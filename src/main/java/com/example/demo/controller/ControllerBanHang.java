package com.example.demo.controller;

import com.example.demo.dto.DonHangDto;
import com.example.demo.dto.SpctDto;
import com.example.demo.entity.*;
import com.example.demo.exception.MessageException;
import com.example.demo.repository.*;
import com.example.demo.service.HoaDonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("ban-hang")
public class ControllerBanHang {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private CTSP_Repository ctsp_repository;
    @Autowired
    private HDfin hoaDonRepo;
    @Autowired
    private KhachHangRepository hangRepository;
    @Autowired
    private HDCT_Repository hdctRepository;
    @Autowired
    private HDCTCus_repo hdctCus_repo;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    List<HoaDon> listHoaDon = new ArrayList<>();

    List<HDCT> listHoaDonChiTiet = new ArrayList<>();

    List<CTSP> listChiTietSanPham = new ArrayList<>();

    Integer idHoaDon;



    @GetMapping("hien-thi")
    public String index(Model model){
        List<HoaDon> ds = this.hoaDonService.getHoaDonsChoThanhToan();
        model.addAttribute("data",ds);
        List<CTSP> dd = this.ctsp_repository.findAll();
        model.addAttribute("dataSP", dd);
//        listHoaDonChiTiet = this.hdctRepository.findAll();
//        model.addAttribute("datahd", listHoaDonChiTiet);
        return "ban_hang/banhang";
    }














    @PostMapping("thd")
    public String thd(RedirectAttributes redirectAttributes) {
        boolean isLimitReached = hoaDonService.thd();

        if (isLimitReached) {
            redirectAttributes.addFlashAttribute("message", "Đã đạt giới hạn 10 hóa đơn chờ thanh toán.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Tạo hóa đơn thành công.");
        }

        return "redirect:/ban-hang/hien-thi";
    }













    @GetMapping("/addGioHang")
    public String showAddGioHangPage(Model model) {
        List<HDCT> ds = this.hdctRepository.findAll();
        model.addAttribute("datahd", ds);
        // Chuẩn bị các dữ liệu ban đầu nếu cần và thêm vào model
        return "addGioHang"; // Trả về trang addGioHang.html (nếu dùng Thymeleaf)
    }

    @PostMapping("/addGioHang")
    public String addGioHang(
            @RequestParam int maHD,
            @RequestParam int maCTSP,
            @RequestParam int soLuongThem,
            @RequestParam float donGia,
            Model model
    ) {
        String result = hoaDonService.addGioHang(maHD, maCTSP, soLuongThem, donGia);
        model.addAttribute("result", result);

        // Có thể cập nhật dữ liệu giỏ hàng, hóa đơn, hoặc thêm dữ liệu khác
        return "redirect:/ban-hang/hien-thi"; // Trả về lại trang addGioHang.html cùng với dữ liệu cập nhật
    }




    @GetMapping("delete/{id}")
    public String  delete(@PathVariable("id") Integer id){
        this.hoaDonRepo.deleteById(id);
        return "redirect:/ban-hang/hien-thi";
    }



    @GetMapping("/tao-don-hang")
    public String taoDonHangView(Model model){
        List<SanPham> ds = this.sanPhamRepository.findByTrangThai("Con hang");
        // Kiểm tra xem danh mục có được gán đúng không
        ds.forEach(sp -> System.out.println(sp.getDanhMuc()));
        model.addAttribute("listSanPham", ds);
        return "/ban_hang/taodonhang";
    }

    @GetMapping("/chi-tiet-san-pham")
    @ResponseBody
    public ResponseEntity<?> chiTietSanPham(@RequestParam Integer sanPhamId){
        List<CTSP> result = ctsp_repository.findBySanPham(sanPhamId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/chi-tiet-san-pham-by-id")
    @ResponseBody
    public ResponseEntity<?> chiTietSanPhamById(@RequestParam Integer id){
        CTSP result = ctsp_repository.findById(id).get();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/tao-don-hang-post")
    @ResponseBody
    public ResponseEntity<String> taoDonHang(@RequestBody DonHangDto donHangDto, HttpSession session) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("nhanVien");

        if (taiKhoan == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Không tìm thấy thông tin tài khoản!");
        }

        // Kiểm tra trùng số điện thoại
        if (hoaDonRepo.existsBySoDienThoai(donHangDto.getSoDienThoai())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Số điện thoại đã tồn tại, vui lòng kiểm tra lại!");
        }

        // Tiếp tục xử lý như cũ
        String username = taiKhoan.getTenDangNhap();
        TaiKhoan taiKhoanFromDb = taiKhoanRepository.findByTenDangNhap(username).orElse(null);
        if (taiKhoanFromDb == null) {
            throw new MessageException("Tài khoản không hợp lệ!");
        }

        Float tongTien = 0F;
        for (SpctDto d : donHangDto.getSpct()) {
            CTSP ctsp = ctsp_repository.findById(d.getIdCtsp()).get();
            if (ctsp.getSoLuong() < d.getQuantity()) {
                throw new MessageException("id CTSP " + ctsp.getId() + " chỉ còn " + ctsp.getSoLuong());
            }
            tongTien += ctsp.getDonGia() * d.getQuantity();
        }

        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayLap(new Date(System.currentTimeMillis()));
        hoaDon.setTrangThaiThanhToan("Da thanh toan");
        hoaDon.setTaiKhoan(taiKhoan);
        hoaDon.setHinhThucThanhToan(donHangDto.getHinhThucThanhToan());
        hoaDon.setTongTien(tongTien);
        hoaDon.setHoTen(donHangDto.getHoTen());
        hoaDon.setSoDienThoai(donHangDto.getSoDienThoai());
        hoaDonRepo.save(hoaDon);

        for (SpctDto d : donHangDto.getSpct()) {
            CTSP ctsp = ctsp_repository.findById(d.getIdCtsp()).get();
            HDCT hdct = new HDCT();
            hdct.setHoaDon(hoaDon);
            hdct.setDonGia(ctsp.getDonGia());
            hdct.setHoaDon_id(hoaDon.getId());
            hdct.setCtsp_id(ctsp.getId());
            hdct.setCtsp(ctsp);
            hdct.setSoLuong(d.getQuantity());
            hdct.setThanhTien(d.getQuantity() * ctsp.getDonGia());
            hdctRepository.save(hdct);
        }

        for (SpctDto d : donHangDto.getSpct()) {
            CTSP ctsp = ctsp_repository.findById(d.getIdCtsp()).get();
            ctsp.setSoLuong(ctsp.getSoLuong() - d.getQuantity());
            ctsp_repository.save(ctsp);
        }

        return ResponseEntity.ok("Thành công!");
    }



}

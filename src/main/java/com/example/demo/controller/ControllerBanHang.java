package com.example.demo.controller;

import com.example.demo.dto.DonHangDto;
import com.example.demo.dto.SpctDto;
import com.example.demo.entity.*;
import com.example.demo.exception.MessageException;
import com.example.demo.repository.*;
import com.example.demo.service.HoaDonService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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




    @GetMapping("/detail/{id}")
    public String showInvoiceDetail(@PathVariable("id") Integer id, Model model) {
        HoaDon hoaDon = hoaDonRepo.findById(id).orElse(null);
        idHoaDon = id;
        if (hoaDon != null) {
            // Gọi phương thức fillHDCT với id và gán vào listHoaDonChiTiet
            listHoaDonChiTiet = hdctRepository.findByHoaDonId(id);
            model.addAttribute("hoaDon", hoaDon);
            model.addAttribute("datahd", listHoaDonChiTiet);  // Truyền danh sách chi tiết hóa đơn vào model
        }

        // Lấy danh sách hóa đơn để giữ lại dữ liệu của bảng phía trên
        listHoaDon = hoaDonService.getHoaDonsChoThanhToan();
        model.addAttribute("listHoaDon", listHoaDon);

        // Lấy lại dữ liệu từ các bảng khác và truyền vào model để không bị mất khi load lại trang
        List<HoaDon> ds = hoaDonService.getHoaDonsChoThanhToan();
        model.addAttribute("data", ds);

        List<CTSP> dd = ctsp_repository.findAll();
        model.addAttribute("dataSP", dd);

        return "ban_hang/banhang";
    }

    @PostMapping("/addhdctt")
    public String addd(@RequestParam("id") Integer id) {
        try {
            // Lấy thông tin sản phẩm (CTSP) từ ID được truyền vào
            CTSP ctsp = this.ctsp_repository.findById(id).orElse(null);

            if (ctsp == null) {
                System.out.println("CTSP không tồn tại.");
                return "ban_hang/banhang";
            }

            // Tạo HDCT mới và thiết lập các thuộc tính
            HDCT hdct = new HDCT();
            HoaDon hoaDon = new HoaDon();
            hoaDon.setId(idHoaDon); // Sử dụng idHoaDon đã được truyền vào
            hdct.setHoaDon(hoaDon);
            hdct.setCtsp(ctsp);
            hdct.setSoLuong(1);
            hdct.setDonGia(ctsp.getDonGia());
            hdct.setThanhTien(ctsp.getDonGia());

            // Lưu HDCT vào cơ sở dữ liệu
            this.hdctRepository.save(hdct);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(id);
            System.out.println(idHoaDon+"=====================================================================================================");
        }

        // Chuyển hướng về trang banhang sau khi thêm mới thành công
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
        List<SanPham> list = sanPhamRepository.findAll();
        model.addAttribute("listSanPham", list);
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
    public void taoDonHang(@RequestBody DonHangDto donHangDto, HttpSession session){
        String username = session.getAttribute("nhanVien").toString();
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(username).get();
        System.out.println("id tai khoan: "+taiKhoan.getId());
        Float tongTien = 0F;
        for(SpctDto d : donHangDto.getSpct()){
            CTSP ctsp = ctsp_repository.findById(d.getIdCtsp()).get();
            if(ctsp.getSoLuong() < d.getQuantity()){
                throw new MessageException("id CTSP"+ctsp.getId()+" chỉ còn "+ctsp.getSoLuong());
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

        for(SpctDto d : donHangDto.getSpct()){
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

        for(SpctDto d : donHangDto.getSpct()){
            CTSP ctsp = ctsp_repository.findById(d.getIdCtsp()).get();
            ctsp.setSoLuong(ctsp.getSoLuong() - d.getQuantity());
            ctsp_repository.save(ctsp);
        }
//        for (SpctDto d : donHangDto.getSpct()){
//            ThanhToan thanhToan = new ThanhToan();
//            HoaDon hoaDon1 = new HoaDon();
//            thanhToan.setHoaDon_id(hoaDon1.getId());
//            thanhToan.setNgayThanhToan(new Date(System.currentTimeMillis()));
//            thanhToan.setSoTien(tongTien);
//            thanhToan.setHinhThucThanhToan(hoaDon1.getHinhThucThanhToan());
//            thanhToan.setTrangThai("Truc tiep");
//
//        }

    }


}

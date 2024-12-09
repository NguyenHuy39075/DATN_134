package com.example.demo.controller;

import com.example.demo.entity.HDCT;
import com.example.demo.entity.HoaDon;
import com.example.demo.repository.HDCT_Repository;
import com.example.demo.repository.HDfin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("hoa-don")
public class ControllerHoaDon {
    @Autowired
    private HDfin hoaDonRepo;

    @Autowired
    private HDCT_Repository hdctRepository;



    @GetMapping("/hien-thi")
    public String viewListDonHang(Model model, @RequestParam(required = false) String trangThai) {
        System.out.println("TrangThai nhận được: " + trangThai); // Debug giá trị
        List<HoaDon> hoaDonList;

        if ("Da thanh toan".equalsIgnoreCase(trangThai != null ? trangThai.trim() : "")) {
            hoaDonList = hoaDonRepo.findByTrangThaiThanhToanOrderByIdDesc("Da thanh toan");
        } else {
            hoaDonList = hoaDonRepo.findAllByOrderByIdDesc();
        }

        // Xác minh danh sách trả về chỉ chứa trạng thái mong muốn
        hoaDonList = hoaDonList.stream()
                .filter(hd -> "Da thanh toan".equalsIgnoreCase(hd.getTrangThaiThanhToan()))
                .collect(Collectors.toList());

        model.addAttribute("listHoaDon", hoaDonList);
        return "/hoa_don/index";
    }





    @GetMapping("/chi-tiet-hoa-don")
    @ResponseBody
    public ResponseEntity<?> chiTietDonHang(@RequestParam Integer hoaDonId){
        List<HDCT> result = hdctRepository.findByHoaDonId(hoaDonId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("doanh-thu")
    public String dt(){

        return "hoa_don/doanhthu";
    }



    @GetMapping("/doanh-thu/ngay")
    public ResponseEntity<?> doanhThuTheoNgay(@RequestParam String ngay) {
        try {
            LocalDate date = LocalDate.parse(ngay); // Định dạng yyyy-MM-dd
            Double doanhThu = hoaDonRepo.tinhDoanhThuTheoNgay(date);
            return new ResponseEntity<>(doanhThu != null ? doanhThu : 0, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ngày không hợp lệ hoặc xảy ra lỗi khi xử lý!", HttpStatus.BAD_REQUEST);
        }
    }

    // Tính doanh thu theo tháng
    @GetMapping("/doanh-thu/thang")
    public ResponseEntity<?> doanhThuTheoThang(@RequestParam int thang, @RequestParam int nam) {
        try {
            Double doanhThu = hoaDonRepo.tinhDoanhThuTheoThang(thang, nam);
            return new ResponseEntity<>(doanhThu != null ? doanhThu : 0, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tháng hoặc năm không hợp lệ!", HttpStatus.BAD_REQUEST);
        }
    }

    // Tính doanh thu theo năm
    @GetMapping("/doanh-thu/nam")
    public ResponseEntity<?> doanhThuTheoNam(@RequestParam int nam) {
        try {
            Double doanhThu = hoaDonRepo.tinhDoanhThuTheoNam(nam);
            return new ResponseEntity<>(doanhThu != null ? doanhThu : 0, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Năm không hợp lệ hoặc xảy ra lỗi khi xử lý!", HttpStatus.BAD_REQUEST);
        }
    }




//    @GetMapping("/hien-thi")
//    public String index(Model model){
//        listHoaDon = hoaDonRepo.findAll();
//        model.addAttribute("listHoaDon", listHoaDon);
//        return "hoa_don/index";
//    }
//    @GetMapping("/detail/{id}")
//    public String indexx(@PathVariable("id") Integer id, Model model) {
//        HoaDon hoaDon = hoaDonRepo.findById(id).orElse(null);
//        if (hoaDon != null) {
//            model.addAttribute("hoaDon", hoaDon);
//        }
//
//        // Lấy danh sách hóa đơn để giữ lại dữ liệu của bảng phía trên
//        listHoaDon = hoaDonRepo.findAll();
//        model.addAttribute("listHoaDon", listHoaDon);
//
//        return "hoa_don/index";
//    }

}

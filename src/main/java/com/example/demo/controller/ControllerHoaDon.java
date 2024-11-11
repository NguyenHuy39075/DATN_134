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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hoa-don")
public class ControllerHoaDon {
    @Autowired
    private HDfin hoaDonRepo;

    @Autowired
    private HDCT_Repository hdctRepository;

    List<HoaDon> listHoaDon = new ArrayList<>();

    @GetMapping("/hien-thi")
    public String viewListDonHang(Model model, @RequestParam(required = false) String trangThai){
        List<HoaDon> hoaDonList = null;
        if(trangThai == null){
            hoaDonList = hoaDonRepo.findAll();
        }
        else{
            hoaDonList = hoaDonRepo.findByTrangThaiThanhToan(trangThai);
        }
        model.addAttribute("listHoaDon", hoaDonList);
        return "/hoa_don/index";
    }

    @GetMapping("/chi-tiet-hoa-don")
    @ResponseBody
    public ResponseEntity<?> chiTietDonHang(@RequestParam Integer hoaDonId){
        List<HDCT> result = hdctRepository.findByHoaDonId(hoaDonId);
        return new ResponseEntity<>(result, HttpStatus.OK);
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

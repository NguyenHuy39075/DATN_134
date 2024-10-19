package com.example.demo.controller;

import com.example.demo.entity.CTSP;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.CTSP_Repository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("ban-hang")
public class ControllerBanHang {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private CTSP_Repository ctsp_repository;


    @GetMapping("hien-thi")
    public String index(Model model){
        List<HoaDon> ds = this.hoaDonRepository.findAll();
        model.addAttribute("data", ds);
        List<CTSP> dd = this.ctsp_repository.findAll();
        model.addAttribute("dataSP", dd);
        return "ban_hang/banhang";
    }






}

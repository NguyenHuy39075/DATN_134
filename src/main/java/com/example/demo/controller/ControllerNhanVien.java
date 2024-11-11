package com.example.demo.controller;

import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class ControllerNhanVien {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @GetMapping("hien-thi")
    public String index(Model model){
        List<TaiKhoan> ls = this.taiKhoanRepository.findAll();
        model.addAttribute("listtk", ls);
        return "nhan_vien/index";
    }
}

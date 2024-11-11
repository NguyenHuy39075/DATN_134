package com.example.demo.controller;

import com.example.demo.entity.CTSP;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.CTSP_Repository;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("san-pham")
public class ControllerQLSP {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private CTSP_Repository ctsp_repository;

    @GetMapping("hien-thi")
    public String index(Model model){
        List<SanPham> ds = this.sanPhamRepository.findAll();
        model.addAttribute("dataSP",ds);
        return "san_pham/index";
    }

    @GetMapping("/ctsp")
    @ResponseBody
    public ResponseEntity<?> index1(@RequestParam Integer idctsp){
        List<CTSP> result = this.ctsp_repository.findBySanPhamId(idctsp);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping("use")
    public String use(){
        return "thong_ke/index";
    }
}

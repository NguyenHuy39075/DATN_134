package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.repository.TaiKhoanRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dang-nhap")
public class UserController {
    @Autowired
    TaiKhoanRepository repo;
    @Autowired
    SanPhamRepository sanPhamRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("NV", new TaiKhoan());
        return "dang_nhap/login";
    }

    @PostMapping("/LoginServlet")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {
        Optional<TaiKhoan> optionalTaiKhoan = repo.findByTenDangNhap(username);
        if (optionalTaiKhoan.isPresent()) {
            TaiKhoan taiKhoan = optionalTaiKhoan.get();
            if (taiKhoan.getMatKhau().equals(password)) {
                session.setAttribute("nhanVien", taiKhoan); // Lưu cả đối tượng TaiKhoan vào session
                return "redirect:/dang-nhap/index";
            }
        }

        model.addAttribute("error", "Invalid username or password");
        return "dang_nhap/login";
    }



    @GetMapping("/index")
    public String home(HttpSession session, Model model) {
        TaiKhoan nhanVien = (TaiKhoan) session.getAttribute("nhanVien");
        if (nhanVien == null) {
            return "redirect:/dang-nhap/login"; // Chuyển hướng về trang đăng nhập nếu chưa đăng nhập
        }
        model.addAttribute("nhanVien", nhanVien); // Truyền đối tượng TaiKhoan vào model
        return "dang_nhap/index"; // Trả về trang index.html nếu đã đăng nhập
    }

    @GetMapping("/hien-thi")
    public String hienThi(HttpSession session, Model model) {
        // Lấy thông tin người dùng từ session
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("nhanVien");
        if (taiKhoan == null || !taiKhoan.getChucVu().equalsIgnoreCase("QL")) {
            return "redirect:/dang-nhap/login"; // Chuyển hướng nếu không phải Quản Lý
        }

        // Nếu là Quản Lý, trả về danh sách nhân viên
        List<TaiKhoan> ls = repo.findAll();
        model.addAttribute("listtk", ls);
        return "nhan_vien/index";
    }






    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/dang-nhap/login";
    }



}

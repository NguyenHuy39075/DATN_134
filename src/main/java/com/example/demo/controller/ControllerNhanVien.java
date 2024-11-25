package com.example.demo.controller;

import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;
import jakarta.persistence.Table;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("nhan-vien")
public class ControllerNhanVien {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @GetMapping("hien-thi")
    public String index(HttpSession session, Model model) {
        List<TaiKhoan> ls = taiKhoanRepository.findAll();
        model.addAttribute("listtk", ls);
        return "nhan_vien/index";
    }

    @GetMapping("/danh-sach-nhan-vien/{id}")
    @ResponseBody
    public ResponseEntity<TaiKhoan> dsmasa(@PathVariable("id") Integer idnv) {
        Optional<TaiKhoan> result = taiKhoanRepository.findByIdTK(idnv);
        return result.map(mauSac -> new ResponseEntity<>(mauSac, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/them-nhan-vien")
    public ResponseEntity<?> themSM(@RequestBody Map<String, Object> payload) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenDangNhap((String) payload.get("tenDangNhap"));
        taiKhoan.setMatKhau((String) payload.get("matKhau"));
        taiKhoan.setChucVu((String) payload.get("chucVu"));
        taiKhoan.setEmail((String) payload.get("email"));
        taiKhoan.setSdt((String) payload.get("sdt"));
        taiKhoan.setNgayTao(LocalDate.parse((String) payload.get("ngayTao")));
        taiKhoan.setTrangThai((String) payload.get("trangThai"));
        taiKhoanRepository.save(taiKhoan);
        return ResponseEntity.ok("Nhân viên đã được thêm thành công!");
    }

    @PutMapping("/cap-nhat-nhan-vien/{id}")
    public ResponseEntity<?> updateSM(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {

        TaiKhoan taiKhoan = taiKhoanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));
        taiKhoan.setTenDangNhap((String) payload.get("tenDangNhap"));
        taiKhoan.setMatKhau((String) payload.get("matKhau"));
        taiKhoan.setChucVu((String) payload.get("chucVu"));
        taiKhoan.setEmail((String) payload.get("email"));
        taiKhoan.setSdt((String) payload.get("sdt"));
        taiKhoan.setNgayTao(LocalDate.parse((String) payload.get("ngayTao")));
        taiKhoan.setTrangThai((String) payload.get("trangThai"));
        taiKhoanRepository.save(taiKhoan);
        return ResponseEntity.ok("Nhân viên đã được cập nhật thành công!");
    }






}

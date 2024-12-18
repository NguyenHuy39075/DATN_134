package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "sanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenSanPham;

    private String maSanPham;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate ngayNhap;


    private String trangThai;


    @ManyToOne
    @JoinColumn(name = "danhMuc_id")
    private DanhMuc danhMuc;



}

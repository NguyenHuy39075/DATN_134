package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "danhMuc")
public class DanhMuc {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenDanhMuc;
    private String moTa;
    private String trangThai;
}

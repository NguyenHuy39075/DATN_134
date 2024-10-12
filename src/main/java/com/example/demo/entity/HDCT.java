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
@Table(name = "hoaDonChiTiet")
public class HDCT {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private int hoaDon_id;
    private int ctsp_id;
    private int soLuong;
    private float donGia;
    private float thanhTien;

}

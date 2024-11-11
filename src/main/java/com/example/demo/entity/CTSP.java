package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "chiTietSanPham")
public class CTSP {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private float donGia;
    private int soLuong;

    private String moTa;
    private String anhSanPham;
    private String maBarcode;
    @ManyToOne
    @JoinColumn(name = "mauSac_id")
    private MauSac mauSac;
    @ManyToOne @JoinColumn(name = "size_id")
    private Size size;
    @ManyToOne @JoinColumn(name = "chatLieu_id")
    private ChatLieu chatLieu;
    @ManyToOne @JoinColumn(name = "sanPham_id")
    private SanPham sanPham;


}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "hoaDon")
public class HoaDon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
//    private int taiKhoan_id;
//    private int kh_id;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Temporal(TemporalType.DATE)
    private Date ngayLap;
    private float tongTien;
    private String trangThaiThanhToan;
    private String hinhThucThanhToan;
    private String hoTen;
    private String soDienThoai;
    private String ghiChu;
    @ManyToOne
    @JoinColumn(name = "taiKhoan_id")
    private TaiKhoan taiKhoan;



    @ManyToOne
    @JoinColumn(name = "kh_id")
    private KhachHang khachHang;
}

package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class SPDto {

    private String tenSanPham;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate ngayNhap;
    private String trangThai;
    private String maSanPham;
    private Integer danhMucId;

}

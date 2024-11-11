package com.example.demo.repository;

import com.example.demo.entity.HDCTCus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HDCTCus_repo extends JpaRepository<HDCTCus, Integer>, CusHDCTREpository {
    @Query(
            value = "SELECT ctsp.id, sp.tenSanPham, ctsp.soLuong, ctsp.donGia, hdct.thanhTien, hd.trangThaiThanhToan " +
                    "FROM hoaDonChiTiet hdct " +
                    "INNER JOIN sanPham sp ON hdct.id = sp.id " +
                    "INNER JOIN chiTietSanPham ctsp ON hdct.ctsp_id = ctsp.id " +
                    "INNER JOIN hoaDon hd ON hdct.hoaDon_id = hd.id " +
                    "WHERE hd.trangThaiThanhToan = 'Cho thanh toan'",
            nativeQuery = true
    )
    List<HDCTCus> fillHDCT();

    @Override
    <S extends HDCTCus> S save(S entity);

    @Query("SELECT c.donGia FROM CTSP c WHERE c.id = :ctspId")
    Double getDonGiaById(@Param("ctspId") int ctspId);


}

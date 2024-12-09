package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HDfin extends JpaRepository<HoaDon, Integer> {


    List<HoaDon> findByTrangThaiThanhToanIn(List<String> trangThaiList);


    List<HoaDon> findByTrangThaiThanhToan(String trangThai);

    List<HoaDon> findAllByOrderByIdDesc();
    List<HoaDon> findByTrangThaiThanhToanOrderByIdDesc(String trangThai);

    @Query("SELECT SUM(hd.tongTien) FROM HoaDon hd WHERE hd.trangThaiThanhToan IN ('Da thanh toan', 'Giao hang thanh cong') AND hd.ngayLap = :ngay")
    Double tinhDoanhThuTheoNgay(@Param("ngay") LocalDate ngay);



    @Query("SELECT SUM(hd.tongTien) FROM HoaDon hd WHERE hd.trangThaiThanhToan IN ('Da thanh toan', 'Giao hang thanh cong') AND FUNCTION('MONTH', hd.ngayLap) = :thang AND FUNCTION('YEAR', hd.ngayLap) = :nam")
    Double tinhDoanhThuTheoThang(@Param("thang") int thang, @Param("nam") int nam);


    @Query("SELECT SUM(hd.tongTien) FROM HoaDon hd WHERE hd.trangThaiThanhToan IN ('Da thanh toan', 'Giao hang thanh cong') AND FUNCTION('YEAR', hd.ngayLap) = :nam")
    Double tinhDoanhThuTheoNam(@Param("nam") int nam);


    boolean existsBySoDienThoai(String soDienThoai);



}

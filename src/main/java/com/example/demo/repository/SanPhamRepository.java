package com.example.demo.repository;

import com.example.demo.entity.CTSP;
import com.example.demo.entity.HDCT;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    @Query("SELECT h FROM SanPham h WHERE h.id = :idsp")
    Optional<SanPham> findByIdSP(@Param("idsp") Integer idsp);

    boolean existsByMaSanPham(String maSanPham);

    List<SanPham> findByTrangThai(String trangThai);

}

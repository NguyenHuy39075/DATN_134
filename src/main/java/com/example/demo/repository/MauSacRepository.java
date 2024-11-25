package com.example.demo.repository;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    Optional<MauSac> findByTenMau(String tenMau);

    @Query("SELECT h FROM MauSac h WHERE h.id = :idms")
    Optional<MauSac> findByIdMauSac(@Param("idms") Integer idms);
}

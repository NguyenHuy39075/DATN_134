package com.example.demo.repository;

import com.example.demo.entity.Size;
import com.example.demo.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    Optional<TaiKhoan> findByTenDangNhap(String tenDangNhap);

    @Query("SELECT h FROM TaiKhoan h WHERE h.id = :idnv")
    Optional<TaiKhoan> findByIdTK(@Param("idnv") Integer idnv);
}

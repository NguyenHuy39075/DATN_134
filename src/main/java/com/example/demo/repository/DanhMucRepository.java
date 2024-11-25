package com.example.demo.repository;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
    Optional<DanhMuc> findByTenDanhMuc(String tenDanhMuc);

    @Query("SELECT h FROM DanhMuc h WHERE h.id = :iddm")
    Optional<DanhMuc> findByIdDm(@Param("iddm") Integer iddm);
}

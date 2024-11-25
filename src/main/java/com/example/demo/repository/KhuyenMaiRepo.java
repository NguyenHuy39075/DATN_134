package com.example.demo.repository;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KhuyenMaiRepo extends JpaRepository<KhuyenMai, Integer> {
    Optional<KhuyenMai> findByTenKhuyenMai(String tenKhuyenMai);
}

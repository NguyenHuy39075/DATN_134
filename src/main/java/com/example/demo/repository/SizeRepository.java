package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SizeRepository extends JpaRepository<Size, Integer> {
    Optional<Size> findByTenSize(String tenSize);

    @Query("SELECT h FROM Size h WHERE h.id = :idkt")
    Optional<Size> findByIdSize(@Param("idkt") Integer idkt);

}

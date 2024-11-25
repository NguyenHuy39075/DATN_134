package com.example.demo.repository;

import com.example.demo.entity.CTSP;
import com.example.demo.entity.HDCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CTSP_Repository extends JpaRepository<CTSP, Integer> {
    @Query("SELECT h FROM CTSP h WHERE h.id = :ctspId")
    List<CTSP> findByctspId(@Param("ctspId") Integer ctspId);


    @Query("SELECT h FROM CTSP h WHERE h.sanPham.id = ?1")
    List<CTSP> findBySanPham(Integer spId);

    @Query("SELECT h FROM CTSP h WHERE h.sanPham.id = :sanPhamId")
    List<CTSP> findBySanPhamId(@Param("sanPhamId") Integer sanPhamId);

    @Query("SELECT h FROM CTSP h WHERE h.sanPham.id = :id")
    Optional<CTSP> findBySPId(@Param("id") Integer id);

}

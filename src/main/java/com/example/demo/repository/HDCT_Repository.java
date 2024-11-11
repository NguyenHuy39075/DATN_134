package com.example.demo.repository;

import com.example.demo.entity.HDCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HDCT_Repository extends JpaRepository<HDCT, Integer> {

        @Query("SELECT h FROM HDCT h WHERE h.hoaDon.id = :hoaDonId")
        List<HDCT> findByHoaDonId(@Param("hoaDonId") Integer hoaDonId);


}

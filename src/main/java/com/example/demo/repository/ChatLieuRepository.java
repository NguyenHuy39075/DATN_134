package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChatLieuRepository extends JpaRepository<ChatLieu, Integer> {
    Optional<ChatLieu> findByTenChatLieu(String tenChatLieu);

    @Query("SELECT h FROM ChatLieu h WHERE h.id = :idct")
    Optional<ChatLieu> findByIdCt(@Param("idct") Integer idct);
}

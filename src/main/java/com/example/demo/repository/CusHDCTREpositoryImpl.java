package com.example.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CusHDCTREpositoryImpl implements CusHDCTREpository{
    @PersistenceContext
    private EntityManager entityManager;

    public boolean inserthdct(int hoaDonId, int ctspId, int soLuong, double donGia, double thanhTien){
        // Kiểm tra số lượng hóa đơn "Chờ thanh toán"
        String countSql = "SELECT COUNT(*) FROM hoaDon WHERE trangThaiThanhToan = 'Cho thanh toan'";
        Number countResult = (Number) entityManager.createNativeQuery(countSql).getSingleResult();
        Long count = countResult.longValue();

        if (count < 50) {
            // Truy vấn dữ liệu từ bảng ctsp
            String ctspSql = "SELECT donGia FROM ctsp WHERE id = :ctspId";
            Number donGiaResult = (Number) entityManager.createNativeQuery(ctspSql)
                    .setParameter("ctspId", ctspId)
                    .getSingleResult();

             donGia = donGiaResult.doubleValue();
             thanhTien = donGia * soLuong;

            // Thêm chi tiết hóa đơn vào bảng hoaDonChiTiet
            String sql = "INSERT INTO hoaDonChiTiet (hoaDon_id, ctsp_id, soLuong, donGia, thanhTien) VALUES (:hoaDonId, :ctspId, :soLuong, :donGia, :thanhTien)";
            entityManager.createNativeQuery(sql)
                    .setParameter("hoaDonId", hoaDonId)
                    .setParameter("ctspId", ctspId)
                    .setParameter("soLuong", soLuong)
                    .setParameter("donGia", donGia)
                    .setParameter("thanhTien", thanhTien)
                    .executeUpdate();

            return false; // Chưa đạt giới hạn
        } else {
            return true; // Đã đạt giới hạn
        }
    }
}



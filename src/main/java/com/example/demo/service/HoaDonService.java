package com.example.demo.service;

import com.example.demo.entity.HDCT;
import com.example.demo.entity.HoaDon;
import com.example.demo.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonService {

    @Autowired
    private CustomHoaDonRepository hoaDonRepository;
    @Autowired
    private HDfin hDfin;
    @Autowired
    private HDCT_Repository hdctRepository;
    @Autowired
    private HDCTCus_repo hdctCus_repo;

    public boolean thd() {
        return hoaDonRepository.insethd();
    }





    public boolean inserthdct(int hoaDonId, int ctspId, int soLuong) {
        // Lấy thông tin đơn giá từ bảng ctsp thông qua một repository hoặc dịch vụ
        double donGia = hdctCus_repo.getDonGiaById(ctspId); // Giả sử bạn có một phương thức như vậy trong ctspRepository

        // Tính thành tiền
        double thanhTien = soLuong * donGia;

        // Gọi phương thức trong repository với đầy đủ các tham số
        return hdctCus_repo.inserthdct(hoaDonId, ctspId, soLuong, donGia, thanhTien);
    }

    public List<HoaDon> getHoaDonsChoThanhToan() {
        return hDfin.findByTrangThaiThanhToan("Cho thanh toan");
    }


    @Transactional
    public String addGioHang(int maHD, int maCTSP, int soLuongThem, float donGia) {
        List<HDCT> listHDCT = hdctRepository.findByHoaDonId(maHD);

        for (HDCT hdct : listHDCT) {
            if (hdct.getCtsp_id() == maCTSP) {
                int soLuongTrung = hdct.getSoLuong() + soLuongThem;
                float thanhTien2 = soLuongTrung * donGia;
                hdct.setSoLuong(soLuongTrung);
                hdct.setDonGia(donGia);
                hdctRepository.save(hdct);
                return "Thành công";
            }
        }

        // Nếu sản phẩm chưa tồn tại trong hóa đơn, thêm sản phẩm mới
        HDCT newHDCT = new HDCT();
        newHDCT.setCtsp_id(maCTSP);
        newHDCT.setHoaDon_id(maHD);
        newHDCT.setSoLuong(soLuongThem);
        newHDCT.setDonGia(donGia);
        hdctRepository.save(newHDCT);

        return "Thành công";
    }



}

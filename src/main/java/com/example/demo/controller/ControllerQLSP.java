package com.example.demo.controller;

import com.example.demo.dto.CTSPDto;
import com.example.demo.dto.SPDto;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("san-pham")
public class ControllerQLSP {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private CTSP_Repository ctsp_repository;
    @Autowired
    private DanhMucRepository  danhMucRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @ModelAttribute("dsMau")
    public List<MauSac> getms(){
        return mauSacRepository.findAll();
    }
    @ModelAttribute("dsSize")
    public List<Size> getsize(){
        return sizeRepository.findAll();
    }
    @ModelAttribute("dsChatLieu")
    public List<ChatLieu> getcl(){
        return chatLieuRepository.findAll();
    }
    @ModelAttribute("dsDanhMuc")
    public List<DanhMuc> gettt(){return danhMucRepository.findAll();}

    @GetMapping("hien-thi")
    public String index(Model model){
        List<SanPham> ds = this.sanPhamRepository.findAll();
        // Kiểm tra xem danh mục có được gán đúng không
        ds.forEach(sp -> System.out.println(sp.getDanhMuc()));
        model.addAttribute("dataSP", ds);
        return "san_pham/index";
    }

    @GetMapping("/check-ma-san-pham")
    @ResponseBody
    public boolean checkMaSanPham(@RequestParam("maSanPham") String maSanPham) {
        return sanPhamRepository.existsByMaSanPham(maSanPham);
    }


    @GetMapping("ds-ctsp/{id}")
    public String iiii(@PathVariable("id") Integer id, Model model){
        List<CTSP> ctsps = this.ctsp_repository.findBySanPhamId(id);
        model.addAttribute("listctsp", ctsps);
        return "san_pham/ctsp";
    }



    @GetMapping("/ctsp-dd")
    @ResponseBody
    public ResponseEntity<?> index22(){
        List<CTSP> result = this.ctsp_repository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/ctsp")
    @ResponseBody
    public ResponseEntity<?> index1(@RequestParam Integer idctsp){
        List<CTSP> result = this.ctsp_repository.findBySanPhamId(idctsp);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/them-ctsp")
    public String themCtsp(@RequestBody CTSPDto ctspDto) {
        try {
            CTSP ctsp = new CTSP();
            SanPham sanPham = sanPhamRepository.findById(ctspDto.getSanPhamId())
                    .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại!"));

            MauSac mauSac = mauSacRepository.findById(ctspDto.getMauSacId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy màu sắc với ID: " + ctspDto.getMauSacId()));
            Size size = sizeRepository.findById(ctspDto.getSizeId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kích thước với ID: " + ctspDto.getSizeId()));
            ChatLieu chatLieu = chatLieuRepository.findById(ctspDto.getChatLieuId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy chất liệu với ID: " + ctspDto.getChatLieuId()));

            ctsp.setSanPham(sanPham);
            ctsp.setMauSac(mauSac);
            ctsp.setSize(size);
            ctsp.setChatLieu(chatLieu);
            ctsp.setSoLuong(ctspDto.getSoLuong());
            ctsp.setDonGia(ctspDto.getDonGia());
            ctsp.setMoTa(ctspDto.getMoTa());
            ctsp.setAnhSanPham(ctspDto.getAnhSanPham());

            ctsp_repository.save(ctsp);
            return "san_pham/ctsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "san_pham/ctsp?error=true";
        }
    }







    @PostMapping("/them-san-pham")
    public String themSanPham(@RequestBody SPDto spDto, RedirectAttributes redirectAttributes) {
        try {
            SanPham sanPham = new SanPham();

            DanhMuc danhMuc = danhMucRepository.findById(spDto.getDanhMucId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy danh mục với ID: " + spDto.getDanhMucId()));

            sanPham.setDanhMuc(danhMuc);
            sanPham.setMaSanPham(spDto.getMaSanPham());
            sanPham.setTenSanPham(spDto.getTenSanPham());
            sanPham.setNgayNhap(spDto.getNgayNhap());
            sanPham.setTrangThai(spDto.getTrangThai());


            sanPhamRepository.save(sanPham);
            redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
            return "redirect:/san-pham/hien-thi";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/san-pham/hien-thi";
        }
    }


    @GetMapping("/danh-sach-san-pham/{id}")
    @ResponseBody
    public ResponseEntity<SanPham> dssan(@PathVariable("id") Integer idsp) {
        Optional<SanPham> result = sanPhamRepository.findByIdSP(idsp);
        return result.map(sanPham -> new ResponseEntity<>(sanPham, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/danh-sach-ctsp/{id}")
    @ResponseBody
    public ResponseEntity<CTSP> dsctsp(@PathVariable("id") Integer idctsp) {
        Optional<CTSP> result = ctsp_repository.findById(idctsp);
        return result.map(ctsp -> new ResponseEntity<>(ctsp, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PutMapping("/cap-nhat-san-pham/{id}")
    public ResponseEntity<?> updateSanPham(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {
        // Tìm sản phẩm cần cập nhật dựa trên ID
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));

        // Cập nhật các trường của sản phẩm
        sanPham.setMaSanPham((String) payload.get("maSanPham"));
        sanPham.setTenSanPham((String) payload.get("tenSanPham"));

        // Cập nhật trường ngày nhập, kiểm tra lỗi định dạng
        try {
            sanPham.setNgayNhap(LocalDate.parse((String) payload.get("ngayNhap")));
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Định dạng ngày nhập không hợp lệ");
        }

        // Kiểm tra và cập nhật danh mục
        Object danhMucObj = payload.get("danhMucId");
        if (danhMucObj == null || danhMucObj.toString().isEmpty()) {
            return ResponseEntity.badRequest().body("Danh mục không được để trống");
        }

        Integer danhMucId;
        try {
            danhMucId = Integer.parseInt(danhMucObj.toString());
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("ID danh mục không hợp lệ");
        }

        DanhMuc danhMuc = danhMucRepository.findById(danhMucId)
                .orElseThrow(() -> new RuntimeException("Danh mục không tồn tại"));
        sanPham.setDanhMuc(danhMuc);

        // Cập nhật trạng thái
        sanPham.setTrangThai((String) payload.get("trangThai"));

        // Lưu sản phẩm đã cập nhật vào cơ sở dữ liệu
        sanPhamRepository.save(sanPham);

        return ResponseEntity.ok("Sản phẩm đã được cập nhật thành công!");
    }



    @PutMapping("/cap-nhat-ctsp/{id}")
    public ResponseEntity<?> updateCTSP(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {
        // Tìm sản phẩm cần cập nhật dựa trên ID
        CTSP ctsp = ctsp_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));

        // Cập nhật các trường của sản phẩm với dữ liệu từ payload
        ctsp.setSoLuong(Integer.parseInt((String)payload.get("soLuong")));
        ctsp.setDonGia(Float.parseFloat((String)payload.get("donGia")));
        ctsp.setAnhSanPham((String) payload.get("anhSanPham"));
        ctsp.setMoTa((String) payload.get("moTa"));

        Integer mauSacId = Integer.parseInt((String) payload.get("mauSac"));
        MauSac mauSac = mauSacRepository.findById(mauSacId)
                .orElseThrow(() -> new RuntimeException("Màu sắc không tồn tại"));
        ctsp.setMauSac(mauSac);

        Integer sizeId = Integer.parseInt((String) payload.get("size"));
        Size size = sizeRepository.findById(sizeId)
                .orElseThrow(() -> new RuntimeException("Size không tồn tại"));
        ctsp.setSize(size);

        Integer chatLieuId = Integer.parseInt((String) payload.get("chatLieu"));
        ChatLieu chatLieu = chatLieuRepository.findById(chatLieuId)
                .orElseThrow(() -> new RuntimeException("Chất liệu không tồn tại"));
        ctsp.setChatLieu(chatLieu);



        // Lưu sản phẩm đã cập nhật vào cơ sở dữ liệu
        ctsp_repository.save(ctsp);

        return ResponseEntity.ok("Sản phẩm đã được cập nhật thành công!");
    }

    @GetMapping("mau-sac")
    public String mausac(Model model){
        List<MauSac> ds = this.mauSacRepository.findAll();
        model.addAttribute("listms",ds);
        return "san_pham/mausac";
    }
    @GetMapping("/danh-sach-mau-sac/{id}")
    @ResponseBody
    public ResponseEntity<MauSac> dsmasa(@PathVariable("id") Integer idms) {
        Optional<MauSac> result = mauSacRepository.findByIdMauSac(idms);
        return result.map(mauSac -> new ResponseEntity<>(mauSac, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/them-mau-sac")
    public ResponseEntity<?> themSM(@RequestBody Map<String, Object> payload) {
        MauSac mauSac = new MauSac();
        mauSac.setTenMau((String) payload.get("tenMau"));
        mauSac.setMoTa((String) payload.get("moTa"));
        mauSacRepository.save(mauSac);
        return ResponseEntity.ok("Màu sắc đã được thêm thành công!");
    }

    @PutMapping("/cap-nhat-mau-sac/{id}")
    public ResponseEntity<?> updateSM(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {

        MauSac mauSac = mauSacRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MS không tồn tại"));
        mauSac.setTenMau((String) payload.get("tenMau"));
        mauSac.setMoTa((String) payload.get("moTa"));
        mauSacRepository.save(mauSac);
        return ResponseEntity.ok("Màu sắc đã được cập nhật thành công!");
    }



    @GetMapping("kich-thuoc")
    public String size(Model model){
        List<Size> ds = this.sizeRepository.findAll();
        model.addAttribute("listsize",ds);
        return "san_pham/size";
    }

    @GetMapping("/danh-sach-kich-thuoc/{id}")
    @ResponseBody
    public ResponseEntity<Size> dsmasaky(@PathVariable("id") Integer idkt) {
        Optional<Size> result = sizeRepository.findByIdSize(idkt);
        return result.map(mauSac -> new ResponseEntity<>(mauSac, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/them-kich-thuoc")
    public ResponseEntity<?> themKT(@RequestBody Map<String, Object> payload) {
        Size size = new Size();
        size.setTenSize((String) payload.get("tenSize"));
        size.setMoTa((String) payload.get("moTa"));
        sizeRepository.save(size);
        return ResponseEntity.ok("Size đã được thêm thành công!");
    }

    @PutMapping("/cap-nhat-kich-thuoc/{id}")
    public ResponseEntity<?> updatekt(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {

        Size size = sizeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Size không tồn tại"));
        size.setTenSize((String) payload.get("tenSize"));
        size.setMoTa((String) payload.get("moTa"));
        sizeRepository.save(size);
        return ResponseEntity.ok("Size đã được cập nhật thành công!");
    }

    @GetMapping("chat-lieu")
    public String chatlieu(Model model){
        List<ChatLieu> ds = this.chatLieuRepository.findAll();
        model.addAttribute("listct",ds);
        return "san_pham/chatlieu";
    }

    @GetMapping("/danh-sach-chat-lieu/{id}")
    @ResponseBody
    public ResponseEntity<ChatLieu> dsmasaaa(@PathVariable("id") Integer idct) {
        Optional<ChatLieu> result = chatLieuRepository.findByIdCt(idct);
        return result.map(mauSac -> new ResponseEntity<>(mauSac, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/them-chat-lieu")
    public ResponseEntity<?> themScM(@RequestBody Map<String, Object> payload) {
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setTenChatLieu((String) payload.get("tenChatLieu"));
        chatLieu.setMoTa((String) payload.get("moTa"));
        chatLieuRepository.save(chatLieu);
        return ResponseEntity.ok("Chất liệu đã được thêm thành công!");
    }

    @PutMapping("/cap-nhat-chat-lieu/{id}")
    public ResponseEntity<?> updateSaM(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {

        ChatLieu chatLieu = chatLieuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chất liệu không tồn tại"));
        chatLieu.setTenChatLieu((String) payload.get("tenChatLieu"));
        chatLieu.setMoTa((String) payload.get("moTa"));
        chatLieuRepository.save(chatLieu);
        return ResponseEntity.ok("Chất liệu đã được cập nhật thành công!");
    }

    @GetMapping("danh-muc")
    public String listddh(Model model){
        List<DanhMuc> ds = this.danhMucRepository.findAll();
        model.addAttribute("listdm", ds);
        return "san_pham/danhmuc";
    }

    @GetMapping("/danh-sach-danh-muc/{id}")
    @ResponseBody
    public ResponseEntity<DanhMuc> dsmasasss(@PathVariable("id") Integer iddm) {
        Optional<DanhMuc> result = danhMucRepository.findByIdDm(iddm);
        return result.map(danhMuc -> new ResponseEntity<>(danhMuc, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/them-danh-muc")
    public ResponseEntity<?> themdm(@RequestBody Map<String, Object> payload) {
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setTenDanhMuc((String) payload.get("tenDanhMuc"));
        danhMuc.setMoTa((String) payload.get("moTa"));
        danhMucRepository.save(danhMuc);
        return ResponseEntity.ok("Danh muc đã được thêm thành công!");
    }

    @PutMapping("/cap-nhat-danh-muc/{id}")
    public ResponseEntity<?> updateDM(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {

        DanhMuc danhMuc = danhMucRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Danh muc không tồn tại"));
        danhMuc.setTenDanhMuc((String) payload.get("tenDanhMuc"));
        danhMuc.setMoTa((String) payload.get("moTa"));
        danhMucRepository.save(danhMuc);
        return ResponseEntity.ok("Danh muc đã được thêm thành công!");
    }




}

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="mb-auto mt-5">
    <h2>Thong tin hoa don</h2>
    <form action="/ban-hang/detail/${hoaDon.id}">
        <div class="form-group mt-3">
            <label class="form-label">Ma hoa don:</label>
            <input class="form-control" placeholder="" value="${hoaDon.id}">
        </div>
        <div class="form-group mt-3">
            <label class="form-label">Ngay tao:</label>
            <input class="form-control" placeholder="" value="${hoaDon.ngayLap}">
        </div>
        <div class="form-group mt-3">
            <label class="form-label">Ten nhan vien:</label>
            <input class="form-control" placeholder="" value="${hoaDon.taiKhoan.tenDangNhap}">
        </div>
        <div class="form-group mt-3">
            <label class="form-label">Ten khach hang:</label>
            <input class="form-control" placeholder="" ng-model="xacNhanDonHang.soDienThoai">
        </div>
        <div class="form-group mt-3">
            <label class="form-label">So dien thoai:</label>
            <input class="form-control" placeholder="" ng-model="xacNhanDonHang.soDienThoai">
        </div>

        <div class="form-group mt-3">
            <label class="form-label">Ma giam gia:</label>
            <select class="custom-select">
                <option>-----Ma giam gia-----</option>
                <option>10k</option>
                <option>15k</option>
            </select>
        </div>
        <div>
            <h5 class="mt-3">Tong cong: <span class="text-danger"></span></h5>
        </div>
        <div class="form-group mt-3">
            <label class="form-label">Tien khach dua:</label>
            <input class="form-control" placeholder="" ng-model="xacNhanDonHang.gmail">
        </div>
        <div class="form-group mt-3">
            <label class="form-label">Tien thua:</label>
            <input class="form-control" placeholder="" ng-model="xacNhanDonHang.gmail">
        </div>
    </form>

</div>

<br>
</div>
<div>
    <h3>Hinh thuc thanh toan:</h3>
    <select name="" class="custom-select custom-select-lg">
        <option name="">Tien mat</option>
        <option name="">Chuyen khoan</option>
        <option name="">Tien mat + chuyen khoan</option>
    </select>
</div>

<!-- Nút Xác nhận đơn hàng -->
<div class="row mt-4 mb-3">
    <div class="col-md-6 offset-md-6">
        <button type="button" class="btn btn-primary btn-block">Xác nhận đơn hàng</button>
    </div>
</div>


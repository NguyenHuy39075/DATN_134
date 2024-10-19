<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div ng-controller="adminCtrl" style="background-color: rgb(37, 244, 5)">
    <!-- Khu vuc header -->
    <!-- Copy noi dung navbar vua demo la duoc -->
    <!-- bo sung them shadow -->
    <nav class="navbar navbar-expand-sm bg-light shadow">
        <div class="container-fluid">
            <!-- logo -->
            <a href="#">
                <img src="https://t3.ftcdn.net/jpg/04/86/45/16/360_F_486451692_j8hWh9dz9PxVovYGX5n0Sgx8jzONjDBD.jpg" alt="" style="max-height: 80px;">
            </a>
            <!-- Thong tin user -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link disabled text-dark" href="#">HELLO</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled text-dark" href="#">Loguot</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- Khu vuc noi dung gom 2 phan -->
    <!-- 1.Menu (nav) | Nam ben trai|do rong khoang 250px -->
    <!-- 2.Noi dung chinh cua trang| nam ben phai | do rong la phan con lai width: cacl(100%) -->
    <!-- 3. Them class .d-flex o the div cha de noi dung co len 1 dong -->
    <!-- 4.Su li chieu cao cua menu (nav) | set css. min-height: cacl(100vh - xxpx) -->
    <div class="d-flex">
        <div class="bg-light pt-3" style="width: 250px; min-height: calc(100vh - 66px);">
            <ul class="nav flex-column ">
                <li class="nav-item">
                    <a class="nav-link " href="qlsp">Quan Ly San Pham</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#!tao-moi-san-pham">Ban Hang</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#!danh-sach-danh-muc">Quan Ly Nhan Vien</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#!tao-moi-danh-muc">Quan Ly Thong Ke</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="#">Quan Ly Khuyen Mai</a>
                </li>
            </ul>
        </div>

        <!-- Khu vuc noi dung chinh -->

        <!-- Khu vuc noi dung chinh -->
        <div class="pt-3" style="width: calc(100% - 250px);">
            <div class="container">


                <form action="">
                    <h3>Hoa Don</h3>
                    <td style="display: flex; justify-content: right;">
                        <button class="btn btn-primary btn-sm">Tao hoa don</button>
                    </td>

                    <div>
                        <table class="table table-bordered table-hover table-striped mt-5">
                            <thead>
                            <tr>
                                <th>Ma</th>
                                <th>Ngay Tao</th>
                                <th>Ten Nhan Vien</th>
                                <th>Trang Thai</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${data}" var="hd">
                                <tr>
                                    <td>${hd.id}</td>
                                    <td>${hd.ngayLap}</td>
                                    <td>${hd.taiKhoan.tenDangNhap}</td>
                                    <td>${hd.trangThaiThanhToan}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <!-- Khu vực phân trang -->
                    </div>
                </form>


                <form action="">
                    <h3>Gio Hang - Hoa Don</h3>


                    <div>
                        <table class="table table-bordered table-hover table-striped mt-5">
                            <thead>
                            <tr>
                                <th>Ma CTSP</th>
                                <th>Ten San Pham</th>
                                <th>So Luong</th>
                                <th>Don Gia</th>
                                <th>Thanh Tien</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>

                        <!-- Khu vực phân trang -->
                    </div>
                </form>



                <form action="">
                    <h3>San Pham</h3>

                    <div>
                        <table class="table table-bordered table-hover table-striped mt-5">
                            <thead>
                            <tr>
                                <th>Ma CTSP</th>
                                <th>Ten San Pham</th>
                                <th>So Luong</th>
                                <th>Mau Sac</th>
                                <th>Size</th>
                                <th>Chat Lieu</th>
                                <th>Don Gia</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${dataSP}" var="sp">
                            <tr>
                                <td>${sp.id}</td>
                                <td>${sp.sanPham.tenSanPham}</td>
                                <td>${sp.soLuong}</td>
                                <td>${sp.mauSac.tenMau}</td>
                                <td>${sp.size.tenSize}</td>
                                <td>${sp.chatLieu.tenChatLieu}</td>
                                <td>${sp.donGia}</td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <!-- Khu vực phân trang -->
                    </div>
                </form>



                <div class="row mt-4 mb-3">
                    <div class="col-md-6 offset-md-6">
                        <button type="button" class="btn btn-danger btn-block"><a style="color: #f7f7f7" href="/ban-hang/tt">Thanh toan</a></button>
                    </div>
                </div>











                </div>
        </div>
    </div>
</div>


</div>
</body>
</html>

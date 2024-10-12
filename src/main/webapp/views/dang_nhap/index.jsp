<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>

<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Danh mục sản phẩm</title>--%>

<%--    <!-- Nhúng Bootstrap -->--%>
<%--    <link rel="stylesheet" href="lib/bootstrap.css">--%>
<%--    <script src="lib/bootstrap.js"></script>--%>

<%--    <!-- Nhúng Font Icon -->--%>
<%--    <!-- <script src="lib/font-fontawesome-ae333ffef2.js"></script> -->--%>

<%--    <!-- Nhúng AngularJS -->--%>
<%--    <!-- <script src="lib/angular.js"></script> -->--%>
<%--    <!-- <script src="lib/angular-route.js"></script> -->--%>
<%--    <style>--%>
<%--        /* Căn giữa nội dung trong thẻ th và td */--%>
<%--        th,--%>
<%--        td {--%>
<%--            text-align: center;--%>
<%--            vertical-align: middle;--%>
<%--        }--%>

<%--        #khunganh {--%>
<%--            display: flex;--%>
<%--            justify-content: center;--%>
<%--            align-items: center;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>

<%--<body>--%>
<%--<!-- Khu vuc header -->--%>
<%--<!-- Copy noi dung navbar vua demo la duoc -->--%>
<%--<!-- bo sung them shadow -->--%>
<%--<nav class="navbar navbar-expand-sm bg-light shadow">--%>
<%--    <div class="container-fluid">--%>
<%--        <!-- logo -->--%>
<%--        <a href="#">--%>
<%--            <img src="https://t3.ftcdn.net/jpg/04/86/45/16/360_F_486451692_j8hWh9dz9PxVovYGX5n0Sgx8jzONjDBD.jpg" alt="" style="max-height: 80px;">--%>
<%--        </a>--%>
<%--        <!-- Thong tin user -->--%>
<%--        <ul class="navbar-nav">--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link disabled text-dark" href="#">Xin chao Van Thanh</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link disabled text-dark" href="#">Dang xuat</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</nav>--%>
<%--<!-- Khu vuc noi dung gom 2 phan -->--%>
<%--<!-- 1.Menu (nav) | Nam ben trai|do rong khoang 250px -->--%>
<%--<!-- 2.Noi dung chinh cua trang| nam ben phai | do rong la phan con lai width: cacl(100%) -->--%>
<%--<!-- 3. Them class .d-flex o the div cha de noi dung co len 1 dong -->--%>
<%--<!-- 4.Su li chieu cao cua menu (nav) | set css. min-height: cacl(100vh - xxpx) -->--%>
<%--<div class="d-flex">--%>
<%--    <div class="bg-light pt-3" style="width: 250px; min-height: calc(100vh - 66px);">--%>
<%--        <ul class="nav flex-column nav-pills">--%>
<%--            <li class="nav-item ">--%>
<%--                <a class="nav-link active" data-bs-toggle="pill" href="#">Danh sách sản phẩm</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" data-bs-toggle="pill" href="#">Tạo mới sản phẩm</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" data-bs-toggle="pill" href="#">Danh sách danh mục</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link " data-bs-toggle="pill" href="#">Tạo mới danh mục</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link " data-bs-toggle="pill" href="#">Danh sách đơn hàng</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>

<%--    <!-- Khu vuc noi dung chinh -->--%>
<%--    <div class="pt-3" style="width: calc(100% - 250px);">--%>
<%--        <div class="container">--%>
<%--            <h3>Danh mục sản phẩm</h3>--%>

<%--            <form action="">--%>
<%--                <div>--%>
<%--                    <table class="table table-bordered table-hover table-striped mt-5">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th>ID</th>--%>
<%--                            <th>Ảnh</th>--%>
<%--                            <th>Tên danh mục</th>--%>
<%--                            <th>Tương tác</th>--%>
<%--                        </tr>--%>
<%--                        </thead>--%>

<%--                        <tbody>--%>
<%--                        <tr>--%>
<%--                            <td>DM001</td>--%>
<%--                            <td style="display: flex; justify-content: center; align-items: center;">--%>
<%--                                <!-- Khai báo thẻ div kiểm soát khung của ảnh -->--%>
<%--                                <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"--%>
<%--                                     style="width: 80px; height: 80px;">--%>
<%--                                    <img src="img/danh_muc_meotamthe.jpg" class="mw-100 mh-100">--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Danh mục Mèo tam thể</td>--%>

<%--                            <th style="width: 1px;" class="text-nowrap">--%>
<%--                                <button class="btn btn-primary btn-sm">Xem</button>--%>
<%--                                <button class="btn btn-warning btn-sm">Sửa</button>--%>
<%--                                <button class="btn btn-danger btn-sm">Xoá</button>--%>
<%--                            </th>--%>
<%--                        </tr>--%>


<%--                        <tr>--%>
<%--                            <td>DM002</td>--%>
<%--                            <td id="khunganh">--%>
<%--                                <!-- Khai báo thẻ div kiểm soát khung của ảnh -->--%>
<%--                                <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"--%>
<%--                                     style="width: 80px; height: 80px;">--%>
<%--                                    <img src="img/danh_muc_meomuop.jpg" class="mw-100 mh-100">--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Danh mục mèo mướp</td>--%>

<%--                            <th>--%>
<%--                                <button class="btn btn-primary btn-sm">Xem</button>--%>
<%--                                <button class="btn btn-warning btn-sm">Sửa</button>--%>
<%--                                <button class="btn btn-danger btn-sm">Xoá</button>--%>
<%--                            </th>--%>
<%--                        </tr>--%>

<%--                        <tr>--%>
<%--                            <td>DM003</td>--%>
<%--                            <td id="khunganh">--%>
<%--                                <!-- Khai báo thẻ div kiểm soát khung của ảnh -->--%>
<%--                                <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"--%>
<%--                                     style="width: 80px; height: 80px;">--%>
<%--                                    <img src="img/danh_muc_meoDomestic Shorthair.jpg" class="mw-100 mh-100">--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Mèo Domestic Shorthair</td>--%>

<%--                            <th>--%>
<%--                                <button class="btn btn-primary btn-sm">Xem</button>--%>
<%--                                <button class="btn btn-warning btn-sm">Sửa</button>--%>
<%--                                <button class="btn btn-danger btn-sm">Xoá</button>--%>
<%--                            </th>--%>
<%--                        </tr>--%>

<%--                        <tr>--%>
<%--                            <td>DM004</td>--%>
<%--                            <td id="khunganh">--%>
<%--                                <!-- Khai báo thẻ div kiểm soát khung của ảnh -->--%>
<%--                                <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"--%>
<%--                                     style="width: 80px; height: 80px;">--%>
<%--                                    <img src="img/danh_muc_meoBritish Shorthair.jpg" class="mw-100 mh-100">--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Mèo British Shorthair</td>--%>

<%--                            <th>--%>
<%--                                <button class="btn btn-primary btn-sm">Xem</button>--%>
<%--                                <button class="btn btn-warning btn-sm">Sửa</button>--%>
<%--                                <button class="btn btn-danger btn-sm">Xoá</button>--%>
<%--                            </th>--%>
<%--                        </tr>--%>

<%--                        <tr>--%>
<%--                            <td>DM005</td>--%>
<%--                            <td id="khunganh">--%>
<%--                                <!-- Khai báo thẻ div kiểm soát khung của ảnh -->--%>
<%--                                <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"--%>
<%--                                     style="width: 80px; height: 80px;">--%>
<%--                                    <img src="img/danh_muc_meoSiamese.jpg" class="mw-100 mh-100">--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Mèo Siamese</td>--%>

<%--                            <th>--%>
<%--                                <button class="btn btn-primary btn-sm">Xem</button>--%>
<%--                                <button class="btn btn-warning btn-sm">Sửa</button>--%>
<%--                                <button class="btn btn-danger btn-sm">Xoá</button>--%>
<%--                            </th>--%>
<%--                        </tr>--%>

<%--                        <tr>--%>
<%--                            <td>DM006</td>--%>
<%--                            <td id="khunganh">--%>
<%--                                <!-- Khai báo thẻ div kiểm soát khung của ảnh -->--%>
<%--                                <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"--%>
<%--                                     style="width: 80px; height: 80px;">--%>
<%--                                    <img src="img/danh_muc_meoBurmese.jpg" class="mw-100 mh-100">--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Mèo Burmese</td>--%>

<%--                            <th>--%>
<%--                                <button class="btn btn-primary btn-sm">Xem</button>--%>
<%--                                <button class="btn btn-warning btn-sm">Sửa</button>--%>
<%--                                <button class="btn btn-danger btn-sm">Xoá</button>--%>
<%--                            </th>--%>
<%--                        </tr>--%>

<%--                        <tr>--%>
<%--                            <td>DM007</td>--%>
<%--                            <td id="khunganh">--%>
<%--                                <!-- Khai báo thẻ div kiểm soát khung của ảnh -->--%>
<%--                                <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"--%>
<%--                                     style="width: 80px; height: 80px;">--%>
<%--                                    <img src="img/danh_muc_meoJapanese Bobtail.jpg" class="mw-100 mh-100">--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Mèo Japanese Bobtail</td>--%>

<%--                            <th>--%>
<%--                                <button class="btn btn-primary btn-sm">Xem</button>--%>
<%--                                <button class="btn btn-warning btn-sm">Sửa</button>--%>
<%--                                <button class="btn btn-danger btn-sm">Xoá</button>--%>
<%--                            </th>--%>
<%--                        </tr>--%>

<%--                        <tr>--%>
<%--                            <td>DM008</td>--%>
<%--                            <td id="khunganh">--%>
<%--                                <!-- Khai báo thẻ div kiểm soát khung của ảnh -->--%>
<%--                                <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"--%>
<%--                                     style="width: 80px; height: 80px;">--%>
<%--                                    <img src="img/danh_muc_meoSingapura.jpg" class="mw-100 mh-100">--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Mèo Singapura</td>--%>

<%--                            <th>--%>
<%--                                <button class="btn btn-primary btn-sm">Xem</button>--%>
<%--                                <button class="btn btn-warning btn-sm">Sửa</button>--%>
<%--                                <button class="btn btn-danger btn-sm">Xoá</button>--%>
<%--                            </th>--%>
<%--                        </tr>--%>
<%--                        </tbody>--%>
<%--                    </table>--%>

<%--                    <!-- Khu vực phân trang -->--%>
<%--                </div>--%>
<%--                <div class="d-flex justify-content-center " style="margin-top: 30px;">--%>
<%--                    <ul class="pagination">--%>
<%--                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="#">Next</a></li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--            </form>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</body>--%>

<%--</html>--%>













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
<body ng-app="myApp">
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
                    <a class="nav-link disabled text-dark" href="#">HELLO ${nhanVien}</a>
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
                    <a class="nav-link" href="/ban-hang/hien-thi">Ban Hang</a>
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
                <h3>Quan Ly San Pham</h3>

                <form action="">
                    <div>
                        <table class="table table-bordered table-hover table-striped mt-5">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Ảnh</th>
                                <th>Tên danh mục</th>
                                <th>Tương tác</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td>DM001</td>
                                <td style="display: flex; justify-content: center; align-items: center;">
                                    <!-- Khai báo thẻ div kiểm soát khung của ảnh -->
                                    <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"
                                         style="width: 80px; height: 80px;">
                                        <img src="img/danh_muc_meotamthe.jpg" class="mw-100 mh-100">
                                    </div>
                                </td>
                                <td>Danh mục Mèo tam thể</td>

                                <th style="width: 1px;" class="text-nowrap">
                                    <button class="btn btn-primary btn-sm">Xem</button>
                                    <button class="btn btn-warning btn-sm">Sửa</button>
                                    <button class="btn btn-danger btn-sm">Xoá</button>
                                </th>
                            </tr>


                            <tr>
                                <td>DM002</td>
                                <td id="khunganh">
                                    <!-- Khai báo thẻ div kiểm soát khung của ảnh -->
                                    <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"
                                         style="width: 80px; height: 80px;">
                                        <img src="img/danh_muc_meomuop.jpg" class="mw-100 mh-100">
                                    </div>
                                </td>
                                <td>Danh mục mèo mướp</td>

                                <th>
                                    <button class="btn btn-primary btn-sm">Xem</button>
                                    <button class="btn btn-warning btn-sm">Sửa</button>
                                    <button class="btn btn-danger btn-sm">Xoá</button>
                                </th>
                            </tr>

                            <tr>
                                <td>DM003</td>
                                <td id="khunganh">
                                    <!-- Khai báo thẻ div kiểm soát khung của ảnh -->
                                    <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"
                                         style="width: 80px; height: 80px;">
                                        <img src="img/danh_muc_meoDomestic Shorthair.jpg" class="mw-100 mh-100">
                                    </div>
                                </td>
                                <td>Mèo Domestic Shorthair</td>

                                <th>
                                    <button class="btn btn-primary btn-sm">Xem</button>
                                    <button class="btn btn-warning btn-sm">Sửa</button>
                                    <button class="btn btn-danger btn-sm">Xoá</button>
                                </th>
                            </tr>

                            <tr>
                                <td>DM004</td>
                                <td id="khunganh">
                                    <!-- Khai báo thẻ div kiểm soát khung của ảnh -->
                                    <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"
                                         style="width: 80px; height: 80px;">
                                        <img src="img/danh_muc_meoBritish Shorthair.jpg" class="mw-100 mh-100">
                                    </div>
                                </td>
                                <td>Mèo British Shorthair</td>

                                <th>
                                    <button class="btn btn-primary btn-sm">Xem</button>
                                    <button class="btn btn-warning btn-sm">Sửa</button>
                                    <button class="btn btn-danger btn-sm">Xoá</button>
                                </th>
                            </tr>

                            <tr>
                                <td>DM005</td>
                                <td id="khunganh">
                                    <!-- Khai báo thẻ div kiểm soát khung của ảnh -->
                                    <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"
                                         style="width: 80px; height: 80px;">
                                        <img src="img/danh_muc_meoSiamese.jpg" class="mw-100 mh-100">
                                    </div>
                                </td>
                                <td>Mèo Siamese</td>

                                <th>
                                    <button class="btn btn-primary btn-sm">Xem</button>
                                    <button class="btn btn-warning btn-sm">Sửa</button>
                                    <button class="btn btn-danger btn-sm">Xoá</button>
                                </th>
                            </tr>

                            <tr>
                                <td>DM006</td>
                                <td id="khunganh">
                                    <!-- Khai báo thẻ div kiểm soát khung của ảnh -->
                                    <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"
                                         style="width: 80px; height: 80px;">
                                        <img src="img/danh_muc_meoBurmese.jpg" class="mw-100 mh-100">
                                    </div>
                                </td>
                                <td>Mèo Burmese</td>

                                <th>
                                    <button class="btn btn-primary btn-sm">Xem</button>
                                    <button class="btn btn-warning btn-sm">Sửa</button>
                                    <button class="btn btn-danger btn-sm">Xoá</button>
                                </th>
                            </tr>

                            <tr>
                                <td>DM007</td>
                                <td id="khunganh">
                                    <!-- Khai báo thẻ div kiểm soát khung của ảnh -->
                                    <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"
                                         style="width: 80px; height: 80px;">
                                        <img src="img/danh_muc_meoJapanese Bobtail.jpg" class="mw-100 mh-100">
                                    </div>
                                </td>
                                <td>Mèo Japanese Bobtail</td>

                                <th>
                                    <button class="btn btn-primary btn-sm">Xem</button>
                                    <button class="btn btn-warning btn-sm">Sửa</button>
                                    <button class="btn btn-danger btn-sm">Xoá</button>
                                </th>
                            </tr>

                            <tr>
                                <td>DM008</td>
                                <td id="khunganh">
                                    <!-- Khai báo thẻ div kiểm soát khung của ảnh -->
                                    <div class="bg-light rounded border overflow-hidden d-flex justify-content-center align-items-center"
                                         style="width: 80px; height: 80px;">
                                        <img src="img/danh_muc_meoSingapura.jpg" class="mw-100 mh-100">
                                    </div>
                                </td>
                                <td>Mèo Singapura</td>

                                <th>
                                    <button class="btn btn-primary btn-sm">Xem</button>
                                    <button class="btn btn-warning btn-sm">Sửa</button>
                                    <button class="btn btn-danger btn-sm">Xoá</button>
                                </th>
                            </tr>
                            </tbody>
                        </table>

                        <!-- Khu vực phân trang -->
                    </div>
                    <div class="d-flex justify-content-center " style="margin-top: 30px;">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
                    </div>
                </form>

            </div>
        </div>
    </div>
    <div class="pt-3" style="width: calc(100% - 250px);">
        <div class="container">
            <div ng-view></div>
        </div>
    </div>
</div>


</div>
</body>
</html>

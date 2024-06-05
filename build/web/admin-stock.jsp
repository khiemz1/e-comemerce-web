<%-- 
    Document   : admin-stock
    Created on : Jan 1, 2024, 12:53:59 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
        <title>Admin - Danh sách sản phẩm | G7 - SHOES</title>
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <style>
        .btn {
            display: inline-block;
            background: #ff523b;
            color: #fff;
            padding: 8px 15px;
            border-radius: 30px;
            transition: 0.5s;
        }
        .btn:hover {
            background: #563434;
        }
    </style>

    <body>
        <!-- =============== Navigation ================ -->
        <div class="container">

            <div id="1"></div>
            <c:import url="admin-nav.jsp"/>

            <!-- ========================= Main ==================== -->
            <div class="main">
                <div class="topbar">
                    <div class="toggle">
                        <ion-icon name="menu-outline"></ion-icon>
                    </div>

                    <div class="search">
                        <label>
                            <input type="text" placeholder="Tìm kiếm...">
                            <ion-icon name="search-outline"></ion-icon>
                        </label>
                    </div>

                    <div class="user">
                        <img src="images/admin.jpg" alt="">
                    </div>
                </div>



                <!-- ================ Order Details List ================= -->
                <div class="details">
                    <div class="recentOrders">
                        <div class="cardHeader">
                            <h2>Danh sách sản phẩm</h2>
                            <a href="#" class="btn" id="btn-them">Thêm sản phẩm</a>
                            <a href="#" class="btn" id="btn-them-size">Thêm size Sản phẩm</a>
                        </div>

                        <table>
                            <thead>
                                <tr>
                                    <td>Tên sản phẩm</td>
                                    <td>Mã SP</td>
                                    <td>Hãng</td>
                                    <td>Giá tiền</td>
                                    <td>SL trong kho</td>
                                    <td>SL đã bán</td>                                
                                    <td>Sửa TT</td>
                                    <td>Xóa SP</td>

                                </tr>
                            </thead>

                            <tbody id="dsSanPham">
                                <c:forEach var="sp" items="${requestScope.listSP}">
                                    <tr id="${sp.maSP}">
                                        <td>${sp.tenSP}</td>
                                        <td>${sp.maSP}</td>
                                        <td>${sp.brandSP}</td>
                                        <td>${sp.giaSP} Vnđ</td>
                                        <td>
                                            <c:forEach var="size" items="${requestScope.listSize}">
                                                <c:if test="${size.maSP == sp.maSP}">
                                                    <p > Size: ${size.size} (Còn lại: ${size.soLuongSize})</p>
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>${sp.soluongDaBan}</td>
                                        <td><a class="btn" id="btn-edit" onclick="edit_Form('${sp.tenSP}', '${sp.maSP}', '${sp.brandSP}', '${sp.giaSP}', '${sp.moTaSP}', '${sp.anhSP}')">Sửa</a></td>
                                        <td><a href="admin_stock?job=delete&maSP=${sp.maSP}" class="btn">Xóa</a></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
            <div id="size" style="display: none;">
                <input type="text" id="maSP2" placeholder="Mã sản phẩm">
                <input type="text" id="sizeSp" placeholder="Size">
                <input type="text" id="soLuongSize" placeholder="Số lượng size"> <br>
                <button class="btn-them" onclick="themSize()">Xác nhận</button>
                <button class="btn-them" onclick="huyThemSize()">Hủy</button>
            </div>
            <!---doi thong tin--->
            <div id="them" style="display: none;">
                <h2 class="edit-head">Thêm sản phẩm</h2>
                <input type="text" class="edit-text" id="tenSP" placeholder="Tên sản phẩm">
                <input type="text" class="edit-text" id="maSP" placeholder="Mã sản phẩm">
                <input type="text" class="edit-text" id="anhSP" placeholder="Link ảnh">
                <input type="text" class="edit-text" id="anhSP1" placeholder="Link ảnh1">
                <input type="text" class="edit-text" id="anhSP2" placeholder="Link ảnh2">
                <input type="text" class="edit-text" id="anhSP3" placeholder="Link ảnh3">
                <input type="text" class="edit-text" id="hang" placeholder="Hãng">
                <input type="text" class="edit-text" id="giaTien" placeholder="Giá tiền">
                <input type="text" class="edit-text" id="chiTiet" placeholder="Chi tiết sản phẩm">
                <button class="btn-them" onclick="xacNhanThem()">Xác nhận</button>
                <button class="btn-them" onclick="huyThem()">Hủy</button>
            </div>

            <div id="edit" style="display: none;">
                <h2 class="edit-head">Chỉnh sửa thông tin sản phẩm</h2>
                <input type="text" class="edit-text" id="tenSP1" placeholder="Tên sản phẩm">
                <input type="text" class="edit-text" id="maSP1" placeholder="Mã sản phẩm" readonly>
                <input type="text" class="edit-text" id="anhSP_1" placeholder="Link ảnh">
                <input type="text" class="edit-text" id="hang1" placeholder="Hãng">
                <input type="text" class="edit-text" id="giaTien1" placeholder="Giá tiền">
                <input type="text" class="edit-text" id="chiTiet1" placeholder="Chi tiết sản phẩm">
                <button class="btn-edit" onclick="xacNhanChinhSua()">Xác nhận</button>
                <button class="btn-edit" onclick="huyChinhSua()">Hủy</button>
            </div>
            <script type="text/javascript">
                var listSP = [];
                <c:forEach var="sp" items="${listSP}">
                listSP.push("${sp.maSP}");
                </c:forEach>


                function edit_Form(tenSP, maSP, brand, giaSP, moTa, anhSP) {
                    document.getElementById("anhSP_1").value = anhSP;
                    document.getElementById("tenSP1").value = tenSP;
                    document.getElementById("maSP1").value = maSP;
                    document.getElementById("hang1").value = brand;
                    document.getElementById("giaTien1").value = giaSP;
                    document.getElementById("chiTiet1").value = moTa;
                    document.getElementById("edit").style.display = "block";
                }

                document.getElementById("btn-them").addEventListener("click", function () {
                    document.getElementById("them").style.display = "block";
                });
                document.getElementById("btn-them-size").addEventListener("click", function () {
                    document.getElementById("size").style.display = "block";
                });
                function xacNhanThem() {
                    var anhSP = document.getElementById("anhSP").value;
                    var anhSP1 = document.getElementById("anhSP1").value;
                    var anhSP2 = document.getElementById("anhSP2").value;
                    var anhSP3 = document.getElementById("anhSP3").value;
                    var tenSP = document.getElementById("tenSP").value;
                    var maSP = document.getElementById("maSP").value;
                    var brand = document.getElementById("hang").value;
                    var giaSP = document.getElementById("giaTien").value;
                    var moTa = document.getElementById("chiTiet").value;
                    if (anhSP === "" || anhSP1 === "" || anhSP2 === "" || anhSP3 === "" || tenSP === "" || maSP === "" || brand === "" || giaSP === "" || moTa === "") {
                        alert("Bạn phải điền đầy đủ thông tin!");
                    } else if (listSP.includes(maSP)) {
                        alert("Mã sản phẩm này đã tồn tại!");
                    } else if (confirm("Bạn có chắc muốn thêm sản phẩm?")) {
                        $.ajax({
                            url: "/BTL_WEB1/addSP",
                            type: "GET",
                            data: {
                                anhSP: anhSP,
                                anhSP1: anhSP1,
                                anhSP2: anhSP2,
                                anhSP3: anhSP3,
                                tenSP: tenSP,
                                maSP: maSP,
                                brand: brand,
                                giaSP: giaSP,
                                moTaSP: moTa
                            },
                            success: function (data) {
                                alert("Bạn đã thêm sản phẩm thành công");
                                var dataSP = document.getElementById("dsSanPham");
                                dataSP.innerHTML = data;
                            },
                            error: function (data) {

                            }
                        });
                        document.getElementById("them").style.display = "none";
                    }


                }

                function huyThem() {
                    document.getElementById("them").style.display = "none";
                }


                function xacNhanChinhSua() {
                    var anhSP = document.getElementById("anhSP_1").value;
                    var tenSP = document.getElementById("tenSP1").value;
                    var maSP = document.getElementById("maSP1").value;
                    var brand = document.getElementById("hang1").value;
                    var giaSP = document.getElementById("giaTien1").value;
                    var moTa = document.getElementById("chiTiet1").value;
                    if (confirm("Bạn có chắc muốn sửa thông tin sản phẩm?")) {
                        $.ajax({
                            url: "/BTL_WEB1/editSP",
                            type: "GET",
                            data: {
                                anhSP: anhSP,
                                tenSP: tenSP,
                                maSP: maSP,
                                brand: brand,
                                giaSP: giaSP,
                                moTaSP: moTa
                            },
                            success: function (data) {
                                alert("Bạn đã sửa sản phẩm thành công");
                                var dataSP = document.getElementById(maSP);
                                dataSP.innerHTML = data;
                            },
                            error: function (data) {

                            }
                        });
                        document.getElementById("edit").style.display = "none";
                    }


                }

                function huyChinhSua() {
                    document.getElementById("edit").style.display = "none";
                }
                function themSize() {
                    var maSanPham = document.getElementById("maSP2").value;
                    var sizeSP = document.getElementById("sizeSp").value;
                    var soLuong = document.getElementById("soLuongSize").value;
                    if (maSanPham === "" || sizeSP === "" || soLuong === "") {
                        alert("Vui lòng điền đầy đủ thông tin!");
                    } else {
                        if (listSP.includes(maSanPham) && confirm("Bạn có chắc muốn thêm size với số lượng này?")) {
//                            window.location = "admin_stock?job=addSize&maSP=" + maSanPham + "&size=" + sizeSP + "&quantity=" + soLuong;
                            $.ajax({
                                url: "/BTL_WEB1/admin_stock",
                                type: "GET",
                                data: {
                                    job: "addSize",
                                    maSP: maSanPham,
                                    size: sizeSP,
                                    quantity: soLuong
                                },
                                success: function (data) {
                                    alert("Bạn đã thêm size sản phẩm thành công");
                                    var dataSP = document.getElementById(maSanPham);
                                    dataSP.innerHTML = data;
                                },
                                error: function (data) {

                                }
                            });
                            document.getElementById("size").style.display = "none";
                        } else {
                            alert("Mã sản phẩm không hợp lệ!");
                        }
                    }

                }
                function huyThemSize() {
                    // Ẩn cửa sổ đổi mật khẩu khi nhấn "Hủy"
                    document.getElementById("size").style.display = "none";
                }

            </script>

        </div>

        <!-- =========== Scripts =========  -->
        <!--        <script src="admin.js"></script>-->

        <!-- ====== ionicons ======= -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>

</html>
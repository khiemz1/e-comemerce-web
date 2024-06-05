<%-- 
    Document   : admin-sale
    Created on : Jan 1, 2024, 12:53:21 PM
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
        <title>Admin - Danh sách đơn hàng | G7 - SHOES</title>
        <link rel="stylesheet" href="css/admin.css">
    </head>

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
                            <h2>Danh sách đơn hàng</h2>

                        </div>

                        <table>
                            <thead>
                                <tr>
                                    <td>Mã đơn hàng</td>
                                    <td>Tên tài khoản</td>
                                    <td>Ngày đặt hàng</td>
                                    <td>Địa chỉ giao hàng</td>
                                    <td>Giá tiền</td>
                                    <td>Hình thức TT</td>
                                    <td>Tình trạng</td>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="dh" items="${requestScope.listDH}">
                                    <tr>
                                        <td>${dh.maDH}</td>
                                        <td>${dh.tentk}</td>
                                        <td>${dh.ngayDatHang}</td>
                                        <td>${dh.diaChi}</td>
                                        <td>${dh.tongBill} Vnđ</td>
                                        <td>${dh.hinhThucThanhToan}</td>
                                        <td><c:choose>
                                                <c:when test="${dh.tinhTrangDH eq '0'}"><span class="status inProgress">Đang chờ xử lí</span>
                                                    <br>  <a href="admin?confirm=1&maDH=${dh.maDH}&tentk=${dh.tentk}" style="text-decoration: none; color: red">Xác nhận đơn hàng?</a>
                                                </c:when>
                                                <c:when test="${dh.tinhTrangDH eq '1'}"><span class="status pending">Đang vận chuyển</span>
                                                    <br>  <a href="admin?confirm=2&maDH=${dh.maDH}&tentk=${dh.tentk}" style="text-decoration: none; color: red">Đã vận chuyển đến?</a>
                                                </c:when>
                                                <c:when test="${dh.tinhTrangDH eq '2'}"><span class="status pending">Đang chờ khách hàng xác nhận</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="status delivered">Đã nhận</span>
                                                </c:otherwise>
                                            </c:choose></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>

        <!-- =========== Scripts =========  -->
        <script src="admin.js"></script>

        <!-- ====== ionicons ======= -->
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>

</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
        <title>Admin | G7 - SHOES</title>
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



                    <div class="user">
                        <img src="images/admin.jpg" alt="">
                    </div>
                </div>

                <!-- ======================= Cards ================== -->
                <div class="cardBox">
                    <div class="card">
                        <div>
                            <div class="numbers">${soLuongTaiKhoan}</div>
                            <div class="cardName">Tài khoản khách </div>
                        </div>

                        <div class="iconBx">
                            <ion-icon name="people-outline"></ion-icon>
                        </div>
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">${soLuongDH}</div>
                            <div class="cardName">Đơn hàng</div>
                        </div>

                        <div class="iconBx">
                            <ion-icon name="cart-outline"></ion-icon>
                        </div>
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">${doanhthuThang1}</div>
                            <div class="cardName">Doanh thu tháng</div>
                        </div>

                        <div class="iconBx">
                            <ion-icon name="cash-outline"></ion-icon>
                        </div>
                    </div>

                    <div class="card">
                        <div>
                            <div class="numbers">${tongbill2024}</div>
                            <div class="cardName">Doanh thu năm 2024</div>
                        </div>

                        <div class="iconBx">
                            <ion-icon name="cash-outline"></ion-icon>
                        </div>
                    </div>
                </div>

                <!-- ================ Order Details List ================= -->
                <div class="details double">
                    <div class="recentOrders">
                        <div class="cardHeader">
                            <h2>Danh sách đơn hàng gần đây</h2>
                            <a href="admin-sale.jsp" class="btn">Xem thêm</a>
                        </div>

                        <table>
                            <thead>
                                <tr>
                                    <td>Mã đơn hàng</td>
                                    <td>Tổng tiền</td>
                                    <td>Hình thức thanh toán</td>
                                    <td>Tình trạng</td>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="dh" items="${requestScope.listDH}">
                                    <tr>
                                        <td>${dh.maDH}</td>
                                        <td>${dh.tongBill} VNĐ</td>
                                        <td>${dh.hinhThucThanhToan}</td>
                                        <td>
                                            <c:choose>
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
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <!-- ================= New Customers ================ -->
                    <div class="recentCustomers">
                        <div class="cardHeader">
                            <h2>Khách hàng gần đây</h2>
                        </div>
                        <c:forEach items="${requestScope.tenKhachHangList}" var="kh">
                            <table>
                                <tr>                        
                                    <td width="60px">
                                        <div class="imgBx"><img src="images/user.png" alt=""></div>
                                    </td>
                                    <td>
                                        <h4>${kh.hoTen} <br> <span>${kh.diaChi}</span></h4>
                                    </td>
                                </tr>
                            </table>
                        </c:forEach>

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
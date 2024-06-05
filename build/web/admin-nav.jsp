<%-- 
    Document   : admin-nav
    Created on : Jan 1, 2024, 12:52:51 PM
    Author     : ADMIN
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
    <title>Admin-NAV | G7 - SHOES</title>
    <link rel="stylesheet" href="css/admin.css">
</head>

<body>
    <!-- =============== Navigation ================ -->
        <div class="navigation">
            <ul>
                <li>
                    <a href="index">
                        <span class="icon">
                            <img
                            src="images/g7_minilogo.png" width="25px" height="25px"/>
                        </span>
                        <span class="title">Groupe G7</span>
                    </a>
                </li>

                <li>
                    <a href="admin">
                        <span class="icon">
                            <ion-icon name="home-outline"></ion-icon>
                        </span>
                        <span class="title">Tổng quan</span>
                    </a>
                </li>

                <li>
                    <a href="DanhSachTaiKhoanKhachHang">
                        <span class="icon">
                            <ion-icon name="people-outline"></ion-icon>
                        </span>
                        <span class="title">Danh sách tài khoản</span>
                    </a>
                </li>

                <li>
                    <a href="admin_stock">
                        <span class="icon">
                            <ion-icon name="shirt-outline"></ion-icon>
                        </span>
                        <span class="title">Danh sách sản phẩm</span>
                    </a>
                </li>

                <li>
                    <a href="admin-sale">
                        <span class="icon">
                            <ion-icon name="cart-outline"></ion-icon>
                        </span>
                        <span class="title">Danh sách đơn hàng</span>
                    </a>
                </li>


                <li>
                    <a href="logout">
                        <span class="icon">
                            <ion-icon name="log-out-outline"></ion-icon>
                        </span>
                        <span class="title">Đăng xuất</span>
                    </a>
                </li>
            </ul>
        </div>


    <!-- =========== Scripts =========  -->
    <script src="admin.js"></script>

    <!-- ====== ionicons ======= -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>

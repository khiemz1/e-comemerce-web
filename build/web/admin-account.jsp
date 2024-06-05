<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
    <title>Admin - Danh sách tài khoản | G7 - SHOES</title>
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
                        <h2>Danh sách tài khoản khách</h2>
                        
                    </div>

                    <table>
                        <thead>
                            <tr>
                                <td>Họ và Tên</td>
                                <td>Tên tài khoản</td>
                                <td>Email</td>
                                <td>SDT</td>
                                <td>Địa chỉ</td>
                                <td>Xóa TK</td>
                            </tr>
                        </thead>
                        <c:forEach items="${requestScope.DsTK}" var="c">
                            <tbody style="height: 40px">
                                <tr>
                                <td>${c.hoTen}</td>
                                <td>${c.tenTK}</td>
                                <td>${c.emial}</td>
                                <td>${c.sdt}</td>
                                <td>${c.diaChi}</td>
                                <td><a href="deleteTaiKhoanKhach?sid=${c.tenTK}" class="btn">Xóa</a></td>
                            </tr>

                        </tbody>
                        </c:forEach>
                        
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
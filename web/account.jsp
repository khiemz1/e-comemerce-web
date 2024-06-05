<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />

        <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
        <title>Đăng nhập | G7 - SHOES</title>

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,600;0,800;0,900;1,100&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="css/account.css"/>
        <link rel="stylesheet" href="css/admin.css"/>
    </head>
    <style>
        .search-container input[type=text] {
            float: right;
            padding: 13.7px 0px;
            padding-right: 230px;
            margin-right: 50px;
            border: 1px solid black;
            font-size: 17px;
        }
        .btn-search {
            display: inline-block;
            background:   #ff523b;
            color: gray;
            padding: 14px 5px;
            margin-left: 100px;
            border: 1.5px solid black;
            transition: 0.5s;
        }
        #cap-nhap-thong-tin {
            width: 500px;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #fff;
            animation: bounceIn 0.5s ease-out;
            border-radius: 10px;
            box-shadow: 0 0 10px 5px rgba(0, 0, 0, 0.5);
            text-align: center;
            display: none;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
    <body>

        <!-- phan user -->
        <div id="1"></div>
        <c:import url="header" />
        <div class="h-location">
            <p class="h-location-text">
                <a href="index">Trang chủ</a> / <a href="">Tài khoản</a>
            </p>
        </div>
        <!--cart-->
        <div class="user-container">
            <div class="user-box">
                <div class="user-profile">
                    <img class="user-avatar" src="images/user.png" alt="Avatar User" />
                    <p><strong>${tentk}</strong></p>
                    <button id="btn-doi-mat-khau" class="btn">Đổi mật khẩu</button>
                    <button class="btn" onclick="logout()">Đăng xuất</button>
                </div>
                <div class="user-info">
                    <p><strong>Họ tên:</strong> ${KH.hoTen}</p>
                    <hr class="user-hr">
                    <p><strong>Địa chỉ:</strong> ${KH.diaChi}</p>
                    <hr class="user-hr">
                    <p><strong>Số điện thoại:</strong> ${sdt}</p>
                    <hr class="user-hr">
                    <p><strong>Email:</strong> ${KH.email}</p>
                    <hr class="user-hr">
                    <button id="btn-edit">Cập nhật thông tin</button>
                </div>
            </div>
        </div>




        <!-- ds san pham -->
        <div class="small-container cart-page">
            <table>
                <tr>
                    <th>Mã đơn hàng</th>
                    <th>Chi tiết đơn hàng</th>
                    <th>Địa chỉ giao hàng</th>
                    <th>Tổng cộng</th>
                    <th>Ngày đặt</th>
                    <th>Tình trạng</th>
                </tr>
                <c:forEach var="c" items="${requestScope.listDH}">
                    <tr>
                        <td>
                            <h1>${c.maDH}</h1>
                        </td>
                        <td>
                            <c:forEach var="sp" items="${requestScope.listSP}">
                                <c:if test="${sp.maDH == c.maDH}">
                                    <div class="cart-info">
                                        <img
                                            src="${sp.anhSP}" width="40px" height="40px"
                                            />
                                        <div>
                                            <a href="Chitietsanpham?maSP=${sp.maSP}">${sp.tenSp}</a> <br>
                                            <small>Giá: ${sp.giaSP} VNĐ x ${sp.soLuongDH}</small>
                                            <p>Size: ${sp.sizeSP}</p>
                                        </div>
                                    </div>
                                    <br />
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>${c.diaChi}</td>
                        <td>${c.tongBill}  VNĐ </td>
                        <td>${c.ngayDatHang}</td>
                        <td>
                            <c:choose>
                                <c:when test="${c.tinhTrangDH eq '0'}"><span class="status inProgress">Đang chờ xử lí</span>
                                    <br>  <a href="account?confirm=4&maDH=${c.maDH}" style="text-decoration: none; color: red">Hủy đơn hàng?</a>
                                </c:when>
                                <c:when test="${c.tinhTrangDH eq '1'}"><span class="status pending">Đang vận chuyển</span>
                                </c:when>
                                <c:when test="${c.tinhTrangDH eq '2'}"><span class="status pending">Chưa xác nhận</span>
                                    <br>  <a href="account?confirm=3&maDH=${c.maDH}" style="text-decoration: none; color: red">Xác nhận đơn hàng?</a>
                                </c:when>
                                <c:otherwise>
                                    <span class="status delivered">Đã nhận</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>

            </table>

        </div>
        <!--Phần Footer -->
        <div id="2"></div>
        <c:import url="footer.jsp" />
        <!---doi mat khau--->
        <div id="doi-mat-khau" style="display: none">
            <h2>Đổi mật khẩu</h2>
            <form>
                <input type="password" id="mat-khau-cu" name="${mk}" placeholder="Mật khẩu cũ"/>
                <input type="password" id="mat-khau-moi" placeholder="Mật khẩu mới" />
                <input
                    type="password"
                    id="xac-nhan-mat-khau-moi"
                    placeholder="Xác nhận mật khẩu mới"
                    />
                <button class="btn" type="button"  onclick="xacNhanDoiMatKhau()">Xác nhận</button>
                <button class="btn" type="button" onclick="huyDoiMatKhau()">Hủy</button>
            </form>
        </div>

        <!---doi thong tin--->
        <div id="cap-nhap-thong-tin" style="display: none">
            <h2>Chỉnh sửa thông tin</h2>
            <form>
                <input type="Name" id="ho-ten" placeholder="Họ và tên" value="${KH.hoTen}" />
                <input type="Address" id="dia-chi" placeholder="Địa chỉ" value="${KH.diaChi}"/>
                <input type="tel" id="so-dien-thoai" placeholder="Số điện thoại" value="${sdt}"/>
                <input type="email" id="email" placeholder="Email" value="${KH.email}" />
                <button class="btn" type="button" onclick="xacNhanChinhSua()">Xác nhận</button>
                <button class="btn" type="button" onclick="huyChinhSua()">Hủy</button>
            </form>
        </div>
        <script>
            document
                    .getElementById("btn-edit")
                    .addEventListener("click", function () {
                        document.getElementById("cap-nhap-thong-tin").style.display = "block";
                    });

            document
                    .getElementById("btn-doi-mat-khau")
                    .addEventListener("click", function () {
                        // Hiển thị cửa sổ đổi mật khẩu
                        document.getElementById("doi-mat-khau").style.display = "block";
                    });

            function xacNhanDoiMatKhau() {
                var matKhauCu = document.getElementById("mat-khau-cu");
                var matKhauMoi = document.getElementById("mat-khau-moi");
                var xacNhanMatKhau = document.getElementById("xac-nhan-mat-khau-moi");

                var mk = matKhauCu.value;
                var mkMoi = matKhauMoi.value;
                var xacNhan = xacNhanMatKhau.value;
                var mkXacNhan = matKhauCu.name;
                if (mkMoi === "" || mk === "" || xacNhan === "") {
                    alert("vui lòng nhập đầy đủ thông tin!");
                } else if (mkMoi !== xacNhan) {
                    alert("vui lòng kiểm tra lại xác nhận mật khẩu");
                } else if (mk !== mkXacNhan) {
                    alert("Mật khẩu cũ không đúng!")
                } else {
                    if (confirm("Bạn chắc chắn muốn thay đổi mật khẩu?")) {
                        window.location = "doimk?mkMoi=" + mkMoi;
                    }
                }
            }

            function huyDoiMatKhau() {
                document.getElementById("doi-mat-khau").style.display = "none";
            }

            function xacNhanChinhSua() {
                var nameInput = document.getElementById("ho-ten");
                var diaChiInput = document.getElementById("dia-chi");
                var sdtInput = document.getElementById("so-dien-thoai");
                var emailInput = document.getElementById("email");

                var name = nameInput.value;
                var diaChi = diaChiInput.value;
                var sdt = sdtInput.value;
                var email = emailInput.value;

                if (sdt === "" || email === "") {
                    alert("Bạn không được để trống số điện thoại và email!")
                } else if (confirm("Bạn chắc chắn muốn thay đổi thông tin?")) {
                    window.location = "updateInfor?name=" + name + "&diaChi=" + diaChi + "&sdt=" + sdt + "&email=" + email;
                }

            }

            function huyChinhSua() {
                // Ẩn cửa sổ chỉnh sửa khi nhấn "Hủy"
                document.getElementById("cap-nhap-thong-tin").style.display = "none";
            }
            function logout() {
                window.location = "logout"
            }
        </script>
    </body>
</html>
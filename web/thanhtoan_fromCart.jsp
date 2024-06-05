<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
        <title>Thanh toán | G7 - SHOES</title>
        <link rel="stylesheet" href="css/thanhtoan.css" />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
            rel="stylesheet"
            />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,600;0,800;0,900;1,100&display=swap"
            rel="stylesheet"
            />
    </head>
    <body>
        <!-- phan header -->
        <div id="1"></div>
        <c:import url="header"/>
        <hr class="h-hr-style" />
        <div class="h-location">
            <p class="h-location-text">
                <a href="index.html">Trang chủ</a> / <a href="">Tài khoản</a> /
                <a href=""> Thanh toán</a>
            </p>
        </div>
        <hr class="h-hr-style" />
        <!-- body -->
        <div class="info">

            <div class="info-container2">
                <div class="info-shoe">
                    <div class="info-shoe_header">
                        <h1 class="info-shoe_heading">Thông tin sản phẩm</h1>
                    </div>
                    <c:forEach var="c" items="${requestScope.listCart}">
                    <c:set var="maSPProcessed" value="false" scope="request"/>

                    <c:forEach var="sp" items="${requestScope.listSP}">
                        <c:if test="${sp.maSP == c.maSP && maSPProcessed eq false}">
                            <c:set var="maSPProcessed" value="true" scope="request"/>
                            <div class="info-shoe_product">
                                    <p class="info-shoe_product_name">${sp.tenSP} - size ${c.sizeSP}</p>
                                    <p class="info-shoe_product_amount">x ${c.soLuongGH}</p>
                                </div>
                        </c:if>
                    </c:forEach>
                </c:forEach>
                    <div class="info-shoe_info">
                        <p class="info-shoe_info_account">Chủ tài khoản: ${KH.hoTen}</p><br>
                    </div>
                    <div class="info-shoe_info2">
                        <p class="info-shoe_sale">Mã đơn hàng: ${maDH}</p>
                        <br>
                    </div>
                    <div class="info-shoe_cost">
                        <p class="info-shoe_cost_total">Tổng cộng:</p>
                        <p class="info-shoe_cost_money">${tong} VNĐ</p>
                    </div>
                    <div class="info-shoe_cost2">
                        <p class="info-shoe_cost_total">Phụ phí (Giao hàng):</p>
                        <p class="info-shoe_cost_money">0 VNĐ</p>
                    </div>
                    <div class="info-shoe_cost3">
                        <p class="info-shoe_cost_total">Thành tiền:</p>
                        <p class="info-shoe_cost_money">${tong} VNĐ</p>
                    </div>
                    <div class="info-shoe_option">
                        <div class="info-shoe_option1">
                            <input name="option" type="radio" class="info-shoe_radio" id="tienMat" value="tienMat" onchange="hienThiDiaChi()"/> Thanh
                            toán tiền mặt khi nhận hàng
                        </div>
                        <div class="info-shoe_option2">
                            <input name="option" type="radio" class="info-shoe_radio" id="chuyenKhoan" value="chuyenKhoan" onchange="hienThiNganHang()"/>
                            Chuyển khoản ngân hàng
                        </div>
                        <br>
                        <div class="info-bank" id="bankInfo">
                            <label for="diaChi1">Địa Chỉ nhận hàng: </label> 
                            <input type="text" id="diaChi1" class="diaChi" value="${KH.diaChi}"> <br> <br>
                            <label for="nganHang">Chọn ngân hàng:</label>
                            <select id="nganHang">
                                <option>Argibank</option>
                                <option>Vientinbank</option>
                                <option>Techcombank</option>
                                <option>MB Bank</option>
                            </select>
                            <br>
                            <br>
                            <label for="stk">Số tài khoản:</label>
                            <input type="text" id="stk" class="soTaiKhoan">
                        </div>

                        <div class="address-info" id="addressInfo">
                            <label for="diaChi2">Địa Chỉ nhận hàng:</label>
                            <input type="text" id="diaChi2" class="diaChi"  value="${KH.diaChi}">
                        </div>

                    </div>
                    <div class="info-form_button">
                        <button class="btn" onclick="thanhToan()">Thanh Toán</button>
                    </div>
                </div>
            </div>
        </div>

        <script>
            // Ẩn cả hai bảng thông tin khi trang web được mở
            document.getElementById('bankInfo').style.display = 'none';
            document.getElementById('addressInfo').style.display = 'none';

            function hienThiNganHang() {
                var chuyenKhoanRadio = document.getElementById('chuyenKhoan');
                var bankInfoDiv = document.getElementById('bankInfo');
                var addressInfoDiv = document.getElementById('addressInfo');

                // Nếu radio "chuyenKhoan" được chọn, hiển thị thông tin ngân hàng và ẩn thông tin địa chỉ
                if (chuyenKhoanRadio.checked) {
                    bankInfoDiv.style.display = 'block';
                    addressInfoDiv.style.display = 'none';
                } else {
                    bankInfoDiv.style.display = 'none';
                }
            }

            function hienThiDiaChi() {
                var tienMatRadio = document.getElementById('tienMat');
                var bankInfoDiv = document.getElementById('bankInfo');
                var addressInfoDiv = document.getElementById('addressInfo');

                // Nếu radio "tienMat" được chọn, hiển thị thông tin địa chỉ và ẩn thông tin ngân hàng
                if (tienMatRadio.checked) {
                    addressInfoDiv.style.display = 'block';
                    bankInfoDiv.style.display = 'none';
                } else {
                    addressInfoDiv.style.display = 'none';
                }
            }

            function thanhToan() {
                var diaChi1 = document.getElementById("diaChi1");
                var diaChi2 = document.getElementById("diaChi2");
                var stk = document.getElementById("stk");
                var chuyenKhoanRadio = document.getElementById('chuyenKhoan');
                var tienMatRadio = document.getElementById('tienMat');
                var nganHang = document.getElementById("nganHang");
                var diaChi;
                var soTaiKhoan;
                var bank;
                if (chuyenKhoanRadio.checked === false && tienMatRadio.checked === false) {
                    alert("Hãy chọn phương thức thay toán!");
                } else {
                    if (chuyenKhoanRadio.checked) {
                        diaChi = diaChi1.value;
                        soTaiKhoan = stk.value;
                        if (diaChi === "") {
                            alert("Bạn cần nhập địa chỉ để nhận hàng!");
                        } else if (soTaiKhoan === "") {
                            alert("Bạn cần nhập số tài khoản thanh toán");
                        }
                        if (diaChi !== "" && soTaiKhoan !== "") {
                            bank = nganHang.value;
                            if (confirm("Bạn xác định thông tin đã nhập và sản phẩm muốn mua?")) {
                                window.location = "taoDonHang?diaChi=" + diaChi + "&nganHang=" + bank + "&stk=" + soTaiKhoan;
                            }
                        }
                    } else if (tienMatRadio.checked) {
                        diaChi = diaChi2.value;
                        if (diaChi === "") {
                            alert("Bạn cần nhập địa chỉ để nhận hàng!");
                        } else {
                            bank = "";
                            soTaiKhoan = "";
                            if (confirm("Bạn xác định thông tin đã nhập và sản phẩm muốn mua?")) {
                                window.location = "taoDonHang?diaChi=" + diaChi + "&nganHang=" + bank + "&stk=" + soTaiKhoan;
                            }
                        }
                    }
                }

            }
        </script>

        <!-- footer -->
        <div id="4"></div>
        <c:import url="footer.jsp"/>
    </body>
</html>

</html>

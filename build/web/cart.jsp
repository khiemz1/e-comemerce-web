<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
        <title>Giỏ hàng | G7 - SHOES</title>
        <link rel="stylesheet" href="css/cart.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,600;0,800;0,900;1,100&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
    </head>
    <style>
        .search-container input[type=text] {
            float: right;
            padding: 14px 0px;
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
            transition: 0.5s;
        }
        .xoa-bo {
            display: block;
            background: #fff;
            border: none;
            color: red;
            padding: 4px;
        }
    </style>

    <body>
        <!-- phan header -->
        <div id="1"></div>
        <c:import url="header" />
        <hr class="h-hr-style" />
        <div class="h-location">
            <p class="h-location-text">
                <a href="index">Trang chủ</a> / <a href="">Tài khoản</a> /
                <a href="">Giỏ hàng</a>
            </p>
        </div>
        <hr class="h-hr-style" />
        <!--cart-->
        <div class="small-container cart-page">
            <table>
                <tr>
                    <th>Mua hàng</th>
                    <th>Sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Tổng cộng</th>
                </tr>
                <c:forEach var="c" items="${requestScope.listCart}">
                    <c:set var="maSPProcessed" value="false" scope="request"/>

                    <c:forEach var="sp" items="${requestScope.listSP}">
                        <c:if test="${sp.maSP == c.maSP && maSPProcessed eq false}">
                            <c:set var="maSPProcessed" value="true" scope="request"/>
                            <tr>
                                <td><label for="buy${c.maSP}-${c.sizeSP}">Mua:</label>
                                    <input type="checkbox" id="buy${c.maSP}-${c.sizeSP}" name="buyCart" 
                                           onclick="updateTotalCart('${c.maSP}', '${c.soLuongGH}', '${c.sizeSP}')"/></td>
                                <td>
                                    <c:forEach var="s" items="${requestScope.listSize}">
                                        <c:if test="${c.maSP == s.maSP && c.sizeSP==s.size}">
                                            <p id="soLuongSize-${s.maSP}" style="display:none"> ${s.soLuongSize}</p>
                                        </c:if>
                                    </c:forEach>
                                    <div class="cart-info">
                                        <img src="${sp.anhSP}" />
                                        <div>
                                            <h4>
                                                <a href="Chitietsanpham?maSP=${c.maSP}" class="doimau">${sp.tenSP}</a>
                                            </h4>
                                            <p> Size: ${c.sizeSP}</p>
                                            <small>Giá: ${sp.giaSP}</small>
                                            <br />
                                            <button class="xoa-bo" onclick="deleteCart('${c.maSP}', '${c.sizeSP}')"> Xóa</button>
                                        </div>
                                    </div>
                                </td>
                                <td><input type="number" value="${c.soLuongGH}" id="quantity- ${c.maSP}"
                                           oninput="updateCart(this, '${c.maSP}','${c.soLuongGH}', '${c.sizeSP}')"/></td>
                                <td>${c.tongTien} VNĐ</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:forEach>

            </table>
            <div class="total-price">
                <table>
                    <tr>
                        <td>Tổng</td>
                        <td id="totalCart1">0 VNĐ</td>
                    </tr>
                    <tr>
                        <td>Phụ phí (Giao hàng)</td>
                        <td>0 VNĐ</td>
                    </tr>
                    <tr>
                        <td>Thành tiền</td>
                        <td id="totalCart">0 VNĐ</td>
                    </tr>
                    <tr>
                        <td> <button type="button" class="btn" onclick="buySelected()">Mua hàng</button></td>
                    </tr>
                </table>
            </div>
        </div>
        <!--Phần Footer -->
        <div id="4"></div>
        <c:import url="footer.jsp" />
    </body>
    <script>
        function updateCart(input, maSP, soLuongGH, sizeSP) {
            var newValue = input.value;
            if (newValue !== soLuongGH && newValue !== '0') {
                if (confirm("Bạn muốn thay đổi số lượng của mặt hàng này trong giỏ hàng? ")) {
                    window.location = "cart?soLuong=" + newValue + "&maSP=" + maSP + "&size=" + sizeSP;
                } else {
                    input.value = soLuongGH;
                }
            } else if (newValue === '0') {
                if (confirm("Bạn muốn xóa mặt hàng này trong giỏ hàng? ")) {
                    window.location = "cart?delete=" + maSP + "&size=" + sizeSP;
                } else {
                    input.value = soLuongGH;
                }
            }
        }
        function buySelected() {
            var listMaSP = [];
            var listSizeSP = [];
            var checkboxes = document.getElementsByName("buyCart");

            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    var idParts = checkboxes[i].id.replace("buy", "").split("-");
                    var maSP = idParts[0];
                    var size = idParts[1];
                    listMaSP.push(maSP);
                    listSizeSP.push(size);
                }
            }

            if (listMaSP.length === 0 || listSizeSP === 0) {
                alert("Hãy chọn sản phẩm muốn mua.");
                return;
            }

            // Chuỗi được ngăn cách bởi dấu phẩy
            var StringMaSP = listMaSP.join(',');
            var StringSizeSP = listSizeSP.join(',');
            if (confirm("Bạn có chắc muốn mua những mặt hàng này? ")) {
                window.location = "thanhtoan?StringMaSP=" + StringMaSP + "&StringSizeSP=" + StringSizeSP;
            }
        }


        function updateTotalCart(maSP, soLuongGH, sizeSP) {
            var totalCart = 0;
            var checkboxes = document.getElementsByName("buyCart");
            var pSoLuongSize = document.getElementById("soLuongSize-" + maSP);
            var soLuongSize = parseInt(pSoLuongSize.innerText);
            var idCheckbox = "buy" + maSP + "-" + sizeSP;

            if (soLuongSize < soLuongGH) {
                for (var i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].id === idCheckbox) {
                        alert("Không đủ sản phẩm trong kho cho số lượng bạn đã chọn.");
                        checkboxes[i].checked = false;
                    }
                }
            }
            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    totalCart += parseInt(
                            checkboxes[i].parentNode.nextElementSibling.nextElementSibling
                            .nextElementSibling.innerText
                            );
                }
            }
            document.getElementById("totalCart").innerText = totalCart + " VNĐ";
            document.getElementById("totalCart1").innerText = totalCart + " VNĐ";
        }
        function deleteCart(maSP, sizeSP) {
            if (confirm("Bạn muốn xóa mặt hàng này trong giỏ hàng? ")) {
                window.location = "cart?delete=" + maSP + "&size=" + sizeSP;
            }
        }
    </script>
</html>

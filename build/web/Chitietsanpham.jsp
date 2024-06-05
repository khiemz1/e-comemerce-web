<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link REL="ICON" HREF="images/g7_minilogo.png" type="x-icon">
        <title> Chi tiết sản phẩm | G7 - SHOES</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/chitetsanpham.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>

        <!-- phan header -->
        <div id="1"></div>
        <c:import url="header" />
        <hr class="h-hr-style" />
        <div class="h-location">
            <p class="h-location-text">
                <a href="index">Trang chủ</a> / <a href="DsSanPham">Danh sách sản phẩm</a> /
                <a href=""> ${SP.tenSP}</a>
            </p>
        </div>
        <hr class="h-hr-style" />


        <!--anh san pham-->
        <div class="smallcontainer single-product">
            <div class="row-sp">
                <div class="col-2 single-product-img">
                    <img src="${SP.anhSP}" width="100%" id="ProductImg">

                    <div class="small-img-row">
                        <div class="small-img-col">
                            <img src="${SP.anhSP}" width="100%" class="small-img">
                        </div>
                        <c:forEach items="${requestScope.listAnh}" var="anh" varStatus="loop">
                            <div class="small-img-col">
                                <img src="${anh}" width="100%" class="small-img">
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-2 single-product-title">
                    <h1>${SP.tenSP}</h1>
                    <h4>${SP.giaSP} VNĐ</h4>
                    <select id="size">
                        <option>Size</option>
                        <c:forEach items="${requestScope.listSize}" var="s" varStatus="loop">
                            <option name="${s.soLuongSize}">${s.size} (còn lại: ${s.soLuongSize})</option>

                        </c:forEach>
                    </select>
                    <input type="hidden" name="maSP" id="maSP" value="${SP.maSP}"/>
                    <input type="number"  id="quantity-sp" value="1">
                    <button class="btn" type="button" onclick="xacNhanAddToCart()">Thêm vào giỏ hàng</button>
                    <button class="btn"  type="button" onclick="xacNhanMua()">Mua ngay</button>              
                    <h3>Chi tiết sản phẩm</h3>
                    <p class="spmota1">${SP.moTaSP}</p>
                </div>
            </div>

            <div class="smallcontainer">
                <div class="row row-2">
                    <h2>Bạn có thể thích</h2>
                    <p><a href="DsSanPham" class="doimau">Xem thêm</a></p>
                </div>
            </div>

            <div class="smallcontainer">
                <div class="row">
                    <c:forEach items="${requestScope.data}" var="c" varStatus="loop">
                        <c:if test="${loop.index < 4}">
                            <c:set var="maSP" value="${c.maSP}"/>
                            <div class="col-4 block">
                                <img src="${c.anhSP}" />
                                <div>
            <!--                        <a href="cart?maSP=${c.maSP}"><button class="button1">Thêm vào giỏ hàng</button></a>-->
                                    <form action="DsSanPham" method="POST" class="form-btn">
                                        <input type="hidden" name="maSP" id="maSP" value="${c.maSP}" />
                                        <button class="button1" name="action" value="addCart">Thêm vào giỏ hàng</button>
                                    </form>
                                    <a href="thanhtoan?maSP=${c.maSP}"><button class="button2">Mua ngay</button></a>
                                </div>
                                <h4>
                                    <a href="Chitietsanpham?maSP=${c.maSP}" class="doimau">${c.tenSP}</a>
                                </h4>
                                <p>${c.giaSP} VNĐ</p>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>

        <!--Phần Footer -->

        <div id="4"></div>
        <c:import url="footer.jsp" />

        <!--Js for img product-->
        <script>
            var ProductImg = document.getElementById("ProductImg");
            var SmallImg = document.getElementsByClassName("small-img");
            SmallImg[0].onclick = function () {
                ProductImg.src = SmallImg[0].src;
            }
            SmallImg[1].onclick = function () {
                ProductImg.src = SmallImg[1].src;
            }
            SmallImg[2].onclick = function () {
                ProductImg.src = SmallImg[2].src;
            }
            SmallImg[3].onclick = function () {
                ProductImg.src = SmallImg[3].src;
            }
            function xacNhanAddToCart() {
                
                var maSPInput = document.getElementById("maSP");
                var quantityInput = document.getElementById("quantity-sp");
                var sizeSelect = document.getElementById("size");

                var quantity = quantityInput.value;
                var selectedOption = sizeSelect.value;  // Đổi tên biến thành selectedOption
                var maSP = maSPInput.value;
                var matches = selectedOption.match(/(\d+)/);
                if (matches) {
                    var size = matches[0];
                }

                if (quantity === "0" || selectedOption === "Size") {  // Đổi tên biến thành selectedOption
                    alert("Xin hãy chọn số lượng và size thêm vào giỏ!");
                } else {
                    if (confirm("Bạn thêm sản phẩm này vào giỏ hàng? ")) {
                        window.location = "addToCart?maSP=" + maSP + "&quantity=" + quantity + "&size=" + size + "&link=Chitietsanpham?maSP=" +maSP;

                    }
                }
            }
            function xacNhanMua() {
                var maSPInput = document.getElementById("maSP");
                var quantityInput = document.getElementById("quantity-sp");
                var sizeSelect = document.getElementById("size");

                var quantity = parseInt(quantityInput.value);
                var selectedOption = sizeSelect.value;
                var maSP = maSPInput.value;
                var matches = selectedOption.match(/(\d+)/);
                if (matches) {
                    var size = matches[0];
                }
                var soLuongSize = parseInt(sizeSelect.options[sizeSelect.selectedIndex].getAttribute("name"));

                if (quantity === 0 || selectedOption === "Size") {  // Đổi tên biến thành selectedOption
                    alert("Xin hãy chọn số lượng và size muốn mua.");
                } else if (quantity > soLuongSize) {
                    alert("Số lượng sản phẩm này trong kho không đủ! Vui lòng giảm bớt số lượng muốn mua hoặc tham khảo sản phẩm khác!");
                    quantityInput.value = 1;
                } else {
                    if (confirm("Bạn mua mặt hàng này? ")) {
                        window.location = "thanhtoan?maSP=" + maSP + "&quantity=" + quantity + "&size=" + size;

                    }
                }
            }
        </script>                                    
    </body>
</html>
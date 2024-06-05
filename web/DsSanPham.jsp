<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
        <title>Danh sách sản phẩm | G7 - SHOES</title>
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/danhsachsanpham.css" />
        <link rel="stylesheet" href="css/alert.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <script
            src="https://code.jquery.com/jquery-3.6.4.min.js"
        ></script>
    </head>
    <style>
        #mua-ngay {
            width: 450px;
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
        #mua-ngay input {
            width: 30px;
            height: 30px;
            margin-right: 10px;
            margin-top: 10px;
        }
        #add-cart {
            width: 450px;
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
        #add-cart input {
            width: 30px;
            height: 30px;
            margin-right: 10px;
            margin-top: 10px;
        }
    </style>
    <body>
        <div class="success alert">
            <div class="content">
                <div class="icon">
                    <svg
                        width="50"
                        height="50"
                        id="Layer_1"
                        style="enable-background: new 0 0 128 128"
                        version="1.1"
                        viewBox="0 0 128 128"
                        xml:space="preserve"
                        xmlns="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        >
                    <g><circle fill="#fff" cx="64" cy="64" r="64" /></g>
                    <g>
                    <path
                        fill="#3EBD61"
                        d="M54.3,97.2L24.8,67.7c-0.4-0.4-0.4-1,0-1.4l8.5-8.5c0.4-0.4,1-0.4,1.4,0L55,78.1l38.2-38.2   c0.4-0.4,1-0.4,1.4,0l8.5,8.5c0.4,0.4,0.4,1,0,1.4L55.7,97.2C55.3,97.6,54.7,97.6,54.3,97.2z"
                        />
                    </g>
                    </svg>
                </div>
                <p>${thongBao}</p>
            </div>
            <button class="close">
                <svg
                    height="18px"
                    id="Layer_1"
                    style="enable-background: new 0 0 512 512"
                    version="1.1"
                    viewBox="0 0 512 512"
                    width="18px"
                    xml:space="preserve"
                    xmlns="http://www.w3.org/2000/svg"
                    xmlns:xlink="http://www.w3.org/1999/xlink"
                    >
                <path
                    fill="#69727D"
                    d="M437.5,386.6L306.9,256l130.6-130.6c14.1-14.1,14.1-36.8,0-50.9c-14.1-14.1-36.8-14.1-50.9,0L256,205.1L125.4,74.5  c-14.1-14.1-36.8-14.1-50.9,0c-14.1,14.1-14.1,36.8,0,50.9L205.1,256L74.5,386.6c-14.1,14.1-14.1,36.8,0,50.9  c14.1,14.1,36.8,14.1,50.9,0L256,306.9l130.6,130.6c14.1,14.1,36.8,14.1,50.9,0C451.5,423.4,451.5,400.6,437.5,386.6z"
                    />
                </svg>
            </button>
        </div>
        <script>
            $(document).ready(function () {
                var thongBao = "${thongBao}";
                if (thongBao !== "") {
                    var popup = $(".success.alert");
                    popup.css("visibility", "visible");
                    popup.css("opacity", "1");
                }

                $(".close").click(function () {
                    var popup = $(".success.alert");
                    popup.css("visibility", "hidden");
                    popup.css("opacity", "0");
                });
            });
        </script>
        <c:if test="${not empty thongBao}">
            <c:remove var="thongBao" scope="session" />
        </c:if>
        <div id="1">
            <c:import url="header" />
        </div>

        <hr class="h-hr-style" />
        <div class="h-location">
            <p class="h-location-text">
                <a href="index.jsp">Trang chủ</a> / <a href="">Danh sách sản phẩm</a>
            </p>
        </div>
        <hr class="h-hr-style" />
        <img src="images/collection_banner.jpg" class="margin-banner" />

        <!--Phan san pham-->
        <div class="smallcontainer">
            <div>
                <a href="DsSanPham" class="dssanpham doimau ${tag == b || tag == "" ? 'page':''}">All</a>
                <c:forEach items="${requestScope.brand}" var="b" >
                    <a href="DsSanPham?tag=${b}" class="dssanpham doimau ${tag == b ? 'page':''}">${b}</a>
                </c:forEach>
                <hr class="hr-style1" />
            </div>
            <br> 
            <div class="sort-sp">
                <img src="images/adjust icon.png" height="15px" width="15px" />
                <select id="sortSelect" class="margin-label" onchange="sortBy()">
                    <option<c:if test="${empty sortId}"> selected</c:if>>Mặc định</option>
                    <option<c:if test="${sortId == '1'}"> selected</c:if>>Sắp xếp theo giá</option>
                    <option<c:if test="${sortId == '2'}"> selected</c:if>>Sắp xếp theo độ bán chạy</option>
                    </select>
                </div>
                <br> 
                <div class="row">
                <c:forEach items="${requestScope.data}" var="c" varStatus="loop">
                    <div class="col-4 block">
                        <img src="${c.anhSP}" />
                        <select id="clone-${c.maSP}" style="display:none">
                            <option>Size</option>
                            <c:forEach items="${listSize}" var="s">
                                <c:if test="${c.maSP==s.maSP}">
                                    <option name="${s.soLuongSize}">${s.size} (còn lại: ${s.soLuongSize})</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        <div>
                            <button class="button1" onclick="addToCart('${c.maSP}', '${c.tenSP}', '${c.giaSP}', '${c.anhSP}', '${c.moTaSP}')">Thêm vào giỏ hàng</button>
                            <button onclick="buyNow('${c.maSP}', '${c.tenSP}', '${c.giaSP}', '${c.anhSP}', '${c.moTaSP}')" class="button2">Mua ngay</button>              
                        </div>
                        <h4>
                            <a href="Chitietsanpham?maSP=${c.maSP}" class="doimau">${c.tenSP}</a>
                        </h4>

                        <p>${c.giaSP} VNĐ</p>
                    </div>
                </c:forEach>
            </div>
        </div>

        <!--Phần Footer -->

        <div id="4"></div>
        <c:import url="footer.jsp" />

        <div id="mua-ngay" style="display:none">
            <p>Lựa chọn size và số lượng sản phẩm bạn muốn mua:</p>
            <h1 id="name-sp">Ten san pham</h1>
            <img id="anh-sp" src="" width="80px" height="80px"/>
            <form>
                <input type="hidden" name="maSP" id="maSP"/>
                <h4 id="price-sp">000 VNĐ</h4>
                <h3>Chi tiết sản phẩm</h3>
                <input type="number" id="quantity-sp" value="1"> 
                <select id="size">
                    <option>Size</option>
                    <option>39</option>
                    <option>40</option>
                    <option>41</option>
                </select> <br>
                <button class="btn"  type="button" onclick="xacNhanMua()">Mua ngay</button>
                <button class="btn" type="button" onclick="huyMua()">Hủy</button>
            </form>
        </div>

        <!-- thêm vào giỏ hàng -->
        <div id="add-cart" style="display:none">
            <p>Lựa chọn size và số lượng sản phẩm bạn muốn mua:</p>
            <h1 id="name-sp1">Ten san pham</h1>
            <img id="anh-sp1" src="" width="80px" height="80px"/>
            <form>
                <input type="hidden" name="maSP" id="maSP1"/>
                <h4 id="price-sp1">000 VNĐ</h4>
                <h3>Chi tiết sản phẩm</h3>
                <input type="number"id="quantity-sp1" value="1"> 
                <select id="size1">
                    <option>Size</option>
                    <option>39</option>
                    <option>40</option>
                    <option>41</option>
                </select> <br>
                <button class="btn" type="button" onclick="xacNhanAddToCart()">Thêm vào giỏ hàng</button>
                <button class="btn" type="button" onclick="huyAdd()">Hủy</button>
            </form>
        </div>
        <script>
            function sortBy() {
                var select = document.getElementById("sortSelect");
                var selectedOption = select.options[select.selectedIndex].text;
                var tagValue = "${tag}";
                if (selectedOption === "Sắp xếp theo giá") {
                    window.location = "DsSanPham?sortId=1&tag=" + tagValue;
                } else if (selectedOption === "Sắp xếp theo độ bán chạy") {
                    window.location = "DsSanPham?sortId=2&tag=" + tagValue;
                }
            }
            function buyNow(maSP, tenSP, giaSP, anhSP, moTaSP) {
                var cloneId = "clone-" + maSP;
                var options = document.querySelectorAll("#" + cloneId + " option");

                // Kiểm tra xem options có dữ liệu không
                if (options.length === 0) {
                    console.error("Không tìm thấy option cho mã SP " + maSP);
                    return;
                }

                var sizeSelect = document.querySelector("#size");

                // Kiểm tra xem phần tử có id là size có tồn tại không
                if (!sizeSelect) {
                    console.error("Không tìm thấy phần tử với id là size");
                    return;
                }

                // Xóa tất cả các option hiện có trong #size trước khi thêm mới
                sizeSelect.innerHTML = "";

                // Thêm thẻ option vào thẻ select có id là size
                for (var i = 0; i < options.length; i++) {
                    sizeSelect.appendChild(options[i].cloneNode(true));
                }
                document.getElementById("mua-ngay").style.display = "block";
                document.getElementById("name-sp").innerText = tenSP;
                document.getElementById("maSP").value = maSP;
                document.getElementById("price-sp").innerText = giaSP + " VNĐ";
                document.getElementById("anh-sp").src = anhSP;
                document.getElementById("describe-sp").innerText = moTaSP;

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

            function huyMua() {
                document.getElementById("mua-ngay").style.display = "none";
            }
            function addToCart(maSP, tenSP, giaSP, anhSP, moTaSP) {
                var cloneId = "clone-" + maSP;
                var options = document.querySelectorAll("#" + cloneId + " option");

                // Kiểm tra xem options có dữ liệu không
                if (options.length === 0) {
                    console.error("Không tìm thấy option cho mã SP " + maSP);
                    return;
                }

                var sizeSelect = document.querySelector("#size1");

                // Kiểm tra xem phần tử có id là size có tồn tại không
                if (!sizeSelect) {
                    console.error("Không tìm thấy phần tử với id là size");
                    return;
                }

                // Xóa tất cả các option hiện có trong #size trước khi thêm mới
                sizeSelect.innerHTML = "";

                // Thêm thẻ option vào thẻ select có id là size
                for (var i = 0; i < options.length; i++) {
                    sizeSelect.appendChild(options[i].cloneNode(true));
                }
                document.getElementById("add-cart").style.display = "block";
                document.getElementById("name-sp1").innerText = tenSP;
                document.getElementById("maSP1").value = maSP;
                document.getElementById("price-sp1").innerText = giaSP + " VNĐ";
                document.getElementById("anh-sp1").src = anhSP;
                document.getElementById("describe-sp1").innerText = moTaSP;
            }
            function xacNhanAddToCart() {
                var maSPInput = document.getElementById("maSP1");
                var quantityInput = document.getElementById("quantity-sp1");
                var sizeSelect = document.getElementById("size1");

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
                        window.location = "addToCart?maSP=" + maSP + "&quantity=" + quantity + "&size=" + size + "&link=DsSanPham";

                    }
                }
            }
            function huyAdd() {
                document.getElementById("add-cart").style.display = "none";
            }
        </script>
    </body>
</html>

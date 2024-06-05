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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap">

        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/login.css" />
        <link rel="stylesheet" href="css/alert.css" />
        <script
            src="https://code.jquery.com/jquery-3.6.4.min.js"
        ></script>
    </head>
    <style>
        .login-header {
            color: #fff;
            background-color: #ff523b;
            border-radius: 20px;
            padding: 10px 20px;
            max-height: 100px;
        }
    </style>
    <body>
        <div class="warning alert">
            <div class="content">
                <div class="icon">
                    <svg
                        height="50"
                        viewBox="0 0 512 512"
                        width="50"
                        xmlns="http://www.w3.org/2000/svg"
                        >
                    <path
                        fill="#fff"
                        d="M449.07,399.08,278.64,82.58c-12.08-22.44-44.26-22.44-56.35,0L51.87,399.08A32,32,0,0,0,80,446.25H420.89A32,32,0,0,0,449.07,399.08Zm-198.6-1.83a20,20,0,1,1,20-20A20,20,0,0,1,250.47,397.25ZM272.19,196.1l-5.74,122a16,16,0,0,1-32,0l-5.74-121.95v0a21.73,21.73,0,0,1,21.5-22.69h.21a21.74,21.74,0,0,1,21.73,22.7Z"
                        />
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
                    var popup = $(".warning.alert");
                    popup.css("visibility", "visible");
                    popup.css("opacity", "1");
                }

                $(".close").click(function () {
                    var popup = $(".warning.alert");
                    popup.css("visibility", "hidden");
                    popup.css("opacity", "0");
                });
            });
        </script>
        <c:if test="${not empty thongBao}">
            <c:remove var="thongBao" scope="session" />
        </c:if>
        <!-- phan header -->
        <div id="1"></div>
        <c:import url="header" /> 

        <hr class="h-hr-style" />
        <div class="h-location">
            <p class="h-location-text">
                <a href="index">Trang chủ</a> / <a href="">Tài khoản</a> /
                <a href=""> Đăng nhập</a>
            </p>
        </div>
        <hr class="h-hr-style" />
        <!--login-->
        <div class="margin-login">
            <div class="login">
                <h1 class="login-heading">Đăng nhập</h1>
                <form action="login" class="login-form" method="post">
                    <label for="UserName" class="login-label">Tên tài khoản *</label>
                    <input name="tentk" type="UserName" class="login-input" required/>

                    <label for="password" class="login-label">Mật khẩu *</label>
                    <input name="mk" type="password" class="login-input" required/>
                    <p class="errorMessage">${Message}</p>
                    <div class="checkbox-text">
                        <div class="checkbox-content">
                            <input type="checkbox" id="logCheck" />
                            <label for="logCheck" class="text">Ghi nhớ mật khẩu</label>
                        </div>

                        <a href="#" class="text">Quên mật khẩu?</a>
                    </div>

                    <button class="login-submit" name="action" value="dangNhap" type="submit"">Đăng nhập</button>
                </form>

                <p class="login-already">
                    <span>Bạn chưa có tài khoản ?</span>
                    <a href="register" class="signup-link">Đăng ký ngay</a>
                </p>
            </div>
        </div>
        <!--Phần Footer -->

        <div id="4"></div>
        <c:import url="footer.jsp" />

    </body>
</html>

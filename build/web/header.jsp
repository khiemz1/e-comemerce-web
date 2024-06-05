<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />

        <link rel="ICON" href="images/g7_minilogo.png" type="x-icon" />
        <title>HEADER</title>

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;0,500;0,600;0,800;0,900;1,100&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="css/header.css" />
    </head>
    <style>
        .search-input {
            float: right;
            padding: 13.7px 0px;
            padding-right: 300px;
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
    </style>
    <body>
        <!-- phan header -->
        <div>
            <div class="h-container">
                <div class="h-navbar">
                    <div class="logo logo-header">
                        <a href="index">
                            <img
                                src="images/g7_logo.png"
                                class="trans-img"
                                width="100px"
                                height="110px"
                                />
                        </a>
                    </div>
                    <div class="search-container">
                        <form action="search" method="post">
                            <input type="text" placeholder="Search.." value="${txt}" name="txt" class="search-input" >
                            <button type="submit" class="btn-search"><img
                                    src="images/search.png"
                                    width="15px"
                                    height="15px"
                                    /></button>
                        </form>
                    </div>

                    <nav>
                        <ul>
                            <li>
                                <a href="index" class="h-content index">Trang chủ</a>
                            </li>
                            <li>
                                <a href="DsSanPham" class="h-content DsSP"
                                   >Danh sách sản phẩm</a
                                >
                            </li>
                            <li>
                                <c:choose>
                                    <c:when test="${tentk eq 'admin'}">
                                        <a href="admin" class="h-content account-header"
                                           >${tentk}
                                            <img src="images/user.png" width="15px" height="15px"
                                                 /></a>
                                        </c:when>
                                        <c:otherwise>
                                        <a href="account" class="h-content account-header"
                                           >${tentk}
                                            <img src="images/user.png" width="15px" height="15px"
                                                 /></a>
                                    </c:otherwise>
                                </c:choose>

                            </li>
                        </ul>
                    </nav>
                    <a href="cart" class="cart"
                       ><img
                            src="images/shopping-bag.png"
                            class="trans-img"
                            width="30px"
                            height="30px"
                            /></a>
                    <a href="${link}" class="h-content login-header"
                       >${link}</a>
                </div>
            </div>
        </div>
    </body>
</html>


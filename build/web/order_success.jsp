<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>ORDER PLACED | E-COMMERCE WEBSITE BY EDYODA</title>
    <!-- favicon -->
    <link
      rel="icon"
      href="https://yt3.ggpht.com/a/AGF-l78km1YyNXmF0r3-0CycCA0HLA_i6zYn_8NZEg=s900-c-k-c0xffffffff-no-rj-mo"
      type="image/gif"
      sizes="16x16"
    />
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/4a3b1f73a2.js"></script>
    <link
      href="https://fonts.googleapis.com/css?family=Lato&display=swap"
      rel="stylesheet"
    />

    <link rel="stylesheet" href="css/orderPlaced.css" />
  </head>
  <body>
    <!-- HEADER -->
    <div id="1"></div>
    <c:import url="header"/>

    <!-- OREDER PLACED -->
    <div id="orderContainer">
      <div id="check"><i class="fas fa-check-circle"></i></div>

      <div id="aboutCheck">
        <h1>Đặt hàng thành công!</h1>
        <p>Cảm ơn bạn đã ủng hộ, đơn hàng sẽ được giao đến trong vài ngày!</p>
      </div>
    </div>
    <!-- FOOTER -->
    <div id="4"></div>
    <c:import url="footer.jsp"/>
  </body>
</html>

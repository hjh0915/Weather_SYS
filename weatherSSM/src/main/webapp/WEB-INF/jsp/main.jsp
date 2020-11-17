<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    pageContext.setAttribute("BASE_PATH", request.getContextPath());
%>

<html>

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${BASE_PATH}/static/css/bootstrap.css">

    <link rel="stylesheet" href="${BASE_PATH}/static/css/colorbox.css">

    <link rel="stylesheet" href="${BASE_PATH}/static/css/my.css">

    <title>全国城市天气分布</title>

    <style>
      /*--------------------------------------------------------------
      # Footer
      --------------------------------------------------------------*/
      #footer a {
        color: #2dc997;
      }

      #footer {
        background: #343b40;
        padding: 30px 0;
        color: #fff;
        font-size: 14px;
        margin-top: 30px;
      }

      #footer .copyright {
        text-align: center;
      }

      #footer .credits {
        padding-top: 10px;
        text-align: center;
        font-size: 13px;
        color: #ccc;
      }
    </style>

  </head>

  <body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#"><img src="${BASE_PATH}/static/img/logo.png"/></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
        aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">首页<span class="sr-only">(current)</span></a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${BASE_PATH}/cityByName" method="get">
          <input class="form-control mr-sm-2" name="cityname" type="text" placeholder="搜索" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
        </form>
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1 class="display-3">全国城市天气预报</h1>
        <p>中国大部分省份城市未来7天的天气情况......</p>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row"></div>
      <div class="d-flex justify-content-center" style="margin-top: 20px;">
        <div class="fixed_sitemap">
          <div class="d-flex justify-content-start flex-wrap">
            <c:forEach var="province" items="${requestScope.provinces}">
            <div class="sitemap_con">
              <strong>
                <a href="#">${province.name}</a>
              </strong>
              <div class="d-flex flex-wrap">
                <c:forEach var="city" items="${province.cities}">
                <a class="inline" href="city?citycode=${city.code}">${city.cname}</a>
                </c:forEach>
              </div>
            </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </div>

    <!--==========================
          Footer
    ============================-->
    <footer id="footer">
      <div class="footer-top">
      <div class="container">

      </div>
      </div>

      <div class="container">
      <div class="copyright">
          &copy; 部分图片来源于 <a href="http://www.baidu.com">baidu</a> 搜索
      </div>
      <div class="credits">
          <!--
          All the links in the footer should remain intact.
          You can delete the links only if you purchased the pro version.
          Licensing information: https://bootstrapmade.com/license/
          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Regna
          -->
          设计者: 2018届 <a href="https://bootstrapmade.com/">HJH</a>
      </div>
      </div>
    </footer><!-- #footer -->
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="${BASE_PATH}/static/js/jquery-3.4.1.min.js"></script>
    <script src="${BASE_PATH}/static/js/jquery.colorbox.js"></script>
    <script src="${BASE_PATH}/static/js/bootstrap.js"></script>

    <script>
      $(function() {
        $(".inline").colorbox({width: "800px", height: "500px"});
      });
    </script>
  </body>

</html>
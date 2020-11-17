<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%
    pageContext.setAttribute("BASE_PATH", request.getContextPath());
%>

<html>
    <head>
        <meta charset="utf-8">
        <title>首页</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Bootstrap CSS File -->
        <link href="static/css/bootstrap.min.css" rel="stylesheet">

        <!-- Main Stylesheet File -->
        <link href="static/css/style.css" rel="stylesheet">
    </head>

    <body>

    <!--==========================
    Header
    ============================-->
    <header id="header">
        <div class="container">
            <nav id="nav-menu-container">
                <ul class="nav-menu">
                <li class="menu-active"><a href="#">首页</a></li>
                <li><a href="adminLogin.jsp">管理员登录</a></li>
                <li><a href="reg.jsp">新用户注册</a></li>
                <li><a href="userLogin.jsp">用户登录</a></li>
                </ul>
            </nav><!-- #nav-menu-container -->
        </div>
    </header><!-- #header -->

    <!--==========================
        Hero Section
    ============================-->
    <section id="hero">
        <div class="hero-container">
        <h1>欢迎您！</h1>
        <h2>查看全国天气预报</h2>
        <a href="all" class="btn-get-started">一起去看看</a>
        </div>
    </section><!-- #hero -->

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

    </body>
</html>
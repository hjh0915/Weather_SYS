<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%
    pageContext.setAttribute("BASE_PATH", request.getContextPath());
%>

<html>

    <head>
        <title>注册</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.5">

        <!-- Bootstrap core CSS -->
        <link href="static/css/bootstrap.css" rel="stylesheet">


        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
        <link href="static/css/signin.css" rel="stylesheet">
    </head>

    <body>
        <form class="form-signin" name="form2" action="${BASE_PATH}/user/reg" method="post">
            <img class="mb-4" src="static/img/bootstrap-solid.svg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">注册</h1>
            <label for="inputEmail" class="sr-only">姓名</label>
            <input type="text" id="uname" name="uname" class="form-control" placeholder="姓名" required autofocus>
            <label for="inputPassword" class="sr-only">密码</label>
            <input type="password" id="upwd" name="upwd" class="form-control" placeholder="密码" required>
            <label for="inputEmail" class="sr-only">所在地</label>
            <input type="text" id="ucity" name="ucity" class="form-control" placeholder="所在地" required autofocus>市（/区/县）
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="注册">
        </form>
    </body>
</html>
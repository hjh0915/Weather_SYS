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

        <title>城市天气预报</title>

        <style>
            td, p {
                font-size: 14px;
            }

            .container {
                width: 600px;
                margin-top: 30px;
            }

            .row {
                margin-top:20px;
            }

            table td {
                font-size: 0.8rem;
            }

            .hours {
                font-size: 0.8rem;
            }

            .hours p {
                margin-bottom: 0.25rem;
            } 

            h3 + p {
                font-size:12px;
                margin-bottom:5px;
            }
        </style>

    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <h3 class="text-center">${weather.getCity()} ${today.wea} ${today.tem}</h3>
                    <p style="font-size: 16px;" class="text-center font-italic">更新时间: ${weather.getUpdate_time()}</p>
                </div>
            </div>


            <div class="row">
                <c:forEach var="x" items="${requestScope.today.hours}">
                <div class="col hours">
                    <p>${x.getTime()}</p>
                    <p>${x.wea}</p>
                    <p>${x.tem}</p>
                </div>
                </c:forEach>
            </div>

            <div class="row">
                <div class="col">
                    <table class="table table-hover">
                        <tbody>
                            <c:forEach var="y" items="${requestScope.weather.getNotToday()}">
                            <tr>
                                <td>${y.day}</td>
                                <td>${y.wea}</td>
                                <td class="text-right">${y.tem1}/${y.tem2}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="${BASE_PATH}/static/js/jquery-3.4.1.min.js"></script>
        <script src="${BASE_PATH}/static/js/bootstrap.js"></script>
    </body>

</html>
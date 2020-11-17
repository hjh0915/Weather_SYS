<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("BASE_PATH", request.getContextPath());
%>

<html>
    <head>
        <title>管理用户页</title>
        <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            // 删除
            function deleteUser(uname) {
                if(confirm("确定要删除名字为【"+uname+"】的用户吗？")==true) {
                    var url="${BASE_PATH}/admin/deleteUser";

                    $.post(url, {uname:uname}, function (data, status) {
                        alert(data);
                        deleteUsercallback(data, status);
                    });
                }
            }
            function deleteUsercallback(data, status) {
                if("success"==status) {
                    if(data=="success") {
                        alert("删除成功！");
                        window.location.reload();
                    }else {
                        alert("删除失败！请重试或联系管理员！");
                    }
                }
            }

            // 修改
            function getInfo(uname, upwd, ucity) {
                alert(uname);
                //input中的id和name要与此一致！
                document.getElementById("uname1").value = uname;
                document.getElementById("upwd1").value = upwd;
                document.getElementById("ucity1").value = ucity;
            }

            
            function updateUser() {
                var uname = document.getElementById("uname1").value;
                var upwd = document.getElementById("upwd1").value;
                var ucity = document.getElementById("ucity1").value;

                if(confirm("确定要修改名字为【"+uname+"】的用户吗？") == true) {
                    var url="${BASE_PATH}/admin/updateUser";

                    $.post(url, {uname:uname, upwd:upwd, ucity:ucity}, function (data, status) {
                        alert(data);
                        updateUsercallback(data,status);
                    });
                }
            }
            function updateUsercallback(data, status) {
                if("success" == status) {
                    if(data == "success") {
                        alert("修改成功！");
                        window.location.reload();
                    }else {
                        alert("修改失败！请重试或联系管理员！");
                    }
                }
            }
        </script>

        <style>
            .nav ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
                position: fixed;
                top: 0;
                width: 100%;
            }

            .nav ul li {
                float: right;
                padding-right: 80px;
            }

            .nav ul li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            .nav ul li a:hover {
                background-color: #4CAF50;
            }

            .nav ul li .active {
                background-color: #4CAF50;
            }
        </style>
    </head>

    <body>
        <div class="nav">
            <ul>
                <li><a href="${BASE_PATH}/all">查看全国天气</a></li>
                <li><a class="active" href="${BASE_PATH}/index.jsp">首页</a></li>
            </ul>
        </div>

        <div style="margin: auto;padding-top: 80px;width: 800px;">
            <table class="table table-bordered table-hover">
                <caption style="text-align: center">用户信息表</caption>
                <thead>
                <tr>
                    <th>用户名字</th>
                    <th>用户密码</th>
                    <th>用户所在地</th>
                    <th>修改</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="user">
                    <tr>
                        <td>${user.uname}</td>
                        <td>${user.upwd}</td>
                        <td>${user.ucity}</td>
                        <td>
                            <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" onclick="getInfo('${user.uname}','${user.upwd}','${user.ucity}')">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>
                                修改
                            </button>
                        </td>
                        <td>
                            <button class="btn btn-danger btn-sm" onclick="deleteUser('${user.uname}')">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>
                                删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="row">
                <div class="col-md-6">
                    第${pageInfo.pageNum}页，共${pageInfo.pages}页，共${pageInfo.total}条记录
                </div>

                <div class="col-md-6 offset-md-4" style="text-align: right">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination pagination-sm">
                            <li class="page-item"><a class="page-link" href="${BASE_PATH}/admin/listUser?page=1">首页</a></li>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                <c:if test="${page==pageInfo.pageNum}">
                                    <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                                </c:if>
                                <c:if test="${page!=pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                            href="${BASE_PATH}/admin/listUser?page=${page}">${page}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pageInfo.hasNextPage}">
                                <li class="page-item"><a class="page-link"
                                                        href="${BASE_PATH}/admin/listUser?page=${pageInfo.pageNum+1}">下一页</a></li>
                            </c:if>
                            <li class="page-item"><a class="page-link" href="${BASE_PATH}/admin/listUser?page=${pageInfo.pages}">末页</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            修改用户信息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="uname1">
                        <div class="input-group">
                            <span class="input-group-addon">密码</span>
                            <input id="upwd1" name="upwd1" type="text" class="form-control" placeholder="请输入密码">
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon">所在地市（/区/县）</span>
                            <input id="ucity1" name="ucity1" type="text" class="form-control" placeholder="请输入所在地市（/区/县）">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-primary" onclick="updateUser()">
                            确认修改
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </body>
</html>
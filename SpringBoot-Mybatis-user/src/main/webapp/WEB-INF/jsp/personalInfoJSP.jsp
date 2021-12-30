<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>旧书买卖系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/modernizr.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.html">首页</a></li>
                <li><a href="index.html" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="index.html">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">


    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><span>欢迎使用『旧书买卖系统』。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="changePersonalInfo.html">修改用户信息</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>用户基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">UID</label>
                        <span class="res-info" id="uidPer">${loginUid}</span>
                    </li>
                    <li>
                        <label class="res-lab">用户名</label>
                        <span class="res-info" id="userNamePer">${LoginUserName}</span>
                    </li>
                    <li>
                        <label class="res-lab">密码</label>
                        <span class="res-info" id="passwordPer">${loginPassword}</span>
                    </li>
                    <li>
                        <label class="res-lab">联系方式</label>
                        <span class="res-info" id="telPer">${loginTel}</span>
                    </li>
                    <li>
                        <label class="res-lab">地址</label>
                        <span class="res-info" id="addressPer">${loginAddress}</span>
                    </li>
                </ul>


            </div>


        </div>



        <div class="result-wrap">
            <form method="post">
                <div class="result-title">
<%--                    <button class="submit">--%>
<%--                        <input type="submit" value="注销当前账号" name="UserMethod" onclick="location.href=('login.html')"/>--%>
<%--                    </button>--%>
                    <button type="button" name="deleteBtn" onclick="deleteUser()">注销当前账号</button>

                </div>
                <div class="result-content">
                    <ul class="sys-info-list">

                        <li>

                        </li>
                    </ul>
                </div>
            </form>
        </div>


        <script>
            function deleteUser(){
                var deleteId=${loginId};
                alert("注销账号"+deleteId);
                $.ajax({
                    type: 'DELETE',
                    url: 'http://localhost:9090/user/'+deleteId,
                    success:function(){
                        alert("注销账号 "+deleteId+" 成功");
                        window.location = "login.html";
                    },
                    failure:function(){alert("注销失败"); }
                })
            }
        </script>


    </div>
    <!--/main-->
</div>


<style>
    .copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
</body>
</html>

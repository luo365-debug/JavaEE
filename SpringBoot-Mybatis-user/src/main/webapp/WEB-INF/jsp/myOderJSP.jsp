<%--
  Created by IntelliJ IDEA.
  User: pro14
  Date: 2021/12/26
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>买书</title>
    <link rel="stylesheet" type="text/css" href="css/upload.css"/>
    <link rel="stylesheet" type="text/css" href="css/reset.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.js"></script>
</head>
<body>
<!-- 导航条 -->
<header class="navbar">
    <div class="nav-info">
        <a href="http://localhost:9090/personalInfoJSP" class="username">${LoginUserName}</a>
        <a href="http://localhost:9090/personalInfoJSP" class="bookshelf">||&nbsp;&nbsp;&nbsp;个人信息</a>
        <a href="login.html" class="logout">[ 退 出 ]</a>
    </div> <!-- nav-info -->
    <form class="nav-search">
        <a href="login.html"><img class="logo" src="img/logo.jpg"></a>
        <div class="search-form">
            <a href="#" class="search-logo">| &nbsp;<img src="img/search.png"></a>
            <input type="search" class="searchIn" placeholder="搜图书...">
            <button class="searchBtn">搜索</button>
        </div>
    </form><!--  nav-search -->
    <ul class="menu">
        <li><a href="index.html">首页</a></li>
        <li><a href="http://localhost:9090/cartJSP">购物车</a></li>
        <li><a href="http://localhost:9090/releaseBookJSP">发布图书</a></li>
        <li><a class="active" href="http://localhost:9090/myOderJSP">我的订单</a></li>
    </ul>
</header>
<!-- <div class="titleName">
    <h3>发布求购信息</h3>
</div> -->

<!-- <div class="ask container">
    <form>
        <p>
            <span class="pic-icon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            上传书图片： <input type="file" name="book-pic">
        </p>
        <p>
            <span class="name-icon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="book-name">
        </p>
        <p>
            <span class="author-icon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：<input type="text" name="book-author">
        </p>
        <p>
            <span class="press-icon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            出&nbsp;&nbsp;&nbsp;&nbsp;版&nbsp;&nbsp;&nbsp;社：<input type="text" name="book-press">
        </p>
        <input type="submit" class="submit-btn" name="book-submit">
    </form>
</div> -->
<div class="container">
    <div class="title">
        &nbsp;<input type="checkbox">&nbsp;全选
        <span class="title-name">商品名称</span>
        <span class="title-price">单价</span>
        <span class="title-num">数量</span>
        <span class="title-prices">小计</span>
        <span class="title-operation">操作</span>
    </div>
    <div class="book-order">
        <ul class="book-lists" id="B_Lists">

            <li class="book-list">
                <input type="checkbox" class="cb">
                <span class="book-pic">
						<img src="img/book-list/article/1.jpg">
					</span>
                <span class="book-info">
						<h5 class="book-name">三国志</h5>
						<span class="book-detail">陈寿 著 / 南海出版公司 / 2008-09 / 平装</span>
					</span>
                <span class="book-price">
						￥20
					</span>
                <span class="book-num">
						1
					</span>
                <span class="book-prices">
						￥20
					</span>
                <span class="delete">
						<a href="#" onclick="delOrder(0,3)">删除</a>
					</span>
            </li>

            <li class="book-list">
                <input type="checkbox" class="cb">
                <span class="book-pic">
						<img src="img/book-list/article/5.jpg">
					</span>
                <span class="book-info">
						<h5 class="book-name">神曲</h5>
						<span class="book-detail">但丁 著/ 燕山出版公司 / 2005-07 / 平装</span>
					</span>
                <span class="book-price">
						￥10
					</span>
                <span class="book-num">
						2
					</span>
                <span class="book-prices">
						￥20
					</span>
                <span class="delete">
						<a href="#" onclick="delOrder(1,4)">删除</a>
					</span>
            </li>


        </ul>
    </div>
</div>
<footer>
    <a href="#">©2020-2021 二手书交易</a>
    <a href="#">意见反馈&nbsp;&nbsp;&nbsp;联系我们&nbsp;&nbsp;&nbsp;隐私权声明&nbsp;&nbsp;&nbsp;使用条款</a>
</footer>

<script>
    function delOrder(liNum,sId){
        alert("liNum "+liNum+"  sId "+sId);
        var ul = document.querySelector("#B_Lists");
        var list = ul.querySelectorAll("li");
        list[liNum].remove();
        $.ajax({
            "url": "http://localhost:9090/shoppingcart/"+sId,
            "type": "DELETE",
            /*"data":{_method:"DELETE"},*/
            success:function (){alert("取消订单成功");},
            failure:function (){alert("取消失败"); }
        })
    }
</script>



</body>
</html>

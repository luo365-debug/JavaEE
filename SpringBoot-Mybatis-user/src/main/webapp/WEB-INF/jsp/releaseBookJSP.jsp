<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>求书区</title>
  <link rel="stylesheet" type="text/css" href="css/book.css"/>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.js"></script>
</head>
<body>
<!-- 导航 -->
<header class="navbar">
  <div class="nav-info">
    <a href="http://localhost:9090/personalInfoJSP" class="username">${LoginUserName}</a>
    <a href="http://localhost:9090/personalInfoJSP" class="bookshelf">||&nbsp;&nbsp;&nbsp;个人信息</a>
    <a href="login.html" class="logout">[ 退 出 ]</a>
  </div> <!-- nav-info -->
  <form class="nav-search">
    <a href="index.html"><img class="logo" src="img/logo.jpg"></a>
    <div class="search-form">
      <a href="#" class="search-logo">| &nbsp;<img src="img/search.png"></a>
      <input type="search" class="searchIn" placeholder="搜图书...">
      <button class="searchBtn">搜索</button>
    </div>
  </form><!--  nav-search -->
  <ul class="menu">
    <li><a href="index.html">首页</a></li>
    <li><a href="http://localhost:9090/cartJSP">购物车</a></li>
    <li><a class="active" href="http://localhost:9090/releaseBookJSP">发布图书</a></li>
    <li><a href="http://localhost:9090/myOderJSP">我的订单</a></li>
  </ul>
</header>
<!-- 图书分类 -->
<div id="container">
  <div id="book-container">
    <h3 class="book-title"><a href="#">| 我的图书</a></h3>

    <ul class="book-lists" id="bookLists">
<%--      <li class="book-list">
        <a href="#" class="book-pic">
          <img src="img/book-list/article/10.jpg">
        </a>
        <a href="#" class="book-info askbook-info">
          <h5 class="book-name">白夜行</h5>
          <span class="book-auto">东野圭吾 著 </span>
          <span class="book-press">南海出版公司 / 2008-09 / 平装</span>
        </a>
        <a href="#" class="book-contact">立即联系求书者</a>
      </li>

      <li class="book-list">
        <a href="#" class="book-pic">
          <img src="img/book-list/article/11.jpg">
        </a>
        <a href="#" class="book-info askbook-info">
          <h5 class="book-name">围城</h5>
          <span class="book-auto">钱钟书 著 </span>
          <span class="book-press">晨光出版公司出版社 / 1947-03 / 平装</span>
        </a>
        <a href="#" class="book-contact">立即联系求书者</a>
      </li>

      <li class="book-list">
        <a href="#" class="book-pic">
          <img src="img/book-list/article/12.jpg">
        </a>
        <a href="#" class="book-info askbook-info">
          <h5 class="book-name">钢铁是怎样炼成的</h5>
          <span class="book-auto">尼古拉奥斯特洛夫斯基 著 </span>
          <span class="book-press">四川文艺出版社  / 1996-08 / 平装</span>
        </a>
        <a href="#" class="book-contact">立即联系求书者</a>
      </li>

      <li class="book-list">
        <a href="#" class="book-pic">
          <img src="img/book-list/article/13.jpg">
        </a>
        <a href="#" class="book-info askbook-info">
          <h5 class="book-name">鲁迅</h5>
          <span class="book-auto">鲁迅 著 </span>
          <span class="book-press">新华出版社 / 1978-09 / 平装</span>
        </a>
        <a href="#" class="book-contact">立即联系求书者</a>
      </li>

      <li class="book-list">
        <a href="#" class="book-pic">
          <img src="img/book-list/article/14.jpg">
        </a>
        <a href="#" class="book-info askbook-info">
          <h5 class="book-name">昆虫记</h5>
          <span class="book-auto">东野圭吾 著 </span>
          <span class="book-press">四川文艺出版社出版 / 1907-04 / 平装</span>
        </a>
        <a href="#" class="book-contact">立即联系求书者</a>
      </li>

      <li class="book-list">
        <a href="#" class="book-pic">
          <img src="img/book-list/article/15.jpg">
        </a>
        <a href="#" class="book-info askbook-info">
          <h5 class="book-name">人间话</h5>
          <span class="book-auto">王国维 著 </span>
          <span class="book-press">江苏古籍出版社出版 / 1965-04 / 平装</span>
        </a>
        <a href="#" class="book-contact">立即联系求书者</a>
      </li>--%>

    </ul><!--  book-list end -->
  </div> <!-- book-container end-->

  <span class="page-btn">
			<a href="#" class="page-top">首页</a>
			<a href="#" class="page-pre">上一页</a>
			<a href="#" class="page-next">下一页</a>
			<a href="#" class="page-end">尾页</a>
		</span>



</div><!-- container end-->

<!-- 脚本 -->
<footer>
  <a href="#">©2020-2021 二手书交易</a>
  <a href="#">意见反馈&nbsp;&nbsp;&nbsp;联系我们&nbsp;&nbsp;&nbsp;隐私权声明&nbsp;&nbsp;&nbsp;使用条款</a>
</footer>

<script>
  $(document).ready(function () {
    showBookList();
  })

  function showBookList(){
    var owner=${loginId};
    /*alert("账号"+owner+" 的藏书");*/
    $.ajax({
      "url": "http://localhost:9090/shoppingcart/"+owner,
      "type": "GET",
      "dataType": "json",
      success:function(dataBooks){
        for (var i = 0; i < dataBooks.length; i++){

          var bookId=dataBooks[i].book.bId;
          var bookNme=dataBooks[i].book.bName;
          var author=dataBooks[i].book.author;

          var oLi = document.createElement("li");
          oLi.className="book-list";
          oLi.innerHTML = '<a href="#" class="book-pic">'+
                  '<img src="img/book-list/article/'+bookId+'.jpg">'+
                  '</a>'+
                  '<a href="#" class="book-info askbook-info">'+
                  '<h5 class="book-name">'+bookNme+'</h5>'+
                  ' <span class="book-auto">'+author+' 著 </span>'+
                  '</a>'+
                  '<a href="#" class="book-contact">立即联系求书者</a>';
          document.getElementById("bookLists").appendChild(oLi);
        }
      },
      failure:function(){alert("查询当前账号拥有的书籍失败"); }
    })
  }
</script>



</body>
</html>

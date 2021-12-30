<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: pro14
  Date: 2021/12/26
  Time: 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="defaultLanguage" content="en-US"/>
    <meta name="availableLanguages" content="en-US, zh-CN"/>
    <!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />-->
    <title>书籍良品</title>
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
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
        <li><a class="active" href="http://localhost:9090/cartJSP">购物车</a></li>
        <li><a href="http://localhost:9090/releaseBookJSP">发布图书</a></li>
        <li><a href="http://localhost:9090/myOderJSP">我的订单</a></li>
    </ul>
</header>
<!-- 图书分类 -->
<div id="container">
    <div id="book-menu">
        <ul class="book-class">
            <li><a href="#article" title="article">小说 / 文学 / 语言文字</a></li>
            <li><a href="#technology" title="technology">工程技术 / 互联网</a></li>
            <li><a href="#">历史 / 地理 / 艺术</a></li>
            <li><a href="#">政治 / 法律 / 军事</a></li>
            <li><a href="#">哲学 / 心理 / 宗教</a></li>
            <li><a href="#">经济 / 社科 / 综合</a></li>
            <li><a href="#">童书 / 生活 / 体育</a></li>
            <li><a href="#">教材 / 教辅 / 考试</a></li>

            <li><a href="#">自然科学 / 医药卫生</a></li>
        </ul>
    </div>
    <div id="book-menu-toggle">
        查 看 菜 单
        <div id="toggle-btn"></div>
    </div>
    <div id="book-container">
        <h3 class="book-title"><a href="#">| 我的购物车</a></h3>
        <ul class="book-lists">

            <li class="book-list">
                <a href="#" class="book-pic">
                    <img src="img/book-list/article/7.jpg">
                </a>
                <a href="#" class="book-info">
                    <h5 class="book-name">Python人脸识别：<br>从入门到工程实践 </h5>
                    <span class="book-detail">王天庆 著 / 上海图书出版公司 / 2011-10 / 平装</span>
                </a>
                <span class="book-price" id="book-7">￥13.8
                    <!--<a href="#" class="book-buy">立即下单</a>-->
						<input name="addBookId" class="book-buy" value="下单" type="submit" onclick="add(7,13.8)"/>
					</span>
            </li>

            <li class="book-list">
                <a href="#" class="book-pic">
                    <img src="img/book-list/article/8.jpg">
                </a>
                <a href="#" class="book-info">
                    <h5 class="book-name">神经网络与深度学习实战：<br>Python+Keras+TensorFlow</h5>
                    <span class="book-detail">陈屹 著 / 译林出版社 / 2016-06 / 平装</span>
                </a>
                <span class="book-price">￥10.8
						<%--<a href="#" class="book-buy">立即下单</a>--%>
                    <input name="addBookId" class="book-buy" value="下单" type="submit" onclick="add(8,10.8)"/>
					</span>
            </li>

            <li class="book-list">
                <a href="#" class="book-pic">
                    <img src="img/book-list/article/9.jpg">
                </a>
                <a href="#" class="book-info">
                    <h5 class="book-name">机器学习：<br>实用案例解析</h5>
                    <span class="book-detail">德鲁 康威 作者 / 世界图书出版社 / 2004-05 / 平装</span>
                </a>
                <span class="book-price">￥12.1
						<%--<a href="#" class="book-buy">立即下单</a>--%>
                    <input name="addBookId" class="book-buy" value="下单" type="submit" onclick="add(9,12.1)"/>
					</span>
            </li>
            <li class="book-list">
                <a href="#" class="book-pic">
                    <img src="img/book-list/article/6.jpg">
                </a>
                <a href="#" class="book-info">
                    <h5 class="book-name">SpringBoot揭秘：<br>快速构建微服务体系 </h5>
                    <span class="book-detail">王福强等 著 / 机械工业出版社 / 2017-01 / 平装</span>
                </a>
                <span class="book-price">￥12.9
						<%--<a href="#" class="book-buy">立即下单</a>--%>
                    <input name="addBookId" class="book-buy" value="下单" type="submit" onclick="add(6,12.9)"/>
					</span>
            </li>
            <li class="book-list">
                <a href="#" class="book-pic">
                    <img src="img/book-list/article/4.jpg">
                </a>
                <a href="#" class="book-info">
                    <h5 class="book-name">瓦尔登湖</h5>
                    <span class="book-detail">亨利 戴维 梭罗 作者 / 上海文艺出版社 / 2004-05 / 平装</span>
                </a>
                <span class="book-price">￥20.3
						<%--<a href="#" class="book-buy">立即下单</a>--%>
                    <input name="addBookId" class="book-buy" value="下单" type="submit" onclick="add(4,20.3)"/>
					</span>
            </li>

            <li class="book-list">
                <a href="#" class="book-pic">
                    <img src="img/book-list/article/5.jpg">
                </a>
                <a href="#" class="book-info">
                    <h5 class="book-name">神曲</h5>
                    <span class="book-detail">但丁 著；/ 北京燕山出版社 / 2005-07 / 平装</span>
                </a>
                <span class="book-price">￥11.2
						<%--<a href="#" class="book-buy">立即下单</a>--%>
                    <input name="addBookId" class="book-buy" value="下单" type="submit" onclick="add(5,11.2)"/>
					</span>
            </li>
            <li class="book-list">
                <a href="#" class="book-pic">
                    <img src="img/book-list/article/2.jpg">
                </a>
                <a href="#" class="book-info">
                    <h5 class="book-name">东京梦华录</h5>
                    <span class="book-detail">孟元老 著 / 湖北图书出版社 / 2011-10 / 平装</span>
                </a>
                <span class="book-price">￥27.3
						<%--<a href="#" class="book-buy">立即下单</a>--%>
                    <input name="addBookId" class="book-buy" value="下单" type="submit" onclick="add(2,27.3)"/>
					</span>
            </li>

            <li class="book-list">
                <a href="#" class="book-pic">
                    <img src="img/book-list/article/3.jpg">
                </a>
                <a href="#" class="book-info">
                    <h5 class="book-name">红字</h5>
                    <span class="book-detail">纳撒尼尔 霍桑 著 / 译林出版社 / 2006-06 / 平装</span>
                </a>
                <span class="book-price">￥22.4
						<%--<a href="#" class="book-buy">立即下单</a>--%>
                    <input name="addBookId" class="book-buy" value="下单" type="submit" onclick="add(3,22.4)"/>
					</span>
            </li>
        </ul><!--  book-list end -->
    </div> <!-- book-container end-->
    <span class="page-btn">
			<a href="#" class="page-top">首页</a>
			<a href="#" class="page-pre">上一页</a>
			<a href="#" class="page-next">下一页</a>
			<a href="#" class="page-end">尾页</a>
		</span>
</div><!-- container end-->
<footer>
    <a href="#">©2020-2021 二手书交易</a>
    <a href="#">意见反馈&nbsp;&nbsp;&nbsp;联系我们&nbsp;&nbsp;&nbsp;隐私权声明&nbsp;&nbsp;&nbsp;使用条款</a>
</footer>
<script type="text/javascript" src="js/jquery-3.2.js"></script>
<script type="text/javascript">
    $(function(){
        //菜单特效
        var index = 0
        $("#book-menu-toggle").on("click",function(){
            if (index ===0 ) {
                $("#book-menu").css("left","1px");
                $(this).css("left","178px");
                index =1;
            }else{
                $("#book-menu").css("left","-180px");
                $(this).css("left","1px");
                index=0;
            }
        });

        //点击菜单，对应类别颜色加深
        $(".book-class li").on("click",function(){
            //加粗当前点击的li
            $(this).css("font-weight","600").siblings("li").css("font-weight","500");
        });
    })
</script>

<span id="buyerName" style="display: none">${loginId}</span>
<script>
    function add(num,price){
        var buyerId=document.getElementById("buyerName").innerText;
        alert(buyerId+" 选择购买书籍"+num+" 单价"+price);

        //虚拟表单提交
        var temp = document.createElement("form");
        temp.method = "post";//也可指定为get
        temp.style.display = "none";
        var opt = document.createElement("input");
        opt.name = "bookId";
        opt.value = num;
        temp.appendChild(opt);
        var optP = document.createElement("input");
        opt.name = "price";
        opt.value = price;
        temp.appendChild(optP);
        document.body.appendChild(temp);
        temp.submit();

        <%
        Map<String,Object> map = new HashMap<String,Object>();//创建Map对象，Object是所有类型的父类
        map.put("price",request.getParameter("price"));//存储key和value
        map.put("b_id",request.getParameter("bookId"));
        /*map.put("u_id",status);*/
        map.put("u1_id",request.getSession().getAttribute("loginId"));
        %>


        var dataMap="<%=map%>";
        alert(dataMap);
        // var dataJson = new JSONObject(dataMap);
        // alert(dataJson);
        /*var dataMap="{\"b_id=\""+num+"\",price=\""+price+"\",u1_id=\""+buyerId+"}";*/


        $.ajax({
            "url": "http://localhost:9090/shoppingcart",
            "type": "post",
            "data": dataMap,
            success:function (res) { alert(res);}
        })
    }
</script>
</body>
</html>

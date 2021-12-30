<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="changePersonalInfo.aspx.cs" Inherits="WebRestClient.change" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>二手书交易系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    　
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.aspx" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.aspx">首页</a></li>
               <%-- <li><a href="#" target="_blank">网站首页</a></li>--%>
            </ul>
        </div>
        <div class="top-info-wrap">
           <%-- <ul class="top-info-list clearfix">
                <li><a href="#">管理员</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">退出</a></li>
            </ul>--%>
        </div>
    </div>
</div>
<div class="container clearfix">
 
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
           <%-- <div class="crumb-list"><i class="icon-font"></i><a href="personalInfo.aspx">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">系统设置</span></div>--%>
         <div class="crumb-list"><i class="icon-font"></i><a href="personalInfo.aspx">返回</a></div>
		</div>
        <div class="result-wrap">
            <form action="#" method="post" id="myform" name="myform"  runat="server">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>用户信息修改</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody>
                             
                            <tr>
                                <th width="15%"><i class="require-red">*</i>Id：</th>
                                <td><input asp:Text ID="id" runat="server" type="text"  value="1" size="85" name="keywords" class="common-text" readonly ="true"></td>
                            </tr>
                            <tr>
                                <th width="15%"><i class="require-red">*</i>Uid：</th>
                                <td><input asp:Text ID="uid" runat="server" type="text"  value="2019302110218" size="85" name="keywords" class="common-text"></td>
                            </tr>
                            <tr>
                                <th width="15%"><i class="require-red">*</i>用户名：</th>
                                <td><input asp:Text ID="name" runat="server" type="text"  value="xlf" size="85" name="keywords" class="common-text"></td>
                            </tr>
                                <tr>
                                    <th><i class="require-red">*</i>密码：</th>
                                    <td><input asp:TextBox ID="password" runat="server" type="text"  value="12345678" size="85" name="title" class="common-text"/></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red">*</i>联系方式：</th>
                                    <td><input asp:TextBox runat="server" ID="tel" type="text" value="13623116586" size="85" name="keywords" class="common-text"/></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red">*</i>地址：</th>
                                    <td><input asp:TextBox runat="server" ID="address" type="text" value="湖北省武汉大学信息学部" size="85" name="description" class="common-text"/></td>
                                </tr>
                                
                                <tr>
                                    <th></th>
                                    <td>
                                        <input asp:button ID="submit1" runat="server" type="submit" value="提交" class="btn btn-primary btn6 mr10" onserverclick="SubmitInfo"/>
                                        <input type="button" value="返回" onclick="history.go(-1)" class="btn btn6"/>
                                    </td>
                                </tr>
                            </tbody></table>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>

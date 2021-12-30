<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="WebRestClient.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>login</title>
    <link rel="stylesheet" href="css/LoginStyle.css"/>
</head>
<body>
    <form id="form1" runat="server">
        <div class="content">
        <div class="form sign-in">
            <h2>欢迎回来</h2>
            <label>
                <span>id</span>
                <input id="id" runat="server" type="text" value=""/>
            </label>
            <label>
                <span>密码</span>
                <input id="password" runat="server" type="text" value=""/>
            </label>
            <p class="forgot-pass"><a href="#">忘记密码？</a></p>
            <asp:Button id="signin" text="登陆" CssClass="submit" runat="server" OnClick="SignIn"/>
<%--            <button type="button" class="submit">登 录</button>--%>
        </div>
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h2>还未拥有账号</h2>
                    <p>立即前往注册</p>
                </div>
                <div class="img__text m--in">
                    <h2>已经拥有帐号</h2>
                    <p>返回登录</p>
                </div>
                <div class="img__btn">
                    <span class="m--up">注 册</span>
                    <span class="m--in">登 录</span>
                </div>
            </div>
            <div class="form sign-up">
                <h2>立即注册</h2>
                
                <label>
                    <span>Uid</span>
                    <input type="text" runat="server" id="newuid"/>
                </label>
                <label>
                    <span>用户名</span>
                    <input type="text" runat="server" id="newuser"/>
                </label>
                <label>
                    <span>手机号</span>
                    <input type="text" runat="server" id="newtel"/>
                </label>
                <label>
                    <span>密码</span>
                    <input type="text" runat="server" id="newpass"/>
                </label>
                <label>
                    <span>地址</span>
                    <input type="text" runat="server" id="newaddress"/>
                </label>
                
<%--                <asp:Button ID="signup" cssclass="submit" runat="server" onserverclick="SignUp" value="注册" />--%>
                    <asp:Button id="signup" text="注册" CssClass="submit" runat="server" OnClick ="SignUp"/>
<%--                <button type="button" class="submit">注 册</button>--%>
            </div>
        </div>
    </div>
    <script src="js/LoginScript.js"></script>
	<div style="text-align:center;"></div>
    </form>
</body>
</html>

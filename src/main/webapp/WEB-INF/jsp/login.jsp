<%@ page import="com.zhxh.admin.entity.SystemUser" %>
<%@ page import="com.zhxh.admin.logic.AuthenticateLogic" %>
<%@ page import="com.zhxh.core.utils.Logger" %>
<%@ page import="com.zhxh.core.env.SysEnv" %>
<%@ page pageEncoding="UTF-8" %>
<%
    String errorMessage = "";
    AuthenticateLogic authenticateLogic = (AuthenticateLogic) SysEnv.getBean("authenticateLogic");
    if (request.getMethod().toLowerCase().equals("post")) {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        SystemUser user = new SystemUser();
        user.setUserId(userId);
        user.setPassword(password);
        try {
            authenticateLogic.authenticate(user);
            String url = SysEnv.getAppRoot() + SysEnv.getUrlAppIndex();
            response.sendRedirect(url);
        } catch (Exception e) {
            errorMessage = e.getMessage();
            Logger.info(errorMessage);
        }
    } else if ("logout".equals(request.getParameter("action"))) {
        authenticateLogic.kickOffUser();
        response.sendRedirect(SysEnv.getAppRoot() + SysEnv.getUrlLoginPage());
    }
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <meta charset="utf-8"/>
    <title><%=SysEnv.getSystemTitle()%>
    </title>

    <link rel="stylesheet" href="<%=SysEnv.getAppRoot()%>/login.css"/>
    <script type="text/javascript">
        function onLogin() {
            var txtUserName = document.getElementById('txtUserName');
            var txtPassword = document.getElementById('txtPassword');
            var txtErrorMessage = document.getElementById('txtErrorMessage');
            if (txtUserName.value == "" || txtPassword.value == "") {
                txtErrorMessage.innerText = "用户名和密码都必须输入！";
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="container">
    <div class="row">
        <h2 class="title"><%=SysEnv.getSystemTitle()%>——系统登录</h2>
    </div>
    <form id="loginForm" action="<%=SysEnv.getAppRoot()%>/login" method="post" onsubmit="return onLogin();">
        <div style="font-size:16px;">
            <div class="row">
                <div class="label">用户名：</div>
                <input type="text" style="width:200px;" id="txtUserName" name="userId" maxlength="6"/>
            </div>
            <div class="row">
                <div class="label">密码：</div>
                <input type="password" style="width:200px;" id="txtPassword" name="password"/>
            </div>
            <div style="height: 10px;"></div>
            <div class="row">
                <div class="label">&nbsp;</div>
                <input type="submit" value="登录" style="width:60px;"/>
            </div>
            <div class="row">
                <div class="label" style="height: 10px;">&nbsp;</div>
                <div id="txtErrorMessage" style="color:red;font-size: smaller; padding-right: 55px;">
                    <%=errorMessage%>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
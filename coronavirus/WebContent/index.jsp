<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>用户登录</title>
        <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport"/>
        <meta content="yes" name="apple-mobile-web-app-capable"/>
        <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
        <meta content="telephone=no" name="format-detection"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery.min.js"></script>

    </head>
    <body>
        <section class="aui-flexView">
            <header class="aui-navBar aui-navBar-fixed b-line">
                <a href="javascript:;" class="aui-navBar-item" onclick="javascript:history.back(-1);">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">登录</span>
                </div>
            </header>
            <section class="aui-scrollView">
                <div class="aui-code-box">
                	${info}
                    <form  class="form" action="LoginServlet" method="post">
                        <p class="aui-code-line">
                            <input type="text" class="aui-code-line-input" value="" name="account" id="account" autocomplete="off" placeholder="请输入学号"/>
                        </p>
                        <p class="aui-code-line aui-code-line-clear">
                            <input type="password" class="aui-code-line-input password" name="password" id="password" placeholder="密码" value="">
                        </p>
                            <input id="login_btu" type="submit" name="submit" value="登录">
                    </form>
                </div>
            </section>
        </section>
		
        <script type="text/javascript" src="js/login.js"></script>

    </body>
</html>

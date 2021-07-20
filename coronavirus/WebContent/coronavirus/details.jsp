<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>疫情防控</title>
<base href="<%=basePath%>/coronavirus/coronavirus">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="res/layui/css/layui.css">
<link rel="stylesheet" href="res/static/css/main.css">
<style>
img {
	width: 100%;
}
</style>
</head>
<body class="lay-blog">
	<div class="container-wrap">
		<div class="container">
			<div class="contar-wrap">
				<div class="item">
					<div class="item-box  layer-photos-demo1 layer-photos-demo">
						<h3 style="text-align: center;">
							<p>${msg.title}</p>
						</h3>
						<h5>
							发布于：
							<span>${msg.date}</span>
						</h5>
						${msg.content}
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="res/layui/layui.js"></script>
	<script>
        layui.config({
            base : 'res/static/js/'
        }).use('blog');
    </script>
</body>
</html>
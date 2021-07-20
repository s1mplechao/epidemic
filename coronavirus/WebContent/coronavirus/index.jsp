<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%--jstl--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<%
    /*获取项目名称*/
	String path = request.getContextPath();
	/*获取项目的绝对路径*/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>疫情防控</title>
<%--设置当前页面基地址--%>
<base href="<%=basePath%>/coronavirus/">
<%--适应移动端--%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%--layui样式--%>
<link rel="stylesheet" href="res/layui/css/layui.css">
<%--自定义样式--%>
<link rel="stylesheet" href="res/static/css/main.css">
</head>
<body class="lay-blog">
	<div class="container-wrap">
		<div class="container">
			<div class="contar-wrap">
				<h4 class="item-title" style="text-align: center;">
					<button style="position: absolute; left: 15px; top: 20px; padding: 0 10px;" class="layui-btn layui-btn-normal" onclick="toRobot()">
						<img style="width: 30px;" src="res/static/images/robot.png">
						疫情百科
					</button>
					<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="HH:mm:ss" var="cur_time" />
					<c:choose>
						<c:when test="${isSign == 1}">
							<button id="btn-sign" class="layui-btn layui-btn-lg" onclick="toSign()">今日已签到</button>
						</c:when>
						<c:when test="${isSign == 0 && cur_time >= '00:00:00' && cur_time < '15:00:00'}">
							<button id="btn-sign" class="layui-btn layui-btn-normal layui-btn-lg" onclick="toSign()">签到</button>
						</c:when>
						<c:when test="${isSign == 0 && cur_time >= '15:00:00'}">
							<button id="btn-sign" class="layui-btn layui-btn-danger layui-btn-lg" onclick="toSign()">未签到</button>
						</c:when>
					</c:choose>
					<p style="color: red;">签到截止时间15:00</p>
					<c:choose>
						<c:when test="${empty ybStudentid}">
							<button id="download" class="layui-btn layui-btn-primary">下载</button>
						</c:when>
					</c:choose>
					<span id="time"></span>
					<span id="sid">学号：${ybStudentid}</span>
				</h4>
				<c:set var="startIndex" value="${fn:length(msgs)-1 }"></c:set>
				<c:forEach var="msg" items="${msgs}" varStatus="status">
					<div class="item">
						<c:choose>
							<c:when test="${msg.id == 1|| msg.id == 2}">
								<img style="height: 30px; display: inline-block; float: right;" src="res/static/images/new.png" />
							</c:when>
						</c:choose>
						<div class="item-box  layer-photos-demo3 layer-photos-demo" onclick="location.href='../coronavirus?action=details&id=${msgs[startIndex - status.index].id}'">
							<h3 style="font-size: 1rem; line-height: 1.5; display: inline">${msgs[startIndex - status.index].title}</h3>
							<h5>
								发布于：
								<span>${msgs[startIndex - status.index].date}</span>
							</h5>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script src="res/static/js/jquery-3.4.1.min.js"></script>
	<script src="res/layui/layui.js"></script>
	<script>
        layui.config({
            base : 'res/static/js/'
        }).use('blog');

        //下载
        $("#download").on('touchend', function() {
            layer.msg("请在电脑端登入 http://211.68.191.30/yq 下载签到信息", {
                time : 10000
            })
        });

        //获取当前时间
        var date = new Date();
        var hour = date.getHours();
        var isSign = $
        {
            isSign
        };

        //签到按钮
        function toSign() {
            if (hour >= 0 && hour < 15) {
                //00:00～15:00 可签到
                $.ajax({
                    //请求方式
                    type : "POST",
                    url : "../coronavirus",
                    data : {
                        "action" : "where"
                    },
                    success : function(data) {
                        if (data === "0") {
                            console.log("不是湖北学生")
                            location.href = 'sign.jsp';
                        } else {
                            console.log("是湖北学生")
                            location.href = "signhb.jsp";
                        }
                    },
                    error : function() {
                        alert("发生错误");
                    }
                });
            } else if (hour >= 15) {
                //15:00～00:00 不能签到
                layer.msg("今天签到已截止")
            }
        }
        function getDate() {
            //获取当前时间
            var date = new Date();
            //格式化为本地时间格式
            var date1 = date.toLocaleString();
            //将时间写入div
            $("#time").html(date1);
        }
        //使用定时器每秒向div写入当前时间
        setInterval("getDate()", 1000);

        function toRobot() {
            location.href = "https://bstys.cpdaily.com/wec-amp-boya/mobile/index.html?login=0"
        }
    </script>
</body>
</html>
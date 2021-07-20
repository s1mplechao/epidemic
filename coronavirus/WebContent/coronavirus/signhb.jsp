<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%--jstl--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="container container-message container-details container-comment">
			<div class="contar-wrap">
				<div class="item">
					<form class="layui-form">
						<div class="item-box  layer-photos-demo1 layer-photos-demo">
							<label>
								<span style="color: red;">实名制签到，请认真操作</span>
							</label>
							<br>
							<hr>
							<div class="layui-form-item layui-hide" id="getclass">
								<label class="layui-form-label">
									<span style="color: red;">*</span>
									班级：
								</label>
								<div class="layui-input-block">
									<input type="text" name="classname" placeholder="例如：网络工程1801（全称）" autocomplete="off" class="layui-input">
								</div>
								<span style="color: red; font-size: 12px; padding-left: 110px;">加入班级后不再手动输入</span>
							</div>
							<div class="layui-input-block">
								<label style="display: inline-block;">1、今日体温：</label>
								<input type="text" name="q1" lay-verify="temp|number" placeholder="请输入体温 ℃" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-input-block">
								<label>2、是否发热？</label>
								<input type="radio" name="q2" value="是" title="是" lay-filter="q2">
								<input type="radio" name="q2" value="否" title="否" lay-filter="q2" checked>
								<br>
								<input type="text" name="q21" placeholder="发热原因" autocomplete="off" class="layui-input layui-hide">
							</div>
							<div class="layui-input-block">
								<label>3、是否已被确诊或确认为疑似病例?</label>
								<input type="radio" name="q3" value="是" title="是">
								<input type="radio" name="q3" value="否" title="否" checked>
							</div>
							<div class="layui-input-block">
								<label>4、密切接触的家人是否有已被确诊或确认为疑似病例 ？</label>
								<input type="radio" name="q4" value="是" title="是">
								<input type="radio" name="q4" value="否" title="否" checked>
							</div>
							<div class="layui-input-block">
								<label>5、是否有与已确诊或疑似病例有密切接触？</label>
								<input type="radio" name="q5" value="是" title="是">
								<input type="radio" name="q5" value="否" title="否" checked>
							</div>
							<div class="layui-input-block">
								<label>6、是否重症病例？</label>
								<input type="radio" name="q6" value="是" title="是">
								<input type="radio" name="q6" value="否" title="否" checked>
							</div>
							<div class="layui-input-block" id="q711">
								<label>7、是否被隔离？</label>
								<input type="radio" name="q7" value="是" title="是" lay-filter="q7">
								<input type="radio" name="q7" value="否" title="否" lay-filter="q7" checked>
								<br>
								<input type="text" name="q71" placeholder="隔离地点" autocomplete="off" class="layui-input layui-hide">
							</div>
							<div class="layui-input-block" id="q711">
								<label>8、是否住院治疗？</label>
								<input type="radio" name="q8" value="是" title="是" lay-filter="q8">
								<input type="radio" name="q8" value="否" title="否" lay-filter="q8" checked>
								<br>
								<input type="text" name="q81" placeholder="医院名称" autocomplete="off" class="layui-input layui-hide">
							</div>
							<br>
							<div class="layui-form-item" style="text-align: center">
								<button id="btn-position" type="button" class="layui-btn layui-btn-normal" onclick="gethtml5location_fun();">获取位置</button>
								<br>
								<input type="text" name="position" placeholder="*当前所在地" readonly="readonly" lay-verify="position">
							</div>
							<br>
							<div class="layui-form-item">
								<div class="layui-input-block" style="text-align: center; margin-top: 10px;">
									<button class="layui-btn" lay-submit lay-filter="submit">提交</button>
									<button type="reset" class="layui-btn layui-btn-primary">重置</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="res/static/js/jquery-3.4.1.min.js"></script>
	<script src="res/layui/layui.js"></script>
	<script src="res/static/js/yb_h5.js"></script>
	<script src="res/static/js/form.js"></script>
	<script>
        layui.config({
            base : 'res/static/js/'
        }).use('blog');
        var haveClassname = 0;

        $(document).ready(function() {
            //判断是否加入班级
            $.ajax({
                //请求方式
                type : "POST",
                cache : false,
                url : "../signyq",
                data : {
                    "action" : "classname"
                },
                success : function(data) {
                    console.log(data);
                    if (data === "0") {
                        $("#getclass").removeClass("layui-hide");
                        $("input[name='classname']").attr({
                            "lay-verify" : "classname"
                        })
                    } else {
                        haveClassname = 1;
                    }
                },
                error : function() {
                    alert("发生错误");
                }
            });

        });
        //题目
        questions = {
            "q1" : "1、今日体温",
            "q2" : "2、是否发热？",
            "q21" : "2.1、发热原因",
            "q3" : "3、是否已被确诊或确认为疑似病例？",
            "q4" : "4、密切接触的家人是否有已被确诊或确认为疑似病例？",
            "q5" : "5、是否与发热患者有过密切接触？",
            "q6" : "6、是否重症病例？",
            "q7" : "7、是否被隔离？",
            "q71" : "7.1、隔离地点",
            "q8" : "8、是否住院治疗？",
            "q81" : "8.1、医院名称"
        }

        //定位
        function yibanhtml5location(postion) {
            var obj = JSON.parse(postion);
            //修改签到按钮后input标签的值
            $("input[name='position']").attr({
                "value" : obj.address
            });
            //修改按钮状态
            $("#btn-position").removeClass("layui-btn-normal");
            $("#btn-position").html("获取成功");
            layer.msg("定位成功");
        }

        //表单
        layui.use('form', function() {
            var form = layui.form;
            // 切换选项
            form.on('radio(q2)', function(data) {
                if (data.value === "是") {
                    $("input[name='q21']").removeClass("layui-hide");
                    $("input[name='q21']").attr({
                        "lay-verify" : "reason"
                    })
                } else {
                    $("input[name='q21']").addClass("layui-hide");
                    $("input[name='q21']").removeAttr("lay-verify")
                }
            });
            form.on('radio(q7)', function(data) {
                if (data.value === "是") {
                    $("input[name='q71']").removeClass("layui-hide");
                    $("input[name='q71']").attr({
                        "lay-verify" : "geli"
                    })
                } else {
                    $("input[name='q71']").addClass("layui-hide");
                    $("input[name='q71']").removeAttr("lay-verify")
                }
            });
            form.on('radio(q8)', function(data) {
                if (data.value === "是") {
                    $("input[name='q81']").removeClass("layui-hide");
                    $("input[name='q81']").attr({
                        "lay-verify" : "hospital"
                    })
                } else {
                    $("input[name='q81']").addClass("layui-hide");
                    $("input[name='q81']").removeAttr("lay-verify")
                }
            });

            //监听提交
            form.on('submit(submit)', function(data) {
                //拼接问卷答案
                var wenjuan = "";
                wenjuan += data.field.q1 + "|" + data.field.q2 + "|";
                if (data.field.q2 === "是") {
                    wenjuan += data.field.q21 + "|";
                } else {
                    wenjuan += "|";
                }
                wenjuan += data.field.q3 + "|" + data.field.q4 + "|" + data.field.q5 + "|" + data.field.q6 + "|" + data.field.q7 + "|";
                if (data.field.q7 === "是") {
                    wenjuan += data.field.q71 + "|";
                } else {
                    wenjuan += "|";
                }
                wenjuan += data.field.q8 + "|"
                if (data.field.q8 === "是") {
                    wenjuan += data.field.q81 + "|";
                } else {
                    wenjuan += "|";
                }

                console.log(wenjuan);
                //获取定位值
                var position = data.field.position;
                //获取班级
                var ybClassname = data.field.classname;

                //示范一个公告层
                setContent(data.field);
                layer.open({
                    type : 1,
                    title : false //不显示标题栏
                    ,
                    closeBtn : false,
                    area : '350px;',
                    shade : 0.8,
                    id : 'confirm' //设定一个id，防止重复弹出
                    ,
                    resize : false,
                    btn : [ '确认提交', '返回修改' ],
                    btnAlign : 'c',
                    moveType : 1 //拖拽模式，0或者1
                    ,
                    content : content,
                    success : function(layero) {
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn0').on('touchend', function() {
                            $.ajax({
                                //请求方式
                                type : "POST",
                                //请求地址
                                url : "../signyq?action=signhb",
                                //数据
                                data : {
                                    "wenjuan" : wenjuan,
                                    "position" : position,
                                    "ybClassname" : ybClassname
                                },
                                //请求成功
                                success : function(data) {
                                    if (data === "1") {
                                        layer.msg("签到成功");

                                        setTimeout(function() {
                                            location.href = "../coronavirus?action=index";
                                        }, 2000);

                                    } else if (data == "2") {
                                        layer.msg("今日已签到,更新签到信息");

                                        setTimeout(function() {
                                            location.href = "../coronavirus?action=index";
                                        }, 3000);

                                    } else {
                                        layer.msg("签到失败");
                                    }
                                },
                                //请求失败，包含具体的错误信息
                                error : function(e) {
                                    console.log(e.status);
                                    console.log(e.responseText);
                                }
                            });
                        })
                    }
                });
                return false;
            });
        });

        //设置校验值 
        var content = "";
        function setContent(data) {
            content = "";
            content += '<div style="font-size:1rem;padding:10px;">'
            for ( var k in questions) {
                content += '<span>' + '<b>' + questions[k] + '</b>' + ' ' + data[k] + '</span><br>';
            }
            content += '</div>'
        }
    </script>
</body>
</html>
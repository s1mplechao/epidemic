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
									<input type="text" name="classname" placeholder="例如：网络1801" autocomplete="off" class="layui-input">
								</div>
								<span style="color: red; font-size: 12px; padding-left: 110px;">加入班级后不再手动输入</span>
							</div>
							<div class="layui-input-block">
								<label style="display: inline-block;">1、今日体温：</label>
								<input type="text" name="q1" lay-verify="temp|number" placeholder="请输入体温 ℃" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-input-block">
								<label>2、1月8日以来是否去过湖北?</label>
								<input type="radio" name="q2" value="是" title="是">
								<input type="radio" name="q2" value="否" title="否" checked>
							</div>
							<div class="layui-input-block">
								<label>3、1月8日以来去过湖北，是否与湖北发热患者有过密切接触?</label>
								<input type="radio" name="q3" value="是" title="是">
								<input type="radio" name="q3" value="否" title="否" checked>
							</div>
							<div class="layui-input-block">
								<label>4、1月8日以来是否与湖北来的发热患者有过密切接触？</label>
								<input type="radio" name="q4" value="是" title="是">
								<input type="radio" name="q4" value="否" title="否" checked>
							</div>
							<div class="layui-input-block">
								<label>5、1月8日以来家人是否有确诊或疑似病例？</label>
								<input type="radio" name="q5" value="是" title="是">
								<input type="radio" name="q5" value="否" title="否" checked>
							</div>
							<div class="layui-input-block">
								<label>6、1月8日以来与确诊或疑似病例密切接触？</label>
								<input type="radio" name="q6" value="是" title="是">
								<input type="radio" name="q6" value="否" title="否" checked>
							</div>
							<div class="layui-input-block">
								<label>7、当前是否热症状？</label>
								<input type="radio" name="q7" value="是" title="是" lay-filter="q7">
								<input type="radio" name="q7" value="否" title="否" lay-filter="q7" checked>
							</div>
							<div class="layui-input-block layui-hide" id="q71">
								<label>7.1、有发热症状，是否与发热患者有过密切接触？</label>
								<input type="radio" name="q71" value="是" title="是" lay-filter="q71">
								<input type="radio" name="q71" value="否" title="否" lay-filter="q71" checked>
							</div>
							<div class="layui-input-block layui-hide" id="q711">
								<label>7.1.1、是否与确诊或疑似病例有过密切接触？</label>
								<input type="radio" name="q711" value="是" title="是">
								<input type="radio" name="q711" value="否" title="否" checked>
							</div>
							<div class="layui-input-block layui-hide" id="q72">
								<label>7.2、有发热症状，医疗诊疗结果？</label>
								<input type="radio" name="q72" value="疑似新型肺炎病例" title="疑似新型肺炎病例">
								<br>
								<input type="radio" name="q72" value="确诊新型肺炎病例" title="确诊新型肺炎病例">
								<br>
								<input type="radio" name="q72" value="确诊且为重症新型肺炎病例" title="确诊且为重症新型肺炎病例">
								<br>
								<input type="radio" name="q72" value="普通发烧" title="普通发烧">
								<br>
								<input type="radio" name="q72" value="其他症状" title="其他症状">
								<br>
								<input type="radio" name="q72" value="还未去医院" title="还未去医院" checked>
							</div>
							<div class="layui-input-block">
								<label>8、是否在定点隔离点进行隔离?</label>
								<input type="radio" name="q8" value="是" title="是">
								<input type="radio" name="q8" value="否" title="否" checked>
							</div>
							<div class="layui-input-block" id="q9">
								<label>9、现在是否在家庭常驻地县区活动?</label>
								<input type="radio" name="q9" value="是" title="是" lay-filter="q9" checked>
								<input type="radio" name="q9" value="否" title="否" lay-filter="q9">
							</div>
							<div class="layui-input-block layui-hide" id="q91">
								<label>9.1、未在家庭常驻地活动的原因：</label>
								<input type="radio" name="q91" value="探亲" title="探亲" lay-filter="q91" checked>
								<br>
								<input type="radio" name="q91" value="旅游" title="旅游" lay-filter="q91">
								<br>
								<input type="radio" name="q91" value="个人联系实习" title="个人联系实习" lay-filter="q91">
								<br>
								<input type="radio" name="q91" value="老师推荐实习" title="老师推荐实习" lay-filter="q91">
								<br>
								<input type="radio" name="q91" value="学校安排实习" title="学校安排实习" lay-filter="q91">
								<br>
								<input type="radio" name="q91" value="其他" title="其他" lay-filter="q91">
								<input type="text" name="q91other" placeholder="未在家庭常驻地活动的原因" autocomplete="off" class="layui-input layui-hide">
							</div>
							<div class="layui-input-block layui-hide" id="q92">
								<label>9.2、到达现在活动地日期：</label>
								<input type="text" name="q92" placeholder="请输入日期" autocomplete="off" class="layui-input">
							</div>
							<br>
							<div class="layui-form-item" style="text-align: center">
								<button id="btn-position" type="button" class="layui-btn layui-btn-normal" onclick="gethtml5location_fun();">获取位置</button>
								<br>
								<input type="text" value="1" name="position" placeholder="*当前所在地" readonly="readonly">
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
            "q1" : "1、今日体温：",
            "q2" : "2、1月8日以来是否去过湖北?",
            "q3" : "3、1月8日以来去过湖北，是否与湖北发热患者有过密切接触?",
            "q4" : "4、1月8日以来是否与湖北来的发热患者有过密切接触？",
            "q5" : "5、1月8日以来家人是否有确诊或疑似病例？",
            "q6" : "6、1月8日以来与确诊或疑似病例密切接触？",
            "q7" : "7、当前是否热症状？",
            "q71" : "7.1、有发热症状，是否与发热患者有过密切接触？",
            "q711" : "7.1.1、是否与确诊或疑似病例有过密切接触？",
            "q8" : "8、是否在定点隔离点进行隔离?",
            "q9" : "9、现在是否在家庭常驻地县区活动?",
            "q91" : "9.1、未在家庭常驻地活动的原因：",
            "q92" : "9.2、到达现在活动地日期："
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
            form.on('radio(q7)', function(data) {
                if (data.value === "是") {
                    $("#q71").removeClass("layui-hide");
                    $("#q72").removeClass("layui-hide");
                } else {
                    $("#q71").addClass("layui-hide");
                    $("#q72").addClass("layui-hide");
                }
            });
            form.on('radio(q71)', function(data) {
                if (data.value === "是") {
                    $("#q711").removeClass("layui-hide");
                } else {
                    $("#q711").addClass("layui-hide");
                }
            });
            form.on('radio(q9)', function(data) {
                if (data.value === "否") {
                    $("#q91").removeClass("layui-hide");
                    $("#q92").removeClass("layui-hide");
                    $("input[name='q92']").attr({
                        "lay-verify" : "date"
                    });
                } else {
                    $("#q91").addClass("layui-hide");
                    $("#q92").addClass("layui-hide");
                    $("input[name='q92']").removeAttr("lay-verify");
                }
            });
            form.on('radio(q91)', function(data) {
                if (data.value === "其他") {
                    $("input[name='q91other']").attr({
                        "lay-verify" : "reason",
                    });
                    $("input[name='q91other']").removeClass("layui-hide");
                } else {
                    $("input[name='q91other']").addClass("layui-hide");
                    $("input[name='q91other']").removeAttr("lay-verify");
                }
            });
            //监听提交
            form.on('submit(submit)', function(data) {
                //拼接问卷答案
                var wenjuan = "";
                wenjuan += data.field.q1 + "|";
                wenjuan += data.field.q2 + "|";
                wenjuan += data.field.q3 + "|";
                wenjuan += data.field.q4 + "|";
                wenjuan += data.field.q5 + "|";
                wenjuan += data.field.q6 + "|";
                wenjuan += data.field.q7 + "|";
                if (data.field.q7 === "是") {
                    wenjuan += data.field.q71 + "|";
                    if (data.field.q71 === "是") {
                        wenjuan += data.field.q711 + "|";
                    } else {
                        wenjuan += "|";
                    }
                    wenjuan += data.field.q72 + "|";
                } else {
                    wenjuan += "|";
                    wenjuan += "|";
                    wenjuan += "|";
                }
                wenjuan += data.field.q8 + "|";
                wenjuan += data.field.q9 + "|";
                if (data.field.q9 === "否") {
                    if (data.field.q91 === "其他") {
                        wenjuan += data.field.q91other + "|";
                    } else {
                        wenjuan += data.field.q91 + "|";
                    }
                    wenjuan += data.field.q92 + "|";
                } else {
                    wenjuan += "|";
                    wenjuan += "|";
                }
                console.log(wenjuan);
                //获取定位值
                var position = data.field.position;
                //获取班级
                var ybClassname = data.field.classname;
                setContent(data.field);
                //示范一个公告层
                layer.open({
                    type : 1,
                    //不显示标题栏
                    title : false,
                    closeBtn : false,
                    area : '350px;',
                    shade : 0.8,
                    //设定一个id，防止重复弹出
                    id : 'confirm',
                    resize : false,
                    btn : [ '确认提交', '返回修改' ],
                    btnAlign : 'c',
                    //拖拽模式，0或者1
                    moveType : 1,
                    content : content,
                    success : function(layero) {
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn0').on('touchend', function() {
                            $.ajax({
                                //请求方式
                                type : "POST",
                                //请求地址
                                url : "../signyq?action=sign",
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
                if ((k === "q9") && (data[k] === "是")) {
                    break;
                }
            }
            content += '</div>'
        }
    </script>
</body>
</html>
//表单
layui.use('form', function() {
	var form = layui.form;
	// 表单校验规则 value：表单的值、item：表单的DOM对象
	form.verify({
		// 数字
		number : function(value, item) {
			if (value != value.replace(/[^\d^\.]+/g, '')) {
				return '体温只能输入数字';
			} else if (value <= 30 || value >= 45) {
				return '体温范围异常'
			}
		},
		// 定位
		position : function(value, item) {
			if (value === "" || value === "null") {
				return '还未获取位置';
			}
		},
		// 班级
		classname : function(value, item) {
			if (value === "") {
				return '请输入班级';
			}
		},
		// 原因
		reason : function(value, item) {
			if (value === "") {
				return '请输入原因';
			}
		},
		// 体温
		temp : function(value, item) {
			if (value === "") {
				return '请输入体温';
			}
		},
		// 日期
		date : function(value, item) {
			if (value === "") {
				return '请输入日期';
			}
		},
		// 隔离地点
		geli : function(value, item) {
			if (value === "") {
				return '请输入隔离地点';
			}
		},
		// 医院名称
		// 日期
		hospital : function(value, item) {
			if (value === "") {
				return '请输入医院名称';
			}
		}
	});
});
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../public/libs.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改密码</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="stylesheet" type="text/css" href="${basePath }/static/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="${basePath }/static/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="${basePath }/lib/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${basePath }/static/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="${basePath }/static/h-ui.admin/css/style.css" />
		
	</head>

	<body>
	<article class="page-container">
	<form class="form form-horizontal" id="theForm" action="${basePath }/admin/no/updateMyPwd.htm">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>账户名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${user.userName }" placeholder="" readonly="readonly">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>原密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text" autocomplete="off" value="" placeholder="原密码" id="oldpassword" name="oldpassword">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text" autocomplete="off" value="" placeholder="新密码" id="password" name="password">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>请再输入一次新密码：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="password" class="input-text" value="" placeholder="" id="pwd1">
		</div>
	</div>

	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" onclick="checkForm();">
		</div>
	</div>
	</form>
</article>


<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath }/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${basePath }/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${basePath }/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">

$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
});


function checkForm(){
	var password = $("#password").val();
	var pwd1 = $("#pwd1").val(); 
	var oldpassword = $("#oldpassword").val(); 
	if(password == "" || pwd1 == "" || oldpassword == ""){
		layer.msg("密码不能为空",{icon:2,time:3000});
		return false;
	}else if(password!=pwd1){
		layer.msg("两次密码输入不一致",{icon:2,time:3000});
		return false;
	}else{
		$("#theForm").submit();
	}
}


</script> 

	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../public/libs.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改用户</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="stylesheet" type="text/css"
			href="${basePath }/static/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css"
			href="${basePath }/static/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css"
			href="${basePath }/lib/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css"
			href="${basePath }/static/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css"
			href="${basePath }/static/h-ui.admin/css/style.css" />

	</head>

	<body>
		<article class="page-container">
		<form class="form form-horizontal" id="form-admin-add">

			<div class="row cl">
				
			</div>

			
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">
					<span class="c-red"></span>厂商编号：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${obj.c_no }"
						placeholder="" id="c_no" name="c_no" readonly="readonly">
					<input type="hidden" class="input-text" name="id"
						value="${obj.id }" />
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">
					<span class="c-red"></span>厂商名称：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" autocomplete="off" value="${obj.name}" id="name" name="name">
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">
					<span class="c-red"></span>厂商电话：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${obj.phone }"
						placeholder="" id="phone" name="phone">
				</div>
			</div>




			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">
					<span class="c-red"></span>厂商邮箱：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${obj.email }"
						placeholder="" id="email" name="email">
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">
					<span class="c-red"></span>联系人：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="@"
						value="${obj.contact_name }" name="contact_name" id="contact_name">
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">
					<span class="c-red"></span>联系人手机：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="@"
						value="${obj.mobile }" name="mobile" id="mobile">
				</div>
			</div>


			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">
					<span class="c-red"></span>厂商地址：
				</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="@"
						value="${obj.address }" name="address" id="address">
				</div>
			</div>




			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;修改&nbsp;&nbsp;">
				</div>
			</div>
		</form>
		</article>


		<!--请在下方写此页面业务相关的脚本-->
		<script type="text/javascript"
			src="${basePath }/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
		<script type="text/javascript"
			src="${basePath }/lib/jquery.validation/1.14.0/validate-methods.js"></script>
		<script type="text/javascript"
			src="${basePath }/lib/jquery.validation/1.14.0/messages_zh.js"></script>
		<script type="text/javascript">


$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-admin-add").validate({
		rules:{
			userName:{
				required:true,
				minlength:4,
				maxlength:16
			},
			nickName:{
				required:true,
			},
			mobile:{
				required:true,
				isPhone:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "${basePath}/admin/updateCompany.htm" ,
				success: function(data){
					var jsonObj = eval('('+data+')');
   					var flag = jsonObj.flag;
   					if(flag == '0'){
						layer.msg("修改成功!", {icon: 1,time: 2000,
												end: function () {
													parent.location.reload(); // 父页面刷新
													var index = parent.layer.getFrameIndex(window.name);
													parent.layer.close(index);
												}
											  });
						
					}else{
						layer.msg(jsonObj.errMsg,{icon:2,time:3000});
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:2,time:3000});
				}
			});
			
		}
	});
});



</script>

	</body>
</html>

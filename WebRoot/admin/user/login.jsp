<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../public/libs.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>

		<title>登录</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link href="${basePath }/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
		<link href="${basePath }/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
		<link href="${basePath }/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${basePath }/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.code{
background-image:url(../images/111.png);
font-family:Arial,宋体;
font-style:italic;
color:green;
border:0;
padding:2px 3px;
letter-spacing:3px;
font-weight:bolder;
font-size: 18px;
}
.unchanged {
border:0;
}
</style>
<script language="javascript" type="text/javascript">
var code ; //在全局 定义验证码
function createCode(){ 
code = new Array();
var codeLength = 4;//验证码的长度
var checkCode = document.getElementById("checkCode");
checkCode.value = "";

var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');

for(var i=0;i<codeLength;i++) {
   var charIndex = Math.floor(Math.random()*32);
   code +=selectChar[charIndex];
}
if(code.length != codeLength){
   createCode();
}
checkCode.value = code;
}



function checkLogin () {
var inputCode = document.getElementById("incode").value.toUpperCase();
var name = $("#userName").val();
var password = $("#password").val();
if(name == ""){
	alert("请输入用户名");
	return false;
}
if(password == ""){
	alert("请输入密码");
	return false;
}
if(inputCode.length <=0) {
   alert("请输入验证码！");
   return false;
}
if(inputCode != code ){
   alert("验证码输入错误！");
   createCode();
   return false;
}
$("#theForm").submit();
}


function canPage(){
location.reload();
}


document.onkeydown=function(e){

          var a=e||window.event;
            if (a.keyCode == 13){
               checkLogin();
            }
           }

</script>
		
	</head>

	<body onLoad="createCode();">
	  
	  <input type="hidden" id="TenantId" name="TenantId" value="" />
		<div class="header"></div>
		<div class="loginWraper">
			<div id="loginform" class="loginBox">
			<form action="${basePath }/admin/login.htm" method="post" id="theForm">
					<div class="row cl">
						<label class="form-label col-xs-3" style="text-align:right">
							<i class="Hui-iconfont">&#xe60d;</i>
						</label>
						<div class="formControls col-xs-8">
							<input  type="text" placeholder="账户" class="input-text size-L" id="userName" name="name" autofocus="autofocus"/>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-3" style="text-align:right">
							<i class="Hui-iconfont">&#xe60e;</i>
						</label>
						<div class="formControls col-xs-8">
							<input  type="password" placeholder="密码" class="input-text size-L" id="password" name="pwd" />
						</div>
					</div>
					<div class="row cl">
        			<div class="formControls col-xs-8 col-xs-offset-3">
          				<input class="input-text size-L" type="text" placeholder="验证码" id="incode" style="width:150px;">
          				<input type="button" id="checkCode" class="code" style="width:80px;height:40px;" onClick="createCode()" />	
          		    </div>
      				</div>
      
					<div class="row cl">
						<div class="formControls col-xs-8 col-xs-offset-3">
							<input name="" type="button" onclick="checkLogin();" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" />
							<input name="" type="reset" onclick="canPage();" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;" />
						</div>
					</div>
					  </form> 
			</div>
		</div>
		<div class="footer">
			巨鼎电子智能远程设备管理系统
		</div>
		
	</body>
</html>

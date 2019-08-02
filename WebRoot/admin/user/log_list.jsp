<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../public/libs.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="${basePath }/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${basePath }/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${basePath }/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${basePath }/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${basePath }/static/h-ui.admin/css/style.css" />


</head>
  
  <body>
<form action="${basePath}/admin/no/queryOperLogList.htm" method="post" id="queryForm">
<input type="hidden" name="page" id="currPage" value="${currentPage}" />

   <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 日志管理 <span class="c-gray en">&gt;</span> 日志列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 
		用户：<input type="text" class="input-text" style="width:150px" placeholder="管理员名称" id="username" name="username" value="${username }">
		&nbsp;&nbsp;一级菜单：<input type="text" class="input-text" style="width:150px" placeholder="一级菜单" id="one_menu" name="one_menu" value="${one_menu }">&nbsp;&nbsp;手机：<input type="text" class="input-text" style="width:150px" placeholder="手机" id="mobile" name="mobile" value="${mobile }">
		&nbsp;&nbsp;二级菜单：<input type="text" class="input-text" style="width:150px" placeholder="二级菜单" id="two_menu" name="two_menu" value="${two_menu }">
		&nbsp;&nbsp;操作内容：<input type="text" class="input-text" style="width:150px" placeholder="内容" id="content" name="content" value="${content }">
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 查询</button>
	</div>
	
	
	<br/>
	
	
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="12">日志列表</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="40">ID</th>
				<th width="100">一级菜单</th>
				<th width="100">二级菜单</th>
				<th width="100">操作人</th>
				<th width="200">操作内容</th>
				<th width="120">操作时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${objs }">
			<tr class="text-c">
				<td><input type="checkbox" value="${obj.id }" name=""></td>
				<td>${obj.id }</td>
				<td>${obj.one_menu }</td>
				<td>${obj.two_menu }</td>
				<td>${obj.nickName }</td>
				<td>${obj.content }</td>
				<td>${obj.addTime }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="mt-20">
		${pageHtml }
	</div>
</div>
</form>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath }/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${basePath }/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${basePath }/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
</script>
  </body>
</html>

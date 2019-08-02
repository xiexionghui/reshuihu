<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../public/libs.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<title>厂商管理</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
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
		<form action="${basePath}/admin/queryUserList.htm" method="post"
			id="queryForm">
			<input type="hidden" name="page" id="currPage" value="${currentPage}" />

			<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe67f;</i> 首页
			<span class="c-gray en">&gt;</span> 系统管理
			<span class="c-gray en">&gt;</span> 厂商列表
			<a class="btn btn-success radius r"
				style="line-height:1.6em;margin-top:3px"
				href="javascript:location.replace(location.href);" title="刷新"><i
				class="Hui-iconfont">&#xe68f;</i> </a>
			</nav>
			<div class="page-container">
				<div class="text-c">

					账号：
					<input type="text" class="input-text" style="width:150px"
						placeholder="管理员名称" id="name" name="name" value="${name }">
					&nbsp;&nbsp;手机：
					<input type="text" class="input-text" style="width:150px"
						placeholder="手机" id="mobile" name="mobile" value="${mobile }">
					<button type="submit" class="btn btn-success" id="" name="">
						<i class="Hui-iconfont">&#xe665;</i> 查询
					</button>
				</div>



				<div class="cl pd-5 bg-1 bk-gray mt-20">
					<span class="l"> <a href="javascript:;" onclick="datadel()"
						class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
							批量删除</a> <a href="javascript:;"
						onclick="admin_add('添加厂商信息','${basePath }/admin/no/toAddCompany.htm','800','600')"
						class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
							添加厂商信息</a> </span>
				</div>


				<table class="table table-border table-bordered table-bg">
					<thead>
						<tr>
							<th scope="col" colspan="12">
								厂商列表
							</th>
						</tr>
						<tr class="text-c">
							<th width="25">
								<input type="checkbox" name="" value="">
							</th>
							<th width="40">
								ID
							</th>
							<th width="100">
								厂商编号
							</th>
							<th width="100">
								厂商名称
							</th>
							<th width="100">
								厂商电话
							</th>

							<th width=60>
								厂商邮箱
							</th>

							<th width="100">
								联系人
							</th>
							<th width="100">
								联系人手机
							</th>
							<th width="130">
								厂商地址
							</th>
							<th width="130">
								时间
							</th>
							<th width="130">
								是否删除
							</th>

							<th width="100">
								操作
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="obj" items="${objs }">
							<tr class="text-c">
								<td>
									<input type="checkbox" value="${obj.id}" name="">
								</td>
								<td>
									${obj.id }
								</td>
								<td>
									${obj.c_no }
								</td>
								<td>
									${obj.name }
								</td>
								<td>
									${obj.phone }
								</td>

								<td>
									${obj.email }
								</td>
								<td>
									${obj.contact_name }
								</td>
								<td>
									${obj.mobile }
								</td>
								<td>
									${obj.address }
								</td>
								<td>
									${obj.addTime }
								</td>
								<td>

									${obj.is_delete }


								</td>



								<td class="td-manage">



									<a title="编辑" href="javascript:;"
										onclick="admin_edit('管理员编辑','${basePath }/admin/no/toUpdateCompany.htm?id=${obj.id }','800','600')"
										class="ml-5" style="text-decoration:none"><i
										class="Hui-iconfont">&#xe6df;</i> </a>
									<a title="删除" href="javascript:;"
										onclick="admin_del(this,'${obj.id }')" class="ml-5"
										style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i>
									</a>
								</td>
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
		<script type="text/javascript"
			src="${basePath }/lib/My97DatePicker/4.8/WdatePicker.js"></script>
		<script type="text/javascript"
			src="${basePath }/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
		<script type="text/javascript"
			src="${basePath }/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript">



/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*管理员-增加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-删除*/
function admin_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
   				type:"post",
  				url: '${basePath}/admin/delCompany.htm',
  				data:{"id":id}, 
   				success:function(data){
   					if(data.indexOf("alert")!=-1){
   						layer.msg('权限不足，请联系管理员!',{icon:2,time:2000});
   					}else{
   						$(obj).parents("tr").remove();
						layer.msg('已删除!',{icon:1,time:2000});
   					}
   					
   				}
   		});	
			
	});
}

/*管理员-批量删除*/
function datadel(){
	layer.confirm('确认要删除吗？',function(index){
		 var idNum=0;
		 var qx=0;
		 $.each($('input:checkbox:checked'),function(){
		 		if($(this).val()>=1){
                	idNum = 1;
                	$.ajax({
   						type:"post",
  						url: '${basePath}/admin/delCompany.htm',
  						data:{"id":$(this).val()}, 
   						success:function(data){
   							if(data.indexOf("alert")!=-1){
   								qx=1;
   							}	
   						}
   					});	
                	
                }
         });
			
		 if(idNum == '1' && qx=='0'){
			layer.msg('已删除!',{icon:1,time:2000,
										end: function () {
											location.reload(); 
										}
			
								});
		 }else{
		 	if(qx == '1'){
   			layer.msg('权限不足，请联系管理员!',{icon:2,time:2000});
		 	}else{
		 	layer.msg('请选择要删除的数据!',{icon:2,time:2000});
		 	}
		 }
		 	
			
	});
}


/*管理员-编辑*/
function admin_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-停用*/
function admin_stop(obj,id){
	layer.confirm('确认要禁用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		$.ajax({
   				type:"post",
  				url: '${basePath}/admin/canUser.htm',
  				data:{"id":id}, 
   				success:function(data){
   					if(data.indexOf("alert")!=-1){
   						layer.msg('权限不足，请联系管理员!',{icon:2,time:2000});
   					}else{
   						$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,'+id+')" href="javascript:;" title="正常" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
						$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
						$(obj).remove();
						layer.msg('已禁用!',{icon: 5,time:2000});
   					}
   				
   					
   				}
   		});	
		
		
	});
}

/*管理员-启用*/
function admin_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		$.ajax({
   				type:"post",
  				url: '${basePath}/admin/qyUser.htm',
  				data:{"id":id}, 
   				success:function(data){
   					if(data.indexOf("alert")!=-1){
   						layer.msg('权限不足，请联系管理员!',{icon:2,time:2000});
   					}else{
   						$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,'+id+')" href="javascript:;" title="禁用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
						$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">正常</span>');
						$(obj).remove();
						layer.msg('已启用!', {icon: 6,time:2000});
   					}
   					
   				}
   			});
				
		
		
	});
}
</script>
	</body>
</html>

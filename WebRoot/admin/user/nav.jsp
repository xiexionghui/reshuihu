<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 账户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${basePath }/admin/queryUserList.htm" data-title="管理员账户管理" href="javascript:void(0)">管理员账户管理</a></li>
					<li><a data-href="${basePath }/admin/queryCompanyList.htm" data-title="厂商用户管理" href="javascript:void(0)">厂商3用户管理</a></li>
					<li><a data-href="${basePath }/admin/no/upPwd.htm" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
					
				</ul>
			</dd>
		</dl>
		
		
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 厂商管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					
					<li><a data-href="${basePath }/admin/queryCompanyList.htm" data-title="厂商列表" href="javascript:void(0)">厂商列表</a></li>
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${basePath }/admin/#" data-title="会员列表" href="javascript:void(0)">会员列表</a></li>
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 设备分类管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${basePath }/admin/#" data-title="设备分类列表" href="javascript:void(0)">设备分类列表</a></li>
					<li><a data-href="${basePath }/admin/#" data-title="模式列表" href="javascript:void(0)">模式列表</a></li>
					<li><a data-href="${basePath }/admin/#" data-title="固件列表" href="javascript:void(0)">固件列表</a></li>
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 设备管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${basePath }/admin/#" data-title="设备列表" href="javascript:void(0)">设备列表</a></li>
				</ul>
			</dd>
		</dl>
		
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 系统设置<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="${basePath }/admin/#" data-title="公众号设置" href="javascript:void(0)">公众号设置</a></li>
					<li><a data-href="${basePath }/admin/#" data-title="客服设置" href="javascript:void(0)">客服设置</a></li>
				</ul>
			</dd>
		</dl>
		
		
	
</div>
</aside>

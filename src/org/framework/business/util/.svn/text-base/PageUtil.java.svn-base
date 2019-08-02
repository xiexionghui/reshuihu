package org.framework.business.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.ModelMap;

public class PageUtil {
	
	
	
	/**
	 * <ul class="pagination">
									<li><a href="#" onclick='return gotoFormPage(1)' aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
									</li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li onclick='return gotoFormPage(" + totalPage + ")'><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a>
									</li>
								</ul>
	 */
	public static String pageFormHeadHtml(int currentPage, int pages, int rows,int currPage,int totalPage) {
		String pageHtml = "<ul class=\"pagination\">";
		if(currentPage-1>=1){
			pageHtml+="<li onclick='return gotoFormPage(" + (currentPage-1) + ")'><a href=\"#\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a>";//上一页
		}else{
			pageHtml+="<li onclick='return gotoFormPage(1)'><a href=\"#\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a>";//上一页
		}
		
		if(pages > 0){
			int beginPage = pages - 3 < 1 ? 1 : pages - 3;
			if (beginPage <= totalPage) {
				int i = beginPage;
				for (int j = 0; (i <= totalPage) && (j < 6); j=j+1) {
					pageHtml = pageHtml + "<li onclick='return gotoFormPage(" + i + ")'><a href=\"#\">1</a></li>";
					
					i=i+1;
				}
			}
			if(currentPage+1<=totalPage){
				pageHtml = pageHtml + "<li onclick='return gotoFormPage(" + (currentPage+1) + ")'><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>";
				
			}else{
				pageHtml = pageHtml + "<li onclick='return gotoFormPage(" + totalPage + ")'><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>";
			}
			
		}
		pageHtml+="</ul>";
		return pageHtml;
	}
	
	
	
	public static String pageHtml(int currentPage, int pages, int rows,int currPage,int totalPage) {
		String pageHtml = "<div id=\"DataTables_Table_0_wrapper\" class=\"dataTables_wrapper no-footer\">";
		pageHtml+="<div class=\"dataTables_info\" id=\"DataTables_Table_0_info\" role=\"status\" aria-live=\"polite\">总共 "+rows+" 条,当前第 "+currentPage+" 页</div>";
		pageHtml+="<div class=\"dataTables_paginate paging_simple_numbers\" id=\"DataTables_Table_0_paginate\">";
		
		pageHtml+="<a onclick='return gotoFormPage(1)' class=\"paginate_button previous disabled\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"0\" tabindex=\"0\" id=\"DataTables_Table_0_previous\">首页</a>";
		
		if(currentPage-1>=1){
			pageHtml+="<a onclick='return gotoFormPage(" + (currentPage-1) + ")' class=\"paginate_button previous disabled\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"0\" tabindex=\"0\" id=\"DataTables_Table_0_previous\">上一页</a>";
		}
		
		if(pages > 0){
			if(currentPage>=3){
				for(int i=currentPage-2;i<=currentPage;i++){
					if(i<=pages){//class=\"paginate_button current\"
						if(i == currentPage){
							pageHtml+="<a onclick='return gotoFormPage(" + i + ")' class=\"paginate_button current\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"1\" tabindex=\"0\">"+i+"</a>";
						}else{
							pageHtml+="<a onclick='return gotoFormPage(" + i + ")' class=\"paginate_button previous disabled\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"1\" tabindex=\"0\">"+i+"</a>";
						}
						
					}
				}
				for(int i=currentPage+1;i<=currentPage+3;i++){
					if(i<=pages){
						if(i == currentPage){
							pageHtml+="<a onclick='return gotoFormPage(" + i + ")' class=\"paginate_button current\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"1\" tabindex=\"0\">"+i+"</a>";
						}else{
							pageHtml+="<a onclick='return gotoFormPage(" + i + ")' class=\"paginate_button previous disabled\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"1\" tabindex=\"0\">"+i+"</a>";
						}
					}
				}
			}else{
				for(int i=1;i<=6;i++){
					if(i<=pages){
						if(i == currentPage){//选中
							pageHtml+="<a onclick='return gotoFormPage(" + i + ")' class=\"paginate_button current\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"1\" tabindex=\"0\">"+i+"</a>";
						}else{
							pageHtml+="<a onclick='return gotoFormPage(" + i + ")' class=\"paginate_button previous disabled\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"1\" tabindex=\"0\">"+i+"</a>";
						}
					}
				}
			}
			
			if(currentPage+1<=totalPage){
				//pageHtml = pageHtml + "<li class=\"paginItem\" onclick='return gotoFormPage(" + (currentPage+1) + ")'><a href=\"javascript:;\"><span class=\"pagenxt\"></span></a></li>";
				pageHtml+="<a  onclick='return gotoFormPage(" + (currentPage+1) + ")' class=\"paginate_button next disabled\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"2\" tabindex=\"0\" id=\"DataTables_Table_0_next\">下一页</a>";
			}
			
		}
		
		pageHtml+="<a  onclick='return gotoFormPage(" + (totalPage) + ")' class=\"paginate_button next disabled\" aria-controls=\"DataTables_Table_0\" data-dt-idx=\"2\" tabindex=\"0\" id=\"DataTables_Table_0_next\">尾页</a>";
		pageHtml+="</div></div>";
		return pageHtml;
	}
	
	
	
	
	
	/**
	 * @param currentPage  当前页
	 * @param pages   总页数
	 * @param rows    总行数
	 * @return
	 * 
	 * **
	 * <ul class="am-pagination tpl-pagination">
                                            <li class="am-disabled"><a href="#">«</a></li>
                                            <li class="am-active"><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">4</a></li>
                                            <li><a href="#">5</a></li>
                                            <li><a href="#">»</a></li>
                                        </ul>
	 * @param currentPage
	 * @param pages
	 * @param rows
	 * @param currPage
	 * @param totalPage
	 * @return
	 *
	 * 
	 */
	public static String showPageFormHtml(int currentPage, int pages, int rows,int currPage,int totalPage) {
		String pageHtml = "<div class=\"am-fr\">"; //到首页
		pageHtml+="<ul class=\"am-pagination tpl-pagination\">";
		if(pages > 0){
			pageHtml+="<li><a href=\"javascript:void(0);\" onclick='return gotoFormPage(1)'>首页</a></li>";
			if(currentPage > 1){			
				pageHtml += "<li><a href=\"javascript:void(0);\" onclick='return gotoFormPage(" + (currentPage - 1) + ")'>上一页</a></li>";
			}
			
			int beginPage = pages - 3 < 1 ? 1 : pages - 3;
			if (beginPage <= totalPage) {
				int i = beginPage;
				for (int j = 0; (i <= totalPage) && (j < 6); j=j+1) {
					pageHtml = pageHtml + "<li><a href=\"javascript:void(0);\" onclick='return gotoFormPage(" + i + ")'>"+i+"</a></li>";
					i=i+1;
				}
			}
			if(pages < totalPage){
				pageHtml += "<li><a href=\"javascript:void(0);\" onclick='return gotoFormPage(" + (currentPage + 1) + ")'>下一页</a></li>"; //到末页			
			}
			pageHtml += "<li><a href=\"javascript:void(0);\" onclick='return gotoFormPage(1)'>末页</a></li>"; //到末页
		}
		pageHtml+="</ul></div>";
		return pageHtml;
	}
	
	/**
	 * 
	 * @param url  跳转的url - 传空
	 * @param staticURL 传空
	 * @param params 传空
	 * @param PageList 
	 * @param modelMap
	 */
	public static void savePageModelMap(String url, String staticURL, String params, PageList<?> page, ModelMap modelMap) {
		if (page != null) {
			modelMap.addAttribute("objs", page.getResult());
			modelMap.addAttribute("totalPage", page.getPages());
			modelMap.addAttribute("pageSize", page.getPageSize());
			modelMap.addAttribute("rows", page.getRowCount());
			modelMap.addAttribute("currentPage", page.getCurrentPage());
			modelMap.addAttribute("gotoPageJsp", showPageFormHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("headPageJsp", pageFormHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("pageFormHeadHtml", pageFormHeadHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("pageHtml", pageHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
		}
	}
	
	
	public static void savePageModelMap1(String url, String staticURL, String params, PageList<?> page, ModelMap modelMap) {
		if (page != null) {
			modelMap.addAttribute("objs1", page.getResult());
			modelMap.addAttribute("totalPage1", page.getPages());
			modelMap.addAttribute("pageSize1", page.getPageSize());
			modelMap.addAttribute("rows1", page.getRowCount());
			modelMap.addAttribute("currentPage1", page.getCurrentPage());
			modelMap.addAttribute("gotoPageJsp1", showPageFormHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("headPageJsp1", pageFormHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("pageFormHeadHtml1", pageFormHeadHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("pageHtml1", pageHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
		}
	}
	
	
	
	public static void savePageModelMap2(String url, String staticURL, String params, PageList<?> page, ModelMap modelMap) {
		if (page != null) {
			modelMap.addAttribute("objs2", page.getResult());
			modelMap.addAttribute("totalPage2", page.getPages());
			modelMap.addAttribute("pageSize2", page.getPageSize());
			modelMap.addAttribute("rows2", page.getRowCount());
			modelMap.addAttribute("currentPage2", page.getCurrentPage());
			modelMap.addAttribute("gotoPageJsp2", showPageFormHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("headPageJsp2", pageFormHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("pageFormHeadHtml2", pageFormHeadHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			modelMap.addAttribute("pageHtml2", pageHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
		}
	}
	
	
	
	/**
	 * <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>

	 * @param currentPage
	 * @param pages
	 * @param rows
	 * @param currPage
	 * @param totalPage
	 * @return
	 */
	public static String pageFormHtml(int currentPage, int pages, int rows,int currPage,int totalPage) {
		String pageHtml = "<div class=\"message\">共<i class=\"blue\">"+rows+"</i>条记录，当前显示第&nbsp;<i class=\"blue\">"+currPage+"&nbsp;</i>页</div>";
		pageHtml+="<ul class=\"paginList\">";
		if(currentPage-1>=1){
			pageHtml+="<li class=\"paginItem\" onclick='return gotoFormPage(" + (currentPage-1) + ")'><a href=\"javascript:;\"><span class=\"pagepre\"></span></a></li>";//上一页
		}else{
			pageHtml+="<li class=\"paginItem\" onclick='return gotoFormPage(1)'><a href=\"javascript:;\"><span class=\"pagepre\"></span></a></li>";//上一页
		}
		
		if(pages > 0){
//			int beginPage = pages - 3 > 1 ? 1 : pages - 3;
//			if (beginPage <= totalPage) {
//				int i = beginPage;
//				for (int j = 0; (i <= totalPage) && (j < 6); j=j+1) {
//					if(currentPage == i){
//						pageHtml = pageHtml + "<li class=\"paginItem\"  onclick='return gotoFormPage(" + i + ")'><a href=\"javascript:;\"><font color='red'>"+i+"</font></a></li>";
//					}else{
//						pageHtml = pageHtml + "<li class=\"paginItem\"  onclick='return gotoFormPage(" + i + ")'><a href=\"javascript:;\">"+i+"</a></li>";
//					}
//					i=i+1;
//				}
//			}
			if(currentPage>=3){
				for(int i=currentPage-2;i<=currentPage;i++){
					if(i<=pages){
					pageHtml = pageHtml + "<li class=\"paginItem\"  onclick='return gotoFormPage(" + i + ")'><a href=\"javascript:;\">"+i+"</a></li>";
					}
				}
				for(int i=currentPage+1;i<=currentPage+3;i++){
					if(i<=pages){
					pageHtml = pageHtml + "<li class=\"paginItem\"  onclick='return gotoFormPage(" + i + ")'><a href=\"javascript:;\">"+i+"</a></li>";
					}
				}
			}else{
				for(int i=1;i<=6;i++){
					if(i<=pages){
					pageHtml = pageHtml + "<li class=\"paginItem\"  onclick='return gotoFormPage(" + i + ")'><a href=\"javascript:;\">"+i+"</a></li>";
					}
				}
			}
			
			if(currentPage+1<=totalPage){
				pageHtml = pageHtml + "<li class=\"paginItem\" onclick='return gotoFormPage(" + (currentPage+1) + ")'><a href=\"javascript:;\"><span class=\"pagenxt\"></span></a></li>";
				
			}else{
				pageHtml = pageHtml + "<li class=\"paginItem\" onclick='return gotoFormPage(" + totalPage + ")'><a href=\"javascript:;\"><span class=\"pagenxt\"></span></a></li>";
			}
			
		}
		pageHtml+="</ul>";
		return pageHtml;
	}

	
}

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.anniushouye{
	position: relative;
	display: inline-block;
	padding: 6px 12px;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	background-color: #ecf0f1;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	  touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	 -moz-user-select: none;
	  -ms-user-select: none;
	      user-select: none;
	border: 1px solid #ecf0f1;
	border-radius: 4px;
}
.anniushouyes{
	color: #ffffff;
	background-color: #BCD2EE;
	border: 1px solid #BCD2EE;
}
.anniumoye{
	position: relative;
	display: inline-block;
	margin-left:8px;
	padding: 6px 12px;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	background-color: #ecf0f1;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	  touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	 -moz-user-select: none;
	  -ms-user-select: none;
	      user-select: none;
	border: 1px solid #ecf0f1;
	border-radius: 4px;
}
.anniumoyes{
	color: #ffffff;
	background-color: #BCD2EE;
	border: 1px solid #BCD2EE;
}
	.pageup_nextye{
	position: relative;
	display: inline-block;
	margin-left:8px;
	padding: 6px 12px;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	background-color: #ecf0f1;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	  touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	 -moz-user-select: none;
	  -ms-user-select: none;
	      user-select: none;
	border: 1px solid #ecf0f1;
	border-radius: 4px;
}
.pageup_nextyes{
	color: #ffffff;
	background-color: #CFCFCF;
	border: 1px solid #CFCFCF;
}

	.pagecountye{
	position: relative;
	display: inline-block;
	margin-left:8px;
	margin-top:8px;
	padding: 6px 12px;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	background-color: #ecf0f1;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	  touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	 -moz-user-select: none;
	  -ms-user-select: none;
	      user-select: none;
	border: 1px solid #ecf0f1;
	border-radius: 4px;
}
.pagecountyes{
	color: #ffffff;
	background-color: #CFCFCF;
	border: 1px solid #CFCFCF;
}
</style>
<div style="text-align: center;margin-bottom: 10px;">
<c:if test="${page.totalPages>1}">
		<input type="hidden" name="pageNumber" id="pageNumber" value="${page.pageable.pageNumber}"/>
		<div class="pages fl_r" id="pager">
			<a class="anniushouye anniushouyes" href="javascript:pageSkip('1');">首页</a>
			<c:if test="${page.pageable.pageNumber!=1}">
				<a class="pageup_nextye pageup_nextyes" href="javascript:pageSkip(${page.previousPageNumber});">上一页</a>
			</c:if>
			
			<c:if test="${page.pageable.pageNumber!=page.totalPages&&page.pageable.pageNumber<page.totalPages}">
				<a class="pageup_nextye pageup_nextyes" href="javascript:pageSkip(${page.nextPageNumber});">下一页</a>
			</c:if>
			<a class="anniumoye anniumoyes" href="javascript:pageSkip(${page.totalPages});">末页</a><br>
			<label class="pagecountye pagecountyes">第${page.pageable.pageNumber}/${page.totalPages}页|总记录数：${page.total}条</label>
		</div>
	</c:if>
	</div>
	<script>
	//分页
	function pageSkip(pageNumber){
		var $listForm = $("#listForm");
		var $pageNumber = $("#pageNumber");
		$pageNumber.val(pageNumber);
		$listForm.submit();
		return false;
	}
	</script>
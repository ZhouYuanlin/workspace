<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${page.totalPages>1}">
		<div style="height:10px;"></div>
		<input type="hidden" name="pageNumber" id="pageNumber" value="${page.pageable.pageNumber}"/>
		<div class="pages fl_r" id="pager" style="font-size: 17px;font-weight: bold;">
			<a class="first" href="javascript:pageSkip('1');">首页</a>
			<c:if test="${page.pageable.pageNumber!=1}">
				<a href="javascript:pageSkip(${page.previousPageNumber});">上一页</a>
			</c:if>
			<c:choose>
				<c:when test="${page.totalPages>page.pageable.showPageNumber}">
					<fmt:parseNumber var="segmentPage" type="number" integerOnly="true" value="${page.pageable.showPageNumber/2}"></fmt:parseNumber>
					<c:choose>
						<c:when test="${page.pageable.pageNumber>segmentPage+1}">
							<c:choose>
								<c:when test="${page.pageable.pageNumber+segmentPage<page.totalPages}">
									<a href="#">...</a>
									<c:forEach begin="${page.pageable.pageNumber-segmentPage}" end="${page.pageable.pageNumber+segmentPage}" var="i">
										<a class="pgnum <c:if test="${i==page.pageable.pageNumber}">pgclick</c:if>" href="javascript:pageSkip(${i});">${i}</a>
									</c:forEach>
									<a href="#">...</a>
								</c:when>
								<c:otherwise>
								    <li class="disa"><a href="#">...</a></li>
									<c:forEach begin="${page.pageable.pageNumber-segmentPage}" end="${page.totalPages}" var="i">
										<a class="pgnum <c:if test="${i==page.pageable.pageNumber}">pgclick</c:if>" href="javascript:pageSkip(${i});">${i}</a>
									</c:forEach>
								</c:otherwise>
							</c:choose>	
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${page.pageable.showPageNumber<page.totalPages}">
										<c:forEach begin="1" end="${page.pageable.showPageNumber}" var="i">
											<a class="pgnum <c:if test="${i==page.pageable.pageNumber}">pgclick</c:if>" href="javascript:pageSkip(${i});">${i}</a>
										</c:forEach>
										<a href="#">...</a>
								</c:when>
								<c:otherwise>
									<c:forEach begin="1" end="${page.totalPages}" var="i">
										<a class="pgnum <c:if test="${i==page.pageable.pageNumber}">pgclick</c:if>" href="javascript:pageSkip(${i});">${i}</a>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:forEach begin="1" end="${page.totalPages}" var="i">
						<a class="pgnum <c:if test="${i==page.pageable.pageNumber}">pgclick</c:if>" href="javascript:pageSkip(${i});">${i}</a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			<c:if test="${page.pageable.pageNumber!=page.totalPages&&page.pageable.pageNumber<page.totalPages}">
				<a href="javascript:pageSkip(${page.nextPageNumber});">下一页</a>
			</c:if>
			<a class="last" href="javascript:pageSkip(${page.totalPages});">末页</a>
			<label class="fleft" style="font-size: 17px;margin-top: 3px;">第 ${page.pageable.pageNumber}/${page.totalPages} 页 | 总记录数：${page.total} 条</label>
		</div>
	</c:if>
	<script>
	//分页
	function pageSkip(pageNumber){
		var $listForm = $("#form");
		var $pageNumber = $("#pageNumber");
		$pageNumber.val(pageNumber);
		$listForm.submit();
		return false;
	}
	</script>
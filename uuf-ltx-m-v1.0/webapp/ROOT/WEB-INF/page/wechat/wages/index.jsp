<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>工资查看</title>
<meta http-equiv="Cache-Control" name="no-store">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet" href="${request.getContextPath}/resources/wechat/custom/css/style.css"/>
<link rel="stylesheet" href="${request.getContextPath}/resources/wechat/custom/css/home.css"/>
<link rel="stylesheet" href="${request.getContextPath}/resources/wechat/custom/css/page.css"/>
<script src="${request.getContextPath}/resources/framework/custom/base/js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>
<body class="salary">
<c:if test="${not empty page.content}">
<form id="listForm" action="${request.getContextPath}/wechat/wages/index" method="post">
<div class="top">

    <h3>本月工资  (${getMonthFirstDay} ~ ${getMonthEndDay})</h3>
    <!--<h2>￥7654.32元</h2>-->
    <div style="height:60px;"></div>
	<div class="SY_content">
		<div class="SY_headfream">
			<div class="SY_headone">发放月份</div>
			<div class="SY_headone">财统工资</div>
			<div class="SY_headone">本级津补贴</div>
			<div class="SY_headone">合计</div>
		</div>
		
		<c:forEach items="${page.content}" var="item" varStatus="c">
			<div class="SY_content_two" ref="${item.id}" onclick="pointDetail(this);" style="text-align: left;">
				<div class="SY_twoa "><span>${item.yf}</span></div>
				<div class="SY_twoa">￥<c:if test="${not empty item.sfxj}"><fmt:formatNumber type="number" value="${item.sfxj}" pattern="0.00" maxFractionDigits="2"/></c:if><c:if test="${empty item.sfxj}">0.00</c:if></div>
				<div class="SY_twoa">￥<c:if test="${not empty item.bjjbt.sfgz}"><fmt:formatNumber type="number" value="${item.bjjbt.sfgz}" pattern="0.00" maxFractionDigits="2"/></c:if><c:if test="${empty item.bjjbt.sfgz}">0.00</c:if></div>
				<div class="SY_twoa">￥<c:if test="${not empty item.sfxj || not empty item.bjjbt.sfgz}"><fmt:formatNumber type="number" value="${item.sfxj+item.bjjbt.sfgz}" pattern="0.00" maxFractionDigits="2"/></c:if><c:if test="${empty item.sfxj && empty item.bjjbt.sfgz}">0.00</c:if></div>
			</div>
		</c:forEach>
		<div style="height: 10px;"></div>
		<jsp:include page="../_include/_pageinfo.jsp"></jsp:include>
		
	</div>
</div>
</form>
</c:if>
<script>
$(document).ready(function(){
    $(window).scroll(function(){
		var scrollnav = $("body").scrollTop();
		if(scrollnav>205){
			$(".navtit").addClass("real");
		}else{
			$(".navtit").removeClass("real");
		};
	});
});

function pointDetail(obj){
	var id = $(obj).attr("ref");
	var url="${request.getContextPath}/wechat/wages/detail?id="+id;
	window.location.href=url;
}
</script>

</body>
<c:if test="${empty page.content}">
        	<jsp:include page="../resultless.jsp"></jsp:include>
</c:if>
</html>
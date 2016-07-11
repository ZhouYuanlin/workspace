<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>搜索</title>
<meta http-equiv="Cache-Control" name="no-store">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/css/aui.css" />
<script src="${request.getContextPath}/resources/framework/custom/base/js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>

<body class="search">
<header class="aui-bar aui-bar-nav aui-bar-dark">
	    <div class="aui-title">人员检索</div>
</header>
<form id="searchform" action="<c:url value='${request.contextPath}/wechat/personal/search/detail'/>" method="post">
	
<div class="aui-card" style="margin-top: 20px;">
        <ul>
        	<li><input type="text" id="xm" class="name" name="xm" placeholder="请输入姓名"></li>
        	<li><input type="text" id="sfzh" class="idnum" name="sfzh" placeholder="请输入身份证号"></li>
        	<c:if test="${empty dw}">
        	<li><select id="dwmc" name="dwb.name" class="form-control col-md-12">
					<option value="">---请选择部门---</option>
					<c:forEach items="${dwList}" var="item">
						<option value="${item.name}">${item.name}</option>
					</c:forEach>
				</select></li></c:if>
			<li><select name="party.dzbmc" class="form-control col-md-12">
				<option value="">---请选择党支部---</option>
				<c:forEach items="${partyList}" var="item">
					<c:if test="${item.sfsc=='否'}">
						<option value="${item.dzbmc}">${item.dzbmc}</option>
					</c:if>
				</c:forEach>
			</select></li>
        	
        	<!-- <li><input id="dwmc" name="dwb.name" type="text" placeholder="请输入所在部门"></li>
        	<li><input  name="party.dzbmc" type="text" placeholder="请输入所在党支部"></li> -->
        </ul>
        <div class="aui-btn-row"  onclick="doSearch();">
            <div class="aui-btn aui-btn-block aui-btn-success">搜索</div>
        </div>
    </div>
</form>
<script>
function doSearch(){
	$('#searchform').attr('action','${request.getContextPath}/wechat/personal/search/detail').submit();
}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <title>搜索</title>
    <meta http-equiv="Cache-Control" name="no-store">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" href="${request.getContextPath}/resources/wechat/custom/css/home.css" />
    <link rel="stylesheet" href="${request.getContextPath}/resources/wechat/custom/css/page.css"/>
    <link rel="stylesheet" href="${request.getContextPath}/resources/wechat/css/aui.css"/>
    <link rel="stylesheet" href="${request.getContextPath}/resources/wechat/css/aui-iconfont.css"/>
    <script src="${request.getContextPath}/resources/framework/custom/base/js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>
<body>
<form id="listForm" action="${request.getContextPath}/wechat/personal/search/detail" method="post">
		<input type="hidden" name="xm" value="${ret.xm}">
		<input type="hidden" name="sfzh" value="${ret.sfzh}">
		<input type="hidden" name="dwb.name" value="${ret.dwb.name}">
		<input type="hidden" name="party.dzbmc" value="${ret.party.dzbmc}">
		
     	<c:if test="${not empty page.content}"><p class="aui-text-left aui-padded-15 LT-fontp">根据查询条件检索出<span style="color:#ffae00">${page.total}</span>个信息</p>
            <!-- <p>根据查询条件检索出<span>${page.total}</span>个信息</p> -->
        
        		<div class="aui-content">
				    <ul class="aui-list-view ">
				    <c:forEach items="${page.content}" var="item" varStatus="c">
				        <li class="aui-list-view-cell"  ref="${item.sfzh}" onclick="pointDetail(this);">
				            <div class="aui-arrow-right ">
				                <ul>
				                    <li class="aui-col-xs-5">${item.xm}</li>
				                    <li class="aui-col-xs-7">${item.dwb.name}</li>
				                </ul>
				                
				            </div>
				        </li>
				         </c:forEach>
				    <jsp:include page="../_include/_pageinfo.jsp"></jsp:include>
				    </ul>
				</div>
		        <!-- <div class="SE_two_2" ref="${item.sfzh}" style="margin-left: 40px;" onclick="pointDetail(this);">
		            <div class="SE_two_2a"></div>
		            <div class="SE_two_2b">
		                <P><B>${item.xm}</B></P>
		                <P class="SE_two_2bp">${item.dwb.name}</P>
		            </div>
		            <div class="SE_two_2c"><img src="${request.getContextPath}/resources/wechat/img/right.png" alt=""/></div>
		        </div> -->
        </c:if>
        <c:if test="${empty page.content}">
        	<jsp:include page="resultless.jsp"></jsp:include>
        </c:if>
</form>
</body>
<script type="text/javascript">
function pointDetail(obj){
	var sfzh = $(obj).attr("ref");
	var url = "${request.getContextPath}/wechat/personal/info?sfzh="+sfzh;
	window.location.href=url;
}
</script>
</html>
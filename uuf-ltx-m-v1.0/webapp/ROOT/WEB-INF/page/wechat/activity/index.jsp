<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
<title>活动管理</title>
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/css/aui.css" />
<script src="${request.getContextPath}/resources/framework/custom/base/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<style type="text/css">
    .aui-input-addon.aui-iconfont {
        font-size: 20px !important;
    }
    .aui-input-row {
        width: 100% !important;
    }
    .aui-btn-row:after{
    	border-bottom:none;
    }
    .aui-bar-warning {
    	background-color: #1A459E;
	}
	.aui-list-view.aui-grid-view .aui-list-view-cell .aui-img-object {
    width: 100%;
    max-width: 100%;
    height: auto;
	}
	.aui-btn-row {
    position: relative;
    text-align: center;
    padding: 0px;
	}
	button, .aui-btn{
	display: block;	
	}
    </style>
</head>
<body style="background:#FFFFFF;">
<header class="aui-bar aui-bar-nav aui-bar-dark">
	    <div class="aui-title">活动管理</div>
</header>
<form style="margin-top: 10px;" id="listForm" action="${request.getContextPath}/wechat/activity/index" method="post">
<c:if test="${not empty page.content}">
<div class="aui-content-padded">
        <ul>
        	<c:forEach items="${page.content}" var="item" varStatus="c">
            <li class="aui-list-view" style="background-color: #E5E5E5">
                <div class="aui-user-view-cell aui-img" ref="${item.id}" onclick="showDetail(this);">
                    <!--<img class="aui-img-object aui-pull-left" src="../../../image/demo4.png">-->
                    <div class="aui-img-body">
                        <span>${item.name}</span>
                        <p class='aui-ellipsis-1' style="font-size:14px;color:red;">活动时间：${item.hdsj} 至 ${item.hdsjjz}</p>
                    </div>
                </div>
                <div class="aui-padded-10 content">
                		${fn:substring(item.hdsm,0,50)}
	            		<c:if test="${fn:length(item.hdsm)>50}">
	            			...
	            		</c:if>
                   		
                </div>
                <ul class="aui-list-view aui-grid-view" style="background-color: #E5E5E5" ref="${item.id}" onclick="showDetail(this);">
                    <li class="aui-list-view-cell aui-img aui-col-xs-12">
                    	<c:if test="${not empty item.imgurl}">
                             <img class="aui-img-object"  src="${request.getContextPath}/${item.imgurl}" >
                       	</c:if>
                       	<c:if test="${empty item.imgurl}">
                            <h2 class="aui-img-object" style="color:#CFCFCF;">暂无图片</h2>
                       	</c:if>
                    </li>
                </ul>
            </li>
            </c:forEach>
            
     		<jsp:include page="../_include/_pageinfo.jsp"></jsp:include>
        </ul>
    </div>
    </c:if>
</form>

</body>
 <c:if test="${empty page.content}">
        		<jsp:include page="../resultless.jsp"></jsp:include>
   	</c:if>
<script type="text/javascript">
	
	//点击查看某活动详情
	function showDetail(obj){
		var id = $(obj).attr("ref");
		var url="${request.getContextPath}/wechat/activity/showDetail?id="+id;
		window.location.href=url;
		
	}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
<meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
<title>离退休</title>
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/css/auis.css" />
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/css/aui-iconfonts.css" />
</head>
<style type="text/css">
	.aui-grid-sixteen li{
        border-bottom: 1px solid #c8c7cc;
    }
</style>
<body style="background-color: white">
    <div class="aui-content">
    	<img src="${request.getContextPath}/resources/wechat/img/LTX-banner.png" alt="" class="aui-img aui-img-object" style="width: 100%;display: block"/>  	
        <ul class="aui-grid-sixteen">
        	<c:if test="${scope=='个人' || empty scope}">
            <li class="aui-col-xs-3 aui-text-center" onclick="openWin('${request.getContextPath}/wechat/personal/index')">
                <img src="${request.getContextPath}/resources/wechat/img/19.png" alt="" class="aui-img aui-img-object" style="width: 45%"/>
                <p>个人档案</p>
            </li>
        	</c:if>
        	<c:if test="${scope=='个人' || empty scope}">
            <li class="aui-col-xs-3 aui-text-center" onclick="openWin('${request.getContextPath}/wechat/wages/index')">
                <img src="${request.getContextPath}/resources/wechat/img/18.png" alt="" class="aui-img aui-img-object" style="width:45%"/>
                <p>工资查询</p>
            </li>
            </c:if>
            <c:if test="${scope=='个人' || empty scope}">
            <li class="aui-col-xs-3 aui-text-center" onclick="openWin('${request.getContextPath}/wechat/activity/index')">
                <img src="${request.getContextPath}/resources/wechat/img/16.png" alt="" class="aui-img aui-img-object" style="width: 45%"/>
                <p>活动报名</p>
            </li>
            </c:if>
              <c:if test="${scope=='全部' || empty scope}">
            <li class="aui-col-xs-3 aui-text-center" onclick="openWin('${request.getContextPath}/wechat/statistics/index')">
                <img src="${request.getContextPath}/resources/wechat/img/25.png" alt="" class="aui-img aui-img-object" style="width: 45%"/>
                <p>统计分析</p>
            </li>
            </c:if>
            <c:if test="${scope!='个人' || empty scope}">
            <li class="aui-col-xs-3 aui-text-center" onclick="openWin('${request.getContextPath}/wechat/personal/journal')">
                <img src="${request.getContextPath}/resources/wechat/img/13.png" alt="" class="aui-img aui-img-object" style="width: 45%"/>
                <p>日程安排</p>
            </li>
            </c:if>
            <c:if test="${scope!='个人' || empty scope}" >
            <li class="aui-col-xs-3 aui-text-center"  onclick="openWin('${request.getContextPath}/wechat/personal/search')">
                <img src="${request.getContextPath}/resources/wechat/img/17.png" alt="" class="aui-img aui-img-object" style="width: 45%"/>
                <p>人员查询</p>
            </li>
            </c:if>
            <li class="aui-col-xs-3 aui-text-center"  onclick="openWin('${request.getContextPath}/wechat/activity/showActivitys')">
                <img src="${request.getContextPath}/resources/wechat/img/16.png" alt="" class="aui-img aui-img-object" style="width: 45%"/>
                <p>活动报名(新)</p>
            </li>
            <li class="aui-col-xs-3 aui-text-center"  onclick="openWin('${request.getContextPath}/wechat/personal/center')">
                <img src="${request.getContextPath}/resources/wechat/img/20.png" alt="" class="aui-img aui-img-object" style="width: 45%"/>
                <p>个人中心</p>
            </li>
            <%-- 占位区域,如果图片功能排版不够4个时,在最后一个图片后面添加此块占位区,以补全边框 --%>
            <li class="aui-col-xs-3 aui-text-center" style="border-bottom: none">
                <img src="${request.getContextPath}/resources/wechat/img/kongbai.png" alt="" class="aui-img aui-img-object" style="width: 45%"/>
                <p style="color: white;border-bottom: none">占位图片</p>
            </li>
        </ul>
    </div>
</body>
<script type="text/javascript" src="${request.getContextPath}/resources/wechat/script/api.js" ></script>
<script type="text/javascript">
	function openWin(url){
		window.location.href=url;
	}

</script>
</body>
</html>
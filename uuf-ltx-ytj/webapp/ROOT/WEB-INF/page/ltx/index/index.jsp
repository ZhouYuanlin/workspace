<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>个人信息</title>
    <link rel="stylesheet" href="${request.getContextPath}/resources/ytj/css/bootstrap.css"/>
    <link rel="stylesheet" href="${request.getContextPath}/resources/ytj/css/style.css"/>
</head>
<body style="background-color:#f5f5f5">
<div class="all-baoguoone">
    <div class="container head">
        <img class="headimg" src="${request.getContextPath}/resources/ytj/images/logo.png" alt=""/>
        <span class="headfont">离退休人员多功能触摸自助查询一体机</span>
    </div>
</div>
<div class="all-baoguotwo">
     <div class="container">
         <div class="row">
             <div class="col-md-12">
                 <h4 class="col-md-11 col-md-offset-1 mt-10">${account.realname}，您好！</h4>
             </div>
             <div class="mt-10 col-md-12 dl-center">
                 <div class="col-md-3" onclick="openUrl('${request.getContextPath}/ytj/grxx/index')">
                     <div class="col-md-12"><img src="${request.getContextPath}/resources/ytj/images/home1-1.png" alt=""/></div>
                     <div class="col-md-12 mt-10">个人信息</div>
                 </div>
                 <div class="col-md-3" onclick="openUrl('${request.getContextPath}/ytj/wages/index')">
                     <div class="col-md-12"><img src="${request.getContextPath}/resources/ytj/images/home1-2.png" alt=""/></div>
                     <div class="col-md-12 mt-10">工资查询</div>
                 </div>
                 <div class="col-md-3" onclick="openUrl('${request.getContextPath}/ytj/health/index')">
                     <div class="col-md-12"><img src="${request.getContextPath}/resources/ytj/images/home1-3.png" alt=""/></div>
                     <div class="col-md-12 mt-10">体检信息</div>
                 </div>
                 <div class="col-md-3">
                     <div class="col-md-12"><img src="${request.getContextPath}/resources/ytj/images/home1-4.png" alt=""/></div>
                     <div class="col-md-12 mt-10">社保信息</div>
                 </div>
                 <div class="col-md-3 mt-20">
                     <div class="col-md-12"><img src="${request.getContextPath}/resources/ytj/images/home2-1.png" alt=""/></div>
                     <div class="col-md-12 mt-10">服务指南</div>
                 </div>
                 <div class="col-md-3 mt-20">
                     <div class="col-md-12"><img src="${request.getContextPath}/resources/ytj/images/home2-2.png" alt=""/></div>
                     <div class="col-md-12 mt-10">通知公告</div>
                 </div>
                 <div class="col-md-3 mt-20">
                     <div class="col-md-12"><img src="${request.getContextPath}/resources/ytj/images/home2-3.png" alt=""/></div>
                     <div class="col-md-12 mt-10">活动报名</div>
                 </div>
                 <div class="col-md-3 mt-20">
                     <div class="col-md-12"><img src="${request.getContextPath}/resources/ytj/images/home2-4.png" alt=""/></div>
                     <div class="col-md-12 mt-10">留言板</div>
                 </div>
             </div>
         </div>
     </div>
</div>
</body>
<script type="text/javascript">
	function openUrl(url){
		window.location.href=url;
	}
</script>
</html>
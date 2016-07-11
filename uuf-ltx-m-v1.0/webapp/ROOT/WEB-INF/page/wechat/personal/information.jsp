<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
<title>个人资料</title>
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/custom/css/style.css" />
</head>
<body class="info">
<div class="top">
	<div class="topimg" style="background-image:url(${request.getContextPath}/resources/wechat/img/topimg.jpg)"></div>
    <div class="userdetail">
        <div class="userimg">
        	<c:choose>
	        	<c:when test="${empty file}">
        			<img src="${request.getContextPath}/upload/photo/101010195210200915.jpg" alt="" style="width: 102px;height: 102px"/>
	        	</c:when>
	        	<c:otherwise>
		       		<img src="${request.getContextPath}/upload/photo/${file}.jpg" alt="" style="width: 102px;height: 102px"/>
	        	</c:otherwise>
	        </c:choose>
        </div>
        <div class="username">
            <h3>${account.realname}</h3>
            <div class="usericon"></div>
            <div class="usericon"></div>
            <div class="userinfo">${account.gzzh}</div>
    	</div>
    </div>
</div>
<div class="content">
	<div class="container">
    	<div class="row">
        	<div class="label">登录名：</div>
            <div class="labelval">${account.username}</div>
        </div>
    </div>
    <div class="container">
        <div class="row">
        	<div class="label">真实姓名：</div>
            <div class="labelval">${account.realname}</div>
        </div>
   	</div>
   	<div class="container">
    	<div class="row">
        	<div class="label">状态：</div>
            <div class="labelval">${account.status}</div>
        </div>
   	</div>
   	<div class="container">
        <div class="row">
        	<div class="label">账号到期时间：</div>
            <div class="labelval"><c:if test="${empty account.dqsj}">未限制</c:if><c:if test="${not empty account.dqsj}">${account.dqsj}</c:if></div>
        </div>
    </div>
    <div class="container">
    </div>
</div>
</body>
</html>
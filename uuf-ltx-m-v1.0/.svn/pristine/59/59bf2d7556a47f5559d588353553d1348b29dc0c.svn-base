<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
<meta name="format-detection" content="telephone=no">
<meta http-equiv="x-rim-auto-match" content="none">
<title>个人资料</title>
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/custom/css/style.css" />
</head>
<body class="info">
<div class="top">
	<div class="topimg" style="background-image:url(${request.getContextPath}/resources/wechat/img/topimg.jpg)"></div>
    <div class="userdetail">
        <div class="userimg"><img src="${request.getContextPath}/upload/photo/101010195210200915.jpg" alt="" style="width: 102px;height: 102px"/></div>
        <div class="username">
            <h3>${personal.xm}</h3>
            <div class="usericon"></div>
            <div class="usericon"></div>
            <div class="userinfo">${personal.party.dzbmc}</div>
    	</div>
    </div>
</div>
<div class="content">
	<div class="container">
    	<div class="row">
        	<div class="label">性别：</div>
            <div class="labelval">${personal.xb}</div>
        </div>
        <div class="row">
        	<div class="label">出生日期：</div>
            <div class="labelval">${personal.csrq}</div>
        </div>
    	<div class="row">
        	<div class="label">民族：</div>
            <div class="labelval">${personal.mzb.name}</div>
        </div>
        <div class="row">
        	<div class="label">政治面貌：</div>
            <div class="labelval">${personal.zzmm.name}</div>
        </div>
         <div class="row">
        	<div class="label">离退休类别：</div>
            <div class="labelval">${personal.lxb.name}</div>
        </div>
        <div class="row">
        	<div class="label">现享受待遇：</div>
            <div class="labelval">${personal.xsdy}</div>
        </div>
    </div>
    <div class="container">
        <div class="row">
        	<div class="label">原工作单位：</div>
            <div class="labelval">${personal.dwb.name}</div>
        </div>
    	<div class="row">
        	<div class="label">参加工作时间：</div>
            <div class="labelval">${personal.gzsj}</div>
        </div>
        <div class="row">
        	<div class="label">离退休时间：</div>
            <div class="labelval">${personal.lxsj}</div>
        </div>
    </div>
	<div class="container">
        <c:if test="${fn:length(address)<12}">
			<div class="row">
        		<div class="label">地址：</div>
            	<div class="labelval">${address}</div>
       		</div>
        </c:if>
       	<c:if test="${fn:length(address)>12 && fn:length(address)<=24}">
			<div class="row">
        		<div class="label">地址：</div>
            	<div class="labelval" style="height: 40px;line-height: 20px;">${fn:substring(address,0,12)}<br>${fn:substring(address,12,24)}</div>
       		</div>
        </c:if>
        <c:if test="${fn:length(address)>24}">
			<div class="row" style="height: 50px;">
        		<div class="label">地址：</div>
            	<div class="labelval" style="line-height: 17px;">${fn:substring(address,0,12)}<br>${fn:substring(address,12,24)}<br>${fn:substring(address,24,36)}</div>
       		</div>
        </c:if>
        <div class="row">
        	<div class="label">联系电话：</div>
            <div class="labelval"><a style="color: green;" href="tel:${personal.lxdh}">${personal.lxdh}</a></div>
        </div>
    </div>
    <div class="container">
    </div>
</div>
</body>
</html>
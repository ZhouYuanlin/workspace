<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8"/>
<title>${xmmc}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<link href="/defaults/css/main.css" rel="stylesheet" type="text/css"/>
<link href="/defaults/css/login.css" rel="stylesheet" type="text/css"/>
<link href="/defaults/plugins/flexslider/flexslider.css" rel="stylesheet" type="text/css"/>
<script src="/defaults/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="/defaults/js/StringToMD5.js" type="text/javascript"></script>
<script src="/defaults/js/unslider.js" type="text/javascript" ></script>
<script src="/defaults/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/defaults/plugins/excanvas.min.js"></script>
<script src="/defaults/plugins/respond.min.js"></script>
<script src="/defaults/plugins/flexslider/jquery.flexslider-min.js" type="text/javascript" ></script>
</head>
<body class="login">
<div class="logo">
	${xmmc}
</div>
<div class="login-warp">
<div class="flexslider">
  <ul class="slides">
  	<c:forEach items="${clist}" var="item">
    <li>
      <img src="/upload/images/${item.imgpath}" />
    </li>
    </c:forEach>
  </ul>
</div>
<div class="login-center">
<div class="content">
	<form class="login-form" action="<c:url value='${request.contextPath}/auth/main'/>" method="post" onsubmit="validator()">
		<h3 class="form-title">用户登录</h3>
		<div class="alert alert-danger display-hide">
			<button class="close" data-close="alert"></button>
			<span>Enter any username and password. </span>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">帐号</label>
			<div class="input-icon">
				<i class="fa fa-user"></i>
				<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="帐号" id="username" name="username"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">密码</label>
			<div class="input-icon">
				<i class="fa fa-lock"></i>
				<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" id="password" name="password"/>
			</div>
		</div>
		<div class="form-actions">
			<button type="submit" class="btn green btn-block">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录 </button>
		</div>
	</form>
</div>
</div>
</div>
<div class="copyright">
	 ${xmbb}
</div>
<script>
	$(function(){
		<c:if test="${not empty param.kickout}">
			alert("您的账户在别处登录，被迫下线！");
		</c:if>
		<c:if test="${!empty message}">
			alert("${message}");
		</c:if>
		if(window.chrome) {
			$('.banner li').css('background-size', 'auto 100%');
		}
		$('.flexslider').flexslider({
		    animation: "fade",
			slideshowSpeed: 3000,
			directionNav: false
		 });
	});
	function validator(){
		$('#password').val(MD5($('#password').val()));
	}
	</script>
</body>
</html>
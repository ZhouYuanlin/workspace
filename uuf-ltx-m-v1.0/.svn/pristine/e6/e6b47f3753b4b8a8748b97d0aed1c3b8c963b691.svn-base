<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.lang.ArrayUtils"%>
<%@page import="cn.uuf.stu.framework.common.SystemParamter" %>
<%@page import="cn.uuf.stu.framework.util.SystemParamterUtils" %>
<%@page import="cn.uuf.stu.framework.common.SystemParamter.CaptchaType" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<%
	SystemParamter systemParamter = SystemParamterUtils.get();
%>
<!DOCTYPE html>
<!--[if IE 8]><html lang="en" class="ie8"><![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"><![endif]-->
<!--[if IE]> <html lang="en" class="ie"><![endif]-->
<!--[if !IE]><!--><html lang="en"><!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8">
    <title>离退休微信管理平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="离退休微信管理平台">
    <meta name="author" content="tangp">
    <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/bootstrap/bootstrap.min.css">
    <link href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/main.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/custom/base/css/message.css">
    <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/custom/base/css/login.css">
    <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/plugins/flexslider/flexslider.css">
    
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/jsbn.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/prng4.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/rng.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/rsa.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/base64.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/common.js"></script>
    
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/plugins/excanvas.min.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/plugins/respond.min.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/plugins/flexslider/jquery.flexslider-min.js"></script>
    <script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/unslider.js"></script>
    <script type="text/javascript">
	    $(function(){
	    	var $enPassword = $("#enPassword");
	    	var $username = $("#username");
	    	var $password = $("#password");
	    	var $captcha = $("#captcha");
	    	var $isRememberUsername = $("#isRememberUsername");
	    	var $loginForm = $("#loginForm");
	    	//记住用户名
	    	if(getCookie("adminUsername") != null){ 
	    		$username.val(getCookie("adminUsername"));
				$password.focus();
	    	}
	    	
	    	//表单验证记住用户名
	    	$loginForm.submit(function(){
	    		if($username.val() == ""){
	    			$.message("warn","用户名不能为空！");
	    			return false;
	    		}
	    		if($password.val() == ""){
	    			$.message("warn","密码不能为空！");
	    			return false;
	    		}
	    		//添加用户名到cookie
	    		addCookie("adminUsername", $username.val(), {expires: 7 * 24 * 60 * 60});
	    		
	    		var rsaKey = new RSAKey();
				rsaKey.setPublic(b64tohex("${modulus}"), b64tohex("${exponent}"));
				var enPassword = hex2b64(rsaKey.encrypt($password.val()));
				$enPassword.val(enPassword);
	    	})
	    	if("${message}"!=""){
	    		$.message("error","<spring:message code='${message}' arguments='${failureCount}'/>");
	    	}
	    	
	    	if(window.chrome) {
				$('.banner li').css('background-size', 'auto 100%');
			}
			$('.flexslider').flexslider({
			    animation: "fade",
				slideshowSpeed: 3000,
				directionNav: false
			 });
	    	
	    })
    </script>
</head>
<body class="login">
	<div class="logo">离退休微信管理平台</div>
	<div class="login-warp">
		<div class="flexslider">
			<ul class="slides">
					<li><img src="${request.getContextPath}/resources/framework/custom/base/img/spring.jpg" /></li>
					<li><img src="${request.getContextPath}/resources/framework/custom/base/img/summer.jpg" /></li>
					<li><img src="${request.getContextPath}/resources/framework/custom/base/img/autumn.jpg" /></li>
					<li><img src="${request.getContextPath}/resources/framework/custom/base/img/winter.jpg" /></li>
			</ul>
		</div>
		<div class="login-center">
			<div class="content">
				<form id="loginForm" class="login-form"
					action="${request.getContextPath}/admin/login"
					method="post" >
					<input type="hidden" id="enPassword" name="enPassword" />
					<input type="hidden" id="isRememberUsername" value="true" />
					<h3 class="form-title">用户登录</h3>
					<div class="form-group">
						<label class="control-label visible-ie8 visible-ie9">帐号</label>
						<div class="input-icon">
							<i class="fa fa-user"></i> <input
								class="form-control placeholder-no-fix" type="text"
								autocomplete="off" placeholder="帐号" id="username"
								name="username" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label visible-ie8 visible-ie9">密码</label>
						<div class="input-icon">
							<i class="fa fa-lock"></i> <input
								class="form-control placeholder-no-fix" type="password"
								autocomplete="off" placeholder="密码" id="password"
								name="password" />
						</div>
					</div>
					<div class="form-actions">
						<input type="submit" value="登录"  class="btn green btn-block"/>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="copyright">2015 © 首都经济贸易大学</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
<title>账号首页</title>
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/css/aui.css" />
<script src="${request.getContextPath}/resources/wechat/custom/js/md5.js" type="text/javascript"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/wechat/custom/js/common.js" ></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/jquery-1.11.0.min.js" type="text/javascript"></script>
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
</style>
</head>
<body style="background:#FFFFFF;">
	<div style="height:50px;"></div>
	<form id="frm" action="${request.getContextPath}/wechat/wechatcoreconnect/toLogin" method="post">
	    <div class="aui-content aui-card">
	        <div class="aui-form">
	            <div class="aui-input-row">
	                <i class="aui-input-addon aui-iconfont aui-icon-people aui-text-info"></i>
	                <input type="text" class="aui-input" name="username" id="username"
	                 placeholder="用户名"/>
	            </div>
	            <div class="aui-input-row">
	                <i class="aui-input-addon aui-iconfont aui-icon-lock aui-text-warning"></i>
	                <input type="password" id="password" name="password"
	                data-rule="*" data-nullmsg="密码不能为空" data-errmsg="验证失败" data-sucmsg=""
	                class="aui-input" placeholder="密码"/>
	                <i class="aui-input-addon aui-iconfont aui-icon-attention aui-text-default" tapmode onclick="showPassword();" id="showpass-btn"></i>
	            </div>
	        </div>
	     </div>
	     <div class="aui-btn-row">
	         <div class="aui-btn aui-btn-block aui-btn-primary" id="subBtn">登录</div>
	     </div>
     </form>   
</body>
<script type="text/javascript" src="${request.getContextPath}/resources/wechat/script/api.js" ></script>
<script type="text/javascript">
jQuery(document).ready(function() {    
		$('#subBtn').click(function(){
			
			if($("#username").val()==null||$("#username").val()==''){
				alert("用户名不能为空！");
				$("#username").focus();
				return false;
			}
			
			if($("#password").val()==null||$("#password").val()==''){
				alert("密码不能为空！");
				$("#password").focus();
				return false;
			}
			var data={"username":$("#username").val(),"password":$("#password").val()};
			data.password=(hex_md5(data.password));
			login(data,"");
			
		});
	});

/* 
if(flag!=""){
	if(flag=="true"){
		alert("密码修改成功,请重新登陆!");
	}
} */
var flag = "${message}";
$(function(){
	   if(flag==""){
		   var username = getCookie("username");
		   var password = getCookie("password");
		   if(username!=null && username!="" && password!=null && password!=""){
			   $("#username").attr("value",username);
			   $("#password").attr("value",password);
			   var data={"username":username,"password":password};
			   login("",data);//自动登录
		   }
	   }else{
		   delCookie("username");
		   delCookie("password");
	   }
	   if(flag=="true"){
			alert("密码修改成功,请重新登陆!");
		}
})

function login(data,hexUser){
	var username = "";
	var hexPassword = "";
	if(data!=""){
		username = data.username;
		hexPassword = data.password;
	}
	if(hexUser!=""){
		username = hexUser.username;
		hexPassword = hexUser.password;
	}
	$.post("/wechat/wechatcoreconnect/toLogin?" + (new Date()).getTime(), {
		username : username,
		password : hexPassword
	}, function(result) {
		if(result.type=='error' || result.type=='warn'){
			$('#username').val("");
			$('#password').val("");
			$('#username').focus();
			alert(result.content);
		}
		if(result.type=='success'){
			SetCookie("username", username);
			SetCookie("password", hexPassword);
			setTimeout(function(){
	           window.location.href="/wechat/wechatcoreconnect/index/home";
		     },500)
		}
	});
}
</script>

</body>
</html>
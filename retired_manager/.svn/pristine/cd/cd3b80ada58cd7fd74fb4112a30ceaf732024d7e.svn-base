<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="/script/web/usercenter.js"></script>
	<style>
		.xiaoxi{width:20px;height:32px;padding:0 10px;position:relative}
		.xiaoxi .img{height:18px;margin-top:8px}
		.right *{float:left}
		.xiaoxi .img2{height:10px;position:absolute;top:5;right:5;z-index:2}
		img{border:none}
		.right span{padding-right:8px}
	</style>
	<script type="text/javascript">
		function informcenter(){
			if("${user==null}"=='true'){
				alert("请先登录！");
				window.location.href="/web/tologin";
			}else{
				window.location.href = "/web/infomAction/infomcenter?curPage=1";	
			}
		}
	</script>
  </head>
  
  <body>
   <!--顶部状态栏-->
	<div class="statusBar">
		<div class="main">
			<span class="left">您好，<b><a href="/web/personal/center">${user.nickname }</a></b>&nbsp;</span>
			<span class="right">
				<a href="/web/personal/center">个人中心</a>
				<div class="xiaoxi">
				<a href="javascript:informcenter();" title="消息中心">
					<img class="img" src="../pcui/img/xiaoxi.png" />
					<c:if test="${size == 'ok'}">
						<img class="img2" src="../pcui/img/dian.png" />
					</c:if>
				</a>
				</div>
				<span>|</span>
				<a href="javascript:logout()">退出</a></span>
		</div>
	</div>
	<!--顶部状态栏End-->
  </body>
</html>

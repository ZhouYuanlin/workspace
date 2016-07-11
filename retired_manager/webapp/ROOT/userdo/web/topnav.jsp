<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>科技成果</title>
    <link rel="stylesheet" href="/pcui/css/all.css" />
    <link rel="stylesheet" href="/pcui/css/index.css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	.searchbutton{
		width:90px;height:36px;border:none;color:#FFF;background: #FF7007;cursor: pointer;
	}
	</style>
	<script type="text/javascript">
	//个人中心登录验证
	function toPersonalCenter(){
		if("${user==null}"=='true'){
			alert("请先登录");
			window.location.href="/web/tologin";
		}
		else{
			window.location.href="/web/personal/center";
		}
	}
	</script>
  </head>
  
  <body>
  <!--头部-->
		<div class="header">
			<div class="main">
				<div class="left">
					<a href="/"><img src="/pcui/img/logo.png" /></a>
				</div>
				<div class="right">
					<form action="/web/sign/searchAll" method="post">
						<input name="conditionstr" id="conditionstr"  class="header_input_text" type="text" placeholder="关键字" value="${conditionstr}"/>
						<!--<input type="submit" value="搜索" />-->
						<input type="submit" class="searchbutton" value="搜索" />
						<!-- <button>搜索</button> 
						<span>
							热门搜索：计算机科学&nbsp;医学&nbsp;新能源
						</span>
						-->
					</form>
				</div>
			</div>
		</div>
		<!--头部End-->

		<!--导航栏-->
		<div class="nav">
			<div class="main">
				<ul>
					<li id="menu1"><a href="/">首页</a></li>
					<li id="menu2"><a href="/web/ach/achPage?curPage=1&active=all&actives=alls">成果库</a></li>
					<li id="menu3"><a href="/web/tran/tranPage?curPage=1&active=all&actives=alls">成果转化</a></li>
					<li id="menu4"><a href="/web/achievement/solicitation?curPage=1&active=all&actives=alls">征集</a></li>
					<li id="menu5"><a href="/web/dynamic/dynamicPage?curPage=1&active=all&actives=alls">领域动态</a></li>
					<li id="menu6"><a href="/web/expertdatabase/list">专家库</a></li>
					<li id="menu7"><a href="javascript:toPersonalCenter();">个人中心</a></li>
				</ul>
			</div>
			<script type="text/javascript">
			$("#${menunumber}").attr("class","active");
			</script>
		</div>
		<!--导航栏End-->

		<div class="bar"></div>
		
		
  <!-- 
  <center>
  <div style="width:90%;">
    <table width=100%>
    	<tr>
    		<td><b><a href="" style="color:blue;">首页</a></b></td>
    		<td><b><a href="" style="color:blue;">科技成果</a></b></td>
    		<td><b><a href="" style="color:blue;">成果转化</a></b></td>
    		<td><b><a href="" style="color:blue;">成果转化</a></b></td>
    		<td><b><a href="" style="color:blue;">专家库</a></b></td>
    		<td>
	    	<br/>
    		</td>
    	</tr>
    </table>
    </div>
    </center>
     -->
  </body>
</html>

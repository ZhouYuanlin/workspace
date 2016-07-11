<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>底部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="/pcui/css/all.css" />
  </head>
  
  <body>
  
     	<div class="bar"></div>

		<!--底部版权信息以及推荐-->
		<div class="bottom">
			<div class="main">
				<div id="friendlinkdiv"><font size="4">友情链接：</font>
				<c:forEach var="friendObj" items="${friendLinkList}">
					&nbsp;<a href="${friendObj.linkurl }">${friendObj.name }</a>
				</c:forEach>
				</div>
				<a href="/">首页</a> &nbsp;|&nbsp;
				<a href="/web/ach/achPage?curPage=1&active=all&actives=alls">成果</a> &nbsp;|&nbsp;
				<a href="/web/tran/tranPage?curPage=1&active=all&actives=alls">成果需求转化</a> &nbsp;|&nbsp;
				<a href="/web/achievement/solicitation?curPage=1&active=all&actives=alls">需求征集</a> &nbsp;|&nbsp;
				<a href="/web/dynamic/dynamicPage?curPage=1&active=all&actives=alls">领域动态</a> &nbsp;|&nbsp;
				<a href="/web/expertdatabase/list">专家库</a> &nbsp;|&nbsp;
				<a href="javascript:toPersonalCenter()">个人中心</a> &nbsp;|&nbsp;
				</br>
				蜀ICP证040431号 互联网出版许可证 新出网证(蜀)字005号 经营性网站备案信息 蜀备11010802014875号 联系电话：028-67431890
				</br>
				Copyright©2015-2018 科技成果网   技术支持：普连众通
			</div>
		</div>
		<!--底部版权信息以及推荐End-->
  </body>
</html>

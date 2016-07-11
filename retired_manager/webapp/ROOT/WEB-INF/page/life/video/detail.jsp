<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link rel='stylesheet' href='${request.contextPath}/defaults/css/style.css' media='screen' />
<script type="text/javascript" src="${request.contextPath}/defaults/js/video/swfobject.js"></script>
</head>
<body>
<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/video">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/video">
							视频分享</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/video">
							详情</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
					<!-- a class="btn blue" href="<c:url value='${request.contextPath}/video/create'/>"><i class="fa fa-plus"></i> 上传视频</a>
		            <a class="btn blue" href="<c:url value='${request.contextPath}/video/appr'/>"><i class="fa fa-times"></i> 删除视频</a-->
		            <jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
                </div>
              </div>
              </div>

<div id="mainContainer">
<div id="DHTMLgoodies_panel_one">
	<div class="albumtitle">
    	<a href="/video" class="backtohome"><img src="${request.contextPath}/defaults/img/pic/backarrow.png" /></a>
        <span class="albumname">视频分享</span>
        <span class="albumname" style="clear:both;display:block;width:200px;padding-top:20px;font-size:14px;max-height:100px;overflow:hidden;line-height:24px;">${video.title}</span>
    </div>
    <div class="albumauthor">
    	此视频由&nbsp;<span>${video.zjh}</span>&nbsp;于&nbsp;<span><fmt:formatDate value = "${video.cdate}" pattern ="yyyy-MM-dd"/></span>&nbsp;上传
    </div>
    <div class="albumintroduce" style="height:200px;" title="点击查看全部说明">
    	${video.content }
    </div>
</div>
<div id="DHTMLgoodies_largeImage">
        <!-- Table is used to get both vertical and horizontal center alignment -->
	<table>
		<tr>
			<td>
<div class="video" id="CuPlayer"></div>
  <script type="text/javascript">
var so = new SWFObject("${request.contextPath}/defaults/folder/CuPlayerMiniV4.swf","CuPlayerV4","600","405","9","#000000");
	so.addParam("allowfullscreen","true");
	so.addParam("allowscriptaccess","always");
	so.addParam("wmode","opaque");
	so.addParam("quality","high");
	so.addParam("salign","lt");
	so.addVariable("CuPlayerSetFile","${request.contextPath}/defaults/folder/CuPlayerSetFile.xml"); //播放器配置文件地址,例SetFile.xml、SetFile.asp、SetFile.php、SetFile.aspx
	so.addVariable("CuPlayerFile","/upload/life/video/${video.url}"); //视频文件地址
	so.addVariable("CuPlayerImage","${request.contextPath}/defaults/img/video/start.jpg");//视频略缩图,本图片文件必须正确
	so.addVariable("CuPlayerLogo","");//${request.contextPath}/defaults/img/video/Logo.png
	so.addVariable("CuPlayerAutoPlay","yes"); //是否自动播放
	so.write("CuPlayer");
	//删除
	function doDel(){
		window.location.href = "${request.contextPath}/video/appr";
	}
	function doCreate(){
		window.location.href = "/video/create";
	}
</script>

			</td>
		</tr>
	</table>
</div>
</div>
</div>
<script>
</script>
</body>
</html>
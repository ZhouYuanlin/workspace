<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="cn.uuf.domain.*" %>
<%
	String path = request.getRequestURI();
	path = path.replaceFirst("/","");
	path = path.split(";")[0];
	path = path.indexOf("/") != -1 ? path.substring(0,path.indexOf("/")) : path;
	path = "/"+path;
	request.setAttribute("pat",path);
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	Subject subject = SecurityUtils.getSubject();
	Account account = (Account)subject.getPrincipal();
	List<Resource> resList = new ArrayList<Resource>();//account.getRoles().get(0).getResources();
	for(Role r : account.getRoles()){
		resList.addAll(r.getResources());
	}
	request.setAttribute("resList",resList);
%>
<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7 no-js"> <![endif]-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8"/>
<title><decorator:title default="${xmmc}"/></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<link href="/defaults/css/main.css" rel="stylesheet" type="text/css"/>
<link href="/defaults/css/jquery.range.css" rel="stylesheet" type="text/css"/>
<script src="/defaults/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="/defaults/plugins/excanvas.min.js"></script>
<script src="/defaults/plugins/respond.min.js"></script>
<script src="/defaults/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/defaults/plugins/jquery.cokie.min.js" type="text/javascript" ></script>
<script src="/defaults/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/defaults/js/metronic.js" type="text/javascript"></script>
<script src="/defaults/js/jquery.messager.js" type="text/javascript"></script>
<script src="/defaults/js/jquery.range-min.js" type="text/javascript"></script>
<script type="text/javascript" src="${request.contextPath}/defaults/js/bootstrap-typeahead.js"></script>
<script type="text/javascript" src="${request.contextPath}/defaults/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${request.contextPath}/defaults/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="/defaults/js/layout.js" type="text/javascript"></script>
<script src="/defaults/js/common.js" type="text/javascript"></script>
<decorator:head/>
</head>

<body class="page-header-fixed page-sidebar-fixed-custom">
<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner">
		<div class="page-logo"> <a href="/">${xmmc}</a></div>
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown dropdown-user">
					<a href="javascript:;;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                    <span class="username"><i class="fa fa-user"></i><shiro:principal property="realname"/> </span>
					<i class="fa fa-angle-down"></i>
					</a>
					  <ul class="dropdown-menu">
						<li> <a href="/information"> <i class="fa fa-gift"></i>个人信息</a> </li>
						<li> <a href="/avator"> <i class="fa fa-gear"></i> 上传头像</a> </li>
						<li> <a href="/modifypass"> <i class="fa fa-gear"></i> 修改密码</a> </li>
						<li class="divider"> </li>
						<li> <a href="<c:url value='${request.contextPath}/auth/logout'/>"> <i class="fa fa-key"></i> 退出 </a> </li>
					  </ul>
				</li>
			</ul>
		</div>

		<div class="hor-menu hor-menu-light hidden-sm hidden-xs">
			<ul class="nav navbar-nav pull-right">
				<li <c:if test="${pat == '/index'}">class="classic-menu-dropdown active"</c:if>>
					<a href="/index">首 页<c:if test="${pat == '/index'}"><span class="selected"></span></c:if></a>
				</li>
				<c:forEach items="${resList}" var="item" varStatus="c">
					<c:set var="sel" value="false"/>
					<c:forEach items="${item.children}" var="chi">
						<c:if test="${chi.status == '启用' && chi.action == pat}">
							<c:set var="sel" value="true"/><c:set var="chlist" value="${item.children}"/>
						</c:if>
					</c:forEach>
					<c:if test="${empty item.parent && item.status == '启用'}">
						<li <c:if test="${sel}">class="classic-menu-dropdown active"</c:if>>
							<a href="${item.children[0].action}" data-toggle="dropdown" class="dropdown-toggle">${item.name}<c:if test="${sel}"><span class="selected"></span></c:if></a>
						<c:if test="${!empty item.children}">
							<ul class="dropdown-menu">
								<c:forEach items="${item.children}" var="chi">
									<shiro:hasPermission name='${chi.action}'>
									<li><a href="${chi.action}" title="${chi.name}"><s:substring length="5" value="${chi.name}"/></a></li>
									</shiro:hasPermission>
								</c:forEach>
							</ul>
						</c:if>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</div>

	</div>
</div>
<div class="clearfix"></div>
<div class="page-container">
	<div class="page-sidebar navbar-collapse collapse isshowleft">
		<ul class="page-sidebar-menu" data-auto-scroll="false" data-auto-speed="200">
        
            <li class="sidebar-toggler-wrapper">
                <div class="sidebar-toggler">
                </div>
            </li>
            <c:forEach items="${chlist}" var="item">
            <c:if test="${item.status == '启用'}">
			<li <c:if test="${item.action == pat}">class="start active open"</c:if>>
				<shiro:hasPermission name='${item.action}'>
				<a href="${item.action}">
				<span class="title">
				${item.name}</span>
				<c:if test="${item.action == pat}"><span class="arrow open">
				</span>
				<span class="selected"></span></c:if>
				</a>
				</shiro:hasPermission>
			</li>
			</c:if>
			</c:forEach>
		</ul>
	</div>
	<decorator:body/>
	</div>
	  <div class="alert alert-info info-div" style="display: none">
		  <span class="fa fa-spinner"></span>正在加载中...
	  </div>
	  <!-- div class="alert alert-block alert-success fade in alert-success-div" style="display: none">
		<button type="button" class="close" data-dismiss="alert"></button>
		<h4 class="alert-heading">提示信息</h4>
		<p>
			${message}
		</p>
	</div-->
<div class="page-footer">
	<div class="page-footer-inner" style="width:90%;text-align:center">
		 ${xmbb}
	</div>
	<div class="page-footer-tools">
		<span class="go-top">
		<i class="fa fa-angle-up"></i>
		</span>
	</div>
</div>
<script>
$(function(){    
   Metronic.init(); // init metronic core components
   Layout.init(); // init current layout
   $(".nav li,.top-nav1 li").hover(
	  function () {
		$(this).addClass("open");
	  },
	  function () {
		$(this).removeClass("open");
	  }
	); 
   $('.date-picker').datepicker({
		rtl: Metronic.isRTL(),
		autoclose: true,
		language: "zh-CN"
	});
   
   $(".range_slide").jRange({ 
		from: 50, 
		to: 120, 
		step: 1, 
		scale: [50,60,70,80,90,100,110,120], 
		format: '%s', 
		showLabels: true, 
		showScale: true,
		theme:'theme-blue',
	}); 
   
   <c:if test="${!empty message}">
	$.messager.lays(200, 200); 
	$.messager.anim('slideDown', 1000); 
	$.messager.show("提示信息", "${message}",5000); 
	</c:if>
	//显示加载中
	$('.wzbtn').click(function(){
		$('#frm').submit(function(){
			if(true){
				$('.info-div,.fa').show();
				$('.wzbtn').attr("disabled", true); 
			}
		});
	});
});
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"  prefix="decorator"%>
<%@ page import="cn.uuf.stu.framework.common.ResourcesHandler" %>
<%@ page import="cn.uuf.stu.entity.framework.WResource" %>
<%@ page import="java.util.List" %>
<%@page import="cn.uuf.stu.framework.common.SystemParamter" %>
<%@page import="cn.uuf.stu.framework.util.SystemParamterUtils" %>
<%@page import="cn.uuf.stu.framework.common.SystemParamter.CaptchaType" %>
<%@page import="cn.uuf.stu.framework.shiro.Principal" %>
<%@page import="org.apache.shiro.subject.Subject" %>
<%@page import="org.apache.shiro.SecurityUtils" %>
<%
  request.setAttribute("rlist",ResourcesHandler.getAdminResources());
  request.setAttribute("buttonImgDir", SystemParamterUtils.get().getButtonImgDir());
  Subject subject = SecurityUtils.getSubject();
  Principal principal = (Principal) subject.getPrincipal();
  request.setAttribute("xm",principal.getXm());
%>    
<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7 no-js"> <![endif]-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>学工后台管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/plugins/excanvas.min.js"></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/plugins/respond.min.js"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/jquery.validate.js"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/jquery.metadata.js"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/validate-plugin.js"></script>
<script src="${request.getContextPath}/resources/framework/custom/base/js/common.js"></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/plugins/jquery.cokie.min.js" type="text/javascript" ></script>
<script type="text/javascript" src="${request.contextPath}/resources/framework/bootstrap-v3.3.1/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${request.contextPath}/resources/framework/bootstrap-v3.3.1/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
<script type="text/javascript" src="${request.contextPath}/resources/framework/bootstrap-v3.3.1/plugins/bootstrap-datepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${request.contextPath}/resources/framework/bootstrap-v3.3.1/plugins/bootstrap-datepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/metronic.js" type="text/javascript"></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/layout.js" type="text/javascript"></script>
<link href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/main.css" rel="stylesheet" type="text/css"/>
<link href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/page-monitor.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/custom/base/css/message.css">
<decorator:head/>
<style type="text/css">
		#form label.fieldError {
				margin-left: 3px;
				width: auto;
				display: inline;
				color: red;
				padding-top: 3px;
			}
			
			#form input.fieldError {
				border: 1px dotted #e60000;
				background: #ffefdd;
			}
			
			span.required {
				padding-right: 3px;
				color: #ff6d6d;
				font-size: 10px;
			}
</style>
</head>
<c:choose>
	<c:when test="${!empty silderMenu}">
	<body class="page-header-fixed page-sidebar-fixed-custom">
	</c:when>
	<c:otherwise>
	<body class="page-header-fixed page-full-width page-hidden-breadcrumb page-portal">
	</c:otherwise>
</c:choose>
<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner">
		<div class="page-logo"> <a href="#">学生工作管理系统 </a> </div>
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown dropdown-user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                    <span class="username"><i class="fa fa-user"></i>
                    	<c:choose>  
						    <c:when test="${fn:length(xm) > 4}">  
						        <c:out value="${fn:substring(xm, 0, 4)}.." />  
						    </c:when>  
						   <c:otherwise>  
						      <c:out value="${xm}" />  
						    </c:otherwise>  
						</c:choose>  
                    </span>
					<i class="fa fa-angle-down"></i>
					</a>
					  <ul class="dropdown-menu">
					  <!-- 
						<li> <a href="#"> <i class="fa fa-gift"></i> 风格设置 </a> </li>
						<li> <a href="#"> <i class="fa fa-gear"></i> 系统设置 </a> </li>
					 -->	
						<li class="divider"> </li>
						<li> <a href="${request.getContextPath}/admin/logout"> <i class="fa fa-key"></i> 退出 </a> </li>
					  </ul>
				</li>
			</ul>
		</div>

		<div class="hor-menu hor-menu-light hidden-sm hidden-xs">
			<ul class="nav navbar-nav pull-right">
				<li 
					<c:if test="${empty selectOnemenu}">
						class="classic-menu-dropdown active"
					</c:if>
				>
					<a href="/"><i class="fa fa-home"></i>首 页</a>
					<c:if test="${empty selectOnemenu}">
						<span class="selected"></span>
					</c:if>	
				</li>
				<c:forEach items="${rlist}" var = "pResource" varStatus="status">
					<li
						<c:if test="${pResource.id == selectOnemenu.id }">
							class="classic-menu-dropdown active"
						</c:if>	
					><a href="
					<c:if test="${!empty pResource.childrens}">
						<c:forEach items="${pResource.childrens}" var = "cResource" varStatus="status_1">
							<c:if test="${status_1.count == 1}">
								<shiro:hasPermission name ="${cResource.permissionString}">	
									${cResource.accessUrl}
								</shiro:hasPermission>
							</c:if>
						</c:forEach>
					</c:if>	
					" data-toggle="dropdown" class="dropdown-toggle">${pResource.resourceName}</a>
					<c:if test="${!empty pResource.childrens}">
						<ul class="dropdown-menu">
							<c:forEach items="${pResource.childrens}" var="item">
								<shiro:hasPermission name ="${item.permissionString}">
									<li><a href="${item.accessUrl}">${item.resourceName}</a></li>
								</shiro:hasPermission>
							</c:forEach>
						</ul>
					</c:if>
					<c:if test="${pResource.id == selectOnemenu.id }">
						<span class="selected"></span>
					</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</div>
	</div>
</div>
<div class="clearfix">
</div>
<div class="page-container">
<c:if test="${!empty silderMenu}">
	<div class="page-sidebar navbar-collapse collapse">
		  	<ul class="page-sidebar-menu" data-auto-scroll="false"
				data-auto-speed="200">
				<li class="sidebar-toggler-wrapper">
					<div class="sidebar-toggler"></div>
				</li>
				<c:forEach items="${silderMenu}" var="item" varStatus="status">
					<c:choose>
						<c:when test="${(empty selectTwomenu && status.count == 1)||item.id == selectTwomenu.id}">
							<c:if test="${!empty item.permissionString}">
								<shiro:hasPermission name ="${item.permissionString}">
									<li class="start active open">
										<a href="${request.getContextPath}${item.accessUrl}"> 
											<span class="title"> ${item.resourceName}</span> 
											<span class="arrow open"> </span> 
											<span class="selected"></span>
										</a>
									</li>
								</shiro:hasPermission>
							</c:if>
						</c:when>
						<c:otherwise>
							<c:if test="${!empty item.permissionString}">
								<shiro:hasPermission name ="${item.permissionString}">
									<li>
										<a href="${request.getContextPath}${item.accessUrl}"> 
											<span class="title">${item.resourceName}</span>
										</a>
									</li>
								</shiro:hasPermission>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
	</div>
	</c:if>	
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="#">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<c:if test="${!empty breadMenu.parent}">
							<li> 
								<a href="#">
								${breadMenu.parent.resourceName}</a>
								<i class="fa fa-angle-right"></i>
							</li>
						</c:if>
						<li>
							<a href="#">
							${breadMenu.resourceName} </a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <!-- 操作按钮 可按需添加-->
                <div class="operation-btn pull-right">
                    <c:forEach items="${buttonList}" var = "bResource" varStatus="status">
									<shiro:hasPermission name ="${bResource.permissionString}">
										<c:if test="${bResource.isEnabled==true}">
											<a url="${bResource.accessUrl}" <c:if test="${!empty bResource.buttonIdName }">id="${bResource.buttonIdName}"</c:if>
											 <c:if test="${!empty bResource.buttonDataToggle}">data-toggle="${bResource.buttonDataToggle}"</c:if>  
											 class="btn blue" href="<c:if test='${empty bResource.buttonHref}'>javascript:;;</c:if><c:if test='${!empty bResource.buttonHref}'>${bResource.buttonHref}</c:if>"> 
											 <i class="${bResource.buttonCssName}"></i>${bResource.resourceName}
											</a>
										</c:if>
									</shiro:hasPermission>
					</c:forEach>
					<!-- 添加特殊按钮 -->
					<c:if test="${!empty qgzxGwsq.ffyf&&qgzxGwsq.xcffzt=='wff'}">
						<a class="btn blue" id="saveplff" href="javascript:;"> 
							<i class=""></i>发放
						</a>
					</c:if>
                </div>
              </div>
              </div>
			  
			  <decorator:body/>
				
			</div>
		</div>
	</div>
	<div class="alert alert-info info-div" style="display: none">
		  <span class="fa fa-spinner"></span>正在加载中...
	  </div>
<div class="page-footer">
	<div class="page-footer-inner">
		 2015 &copy;  学生工作管理系统.
	</div>
	<div class="page-footer-tools">
		<span class="go-top">
		<i class="fa fa-angle-up"></i>
		</span>
	</div>
</div>

<!----------------------------  各种内容弹窗  ------------------------> 
<!-- 对话框 -->
<div class="modal fade" id="deleteModel" tabindex="-1" role="testModalDialog" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    <h3>操作提示</h3>
  </div>
  <div class="modal-body">
    <p class="fs16">确定删除该条记录吗？</p>
  </div>
  <div class="modal-footer">
    <button data-dismiss="modal" class="btn blue confirm" onclick="$.del('ok')">确定</button>
    <button class="btn" data-dismiss="modal" aria-hidden="true" onclick="$.del('cancel')">取消</button>
  </div>
</div>

<script>
jQuery(document).ready(function() {    
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
 //显示加载中
	$('.wzbtn').click(function(){
		$('#listForm').submit(function(){
			if(true){
				$('.info-div,.fa').show();
				$('.wzbtn').attr("disabled", true); 
			}
		});
	});
});
		/** 增删改查基本操作*/
		(function($){
			var $delete = $("#delete");
			var $create = $("#create");
			var $update = $("#edit");
			var $upload = $('#upload');
			var $down = $('#download');
			//删除
			$delete.click(function(){
				 /* var $checkedIds = $.selectedList();
				 if($checkedIds.length==0){
					alert("您还没有选择修改条目");
					return;
				 } */
				$("#deleteModel").modal('show');
			})
			//upload
			$upload.click(function(){
				$.upload($upload.attr("url"));
			});
			$.upload = function(url){
				window.location.href = "${request.contexPath}" + url;
			}
			$down.click(function(){
				$download($down.attr("url"));
			});
			$download = function(url){
				window.location.href = "${request.contextPath}" + url;
			}
			//增加
			$create.click(function(){
				$.create($create.attr("url"));
			})
			$.create = function(url){
				window.location.href="${request.contextPath}"+url;
			}
			
			//更新
			$update.click(function(){
				var nodes = $.selectedList();
				var $checkedId = $.selectedId(nodes);
				if(nodes.length==0){
					alert("您还没有选择修改条目");
					return;
				}
				if(nodes.length>1){
					alert("每次只能修改一条");
					return;
				}
				$.update($update.attr("url"),$checkedId);
			})
			
			$.update = function(url,id){
				if(typeof(update) == "function"){
					update(url,id);
				}else{
					window.location.href="${request.contextPath}"+url+"?id="+id;
				}
			}
			
			//删除
			 $.delete = function(url){
				 var $checkedIds = $.selectedList();
				 if($checkedIds.length==0){
					alert("您还没有选择修改条目");
					return;
				 }
				 $.doAjax(url,"POST",$checkedIds.serialize());
			}			
			
			
			
			//瞬时消息提醒
			if("${flash_message}"!=""){
				if("${flash_message.type}"=="success"){
					$.message("success","<spring:message code='${flash_message}'/>");
				}else if("${flash_message.type}"=="error"){
					$.message("error","<spring:message code='${flash_message}'/>");
				}else{
					$.message("warn","<spring:message code='${flash_message}'/>");
				}
			}
			
			//返回选中的列表
			$.selectedList = function(){
				var $enabledIds = $("#listTable input[name='ids']:enabled:checked");
				return $enabledIds;
			}
			
			//返回选中的ID
			$.selectedId = function(nodes){
				var $checkedId;
				nodes.each(function(i){
					$checkedId = $(this).val();
				})
				return $checkedId;
			}
			
			//删除对话框
			$.del = function(operation){
				var $url = $delete.attr("url");
				if(operation=="cancel"){
					//执行取消函数
					if(typeof(delCacel) == "function"){
						//执行
						delCacel();
					}
				}else{
					if(typeof(delOk) == "function"){
						//执行
						delOk($url);
					}else{
						//执行默认删除方法
						$.delete($url);
					}
				}
				$("#deleteModel").modal('hide');
			}
			
			/** 执行删除方法*/
			$.doAjax = function(url,type,param){
				$.ajax({
					url:url,
					type:type,
					data:param,
					dataType:"json",
					cache:false,
					success:function(message){
						$.message(message);
						setTimeout("location.reload()",2000);
					}
				});
			}
			
		})(jQuery)
		
	</script>
</body>
</html>

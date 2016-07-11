<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单页</title>
<link href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/main.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/custom/base/css/message.css">	
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/jquery.validate.js"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/validate-plugin.js"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/common.js"></script>	
<script type="text/javascript">
			$(function(){
				$(window.parent.document).find("#main").load(function(){
					var main = $(window.parent.document).find("#main");
					var thisheight = $(document).height()+30;
					main.height(thisheight);
				});
				//表单验证
				var $form = $("#form");
				$form.validate({
					rules:{
						resourceName:{
							required:true
						}
					}
				});
				//消息提醒
				if("${flash_message}"!=""){
					if("${flash_message.type}"=="success"){
						$.message("success","<spring:message code='${flash_message}'/>");
					}else if("${flash_message.type}"=="error"){
						$.message("error","<spring:message code='${flash_message}'/>");
					}else{
						$.message("warn","<spring:message code='${flash_message}'/>");
					}
					setTimeout("parent.location.reload()",2000);
				}
				
			})
		</script>
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
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">信息添加</div>
					<div class="tools">
						<a href="javascript:;" class="collapse"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form id="form" action="${request.getContextPath}/admin/resource/update" class="form-horizontal" method="post">
						<input type="hidden" name="id" value="${resource.id}">
					<div class="form-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label"><span class="required">*</span>菜单名称：</label>
									<div class="controls">
										<input type="text" name="resourceName" value="${resource.resourceName}" class="form-control col-md-12" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">菜单类型：</label>
									<div class="controls">
										<select id="type" name="type" class="form-control col-md-12">
											<c:forEach items="${types}" var="type">
												<option value="${type}"
													<c:if test="${resource.type == type}">selected</c:if>><spring:message
														code="resource.type.${type}" /></option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">访问路径：</label>
									<div class="controls">
										<input type="text" name="accessUrl" id="accessUrl"
											value="${resource.accessUrl}" class="form-control col-md-12" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
										<label class="control-label">权限字符串：</label>
										<div class="controls">
											<input type="text" name="permissionString" id="permissionString"
												value="${resource.permissionString}" class="form-control col-md-12" />
										</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">是否启用：</label>
									<div class="controls">
										<input type="checkbox" name="isEnabled" value="true"
											<c:if test="${resource.isEnabled=='true'}">
												checked="checked"
											</c:if>>
										<input type="hidden" name="_isEnabled" value="false" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
										<label class="control-label">菜单图片名：</label>
										<div class="controls">
											<input type="text" id="menuImgName" name="menuImgName"
												value="${resource.menuImgName}" class="form-control col-md-12" />
										</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">按钮样式名：</label>
									<div class="controls">
										<input type="text" id="buttonCssName" name="buttonCssName"
											value="${resource.buttonCssName}" class="form-control col-md-12" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
										<label class="control-label">父节点：</label>
										<div class="controls">
												<select name="parentId" id="parentId" class="form-control col-md-12">
													<option value="">顶级节点</option>
													<c:forEach items="${rootMenus}" var="rootmenu"
														varStatus="status">
														<c:if test="${rootmenu.id!=resource.id }">
															<option value="${rootmenu.id}"
																<c:if test="${!empty resource.parent &&resource.parent.id==rootmenu.id}">selected</c:if>>
																${rootmenu.resourceName}
															</option>
															<c:if test="${!empty rootmenu.childrens }">
																<c:forEach items="${rootmenu.childrens}" var="childMenu">
																	<c:if test="${childMenu.type!='button'&&childMenu.id!=resource.id}">
																		<option value="${childMenu.id}"
																			<c:if test="${!empty resource.parent &&resource.parent.id==childMenu.id}">
																			selected											
																		</c:if>>${childMenu.resourceName}</option>
																	</c:if>
																</c:forEach>
															</c:if>
														</c:if>
													</c:forEach>
												</select>
										</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">前置节点：</label>
									<div class="controls">
										<select name="preId" id="preId" class="form-control col-md-12">
											<option value="">首级节点</option>
											<c:forEach items="${brotherResource}" var="bResource">
												<c:if test="${bResource.id != resource.id}">
													<option value="${bResource.id}"
														<c:if test="${bResource.sort==resource.sort-1}">selected</c:if>>${bResource.resourceName}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">按钮的ID属性名：</label>
									<div class="controls">
										<input type="text" value="${resource.buttonIdName}" name="buttonIdName" id="buttonIdName" class="form-control col-md-12" />
									</div>
								</div>
							</div>
							<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label class="control-label">按钮的HREF：</label>
																<div class="controls">
																	<input type="text" id="buttonHref" name="buttonHref"
																		value="${resource.buttonHref}" class="form-control col-md-12" />
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label class="control-label">按钮的Toggle：</label>
																<div class="controls">
																	<input type="text" value="${resource.buttonDataToggle}"
																		name="buttonDataToggle" id="buttonDataToggle" class="form-control col-md-12" />
																</div>
															</div>
														</div>
													</div>
						</div>
					</div>
						<div class="form-actions fluid">
							<div class="row">
								<div class="col-md-12">
									<div class="col-md-offset-5">
										<button type="submit" class="btn blue mgr20 wzbtn">
											提交</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
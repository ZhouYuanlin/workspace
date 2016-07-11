<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单页</title>
		<script type="text/javascript">
			$(function(){
				var $form = $("#form");
				$form.validate({
					rules:{
						resourceName:{
							required:true
						},
						permissionString:{
							required:true
						}
					}
				});
			})	
		</script>
</head>
<body>
	 <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-title">
										<div class="caption">
											信息添加
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form action="${request.getContextPath}/admin/resource/save"
										id="form" class="form-horizontal" method="post">
											<div class="form-body">
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label class="control-label"><span class="required">*</span>菜单名称：</label>
																<div class="controls">
																	<input type="text" name="resourceName"
																		value="${resource.resourceName}" class="form-control col-md-12" />
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
																<label class="control-label"><span class="required">*</span>权限字符串：</label>
																<div class="controls">
																	<input type="text" name="permissionString"
																		 value="${resource.permissionString}"
																		class="form-control col-md-12" />
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
																			<option value="${rootmenu.id}"
																				<c:if test="${!empty resource.parent &&resource.parent.id==rootmenu.id}">
															selected
															</c:if>>${rootmenu.resourceName}</option>
																			<c:if test="${!empty rootmenu.childrens }">
																				<c:forEach items="${rootmenu.childrens}" var="childMenu">
																					<c:if test="${childMenu.type!='button'}">
																						<option value="${childMenu.id}"
																							<c:if test="${!empty resource.parent &&resource.parent.id==childMenu.id}">
																								selected											
																							</c:if>>>${childMenu.resourceName}</option>
																					</c:if>
																				</c:forEach>
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
																<label class="control-label">按钮的ID属性名：</label>
																<div class="controls">
																	<input type="text" value="${resource.buttonIdName}"
																		name="buttonIdName" id="buttonIdName" class="form-control col-md-12" />
																</div>
															</div>
														</div>
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
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr20 wzbtn"> 提交 </button> 
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
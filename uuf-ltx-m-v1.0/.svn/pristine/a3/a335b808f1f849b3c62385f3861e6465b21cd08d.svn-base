<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${request.getContextPath}/resources/framework/custom/base/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/jquery.ztree.excheck-3.5.min.js"></script>
<title>角色更新</title>
<style type="text/css">
	.ztree li{line-height:18px;}
</style>
<script type="text/javascript">
	(function($){
		var setting = {
				data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:""}},
				check:{enable: true,chkboxType:{ "Y" : "", "N" : "s" }}
		};
		var arry = [
		           	<c:forEach items="${resources}" var="item" varStatus="i">
						{
							id:'${item.id}',
							pId:'${item.parent.id}',
							name:'${item.resourceName}',
							<c:forEach items="${role.resoures}" var="checkedResource">
								<c:if test="${checkedResource.id==item.id}">
								checked:true,
								</c:if>
							</c:forEach>
							<c:if test="${!empty item.childrens}">
								iconOpen:"/resources/framework/custom/base/img/ztree/diy/1_open.png",
								iconClose:"/resources/framework/custom/base/img/ztree/diy/1_close.png",
								open:true
							</c:if>
							<c:if test="${empty item.childrens}">icon:"/resources/framework/custom/base/img/ztree/diy/2.png"</c:if>
						}<c:if test="${!i.last}">,</c:if>		           	
		           	</c:forEach> 
		           ]
		$.zTree = function(){
			$.fn.zTree.init($("#tree"), setting, arry);
		} 
	})(jQuery);

	$(function(){
		var zTree = $.zTree();
		//表单验证
		var $form = $("#form");
		$form.validate({
			submitHandler:function(form){
				getCheckedNodes();
				form.submit();  
			},
			rules:{
				roleName:{
					required:true,
					maxlength:10
				},
				decription:{
					maxlength:30
				}
			}
		})
		
		var getCheckedNodes = function(){
			var treeObj = $.fn.zTree.getZTreeObj("tree");
			var nodes = treeObj.getCheckedNodes(true);
			if(nodes.length>0){
				for(var i=0;i<nodes.length;i++){
					 $form.append("<input type='hidden'  name='ids' value='"+nodes[i].id+"'>");
				}
			}
		}
		
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">
						角色添加
					</div>
					<div class="tools">
						<a href="javascript:;" class="collapse">
						</a>
					</div>
				</div>
				<div class="portlet-body form">
					<!-- BEGIN FORM-->
					<form id="form" class="form-horizontal"
						action="${request.getContextPath}/admin/role/update"  method="post">
						<input type="hidden" name="id" value="${role.id}"/>
						<div class="form-body">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>角色名称：</label>
										<div class="controls">
											<input type="text" name="roleName" value="${role.roleName}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>域名称：</label>
										<div class="controls">
											<select name="roleScope.id" class="form-control col-md-12">
												<c:forEach items="${rcList}" var="item">
													<option value="${item.id}" 
													<c:if test="${role.roleScope.id==item.id}">selected</c:if>
													>
													<spring:message	code="ROLE.SCOPE.${item.rScope}" />
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">首页模块执行方法名：</label>
										<div class="controls">
											<input type="text" name="indexShow.functionName" value="${role.indexShow.functionName}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">首页模块执行页面名：</label>
										<div class="controls">
											<input type="text" name="indexShow.pageName" value="${role.indexShow.pageName}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label">角色描述：</label>
										<div class="controls">
											<textarea rows="3" name="decription" value="${role.decription}" class="form-control col-md-12"></textarea>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label">角色授权：</label>
										<div class="controls">
											<div  style="border:1px solid #ccc">
												<ul id="tree" class="ztree" ></ul>
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
										<button type="submit" class="btn blue mgr20 wzbtn"> 提交 </button>
									</div>
								</div>
							</div>
						</div>
					</form>
					<!-- END FORM-->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
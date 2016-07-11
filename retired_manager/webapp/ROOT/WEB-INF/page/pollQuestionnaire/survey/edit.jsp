<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${request.getContextPath}/resources/framework/custom/base/css/zTreeStyle.css"
	type="text/css" />
<script type="text/javascript"
	src="${request.getContextPath}/resources/framework/custom/base/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript"
	src="${request.getContextPath}/resources/framework/custom/base/js/jquery.ztree.excheck-3.5.min.js"></script>

<link rel="stylesheet"
	href="${request.getContextPath}/resources/framework/custom/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="${request.getContextPath}/resources/framework/custom/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8"
	src="${request.getContextPath}/resources/framework/custom/kindeditor/kindeditor.js"></script>
<script charset="utf-8"
	src="${request.getContextPath}/resources/framework/custom/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="${request.getContextPath}/resources/framework/custom/kindeditor/plugins/code/prettify.js"></script>
<title>创建测试</title>
<script type="text/javascript">
		$(function(){
			var $form = $("#form");
			 $form.validate({
				submitHandler:function(form){
					if($("#parentId").val()==""){
						alert("请选择！");
					}else{
						form.submit(); 
					}
				}, 
				rules:{
					title:{
						required:true
					},
					fbr:{
						required:true
					},
					fbsj:{
						required:true
					}
				}
			});
		
		})
		
			var zTree;
			var setting = {
				data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:""}},
				check: {
					enable: true,
					chkStyle: "radio",
					radioType: "all"
				},
				callback:{
	                onCheck:onCheck
	            }
			};
			var arry = [
				<c:forEach items="${categories}" var="item" varStatus="i">
				{id:${item.id},pId:'${item.parent.id}',name:'${item.name}',<c:if test="${empty item.parent.id}">open:true,</c:if>
						<c:if test="${!empty item.children}">iconOpen:"/resources/framework/custom/base/img/ztree/diy/1_open.png",iconClose:"/resources/framework/custom/base/img/ztree/diy/1_close.png"</c:if>
						<c:if test="${empty item.children}">icon:"/resources/framework/custom/base/img/ztree/diy/2.png"</c:if>
						}<c:if test="${!i.last}">,</c:if>
				</c:forEach>
				];
			
			$(function(){
				zTree = $.fn.zTree.init($("#tree"), setting, arry);
			});
			var obj = new Object();
			function onCheck(event, treeId, treeNode){
				obj["id"]=treeNode.id;
				obj["name"]=treeNode.name;
			};
			function toSubmit(){
				var nodes = zTree.getCheckedNodes(true);
				if(nodes.length==1){
					$("#parentName").html(obj["name"]);
					$("#parentId").attr("value",obj["id"]);
				}else{
					alert("您没有选择任何节点！");
					return false;
				}
			}

			var zTree_;
			var setting_ = {
				data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:""}},
				check: {
					enable: true,
					chkStyle: "radio",
					radioType: "all"
				},
				callback:{
	                onCheck:onCheck_
	            }
			};
			var arry_ = [
				<c:forEach items="${demolist}" var="item" varStatus="i">
				{id:${item.id},pId:'${item.parent.id}',name:'${item.name}',<c:if test="${empty item.parent.id}">open:true,</c:if>
						<c:if test="${!empty item.children}">iconOpen:"/resources/framework/custom/base/img/ztree/diy/1_open.png",iconClose:"/resources/framework/custom/base/img/ztree/diy/1_close.png"</c:if>
						<c:if test="${empty item.children}">icon:"/resources/framework/custom/base/img/ztree/diy/2.png"</c:if>
						}<c:if test="${!i.last}">,</c:if>
				</c:forEach>
				];
			
			$(function(){
				zTree_ = $.fn.zTree.init($("#tjtree"), setting_, arry_);
			});
			var obj_ = new Object();
			function onCheck_(event, treeId, treeNode){
				obj_["id"]=treeNode.id;
				obj_["name"]=treeNode.name;
			};
			function toSubmit_(){
				var nodes = zTree_.getCheckedNodes(true);
				if(nodes.length==1){
					$("#tjName").html(obj_["name"]);
					$("#tjId").attr("value",obj_["id"]);
				}else{
					alert("您没有选择任何节点！");
					return false;
				}
			}
		</script>
</head>
<body>
	<div class="modal fade" id="showdetail" tabindex="-1" role="testModal"
		aria-hidden="true"
		style="width: 850px; margin-left: 50%; margin-left: -425px; margin-top: 50px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3>选择</h3>
		</div>
		<div class="modal-body">
			<ul id="tree" class="ztree"
				style="width: 820px; overflow: auto; clear: both; height: 400px;"></ul>
		</div>
		<div class="modal-footer">
			<button data-dismiss="modal" class="btn blue confirm"
				onclick="toSubmit()">确定</button>
			<button data-dismiss="modal" class="btn blue confirm">关闭</button>
		</div>
	</div>

	<div class="modal fade" id="showdetail_" tabindex="-1" role="testModal"
		aria-hidden="true"
		style="width: 850px; margin-left: 50%; margin-left: -425px; margin-top: 50px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3>选择</h3>
		</div>
		<div class="modal-body">
			<ul id="tjtree" class="ztree"
				style="width: 820px; overflow: auto; clear: both; height: 400px;"></ul>
		</div>
		<div class="modal-footer">
			<button data-dismiss="modal" class="btn blue confirm"
				onclick="toSubmit_()">确定</button>
			<button data-dismiss="modal" class="btn blue confirm">关闭</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">测试添加</div>
					<div class="tools">
						<a href="javascript:;" class="collapse"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="${request.getContextPath}/admin/test/demo/save"
						id="form" class="form-horizontal" method="post">
						<input type="hidden" name="id" value="${demo.id}" />
						<div class="form-body">
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>姓名：</label>
										<div class="controls">
											<input type="text" name="name" value="${demo.name}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>手机</label>
										<div class="controls">
											<input type="text" name="mobile" value="${demo.mobile}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>住址</label>
										<div class="controls">
											<input type="text" name="address" value="${demo.address}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>提交内容</label>
										<div class="controls">
											<input type="text" name="content" value="${demo.content}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>提交时间</label>

										<div class="controls">
											<input type="text" id="tjsj" name=tjsj value="${demo.tjsj}"
												class="form-control col-md-12 date-picker"
												data-date-format="yyyy-mm-dd" size="16" readonly />
										</div>
									</div>
								</div>
							<%-- 	<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>提交IP</label>
										<div class="controls">
											<input type="text" name="tjip" value="${demo.tjip}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div> --%>
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
<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.js"></script>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/carInfo/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/carInfo/">
							车辆管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/carInfo/">
							修改 </a>
						</li>
					</ul>
				</div>
			</div>
			  <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-title">
										<div class="caption">
											信息修改
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="<c:url value='${request.contextPath}/carInfo/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${r.id}"/>
											<input type="hidden" name="updateDate" value="${r.updateDate}"/>
											<input type="hidden" name="createDate" value="${r.createDate}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车辆名称：</label>
															<div class="controls">
																<input type="text" id="carName" name="carName" value="${r.carName}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车辆类型：</label>
															<div class="controls">
																<select name="carType"  id="carType" class="form-control col-md-12">
										                          		<option value="">----请选择----</option>
												             			<option value="轿车" <c:if test="${r.carType == '轿车'}">selected</c:if>>轿车</option>
												             			<option value="货车" <c:if test="${r.carType == '货车'}">selected</c:if>>货车</option>
												             			<option value="客车" <c:if test="${r.carType == '客车'}">selected</c:if>>客车</option>
												             	</select>																
												            </div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>司机：</label>
															<div class="controls">
																<input type="text" id="carDriver" name="carDriver" value="${r.carDriver}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车牌号：</label>
															<div class="controls">
																<input type="text" id="carNumber" name="carNumber" value="${r.carNumber}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>可坐人数：</label>
															<div class="controls">
																<input type="text" id="peopleNumber" name="peopleNumber" value="${r.peopleNumber}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>电话：</label>
															<div class="controls">
																<input type="text" id="tel" name="tel" value="${r.tel}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>审批人：</label>
															<div class="controls">
																<select name="account.id"  id="accountId" class="form-control col-md-12">
										                          	<option value="">----请选择----</option>
												             		<c:forEach items="${alist}" var="item">
												             			<option value="${item.id}" <c:if test="${item.id == r.account.id}">selected</c:if>>${item.realname}</option>
												             		</c:forEach>
												             	</select>	
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">其他说明：</label>
															<div class="controls">
																<textarea id="explain" name="explain" class="form-control col-md-12" style="height: 300px;">${r.explain}</textarea>
															</div>
														</div>
													</div>
												</div>
												</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10 wzbtn"> 提交 </button> 
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>  
					</div>
			  </div>
			</div>
		</div>
		<script>
		$(function(){
			$('.wzbtn').click(function(){
				if($('#sfzh').val() == ""){
					alert("请输入身份证号");
					$('#sfzh').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
		KindEditor.ready(function(K) {
			var editor1 = K
					.create(
							'textarea[id="explain"]',
							{
								cssPath : '${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.css',
								uploadJson : '${request.contextPath}/retirenotice/ajaxupload',//上传图片时用
								allowUpload : true,
								urlType : 'absolute',
								items : [ //配置工具栏
								'fontname', 'fontsize', '|', 'forecolor',
										'hilitecolor', 'bold', 'italic',
										'underline', 'removeformat', '|',
										'justifyleft', 'justifycenter',
										'justifyright', 'insertorderedlist',
										'insertunorderedlist', '|', 'emoticons',
										'link', 'wordpaste' ],

								afterCreate : function() {
									var self = this;
									K.ctrl(document, 13, function() {
										self.sync();
									});
									K.ctrl(self.edit.doc, 13, function() {
										self.sync();
									});
								}
							});
			prettyPrint();

		});
		</script>
	</body>
</html>
<%!
    String htmlspecialchars(String str) {
    str = str.replaceAll("&", "&amp;");
    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll("\"", "&quot;");
    return str;
}
%>
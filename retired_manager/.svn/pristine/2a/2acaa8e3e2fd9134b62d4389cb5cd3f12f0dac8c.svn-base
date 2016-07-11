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
							<a href="${request.contextPath}/carInfo">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/carInfo">
							车辆管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/carInfo">
							增加 </a>
						</li>
					</ul>
				</div>
			</div>
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
										<form id="frm" action="<c:url value='${request.contextPath}/carInfo/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车辆名称及型号：</label>
															<div class="controls">
																<input type="text" id="carName" name="carName"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车辆类型：</label>
															<div class="controls">
																<select name="carType"  id="carType" class="form-control col-md-12">
										                          		<option value="">----请选择----</option>
												             			<option value="轿车" >轿车</option>
												             			<option value="货车" >货车</option>
												             			<option value="客车" >客车</option>
												             	</select>	
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>司机：</label>
															<div class="controls">
																<input type="text" id="carDriver" name="carDriver"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车牌号：</label>
															<div class="controls">
																<input type="text" id="carNumber" name="carNumber"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>可坐人数：</label>
															<div class="controls">
																<input type="text" id="peopleNumber" name="peopleNumber"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>电话：</label>
															<div class="controls">
																<input type="text" id="tel" name="tel"  class="form-control col-md-12">
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
												             			<option value="${item.id}">${item.realname}</option>
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
																<textarea id="explain" name="explain" class="form-control col-md-12" style="height: 300px;"></textarea>
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
				if($('#carName').val() == ""){
					alert("请输入车辆名称及型号");
					$('#carName').focus();
					return false;
				}
				if($('#carType').val() == ""){
					alert("请输入车辆类型");
					$('#carType').focus();
					return false;
				}
				if($('#carDriver').val() == ""){
					alert("请输入司机姓名");
					$('#carDriver').focus();
					return false;
				}
				if($('#carNumber').val() == ""){
					alert("请输入车牌号");
					$('#carNumber').focus();
					return false;
				}
				if($('#peopleNumber').val() == ""){
					alert("请输入可坐人数");
					$('#peopleNumber').focus();
					return false;
				}
				if($('#tel').val() == ""){
					alert("请输入联系电话");
					$('#tel').focus();
					return false;
				}
				if($('#accountId').val() == ""){
					alert("请输入审批人");
					$('#accountId').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
	
		
		
		KindEditor.ready(function(K) {
			var editor1 = K
					.create(
							'textarea[name="explain"]',
							{
								cssPath : '${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.css',
								uploadJson : '${request.contextPath}/retirenotice/ajaxupload',//上传图片时用
								allowUpload : true,
								urlType : 'relative',
								items : [ //配置工具栏
								'fontname', 'fontsize', '|', 'forecolor',
										'hilitecolor', 'bold', 'italic',
										'underline', 'removeformat', '|',
										'justifyleft', 'justifycenter',
										'justifyright', 'insertorderedlist',
										'insertunorderedlist', '|', 'emoticons', 'image',
										'link', 'wordpaste','clearhtml' ],

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
<%-- <%!
    String htmlspecialchars(String str) {
    str = str.replaceAll("&", "&amp;");
    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll("\"", "&quot;");
    return str;
}
%>
 --%>
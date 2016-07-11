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
							<a href="${request.contextPath}/meetingApply">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/meetingApply">
							审核 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/meetingApply">
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
											审核
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="<c:url value='${request.contextPath}/meetingApply/auditSuccess'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${meeting.id}"/>
											<div class="form-body">
												<div class="row">
												<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>会议主题：</label>
															<div class="controls">
																<input type="text" id="title" name="title" value="${meeting.title}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>会议室名称：</label>
															<div class="controls">
																<select name="meetingRoom.id"  id="meetingRoom.id" class="form-control col-md-12" >
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${roomlist}" var="item">
												             			<option value="${item.id}"<c:if test="${meeting.meetingRoom.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请人：</label>
															<div class="controls">
																<input type="text" id="applicantName" name="applicantName" value="${meeting.applicantName}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">申请使用日期：</label>
															<div class="controls">
																	<input  type="text" id="useTime" name="useTime" value="${meeting.useTime}" class="form-control col-md-12 " readonly="readonly"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请使用开始时间：</label>
															<div class="controls">
																<input  type="text" id="startTime" name="startTime" value="${meeting.startTime}" class="form-control col-md-12 "   readonly="readonly"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请使用结束时间：</label>
															<div class="controls">
																<input type="text" id="endTime" name="endTime" value="${meeting.endTime}" class="form-control col-md-12 "  readonly="readonly"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>参会人数：</label>
															<div class="controls">
																<input type="text" id="attendNum" name="attendNum" value="${meeting.attendNum}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-12">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请原因：</label>
															<div class="controls">
																<input type="text" id="reason" name="reason" value="${meeting.reason}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>审核状态：</label>
																<div class="controls">
																	<select name="status"  id="status" class="form-control col-md-12">
											                            <option value="0" <c:if test="${meeting.status == 0}">selected</c:if>>待审核</option>
											                            <option value="1" <c:if test="${meeting.status == 1}">selected</c:if>>审核通过</option>
											                            <option value="2" <c:if test="${meeting.status == 2}">selected</c:if>>审核不通过</option>
													             	</select>
																</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">审核建议：</label>
															<div class="controls">
																<textarea id="opinion" name="opinion" class="form-control col-md-12" style="height: 300px;" >${meeting.opinion}</textarea>
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
							'textarea[id="reason"]',
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
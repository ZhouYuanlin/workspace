<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/defaults/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css"/>
	<link href="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet"/>
	<script src="${request.contextPath}/defaults/plugins/My97DatePicker/WdatePicker.js" type="text/javascript" ></script>
	<script type="text/javascript" src="${request.contextPath}/defaults/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
	<script src="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
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
							<a href="${request.contextPath}/carApply">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/carApply">
							车辆使用申请 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/carApply">
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
										<form id="frm" action="<c:url value='${request.contextPath}/carApply/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${r.id}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车号（车型）：</label>
															<div class="controls">
																<select name="carinfo.Id"  id="carinfo.Id" class="form-control col-md-12">
												             		<c:forEach items="${carslist}" var="item">
												             			<option value="${item.id}"<c:if test="${r.carinfo.id == item.id}">selected</c:if>>${item.carNumber} (${item.carName})</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请使用日期：</label>
															<div class="controls">
																<input type="text" id="useTime" name="useTime" value="${r.useTime}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请使用开始时间：</label>
															<div class="controls">
																<div class="input-group">
																	<span class="input-group-btn">
																	<input type="text" id="startTime" name="startTime" value="<c:if test='${empty w.kssj}'><fmt:formatDate value='${w.createDate}' pattern='HH:mm'/></c:if><c:if test='${!empty r.startTime}'>${r.startTime}</c:if>" class="form-control timepicker timepicker-24" style="width:120px;">
																	<button class="btn default timepicker-btn" type="button"><i class="fa fa-clock-o"></i></button>
																	</span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请使用结束时间：</label>
															<div class="controls">
																<div class="input-group">
																	<span class="input-group-btn">
																	<input type="text" id="endTime" name="endTime" value="<c:if test='${empty r.endTime}'><fmt:formatDate value='${w.createDate}' pattern='HH:mm'/></c:if><c:if test='${!empty r.endTime}'>${r.endTime}</c:if>" class="form-control timepicker timepicker-24" style="width:120px;">
																	<button class="btn default timepicker-btn" type="button"><i class="fa fa-clock-o"></i></button>
																	</span>
																</div>
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
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请人电话：</label>
															<div class="controls">
																<input type="text" id="tel" name="tel" value="${r.tel}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">申请原因：</label>
															<div class="controls">
																<textarea id="peason" name="peason" class="form-control col-md-12" style="height: 300px;">${r.peason}</textarea>
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
				if($('#carinfo.Id').val() == ""){
					alert("请选择车辆名称及型号");
					$('#carinfo.Id').focus();
					return false;
				}
				if($('#peason').val() == ""){
					alert("请选择车辆名称及型号");
					$('#peason').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
		KindEditor.ready(function(K) {
			var editor1 = K
					.create(
							'textarea[id="peason"]',
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

		$(function(){
	  		$('.date-picker').datepicker({
				rtl: Metronic.isRTL(),
				autoclose: true,
				language: "zh-CN"
			});
			$('.timepicker-24').timepicker({
				autoclose: true,
				minuteStep: 5,
				showSeconds: false,
				showMeridian: false
			});
			$('.timepicker').parent('.input-group-btn').on('click', '.timepicker-btn', function(e){
				e.preventDefault();
				$(this).parent('.input-group-btn').find('.timepicker').timepicker('showWidget');
			});
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
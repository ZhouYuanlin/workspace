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
							<a href="${request.contextPath}/meetingapply/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/meetingApply/">
							会议室使用申请 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/meetingapply/">
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
									<form id="frm" action="<c:url value='${request.contextPath}/meetingApply/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>会议主题：</label>
															<div class="controls">
																<input type="text" id="title" name="title" value="${meeting.title}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>参会人数：</label>
															<div class="controls">
																<input type="text" id=attendNum name="attendNum" value="${meeting.attendNum}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>会议室：</label>
															<div class="controls">
																<select name="meetingRoom.id"  id="meetingRoomid" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${roomlist}" var="item">
												             			<option value="${item.id}">${item.name}&nbsp;&nbsp;&nbsp;&nbsp;设备有：&nbsp;${item.device}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
												
												<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请使用日期：</label>
															<div class="controls">
																<input type="text" id="useTime" name="useTime" value="" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
												</div>
												
												<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>申请使用开始时间：</label>
															<div class="controls">
																<div class="input-group">
																	<span class="input-group-btn">
																	<input type="text" id="startTime" name="startTime" value="<c:if test='${empty w.kssj}'><fmt:formatDate value='${w.createDate}' pattern='HH:mm'/></c:if><c:if test='${!empty w.kssj}'>${w.kssj}</c:if>" class="form-control timepicker timepicker-24" style="width:120px;">
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
																	<input type="text" id="endTime" name="endTime" value="<c:if test='${empty w.jssj}'><fmt:formatDate value='${w.createDate}' pattern='HH:mm'/></c:if><c:if test='${!empty w.jssj}'>${w.jssj}</c:if>" class="form-control timepicker timepicker-24" style="width:120px;">
																	<button class="btn default timepicker-btn" type="button"><i class="fa fa-clock-o"></i></button>
																	</span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">申请理由：</label>
															<div class="controls">
															<textarea id="reason" name="reason" class="form-control col-md-12" style="height: 300px;">${meeting.reason}</textarea>
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
		KindEditor.ready(function(K) {
			var editor1 = K
					.create(
							'textarea[name="reason"]',
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
			$('.wzbtn').click(function(){
				if($('#title').val() == ""){
					alert("请输入会议主题");
					$('#title').focus();
					return false;
				}
				if($('#attendNum').val() == ""){
					alert("请输入参加会议室人数");
					$('#attendNum').focus();
					return false;
				}
				if($('#meetingRoomid').val() == null){
					alert($('#meetingRoomid').val())
					alert("请选择会议室");
					$('#meetingRoomid').focus();
					return false;
				}
				if($('#startTime').val() == null){
					alert("请选择使用开始时间");
					$('#startTime').focus();
					return false;
				}
				if($('#endTime').val() == null){
					alert("请选择使用结束时间");
					$('#endTime').focus();
					return false;
				}
				if($('#useTime').val() == null){
					alert("请选择使用时间");
					$('#useTime').focus();
					return false;
				}
				if($('#startTime').val()>=$('#endTime').val()){
					alert("开始时间应该小于结束时间");
					return false;
				}
				$('#frm').submit();
			});
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
<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
	<%@ taglib prefix="xxs" tagdir="/WEB-INF/tags" %>
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
							<a href="${request.contextPath}/activityReleas">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/activityReleas">
							活动发布 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/activityReleas">
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
										<form id="frm" action="<c:url value='${request.contextPath}/activityReleas/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动名称：</label>
															<div class="controls">
																<input type="text" id="activityName" name="activityName"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动地点：</label>
															<div class="controls">
																<input type="text" id="address" name="address"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>开始日期：</label>
															<div class="controls">
																<input type="text" id="startTime" name="startTime" value="" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>结束日期：</label>
															<div class="controls">
																<input type="text" id="endTime" name="endTime" value="" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>报名截止日期：</label>
															<div class="controls">
																<input type="text" id="addEndTime" name="addEndTime" value="" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>负责人：</label>
															<div class="controls">
																<input type="text" id="person" name="person"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>联系电话：</label>
															<div class="controls">
																<input type="text" id="tel" name="tel"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车辆数量：</label>
															<div class="controls">
																<input type="text" id="carNumber" name="carNumber"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车辆乘坐人数：</label>
															<div class="controls">
																<input type="text" id="peopleNub" name="peopleNub"  class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">备注：</label>
															<div class="controls">
																<input type="text" id="remarks" name="remarks"  class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label">活动图片：</label>
														<div class="controls" id="siteWebLog">
															<input type="hidden" id="siteWebLogName" value="imgurl" />
															<xxs:commonupload id="siteWebLog" uploadType="1" type="1" name="imgurl" fileTypes="*.jpg;*.gif;*.png" sizeLimit="10 MB" srcImg="${meeting.imgurl}" showText="true" styleClass="text_4" />
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动介绍：</label>
															<div class="controls">
																<textarea id="introduction" name="introduction" class="form-control col-md-12" style="height: 300px;"></textarea>
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
							'textarea[name="peason"]',
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
		$(function(){
			$('.wzbtn').click(function(){
				if($('#activityName').val() == ""){
					alert("请输入活动名称");
					$('#activityName').focus();
					return false;
				}
				if($('#address').val() == ""){
					alert("请输入活动地点");
					$('#address').focus();
					return false;
				}
				if($('#introduction').val() == ""){
					alert("请输入活动介绍");
					$('#introduction').focus();
					return false;
				}
				if($('#introduction').val().length>300){
					alert("请输入活动介绍的字数少于300字");
					$('#introduction').focus();
					return false;
				}
				if($('#startTime').val() == ""){
					alert("请输入活动开始日期");
					$('#startTime').focus();
					return false;
				}
				if($('#endTime').val() == ""){
					alert("请输入活动结束日期");
					$('#endTime').focus();
					return false;
				}
				if($('#addEndTime').val() == ""){
					alert("请输入报名截止日期");
					$('#addEndTime').focus();
					return false;
				}
				if($('#person').val() == ""){
					alert("请输入负责人姓名");
					$('#person').focus();
					return false;
				} 
				if($('#tel').val() == ""){
					alert("请输入联系电话");
					$('#tel').focus();
					return false;
				} 
				if($('#carNumber').val() == ""){
					alert("请输入活动车辆数量");
					$('#carNumber').focus();
					return false;
				} 
				if($('#peopleNub').val() == ""){
					alert("请输入活动车辆乘坐人数");
					$('#peopleNub').focus();
					return false;
				} 
				$('#frm').submit();
			});
		});
		</script>
	</body>
</html>
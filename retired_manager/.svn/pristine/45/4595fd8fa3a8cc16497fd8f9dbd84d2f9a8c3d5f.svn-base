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
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/retmarke/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retmarke/">
							提示语 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retmarke/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retmarke/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>开始时间：</label>
															<div class="controls">
																<input type="text" id="kssj" name="kssj" value="${m.kssj}" class="form-control col-md-12 timepicker-24" readonly>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>结束时间：</label>
															<div class="controls">
																<input type="text" id="jssj" name="jssj" value="${m.jssj}" class="form-control col-md-12 timepicker-24" readonly>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>提示语：</label>
															<div class="controls">
																<textarea name="content" id="content" class="form-control col-md-12">${m.content}</textarea>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" class="btn blue mgr10 wzbtn"> 提交 </button> 
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
		<script type="text/javascript">
			$(function(){
				$('.timepicker-24').timepicker({
					autoclose: true,
					minuteStep: 5,
					showSeconds: false,
					showMeridian: false
				});
				$('.wzbtn').click(function(){
					if($('#kssj').val() == ''){
						alert('请选择开始时间');
						$('#kssj').focus();
						return false;
					}
					if($('#jssj').val() == ''){
						alert('请选择结束时间');
						$('#jssj').focus();
						return false;
					}
					if($('#content').val() == ''){
						alert('请输入提示语');
						$('#content').focus();
						return false;
					}
					$('#frm').submit();
				});
			});
		</script>
	</body>
</html>
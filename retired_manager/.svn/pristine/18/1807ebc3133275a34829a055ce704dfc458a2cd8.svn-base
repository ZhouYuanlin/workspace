<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<body>
	<link rel="stylesheet" type="text/css"
		href="${request.contextPath}/defaults/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css" />
	<link
		href="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.css"
		rel="stylesheet" />
	<script
		src="${request.contextPath}/defaults/plugins/My97DatePicker/WdatePicker.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${request.contextPath}/defaults/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
	<script
		src="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li><i class="fa fa-home"></i> <a
							href="${request.contextPath}/retmarke/"> 首页 </a> <i
							class="fa fa-angle-right"></i></li>
						<li><a href="${request.contextPath}/retmarke/"> 问卷列表 </a> <i
							class="fa fa-angle-right"></i></li>
						<li><a href="${request.contextPath}/retmarke/"> 新增问卷</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="portlet box grey">
						<div class="portlet-title">
							<div class="caption">添加问卷</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"> </a>
							</div>
						</div>
						<div class="portlet-body form">
							<form id="frm"
								action="<c:url value='${request.contextPath}/pollQuestionnaire/save'/>"
								class="form-horizontal" method="post">
								<div class="form-body">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label"><i
													style="color: red; margin-right: 5px;">*</i>名称：</label>
												<div class="controls">
													<input type="text" id="wjzt" name="wjzt" value="${s.wjzt}"
														class="form-control col-md-12 " />
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label"><i
													style="color: red; margin-right: 5px;">*</i>匿名：</label>
												<div class="controls">
													<input type="text" id="nm" name="nm" value="${s.nm}"
														class="form-control col-md-12 " />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label"><i
														style="color: red; margin-right: 5px;">*</i>状态： </label> <label><input
														name="status" id="status" type="radio" value="status" /></label>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label"><i
												style="color: red; margin-right: 5px;">*</i>发布人：</label>
											<div class="controls">
												<input type="text" id="fbr" name="fbr" value="${s.fbr}"
													class="form-control col-md-12 " />
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label"><i
													style="color: red; margin-right: 5px;">*</i>备注：</label>
												<div class="controls">
													<textarea name="bz" id="bz" class="form-control col-md-12">${s.bz}</textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-actions fluid">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-offset-5">
												<button type="button" class="btn blue mgr10 wzbtn">
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
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('.timepicker-24').timepicker({
				autoclose : true,
				minuteStep : 5,
				showSeconds : false,
				showMeridian : false
			});
			$('.wzbtn').click(function() {
				if ($('#wjzt').val() == '') {
					alert('请选择名称');
					$('#wjzt').focus();
					return false;
				}
				if ($('#nm').val() == '') {
					alert('请选择匿名');
					$('#nm').focus();
					return false;
				}
				if ($('#status').val() == '') {
					alert('请选择状态 ');
					$('#status').focus();
					return false;
				}
				if ($('#fbr').val() == '') {
					alert('请选择发布人');
					$('#fbr').focus();
					return false;
				}
				if ($('#bz').val() == '') {
					alert('请输入提示语');
					$('#bz').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
	</script>
</body>
</html>
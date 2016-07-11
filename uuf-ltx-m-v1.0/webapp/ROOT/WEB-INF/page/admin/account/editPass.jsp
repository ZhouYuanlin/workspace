<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>重置密码</title>
<script type="text/javascript">
	$(function(){
		var $form = $("#form");
		$form.validate({
			rules:{
				password:{
					required:true,
					maxlength:12
				},				
				confirmPass:{
					required:true,
					equalTo:"#password"
				}
			}
		})
	})
</script>
</head>
<body>
	<div class="row">
	<div class="col-md-12">
		<div class="portlet box grey">
			<div class="portlet-title">
				<div class="caption">
					重置密码
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse">
					</a>
				</div>
			</div>
			<div class="portlet-body form">
				<!-- BEGIN FORM-->
					<form id="form" class="form-horizontal" action="${request.getContextPath}/admin/account/updatePass" method="post">
						<input type="hidden" name="id" value="${account.id}" />
						<div class="form-body">
							<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">用户名：</label>
											<div class="controls">
												<input type="text" name="username" readonly="readonly"
													value="${account.username}" class="form-control col-md-10" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label"><span class="required">*</span>输入密码：</label>
											<div class="controls">
												<input id="password" type="password" name="password"
													value="" class="form-control col-md-10" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label"><span class="required">*</span>确认密码：</label>
											<div class="controls">
												<input type="password" name="confirmPass"
													value="" class="form-control col-md-10" />
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
							</div>
					</form>
				<!-- END FORM-->
			</div>
		</div>
	</div>
</div>
</body>
</html>
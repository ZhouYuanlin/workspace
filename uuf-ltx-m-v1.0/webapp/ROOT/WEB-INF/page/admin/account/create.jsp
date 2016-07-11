<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>创建用户</title>
<script type="text/javascript">
	$(function(){
		var $form = $("#form");
		$form.validate({
			rules:{
				username:{
					required:true,
					pattern:/^[0-9a-z_A-Z\u4e00-\u9fa5]+$/,
					minlength:2,
					maxlength:12,
					remote:{
						url:"/admin/account/ckeckUsername",
						cache:false
					}
				},
				password:{
					required:true,
					pattern: /^[^\s&\"<>]+$/,
					minlength: 4,
					maxlength: 20
				},
				xm:{
					required:true
				}
			},
			messages:{
				username: {
					pattern: "<spring:message code="admin.validate.illegal"/>",
					remote: "<spring:message code="admin.validate.exist"/>"
				},
				password:{
					pattern: "<spring:message code="admin.validate.illegal"/>"
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
					创建用户
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse">
					</a>
				</div>
			</div>
			<div class="portlet-body form">
				<!-- BEGIN FORM-->
				<form id="form" class="form-horizontal" action="${request.getContextPath}/admin/account/save" method="post">
					<div class="form-body">
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>用户名称：</label>
										<div class="controls">
											<input type="text" name="username"
												value="${account.username}" class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>密码：</label>
										<div class="controls">
											<input type="text" name="password"
												value="${account.password}" class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>姓名：</label>
										<div class="controls">
											<input type="text" name="xm"
												value="${account.xm}" class="form-control col-md-12" />
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label">是否启用：</label>
										<div class="controls">
											<div class="radio-list">
												<label class="radio-inline">
													<input type="checkbox" name="isEnabled" value="true"
														<c:if test="${account.isEnabled=='true'}">
															checked="checked"</c:if> />
													<input type="hidden" name="_isEnabled" value="false" />
												</label>	
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label">授予角色：</label>
										<div class="controls">
											<div class="radio-list">
												<c:forEach items="${roles}" var="item">
													<label class="radio-inline"> <input
														type="radio" value="${item.id}" name="roleIds" />${item.roleName}
													</label>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label">院系：</label>
										<div class="controls">
											 <select name="dwId" class="form-control col-md-4" onChange="changeBjb(this)">
					                            <option value="">----请选择----</option>
							             		<c:forEach items="${jxdwList}" var="item">
							             			<option value="${item.id}">${item.dwmc}</option>
							             		</c:forEach>
							             	</select>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label">班级：</label>
										<div class="controls">
											<div class="bjs">
												
											</div>
										</div>
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
				</form>
				<!-- END FORM-->
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function changeBjb(obj){
		var str ="";
		var dwId = obj.value;
		if(obj.value == ''){
			str="";
		}
		if(obj.value != ''){
			<c:forEach items="${jxdwList}" var="item">
				if(obj.value == '${item.id}'){
					<c:forEach items="${item.codeBjbs}" var="chi" varStatus="c">
					<c:if test="${c.index != 0 && c.index % 10 == 0}">
					str += "<br>"
					</c:if>
					str += "<input type='checkbox'  name='bjh' value='${chi.id}' class='checkboxes'/>${chi.bm} ";
					</c:forEach>
				}
			</c:forEach>
		}
		$('.bjs').html(str);
	}




</script>
</body>
</html>
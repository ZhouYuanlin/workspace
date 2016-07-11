<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>编辑用户</title>
<script type="text/javascript">
$(function(){
	var $form = $("#form");
	$form.validate({
		rules:{
			xm:{
				required:true
				
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
					<div class="caption">信息修改</div>
					<div class="tools">
						<a href="javascript:;" class="collapse"> </a>
					</div>
				</div>
				<div class="portlet-body form">
					<!-- BEGIN FORM-->
					<form id="form"  action="${request.getContextPath}/admin/account/update" class="form-horizontal"
					method="post">
						<input type="hidden" name="id" value="${account.id}"/>
						<div class="form-body">
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>用户名称：</label>
										<div class="controls">
											<input type="text" readonly="readonly" name="username" value="${account.username}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label"><span class="required">*</span>姓名：</label>
										<div class="controls">
											<input type="text" name="xm" value="${account.xm}"
												class="form-control col-md-12" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label">是否启用：</label>
										<div class="controls">
											<div class="radio-list">
												<label class="radio-inline">
													<input type="checkbox" name="isEnabled" value="true"
													<c:if test="${account.isEnabled=='true'}">
														checked="checked"</c:if>
													/>
												</label>
											</div>
											<input type="hidden" name="_isEnabled" value="false"/>
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
													<c:choose>
														<c:when test="${!empty account.roles}">
															<c:forEach items="${account.roles}" var="role">
																<c:choose>
																	<c:when test="${role.id==item.id}">
																		<label class="radio-inline">
																			<input type="radio" checked="checked" value="${item.id}" name="roleIds"/>${item.roleName} 
																		</label>	
																	</c:when>
																	<c:otherwise>
																		<label class="radio-inline">
																			<input type="radio" value="${item.id}" name="roleIds"/>${item.roleName} 
																		</label>
																	</c:otherwise>
																</c:choose>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<label class="radio-inline">
																<input type="checkbox" value="${item.id}" name="roleIds"/>${item.roleName} 
															</label>	 
														</c:otherwise>
													</c:choose>
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
											  <select name="dwId"  class="form-control col-md-4" onChange="changeBjb(this)">
							             		<c:forEach items="${jxdwList}" var="item">
							             			<option value="${item.id}" 
							             			<c:if test="${!empty codeJsb && codeJsb.dwb.id  == item.id}">selected</c:if>
							             			<c:if test="${!empty xjxx && xjxx.codedwb.id  == item.id}">selected</c:if>>
							             			${item.dwmc}
							             			</option>
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
												<c:if test="${!empty xjxx}">
													<c:forEach items="${jxdwList}" var="item">
														<c:if test="${item.id==xjxx.codedwb.id}">
															<c:forEach items="${item.codeBjbs}" var="bj">
																<input type="checkbox" name="bjh" value="${bj.id}"
																 <c:if test="${xjxx.codebjb.id==bj.id}">
																 	checked
																 </c:if>
																 />${bj.bm}
															</c:forEach>
														</c:if>
													</c:forEach>
				                            	</c:if>
				                            	<c:if test="${!empty codeJsb}">
				                            		<c:forEach items="${jxdwList}" var="item">
				                            			<c:if test="${item.id==codeJsb.dwb.id}">
				                            				<c:forEach items="${item.codeBjbs}" var="bj">
					                            				<input type="checkbox" name="bjh" value="${bj.id}"
					                            				 	<c:forEach items="${codeJsb.bjbs}" var="chi">
					                            				 		<c:if test="${chi.id==bj.id}">
					                            				 			checked
					                            				 		</c:if>
						                            				</c:forEach>
					                            				 />${bj.bm}
						                            		</c:forEach>
					                            		 </c:if>
				                            		</c:forEach>
				                            	</c:if>
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
										<button type="submit" class="btn blue mgr20 wzbtn">
											提交</button>
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
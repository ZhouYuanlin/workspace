<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/retdepart/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retdepart/">
							部门 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retdepart/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retdepart/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${d.id}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>部门：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="${d.name}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">父级：</label>
															<div class="controls">
																<select name="pid"  id="pid" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${dlist}" var="item">
																		<c:if test="${empty item.parent}">
																			<option value="${item.id}" <c:if test="${item.id == d.parent.id}">selected</c:if>>${item.name}</option>
																			<c:forEach items="${item.children}" var="chi" varStatus="c">
																				<option value="${chi.id}" <c:if test="${chi.id == d.parent.id}">selected</c:if>>&nbsp;&nbsp;${c.index+1}、${chi.name}</option>
																			</c:forEach>
																		</c:if>
																	</c:forEach>
												             	</select>
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
				if($('#name').val() == ""){
					alert("请输入名称");
					$('#name').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
		</script>
	</body>
</html>

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
							<a href="${request.contextPath}/retireoldun/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retireoldun/">
							老年大学信息</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retireoldun/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retireoldun/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${p.id}"/>
											<jsp:include page="../_info.jsp"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>入学日期：</label>
															<div class="controls">
																<input type="text" id="rxrq" name="rxrq" value="${p.rxrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>结业日期：</label>
															<div class="controls">
																<input type="text" id="byrq" name="byrq" value="${p.byrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">课堂类型：</label>
															<div class="controls">
																<select id="ktlx" name="ktlx" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${ktlblist}" var="item">
																		<option value="${item.name}" <c:if test="${item.name == p.ktlx}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">课堂职务：</label>
															<div class="controls">
																<select id="ktzw" name="ktzw" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${ktzwlist}" var="item">
																		<option value="${item.name}" <c:if test="${item.name == p.ktzw}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">说明：</label>
															<div class="controls">
																<textarea name="bz" class="form-control col-md-12">${p.bz}</textarea>
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
			$('.btn').click(function(){
				if($('#rxrq').val() == ""){
					alert("入学日期不能为空");
					$('#rxrq').focus();
					return false;
				}
				if($('#byrq').val() == ""){
					alert("结业日期不能为空");
					$("#byrq").focus();
					return false;
				}
				if(($('#rxrq').val() != '' && $('#byrq').val() != '')){
					if(fnbeginOverEnd($('#rxrq').val(),$('#byrq').val(),'结业日期止不能小于入学日期起')){
						return false;
					}
				}
			});
		});
		</script>
	</body>
</html>
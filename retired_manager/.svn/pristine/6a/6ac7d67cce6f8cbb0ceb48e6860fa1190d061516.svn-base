<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
	<script type="text/javascript" src="${request.contextPath}/defaults/js/bootstrap-typeahead.js"></script>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/retirepartywork/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retirepartywork/">
							党建工作</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retirepartywork/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retirepartywork/save'/>" class="form-horizontal" method="post">
											<input type="hidden" name="cfsf" id="cfsf" value="${p.cfsf}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>标题：</label>
															<div class="controls">
																<input type="text" id="title" name="title" value="${p.title }" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>时间：</label>
															<div class="controls">
																<input type="text" id="kfrq" name="kfrq" value="${p.kfrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">主持人：</label>
															<div class="controls">
																<input type="text" id="zcr" name="zcr" value="${p.zcr }" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">所在党支部：</label>
															<div class="controls">
																<select id="kfdzb" name="kfdzb" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${plist}" var="item">
																		<option value="${item.dzbmc}" <c:if test="${p.kfdzb == item.dzbmc}">selected</c:if>>${item.dzbmc}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><a href="#showdetail" id="approve1" class="black" data-toggle="modal">参会人：</a></label>
															<div class="controls">
																<a href="#showdetail" id="approve1" class="black" data-toggle="modal"><input type="text" id="cfry" name="cfry" value="${p.cfry}" class="form-control col-md-12" readonly></a>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">内容：</label>
															<div class="controls">
																<textarea name="content" class="form-control col-md-12">${p.content}</textarea>
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
		<!-- 选择人员 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:530px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		  <jsp:include page="_choice.jsp"/>
		</div>
		<script>
		$(function(){
			$('.wzbtn').click(function(){
				if($('#title').val() == ""){
					alert("标题不能为空");
					$('#title').focus();
					return false;
				}
				if($('#kfrq').val() == ""){
					alert("时间不能为空");
					$('#kfrq').focus();
					return false;
				}
			});
		});
		</script>
	</body>
</html>
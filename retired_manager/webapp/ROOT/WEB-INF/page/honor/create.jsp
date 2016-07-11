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
							<a href="${request.contextPath}/retirehonor/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retirehonor/">
							表彰管理</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retirehonor/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retirehonor/save'/>" class="form-horizontal" method="post">
											<input type="hidden" id="cyhs" name="cyhs" value="${h.cyhs}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>表彰名称：</label>
															<div class="controls">
																<input type="text" id="bzmc" name="bzmc" value="${h.bzmc}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">表彰时间：</label>
															<div class="controls">
																<input type="text" id="bzsj" name="bzsj" value="${cd}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">表彰级别：</label>
															<div class="controls">
																<select id="bzjb" name="bzjb" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${jbblist}" var="item">
																		<option value="${item.name}" <c:if test="${item.name == h.bzjb}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">表彰单位：</label>
															<div class="controls">
																<input type="text" id="bzdw" name="bzdw" value="${h.bzdw}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><a href="#showdetail" id="approve1" class="black" data-toggle="modal"><i style="color:red;margin-right:5px;">*</i>表彰人员：</a></label>
															<div class="controls">
																<a href="#showdetail" id="approve1" class="black" data-toggle="modal"><input type="text" id="cyxms" name="cyxms" value="${h.cyxms}" class="form-control col-md-12 black" readonly></a>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">表彰内容：</label>
															<div class="controls">
																<textarea name="bznr" class="form-control col-md-12">${h.bznr}</textarea>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">备注：</label>
															<div class="controls">
																<textarea name="bz" class="form-control col-md-12">${h.bz}</textarea>
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
				if($('#bzmc').val() == ""){
					alert("标题不能为空");
					$('#bzmc').focus();
					return false;
				}
				if($('#cyxms').val() == ""){
					alert("请选择表彰人员不能为空");
					$('#cyxms').focus();
					return false;
				}
			});
		});
		</script>
	</body>
</html>
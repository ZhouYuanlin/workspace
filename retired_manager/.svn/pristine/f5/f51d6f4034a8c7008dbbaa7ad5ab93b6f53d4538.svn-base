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
							<a href="${request.contextPath}/retorganize/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retorganize/">
							组织关系</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retorganize/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retorganize/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<%-- <jsp:include page="../../retire/_ajaxadd.jsp"/> --%>
												<jsp:include page="../../beInCommon/_ajaxadd.jsp"/>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原支部：</label>
															<div class="controls">
																<p class="c-text" id="party"></p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>调整后支部：</label>
															<div class="controls">
																<select id="hid" name="hid" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${list}" var="item">
																		<option value="${item.id}" <c:if test="${item.id == p.hparty.id}">selected</c:if>>${item.dzbmc}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>调整日期：</label>
															<div class="controls">
																<input type="text" id="tzsj" name="tzsj" value="${p.tzsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">调整原因：</label>
															<div class="controls">
																<textarea name="tzyy" class="form-control col-md-12">${p.tzyy}</textarea>
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
				if($('#sfzh').val() == ""){
					alert("请输入身份证号");
					$('#sfzh').focus();
					return false;
				}
				if($('#hid').val() == ""){
					alert("请选择调整后支部");
					$('#hid').focus();
					return false;
				}
				if($('#tzsj').val() == ""){
					alert("调整日期不能为空");
					$('#tzsj').focus();
					return false;
				}
			});
		});
		</script>
	</body>
</html>
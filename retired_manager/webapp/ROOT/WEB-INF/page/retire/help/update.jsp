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
							<a href="${request.contextPath}/retphone/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retphone/">
							电话联系</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retphone/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/rethelp/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${r.id}"/>
											<div class="form-body">
												<jsp:include page="../_update.jsp"/>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>帮扶原因：</label>
															<div class="controls">
																<input type="text" id="bfyy" name="bfyy" value="${r.bfyy}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">帮扶额度：</label>
															<div class="controls">
																<input type="text" id="bfed" name="bfed" value="${r.bfed}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">项目：</label>
															<div class="controls">
																<select name="bfxm" class="form-control col-md-12">
																	<option>--请选择--</option>
																	<c:forEach items="${bfxmlist}" var="item">
																		<option value="${item.name}" <c:if test="${item.name == r.bfxm}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">帮扶日期：</label>
															<div class="controls">
																<input type="text" id="bfrq" name="bfrq" value="${r.bfrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="20" readonly/>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10 wzbtn" onclick="return doSave()"> 提交 </button> 
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
	</body>
</html>
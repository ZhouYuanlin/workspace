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
							<a href="${request.contextPath}/assetManage/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/assetManage/">
							资产管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/rassetManage/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/assetManage/update'/>" class="form-horizontal" method="post">
											<input type="hidden" id="assetId" name="assetId" value="${asset.assetId}" class="form-control col-md-12"/>
											<input type="hidden" name="id" value="${asset.id}"/>
											<input type="hidden" id="registerDate" name="registerDate" value="${asset.registerDate}" class="form-control col-md-12"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>资产名称：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="${asset.name}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>资产型号：</label>
															<div class="controls">
																<input type="text" id="version" name="version" value="${asset.version}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>单价：</label>
															<div class="controls">
																<input type="text" id="unitPrice" name="unitPrice" value="${asset.unitPrice}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">数量：</label>
															<div class="controls">
																<input type="text" id="aNum" name="aNum" value="${asset.aNum}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">采购日期：</label>
															<div class="controls">
																<input type="text" id="purchaseDate" name="purchaseDate" value="${asset.purchaseDate}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">质保期：</label>
															<div class="controls">
																<input type="text" name="shelfLife" value="${asset.shelfLife}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">资产类型：</label>
															<div class="controls">
																<select name="ca.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${assetlist}" var="item">
																		<option value="${item.id}" <c:if test="${asset.ca.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">资产来源：</label>
															<div class="controls">
																<select name="codeAs.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${assetSourcelist}" var="item">
																		<option value="${item.id}" <c:if test="${asset.codeAs.id == item.id}">selected</c:if>>${item.name}</option>
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
		<script>
		</script>
	</body>
</html>
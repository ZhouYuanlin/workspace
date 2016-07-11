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
							<a href="${request.contextPath}/folder/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/folder/">
							文档管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/folder/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/folder/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${r.id}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>文件名：</label>
															<div class="controls">
																<input type="text" id="fileName" name="fileName" value="${r.fileName}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">父级：</label>
															<div class="controls">
																<select id="pid" name="pid" class="form-control col-md-12">
																	<option value="">---请选择---</option>
																	<c:choose>
																	<c:when test="${fn:length(plist)<2}">
																		<c:forEach items="${plist}" var="item" >
																			<option  value="${item.id}"<c:if test="${r.id == item.id}">selected</c:if>>${item.fileName}</option>
																		</c:forEach>
																	</c:when>
																	<c:otherwise>
																	<c:forEach items="${plist}" var="item" >
																	<c:if test="${empty item.parent}">
																		<option  value="${item.id}"<c:if test="${r.parent.id == item.id}">selected</c:if>>${item.fileName}</option>
																		<c:forEach items="${item.children}" var="chi" varStatus="c">
																			<c:if test="${chi.fileType == '文件夹'}">
																			<option value="${chi.id}" <c:if test="${chi.id == r.parent.id }">selected</c:if>>
																				&nbsp;&nbsp;
																				${c.index+1}、${chi.fileName}</option>
																				</c:if>
																			<c:forEach items="${chi.children}" var="dd" varStatus="cs">
																				<c:if test="${dd.fileType == '文件夹'}">
																				<option value="${dd.id}" <c:if test="${dd.id == r.parent.id}">selected</c:if>>
																					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
																					${c.index+1}-${cs.index+1}、${dd.fileName}
																				</option>
																				</c:if>
																			</c:forEach>
																		</c:forEach>
																	</c:if>
																	</c:forEach></c:otherwise></c:choose>
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
															<button type="button" class="btn blue mgr10 wzbtn"> 提交 </button> 
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
				if($('#fileName').val() == ""){
					alert("请输入名称");
					$('#fileName').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
		</script>
	</body>
</html>
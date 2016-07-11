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
							<a href="${request.contextPath}/retsalute/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retsalute/">
							慰问服务</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retsalute/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retsalute/save'/>" class="form-horizontal" method="post">
											<input type="hidden" name="sfzhs" id="sfzhs"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">慰问类型：</label>
															<div class="controls">
																<select id="wwlx" name="wwlx" class="form-control col-md-12">
																	<c:forEach items="${wwlxlist}" var="item">
																		<option value="${item.name}" <c:if test="${r.wwlx == item.name}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>慰问时间：</label>
															<div class="controls">
																<input type="text" id="wwsj" name="wwsj" value="${cd}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="20" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">慰问地点：</label>
															<div class="controls">
																<input type="text" name="wwdd" value="${r.wwdd}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">慰问品标准：</label>
															<div class="controls">
																<input type="text" id="wwp" name="wwp" value="${r.wwp}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">看望人员：</label>
															<div class="controls">
																<input type="text" id="kwry" name="kwry" value="${r.kwry}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">执行状态：</label>
															<div class="controls">
																<select id="zxzt" name="zxzt" class="form-control col-md-12">
																	<option value="未执行" <c:if test="${r.zxzt == '未执行'}"></c:if>>未执行</option>
																	<option value="已执行" <c:if test="${r.zxzt == '已执行'}"></c:if>>已执行</option>
																	<option value="取消" <c:if test="${r.zxzt == '取消'}"></c:if>>取消</option>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><a href="#showdetail" id="approve1" class="black" data-toggle="modal"><i style="color:red;margin-right:5px;">*</i>慰问对象：</a></label>
															<div class="controls">
																<a href="#showdetail" id="approve1" class="black" data-toggle="modal"><input type="text" id="rets" name="rets" class="form-control col-md-12" readonly></a>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">慰问内容：</label>
															<div class="controls">
																<textarea id="bz" name="bz" class="form-control col-md-12">${r.bz}</textarea>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">反馈信息：</label>
															<div class="controls">
																<textarea id="fkxx" name="fkxx" class="form-control col-md-12">${r.fkxx}</textarea>
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
		<!-- 查看详情 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:530px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		  <jsp:include page="_choice.jsp"/>
		</div>
		<script>
		$(function(){
			$('.wzbtn').click(function(){
				if($('#wwsj').val() == ""){
					alert("请输入慰问时间");
					$('#wwsj').focus();
					return false;
				}
				if($("#rets").val() == ""){
					alert("请选择慰问对像");
					return false;
				}
			});
		});
		</script>
	</body>
</html>
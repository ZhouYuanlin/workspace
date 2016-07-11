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
							<a href="${request.contextPath}/rethoscard/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/rethoscard/">
							医保卡 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/rethoscard/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/rethoscard/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<jsp:include page="../../beInCommon/_ajaxadd.jsp"/>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>发放日期：</label>
															<div class="controls">
																<input type="text" id="fyrq" name="fyrq" value="${r.fyrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="20" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">是否发放：</label>
															<div class="controls">
																<select id="sfff" name="sfff" value="${r.sfff}" class="form-control col-md-12">
																	<option value="是" <c:if test="${r.sfff == '是'}">selected</c:if>>是</option>
																	<option value="否" <c:if test="${r.sfff == '否'}">selected</c:if>>否</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>就近医院一：</label>
															<div class="controls">
																<input type="text" id="jjyyo" name="jjyyo" value="${r.jjyyo}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>就近医院二：</label>
															<div class="controls">
																<input type="text" id="jjyyt" name="jjyyt" value="${r.jjyyt}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>就近医院三：</label>
															<div class="controls">
																<input type="text" id="jjyyh" name="jjyyh" value="${r.jjyyh}" class="form-control col-md-12">
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
				if($('#fyrq').val() == ""){
					alert("请选择发放日期");
					$('#fyrq').focus();
					return false;
				}
				if($('#jjyyo').val() == ""){
					alert("请输入就近医院一");
					$('#jjyyo').focus();
					return false;
				}
				if($('#jjyyt').val() == ""){
					alert("请输入就近医院二");
					$('#jjyyt').focus();
					return false;
				}
				if($('#jjyyh').val() == ""){
					alert("请输入就近医院三");
					$('#jjyyh').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
		</script>
	</body>
</html>

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
							<a href="${request.contextPath}/retirepay/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retirepay/">
							党费管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retirepay/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retirepay/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${p.id}"/>
											<div class="form-body">
												<jsp:include page="../../activ/_info.jsp"/>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>缴费时间：</label>
															<div class="controls">
																<input type="text" id="jfsj" name="jfsj" value="${p.jfsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">党费基数：</label>
															<div class="controls">
																<input type="text" id="dfjs" name="dfjs" value="${p.dfjs}" class="form-control col-md-12" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">缴费周期：</label>
															<div class="controls">
																<input type="text" id="jfzq" name="jfzq" value="${p.jfzq}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">金额：</label>
															<div class="controls">
																<input type="text" id="money" name="money" value="${p.money}" class="form-control col-md-12" readonly/>
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
			$('#jfzq').blur(function(){
				$('#money').val($('#dfjs').val() * $('#jfzq').val());
			});
			$('.btn').click(function(){
				if($('#jfsj').val() == ""){
					alert("请输入缴费时间！");
					$('#jfsj').focus();
					return false;
				}
				var reg = /^[\d|\.]+$/;//判断数字
				if($('#money').val() != "" && !reg.test($('#money').val())){
					alert("金额为数字，请检查");
					$("#money").focus();
					return false;
				}
			});
		});
		</script>
	</body>
</html>
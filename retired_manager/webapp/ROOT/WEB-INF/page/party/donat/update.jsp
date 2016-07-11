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
							<a href="${request.contextPath}/retiredonat/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retiredonat/">
							捐款信息</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retiredonat/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retiredonat/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${p.id}"/>
											<div class="form-body">
												<jsp:include page="../../activ/_info.jsp"/>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>捐款金额：</label>
															<div class="controls">
																<input type="text" id="jkje" name="jkje" value="${p.jkje}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>捐款日期：</label>
															<div class="controls">
																<input type="text" id="jkrq" name="jkrq" value="${p.jkrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
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
				var reg = /^[\d|\.]+$/;//判断数字
				if($('#sfzh').val() == ""){
					alert("请输入身份证号");
					$('#sfzh').focus();
					return false;
				}
				if($('#jkje').val() == ""){
					alert("请输入捐款金额！");
					$('#jkje').focus();
					return false;
				}
				if($('#jkje').val() != "" && !reg.test($('#jkje').val())){
					alert("捐款金额为数字，请检查");
					$("#jkje").focus();
					return false;
				}
				if($('#jkrq').val() == ''){
					alert('请输入捐款日期');
					$('#jkrq').focus();
					return false;
				}
			});
		});
		</script>
	</body>
</html>
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
							党员管理</a>
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
										<form id="frm" action="<c:url value='${request.contextPath}/retpartymems/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="sfzh" value="${ret.sfzh}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<p class="c-text">${ret.sfzh}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
											                                             <div class="form-group">
															<label class="control-label">姓名：</label>
															<div class="controls">
																<p class="c-text">${ret.xm}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
											                                             <div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<p class="c-text">${ret.xb}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
											                                             <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<p class="c-text">${ret.dwb.name}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">民族：</label>
															<div class="controls">
																<p class="c-text">${ret.mzb.name}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<p class="c-text">${ret.lxb.name}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>入党时间：</label>
															<div class="controls">
																<input type="text" id="rdsj" name="rdsj" value="${ret.rdsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
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
				var reg = /^[\d|\.]+$/;//判断数字
				if($('#sfzh').val() == ""){
					alert("请输入身份证号");
					$('#sfzh').focus();
					return false;
				}
				if($('#rdsj').val() == ""){
					alert("请输入入党时间");
					$('#rdsj').focus();
					return false;
				}
			});
		});
		</script>
	</body>
</html>
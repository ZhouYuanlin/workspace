<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.js"></script>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/rethospital/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/rethospital/">
							住院管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/rethospital/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/rethospital/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${r.id}"/>
											<input type="hidden" id="sfzh" name="sfzh" value="${r.ret.sfzh}"/>
											<div class="form-body">
												<jsp:include page="../../retire/_update.jsp"/>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>住院日期：</label>
															<div class="controls">
																<input type="text" id="zyrq" name="zyrq" value="${r.zyrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="20" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>医院：</label>
															<div class="controls">
																<input type="text" id="yymc" name="yymc" value="${r.yymc}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">科室：</label>
															<div class="controls">
																<input type="text" id="yyks" name="yyks" value="${r.yyks}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">楼层：</label>
															<div class="controls">
																<input type="text" id="yylc" name="yylc" value="${r.yylc}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">床位：</label>
															<div class="controls">
																<input type="text" id="yycw" name="yycw" value="${r.yycw}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">探视日期：</label>
															<div class="controls">
																<input type="text" id="tsrq" name="tsrq" value="${r.tsrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="20" readonly/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
                                                        <div class="form-group">
															<label class="control-label">探视人员：</label>
															<div class="controls">
																<input type="text" id="tsry" name="tsry" value="${r.tsry}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">住院原因：</label>
															<div class="controls">
																<textarea id="zyyy" name="zyyy" class="form-control col-md-12" style="height: 300px;">${r.zyyy}</textarea>
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
				if($('#zyrq').val() == ""){
					alert("请输入住院日期");
					$('#zyrq').focus();
					return false;
				}
				if($('#yymc').val() == ""){
					alert("请输入医院");
					$('#yymc').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
		</script>
	</body>
</html>

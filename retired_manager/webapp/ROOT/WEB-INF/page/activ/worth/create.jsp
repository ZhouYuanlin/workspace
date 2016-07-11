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
							<a href="${request.contextPath}/retireworthines/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retireworthines/">
							老有所为信息</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retireworthines/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retireworthines/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<jsp:include page="../../beInCommon/_ajaxadd.jsp"/>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>宣讲主题：</label>
															<div class="controls">
																<input type="text" id="title" name="title" value="${p.title}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">银龄宣讲小组：</label>
															<div class="controls">
																<select id="sfxjxz" name="sfxjxz" class="form-control col-md-12">
												             		<option value="否" <c:if test="${p.sfxjxz == '否'}">selected</c:if>>否</option>
																	<option value="是" <c:if test="${p.sfxjxz == '是'}">selected</c:if>>是</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>宣讲时间：</label>
															<div class="controls">
																<input type="text" id="xjsj" name="xjsj" value="${p.xjsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">宣讲地点：</label>
															<div class="controls">
																<input type="text" id="xjdd" name="xjdd" value="${p.xjdd}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">宣讲费用：</label>
															<div class="controls">
																<input type="text" id="xjfy" name="xjfy" value="${p.xjfy}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">说明：</label>
															<div class="controls">
																<textarea name="bz" class="form-control col-md-12">${p.bz}</textarea>
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
				if($('#title').val() == ""){
					alert("宣讲主题 不能为空");
					$('#title').focus();
					return false;
				}
				var reg = /^[\d|\.]+$/;//判断数字
				if($('#xjfy').val() != "" && !reg.test($('#xjfy').val())){
					alert("宣讲费用只能为数字");
					$("#xjfy").focus();
					return false;
				}
				$('#frm').submit();
			});
		});
		</script>
	</body>
</html>
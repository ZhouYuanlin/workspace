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
							电话联系 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retphone/">
							联系信息 </a>
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
										<form id="frm" action="<c:url value='${request.contextPath}/retphone/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${retphone.id}"/>
											<input type="hidden" id="sfzh" name="sfzh" value="${retphone.retirement.sfzh}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<p class="c-text">${retphone.retirement.sfzh}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
											                                             <div class="form-group">
															<label class="control-label">姓名：</label>
															<div class="controls">
																<p class="c-text">${retphone.retirement.xm}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
											                                             <div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<p class="c-text">${retphone.retirement.xb}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
											                                             <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<p class="c-text">${retphone.retirement.dwb.name}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">民族：</label>
															<div class="controls">
																<p class="c-text">${retphone.retirement.mzb.name}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<p class="c-text">${retphone.retirement.lxb.name}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>联系人：</label>
															<div class="controls">
																<input type="text" id="lxr" name="lxr" value="${retphone.lxr}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>联系日期：</label>
															<div class="controls">
																<input type="text" id="lxrq" name="lxrq" value="<fmt:formatDate value="${retphone.lxrq}"  pattern="yyyy-MM-dd"/>" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="20" readonly/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">联系详情：</label>
															<div class="controls">
																<textarea id="lxxq" name="lxxq" style="width: 500px;height: 100px;">${retphone.lxxq}</textarea>
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
				if($('#lxr').val() == ""){
					alert("请输入联系人");
					$('#lxr').focus();
					return false;
				}
				if($('#lxrq').val() == ""){
					alert("请选择联系日期");
					$('#lxrq').focus();
					return false;
				}
				if($('#lxxq').val().length>300){
					alert("输入的联系详情字数大于300,请重新输入！");
					$('#lxrq').focus();
					return false;
				}
				$('#frm').submit();
			});
		});
		</script>
	</body>
</html>

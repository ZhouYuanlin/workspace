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
							<a href="${request.contextPath}/retlife/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retlife/">
							生活服务</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retlife/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retlife/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="sfzh" value="${r.sfzh}"/>
											<input type="hidden" name="xm" value="${r.xm}">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<p class="c-text">${r.sfzh}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
											          <div class="form-group">
															<label class="control-label">姓名：</label>
															<div class="controls">
																<p class="c-text">${r.xm}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
											             <div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<p class="c-text">${r.xb}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
											              <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<p class="c-text">${r.dwb.name}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">民族：</label>
															<div class="controls">
																<p class="c-text">${r.mzb.name}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<p class="c-text">${r.lxb.name}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">卫生间扶手：</label>
															<div class="controls">
																<select id="wsjfs" name="wsjfs" class="form-control col-md-12">
																	<option value="已安装" <c:if test="${r.wsjfs == '已安装'}">selected</c:if>>已安装</option>
																	<option value="未安装" <c:if test="${r.wsjfs == '未安装'}">selected</c:if>>未安装</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">急救一键通：</label>
															<div class="controls">
																<select id="jjyjt" name="jjyjt" class="form-control col-md-12">
																	<option value="已安装" <c:if test="${r.jjyjt == '已安装'}">selected</c:if>>已安装</option>
																	<option value="未安装" <c:if test="${r.jjyjt == '未安装'}">selected</c:if>>未安装</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">公共意外险：</label>
															<div class="controls">
																<select id="ggywx" name="ggywx" class="form-control col-md-12">
																	<option value="已购买" <c:if test="${r.ggywx == '已购买'}">selected</c:if>>已购买</option>
																	<option value="未购买" <c:if test="${r.ggywx == '未购买'}">selected</c:if>>未购买</option>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">在职干部结对：</label>
															<div class="controls">
																<textarea name="zzgbjs" class="form-control col-md-12">${r.zzgbjs}</textarea>
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
	</body>
</html>
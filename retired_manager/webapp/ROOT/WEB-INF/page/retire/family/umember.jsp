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
							<a href="${request.contextPath}/retfamily/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retfamily/">
							家庭信息 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retfamily/">
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
											成员添加
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="<c:url value='${request.contextPath}/retfamily/updatemem'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${f.id}"> 
											<input type="hidden" id="sfzh" name="sfzh" value="${f.ret.sfzh}">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<p class="c-text">${f.ret.sfzh}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">姓名：</label>
															<div class="controls">
																<p class="c-text">${f.ret.xm}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<p class="c-text">${f.ret.xb}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">工作证号：</label>
															<div class="controls">
																<p class="c-text">${f.ret.gzzh}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<p class="c-text">${f.ret.dwb.name}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">联系电话：</label>
															<div class="controls">
																<p class="c-text">${f.ret.lxdh}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>成员姓名：</label>
															<div class="controls">
																<input type="text" id="mxm" name="mxm" value="${f.mxm}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">成员关系：</label>
															<div class="controls">
																<input type="text" id="mgx" name="mgx" value="${f.mgx}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">工作单位：</label>
															<div class="controls">
																<input type="text" id="mgzdw" name="mgzdw" value="${f.mgzdw}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">职务：</label>
															<div class="controls">
																<input type="text" id="mzw" name="mzw" value="${f.mzw}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">电话：</label>
															<div class="controls">
																<input type="text" id="mdh" name="mdh" value="${f.mdh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">居住关系：</label>
															<div class="controls">
																<input type="text" name="mjzgx" value="${f.mjzgx}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">备注：</label>
															<div class="controls">
																<input type="text" name="mkwpc" value="${f.mkwpc}" class="form-control col-md-12">
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
		<script>
		$(function(){
			$('.btn').click(function(){
				if($('#sfzh').val() == ""){
					alert("请输入身份证号");
					$('#sfzh').focus();
					return false;
				}
				if($('#mxm').val() == ""){
					alert("请输入成员姓名！");
					$('#mxm').focus();
					return false;
				}
			});
		});
		</script>
	</body>
</html>
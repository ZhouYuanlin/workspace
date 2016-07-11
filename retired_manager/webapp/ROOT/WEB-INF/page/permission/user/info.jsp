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
							<a href="${request.contextPath}/information/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/information/">
							个人信息 </a>
						</li>
					</ul>
				</div>
			</div>
			  <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-title">
										<div class="caption">
											基本信息
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="/information/bindlogin" class="form-horizontal" method="post">
											<div class="form-body">
											<div class="row">
												<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">证件号：</label>
															<div class="controls">
																<p class="c-text">${u.sfzh}</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<p class="c-text">${u.xb}</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label">工作证号：</label>
															<div class="controls">
																<input type="text" id="gzzh" name="gzzh" value="${u.gzzh}" class="form-control col-md-12"/>
															</div>
														</div>
												</div>
												<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">姓名：</label>
															<div class="controls">
																<p class="c-text">${u.xm}</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label">部门：</label>
															<div class="controls">
																<p class="c-text">${u.codedwb.name}</p>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label">手机号：</label>
															<div class="controls">
																<input type="text" id="lxdh" name="lxdh" value="${u.lxdh}" class="form-control col-md-12"/>
															</div>
														</div>
												</div>
												<div class="col-md-4">
													<div class="form-group" >
														<p style="height:172px;padding:10px;">
															<a href="/avator"><s:image id="imageThumb" user="${u.sfzh}" size="zoom"  width="120" height="130"/></a>
														</p>
													</div>
												</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" class="btn blue mgr10 wzbtn">绑定</button> 
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
			$('.wzbtn').click(function(){
				if($('#gzzh').val() == '' && $('#lxdh').val() == ''){
					alert("请输入要绑定的用户名或手机号");
					return false;
				}
				$('#frm').submit();
			});
		</script>
	</body>
</html>
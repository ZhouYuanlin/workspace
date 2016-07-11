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
							<a href="${request.contextPath}/codegjcxb/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/codegjcxb/">
							条件表管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/codegjcxb/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/codegjcxb/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
											
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>代码：</label>
															<div class="controls">
																<input type="text" id="code" name="code" value="${tjb.code}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>条件表英文名：</label>
															<div class="controls">
																<input type="text" id="ywm" name="tjbywm" value="${tjb.tjbywm}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>条件表中文名：</label>
															<div class="controls">
																<input type="text" id="zwm" name="tjbzwm" value="${tjb.tjbzwm}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">备注：</label>
															<div class="controls">
																<textarea name="bz" id="bz" class="form-control col-md-12">${tjb.bz}</textarea>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" onclick="sub();"  class="btn blue mgr10 wzbtn"> 提交 </button> 
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
<script type="text/javascript">
	function sub(){
		if($("#code").val()=='' || $("#code").val().trim()==''){
			alert("代码必填!");
			return false;
		}
		if($("#ywm").val()=='' || $("#ywm").val().trim()==''){
			alert("条件表英文名必填!");
			return false;
		}
		if($("#zwm").val()=='' || $("#zwm").val().trim()==''){
			alert("条件表中文名必填!");
			return false;
		}
		$('#frm').submit();
	}
</script>
</body>
</html>
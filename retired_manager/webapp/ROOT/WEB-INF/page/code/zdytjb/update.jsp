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
							<a href="${request.contextPath}/codezdytjb/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/codezdytjb/">
							自定义条件表管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/codezdytjb/">
							修改</a>
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
										<form id="frm" action="<c:url value='${request.contextPath}/codezdytjb/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="tjb.id" value="${tjb.id}">
											<input type="hidden" name="id" value="${zdytjb.id}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>代码：</label>
															<div class="controls">
																<input type="text" id="code" name="code" value="${zdytjb.code}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>字段英文名：</label>
															<div class="controls">
																<input type="text" id="ywm" name="zdywm" value="${zdytjb.zdywm}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>字段中文名：</label>
															<div class="controls">
																<input type="text" id="zwm" name="zdzwm" value="${zdytjb.zdzwm}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">文本类型：</label>
															<div class="controls">
																<select id="texttype" name="texttype" class="form-control col-md-12">
																    <option value="">--请选择--</option>
																	<option value="input" <c:if test="${zdytjb.texttype == 'input'}">selected</c:if>>input</option>
																	<option value="select" <c:if test="${zdytjb.texttype == 'select'}">selected</c:if>>select</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">文本值：</label>
															<div class="controls">
																<input type="text" id="textvalue" name="textvalue" value="${zdytjb.textvalue}" placeholder="例如:是$否" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">是否显示：</label>
															<div class="controls">
																<select name="sfxs" class="form-control col-md-12">
																    <option value="">--请选择--</option>
																	<option value="是" <c:if test="${zdytjb.sfxs == '是'}">selected</c:if>>是</option>
																	<option value="否" <c:if test="${zdytjb.sfxs == '否'}">selected</c:if>>否</option>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">备注：</label>
															<div class="controls">
																<textarea name="bz" id="bz" class="form-control col-md-12">${zdytjb.bz}</textarea>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" onclick="sub();" class="btn blue mgr10 wzbtn"> 提交 </button> 
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
			alert("字段英文名必填!");
			return false;
		}
		if($("#zwm").val()=='' || $("#zwm").val().trim()==''){
			alert("字段中文名必填!");
			return false;
		}
		var arr = new Array();
		arr = $("#textvalue").val().split("$");
		if($("#texttype").val()=="select"){
			if(arr.length==1){
				alert("select文本值应为a$b格式!");
				return false;
			}
		}
		$('#frm').submit();
	}
</script>
	</body>
</html>
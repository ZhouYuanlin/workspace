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
							<a href="${request.contextPath}/assetSub/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/assetSub/">
							资产领用归还 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/assetSub/">
							归还</a>
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
										<form id="frm" action="<c:url value='${request.contextPath}/assetSub/returnSuccess'/>" class="form-horizontal" method="post">
											<div class="form-body">
											<input type="hidden" name="id" value="${assetSub.id}"/>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>资产编号：</label>
															<div class="controls">
																<input type="text" id="assetId" name="assetId" value="${assetSub.assetId}" class="form-control col-md-12" readonly="readonly"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>资产名称：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="${assetSub.assetManage.name}" class="form-control col-md-12"readonly="readonly"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>型号：</label>
															<div class="controls">
																<input type="text" id="version" name="version" value="${assetSub.assetManage.version}" class="form-control col-md-12"readonly="readonly"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">领用人：</label>
															<div class="controls">
																<input type="text" id="usePerson" name="usePerson" value="${assetSub.usePerson}" class="form-control col-md-12 "readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">领用时间：</label>
															<div class="controls">
																<input type="text" id="useDate" name="useDate" value="${assetSub.useDate}" class="form-control col-md-12 " readonly/>
															</div>
														</div>
													</div>
														<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">归还时间：</label>
															<div class="controls">
																<input type="text" id="returnTime" name="returnTime" value="${assetSub.returnTime}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10 wzbtn" > 提交 </button> 
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
			$("#sfzh").blur(function(){
				if($("#sfzh").val() != ""){
					$.get("/retwork/beforeFind?"+new Date().getTime(),{sfzh:$("#sfzh").val()},function(data) {
				  		if(data == ""){
				  			alert("此身份证号人员已存在不能添加");
				  			$("#sfzh").focus();
				  			$("#sfzh").val("");
				  		}
					});
				};
			});
			$('.btn').click(function(){
				if($('#sfzh').val() == ""){
					alert("请输入身份证号");
					$('#sfzh').focus();
					return false;
				}
				if($('#xm').val() == ""){
					alert("请输入姓名！");
					$('#xm').focus();
					return false;
				}
				if(($('#gzsj').val() != '' && $('#lxsj').val() != '')){
					if(fnbeginOverEnd($('#gzsj').val(),$('#lxsj').val(),'离休时间不能小于工作时间')){
						return false;
					}
				}
			});
		});
		</script>
	</body>
</html>
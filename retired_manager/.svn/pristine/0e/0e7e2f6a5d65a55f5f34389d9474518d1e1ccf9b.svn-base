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
							<a href="${request.contextPath}/assetManage/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/assetManage/">
							资产管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/rassetManage/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/assetManage/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>资产名称：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="${asset.name}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>资产型号：</label>
															<div class="controls">
																<input type="text" id="version" name="version" value="${asset.version}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>单价：</label>
															<div class="controls">
																<input type="text" id="unitPrice" name="unitPrice" value="${asset.unitPrice}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">数量：</label>
															<div class="controls">
																<input type="text" id="aNum" name="aNum" value="${asset.aNum}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">采购日期：</label>
															<div class="controls">
																<input type="text" id="purchaseDate" name="purchaseDate" value="${asset.purchaseDate}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">质保期：</label>
															<div class="controls">
																<input type="text" name="shelfLife" value="${asset.shelfLife}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">资产类型：</label>
															<div class="controls">
																<select name="ca.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${assetlist}" var="item">
																		<option value="${item.id}">${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">资产来源：</label>
															<div class="controls">
																<select name="codeAs.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${assetSourcelist}" var="item">
																		<option value="${item.id}" >${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<%-- div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">卫生间扶手：</label>
															<div class="controls">
																<select id="wsjfs" name="wsjfs" class="form-control col-md-12">
																	<option value="已安装" <c:if test="${ret.wsjfs == '已安装'}">selected</c:if>>已安装</option>
																	<option value="未安装" <c:if test="${ret.wsjfs == '未安装'}">selected</c:if>>未安装</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">急救一键通：</label>
															<div class="controls">
																<select id="jjyjt" name="jjyjt" class="form-control col-md-12">
																	<option value="已安装" <c:if test="${ret.jjyjt == '已安装'}">selected</c:if>>已安装</option>
																	<option value="未安装" <c:if test="${ret.jjyjt == '未安装'}">selected</c:if>>未安装</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">公共意外险：</label>
															<div class="controls">
																<select id="ggywx" name="ggywx" class="form-control col-md-12">
																	<option value="已购买" <c:if test="${ret.ggywx == '已购买'}">selected</c:if>>已购买</option>
																	<option value="未购买" <c:if test="${ret.ggywx == '未购买'}">selected</c:if>>未购买</option>
																</select>
															</div>
														</div>
													</div>
												</div--%>
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
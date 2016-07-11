<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
	<script type="text/javascript" src="${request.contextPath}/defaults/js/bootstrap-typeahead.js"></script>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/retparty/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retparty/">
							党支部管理</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retparty/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retparty/save'/>" class="form-horizontal" method="post">
											<input type="hidden" name="rets" id="rets"/>
											<input type="hidden" name="sfhs" id="sfhs"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>党支部名称：</label>
															<div class="controls">
																<input type="text" id="dzbmc" name="dzbmc" value="${r.dzbmc}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">党支部简称：</label>
															<div class="controls">
																<input type="text" id="dzbjc" name="dzbjc" value="${r.dzbjc}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">党支部书记：</label>
															<div class="controls">
																<a href="#showzbsj" id="approve3" class="zbsjlack" data-toggle="modal"><input type="text" id="dzbsj" name="dzbsj" value="${r.dzbsj}" class="form-control col-md-12" readonly/></a>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">党支部副书记：</label>
															<div class="controls">
																<a href="#showzbfsj" id="approve4" class="zbfsjlack" data-toggle="modal"><input type="text" id="dzbfsj" name="dzbfsj" value="${r.dzbfsj}" class="form-control col-md-12" readonly/></a>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">联络员：</label>
															<div class="controls">
																<input type="text" name="zblny" value="${r.zblny}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">联系电话：</label>
															<div class="controls">
																<input type="text" name="lxdh" value="${r.lxdh}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<select id="lxb" name="lxb.id" class="form-control col-md-12">
																	<option value="">---请选择---</option>
																	<c:forEach items="${lxblist}" var="item">
																		<option value="${item.id}" <c:if test="${r.lxb.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">单位：</label>
															<div class="controls">
																<select id="dwb" name="dwb.id" class="form-control col-md-12">
																	<option value="">---请选择---</option>
																	<c:forEach items="${dwblist}" var="item">
																		<option value="${item.id}" <c:if test="${r.dwb.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">党支部代码：</label>
															<div class="controls">
																<input type="text" id="dzbdm" name="dzbdm" value="${r.dzbdm}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">支委：</label>
															<div class="controls">
																<a href="#showzw" id="approve2" class="zwblack" data-toggle="modal"><input type="text" id="xms" name="xms" value="" class="form-control col-md-12" readonly/></a>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><a href="#showdetail" id="approve1" class="black" data-toggle="modal">党员：</a></label>
															<div class="controls">
																<a href="#showdetail" id="approve1" class="black" data-toggle="modal"><input type="text" id="dys" name="dys" class="form-control col-md-12" readonly></a>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">党支部简介：</label>
															<div class="controls">
																<textarea id="zzms" name="zzms" class="form-control col-md-12">${r.zzms}</textarea>
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
		<!-- 选择人员 -->
		<div class="modal fade" id="showzbsj" tabindex="-1" role="testModal" aria-hidden="true" style="width:530px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		  <jsp:include page="_zbsj.jsp"/>
		</div>
		<div class="modal fade" id="showzbfsj" tabindex="-1" role="testModal" aria-hidden="true" style="width:530px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		  <jsp:include page="_zbfsj.jsp"/>
		</div>
		<div class="modal fade" id="showzw" tabindex="-1" role="testModal" aria-hidden="true" style="width:530px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		  <jsp:include page="_user.jsp"/>
		</div>
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:530px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		  <jsp:include page="_choice.jsp"/>
		</div>
		<script>
		$(function(){
			$("#dzbmc").blur(function(){
				if($("#dzbmc").val() != ""){
					$(".btn").removeAttr("disabled");
					$.get("/retparty/beforeFind?"+new Date().getTime(),{dzbmc:$("#dzbmc").val()},function(data) {
				  		if(data != ""){
				  			alert($('#dzbmc').val() + '已存在不能添加！');
				  			$("#dzbmc").focus();
				  			$("#dzbmc").val("");
				  		}
					});
				};
			});
			$('.wzbtn').click(function(){
				if($('#dzbmc').val() == ""){
					alert("党支部名称不能为空");
					$('#dzbmc').focus();
					return false;
				}
			
			});
		});
		</script>
	</body>
</html>
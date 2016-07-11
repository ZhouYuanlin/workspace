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
							<a href="${request.contextPath}/retdeath/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retdeath/">
							离世管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retdeath/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retdeath/save'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<jsp:include page="_ajaxadd.jsp"/>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">离世原因：</label>
															<div class="controls">
																<input type="text" name="lsyy" value="${ret.lsyy}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">离世时间：</label>
															<div class="controls">
																<input type="text" id="lssj" name="lssj" value="${ret.lssj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="20" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">离世地点：</label>
															<div class="controls">
																<input type="text" name="lsdd" value="${ret.lsdd}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">丧事从简：</label>
															<div class="controls">
																<label class="checkbox-inline"><input type="checkbox" id="sscj" name="sscj" value="是"></label>
															</div>
														</div>
													</div>
												</div>
												<div class="isshow">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">告别仪式时间：</label>
															<div class="controls">
																<input type="text" id="gbyssj" name="gbyssj" value="${ret.gbyssj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="20" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">告别仪式地点：</label>
															<div class="controls">
																<input type="text" id="gbysdd" name="gbysdd" value="${ret.gbysdd}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<!-- div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">籍贯：</label>
															<div class="controls">
																<select id="jg" name="jg" class="form-control col-md-12">
																	<c:forEach items="${sydlist}" var="item">
																		<option value="${item.name}" <c:if test="${ret.jg == item.name}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div-->
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">个人生平：</label>
															<div class="controls">
																<textarea id="grsp" name="grsp" class="form-control col-md-12">${ret.grsp}</textarea>
															</div>
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
			$("#sscj").click(function(){
				if($(this).prop('checked')){
					$(".isshow").hide();
					$("#gbyssj").val("");
					$("#gbysdd").val("");
					$("#grsp").val("");
				}else{
					$(".isshow").show();
				}
			});
			/* $("#sfzh").blur(function(){
				if($("#sfzh").val() != ""){
					$(".btn").removeAttr("disabled");
					$.get("/retwork/beforeFind?"+new Date().getTime(),{sfzh:$("#sfzh").val()},function(data) {
				  		if(data != ""){
				  			alert('根据身份证号未找到退休人员！');
				  			$("#sfzh").focus();
				  			$("#sfzh").val("");
				  			$("#save").attr({"disabled":"disabled"});
				  		}else{
				  			$.post("/retwork/querybysfzh/json?"+(new Date()).getTime(),{sfzh:$("#sfzh").val()},function(d){
								$.each($.parseJSON(d),function(i,e){
									$("#sfzh").val(e.sfzh);
									$("#xm").val(e.xm);
									$("#xb").val(e.xb);
									$("#dwb.id").val(e.dwb);
									$("#mzb.id").val(e.mzb);
									$("#lxb.id").val(e.lxb);
									$("#jg").val(e.jg);
								});
							});
						}
					});
				};
			}); */
		});
		$(function(){
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
			});
		});
		</script>
	</body>
</html>
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
							<a href="${request.contextPath}/account/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/account/">
							用户管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/account/">
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
											信息添加
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="<c:url value='${request.contextPath}/account/update'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>身份证号：</label>
															<div class="controls">
																<input type="text" id="sfzh" name="sfzh" value="${user.sfzh}" class="form-control col-md-12" onblur="checkUName(this);"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>姓名：</label>
															<div class="controls">
																<input type="text" id="xm" name="xm" value="${user.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<select name="xb" class="form-control col-md-12">
																	<option value="男" <c:if test="${user.xb == '男'}">selected</c:if>>男</option>
																	<option value="女" <c:if test="${user.xb == '女'}">selected</c:if>>女</option>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">工作证号：</label>
															<div class="controls">
																<input type="text" id="gzzh" name="gzzh" value="${user.gzzh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">所在岗位：</label>
															<div class="controls">
																<select id="ssgw" name="ssgw" class="form-control col-md-12">
																		<c:forEach items="${dwblist}" var="item">
																			<option value="${item.id}" <c:if test="${item.id == user.codedwb.id}">selected</c:if>>${item.name}</option>
																		</c:forEach>
																</select>
															</div>
														</div>
													</div>
													</div>
													<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">联系电话：</label>
															<div class="controls">
																<input type="text" name="lxdh" value="${user.lxdh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">用户到期时间：</label>
															<div class="controls">
																<input type="text" name="role" value="${user.role}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>用户角色：</label>
															<div class="controls">
																<c:set var="xsrole" value="<%=cn.uuf.contants.Constants.INFOGR%>"/>
									                             <c:forEach items="${roleList}" var="item" varStatus="c">
									                              <label class="checkbox inline">
									                                <c:if test="${item.scope != xsrole}"><input type="checkbox" name="rId" id="rId" class="rolesClass" ref="${item.scope}" value="${item.id}" <c:forEach items="${acc.roles}" var="chi"><c:if test="${chi.id == item.id}">checked</c:if></c:forEach>/>${item.name}</c:if>
									                            </label>
									                            </c:forEach>
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
		function doSave(){
			if($('#sfzh').val() == ""){
				alert("请输入身份证号！");
				$('#sfzh').focus();
				return false;
			}else if($('#xm').val() == ""){
				alert("姓名不能为空 ！");
				$('#xm').focus();
				return false;
			}
			var bol = false;
			var str = "";
			$('.rolesClass').each(function(){
				if($(this).is(':checked')){
					bol = true;
					str += $(this).val() + ",";
				}
			});
			if(!bol){
				alert('请选择用户角色');
				return false;
			}
			return true;
		}
		function checkUName(obj){
			var value=$(obj).val();
			$.post("/account/checkUName?"+new Date().getTime(),"name="+value,function(data){
				if(data=='1'){
					$(obj).val('');
					$(obj).focus();
					window.setTimeout(function(){ $('#'+obj.id).focus();}, 0);//Firefox
					alert("用户名已存在,请重新输入!");
				}
			})
		}
		</script>
	</body>
</html>
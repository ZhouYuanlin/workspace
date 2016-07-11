<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
	<script type="text/javascript" src="${request.contextPath}/defaults/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/retment/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retment/">
							人员管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retment/">
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
										<form id="frm" action="<c:url value='${request.contextPath}/retment/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="sfzh" value="${ret.sfzh}"/>
											<input type="hidden" name="zzgbjs" value="${ret.zzgbjs}"/>
											<input type="hidden" name="wsjfs" value="${ret.wsjfs}"/>
											<input type="hidden" name="jjyjt" value="${ret.jjyjt}"/>
											<input type="hidden" name="ggywx" value="${ret.ggywx}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<p class="c-text">${ret.sfzh}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>姓名：</label>
															<div class="controls">
																<input type="text" id="xm" name="xm" value="${ret.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<select name="xb" class="form-control col-md-12">
																    <option value="">--请选择--</option>
																	<option value="男" <c:if test="${ret.xb == '男'}">selected</c:if>>男</option>
																	<option value="女" <c:if test="${ret.xb == '女'}">selected</c:if>>女</option>
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
																<input type="text" id="gzzh" name="gzzh" value="${ret.gzzh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<select name="dwb.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${dwblist}" var="item">
																		<option value="${item.id}" <c:if test="${ret.dwb.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">联系电话：</label>
															<div class="controls">
																<input type="text" name="lxdh" value="${ret.lxdh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">民族：</label>
															<div class="controls">
																<select name="mzb.id" class="form-control col-md-12">
																<option value="">--请选择--</option>
																	<c:forEach items="${mzblist}" var="item">
																		<option value="${item.id}" <c:if test="${ret.mzb.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">职务：</label>
															<div class="controls">
																<select name="zwb.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${zwblist}" var="item">
																		<option value="${item.id}" <c:if test="${ret.zwb.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">职级：</label>
															<div class="controls">
																<select name="zjb.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${zjblist}" var="item">
																		<option value="${item.id}" <c:if test="${ret.zjb.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<select name="lxb.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${lxblist}" var="item">
																		<option value="${item.id}" <c:if test="${ret.lxb.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">政治面貌：</label>
															<div class="controls">
																<select name="zzmm.id" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${zzmmlist}" var="item">
																		<option value="${item.id}" <c:if test="${ret.zzmm.id == item.id}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">籍贯：</label>
															<div class="controls">
																<select name="jg" class="form-control col-md-12">
																<option value="">--请选择--</option>
																	<c:forEach items="${sydlist}" var="item">
																		<option value="${item.name}" <c:if test="${ret.jg == item.name}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">婚姻状况：</label>
															<div class="controls">
																<select name="fyzk" class="form-control col-md-12">
																    <option value="">--请选择--</option>
																	<option value="已婚" <c:if test="${ret.fyzk == '已婚'}">selected</c:if>>已婚</option>
																	<option value="未婚" <c:if test="${ret.fyzk == '未婚'}">selected</c:if>>未婚</option>
																	<option value="丧偶" <c:if test="${ret.fyzk == '丧偶'}">selected</c:if>>丧偶</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">学历：</label>
															<div class="controls">
																<select name="grxl" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${xlblist}" var="item">
																		<option value="${item.name}" <c:if test="${ret.grxl == item.name}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">学位：</label>
															<div class="controls">
																<select name="grxw" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${xwblist}" var="item">
																		<option value="${item.name}" <c:if test="${ret.grxw == item.name}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">是否独居：</label>
															<div class="controls">
																<select name="sfdj" class="form-control col-md-12">
																    <option value="">--请选择--</option>
																	<option value="否" <c:if test="${ret.sfdj == '否'}">selected</c:if>>否</option>
																	<option value="是" <c:if test="${ret.sfdj == '是'}">selected</c:if>>是</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">是否孤寡：</label>
															<div class="controls">
																<select name="sfgg" class="form-control col-md-12">
																    <option value="">--请选择--</option>
																	<option value="否" <c:if test="${ret.sfgg == '否'}">selected</c:if>>否</option>
																	<option value="是" <c:if test="${ret.sfgg == '是'}">selected</c:if>>是</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">是否失能：</label>
															<div class="controls">
																<select name="sssn" class="form-control col-md-12">
																    <option value="">--请选择--</option>
																	<option value="否" <c:if test="${ret.sssn == '否'}">selected</c:if>>否</option>
																	<option value="是" <c:if test="${ret.sssn == '是'}">selected</c:if>>是</option>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">是否保健干部：</label>
															<div class="controls">
																<select name="sfbjgb" class="form-control col-md-12">
																    <option value="">--请选择--</option>
																	<option value="否" <c:if test="${ret.sfbjgb == '否'}">selected</c:if>>否</option>
																	<option value="是" <c:if test="${ret.sfbjgb == '是'}">selected</c:if>>是</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">QQ：</label>
															<div class="controls">
																<input type="text" name="qq" value="${ret.qq}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">微信：</label>
															<div class="controls">
																<input type="text" name="weix" value="${ret.weix}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												
												
												<div class="row">
													
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">邮箱：</label>
															<div class="controls">
																<input type="text" name="email" value="${ret.email}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">出生日期：</label>
															<div class="controls">
																<input type="text" name="csrq" value="${ret.csrq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">护照号码：</label>
															<div class="controls">
																<input type="text" name="fzhm" value="${ret.fzhm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">工作时间：</label>
															<div class="controls">
																<input type="text" id="gzsj" name="gzsj" value="${ret.gzsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">离休时间：</label>
															<div class="controls">
																<input type="text" id="lxsj" name="lxsj" value="${ret.lxsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">现享受待遇：</label>
															<div class="controls">
																<select name="xsdy" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${dyblist}" var="item">
																		<option value="${item.name}" <c:if test="${ret.xsdy == item.name}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
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
				if($('#xm').val() == ""){
					alert("姓名不能为空 ！");
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
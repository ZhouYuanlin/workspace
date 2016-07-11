<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="xxs" tagdir="/WEB-INF/tags" %>
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/defaults/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css"/>
	<link href="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet"/>
	<script src="${request.contextPath}/defaults/plugins/My97DatePicker/WdatePicker.js" type="text/javascript" ></script>
	<script type="text/javascript" src="${request.contextPath}/defaults/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
	<script src="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.js"></script>
<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>活动详情</h3>
		  </div>
		  <div class="modal-body" style="height:500px;">
		    <div class="form">
		       <form id="frm" action="<c:url value='${request.contextPath}/activityReleas/assinSuccess'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${r.id}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动名称：</label>
															<div class="controls">
																<input type="text" id="activityName" name="activityName" value="${r.activityName}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动地点：</label>
															<div class="controls">
																<input type="text" id="address" name="address" value="${r.address}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>开始日期：</label>
															<div class="controls">
																<input type="text" id="startTime" name="startTime" value="${r.startTime}" class="form-control col-md-12" readonly="readonly"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>结束日期：</label>
															<div class="controls">
																<input type="text" id="endTime" name="endTime" value="${r.endTime}" class="form-control col-md-12" readonly="readonly"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>报名截止日期：</label>
															<div class="controls">
																<input type="text" id="addEndTime" name="addEndTime" value="${r.addEndTime}" class="form-control col-md-12" readonly="readonly"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>负责人：</label>
															<div class="controls">
																<input type="text" id="person" name="person" value="${r.person}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>联系电话：</label>
															<div class="controls">
																<input type="text" id="tel" name="tel" value="${r.tel}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车辆数量：</label>
															<div class="controls">
																<input type="text" id="carNumber" name="carNumber" value="${r.carNumber}" class="form-control col-md-12" readonly="readonly"> 
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>车辆乘坐人数：</label>
															<div class="controls">
																<input type="text" id="peopleNub" name="peopleNub" value="${r.peopleNub}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">报名人数：</label>
															<div class="controls">
																<input type="text" value="${nums}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">备注：</label>
															<div class="controls">
																<input type="text" id="remarks" name="remarks" value="${r.remarks}" class="form-control col-md-12" readonly="readonly">
															</div>
														</div>
													</div>
												</div>
												
												 <div class="row">
													<div class="col-md-12">
								                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
								                                <thead>
								                                <tr>
								                                	<th width="45">序号</th>
								                                   <!--  <th class="table-checkbox" width="45">
								                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
								                                    </th> -->
								                                    <th>身份证号码</th>
								                                 <!--    <th>姓名</th> -->
								                                    <th>参加活动时间</th>
								                                    <th>报名方式</th>
								                                    <th>报名时间</th>
								                                    <th>车辆编号</th>
								                                    <th>座位编号</th>
								                                </tr>
								                                </thead>
								                                <tbody>
								                                <c:forEach items="${peo}" var="item" varStatus="c">
								                                <tr class="odd gradeX">
								                                	<td>${c.index + 1}</td>
<%-- 								                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
 --%>								                                <td>${item.idCard}</td>
                                                                   <%--  <td>${item.ac.realname}</td> --%>
								                                    <td>${item.comeTime}</td>
								                                    <td>${item.entryMode}</td>
								                                    <td>${item.enrollTime}</td>
								                                    <td>${item.carNumber}</td>
								                                    <td>${item.seatNumber}</td>
								                                </tr>
								                                </c:forEach>
								                                </tbody>
								                                </table>
															<div class="pagination pull-right">
																<s:pagination page="${paginate.page}" namespace="/" controller="retireactivity" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
															</div>
								              		</div>
												</div>
												
												
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">活动图片：</label>
															<div class="controls" id="siteWebLog">
																<input type="hidden" id="siteWebLogName" value="imgurl" />
																<xxs:commonupload id="siteWebLog" uploadType="1" type="1"
																	name="imgurl" fileTypes="*.jpg;*.gif;*.png"
																	sizeLimit="10 MB" srcImg="${r.imgurl}"
																	showText="true" styleClass="text_4" />
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动介绍：</label>
															<div class="controls">
																<textarea id="introduction" name="introduction" class="form-control col-md-12" style="height: 300px;" readonly="readonly">${r.introduction}</textarea>
															</div>
														</div>
													</div>
												</div>
												</div>
										</form>
		    </div>
		  </div>

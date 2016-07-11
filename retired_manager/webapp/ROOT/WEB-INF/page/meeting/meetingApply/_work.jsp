<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>会议室申请审核</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form id="wkfrm" action="meetingApplyShow/auditSuccess" class="form-horizontal" method="post">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
						<input type="hidden" name="id" value="${r.id}"/>
						<input type="hidden" name="times" id="times" value="0"/>
							<div class="form-group">
								<label class="control-label">会议室名称：</label>
								<div class="controls">
									<select name="meetingRoom.Id"  id="meetingRoom.Id" class="form-control col-md-12">
										<option value="">----请选择----</option>
										<c:forEach items="${carslist}" var="item">
											<option value="${item.id}" <c:if test="${item.name == r.meetingRoom.name}">selected</c:if>>${item.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">申请人：</label>
								<div class="controls">
									<input type="text" id="applicantName" name="applicantName" value="${r.applicantName}" class="form-control col-md-12" readonly="readonly">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">申请使用日期：</label>
								<div class="controls">
										<input  type="text" id="useTime" name="useTime" value="${r.useTime}" class="form-control col-md-12 " readonly="readonly"/>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">申请使用时间：</label>
								<div class="controls">
									<input  type="hidden" id="startTime" name="startTime" value="${r.startTime}" class="form-control col-md-12 " readonly="readonly"/>
									<input type="hidden" id="endTime" name="endTime" value="${r.endTime}" class="form-control col-md-12"  readonly="readonly"/>
									<input  type="text" id="Time" name="Time" value="${r.startTime}-${r.endTime}" class="form-control col-md-12 " readonly="readonly"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">会议主题：</label>
								<div class="controls">
									<input type="text" id="title" name="title" value="${r.title}" class="form-control col-md-12" readonly="readonly">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">参会人数：</label>
								<div class="controls">
									<input type="text" id="attendNum" name="attendNum" value="${r.attendNum}" class="form-control col-md-12" readonly="readonly">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">申请原因：</label>
								<div class="controls">
									<input type="text" id="reason" name="reason" value="${r.reason}" class="form-control col-md-12" readonly="readonly">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">审核状态：</label>
									<div class="controls">
										<select name="status"  id="status" class="form-control col-md-12">
											 <option value="0" >待审核</option>
											 <option value="1" selected>审核通过</option>
											 <option value="2" >审核不通过</option>
										</select>
									</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">审核意见：</label>
									<div class="controls">
										<textarea id="opinion" name="opinion" class="form-control col-md-12" style="height: 120px;"><c:if test="${r.opinion != ''}">${r.opinion}</c:if></textarea>
									</div>
							</div>
						</div>
					</div>
		          </div>
		        </form>
		    </div>
		  </div>
		  <div class="modal-footer">
		   <button id="tijiao" data-dismiss="modal" class="btn blue confirm">审核完成</button>
		   <!--  <button data-dismiss="modal" class="btn blue confirm">关闭</button> -->
		   <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		  </div>
		  <script>
		  	$(function(){
		  	$('#tijiao').click(function(){
			  			$('#wkfrm').submit();
			  		});
		  	});
		  </script>  		
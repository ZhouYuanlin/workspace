<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>会议室申请</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form id="wkfrm" action="meetingApplyShow/save" class="form-horizontal" method="post">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">会议室名称：</label>
								<div class="controls">
									<input type="text" id="meetingRoom.name" name="meetingRoom.name" value="${r.name }" class="form-control col-md-12" readonly="readonly"/>
									<input type="hidden" id="meetingRoom.Id" name="meetingRoom.Id" value="${r.id}" class="form-control col-md-12" readonly="readonly">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">使用时间：</label>
								<div class="controls">
									<input type="text" id="useTime" name="useTime" value="${useTime }" class="form-control col-md-12" readonly="readonly"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">申请使用开始时间：</label>
								<div class="controls">
									<!-- <input type="text" id="startTime" name="startTime"  class="form-control col-md-12" /> -->
									<div class="input-group">
											<span class="input-group-btn">
											<input type="text" id="startTime" name="startTime" value="<c:if test='${empty w.kssj}'><fmt:formatDate value='${w.createDate}' pattern='HH:mm'/></c:if><c:if test='${!empty w.kssj}'>${w.kssj}</c:if>" class="form-control timepicker timepicker-24" style="width:120px;">
											<button class="btn default timepicker-btn" type="button"><i class="fa fa-clock-o"></i></button>
											</span>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">申请使用结束时间：</label>
								<div class="controls">
									<!-- <input type="text" id="endTime" name="endTime"  class="form-control col-md-12" /> -->
									<div class="input-group">
											<span class="input-group-btn">
											<input type="text" id="endTime" name="endTime" value="<c:if test='${empty w.kssj}'><fmt:formatDate value='${w.createDate}' pattern='HH:mm'/></c:if><c:if test='${!empty w.kssj}'>${w.kssj}</c:if>" class="form-control timepicker timepicker-24" style="width:120px;">
											<button class="btn default timepicker-btn" type="button"><i class="fa fa-clock-o"></i></button>
											</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">会议主题：</label>
								<div class="controls">
									<input type="text" id="title" name="title"  class="form-control col-md-12" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">参会人数：</label>
								<div class="controls">
									<input type="text" id="attendNum" name="attendNum"  class="form-control col-md-12" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label"><i style="color: red; margin-right: 5px;">*</i>申请原因：</label>
								<div class="controls">
									<textarea id="reason" name="reason" class="form-control col-md-12" style="height: 60px;"></textarea>
								</div>
							</div>
						</div>
						<%-- <div class="col-md-6">
							<div class="form-group">
								<label class="control-label">体检医院：</label>
								<div class="controls">
									<p class="c-text">${r.tjyy}</p>
								</div>
							</div>
						</div> --%>
					</div>
					<%-- <div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">审核状态：</label>
									<div class="controls">
										<select name="state"  id="state" class="form-control col-md-12">
											 <option value="待审核" <c:if test="${r.state == '待审核'}">selected</c:if>>待审核</option>
											 <option value="审核通过" <c:if test="${r.state == '审核通过'}">selected</c:if>>审核通过</option>
											 <option value="审核不通过" <c:if test="${r.state == '审核不通过'}">selected</c:if>>审核不通过</option>
										</select>
									</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label">审核日期：</label>
									<div class="controls">
										<input type="text" id="applyTime" name="applyTime" value="${r.applyTime}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
									</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">审核意见：</label>
									<div class="controls">
										<textarea id="opinion" name="opinion" class="form-control col-md-12" style="height: 300px;"><c:if test="${r.opinion != ''}">${r.opinion}</c:if></textarea>
									</div>
							</div>
						</div>
					</div> --%>
		          </div>
		        </form>
		    </div>
		  </div>
		  <div class="modal-footer">
		    <button id="tijiao" data-dismiss="modal" class="btn blue confirm">申请</button>
		   <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		  </div>
		  
		   <script>
		  	$(function(){
		  		$('.date-picker').datepicker({
					rtl: Metronic.isRTL(),
					autoclose: true,
					language: "zh-CN"
				});
				$('.timepicker-24').timepicker({
					autoclose: true,
					minuteStep: 5,
					showSeconds: false,
					showMeridian: false
				});
				$('.timepicker').parent('.input-group-btn').on('click', '.timepicker-btn', function(e){
					e.preventDefault();
					$(this).parent('.input-group-btn').find('.timepicker').timepicker('showWidget');
				});
			  	$('#tijiao').click(function(){
				  		if($('#reason').val() == ""){
							alert("请选择输入申请原因");
							$('#reason').focus();
							return false;
						}
				  			$('#wkfrm').submit();
				  		});
			  	});
		  </script>  	
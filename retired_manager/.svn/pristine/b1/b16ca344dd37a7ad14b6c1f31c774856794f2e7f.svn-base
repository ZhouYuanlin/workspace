<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

		<div class="modal-header" >
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>工作管理</h3>
			  </div>
			  <div class="modal-body">
				    <div class="form">
			        <form id="wkfrm" action="/workdaily/save" class="form-horizontal" method="post">
			        	<input type="hidden" name="id" value="${w.id}"/>
			          <div class="form-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label">日期：</label>
									<div class="controls">
										<div class="input-group date date-picker" data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" id="nf" name="nf" value="<fmt:formatDate value='${w.createDate}' pattern='yyyy-MM-dd'/>" class="form-control" >
											<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label">时间：</label>
									<div class="controls">
										<div class="input-group">
											<span class="input-group-btn">
											<input type="text" id="kssj" name="kssj" value="<c:if test='${empty w.kssj}'><fmt:formatDate value='${w.createDate}' pattern='HH:mm'/></c:if><c:if test='${!empty w.kssj}'>${w.kssj}</c:if>" class="form-control timepicker timepicker-24" style="width:120px;">
											<button class="btn default timepicker-btn" type="button"><i class="fa fa-clock-o"></i></button>
											</span>
											<span class="input-group-btn">
											<input type="text" id="jssj" name="jssj" value="<c:if test='${empty w.jssj}'><fmt:formatDate value='${w.createDate}' pattern='HH:mm'/></c:if><c:if test='${!empty w.jssj}'>${w.jssj}</c:if>" class="form-control timepicker timepicker-24" style="width:120px;">
											<button class="btn default timepicker-btn" type="button"><i class="fa fa-clock-o"></i></button>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label">类别：</label>
									<div class="controls">
										<select name="type" class="form-control col-md-12">
											<c:forTokens items="${tps}" delims="," var="t">
												<option value="${t}" <c:if test="${t == w.type}">selected</c:if>>${t}</option>
											</c:forTokens>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label">重要程度：</label>
									<div class="controls">
										<select id="sfzy" name="sfzy" class="form-control col-md-12">
											<c:forTokens items="${sfzy}" delims="," var="zy">
												<option value="${zy}" <c:if test="${zy ==w.sfzy}">selected</c:if>>
												${zy}</option>
											</c:forTokens>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label">内容：</label>
									<div id="biaoj" class="controls">
											<textarea id="content" name="content" style="height: 200px;" class="form-control col-md-12">${w.content}</textarea>
									</div>
								</div>
							</div>
						</div>
			          </div>
			        </form>
			    </div>
			  </div>
			  
			  <div class="modal-footer">
			    <button data-dismiss="modal" class="btn blue confirm">确定</button>
			    <c:if test="${!empty w.id}"><button class="btn cutlog" data-dismiss="modal">删除</button></c:if>
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
			  		$('.confirm').click(function(){
			  			var a = $('#kssj').val();
			  			var b = $('#jssj').val();
						if (a>b) {
							alert("结束时间不能小于开始时间!! ");
							return false;
						}
			  			if($('#nf').val() == ""){
			  				alert("请选择日期");
			  				$('#nf').focus();
			  				return false;
			  			}
			  			if($('#content').val() == ""){
			  				alert("请输入内容!");
			  				$('#content').focus();
			  				return false;
			  			}
			  			if($('#content').val().length>1000){
			  				alert("工作计划内容不能大于1000个字!");
			  				return false;
			  			}
			  			$('#wkfrm').submit();
			  		});
			  		
			  		$('.cutlog').click(function(){
			  			if(confirm("确定要删除日志？")){
			  				$("#wkfrm").attr('action','/workdaily/strike').submit();
			  			}else
			  				return false;
			  		});
			  	});
			  	
			  </script>
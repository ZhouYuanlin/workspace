<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
	</head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retbirthday'/>" class="form-horizontal" method="post">
		<input type="hidden" name="ksage" id="ksage" value="${ksage}"/>
		<input type="hidden" name="jsage" id="jsage" value="${jsage}"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retbirthday">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retbirthday">
							人员管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retbirthday">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
              <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-body form">
										
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">姓名：</label>
															<div class="controls">
																<input type="text" id="xm" name="xm" value="${ret.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<select name="dwb.id"  id="dwb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${dwblist}" var="item">
												             			<option value="${item.id}" <c:if test="${ret.dwb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<select name="lxb.id"  id="lxb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${lxblist}" var="item">
												             			<option value="${item.id}" <c:if test="${ret.lxb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">出生日期(起)：</label>
															<div class="controls">
																<input type="text" id="kssj" name="kssj" value="${kssj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">出生日期(止)：</label>
															<div class="controls">
																<input type="text" id="jssj" name="jssj" value="${jssj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">年龄范围：</label>
															<div class="controls">
																<input type="hidden" name="ages" class="range_slide" 
																value='<c:choose>
																	<c:when test="${empty ages}">0,120</c:when>
																	<c:otherwise>${ages}</c:otherwise>
																</c:choose>' /> 
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10 wzbtn"><i class="fa fa-search"></i> 查询</button> 
														</div>
													</div>
												</div>
											</div>
										
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
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>民族</th>
                                    <th>原工作单位</th>
                                    <th>类型</th>
                                    <th>出生日期</th>
                                    <th>生日倒计时</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td>${item.xm}</td>
                                    <td>${item.xb}</td>
                                    <td>${item.mzb.name}</td>
                                    <td title="${item.dwb.name}"><s:substring length="10" value="${item.dwb.name}"/></td>
                                    <td>${item.lxb.name}</td>
                                    <td>${item.csrq}</td>
                                    <td>${item.srtx}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retbirthday" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<script>
		$(document).ready(function (){
			$('#xm').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/retment/autoCompleteUser', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#xm'
				,id:1
				,cusReq:selUser
				,view:3
			});
		});

//查询到用户放入姓名框中
		function selUser(id){
		   var tid=id.split('-')[1];
		  $("#xm").val(tid);
		}
		$(function(){
			$(".range_slide").jRange({ 
				from: 0, 
				to: 120, 
				step: 1, 
				scale: [0,20,40,60,80,100,120], 
				format: '%s', 
				showLabels: true, 
				showScale: true,
				theme:'theme-blue',
			});
			
			$('.btn-sm').blur(function(){
				var i=0;
				$('.btn-sm').each(function(){
					if($('#kssj').val() == '' && $('#jssj').val() == ''){
						if($(this).hasClass('active'))
							i++;
						if(i > 2)
							$(this).removeClass('active');
					}else{
						$(this).removeClass('active');
						$('#ksage').val('');$('#jsage').val('');
					}
				});
			});//选择生日时间段取消具体年龄段
			$('.date-picker').blur(function(){
				$('.btn-sm').each(function(){
					$(this).removeClass('active');
					$('#ksage').val('');$('#jsage').val('');
				});
			});
			//查询
			$('.wzbtn').click(function(){
				var i = 0;
				$('.btn-sm').each(function(){
					if($(this).hasClass('active') && i < 1){
						$("#ksage").val($(this).attr("ref"));
						i++;
					}else if($(this).hasClass('active') && i >= 1){
						$("#jsage").val($(this).attr("ref"));
						i++;
					}
				});
				if(($('#kssj').val() != '' && $('#jssj').val() != '')){
					if(fnbeginOverEnd($('#kssj').val(),$('#jssj').val(),'出生日期止不能小于出生日期起')){
						return false;
					}
				}
				$('#frm').attr('action','/retbirthday').submit();
			});
		});
		
		</script>
	</body>
</html>
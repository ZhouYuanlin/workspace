<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/activityDistribution'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/activityReleas">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/activityReleas">
							活动车辆分配</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/activityReleas">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<!-- a href="javascript:;;" class="btn blue" onclick="doCreate()"><i class="fa fa-plus"></i> 新增</a> 
                    <a href="javascript:;;" class="btn blue" onclick="doEdit()"><i class="fa fa-pencil-square-o"></i> 修改</a>
					<a href="javascript:;;" class="btn blue" onclick="doDel()"><i class="fa fa-times"></i> 删除</a-->
					<jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
                </div>
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
															<label class="control-label">活动名称：</label>
															<div class="controls">
																<input type="text" id="activityName" name="activityName" value="${cp.activityName}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">活动地点：</label>
															<div class="controls">
																<input type="text" id="address" name="address" value="${cp.address}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10 wzbtn" onClick="doSearch();"><i class="fa fa-search"></i> 查询</button> 
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
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>活动名称</th>
                                    <th>活动地点</th>
                                    <th>开始时间</th>
                                    <th>结束时间</th>
                                    <th>负责人</th>
                                    <th>联系电话</th>
                                    <th>车辆数量</th>
                                    <th>车辆乘坐人数</th>
                                    <th>报名截止时间</th>
                                    <th>活动介绍</th>
                                    <th>备注</th>
                                    <th>详情</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.activityName}</td>
                                    <td>${item.address}</td>
                                    <td>${item.startTime}</td>
                                    <td>${item.endTime}</td>
                                    <td>${item.person}</td>
                                    <td>${item.tel}</td>
                                    <td>${item.carNumber}</td>
                                    <td>${item.peopleNub}</td>
                                    <td>${item.addEndTime}</td>
                                    <td>${item.introduction}</td>
                                    <td>${item.remarks}</td>
                                    <td><a  href="#showdetail" ref="${item.id}" class="btn default btn-xs black pphdxq" data-toggle="modal">查看</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retireactivity" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<!-- 查看详情 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		  	
		</div>
		<script>
		function doCreate(){
			$('#frm').attr('action','/activityReleas/create').submit();
		}
		//修改
		function doEdit(){
			if(fnupdate()){
				var val = "";
				$('.checkboxes').each(function(){
					if(this.checked)
						val = $(this).val();
				});
				$('#frm').attr('method','post').attr("action","${request.contextPath}/activityDistribution/"+val+"/edit").submit();
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				$('#frm').attr('method','post').attr("action","${request.contextPath}/activityReleas/delete").submit();
			}
		}
		//查询
		function doSearch(){
			$('#frm').attr('action','/activityDistribution').submit();
		}
		
		$(function(){
			$('.pphdxq').click(function(){
				var id = $(this).attr("ref");
				$.post('/activityReleas/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
		});
		</script>
	</body>
</html>
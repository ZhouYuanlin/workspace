<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
</head>
<body>
	<form id="frm"
		action="<c:url value='${request.contextPath}/meetingApply'/>"
		class="form-horizontal" method="post">
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="/retinfo"> 首页 </a> <i
								class="fa fa-angle-right"></i></li>
							<li><a href="/meetingApply"> 会议室记录申请管理 </a> <i
								class="fa fa-angle-right"></i></li>
							<li><a href="/meetingApply"> 列表信息</a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 clearfix">
						<div class="operation-btn pull-right">
						<!-- <a href="javascript:;;" class="btn blue" onclick="doCreate()"><i
								class="fa fa-plus"></i> 申请</a> <a href="javascript:;;"
								class="btn blue" onclick="doAudit()"><i
								class="fa fa-pencil-square-o"></i> 审核</a> -->
						 <jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col- md-12 clearfix">
						<div class="operation-btn pull-right"></div>
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
												<label class="control-label">主题：</label>
												<div class="controls">
													<input type="text" id="title" name="title"
														value="${meeting.title}" class="form-control col-md-12" />
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">申请人：</label>
												<div class="controls">
													<input type="text" id="applicantName" name="applicantName"
														value="${meeting.applicantName}" class="form-control col-md-12" />
												</div>
											</div>
										</div>
									</div>

								</div>
								<div class="form-actions fluid">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-offset-5">
												<button type="button" class="btn blue mgr10 wzbtn" onClick="doSearch();"><i class="fa fa-search"></i> 查询</button> 
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
						<table
							class="table table-striped table-bordered table-condensed table-advance table-hover">
							<thead>
								<tr>
									<th width="45">序号</th>
									<th class="table-checkbox" width="45"><input
										type="checkbox" id="checkbox" onClick="checkAll(this)"
										class="group-checkable" /></th>
									<th>会议室名称</th>
									<th>会议主题</th>
									<th>参会人数</th>
									<th>申请人</th>
									<th>审核状态</th>
									<th>申请使用日期</th>
									<th>申请使用开始时间</th>
									<th>申请使用结束时间</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="item" varStatus="c">
									<tr class="odd gradeX">
										<td>${c.index + 1}</td>
										<td><input type="checkbox" id="id" name="id"
											class="checkboxes" value="${item.id}" /></td>
										<td>${item.meetingRoom.name}</td>
										<td>${item.title}</td>
										<td>${item.attendNum}</td>
										<td>${item.applicantName}</td>
										<c:if test="${item.status==0}">
											<td>待审核</td>
										</c:if>
										<c:if test="${item.status==1}">
											<td><font size="2" color="blue">审核通过</font></td>
										</c:if>
										<c:if test="${item.status==2}">
											<td><font size="2" color="red">审核不通过</font></td>
										</c:if>
										<td>${item.useTime}</td>
										<td>${item.startTime}</td>
										<td>${item.endTime}</td>
									</tr>
								</c:forEach>
								<c:if test="${empty list}">
									<tr>
										<td colspan="14">没有数据！</td>
									</tr>
								</c:if>
							</tbody>
						</table>

						<div class="pagination pull-right">
							<s:pagination page="${paginate.page}" namespace="/"
								controller="retinfo" includeParams="false" formWay="true"
								formId="frm" styleClass="pages fl_r" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script>
		$(document)
				.ready(
						function() {
							$('#xm')
									.typeahead(
											{
												source : function(query,
														process) {
													return $
															.post(
																	'${request.contextPath}/meetingApply/autoCompleteUser',
																	{
																		query : query
																	},
																	function(
																			data) {
																		return process(data);
																	});
												},
												param : '#xm',
												id : 1,
												cusReq : selUser,
												view : 3
											});
						});
		//查询到用户放入姓名框中
		function selUser(id) {
			var tid = id.split('-')[1];
			$("#xm").val(tid);
		}
		//申请
		function doCreate() {
			$('#frm').attr('action','${request.contextPath}/meetingApply/create').submit();
		}
		//审核
		function doAudit() {
			if (fnupdate()) {
				var val = "";
				$('.checkboxes').each(function() {
					if (this.checked)
						val = $(this).val();
				});
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/meetingApply/" + val
						+ "/audit";
				frm.submit();
			}
		}
		//修改
		function doEdit() {
			if (fnupdate()) {
				var val = "";
				$('.checkboxes').each(function() {
					if (this.checked)
						val = $(this).val();
				});
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/meetingApply/" + val
						+ "/edit";
				frm.submit();
			}
		}
		//查询
		function doSearch(){
			var k = true;
			if(k)
				$('#frm').attr('action','/meetingApply').submit();
			else 
				return false;
		}
		//删除
		function doDel() {
			if (fnremove()) {
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/meetingApply/delete";
				frm.submit();
			}
		}
	</script>
</body>
</html>
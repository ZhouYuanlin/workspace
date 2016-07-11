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
		action="<c:url value='${request.contextPath}/meetingRoom'/>"
		class="form-horizontal" method="post">
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="/retinfo"> 首页 </a> <i
								class="fa fa-angle-right"></i></li>
							<li><a href="/meetingRoom/getList"> 会议室管理 </a> <i
								class="fa fa-angle-right"></i></li>
							<li><a href="/meetingRoom/getList"> 列表信息</a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 clearfix">
						<div class="operation-btn pull-right">
							<a href="javascript:;;" class="btn blue" onclick="doCreate()"><i
								class="fa fa-plus"></i> 增加</a> <a href="javascript:;;"
								class="btn blue" onclick="doEdit()"><i
								class="fa fa-pencil-square-o"></i> 修改</a> 
								<a href="javascript:;;"class="btn blue" onclick="doDel()"><i class="fa fa-times"></i>删除</a>
							<%-- <jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
					<jsp:include page="../../_method.jsp"/> --%>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 clearfix">
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
												<label class="control-label">会议室名称：</label>
												<div class="controls">
													<input type="text" id="name" name="name"
														value="${meeting.name}" class="form-control col-md-12" />
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">地址：</label>
												<div class="controls">
													<input type="text" id="address" name="address"
														value="${meeting.address}" class="form-control col-md-12" />
												</div>
											</div>
										</div>
									</div>

								</div>
								<div class="form-actions fluid">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-offset-5">
												<button type="submit" class="btn blue mgr10"
													onclick="return verify()">
													<i class="fa fa-search"></i> 查询
												</button>
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
									<th>可用设备</th>
									<th>地址</th>
									<th>面积</th>
									<th>最大使用人数</th>
									<th>描述</th>
									<th>是否占用</th>
									 <th>会议室详情</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="item" varStatus="c">
									<tr class="odd gradeX">
										<td>${c.index + 1}</td>
										<td><input type="checkbox" id="id" name="id"
											class="checkboxes" value="${item.id}" /></td>
										<td>${item.name}</td>
										<td>${item.device}</td>
										<td>${item.address}</td>
										<td>${item.area}</td>
										<td>${item.upperLimit}</td>
										<td>${item.description}</td>
										<c:if test="${item.enableState==1}">
											<td>是</td>
										</c:if>
										<c:if test="${item.enableState==2}">
											<td>否</td>
										</c:if>
										 <td width="150"><a  href="#showdetail" ref="${item.id}" class="btn default btn-xs black pphdxq" data-toggle="modal">查看</a></td>
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
																	'${request.contextPath}/meetingRoom/autoCompleteUser',
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
		function doCreate() {
			$('#frm').attr('action','${request.contextPath}/meetingRoom/create').submit();
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
				frm.action = "${request.contextPath}/meetingRoom/" + val
						+ "/edit";
				frm.submit();
			}
		}
		//删除
		function doDel() {
			if (fnremove()) {
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/meetingRoom/delete";
				frm.submit();
			}
		}
		//查询
		function doSearch() {
			$('#frm').attr('action', '/meetingRoom').submit();
		}
		
		$(function(){
			$('.pphdxq').click(function(){
				var id = $(this).attr("ref");
				$.post('/meetingRoom/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
		});
	</script>
	<!-- 查看详情 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		</div>
</body>
</html>
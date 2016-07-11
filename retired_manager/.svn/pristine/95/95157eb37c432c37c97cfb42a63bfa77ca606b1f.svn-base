<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="${request.contextPath}/defaults/js/bootstrap-typeahead.js"></script>
<html>
<head>
</head>
<body>
	<form id="frm"
		action="<c:url value='${request.contextPath}/assetRecord'/>"
		class="form-horizontal" method="post">
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="/assetRecord"> 首页 </a> <i
								class="fa fa-angle-right"></i></li>
							<li><a href="/assetRecord"> 资产记录管理 </a> <i
								class="fa fa-angle-right"></i></li>
							<li><a href="assetRecord"> 列表信息</a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 clearfix">
						<div class="operation-btn pull-right">
							<!-- <a href="javascript:;;" class="btn blue" onclick="doCreate()"><i
								class="fa fa-plus"></i> 增加</a> <a href="javascript:;;"
								class="btn blue" onclick="doEdit()"><i
								class="fa fa-pencil-square-o"></i> 修改</a> 
								<a href="javascript:;;"class="btn blue" onclick="doDel()"><i class="fa fa-times"></i>删除</a> -->
							<jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
					<jsp:include page="../../_method.jsp"/> 
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
												<label class="control-label">资产编号：</label>
												<div class="controls">
												    <input type="hidden" name="id" id="id"/>	
													<input type="text" id="assetId" name="fushu.assetId"
														value="${asset.fushu.assetId}" class="form-control col-md-12" autocomplete="off" data-provide="typeahead" data-items="4" data-source='data'/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">领用人：</label>
												<div class="controls">
													<input type="text" id="usePerson" name="usePerson"
														value="${asset.usePerson}" class="form-control col-md-12" />
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">领用时间：</label>
												<div class="controls">
													<input type="text" id="useDate" name="useDate"  value="${asset.useDate}"class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
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
									
									<th>资产编号</th>
									<th>资产名称</th>
									<th>型号</th>
									<th>领用人</th>
									<th>领用时间</th>
									<th>领用登记人</th>
									<th>领用登记时间</th>
									<th>归还状态</th>
									<th>归还时间</th>
									<th>归还登记人</th>
									<th>归还登记时间</th>
									<th>记录详情</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="item" varStatus="c">
									<tr class="odd gradeX">
										<td>${c.index + 1}</td>
										<td><input type="checkbox" id="id" name="id"
											class="checkboxes" value="${item.id}" /></td>
								    <td>${item.fushu.assetId}</td>
                                    <td>${item.fushu.assetManage.name}</td>
                                    <td>${item.fushu.assetManage.version}</td>
                                    <td>${item.usePerson}</td>
                                    <td>${item.useDate}</td>
                                    <td>${item.register}</td>
                                    <td>${item.registerDate}</td>
                                    <c:if test="${item.returnState==0}">
											<td>未归还</td>
										</c:if>
										<c:if test="${item.returnState==1}">
											<td><font size="2" color="red">已归还</font></td>
										</c:if>
                                    <td>${item.returnTime}</td>
                                    <td>${item.returnRegister}</td>
                                    <td>${item.returnRegisterTime}</td>
								<td width="80"><a  href="#showdetail" ref="${item.fushu.id}" class="btn default btn-xs black pphdxq" data-toggle="modal">查看</a></td>
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
								controller="assetSub" includeParams="false" formWay="true"
								formId="frm" styleClass="pages fl_r" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script>
	  $(document).ready(function (){
		  	$('#assetId').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/assetRecord/autoCompleteAsset', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#id'
				,id:1
				,cusReq:selAsset
				,view:3
			});
	  });
		  //查询到资产放入右侧下拉框
			function selAsset(id){
			   var tid=id.split('-')[0];
				  var flag=isExistOption("rightop",tid);
				  if(!flag){
					  $("#rightop").append("<option value='"+tid+"'>"+id.split('-')[1]+"</option>")
				  }
			   
			}
		$(function(){
			$('.pphdxq').click(function(){
				var id = $(this).attr("ref");
				$.post('/assetRecord/ajaxdetail?'+new Date().getTime(),{"fid":id},function(d){
					$("#showdetail").html(d);
				});
			});
		});
		
	</script>
	
	<!-- 查看详情 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:900px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		</div>
</body>
</html>
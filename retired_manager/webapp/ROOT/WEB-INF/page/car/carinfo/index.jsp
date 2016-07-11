<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/carInfo'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/carInfo">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/carInfo">
							车辆信息管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/carInfo">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<!-- <a href="javascript:;;" class="btn blue" onclick="doCreate()"><i class="fa fa-plus"></i> 新增</a> 
                    <a href="javascript:;;" class="btn blue" onclick="doEdit()"><i class="fa fa-pencil-square-o"></i> 修改</a>
					<a href="javascript:;;" class="btn blue" onclick="doDel()"><i class="fa fa-times"></i> 删除</a> -->
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
															<label class="control-label">车辆名称及型号：</label>
															<div class="controls">
																<input type="text" id="carName" name="carName" value="${ci.carName}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">车辆类型：</label>
															<div class="controls">
																<select name="carType"  id="carType" class="form-control col-md-12">
										                          		<option value="">----请选择----</option>
												             			<option value="轿车" <c:if test="${ci.carType == '轿车'}">selected</c:if>>轿车</option>
												             			<option value="货车" <c:if test="${ci.carType == '货车'}">selected</c:if>>货车</option>
												             			<option value="客车" <c:if test="${ci.carType == '客车'}">selected</c:if>>客车</option>
												             	</select>															
												             </div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">司机：</label>
															<div class="controls">
																<input type="text" id="carDriver" name="carDriver" value="${ci.carDriver}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">车牌号：</label>
															<div class="controls">
																<input type="text" id="carNumber" name="carNumber" value="${ci.carNumber}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">可坐人数：</label>
															<div class="controls">
																<input type="text" id="peopleNumber" name="peopleNumber" value="${ci.peopleNumber}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">电话：</label>
															<div class="controls">
																<input type="text" id="tel" name="tel" value="${ci.tel}" class="form-control col-md-12"/>
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
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                	<th width="45">序号</th>
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>车辆名称及型号</th>
                                    <th>车辆类型</th>
                                    <th>司机</th>
                                    <th>车牌号</th>
                                    <th>可坐人数</th>
                                    <th>电话</th>
                                    <th>车辆审批人</th>
                                    <th>备注</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.carName}</td>
                                    <td>${item.carType}</td>
                                    <td>${item.carDriver}</td>
                                    <td>${item.carNumber}</td>
                                    <td>${item.peopleNumber}</td>
                                    <td>${item.tel}</td>
                                    <td>${item.account.realname}</td>
                                    <td>${item.explain}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="rethealth" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
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
		$(function(){
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
			$('#sfzh').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/retment/autoCompleteUser', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#sfzh'
				,id:1
				,cusReq:selUserSfzh
				,view:3
			});
			$('.black').click(function(){
				var id = $(this).attr("ref");
				$.post('/rethealth/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
		});
		
		//查询到用户放入姓名框中
		function selUser(id){
		   var tid=id.split('-')[1];
		  $("#xm").val(tid);
		}
		//查询到用户放入身份证框中
		function selUserSfzh(id){
		   var tid=id.split('-')[0];
		  $("#sfzh").val(tid);
		}
		
		
		function doCreate(){
			$('#frm').attr('action','/carInfo/create').submit();
		}
		//修改
		function doEdit(){
			if(fnupdate()){
				var val = "";
				$('.checkboxes').each(function(){
					if(this.checked)
						val = $(this).val();
				});
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/carInfo/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/carInfo/delete";
				frm.submit();
			}
		}
		//查询
		function doSearch(){
			var k = true;
			if(k)
				$('#frm').attr('action','/carInfo').submit();
			else 
				return false;
		}
		</script>
	</body>
</html>
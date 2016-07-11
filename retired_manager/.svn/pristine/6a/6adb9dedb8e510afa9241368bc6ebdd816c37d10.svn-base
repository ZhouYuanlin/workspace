<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
	</head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/assetManage'/>" class="form-horizontal" method="post">
		<input type="hidden" id="xzmob" name="xzmob" value="retment"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/assetManage">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/assetManage">
							资产管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/assetManage">
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
					<jsp:include page="../../_method.jsp"/>
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
															<label class="control-label">资产名称：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="${asset.name}" class="form-control col-md-12" />
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">资产型号：</label>
															<div class="controls">
																<input type="text" id="version" name="version" value="${asset.version}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
															<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">采购日期：</label>
															<div class="controls">
																<input type="text" id="purchaseDate" name="purchaseDate"  value="${asset.purchaseDate}"class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												</div>
												<%-- <jsp:include page="_selectzjb.jsp"/>
												<jsp:include page="_selectzwb.jsp"/>
												<jsp:include page="_selectdwb.jsp"/> --%>
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
                                    <th>资产名称</th>
                                    <th>型号</th>
                                    <th>类型</th>
                                    <th>单价</th>
                                    <th>数量</th>
                                    <th>采购日期</th>
                                    <th>质保期</th>
                                    <!-- <th>来源</th> -->
                                     <th>资产详情</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.name}</td>
                                    <td>${item.version}</td>
                                    <td>${item.ca.name}</td>
                                    <td>${item.unitPrice}</td>
                                    <td>${item.aNum}</td>
                                    <td>${item.purchaseDate}</td>
                                    <td>${item.shelfLife}</td>
                                  <%--   <td>${item.codeAs.name}</td> --%>
                                     <td width="200"><a  href="#showdetail" ref="${item.id}" class="btn default btn-xs black" data-toggle="modal">查看</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
                                    
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retment" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div> 
              		</div>
				</div>
			</div>
		</div>
		</form>
		<script>
		 $(document).ready(function (){
			$('#name').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/assetManage/autoCompleteUser', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#name'
				,id:1
				,cusReq:selUser
				,view:3
			});
			$('#id').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/assetManage/autoCompleteUser', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#id'
				,id:1
				,cusReq:selUserSfzh
				,view:3
			});
			$('.wzbtn').click(function(){
				$('#frm').attr('action','/assetManage').submit();
			});
		});
		//查询到用户放入姓名框中
		function selUser(id){
		   var tid=id.split('-')[1];
		  $("#name").val(tid);
		}
		//查询到用户放入身份证框中
		function selUserSfzh(id){
		   var tid=id.split('-')[0];
		  $("#version").val(tid);
		}
		function doCreate(){
			$('#frm').attr("method","post").attr('action','/assetManage/create').submit();
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
				frm.action = "${request.contextPath}/assetManage/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/assetManage/delete";
				frm.submit();
			}
		}
		//查看详情
		$(function(){
			$('.black').click(function(){
				var id = $(this).attr("ref");
				$.post('/assetManage/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
		});
		
		//查询
		function doSearch(){
			$('#frm').attr('action','/assetMange').submit();
		}
		</script>
			<!-- 查看详情 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		</div>
	</body>
</html>
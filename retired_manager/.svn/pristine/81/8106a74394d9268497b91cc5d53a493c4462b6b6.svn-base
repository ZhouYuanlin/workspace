<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/account'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/account">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/account">
							用户管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/account">
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
					<a href="javascript:;;" class="btn blue" onclick="doDel()"><i class="fa fa-times"></i> 删除</a>					
					<a href="javascript:;;" class="btn blue" onclick="doReset()"><i class="fa fa-repeat"></i> 重置密码</a-->
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
															<label class="control-label">账号：</label>
															<div class="controls">
																<input type="text" id="sfzh" name="sfzh" value="${acc.sfzh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">姓名：</label>
															<div class="controls">
																<input type="text" id="xm" name="xm" value="${acc.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<%--div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">角色：</label>
															<div class="controls">
																<select name="roleId"  id="roleId" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${roles}" var="item">
												             			<option value="${item.id}" <c:if test="${roleId == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div--%>
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
                                    <th>账号</th>
                                    <th>姓名</th>
                                    <th>所在部门</th>
                                    <th>拥有的角色</th>
                                    <th>联系电话</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.sfzh}"/></td>
                                    <td>${item.sfzh}</td>
                                    <td>${item.xm}</td>
                                	<td>${item.codedwb.name}</td>
                                    <td>${item.role}</td>
                                    <td>${item.lxdh}</td>
                                    <td width="150"><a href="/account/${item.sfzh}/edit" class="btn default btn-xs black" id="showtoast">编辑</a> <a href="javascript:if(confirm('您确定要删除吗？'))location.href='/account/delete?id=${item.sfzh}'" class="btn default btn-xs black">删除</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="6">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<ul class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="account" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</ul>
              		</div>
				</div>
			</div>
			<!-- 自由导出 -->
			<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
			</div>
		</div>
		</form> 
		<script>
		function doCreate(){
			$('#frm').attr('action','/account/create').submit();
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
				frm.action = "${request.contextPath}/account/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/account/delete";
				frm.submit();
			}
		}
		//查询
		function doSearch(){
			var frm = document.getElementById('frm');
			frm.action = "${request.contextPath}/account";
			frm.submit();
		}
		//导入
		function doExcel(){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/account/doExcel";
				frm.submit();
			
		}
		//自由导出
		function doExport(){
	        
	        $.post('${request.contextPath}/account/ajaxUserExport',function(d){
				$("#showdetail").html(d);
			});
		}
		//下载
		function doDown(){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/account/downExcel";
				frm.submit();
		}
		//重置密码
		function doReset(){
			if(fnupdate()){
				var vals = "" ;
				$('.checkboxes').each(function(){
					if(this.checked)
						vals = $(this).val() ;
					});
				window.location.href = "${request.contextPath}/account/"+vals+"/resetPassword";
			}
		}
		</script>
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retirenotice'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retirenotice">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retirenotice">
							通知公告 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retirenotice">
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
															<label class="control-label">标题：</label>
															<div class="controls">
																<input type="text" id="title" name="title" value="${n.title}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">来源：</label>
															<div class="controls">
																<select name="dwbs"  id="dwbs" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${dwblist}" var="item">
												             			<c:if test="${!empty item && item.sfejdw=='否'}">
													             			<option value="${item.id}" <c:if test="${fn:contains(n.dwbs,item.id)}">selected</c:if>>${item.name}</option>
												             			</c:if>
												             		</c:forEach>
												             	</select>
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
                                    <th>标题</th>
                                    <th>发布时间</th>
                                    <th>发布人</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><c:if test="${user == item.fbz}"><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></c:if></td>
                                    <td title="${item.title}"><a href="#showdetail" ref="${item.id}" class="black" data-toggle="modal"><s:substring length="60" value="${item.title}"/></a></td>
                                    <td><fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd"/></td>
                                    <td>${item.fbz}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retirenotice" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
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
			$('.black').click(function(){
				var id = $(this).attr("ref");
				$.post('/retirenotice/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
		});
		function doCreate(){
			$('#frm').attr('action','/retirenotice/create').submit();
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
				frm.action = "${request.contextPath}/retirenotice/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/retirenotice/delete";
				frm.submit();
			}
		}
		//查询
		function doSearch(){
			$('#frm').attr('action','/retirenotice').submit();
		}
		</script>
	</body>
</html>
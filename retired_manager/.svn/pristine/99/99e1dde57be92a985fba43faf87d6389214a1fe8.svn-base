<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/rethoscard'/>" class="form-horizontal" method="post">
		<input type="hidden" id="xzmob" name="xzmob" value="rethoscard"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/rethoscard">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/rethoscard">
							医保卡 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/rethoscard">
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
															<label class="control-label">姓名：</label>
															<div class="controls">
																<input type="text" id="xm" name="ret.xm" value="${w.ret.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<input type="text" id="sfzh" name="ret.sfzh" value="${w.ret.sfzh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<%-- <div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<select name="ret.dwb.id"  id="ret.dwb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${dwblist}" var="item">
												             			<option value="${item.id}" <c:if test="${w.ret.dwb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
													--%>
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
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>身份证号</th>
                                    <th>是否发放</th>
                                    <th>发放日期</th>
                                    <th>就近医院一</th>
                                    <th>修改日期</th>
                                    <th>就近医院二</th>
                                    <th>修改日期</th>
                                    <th>就近医院三</th>
                                    <th>修改日期</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.ret.xm}</td>
                                    <td>${item.ret.xb}</td>
                                    <td>${item.ret.sfzh}</td>
                                    <td>${item.sfff}</td>
                                    <td>${item.fyrq}</td>
                                    <td>${item.jjyyo}</td>
                                    <td><fmt:formatDate value="${item.xgrqo}" pattern="yyyy-MM-dd"/></td>
                                    <td>${item.jjyyt}</td>
                                    <td><fmt:formatDate value="${item.xgrqt}" pattern="yyyy-MM-dd"/></td>
                                    <td>${item.jjyyh}</td>
                                    <td><fmt:formatDate value="${item.xgrqh}" pattern="yyyy-MM-dd"/></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="rethoscard" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
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
				$.post('/rethoscard/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
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
			$('#frm').attr('action','/rethoscard/create').submit();
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
				frm.action = "${request.contextPath}/rethoscard/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/rethoscard/delete";
				frm.submit();
			}
		}
		//查询
		function doSearch(){
			$('#frm').attr('action','/rethoscard').submit();
		}
		//导出
		function doXiazai(){
			$('#frm').attr('action','/rethoscard/export').submit();
		}
		</script>
	</body>
</html>
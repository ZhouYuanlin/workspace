<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retparty'/>" class="form-horizontal" method="post">
		<input type="hidden" id="xzmob" name="xzmob" value="retparty"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retparty">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retparty">
							党支部管理</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retparty">
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
															<label class="control-label">党支部名称：</label>
															<div class="controls">
																<input type="text" id="dzbmc" name="dzbmc" value="${p.dzbmc}" class="form-control col-md-12"/>
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
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>党支部名称</th>
                                   <!--  <th>类型</th>
                                    <th>单位</th> -->
                                    <th>党支部书记</th>
                                    <th>党支部副书记</th>
                                    <th>支委</th>
                                    <th>联络员</th>
                                    <th>联系电话</th>
                                    <th>党员人数</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.dzbmc}</td>
                                    <%-- <td>${item.lxb.name}</td>
                                    <td title="${item.dwb.name}"><s:substring length="8" value="${item.dwb.name}"/></td> --%>
                                    <td title="<c:forEach items='${infolist}' var='chi'><c:if test='${chi[0] == item.dzbsj}'>${chi[1]}</c:if></c:forEach>">${item.dzbsj}</td>
                                    <td title="<c:forEach items='${infolist}' var='chi'><c:if test='${chi[0] == item.dzbfsj}'>${chi[1]}</c:if></c:forEach>">${item.dzbfsj}</td>
                                    <td title="<c:forEach items='${item.zws}' var='chi' varStatus='s'>${chi.xm}-${chi.lxdh}<c:if test='${!s.last}'>;</c:if></c:forEach>"><c:forEach items="${item.zws}" var="chi" varStatus="s">${chi.xm}<c:if test="${!s.last}">;</c:if></c:forEach></td>
                                    <td>${item.zblny}</td>
                                    <td>${item.lxdh}</td>
                                    <td><a href="#showdetail" ref="${item.id}" class="btn default btn-xs black" data-toggle="modal">${fn:length(item.ments)}</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retparty" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
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
				$.post('/retparty/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
			//查询
			$('.wzbtn').click(function(){
				$('#frm').attr('action','/retparty').submit();
			});
		});
		function doCreate(){
			$('#frm').attr('action','/retparty/create').submit();
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
				frm.action = "${request.contextPath}/retparty/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/retparty/delete";
				frm.submit();
			}
		}
		//导出
		function doXiazai(){
			$('#frm').attr('action','/retparty/export').submit();
		}
		
		</script>
	</body>
</html>
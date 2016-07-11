<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retsalute'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retsalute">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retsalute">
							慰问服务</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retsalute">
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
															<label class="control-label">慰问对象：</label>
															<div class="controls">
																<input type="text" id="rets" name="rets" value="${r.rets}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">看望人员：</label>
															<div class="controls">
																<input type="text" id="kwry" name="kwry" value="${r.kwry}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">慰问类型：</label>
															<div class="controls">
																<select id="wwlx" name="wwlx" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<c:forEach items="${wwlxlist}" var="item">
																		<option value="${item.name}" <c:if test="${r.wwlx == item.name}">selected</c:if>>${item.name}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">慰问日期(起)：</label>
															<div class="controls">
																<input type="text" id="ksj" name="ksj" value="${ksj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">慰问日期(止)：</label>
															<div class="controls">
																<input type="text" id="jsj" name="jsj" value="${jsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" class="btn blue mgr10 wzbtn"><i class="fa fa-search"></i> 查询</button> 
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
                                    <th>慰问时间</th>
                                    <th>慰问类型</th>
                                    <th>慰问对象</th>
                                    <th>慰问地点</th>
                                    <th>慰问标准</th>
                                    <th>看望人员</th>
                                    <th>状态</th>
                                    <th>详情</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.wwsj}</td>
                                    <td>${item.wwlx}</td>
                                    <td title="${item.rets}"><s:substring length="30" value="${item.rets}"/></td>
                                    <td>${item.wwdd}</td>
                                    <td>${item.wwp}</td>
                                    <td>${item.kwry}</td>
                                    <td><c:if test="${item.zxzt == '已执行' || item.zxzt == '取消'}">${item.zxzt}</c:if><c:if test="${item.zxzt == '未执行'}"><a href="javascript:;;" class="executerule" ref="${item.id}#已执行">执行</a>|<a href="javascript:;;" class="executerule" ref="${item.id}#取消">取消</a></c:if></td>
                                    <td><a href="#showdetail" ref="${item.id}" class="btn default btn-xs black" data-toggle="modal">详情</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retsalute" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:100px;">
		  
		</div>
		<script>
		$(function(){
			$('.executerule').click(function(){
				var v = $(this).attr("ref");
				if(confirm("您确定要"+(v.split("#")[1] == "已执行" ? "执行?" : "取消?"))){
					$("#frm").attr("method","post");
					$("#frm").attr("action","${request.contextPath}/retsalute/"+v.split("#")[0]+"/"+v.split("#")[1]+"/backinfo").submit();
				}
			});
			$('.black').click(function(){
				var id = $(this).attr("ref");
				$.post('/retsalute/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
			$('.wzbtn').click(function(){
				if(($('#ksj').val() != '' && $('#jsj').val() != '')){
					if(fnbeginOverEnd($('#ksj').val(),$('#jsj').val(),'慰问日期止不能小于慰问日期起')){
						return false;
					}
				}
				$('#frm').attr('action','/retsalute').submit();
			});
		});
		function doCreate(){
			$('#frm').attr('action','/retsalute/create').submit();
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
				frm.action = "${request.contextPath}/retsalute/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/retsalute/delete";
				frm.submit();
			}
		}
		</script>
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retirepartywork'/>" class="form-horizontal" method="post">
		<input type="hidden" id="xzmob" name="xzmob" value="retpartywork"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retirepartywork">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retirepartywork">
							党建工作</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retirepartywork">
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
															<label class="control-label">日期(起)：</label>
															<div class="controls">
																<input type="text" id="kssj" name="kssj" value="${kssj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">日期(止)：</label>
															<div class="controls">
																<input type="text" id="jssj" name="jssj" value="${jssj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">标题：</label>
															<div class="controls">
																<input type="text" id="title" name="title" value="${p.title}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
	                                                        <div class="form-group">
																<label class="control-label">所在党支部：</label>
																<div class="controls">
																	<select name="retireparty.dzbmc"  id="retireparty.dzbmc" class="form-control col-md-12">
											                            <option value="">----请选择----</option>
													             		<c:forEach items="${party}" var="item">
													             			<option value="${item.dzbmc}" <c:if test="${p.retireparty.dzbmc == item.dzbmc}">selected</c:if>>${item.dzbmc}</option>
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
                                    <th>标题</th>
                                    <th>所在党支部</th>
                                    <th>主持人</th>
                                    <th>参与人</th>
                                    <th>联络员</th>
                                    <th>时间</th>
                                    <th>工作内容</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.title}</td>
                                    <td>${item.kfdzb}</td>
                                    <td>${item.zcr}</td>
                                    <td>${fn:length(fn:split(item.cfry,';'))}</td>
                                    <td>${item.retireparty.zblny}</td>
                                    <td>${item.kfrq}</td>
                                    <td width="150"><a href="#showdetail" ref="${item.id}" class="btn default btn-xs black" data-toggle="modal">查看</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
                                   
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retirepartywork" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
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
				$.post('/retirepartywork/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
			$('.wzbtn').click(function(){
				if(($('#kssj').val() != '' && $('#jssj').val() != '')){
					if(fnbeginOverEnd($('#kssj').val(),$('#jssj').val(),'日期止不能小于日期起')){
						return false;
					}
				}
				$('#frm').attr('action','/retirepartywork').submit();
			});
		});
		function doCreate(){
			$('#frm').attr('action','/retirepartywork/create').submit();
		}
		//修改
		function doEdit(){
			if(fnupdate()){
				var val = "";
				$('.checkboxes').each(function(){
					if(this.checked)
						val = $(this).val();
				});
				$('#frm').attr('method','post').attr("action","${request.contextPath}/retirepartywork/"+val+"/edit").submit();
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				$('#frm').attr('method','post').attr("action","${request.contextPath}/retirepartywork/delete").submit();
			}
		}
		//导出
		function doXiazai(){
			$('#frm').attr('action','/retirepartywork/export').submit();
		}
		</script>
	</body>
</html>
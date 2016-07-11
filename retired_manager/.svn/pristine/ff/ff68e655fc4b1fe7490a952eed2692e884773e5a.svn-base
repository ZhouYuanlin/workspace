<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
	</head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retireactother'/>" class="form-horizontal" method="post">
		<input type="hidden" id="xzmob" name="xzmob" value="reteactother"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retireactother">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retireactother">
							品牌活动</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retireactother">
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
															<label class="control-label">活动名称：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="${p.name}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
														<div class="col-md-4">
															<div class="form-group">
																<label class="control-label">活动时间(起)：</label>
																<div class="controls">
																	<input type="text" id="hdsjq" name="hdsjq" value="${hdsjq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group">
																<label class="control-label">活动时间(止)：</label>
																<div class="controls">
																	<input type="text" id="hdsjz" name="hdsjz" value="${hdsjz}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
																</div>
															</div>
														</div>
												</div>
												</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10 wzbtn" onClick="return doSearch();"><i class="fa fa-search"></i> 查询</button> 
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
                                    <th>活动名称</th>
                                    <th>活动地点</th>
                                    <th>活动时间</th>
                                    <th>负责人</th>
                                    <th>负责人电话</th>
                                    <th>参与人员</th>
                                    <th>活动详情</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.name}</td>
                                    <td>${item.hddd}</td>
                                    <td>${item.hdsj}~${item.hdsjjz}</td>
                                    <td>${item.fzr}</td>
                                    <td>${item.fzrlxdh}</td>
                                   	<c:if test="${not empty item.cyrys}">
	                                    <td>${fn:length(fn:split(item.cyrys,';'))}</td>
                                   	</c:if>
                                   	<c:if test="${empty item.cyrys}">
	                                    <td>0</td>
                                   	</c:if>
                                    <td width="150"><a  href="#showdetail" ref="${item.id}" class="btn default btn-xs black pphdxq" data-toggle="modal">查看</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="15">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retireactother" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<script>
		$(function(){
			$('.pphdxq').click(function(){
				var id = $(this).attr("ref");
				$.post('/retireactother/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
					$("#showdetail").html(d);
				});
			});
		});
			function doCreate(){
			$('#frm').attr('action','/retireactother/create').submit();
		}
		//修改
		function doEdit(){
			if(fnupdate()){
				var val = "";
				$('.checkboxes').each(function(){
					if(this.checked)
						val = $(this).val();
				});
				$('#frm').attr("method","post").attr("action","${request.contextPath}/retireactother/"+val+"/edit").submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				$('#frm').attr("method","post").attr("action","${request.contextPath}/retireactother/delete").submit();
			}
		}
		//查询
		function doSearch(){
			var blag = true;
			if($('#hdsjq').val() != '' && $('#hdsjz').val() != ''){
				if(fnbeginOverEnd($('#hdsjq').val(),$('#hdsjz').val(),'活动时间止不能小于活动时间起')){
					blag = false;
				}
			}
			if(blag){
				$('#frm').attr('action','/retireactother').submit();
			}else{
				return false;
			}
		}
		//导出
		function doXiazai(){
			$('#frm').attr('action','/retireactother/export').submit();
		}
		</script>
		<!-- 查看详情 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		</div>
	</body>
</html>
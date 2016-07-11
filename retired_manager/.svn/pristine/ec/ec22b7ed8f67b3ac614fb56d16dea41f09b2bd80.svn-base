<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>

	<form id="frm" action="<c:url value='${request.contextPath}/retpartymems'/>" class="form-horizontal" method="post">
	<input type="hidden" id="xzmob" name="xzmob" value="retpartymems"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retpartymems">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retpartymems">
							党员管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retpartymems">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<!-- a href="javascript:;;" class="btn blue" onclick="doExcel()"><i class="fa fa-sign-in"></i> 导入</a>
					<a href="javascript:;;" class="btn blue" onclick="doDown()"><i class="fa fa-download"></i> 下载模板</a>
                	<a href="javascript:;;" class="btn blue" onclick="doExport()"><i class="fa fa-sign-out"></i> 导出党员</a-->
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
																<input type="text" id="xm" name="xm" value="${m.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<select name="dwb.id"  id="dwb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${dwblist}" var="item">
												             			<option value="${item.id}" <c:if test="${m.dwb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">所在党支部：</label>
															<div class="controls">
																<select name="party.id"  id="party.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${zblist}" var="item">
												             			<option value="${item.id}" <c:if test="${m.party.id == item.id}">selected</c:if>>${item.dzbmc}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">入党时间(起)：</label>
															<div class="controls">
																<input type="text" id="kssj" name="kssj" value="${kssj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">入党时间(止)：</label>
															<div class="controls">
																<input type="text" id="jssj" name="jssj" value="${jssj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">党龄范围：</label>
															<div class="controls">
																<input type="hidden" name="parAges" class="range_slide" 
																value='<c:choose>
																	<c:when test="${empty parAges}">0,100</c:when>
																	<c:otherwise>${parAges}</c:otherwise>
																</c:choose>' /> 
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10" onclick="return verify()"><i class="fa fa-search"></i> 查询</button> 
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
                                    <th>民族</th>
                                    <th>政治面貌</th>
                                    <th>原工作单位</th>
                                    <th>入党时间</th>
                                    <th>党支部</th>
                                    <th>党员档案</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                	<td><input type="checkbox" id="sfzh" name="sfzh" class="checkboxes" value="${item.sfzh}"/></td>
                                    <td>${item.xm}</td>
                                    <td>${item.xb}</td>
                                	<td><a href="/retment/${item.sfzh}/detail">${item.sfzh}</a></td>
                                    <td>${item.mzb.name}</td>
                                    <td>${item.zzmm.name}</td>
                                    <td>${item.dwb.name}</td>
                                    <td>${item.rdsj}</td>
                                    <td>${item.party.dzbmc}</td>
                                    <td width="150"><a href="#showdetail" ref="${item.sfzh}" class="btn default btn-xs black" data-toggle="modal">查看</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
                                  
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retpartymems" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
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
	$(document).ready(function (){
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
	});

//查询到用户放入姓名框中
	function selUser(id){
	   var tid=id.split('-')[1];
	  $("#xm").val(tid);
	}
	//查询
	function verify(){
		if(($('#kssj').val() != '' && $('#jssj').val() != '')){
			if(fnbeginOverEnd($('#kssj').val(),$('#jssj').val(),'入党时间止不能小于入党时间起')){
				return false;
			}
		}
	}	
		$(function(){
			 $(".range_slide").jRange({ 
					from: 0, 
					to: 100, 
					step: 1, 
					scale: [0,20,40,60,80,100], 
					format: '%s', 
					showLabels: true, 
					showScale: true,
					theme:'theme-blue',
				});
			$('.black').click(function(){
				var sfzh = $(this).attr("ref");
				$.post('/retpartymems/ajaxdetail?'+new Date().getTime(),{"sfzh":sfzh},function(d){
					$("#showdetail").html(d);
				});
			});
			
			});
		
		//增加
		function doCreate(){
			$('#frm').attr('action','/retpartymems/create').submit();
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
				frm.action = "${request.contextPath}/retpartymems/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			$('#frm').attr('action','/retpartymems/delete').submit();
		}
		//导出
		function doExport(){
			$('#frm').attr("method","post").attr("action","/retpartymems/doExport").submit();
		}
		//导入
		function doExcel(){
			$('#frm').attr('action','/retpartymems/importexecl').submit();
		}
		
		</script>s	
</body>
	
</html>
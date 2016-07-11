<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
	</head>
	
	<body><!--  enctype="multipart/form-data" -->
	<form id="frm" action="<c:url value='${request.contextPath}/retwages'/>" class="form-horizontal" method="post">
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
							工资管理</a>
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
												<label class="control-label">姓名：</label>
												<div class="controls">
													<input type="text" id="rets" name="xm" value="${r.xm}" class="form-control col-md-12"/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">发放月份(起)：</label>
												<div class="controls">
													<input type="text" name="yf" id="yf" value="${r.yf}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm" size="16" readonly/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">发放月份(止)：</label>
												<div class="controls">
													<input type="text" id="ttgzygZ" name="ttgzygZ" value="${ttgzygZ}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm" size="16" readonly/>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">身份证号：</label>
												<div class="controls">
													<input type="text" id="sfzh" name="sfzh" value="${r.sfzh}" class="form-control col-md-12"/>
												</div>
											</div>
										</div>
										<%-- <div class="col-md-4">
											<div class="form-group">
												<label class="control-label">津补贴放月份(起)：</label>
												<div class="controls">
													<input type="text" name="bjjbt.ffyf" id="bjjbtffyf" value="${r.bjjbt.ffyf}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm" size="16" readonly/>
												</div>
											</div>
										</div> --%>
										<%-- <div class="col-md-4">
											<div class="form-group">
												<label class="control-label">津补贴放月份(止)：</label>
												<div class="controls">
													<input type="text" id="jbtyfZ" name="jbtyfZ" value="${jbtyfZ }" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm" size="16" readonly/>
												</div>
											</div>
										</div> --%>
									</div>
								</div>
								<div class="form-actions fluid">
										<div class="row">
											<div class="col-md-12">
												<div class="col-md-offset-5">
													<button type="button" onclick="isMatching()" class="btn blue mgr10">
														<i class="fa fa-search"></i> 
														查询
													</button> 
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
                                    <th>姓名 </th>
                                    <th>发放月份</th>
                                    <th>财统工资(元)</th>
                                    <th>本级津补贴(元)</th>
                                    <th>更多的操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listwages}" var="item" varStatus="c">
	                                <tr class="odd gradeX">
	                                	<td>${c.index + 1}</td>
	                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
	                                    <td>${item.xm}</td>
	                                    <td>${item.yf}</td>
	                                    <td>${item.sfxj}</td>
	                                    <td>${item.bjjbt.sfgz}</td>
	                                    <td>
	                                    	<a href="#showdetailAjax" ref="${item.id}" class="btn default btn-xs black" onclick="InformationDetails(${item.id})" data-toggle="modal">详情</a>
	                                    </td>
	                                </tr>
                                </c:forEach>
                                <c:if test="${empty listwages}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retwages" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
			<!-- 自由导出 -->
			<div class="modal fade" id="showdetailAjax" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:150px;">
			</div>
		</div>
		</form>
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:100px;">
		  
		</div>
		<script>
		 $(document).ready(function (){
				$('#rets').typeahead({
			    	source: function (query, process) {
				        return $.post('${request.contextPath}/retment/autoCompleteUser', 
				        { query:query}, 
				        function (data) {
				            return process(data);
				        });
				    }
					,param:'#rets'
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
		 	});
			//查询到用户放入姓名框中
			function selUser(id){
			   var tid=id.split('-')[1];
			  $("#rets").val(tid);
			}
			//查询到用户放入身份证框中
			function selUserSfzh(id){
			   var tid=id.split('-')[0];
			  $("#sfzh").val(tid);
			}
			
			function doCreate(){//添加
				$('#frm').attr("method","post").attr('action','/retwages/create').submit();
			}
			function doUpdate(){//修改
				if(fnupdate()){
					$('#frm').attr("method","post").attr('action','/retwages/update').submit();
				}
			}
			
			function InformationDetails(id)//查询详情
			{
				$.post('${request.contextPath}/retwages/ajaxRetiWagesDetails?id='+id,function(d){
					$("#showdetailAjax").html(d);
				});
			}
			
			function dosPecialUpdate(id)
			{
				$('#frm').attr("method","post").attr('action','/retwages/update?id='+id).submit();
			}
			
			function isMatching(){//模糊匹配
				
				if(($('#yf').val() != '' && $('#ttgzygZ').val() != '')){
					if(fnbeginOverEnd($('#yf').val(),$('#ttgzygZ').val(),'工资发放月份止不能小于工资发放月份起')){
						return false;
					}
				}
				/* if(($('#bjjbtffyf').val() != '' && $('#jbtyfZ').val() != '')){
					alert($('#bjjbtffyf').val());
					if(fnbeginOverEnd($('#bjjbtffyf').val(),$('#jbtyfZ').val(),'津补贴发放月份止不能小于津补贴发放月份起')){
						return false;
					}
				} */
				$('#frm').attr('action','/retwages').submit();
			}
			
			//删除
			function doDel(){
				if(fnremove()){
					var frm = document.getElementById('frm');
					frm.action = "${request.contextPath}/retwages/delete";
					frm.submit();
				}
			}
			
			function doExcel(){//导入
				$.post('${request.contextPath}/retwages/ajaxRetiWagesImport',function(d){
					$("#showdetailAjax").html(d);
				});
			}
			function doXiazai(){
				$.post('${request.contextPath}/retwages/ajaxRetiWagesExport',function(d){
					$("#showdetailAjax").html(d);
				});
			}
		</script>
	</body>
</html>
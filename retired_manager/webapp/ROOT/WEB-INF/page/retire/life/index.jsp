<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retlife'/>" class="form-horizontal" method="post">
	<input type="hidden" id="xzmob" name="xzmob" value="retlife"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retlife">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retlife">
							生活服务</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retlife">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                    <!-- a href="javascript:;;" class="btn blue" onclick="doEdit()"><i class="fa fa-pencil-square-o"></i> 修改</a-->
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
																<input type="text" id="xm" name="xm" value="${r.xm}" class="form-control col-md-12"/>
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
												             			<option value="${item.id}" <c:if test="${r.dwb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<select name="lxb.id"  id="lxb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${lxblist}" var="item">
												             			<option value="${item.id}" <c:if test="${r.lxb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">卫生间扶手：</label>
															<div class="controls">
																<select id="wsjfs" name="wsjfs" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<option value="已安装" <c:if test="${r.wsjfs == '已安装'}">selected</c:if>>已安装</option>
																	<option value="未安装" <c:if test="${r.wsjfs == '未安装'}">selected</c:if>>未安装</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">急救一键通：</label>
															<div class="controls">
																<select id="jjyjt" name="jjyjt" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<option value="已安装" <c:if test="${r.jjyjt == '已安装'}">selected</c:if>>已安装</option>
																	<option value="未安装" <c:if test="${r.jjyjt == '未安装'}">selected</c:if>>未安装</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">公共意外险：</label>
															<div class="controls">
																<select id="ggywx" name="ggywx" class="form-control col-md-12">
																	<option value="">--请选择--</option>
																	<option value="已购买" <c:if test="${r.ggywx == '已购买'}">selected</c:if>>已购买</option>
																	<option value="未购买" <c:if test="${r.ggywx == '未购买'}">selected</c:if>>未购买</option>
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
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>原工作单位</th>
                                    <th>级别</th>
                                    <th>类型</th>
                                    <th>卫生间扶手</th>
                                    <th>急救一键通</th>
                                    <th>公共意外保险</th>
                                    <th>在职干部结对</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.sfzh}"/></td>
                                    <td>${item.xm}</td>
                                    <td>${item.xb}</td>
                                    <td>${item.dwb.name}</td>
                                    <td>${item.zjb.name}</td>
                                    <td>${item.lxb.name}</td>
                                    <td><s:substring length="30" value="${item.wsjfs}"/></td>
                                    <td>${item.jjyjt}</td>
                                    <td>${item.ggywx}</td>
                                    <td>${item.zzgbjs}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retlife" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
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
		
		function doCreate(){
			$('#frm').attr('action','/retlife/create').submit();
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
				frm.action = "${request.contextPath}/retlife/"+val+"/edit";
				frm.submit();
			}
		}
		//查询
		function doSearch(){
			$('#frm').attr('action','/retlife').submit();
		}
		//导出
		function doXiazai(){
			$('#frm').attr('action','/retlife/export').submit();
		}
		</script>
	</body>
</html>
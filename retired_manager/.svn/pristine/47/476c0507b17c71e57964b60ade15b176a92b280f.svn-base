<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retiredues'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retiredues">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retiredues">
							党费基数管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retiredues">
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
																<input type="text" id="xm" name="xm" value="${ret.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<select id="xb" name="xb" class="form-control col-md-12">
																	<option value="">----请选择----</option>
																	<option value="男" <c:if test="${ret.xb == '男'}">selected</c:if>>男</option>
																	<option value="女" <c:if test="${ret.xb == '女'}">selected</c:if>>女</option>
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
												             			<option value="${item.id}" <c:if test="${ret.lxb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">民族：</label>
															<div class="controls">
																<select name="mzb.id"  id="mzb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${mzblist}" var="item">
												             			<option value="${item.id}" <c:if test="${ret.mzb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">政治面貌：</label>
															<div class="controls">
																<select name="zzmm.id"  id="zzmm.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${zzmmlist}" var="item">
												             			<option value="${item.id}" <c:if test="${ret.zzmm.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">党支部：</label>
															<div class="controls">
																<select name="party.id"  id="party.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${plist}" var="item">
												             			<option value="${item.id}" <c:if test="${ret.party.id == item.id}">selected</c:if>>${item.dzbmc}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<input type="text" class="form-control col-md-12 showdwb" readonly value="<c:forEach items='${dwblist}' var='item' varStatus='s'><c:if test='${fn:contains(ret.bz,item.id)}'>${item.name}<c:if test='${!s.last}'> </c:if></c:if></c:forEach>"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">职务：</label>
															<div class="controls">
																<input type="text" class="form-control col-md-12 showzwb" readonly value="<c:forEach items='${zwblist}' var='item' varStatus='s'><c:if test='${fn:contains(ret.sfyfz,item.id)}'>${item.name}<c:if test='${!s.last}'> </c:if></c:if></c:forEach>"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">职级：</label>
															<div class="controls">
																<input type="text" class="form-control col-md-12 showzjb" readonly value="<c:forEach items='${zjblist}' var='item' varStatus='s'><c:if test='${fn:contains(ret.qq,item.id)}'>${item.name}<c:if test='${!s.last}'> </c:if></c:if></c:forEach>"/>
															</div>
														</div>
													</div>
												</div>
												<jsp:include page="../../retire/person/_selectzjb.jsp"/>
												<jsp:include page="../../retire/person/_selectzwb.jsp"/>
												<jsp:include page="../../retire/person/_selectdwb.jsp"/>
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
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>出生日期</th>
                                    <th>民族</th>
                                    <th>政治面貌</th>
                                    <th>原工作单位</th>
                                    <th>职务</th>
                                    <th>职级</th>
                                    <th>类型</th>
                                    <th>党支部</th>
                                    <th>联系电话</th>
                                    <th>党费基数</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                	<td><input type="checkbox" id="sfzh" name="sfzh" class="checkboxes" value="${item.sfzh}"/></td>
                                    <td>${item.xm}</td>
                                    <td>${item.xb}</td>
                                    <td>${item.csrq}</td>
                                    <td>${item.mzb.name}</td>
                                    <td>${item.zzmm.name}</td>
                                    <td>${item.dwb.name}</td>
                                    <td>${item.zwb.name}</td>
                                    <td>${item.zjb.name}</td>
                                    <td>${item.lxb.name}</td>
                                    <td>${item.party.dzbmc}</td>
                                    <td>${item.lxdh}</td>
                                    <td>${item.dfjs}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
                                    
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retiredues" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
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
			$('.wzbtn').click(function(){
				$('#frm').attr('action','/retiredues').submit();
			});
		});
		//查询到用户放入姓名框中
		function selUser(id){
		   var tid=id.split('-')[1];
		  $("#xm").val(tid);
		}
		
		function doCreate(){
			$('#frm').attr("method","post").attr('action','/retiredues/create').submit();
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
				frm.action = "${request.contextPath}/retiredues/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			$('#frm').attr('action','/retiredues/delete').submit();
		}
		//导入
		function doExcel(){
			$('#frm').attr('action','/retiredues/import').submit();
		}
		//下载
		function doDown(){
			$('#frm').attr('method','post').attr('action','/retiredues/download').submit();
		}
		function doXiazai(){
			$('#frm').attr('method','post').attr('action','/retiredues/export').submit();
		}
		</script>
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retireworthines'/>" class="form-horizontal" method="post">
		<input type="hidden" id="xzmob" name="xzmob" value="retworthines"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retireworthines">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retireworthines">
							老有所为</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retireworthines">
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
																<input type="text" id="xm" name="ret.xm" value="${p.ret.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">银龄宣讲小组：</label>
															<div class="controls">
																<select name="sfxjxz"  id="sfxjxz" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<option value="是" <c:if test="${p.sfxjxz == '是'}">selected</c:if>>是</option>
												             		<option value="否" <c:if test="${p.sfxjxz == '否'}">selected</c:if>>否</option>
												             	</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<select name="ret.dwb.id"  id="ret.dwb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${dwblist}" var="item">
												             			<option value="${item.id}" <c:if test="${p.ret.dwb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">宣讲日期(起)：</label>
															<div class="controls">
																<input type="text" id="rxq" name="rxq" value="${rxq}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">宣讲日期(止)：</label>
															<div class="controls">
																<input type="text" id="rxz" name="rxz" value="${rxz}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
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
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>类型</th>
                                    <th>原工作单位</th>
                                    <th>银龄宣讲小组</th>
                                    <th>宣讲主题</th>
                                    <th>宣讲时间</th>
                                    <th>宣讲地点</th>
                                    <th>宣讲费用</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.ret.xm}</td>
                                    <td>${item.ret.xb}</td>
                                    <td>${item.ret.lxb.name}</td>
                                    <td>${item.ret.dwb.name}</td>
                                    <td>${item.sfxjxz}</td>
                                    <td title="${item.title}"><s:substring length="15" value="${item.title}"/></td>
                                    <td>${item.xjsj}</td>
                                    <td>${item.xjdd}</td>
                                    <td>${item.xjfy}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="15">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retireworthines" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
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
				if(($('#rxq').val() != '' && $('#rxz').val() != '')){
					if(fnbeginOverEnd($('#rxq').val(),$('#rxz').val(),'宣讲日期止不能小于宣讲日期起')){
						return false;
					}
				}
				$('#frm').attr('action','/retireworthines').submit();
			});
		});
		
		//查询到用户放入姓名框中
		function selUser(id){
		   var tid=id.split('-')[1];
		  $("#xm").val(tid);
		}
		
		
		function doCreate(){
			$('#frm').attr('action','/retireworthines/create').submit();
		}
		//修改
		function doEdit(){
			if(fnupdate()){
				var val = "";
				$('.checkboxes').each(function(){
					if(this.checked)
						val = $(this).val();
				});
				$('#frm').attr("method","post").attr("action","${request.contextPath}/retireworthines/"+val+"/edit").submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				$('#frm').attr("method","post").attr("action","${request.contextPath}/retireworthines/delete").submit();
			}
		}
		//导出
		function doXiazai(){
			$('#frm').attr('action','/retireworthines/export').submit();
		}
		</script>
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
	</head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retwork'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retwork">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retwork">
							工作经历 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retwork">
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
															<label class="control-label">姓名：</label>
															<div class="controls">
																<input type="text" id="xm" name="ret.xm" value="${w.ret.xm}" class="form-control col-md-12" autocomplete="off" data-provide="typeahead" data-items="4" data-source='data'/>
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
													<div class="col-md-4">
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
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">参加工作时间(起)：</label>
															<div class="controls">
																<input type="text" id="gksj" name="gksj" value="${gksj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">参加工作时间(止)：</label>
															<div class="controls">
																<input type="text" id="gjsj" name="gjsj" value="${gjsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">职务：</label>
															<div class="controls">
																<select name="ret.zwb.id"  id="ret.zwb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${zwblist}" var="item">
												             			<option value="${item.id}" <c:if test="${w.ret.zwb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">离退休时间(起)：</label>
															<div class="controls">
																<input type="text" id="lksj" name="lksj" value="${lksj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">离退休时间(止)：</label>
															<div class="controls">
																<input type="text" id="ljsj" name="ljsj" value="${ljsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<select name="ret.lxb.id"  id="ret.lxb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${lxblist}" var="item">
												             			<option value="${item.id}" <c:if test="${w.ret.lxb.id == item.id}">selected</c:if>>${item.name}</option>
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
                                    <th>原工作单位</th>
                                    <th>职务</th>
                                    <th>类型</th>
                                    <th ref="gzsj" refValue="${sort }">
                                    	参加工作时间
                                    </th>
                                    <th ref="lxsj" refValue="${sort }">
                                    	<!-- 
                                    	<input type="hidden" class="lxsjOrder" value="lxsj" ref="asc"/> -->
                                    	离退休时间
                                    </th>
                                    <th>籍贯</th>
                                    <th>工作经历</th>
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
                                    <td>${item.ret.dwb.name}</td>
                                    <td>${item.ret.zwb.name}</td>
                                    <td>${item.ret.lxb.name}</td>
                                    <td>${item.ret.gzsj}</td>
                                    <td>${item.ret.lxsj}</td>
                                    <td>${item.ret.jg}</td>
                                    <td width="150"><a href="#showdetail" ref="${item.ret.sfzh}" class="btn default btn-xs black" data-toggle="modal">查看</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retwork" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
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
			
				
				$('.wzbtn').click(function(){
					 var k = true;
						var l = true;
						if($('#gksj').val() != '' && $('#gjsj').val() != ''){
							if(fnbeginOverEnd($('#gksj').val(),$('#gjsj').val(),'工作结束时间不能小于开始时间')){
								k = false;
							}
						}
						if($('#lksj').val() != '' && $('#ljsj').val() != ''){
							if(fnbeginOverEnd($('#lksj').val(),$('#ljsj').val(),'离退结束时间不能小于开始时间')){
								l = false;
							}
						}
					if(k && l){
						$('#frm').attr('action','/retwork').submit();
					}else{
						return false;
					}
					$('#frm').attr('action','/retwork').submit();
				});
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
		$(function(){
			$('.black').click(function(){
				var sfzh = $(this).attr("ref");
				$.post('/retwork/ajaxdetail?'+new Date().getTime(),{"sfzh":sfzh},function(d){
					$("#showdetail").html(d);
				});
			});
		});
		function doCreate(){
			$('#frm').attr('action','/retwork/create').submit();
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
				frm.action = "${request.contextPath}/retwork/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/retwork/delete";
				frm.submit();
			}
		}
		//查询
		/* function doSearch(){
			var k = true;
			var l = true;
			if($('#gksj').val() != '' && $('#gjsj').val() != ''){
				if(fnbeginOverEnd($('#gksj').val(),$('#gjsj').val(),'工作结束时间不能小于开始时间')){
					k = false;
				}
			}
			if($('#lksj').val() != '' && $('#ljsj').val() != ''){
				if(fnbeginOverEnd($('#lksj').val(),$('#ljsj').val(),'离退结束时间不能小于开始时间')){
					l = false;
				}
			}
			if(k && l){
				$('#frm').attr('action','/retwork').submit();
			}else{
				return false;
			} 
		} */
		//导出
		function doXiazai(){
			$('#frm').attr('action','/retwork/export').submit();
		}
		//导入
		function doExcel(){
			$('#frm').attr('action','/retwork/importexecl').submit();
		}
		//下载
		function doDown(){
			$('#frm').attr('action','/retwork/download').submit();
		}
		</script>
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
	</head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retment'/>" class="form-horizontal" method="post">
		<input type="hidden" id="xzmob" name="xzmob" value="retment"/>
		<input type="hidden" id="advancedSearch" name="advancedSearch"/>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retment">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retment">
							人员管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retment">
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
																<input type="text" id="xm" name="xm" value="${ret.xm}" class="form-control col-md-12" autocomplete="off" data-provide="typeahead" data-items="4" data-source='data'/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<input type="text" id="sfzh" name="sfzh" value="${ret.sfzh}" class="form-control col-md-12"/>
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
												</div>
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<input type="text" class="form-control col-md-12 showdwb" readonly value="<c:forEach items='${dwblist}' var='item' varStatus='s'><c:if test='${fn:contains(ret.bz,item.id)}'>${item.name}<c:if test='${!s.last}'> </c:if></c:if></c:forEach>"/>
															</div>
														</div>
														<!-- -->
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
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">年龄范围：</label>
															<div class="controls">
																<input type="hidden" name="ages" class="range_slide" 
																value='<c:choose>
																	<c:when test="${empty ages}">0,120</c:when>
																	<c:otherwise>${ages}</c:otherwise>
																</c:choose>' /> 
															</div>
														</div>
													</div>
												</div>
												<jsp:include page="_selectzjb.jsp"/>
												<jsp:include page="_selectzwb.jsp"/>
												<jsp:include page="_selectdwb.jsp"/>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-4">
															<button id="wzbtn" class="btn blue mgr10 wzbtn"><i class="fa fa-search"></i>&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;</button> 
															<a href="#advancedpage" data-toggle="modal"><button type="button" id="advanced" class="btn blue mgr10 wzbtn"><i class="fa fa-search"></i>高级查询</button></a> 
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
                                    <th>身份证号</th>
                                    <th>性别</th>
                                    <th>出生日期</th>
                                    <th>民族</th>
                                    <th>政治面貌</th>
                                    <th>原工作单位</th>
                                    <th>职务</th>
                                    <th>职级</th>
                                    <th>类型</th>
                                    <th>籍贯</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.sfzh}"/></td>
                                    <td><a href="/retment/${item.sfzh}/detail">${item.xm}</a></td>
                                    <td>${item.sfzh}</td>
                                    <td>${item.xb}</td>
                                    <td>${item.csrq}</td>
                                    <td>${item.mzb.name}</td>
                                    <td>${item.zzmm.name}</td>
                                    <td title="${item.dwb.name}"><s:substring length="8" value="${item.dwb.name}"/></td>
                                    <td>${item.zwb.name}</td>
                                    <td>${item.zjb.name}</td>
                                    <td>${item.lxb.name}</td>
                                    <td>${item.jg}</td>
                                    <!-- td width="150"><a href="/retment/${item.sfzh}/edit" class="btn default btn-xs black" id="showtoast">编辑</a> <a href="/retment/delete?id=${item.sfzh}" onclick="return confirm('删除后无法恢复,确定要删除吗')" class="btn default btn-xs black">删除</a></td-->
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retment" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
			<!-- 自由导出 -->
			<div class="modal fade" id="showdetailAjax" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:150px;">
			</div>
			
			<!-- 高级查询 -->
			<div class="modal fade modal-custom" id="advancedpage" tabindex="-1" role="testModal" aria-hidden="true" style="width:650px;margin-left:50%;margin-left:-300px;margin-top:100px;padding: 0px 20px 0px 20px;">
			  
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
			$('#wzbtn').click(function(){
				$('#frm').attr('action','/retment').submit();
			});
			$('#advanced').click(function(){
				$('#frm')[0].reset();
				$.post('/retment/advancedSearch?'+new Date().getTime(),function(d){
					$("#advancedpage").html(d);
				});
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
		function doCreate(){
			$('#frm').attr("method","post").attr('action','/retment/create').submit();
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
				frm.action = "${request.contextPath}/retment/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/retment/delete";
				frm.submit();
			}
		}
		//导出
		function doXiazai(){
			$.post('${request.contextPath}/retment/ajaxRetirementExport',function(d){
				//alert(d);
				$("#showdetailAjax").html(d);
			});
			//$('#frm').attr("method","post").attr('action','/retment/export').submit();
		}
		//重置密码
		function doReset(){
			if($.fn.update()){
				var vals = "" ;
				$('.checkboxes').each(function(){
					if(this.checked)
						vals = $(this).val() ;
					});
				window.location.href = "${request.contextPath}/retment/"+vals+"/resetPassword";
			}
		}
		//导入批理
		function doPl(){
			$('#frm').attr('action','/retment/importpl').submit();
		}
		//下载
		function doDownpl(){
			$('#frm').attr('method','post').attr('action','/retment/xiazai').submit();
		}
		
		//高级条件查询
		function searchKeyChange(obj){
		 	var n = $(obj).parent().next().next();
			var html = "";
			<c:forEach items="${zdytjbList}" var="item">
				<c:choose>
					<c:when test="${!fn:contains(item.zdywm,'.')}">
						if($(obj).val()=='jg' || $(obj).val()=='grxl'){
							if($(obj).val()=='jg'){
								html = "<select id='convalue' name='convalue' class='form-control'>";
								<c:forEach items="${sydlist}" var='listitem' varStatus="c">
									html += "<option value='${listitem.name}'>${listitem.name}</option>";
								</c:forEach>
								html += "</select>";
								$(n).html(html);
								return false;
							}
							if($(obj).val()=='grxl'){
								html = "<select id='convalue' name='convalue' class='form-control'>";
								<c:forEach items="${xlblist}" var='listitem' varStatus="c">
									html += "<option value='${listitem.name}'>${listitem.name}</option>";
								</c:forEach>
								html += "</select>";
								$(n).html(html);
								return false;
							}
						}
						if('${item.zdywm}' == $(obj).val() && ${!empty item.textvalue}){
							if(${item.textvalue=='date'}){
								html = "<input type='text' id='convalue' name='convalue' value='' class='form-control' placeholder='格式:yyyy-mm-dd'>";
								$(n).html(html);
								return false;
							}else{
								html = "<select id='convalue' name='convalue' class='form-control'>";
								<c:forTokens items="${item.textvalue}" delims="$" var="tv">
									html += "<option value='${tv}'>${tv}</option>";
								</c:forTokens>
								html += "</select>";
								$(n).html(html);
								return false;
							}
						}else{
							html = "<input type='text' id='convalue' name='convalue' value='' class='form-control' placeholder='请输入条件'>";
							$(n).html(html);
						}
					</c:when>
					<c:when test="${fn:contains(item.zdywm,'.')}">
						if($(obj).val()=="party_id"){
							html = "<select id='convalue' name='convalue' class='form-control'>";
								<c:forEach items="${dzblist}" var='partyItem' varStatus="c">
									html += "<option value='${partyItem.id}'>${partyItem.dzbmc}</option>";
								</c:forEach>
							html += "</select>";
							$(n).html(html);
							return false;
						}
						if("${fn:substringBefore(item.zdywm,'.')}_id" == $(obj).val()){
							html = "<select id='convalue' name='convalue' class='form-control'>";
									<c:set var="selec2" value="${fn:substringBefore(item.zdywm,'.')}list"></c:set>
									<c:forEach items="${requestScope[selec2]}" var='listitem' varStatus="c">
										html += "<option value='${listitem.id}'>${listitem.name}</option>";
									</c:forEach>
							html += "</select>";
							$(n).html(html);
							return false;
						}
					</c:when>
				</c:choose>
			</c:forEach>
		}
		
		//高级查询
		function advanSearch(){
			$("#advanForm").attr('action','/retment').submit();
		}
		</script>
	</body>
</html>
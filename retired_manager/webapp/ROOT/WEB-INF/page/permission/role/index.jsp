<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/role">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/role">
							角色管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/role">
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
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>序号</th>
                                    <th>角色名</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
	                                <tr class="odd gradeX">
	                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
	                                    <td>${c.index + 1}</td>
	                                    <td>${item.name}</td>
	                                    <td width="200">
	                                    	<a href="#showdetail" ref="${item.id}" class="btn default btn-xs black showtoast" data-toggle="modal">查看详情</a>
	                                    	<!-- 
	                                    	<a href="/role/${item.id}/detail" class="btn default btn-xs black" id="showdetail">查看详情</a>
	                                    	 -->
		                                    <a href="/role/${item.id}/edit" class="btn default btn-xs black">编辑</a>
		                                    <a href="javascript:if(confirm('您确定要删除吗？'))location.href='/role/delete?id=${item.id}'" class="btn default btn-xs black">删除</a>
	                                    </td>
	                                </tr>
                                </c:forEach>
                                </tbody>
                                </table> 
							<ul class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="role" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</ul>
              		</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		</div>
		</form>
		
		<script>
			function doCreate(){
				$('#frm').attr("action","/role/create").submit();
			}
			function doSq(){
				$("#frm").attr("method","post").attr("action","${request.contextPath}/role/console").submit();
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
					frm.action = "${request.contextPath}/role/"+val+"/edit";
					frm.submit();
				}
			}
			//删除
			function doDel(){
				if(fnremove()){
					var frm = document.getElementById('frm');
					frm.action = "${request.contextPath}/role/delete";
					frm.submit();
				}
			}
			//查询
			function doSearch(){
				var frm = document.getElementById('frm');
				frm.action = "/role";
				frm.submit();
				
			}
			function doSq(){
				window.location.href = "${request.contextPath}/role/console";
			}
			/*
			查看详情
			*/
			$(function(){
				$('.showtoast').click(function(){
					var id = $(this).attr("ref");
					$.post('${request.contextPath}/role/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
						$("#showdetail").html(d);
					});
				});
			});
		</script>
	</body>
</html>
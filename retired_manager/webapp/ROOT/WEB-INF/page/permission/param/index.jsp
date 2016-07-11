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
							<a href="/retparam">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retparam">
							参数管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retparam">
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
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                	<th width="45">序号</th>
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>参数名</th>
                                    <th>参数值</th>
                                    <th>说明</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.name}</td>
                                    <td>${item.pvalue}</td>
                                    <td title="${item.bz}">${item.bz}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}">
                                	<tr><td colspan="4">没有数据</td></tr>
                                </c:if>
                                </tbody>
                                </table> 
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retparam" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form> 
		<script>
			function doCreate(){
				$('#frm').attr("action","/retparam/create").submit();
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
					frm.action = "${request.contextPath}/retparam/"+val+"/edit";
					frm.submit();
				}
			}
			//删除
			function doDel(){
				if(fnremove()){
					var frm = document.getElementById('frm');
					frm.action = "${request.contextPath}/retparam/delete";
					frm.submit();
				}
			}
			//查询
			function doSearch(){
				var frm = document.getElementById('frm');
				frm.action = "/retparam";
				frm.submit();
				
			}
		</script>
	</body>
</html>
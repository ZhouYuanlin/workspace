<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>账号首页</title>
<script type="text/javascript">
$(function(){
	var $editPass = $("#editPass");
	$editPass.click(function(){
		var nodes = $.selectedList();
		var $checkedId = $.selectedId(nodes);
		if(nodes.length==0){
			alert("您还没有选择修改条目");
			return;
		}
		if(nodes.length>1){
			alert("每次只能重置一条");
			return;
		}
		var url = $editPass.attr("url");
		window.location.href = "${request.contextPath}"+url+"?id="+$checkedId;
	})
})
</script>
</head>
<body>
<form id="listForm" action="${request.getContextPath}/admin/account" class="form-horizontal">
		<div class="row">
		<div class="col-md-12">
			<div class="portlet box grey">
				<div class="portlet-body form">
					<!-- BEGIN FORM-->
						<div class="form-body">
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label">用户名：</label>
										<div class="controls">
											<input name="username" value="${account.username}" type="text" class="form-control col-md-12">
										</div>
									</div>
								</div>	
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label">姓名：</label>
										<div class="controls">
											<input name="xm" value="${account.xm}" type="text" class="form-control col-md-12">
										</div>
									</div>
								</div>	
								<div class="col-md-4">
									<div class="form-group">
										<label class="control-label">角色：</label>
										<div class="controls">
											 <select name="roleId" class="form-control col-md-4">
											 <option value="">---请选择---</option>
											             		<c:forEach items="${roleList}" var="item">
											             			<option value="${item.id}"
												             			<c:if test="${roleId==item.id }">
												             				selected
												             			</c:if>>
											             				${item.roleName}
											             			</option>
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
										<button type="submit" class="btn blue mgr20 wzbtn">查询</button>
									</div>
								</div>
							</div>
						</div>
					<!-- END FORM-->
				</div>
			</div>
		</div>
	</div>
		
		<div class="table-warp">
			<table id="listTable" class="table table-bordered table-condensed table-advance table-hover">
					<thead>
					<tr>
		               <th style="width:40px;" class="text_center">序号</th>
					   <th class="table-checkbox" width="80" >
						<input id="selectAll" type="checkbox" name="all" class="group-checkable"/>&nbsp; &nbsp;全选 
					  </th>
					  <th>用户名</th>
					  <th>姓名</th>
					   <th>启用状态</th>
					   <th>锁住状态</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="account" varStatus="c">
							<tr class="odd gradeX">
				             <td>${c.index+1}</td>
				             <td><input value="${account.id}" name="ids" type="checkbox"></td>
					      	 <td>${account.username}</td>
					      	 <td>${account.xm}</td>
					      	 <td>
					      	 	<c:choose>
					      	 		<c:when test="${account.isEnabled}">
					      	 			开启
					      	 		</c:when>
					      	 		<c:otherwise>
					      	 			停用
					      	 		</c:otherwise>
					      	 	</c:choose>
					      	 </td>
					      	 <td>
					      	 	<c:choose>
					      	 		<c:when test="${account.isLocked}">
					      	 			是
					      	 		</c:when>
					      	 		<c:otherwise>
					      	 			否
					      	 		</c:otherwise>
					      	 	</c:choose>
					      	 </td>
						</tr>
						</c:forEach>
				</tbody>
			</table>
		</div>
		<jsp:include page="../_include/_pageinfo.jsp"></jsp:include>
	</form>
</body>
</html>
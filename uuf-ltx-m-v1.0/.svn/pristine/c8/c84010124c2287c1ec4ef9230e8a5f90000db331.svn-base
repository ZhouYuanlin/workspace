<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>日志列表</title>
</head>
<body>
	 <form id="listForm"  class="form-horizontal" action="${request.getContextPath}/admin/log" method="get">
		<div class="row-fluid">
				<div class="span6">
				  <div class="control-group">
					<label class="control-label">操作名称：</label>
					<div class="controls">
						<input type="text" name="operation" value="${log.operation}" class="m-wrap span8"/>
					</div>
				   </div>
				</div>
				<div class="span6">
					<div class="control-group">
					<label class="control-label">操作人：</label>
					<div class="controls">
						<input type="text" name="operator" value="${log.operator}" class="m-wrap span8"/>
					</div>
					</div>
				</div>
		</div>
		<div class="form-actions nobg">
				<button class="btn blue" type="button" onclick="pageSkip('1')" ><i class="icon-search icon-white"></i> 查询</button> 
		</div>
		<div class="row-fluid">
			<div class="span12">
				<table id="listTable" class="table table-striped table-bordered table-hover">
						<thead>
						<tr>
			               <th style="width:29px;" class="text_center">序号</th>
						   <th class="text-center">操作名称</th>
						   <th class="text-center">操作人</th>
						   <th class="text-center">操作IP</th>
						   <th class="text-center">操作时间</th>
						</tr>	 
						</thead>
						<tbody>
						<c:forEach items="${page.content}" var="log" varStatus="c">
						    <tr>
						    	<td class="text_center">${c.index+1}</td>
								<td><a href="#">${log.operation}</a></td>
								<td>${log.operator}</td>
								<td>${log.ip}</td>
								<td><fmt:formatDate value="${log.createDate}" pattern="yyyy-MM-ddd hh:mm:ss"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<jsp:include page="../_include/_pageinfo.jsp"></jsp:include>
	</form>		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色管理</title>
</head>
<body>
		<div class="table-warp">
			<table id="listTable" class="table table-bordered table-condensed table-advance table-hover">
					<thead>
					<tr>
		               <th style="width:40px;" class="text_center">序号</th>
					   <th class="table-checkbox" width="80">
						<input id="selectAll" type="checkbox" name="all" class="group-checkable"/>&nbsp; &nbsp;全选 
					  </th>
					   <th>角色名称</th>
					   <th>是否超级管理员</th>
					</tr>	 
					</thead>
					<tbody>
					<c:forEach items="${roleList}" var="role" varStatus="c">
					    <tr class="odd gradeX">
					    	<td>${c.index+1}</td>
					    	<td>
					    		<c:choose>
									<c:when test="${role.isSuperAdministrator==true}">
										<input value="${role.id}" readonly="readonly" name="ids" type="checkbox">
									</c:when>
									<c:otherwise>
										<input value="${role.id}"  name="ids" type="checkbox">
									</c:otherwise>
								</c:choose>
					    	</td>
							<td><a href="#">${role.roleName}</a></td>
							<td>
								<c:choose>
									<c:when test="${role.isSuperAdministrator==true}">
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
</body>
</html>
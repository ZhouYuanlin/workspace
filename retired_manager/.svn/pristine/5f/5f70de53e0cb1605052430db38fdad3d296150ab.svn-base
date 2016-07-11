<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
	</head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/role/grant'/>" method="post" class="form-horizontal">
		<input type="hidden" name="pid" value="${pid}"/>
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
							授权</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
              </div>
			  <div class="row custom-left-row">
			  		<div class="custom-row-2">
						<div class="list-group left-list-group">
						  <a href="javascript:;;" class="list-group-item">所有角色</a>
						  <c:forEach items="${rlist}" var="item" varStatus="c">
						  		<a href="<c:url value='/role/console?pid=${item.id}'/>" class="list-group-item ${item.id == pid ? 'active' : ''}">${item.name}</a>
						  </c:forEach>
						</div>
					</div>
					<c:set var="count" value="-1"/>
					<div class="custom-row-10">
					<c:forEach items="${slist}" var="item" varStatus="i">
  						<c:set var="count" value="${count + 1}"/>
						<div class="panel panel-default checkbox-list">
						  <div class="panel-heading"><label class=""><input type="checkbox" name="resList[${count}].id" value="${item.id}" <c:forEach items="${item.roles}" var="x"><c:if test="${x.id == pid}">checked</c:if></c:forEach>>${item.name}</label></div>
						  <div class="panel-body">
							<c:forEach items="${item.children}" var="chi" varStatus="c">
  								<c:set var="count" value="${count + 1}"/>
							<dl>
							<dt><label class=""><input type="checkbox" name="resList[${count}].id" value="${chi.id}" <c:forEach items="${chi.roles}" var="x"><c:if test="${x.id == pid}">checked</c:if></c:forEach>>${chi.name}</label></dt>
							<c:forEach items="${chi.children}" var="t">
		  						<c:set var="count" value="${count + 1}"/>
							<dd><label class=""><input type="checkbox" name="resList[${count}].id" value="${t.id}" <c:forEach items="${t.roles}" var="x"><c:if test="${x.id == pid}">checked</c:if></c:forEach>>${t.name}</label></dd>
							</c:forEach>
							</dl>
							</c:forEach>
						  </div>
					</div>
					</c:forEach>
					</div>
			  </div>
			  <div class="form-actions fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="col-md-offset-5">
								<button type="submit" class="btn blue mgr10 wzbtn">提交</button> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
  		</form>
	</body>
</html>

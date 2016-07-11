<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page import="java.util.*"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="cn.uuf.domain.Account"%>
<%@page import="cn.uuf.domain.Resource"%>
<%@page import="cn.uuf.domain.Role"%>
<%
	Subject subject = SecurityUtils.getSubject();
	Account account = (Account)subject.getPrincipal();
	List<Resource> resList = new ArrayList<Resource>();//account.getRoles().get(0).getResources();
	for(Role r : account.getRoles()){
		resList.addAll(r.getResources());
	}
	request.setAttribute("resList",resList);
%>
<c:forEach items="${resList}" var="item">
		<c:forEach items='${item.children}' var='chi'>
			<c:if test="${!empty chi.action && chi.status != '停用'}">
				<shiro:hasPermission name='${chi.action}'>
					<c:forEach items="${chi.children}" var="ss">
						<shiro:hasPermission name='${ss.action}'>
						<c:if test="${fn:endsWith(fn:split(ss.action,'/')[0],fn:replace(Mpath,'/',''))}">
						<a <c:if test="${!empty ss.aalias}">id="${ss.aalias}"</c:if> class="${ss.aclass}" href="${ss.ahref}" <c:if test="${!empty ss.data_formid}">data-formid="${ss.data_formid}"</c:if>
						   <c:if test="${!empty ss.data_action}">data-action="${ss.data_action}"</c:if><c:if test="${!empty ss.domethod}">onClick="${ss.domethod}"</c:if>
						   <c:if test="${!empty ss.arole}">role="${ss.arole}"</c:if><c:if test="${!empty ss.data_toggle}">data-toggle="${ss.data_toggle}"</c:if>>
						<i class="${ss.iclass}"></i>${ss.name}</a>
						</c:if>
						</shiro:hasPermission>
					</c:forEach>
				</shiro:hasPermission>
			</c:if>
		</c:forEach>
</c:forEach>
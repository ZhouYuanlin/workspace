<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

			<div style="margin-left: 10px;">
					<c:set var="list" value="${fam}"></c:set>
					<c:if test="${empty list}">
						<label class="control-label" style="color: red">未检索到数据</label>
					</c:if>
					<c:if test="${not empty list}">
						<label class="control-label" style="color: #666">搜索结果</label><br>
					</c:if>
				<div class="controls">
					<div>
					<c:forEach items="${fam}" var="item" varStatus="c">
						<a href="#" id="adre+${c.index}" ref="${item.jtdz }" onclick="pointJtdz(this)" style="font-size: 14px;color:#9c6 ">${item.jtdz }</a></br></br>
					</c:forEach>
					</div>
				</div>
			</div>

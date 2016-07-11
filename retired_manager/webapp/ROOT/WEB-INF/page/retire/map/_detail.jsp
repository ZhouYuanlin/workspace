<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
				<div style="margin-left: 10px;">
									<c:set var="list" value="${xmList}"></c:set>
										<c:if test="${empty list}">
											<label class="control-label" style="color: red">未找到对应信息</label>
										</c:if>
										<c:if test="${not empty list}">
											<label class="control-label" id="countsss" style="color: #666">根据搜索结果查询到以下人员</label><br><br>
										</c:if>
									
									<div class="controls">
										<div>
										<c:forEach items="${xmList}" var="item" varStatus="c">
											<a href="#" id="${c.index}" ref="${item.familys[0].jtdz}" onclick="pointJtdz(this)" style="font-size: 14px;text-decoration: none;">
											<table style="width: 100%;margin-bottom: 5px;">
											<input type="hidden" id="sfzhxc${c.index}" value="${item.sfzh}"/>
												<tr>
													<td width="10%">${c.index+1}、</td>
													<td width="20%">姓名:</td>
													<td width="60%">${item.xm}<input type="hidden" id="djxmcx${c.index}" value="${item.xm}"></td>
												</tr>
												<tr>
													<td></td>
													<td valign="top">住址:</td>
													<td id='addre'>${item.familys[0].jtdz}</td>
												</tr>
												<tr>
													<td></td>
													<td>电话:</td>
													<td>${item.lxdh}</td>
												</tr>
											</table>
												</a>
										</c:forEach>
										
										</div>
									</div>
									
</div>
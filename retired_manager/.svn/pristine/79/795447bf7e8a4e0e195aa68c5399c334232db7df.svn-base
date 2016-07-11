<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${fn:length(m.familys) > 1}">
			  	<div class="row">
					<div class="col-md-12">
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                         <thead>
                         <tr>
                         	<th width="45">序号</th>
                             <th>家庭住址</th>
                             <th>邮编</th>
                             <th>家庭电话</th>
                             <th>说明</th>
                             <th>默认住址</th>
                             <th>操作</th>
                         </tr>
                         </thead>
                         <tbody>
                         <c:forEach items="${m.familys}" var="item" varStatus="c">
                         <tr class="odd gradeX">
                         	<td>${c.index + 1}</td>
                             <td title="${item.jtdz}"><s:substring length="50" value="${item.jtdz}"/></td>
                             <td>${item.yzbm}</td>
                             <td>${item.jtdh}</td>
                             <td title="${item.description}"><s:substring length="30" value="${item.description}"/></td>
                             <td>${item.sfmr}</td>
                             <td width="150"><a href="/retfamily/${item.id}/edit" class="btn default btn-xs black" id="showtoast">编辑</a> <a href="" ref="${item.id}" class="btn default btn-xs black delinfo">删除</a></td>
                         </tr>
                         </c:forEach>
                          </tbody>
                       </table>
              		</div>
				</div>
			  </c:if>
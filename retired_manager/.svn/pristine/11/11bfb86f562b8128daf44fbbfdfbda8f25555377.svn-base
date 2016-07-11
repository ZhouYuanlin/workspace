<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${fn:length(m.members) > 0}">
<div class="mgb10">	
								<button type="submit" class="btn blue mgr20 wzbtn"> 家庭成员 </button> 
							</div>
			  	<div class="row">
					<div class="col-md-12">
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                         <thead>
                         <tr>
                         	<th width="45">序号</th>
                             <th>姓名</th>
                             <th>关系</th>
                             <th>工作单位</th>
                             <th>职务</th>
                             <th>联系电话</th>
                             <th>居住关系</th>
                             <th>备注</th>
                             <th>操作</th>
                         </tr>
                         </thead>
                         <tbody>
                         <c:forEach items="${m.members}" var="item" varStatus="c">
                         <tr class="odd gradeX">
                         	<td>${c.index + 1}</td>
                             <td>${item.mxm}</td>
                             <td>${item.mgx}</td>
                             <td title="${item.mgzdw}"><s:substring length="50" value="${item.mgzdw}"/></td>
                             <td>${item.mzw}</td>
                             <td>${item.mdh}</td>
                             <td>${item.mjzgx}</td>
                             <td>${item.mkwpc}</td>
                             <td width="150"><a href="/retfamily/${item.id}/modify" class="btn default btn-xs black" id="showtoast">编辑</a> <a href="javascript:;;" ref="${item.id}" class="btn default btn-xs black delmem">删除</a></td>
                         </tr>
                         </c:forEach>
                          </tbody>
                       </table>
              		</div>
				</div>
			  </c:if>
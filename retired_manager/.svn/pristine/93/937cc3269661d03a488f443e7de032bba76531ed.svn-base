<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>详情</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form id="exp" action="javascript:;;" class="form-horizontal">
		          <div class="row">
					<div class="col-md-12">
					<div class="mgb10">	
						<button class="btn blue mgr20 wzbtn"> 资产编号为<font size="2" color="black">${fushu.assetId}</font>的详细记录 </button> 
					</div>
                         <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                	<th width="45">序号</th>
									<th>资产名称</th>
									<th>型号</th>
									<th>领用人</th>
									<th>领用时间</th>
									<th>归还时间</th>
									<th>领用登记人</th>
									<th>领用登记时间</th>
									<th>归还登记人</th>
									<th>归还登记时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                               <tr class="odd gradeX">
									<td>${c.index + 1}</td>
                                    <td>${item.fushu.assetManage.name}</td>
                                    <td>${item.fushu.assetManage.version}</td>
                                    <c:if test="${item.returnState==0}">
										<td>${item.usePerson}<font size="2" color="red"> 正在使用!</font></td>
									</c:if>
									<c:if test="${item.returnState==1}">
										<td>${item.usePerson}<font size="2" color="blue">曾经使用!</font></td>
									</c:if>
                                    <td>${item.useDate}</td>
                                    <td>${item.returnTime}</td>
                                    <td>${item.register}</td>
                                    <td>${item.registerDate}</td>
                                    <td>${item.returnRegister}</td>
                                    <td>${item.returnRegisterTime}</td>
									</tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
              		</div>
              		</div>
		        </form>
		    </div>
		  </div>
		  <div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
<%-- 		  <c:if test="${!empty list}"><button data-dismiss="modal" class="btn blue export">导出</button></c:if>
 --%>		  </div>
		  <script>
		  	$(function(){
		  		$('.export').click(function(){
		  			$('#exp').attr('method','post').attr('action','/retireactivity/export').submit();
		  		});
		  	});
		  </script>
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
						<button class="btn blue mgr20 wzbtn"> 资产明细 </button> 
					</div>
                         <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                	<th width="45">序号</th>
                                	 <th>资产编号</th>
                                    <th>资产名称</th>
                                    <th>型号</th>
                                    <th>类型</th>
                                    <th>单价</th>
                                    <th>采购日期</th>
                                    <th>质保期</th>
                                    <th>来源</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                     <td>${c.index + 1}</td>
                                    <td>${item.assetId}</td>
                                    <td>${item.assetManage.name}</td>
                                    <td>${item.assetManage.version}</td>
                                    <td>${item.assetManage.ca.name}</td>
                                    <td>${item.assetManage.unitPrice}</td>
                                    <td>${item.assetManage.purchaseDate}</td>
                                    <td>${item.assetManage.shelfLife}</td>
                                    <td>${item.assetManage.codeAs.name}</td>
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
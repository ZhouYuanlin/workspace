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
		        	<input type="hidden" name="id" value="${t.id}"/>
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">小组名称：</label>
								<div class="controls">
									<p class="c-text">${t.title}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">小组类型：</label>
								<div class="controls">
									<p class="c-text">${t.xzlx}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">小组长：</label>
								<div class="controls">
									<p class="c-text">${t.xzzz}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">联系电话：</label>
								<div class="controls">
									<p class="c-text">${t.lxdh}</p>
								</div>
							</div>
						</div>
					</div>
		          </div>
		          <div class="row">
					<div class="col-md-12">
					<div class="mgb10">	
						<button class="btn blue mgr20 wzbtn"> 小组成员 </button> 
					</div>
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                	<th>序号</th>
                                    <th>姓名</th>
                                    <th>支部</th>
                                    <th>手机</th>
                                    <th>原工作单位</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                	<c:if test="${empty item.sfzh}">
                                    	<td>${item.xm}<i style="color: red;">(此人员已被删除)</i></td>
                                	</c:if>
                                	<c:if test="${not empty item.sfzh}">
                                    	<td>${item.xm}</td>
                                	</c:if>
                                    <td>${item.party.dzbmc}</td>
                                    <td>${item.lxdh}</td>
                                    <td>${item.dwb.name}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="6">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
              		</div>
              		</div>
		        </form>
		    </div>
		  </div>
		  <div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
		    <c:if test="${!empty list}"><button data-dismiss="modal" class="btn blue export">导出</button></c:if>
		  </div>
		  <script>
		  	$(function(){
		  		$('.export').click(function(){
		  			$('#exp').attr('method','post').attr('action','/retireactivity/export').submit();
		  		});
		  	});
		  </script>
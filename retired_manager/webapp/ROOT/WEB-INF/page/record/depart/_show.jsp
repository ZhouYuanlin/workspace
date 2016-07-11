<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>通信录</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form action="#" class="form-horizontal">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">部门：</label>
								<div class="controls">
									<p class="c-text">${d.name}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">父级：</label>
								<div class="controls">
									<p class="c-text">${d.parent.name}</p>
								</div>
							</div>
						</div>
					</div>
						<div class="table-warp">	
						
							<table class="table table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>办公电话</th>
                                    <th>手机</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${d.records}" var="item">
                                  <tr>
                                    <td>${item.name}</td>
                                    <td>${item.bgdh}</td>
                                    <td>${item.mobile}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty d.records}">
                                	<tr><td colspan="3">无</td></tr>
                                </c:if>
                                </tbody>
                                </table> 
								</div>
					</div>
		        </form>
		    </div>
		  </div>
		  <div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
		  </div>
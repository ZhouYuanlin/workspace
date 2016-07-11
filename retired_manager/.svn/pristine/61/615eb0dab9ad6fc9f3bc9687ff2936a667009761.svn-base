<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>角色信息</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form action="javascript:;" class="form-horizontal">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">角色名称：</label>
								<div class="controls">
									<p class="c-text">${role.name}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">角色访问的范围：</label>
								<div class="controls">
									<p class="c-text">${role.scope}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">角色描述：</label>
								<div class="controls">
									<p class="c-text">
										<c:if test="${role.description==null}">空</c:if>
										${role.description}
									</p>
								</div>
							</div>
						</div>
					</div>
		          </div>
		          <div class="row">
					<div class="col-md-12">
					<div class="mgb10">	
						<button class="btn blue mgr20 wzbtn">此角色下用户信息 </button> 
					</div>
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                    <th>真实姓名</th>
                                    <th>状态</th>
                                    <th>登录名</th>
                                    <th>工作证号</th>
                                    <th>联系电话</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${role.accounts}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td>${item.realname}</td>
                                    <td>${item.status}</td>
                                    <td>${item.username}</td>
                                    <td>${item.gzzh}</td>
                                    <td>${item.lxdh}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty role.accounts}"><tr><td colspan="5">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
              		</div>
              		</div>
		        </form>
		    </div>
		  </div>
		  <%--div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
		  </div--%>
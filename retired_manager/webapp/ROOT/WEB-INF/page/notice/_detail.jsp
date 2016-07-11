<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>通知公告</h3>
		  </div>
		  <div class="modal-body">
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form action="#" class="form-horizontal">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">标题：</label>
								<div class="controls">
									<p class="c-text">${n.title}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">发布时间：</label>
								<div class="controls">
									<p class="c-text"><fmt:formatDate value="${n.createDate}" pattern="yyyy-MM-dd"/></p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">发布人：</label>
								<div class="controls">
								<c:choose>
									<c:when test="${empty account}">
										<p class="c-text">${n.fbz}</p>
									</c:when>
									<c:otherwise>
										<p class="c-text">${account.realname}</p>
									</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
					<c:if test="${!empty n.attach}">
						<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">下载：</label>
								<div class="controls">
									<p class="c-text"><a href="/retirenotice/${n.id}/download">${n.attach}</a></p>
								</div>
							</div>
						</div>
					</div>
					</c:if>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">内容：</label>
									<div class="controls">
										<p class="c-text">${n.content}</p>
									</div>
							</div>
						</div>
					</div>
		          </div>
		        </form>
		    </div>
		    </div>
		  </div>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>问卷详情</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form action="javascript:;;" class="form-horizontal">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">问卷名称：</label>
								<div class="controls">
									<p class="c-text">${r.wjzt}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">性别：</label>
								<div class="controls">
									<p class="c-text">${r.id}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">类型：</label>
								<div class="controls">
									<p class="c-text">${q.id}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">所在党支部：</label>
								<div class="controls">
									<p class="c-text">${r.id}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">党费基数：</label>
								<div class="controls">
									<p class="c-text">${r.id}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">缴费周期：</label>
								<div class="controls">
									<p class="c-text">${r.id}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">缴费金额：</label>
								<div class="controls">
									<p class="c-text">${r.id}</p>
<%-- 									<p class="c-text">${p.dfjs * p.jfzq}</p> --%>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">缴费时间：</label>
								<div class="controls">
									<p class="c-text">${r.id}</p>
								</div>
							</div>
						</div>
					</div>
		          </div>
		        </form>
		    </div>
		  </div>
		  <%--div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
		  </div--%>
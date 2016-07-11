<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>工作经历</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form action="#" class="form-horizontal">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">姓名：</label>
								<div class="controls">
									<p class="c-text">${ret.xm}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">身份证号：</label>
								<div class="controls">
									<p class="c-text">${ret.sfzh}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">性别：</label>
								<div class="controls">
									<p class="c-text">${ret.xb}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">民族：</label>
								<div class="controls">
									<p class="c-text">${ret.mzb.name}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">原工作单位：</label>
								<div class="controls">
									<p class="c-text">${ret.dwb.name}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">职务：</label>
								<div class="controls">
									<p class="c-text">${ret.zwb.name}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">工作时间：</label>
								<div class="controls">
									<p class="c-text">${ret.gzsj}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">离退休时间：</label>
								<div class="controls">
									<p class="c-text">${ret.lxsj}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">工作经历：</label>
								<c:forEach items="${ret.works}" var="item">
									<div class="controls">
										<p class="c-text">${item.content}</p>
									</div>
								</c:forEach>
								<c:if test="${empty ret.works}">
									<div class="controls">暂无</div>
								</c:if>
							</div>
						</div>
					</div>
		          </div>
		        </form>
		    </div>
		  </div>
		  <div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
		  </div>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>电话联系详情</h3>
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
								<label class="control-label">类型：</label>
								<div class="controls">
									<p class="c-text">${ret.lxb.name}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">原工作单位：</label>
								<div class="controls">
									<p class="c-text">${ret.dwb.name}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">联系人：</label>
								<div class="controls">
									<p class="c-text">${retphone.lxr}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">联系日期：</label>
								<div class="controls">
									<p class="c-text"><fmt:formatDate value="${retphone.lxrq}"  pattern="yyyy-MM-dd"/></p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">登记人：</label>
								<div class="controls">
									<p class="c-text">${retphone.djr}</p>
									
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">登记日期：</label>
								<div class="controls">
									<p class="c-text"><fmt:formatDate value="${retphone.djrq}"  pattern="yyyy-MM-dd"/></p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
                            <div class="form-group">
								<label class="control-label">联系详情：</label>
								<div class="controls">
									<textarea class="form-control col-md-12" style="height: 100px;background-color: white;" readonly="readonly">${retphone.lxxq}</textarea>
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
		  </div> --%>
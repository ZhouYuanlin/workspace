<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>活动详情</h3>
		  </div>
		  <div class="modal-body" style="height:500px;">
		    <div class="form">
		        <form action="#" class="form-horizontal">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">活动名称：</label>
								<div class="controls">
									<p class="c-text">${p.name}</p>
								</div>
							</div>
						</div>
						
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">活动地点：</label>
								<div class="controls">
									<p class="c-text">${p.hddd}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">封页图片：</label>
								<div class="controls">
									<p class="c-text"><img width=240px height=160px src="${p.imgurl}"/></p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">活动时间：</label>
								<div class="controls">
									<p class="c-text">${p.hdsj}~${p.hdsjjz}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label">负责人：</label>
								<div class="controls">
									<p class="c-text">${p.fzr}</p>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label class="control-label">负责人联系电话：</label>
								<div class="controls">
									<p class="c-text">${p.fzrlxdh}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">参与人员：</label>
								<div class="controls">
									<p class="c-text">${p.cyrys}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">说明：</label>
								<div class="controls">
									<p class="c-text">${p.bz}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">活动内容：</label>
								<div class="controls">
									<p class="c-text">${p.content}</p>
								</div>
							</div>
						</div>
					</div>
		          </div>
		        </form>
		    </div>
		  </div>

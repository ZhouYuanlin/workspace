<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>职级</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form action="#" class="form-horizontal">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">职级：</label>
								<c:forEach items="${zjblist}" var="item">
									<button type="button" class="btn btn-sm <c:if test='${fn:contains(ret.qq,item.id)}'>active</c:if>" ref="${item.id}" data-toggle="button">${item.name}</button>
								</c:forEach>
							</div>
						</div>
					</div>
		          </div>
		        </form>
		    </div>
		  </div>
		  <div class="modal-footer">
		  	<button data-dismiss="modal" class="btn blue confirm">确定</button>
		    <button data-dismiss="modal" class="btn blue concace">取消</button>
		  </div>
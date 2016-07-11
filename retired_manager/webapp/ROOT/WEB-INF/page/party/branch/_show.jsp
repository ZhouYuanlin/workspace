<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>党支部信息</h3>
		  </div>
		  <div class="modal-body" style="height:400px;">
		    <div class="form">
		        <form action="javascript:;;" class="form-horizontal">
		          <div class="form-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">党支部名称：</label>
								<div class="controls">
									<p class="c-text">${r.dzbmc}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">支部简称：</label>
								<div class="controls">
									<p class="c-text">${r.dzbjc}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">党支部书记：</label>
								<div class="controls">
									<p class="c-text">${r.dzbsj}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">党支部副书记：</label>
								<div class="controls">
									<p class="c-text">${r.dzbfsj}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">联络员：</label>
								<div class="controls">
									<p class="c-text">${r.zblny}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">联系电话：</label>
								<div class="controls">
									<p class="c-text">${r.lxdh}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">支委：</label>
								<div class="controls">
									<p class="c-text"><c:forEach items="${r.zws}" var="chi" varStatus="s">${chi.xm}<c:if test="${!s.last}">;</c:if></c:forEach></p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">简述：</label>
								<div class="controls">
									<p class="c-text">${r.zzms}</p>
								</div>
							</div>
						</div>
					</div>
		          </div>
		          <div class="row">
					<div class="col-md-12">
					<div class="mgb10">	
						<button class="btn blue mgr20 wzbtn"> 人员信息 </button> 
					</div>
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>部门</th>
                                    <th>类型</th>
                                    <th>联系电话</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${r.ments}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td>${item.xm}</td>
                                    <td>${item.xb}</td>
                                    <td>${item.dwb.name}</td>
                                    <td>${item.lxb.name}</td>
                                    <td>${item.lxdh}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty r.ments}"><tr><td colspan="5">没有数据！</td></tr></c:if>
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
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>党员信息</h3>
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
								<label class="control-label">入党时间：</label>
								<div class="controls">
									<p class="c-text">${ret.rdsj}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">所在党支部：</label>
								<div class="controls">
									<p class="c-text">${ret.party.dzbmc}</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">支部书记：</label>
								<div class="controls">
									<p class="c-text">${ret.party.dzbsj}</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">支部联络员：</label>
								<div class="controls">
									<p class="c-text">${ret.party.zblny}</p>
								</div>
							</div>
						</div>
					</div>
		          </div>
		          <div class="row">
					<div class="col-md-12">
					<div class="mgb10">	
					<input type="button" class="btn blue mgr20 wzbtn" value="党费记录">
					</div>
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                    <th>缴费日期</th>
                                    <th>缴费基数</th>
                                    <th>缴费周期</th>
                                    <th>金额</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${ret.pays}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td>${item.jfsj}</td>
                                    <td>${item.dfjs}</td>
                                    <td>${item.jfzq}</td>
                                    <td>${item.money}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty ret.pays}"><tr><td colspan="5">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
              		</div>
              		<div class="col-md-12">
					<div class="mgb10">	
						<input type="button" class="btn blue mgr20 wzbtn" value="捐款记录">
					</div>
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                    <th>捐款日期</th>
                                    <th>捐款金额</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${ret.donas}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td>${item.jkrq}</td>
                                    <td>${item.jkje}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty ret.donas}"><tr><td colspan="5">还没有捐款！</td></tr></c:if>
                                </tbody>
                                </table>
              		</div>
				</div>
		        </form>
		    </div>
		  </div>
		  <%--div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
		  </div> --%>
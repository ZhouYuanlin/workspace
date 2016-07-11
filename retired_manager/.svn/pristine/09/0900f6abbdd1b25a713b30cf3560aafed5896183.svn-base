<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/retfamily/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retfamily/">
							家庭信息 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retfamily/">
							详情 </a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<a href="javascript:;;" class="btn blue" onclick="doCreate()"><i class="fa fa-plus"></i> 家庭住址</a>
                	<a href="javascript:;;" class="btn blue" onclick="doMember()"><i class="fa fa-plus"></i> 家庭成员</a> 
                </div>
              </div>
              </div>
			  <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-body form">
										<form id="frm" action="<c:url value='${request.contextPath}/retfamily'/>" class="form-horizontal" method="post">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">姓名：</label>
															<div class="controls">
																<p class="c-text">${m.xm}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">性别：</label>
															<div class="controls">
																<p class="c-text">${m.xb}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<p class="c-text">${m.sfzh}</p>
															</div>
														</div>
													</div>
												</div>
												<c:if test="${fn:length(m.familys) > 0}">
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">手机：</label>
															<div class="controls">
																<p class="c-text">${m.lxdh}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">邮箱：</label>
															<div class="controls">
																<p class="c-text">${m.email}</p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">微信：</label>
															<div class="controls">
																<p class="c-text">${m.weix}</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-8">
														<div class="form-group">
															<label class="control-label">家庭地址：</label>
															<div class="controls">
																<p class="c-text" title="${m.familys[0].jtdz}"><s:substring length="100" value="${m.familys[0].jtdz}"/></p>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">邮编：</label>
															<div class="controls">
																<p class="c-text">${m.familys[0].yzbm}</p>
															</div>
														</div>
													</div>
												</div>
												</c:if>
											</div>
										</form>
									</div>
								</div>  
					</div>
			  </div>
			  <div class="showjtdz"><jsp:include page="_info.jsp"/></div>
			  <div class="showmem"><jsp:include page="_jtcy.jsp"/></div>
			</div>
		</div>
		<script>
		function doCreate(){
			$('#frm').attr('action','/retfamily/${m.sfzh}/create').submit();
		}
		function doMember(){
			$('#frm').attr('action','/retfamily/${m.sfzh}/addmember').submit();
		}
		$(function(){
			$('.delinfo').click(function(){
				var id = $(this).attr("ref");
				//var fsfzh = ${fsfzh};
				if(confirm("删除后无法恢复,确定要删除吗?")){
					$.post('/retfamily/ajaxremove?'+new Date().getTime(),{"id":id},function(d){
						location.reload();
						$(".showjtdz").html(d);
					});
				}
			});
			$('.delmem').click(function(){
				var id = $(this).attr("ref");
				if(confirm("删除后无法恢复,确定要删除吗?")){
					$.post('/retfamily/ajaxcutmem?'+new Date().getTime(),{"id":id},function(d){
						location.reload();
						$(".showmem").html(d);
					});
				}
			});
		});
		</script>
	</body>
</html>
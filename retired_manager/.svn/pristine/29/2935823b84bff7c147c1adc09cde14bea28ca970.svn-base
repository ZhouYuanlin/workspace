<%@page import="cn.uuf.contants.Constants"%>
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
							<a href="${request.contextPath}/retlabel/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retlabel/">
							保健标记</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retlabel/">
							修改 </a>
						</li>
					</ul>
				</div>
			</div>
			  <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-title">
										<div class="caption">
											信息修改
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="<c:url value='${request.contextPath}/retlabel/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" value="${r.id}"/>
											<input type="hidden" id="sfzh" name="sfzh" value="${r.ret.sfzh}"/>
											<div class="form-body">
												<jsp:include page="../../retire/_update.jsp"/>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">保健标记：</label>
															<div class="controls">
																<c:forEach items="${bjbjlist}" var="item">
																	<input type="checkbox" id="bjbj" name="bjbj" value="${item.name}" class="bjs" <c:if test="${fn:contains(r.bjbj,item.name)}">checked="true"</c:if>/>${item.name}
																</c:forEach>
															</div>
														</div>
													</div>
												</div>
												</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10 wzbtn"> 提交 </button> 
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>  
					</div>
			  </div>
			</div>
		</div>
		<script>
		$(function(){
			$('.wzbtn').click(function(){
				if($('#sfzh').val() == ""){
					alert("请输入身份证号");
					$('#sfzh').focus();
					return false;
				}
				var b = 0;
				$('.bjs').each(function(){
					if($(this).is(':checked'))
						b++;
				});
				if(b > 0)$('#frm').submit();
				else{alert('请选择保健标记');return false;}
			});
		});
		</script>
	</body>
</html>

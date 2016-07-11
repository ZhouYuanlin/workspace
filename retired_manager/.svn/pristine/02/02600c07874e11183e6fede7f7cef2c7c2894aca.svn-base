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
							<a href="${request.contextPath}/picture/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/picture/">
							图片分享</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/picture/">
							修改 </a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
	                <div class="operation-btn pull-right">
	                	<a class="btn blue" href="javascript:void(0)" onclick="doBackUp();">返回</a>
	                </div>
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
										<form id="frm" action="<c:url value='${request.contextPath}/picture/update'/>" class="form-horizontal" method="post">
											<input type="hidden" name="id" id="id" value="${grp.id }"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>相册名称：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="${grp.name}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>相册描述：</label>
															<div class="controls">
																<textarea name="summary" id="summary" class="form-control col-md-12">${grp.summary}</textarea>
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
				var name=$("#name").val();
				var summary=$("#summary").val();
				if(name==null || name==""){
					alert("相册名称不能为空！");
					return false;
				}
				if(summary==null || summary==""){
					alert("相册描述不能为空！");
					return false;
				}
				return true;
			});
		});
		//返回上级
		function doBackUp(){
			var id="${back}";
			$('#frm').attr('method','post').attr('action',"/picture/"+id+"/back").submit();
		}
		</script>
	</body>
</html>
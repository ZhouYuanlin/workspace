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
							<a href="${request.contextPath}/carousel/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/carousel/">
							图片轮播</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/carousel/">
							修改</a>
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
										<form id="frm" action="<c:url value='${request.contextPath}/carousel/update'/>" class="form-horizontal" method="post" enctype="multipart/form-data">
											<input type="hidden" name="id" value="${c.id}"/>
											<input type="hidden" name="imgpath" value="${c.imgpath}">
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>图片名称：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="${c.name}" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color: red; margin-right: 5px;">*</i>图片上传：</label>
															<div class="controls">
																<input type="file" id="imgFile" name="imgFile" id="imgFile" class="form-control col-md-12">
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">显示顺序：</label>
															<div class="controls">
																<input type="text" name="sort" value="${c.sort}" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" class="btn blue mgr10 wzbtn"> 提交 </button> 
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
					if($('#name').val() == ''){
						alert('图片名称不能为空');
						$('#name').focus();
						return false;
					}
					if($('#imgFile').val() == ''){
						alert('请选择图片');
						$('#imgFile').focus();
						return false;
					}
					$('#frm').submit();
				});
			});
		</script>
	</body>
</html>
<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<body>
	<script>
		var contextPath="${request.contextPath}";
	</script>
	<link href="${request.contextPath}/defaults/css/jquery_imgareaselect.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/themes/default/default.css" />
	<script type="text/javascript" src="${request.contextPath}/defaults/js/kindeditor/kindeditor-all.js"></script>
	<script type="text/javascript" src="${request.contextPath}/defaults/js/jquery.uploadify.js"></script>
	<script type="text/javascript" src="${request.contextPath}/defaults/js/jquery.imgareaselect.js"></script>
	<script type="text/javascript" src="${request.contextPath}/defaults/js/imageWithCropperUpload.js"></script>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/information/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/information/">
							个人信息 </a>
						</li>
					</ul>
				</div>
			</div>
			  <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-title">
										<div class="caption">
											更换头像
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
											<div class="form-body">
												<div class="row">
													<div class="col-md-5">
														<div class="form-group">
															<label class="control-label">当前图片：</label>
															<div class="controls">
																<img id="imageOriginal" src="${request.contextPath}/defaults/img/avator_default.jpg"/>
															</div>
														</div>
													</div>
													<div class="col-md-7">
														<div class="form-group">
															<label class="control-label">头像预览：</label>
															<div class="controls">
															<div class="photopreview"> 
																<c:if test="${empty u.imgsfsc}">
																	<p class="p1" style="overflow: hidden;"><img id="imageBig" src="${request.contextPath}/defaults/img/avator_blank.jpg"/></p>
																	<p class="p2" style="overflow: hidden;"><img id="imageMedium" src="${request.contextPath}/defaults/img/avator_blank.jpg"/></p>
																	<p class="p3" style="overflow: hidden;"><img id="imageThumb" src="${request.contextPath}/defaults/img/avator_blank.jpg"/></p>
																</c:if>
																<c:if test="${!empty u.imgsfsc}">
																	<p class="p1" style="overflow: hidden;"><s:image id="imageBig" user="${u.sfzh}" size="zoom" width="180" height="180"/></p>
																	<p class="p2" style="overflow: hidden;"><s:image id="imageMedium" user="${u.sfzh}" size="middle" width="90" height="90"/></p>
																	<p class="p3" style="overflow: hidden;"><s:image id="imageThumb" user="${u.sfzh}" size="small" width="50" height="50"/></p>
																</c:if>
															</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">更换头像：</label>
															<div class="controls">
																<div class="input-append">
																 <input class="form-control col-md-3 input-xlarge mgr5" id="disabledInput" disabled type="text"/> 
																 <button class="btn blue" type="button" id="imageWithCropperUpload" >浏览</button>
																  <form  id="frm" name="frm" method="post" action="<c:url value='${request.contextPath}/avator/avatorCrop'/>">
																	<input id="imageScaleWidth"  type="hidden" name="scaleWidth"/>
																	<input id="imageScaleHeight" type="hidden" name="scaleHeight"/>
																	<input id="imageScaleX1" type="hidden" name="startX"/>
																	<input id="imageScaleY1" type="hidden" name="startY"/>
																	<input id="imageScaleX2" type="hidden" name="endX"/>
																	<input id="imageScaleY2" type="hidden" name="endY"/>
																	<input id="imageOriginalName" name="originalImage" type="hidden"/>
																</form>

															</div>
														</div>
													</div>
												</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">修改说明：</label>
															<div class="controls">

																  <div class="uploadhelp">

																	<p>1、点击<strong>"浏览"</strong>按钮，选择一张本地的图片<br/>
																	2、在左边区域进行必要的修改之后，点击屏幕下方<strong>"保存"</strong>即可</p>

																  </div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" class="btn blue mgr20 wzbtn"> 保存 </button> 
														</div>
													</div>
												</div>
											</div>
									</div>
								</div>  
					</div>
			  </div>

			</div>  
			</div>
		<script>
		$(function(){
			$('.wzbtn').click(function(){
				if($('#imageOriginalName').val() == ''){
					alert('请点击修改头像，选择您要上传的照片！');
					return false;
				}else{
					$('#frm').submit();
				}
			});
		});
		</script>
	</body>
</html>
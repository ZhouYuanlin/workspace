<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
	<body>
  <div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/folder/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/folder/">
							文档管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/folder/">
							增加 </a>
						</li>
					</ul>
				</div>
			</div>
			  <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-title">
										<div class="caption">
											上传文档
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="up_frm" action="<c:url value='${request.contextPath}/folder/upload'/>" method="post" class="form-horizontal" enctype="multipart/form-data" >
											<input type="hidden" name="status" value="公开"/>
											<input type="hidden" name="pid" id="pid" value="${pid}"/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>选择文件：</label>
															<div class="controls">
																<input type="hidden" id="type" name="type" value=""/>
                            									<input type="hidden" id="ufpath" name="ufpath" value=""/>
																<input type="file" id="uploadFile" name="uploadFile" value="" class="form-control col-md-12" />
																<c:if test="${!empty error}">
								                            		<span style="color:red">${error}</span>
								                            	</c:if>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">文件名称：</label>
															<div class="controls">
																<input type="text" id="fileName" name="fileName" value=""  class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
														<div class="col-md-4">
															<div class="form-group">
																<label class="control-label">可上传的文件类型：</label>
																<div class="controls">
																	<i style="color:red;margin-right:5px;">doc,xls,xlsx,pdf,PDF,ppt,pptx,txt</i>
																</div>
															</div>
														</div>
													</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" onclick="return validate()" class="btn blue mgr10 wzbtn"> 提交 </button> 
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
		function validate(){
			if($('.title') == ''){
				alert('标题不能为空');
				$('title').focus();
				return false;
			}
			var str = $("input[name='uploadFile']").val();
			if(str == ""){
				alert('请选择您要上传的文件');
				return false;
			}
			var arr = new Array("doc","xls","xlsx","pdf","PDF","ppt","pptx","txt");
			var type = str.split('.')[1];
			if(!in_array(arr,type)){
				return false;
			}
		}
		
		function in_array(arr, type) {
			  for (var i = 0; i < arr.length; i++) {
			    if (type === arr[i]) {
			     return true;
			    }
			  }
			  alert('格式为如下一种'+arr);
			return false;
		} 
		
		$(function(){
			$('#uploadFile').change(function(){
				var upload = $('#uploadFile').val();
				$('#ufpath').val(upload);
				document.getElementById('type').value = upload.substring(upload.lastIndexOf('.')+1,upload.length);
				document.getElementById('fileName').value = upload.substring(upload.lastIndexOf('\\')+1,upload.lastIndexOf('.'));
			});
		});
		
		$(document).ready(function(){
			$('.btn_blue').click(function(){
				var upload = $('#uploadFile').val();
				if(upload == ''){
					alert('请选择要上传的文件');
					return false;
				}
					$('#up_frm').submit();
			});
		});
	</script>
	</body>
</html>
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
							<a href="${request.contextPath}/video/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/video/">
							视频分享 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/video/">
							视频上传 </a>
						</li>
					</ul>
				</div>
			</div>
			  <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-title">
										<div class="caption">
											文件上传
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="/video/doUpload" enctype="multipart/form-data" class="form-horizontal" method="post">
											<input type="hidden" name="type" id="type" value=""/>
  											<input type="hidden" name="fileName" id="fileName" value=""/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>文件：</label>
															<div class="controls">
																<input  type="file" id="uploadFile" name="uploadFile" value="" multiple class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>标题：</label>
															<div class="controls">
																<input type="text" id="title" name="title" value="" class="form-control col-md-12">
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">可上传的文件类型：</label>
															<div class="controls">
																<i style="color:red;margin-right:5px;">"mp4","flv","mov","f4v","3gp"</i>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">视频默认显示图：</label>
															<div class="controls">
																<input  type="file" name="filePic" value="" multiple class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">描述：</label>
															<div class="controls">
																<textarea class="form-control col-md-12" name="content"></textarea>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="submit" class="btn blue mgr10 wzbtn" onclick="return validate()"> 上传</button> 
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
			$('#uploadFile').change(function(){
				var str = $("input[name='uploadFile']").val();
				var n=str.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1"); 
				if($('#title').val() == '')
					$('#title').val(n);
			});
		});
		function validate(){
			var str = $("input[name='uploadFile']").val();
			if(str == ""){
				alert('请选择您要上传的文件');
				return false;
			}
			var arr = new Array("mp4","flv","mov","f4v","3gp");
			$('#fileName').val(str);
			var type = str.split('.')[1].toLowerCase();
			if(!in_array(arr,type)){
				return false;
			}
			if($('#title').val() == ''){
				alert('请输入标题');
				$('#title').focus();
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
		</script>
	</body>
</html>
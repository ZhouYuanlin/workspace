<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
        <title></title>
    </head>
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
							上传图片 </a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
	                <div class="operation-btn pull-right">
	                	<a class="btn blue" href="/picture/${back}/view/s">返回</a>
	                </div>
             	</div>
           </div>
			<div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-title">
										<div class="caption">
											图片上传
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="<c:url value='/picture/${back}/doUploadPhoto'/>" class="form-horizontal" enctype="multipart/form-data" method="post">
											<input type="hidden" name="type" id="type" value=""/>
  											<input type="hidden" name="fileName" id="fileName" value=""/>
											<div class="form-body">
												<div class="col-md-4">
													<div class="form-group">
														<label class="control-label"><i style="color:red;margin-right:5px;">*</i>图片：</label>
														<div class="controls">
															<input type="file" name="files[]" value="" class="form-control col-md-12"/>
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label class="control-label"><i style="color:red;margin-right:5px;">*</i>图片大小限制10M：</label>
														<div class="controls">
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
    </body>
    <script>
    $(function(){
		$('.wzbtn').click(function(){
			var str = $("input[name='files[]']").val();
			if(str == ""){
				alert('请选择您要上传的图片文件');
				return false;
			}
		});
	});
    </script>
</html>

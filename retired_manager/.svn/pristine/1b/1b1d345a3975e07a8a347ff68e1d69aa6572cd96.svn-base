<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
    <head>
        <title></title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
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
							图片上传</a>
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
											图片上传
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="${request.contextPath}/picture/doUpload" class="form-horizontal" enctype="multipart/form-data" method="post">
											<input type="hidden" name="type" id="type" value=""/>
  											<input type="hidden" name="fileName" id="fileName" value=""/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>上传到->相册：</label>
															<div class="controls">
																<select name = "nameId" id = "nameId" class="form-control col-md-12">
									                             	<c:forEach items="${list}" var = "item">
									                             	<option value="${item.id }">${item.name}</option>
									                             	</c:forEach>
								                        		</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>图片：</label>
															<div class="controls">
																<input  type="file" name="files[]" value="" multiple class="form-control col-md-12"/>
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
				var str = $("input[name='files[]']").val();
				if(str == ""){
					alert('请选择您要上传的图片文件');
					return false;
				}
			});
		});
		//返回上级
		function doBackUp(){
			var id="${back}";
			frm.action = "/picture/"+id+"/back";
			//frm.action = "${request.contextPath}/picture/"+id+"/view/s";
			frm.submit();
		}
		function doNewPo(){
			var id="${back}";
			frm.action = "/picture/"+id+"/create2";
			frm.submit();
		}
	
		</script>
    </body>
</html>

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
							创建 </a>
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
											创建相册
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
										</div>
									</div>
									<div class="portlet-body form">
										<form id="frm" action="<c:url value='/picture/${back}/doCreateAlbum1'/>" class="form-horizontal" enctype="multipart/form-data" method="post">
											<input type="hidden" name="type" id="type" value=""/>
  											<input type="hidden" name="fileName" id="fileName" value=""/>
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label"><i style="color:red;margin-right:5px;">*</i>相册名称：</label>
															<div class="controls">
																<input type="text" id="name" name="name" value="" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="form-group">
															<label class="control-label">描述：</label>
															<div class="controls">
																<textarea name="summary" id="summary" class="form-control col-md-12">${retreat.deadReason}</textarea>
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
		</form>
		<script>
		$(function(){
			$('.wzbtn').click(function(){
				var name=$("#name").val();
				if(name==""){
					alert("相册名不能为空");
					return false;
				}
			});
		});
		//返回上级
		function doBackUp(){
			var id="${back}";
			frm.action = "/picture/"+id+"/back";
			frm.submit();
		}
		</script>
    </body>
</html>

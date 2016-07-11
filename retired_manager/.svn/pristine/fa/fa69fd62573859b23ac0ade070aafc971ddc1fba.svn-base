<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="xxs" tagdir="/WEB-INF/tags" %>
<html>
	<head>
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.js"></script>
	
	<script type="text/javascript" src="${request.contextPath}/defaults/js/bootstrap-typeahead.js"></script>
	</head>
	<body>
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<ul class="page-breadcrumb breadcrumb">
							<li>
								<i class="fa fa-home"></i>
								<a href="${request.contextPath}/retireactother/">
								首页 </a>
								<i class="fa fa-angle-right"></i>
							</li>
							<li>
								<a href="${request.contextPath}/retireactother/">
								其它活动信息</a>
								<i class="fa fa-angle-right"></i>
							</li>
							<li>
								<a href="${request.contextPath}/retireactother/">
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
									信息添加
								</div>
								<div class="tools">
									<a href="javascript:;" class="collapse">
									</a>
								</div>
							</div>
							<div class="portlet-body form">
								<form id="frm" action="<c:url value='${request.contextPath}/retireactother/save'/>" class="form-horizontal" method="post">
									<input type="hidden" name="cyry" id="cyry" value="${t.cyry}"/>
									<div class="form-body">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动名称：</label>
													<div class="controls">
														<input type="text" style="width:95%;" id="name" name="name" value="${p.name}" class="form-control col-md-12"/>
													</div>
												</div>
											</div>
											
											
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label">活动地点：</label>
													<div class="controls">
														<input type="text" style="width:95%;" id="hddd" name="hddd" value="${p.hddd}" class="form-control col-md-12"/>
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label"><i style="color:red;margin-right:5px;">*</i>负责人：</label>
													<div class="controls">
														<input style="width:95%;" type="text" id="fzr" name="fzr" value="${p.fzr}" class="form-control col-md-12"/>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
                                                      <div class="form-group">
													<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动时间起：</label>
													<div class="controls">
														<input style="width:95%;" type="text" id="hdsj" name="hdsj" value="${p.hdsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
													</div>
												</div>
											</div>
											<div class="col-md-4">
                                                      <div class="form-group">
													<label class="control-label"><i style="color:red;margin-right:5px;">*</i>活动时间止：</label>
													<div class="controls">
														<input style="width:95%;" type="text" id="hdsjjz" name="hdsjjz" value="${p.hdsjjz}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label"><i style="color:red;margin-right:5px;">*</i>负责人联系电话：</label>
													<div class="controls">
														<input style="width:95%;" type="text" id="fzrlxdh" name="fzrlxdh" value="${p.fzrlxdh}" class="form-control col-md-12"/>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											
										</div>
										
										
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label class="control-label"><a href="#showdetail" id="approve1" class="black" data-toggle="modal">参与人员：</a></label>
													<div class="controls" >
														<a href="#showdetail" id="approve1" class="black" data-toggle="modal"><input type="text" id="cyrys" name="cyrys" value="${p.cyrys}" class="form-control col-md-12" style="width:95%;" readonly></a>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label class="control-label">说明：</label>
													<div class="controls">
														<textarea name="bz" class="form-control col-md-12" style="width:95%;">${p.bz}</textarea>
													</div>
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label class="control-label">活动正文：</label>
													<div class="controls">
														<textarea id="content" name="content" style="height:300px;visibility:hidden;">${p.content}</textarea>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label class="control-label">封页图片：</label>
													<div class="controls" id="siteWebLog">
														<input type="hidden" id="siteWebLogName" value="imgurl" />
	    												<xxs:commonupload id="siteWebLog" uploadType="1" type="1" name="imgurl" fileTypes="*.jpg;*.gif;*.png" sizeLimit="10 MB" srcImg="${meeting.imgurl}" showText="true" styleClass="text_4" />
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
		<!-- 选择人员 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:530px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		  <jsp:include page="_choice.jsp"/>
		</div>
		<script>
		$(function(){
			$('.wzbtn').click(function(){
				if($('#name').val() == ""){
					alert("活动名称不能为空");
					$('#name').focus();
					return false;
				}
				if($('#hdsj').val() == ""){
					alert("请输入活动开始时间");
					$('#hdsj').focus();
					return false;
				}
				if($('#hdsjjz').val() == ""){
					alert("请输入活动结束时间");
					$('#hdsjjz').focus();
					return false;
				}
				if($('#fzr').val() == ""){
					alert("负责人不能为空!");
					$('#fzr').focus();
					return false;
				}
				if($('#fzrlxdh').val() == ""){
					alert("负责人电话不能为空!");
					$('#fzrlxdh').focus();
					return false;
				}
			});
		});
		
		KindEditor.ready(function(K) {
			var editor1 = K
					.create(
							'textarea[name="content"]',
							{
								cssPath : '${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.css',
								uploadJson : '${request.contextPath}/retirenotice/ajaxupload',//上传图片时用
								allowUpload : true,
								urlType : 'relative',
								items : [ //配置工具栏
								'fontname', 'fontsize', '|', 'forecolor',
										'hilitecolor', 'bold', 'italic',
										'underline', 'removeformat', '|',
										'justifyleft', 'justifycenter',
										'justifyright', 'insertorderedlist',
										'insertunorderedlist', '|', 'emoticons', 'image',
										'link', 'wordpaste','clearhtml' ],

								afterCreate : function() {
									var self = this;
									K.ctrl(document, 13, function() {
										self.sync();
									});
									K.ctrl(self.edit.doc, 13, function() {
										self.sync();
									});
								}
							});
							prettyPrint();

			});
		</script>
	</body>
</html>
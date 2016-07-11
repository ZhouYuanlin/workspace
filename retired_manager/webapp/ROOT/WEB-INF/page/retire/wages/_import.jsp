<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    <h3>导入工资</h3>
  </div>
  <div class="modal-body">
	<div class="form-body">
		<div class="row">
			<div class="col-md-8">
				<div class="form-group">
					<label class="control-label">导入财统工资：</label>
					<div class="controls">
						<input type="file" id="RetwageFile" name="RetwageFile" ref="财统工资文件" class="form-control col-md-12"/>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label">
						<a href="javascript:doDown('ctgz');">--下载模板--</a>
					</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="form-group">
					<label class="control-label">导入本级津补贴：</label>
					<div class="controls">
						<input type="file" id="RetiresubsidyFile" name="RetiresubsidyFile" class="form-control col-md-12"/>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label">
						<a href="javascript:doDown('bjjbt');">--下载模板--</a>
					</label>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button class="btn blue mgr10 expdata" >导入</button>
		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	</div>
	</div>
<script>
	$(function(){
		$('.expdata').click(function(){
			if(document.getElementById("RetwageFile").value==""&&document.getElementById("RetiresubsidyFile").value==""){
				alert("您未选中文件！");
				return false;
			}
			$("#frm").attr("enctype","multipart/form-data");
			$('#frm').attr('action','${request.contextPath}/retwages/export').submit();
		});
	});
	//下载模板
	function doDown(str)
	{
		$('#frm').attr('method','post').attr('action','/retment/download?xzmob='+str).submit();
	}
</script>
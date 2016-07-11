<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><i style="color:red;margin-right:5px;">*</i>身份证号：</label>
			<div class="controls">
				<input type="text" id="sfzh" name="sfzh" value="${r.ret.sfzh}" class="form-control col-md-12"/>
			</div>
		</div>
	</div>
	<div class="col-md-4">
                                            <div class="form-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<p class="c-text" id="xm"></p>
			</div>
		</div>
	</div>
	<div class="col-md-4">
                                            <div class="form-group">
			<label class="control-label">性别：</label>
			<div class="controls">
				<p class="c-text" id="xb"></p>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-4">
                                            <div class="form-group">
			<label class="control-label">原工作单位：</label>
			<div class="controls">
				<p class="c-text" id="dwb"></p>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label">民族：</label>
			<div class="controls">
				<p class="c-text" id="mzb"></p>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label">类型：</label>
			<div class="controls">
				<p class="c-text" id="lxb"></p>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	$("#sfzh").blur(function(){
		if($("#sfzh").val() != ""){
			$(".btn").removeAttr("disabled");
			$.get("/retwork/beforeFind?"+new Date().getTime(),{sfzh:$("#sfzh").val()},function(data) {
		  		if(data != ""){
		  			alert('根据身份证号未找到退休人员！');
		  			$("#sfzh").focus();
		  			$("#sfzh").val("");
		  			$("#xm").text("");
					$("#xb").text("");
					$("#dwb").text("");
					$("#mzb").text("");
					$("#lxb").text("");
					$("#dfjs").val("");
		  			$("#save").attr({"disabled":"disabled"});
		  		}else{
		  			$.post("/retwork/querybysfzh/json?"+(new Date()).getTime(),{sfzh:$("#sfzh").val()},function(d){
						$.each($.parseJSON(d),function(i,e){
							$("#sfzh").text(e.sfzh);
							$("#xm").text(e.xm);
							$("#xb").text(e.xb);
							$("#dwb").text(e.dwb);
							$("#mzb").text(e.mzb);
							$("#lxb").text(e.lxb);
							$("#dfjs").val(e.dfjs);
							$("#party").text(e.party);
						});
					});
				}
			});
		};
	});
});
</script>
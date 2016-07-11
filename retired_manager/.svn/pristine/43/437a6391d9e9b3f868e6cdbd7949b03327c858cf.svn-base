<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="row">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><i
				style="color: red; margin-right: 5px;">*</i>身份证号：</label>
			<div class="controls">
				<input type="text" id="sfzh" name="sfzh"
					class="form-control col-md-12" />
					<input type="hidden" id="xms" name='xm'>
					<input type="hidden" id="xbs" name='xb'>
					<input type="hidden" id="dwbs" name='dwb.id'>
					<input type="hidden" id="mzbs" name='mzb.id'>
					<input type="hidden" id="lxbs" name='lxb.id'>
			</div>
		</div>
	</div>
	<!-- 	<div class="col-md-4">
                                            <div class="form-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<p class="c-text" id="xm"></p>
			</div>
		</div>
	</div> -->
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><a href="#showdetail"
				id="approve1" onclick="sele();" class="black" data-toggle="modal">姓名：</a></label>
			<div class="controls">
				<a href="#showdetail" id="approve1" onclick="sele();" class="black"
					data-toggle="modal"><input type="text" id="xm"
					value="${r.ret.xm}" class="form-control col-md-12" readonly></a>
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
<!-- 选择人员 -->
<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:570px;margin-left:50%;margin-left:-275px;margin-top:50px;">
 	<jsp:include page="_choice.jsp"/><!-- ../activ/oldun/ -->
</div>
<script>
	$(function() {
		$("#sfzh").blur(
				function() {
					if ($("#sfzh").val() != "") {
						$('.wzbtn').removeAttr("disabled");
						$.get("/retwork/beforeFind?" + new Date().getTime(), {
							sfzh : $("#sfzh").val()
						}, function(data) {
							if (data != "") {
								alert('根据身份证号未找到退休人员！');
								$("#sfzh").focus();
								$("#sfzh").val("");
								$("#xm").val("");
								$("#xb").text("");
								$("#dwb").text("");
								$("#mzb").text("");
								$("#lxb").text("");
								$("#dfjs").val("");
								$("#lxdh").val("");
								$("#save").attr({
									"disabled" : "disabled"
								});
							} else {
								$.post("/retwork/querybysfzh/json?"
										+ (new Date()).getTime(), {
									sfzh : $("#sfzh").val()
								}, function(d) {
									$.each($.parseJSON(d), function(i, e) {
										$("#sfzh").text(e.sfzh);
										$("#xm").val(e.xm);
										$("#xb").text(e.xb);
										$("#dwb").text(e.dwb);
										$("#mzb").text(e.mzb);
										$("#lxb").text(e.lxb);
										$("#dfjs").val(e.dfjs);
										$("#lxdh").val(e.lxdh);
										$("#party").text(e.party);
									});
								});
								$.post("/retdeath/querybysfzh/json?"
										+ (new Date()).getTime(), {
									sfzh : $("#sfzh").val()
								}, function(d) {
									$.each($.parseJSON(d), function(i, e) {
										$("#sfzh").val(e.sfzh);
										$("#xms").val(e.xm);
										$("#xbs").val(e.xb);
										$("#dwbs").val(e.dwb);
										$("#mzbs").val(e.mzb);
										$("#lxbs").val(e.lxb);
									});
								});
							}
						});
					}
					;
				});
	});

	
</script>
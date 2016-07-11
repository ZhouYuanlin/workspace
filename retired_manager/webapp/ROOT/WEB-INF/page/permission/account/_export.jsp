<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    <h3>自定义导出</h3>
  </div>
  <div class="modal-body">
	<div class="form-body">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="row">
					<div class="row">
						<div class="col-md-16">
							<div class="form-group">
								<div class="controls">
									<div class="row">
										<div class="btn-group btn-group-custom" data-toggle="buttons">
											<label class="btn active">
												<input name="list[0].gzzh" checked="checked" value="username" type="checkbox">身份证号
												<input name="list[0].lxdh" value="身份证号" type="hidden">
											</label>
											<label class="btn active">
												<input name="list[1].gzzh" checked="checked" value="realname" type="checkbox">姓名
												<input name="list[1].lxdh" value="姓名" type="hidden">
											</label>
											<label class="btn">
												<input name="list[2].gzzh" checked="checked" value="status" type="checkbox">性别
												<input name="list[2].lxdh" value="性别" type="hidden">
											</label>
											<label class="btn">
												<input name="list[3].gzzh" value="gzzh" type="checkbox">工作证号
												<input name="list[3].lxdh" value="工作证号" type="hidden">
											</label>
											<label class="btn">
												<input name="list[5].gzzh" value="lxdh" type="checkbox">
												联系电话
												<input name="list[5].lxdh" value="联系电话" type="hidden">
											</label>
											<label class="btn">
												<input name="list[6].gzzh" value="dqsj" type="checkbox">
												用户到期时间
												<input name="list[6].lxdh" value="用户到期时间" type="hidden">
											</label>
											<label class="btn active">
												<input name="list[7].gzzh" value="roles[0].name" type="checkbox">
												用户角色
												<input name="list[7].lxdh" value="用户角色" type="hidden">
											</label>
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
	<div class="modal-footer">
		<button class="btn blue mgr10 expdata" >导出</button>
		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	</div>
	</div>
<script>
	$(function(){
		$('.expdata').click(function(){
			$('#frm').attr('action','${request.contextPath}/account/UserExport').submit();
		});
	});
</script>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    <h3>工资详情</h3>
  </div>
  <div class="modal-body" style="height:500px;">
	<div class="portlet box grey">
		<div class="portlet-title" ref="form0">
			<div class="caption">
				基本信息
			</div>
			<div class="tools">
				<!-- 
					<i class="fa fa-chevron-circle-down Iform0" style="font-size:28px;"></i>
				 -->
				<a href="javascript:;" class="collapse">
				</a>
			</div>
		</div>
		<div class="portlet-body form form0">
			<div class="form-body">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">姓名：</label>
							<div class="controls">
								<p class="c-text">${retDetails.xm }</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">身份证号码：</label>
							<div class="controls">
								<p class="c-text">${retDetails.sfzh }</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">发放月份：</label>
							<div class="controls">
								<p class="c-text">
									<c:if test="${empty retDetails.yf}">${retDetails.bjjbt.ffyf }</c:if>
									<c:if test="${!empty retDetails.yf}">${retDetails.yf}</c:if>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-6" style="">
						<div class="form-group">
							<label class="control-label">总计：</label>
							<div class="controls">
								<p class="c-text">
									${retDetails.sfxj+retDetails.bjjbt.sfgz}(元)
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portlet box grey">
		<div class="portlet-title" ref="form1">
			<div class="caption">
				财统工资&nbsp;&nbsp;<c:if test="${empty retDetails.sfxj}">(暂未发放)</c:if>
			</div>
			${retDetails.ffsj }
			<div class="tools">
			<!-- 
				<i class="fa fa-chevron-circle-down Iform1" style="font-size:28px;"></i>
			 -->
			 	
				<a href="javascript:;" class="collapse">
				</a>
			</div>
		</div>
		<div class="portlet-body form form1">
			<div class="form-body">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">离退休费：</label>
							<div class="controls">
								<p class="c-text">${retDetails.ltxf }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">生活补：</label>
							<div class="controls">
								<p class="c-text">${retDetails.shb }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">交通：</label>
							<div class="controls">
								<p class="c-text">${retDetails.jt }</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">在京补：</label>
							<div class="controls">
								<p class="c-text">${retDetails.zjb }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">电话：</label>
							<div class="controls">
								<p class="c-text">${retDetails.dhb}</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">书报费：</label>
							<div class="controls">
								<p class="c-text">${retDetails.sbf }</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">洗理：</label>
							<div class="controls">
								<p class="c-text">${retDetails.xl }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">护理：</label>
							<div class="controls">
								<p class="c-text">${retDetails.hl }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">自雇费：</label>
							<div class="controls">
								<p class="c-text">${retDetails.zgf }</p>
							</div>
						</div>
					</div>
					
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">其他：</label>
							<div class="controls">
								<p class="c-text">${retDetails.qt }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">其他补贴：</label>
							<div class="controls">
								<p class="c-text">${retDetails.qtbt }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">补工资：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bgz }</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">应发小计：</label>
							<div class="controls">
								<p class="c-text">${retDetails.yfxj }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">扣款小计：</label>
							<div class="controls">
								<p class="c-text">${retDetails.gkxj }</p>
							</div>
						</div>
					</div>
					
				</div>
				<div class="row" style="font-size:20px;">
					<div class="col-md-4" style="left: 537px;">
						<div class="form-group">
							<label class="control-label">实发小计：</label>
							<div class="controls">
								<p class="c-text">
									<c:if test="${!empty retDetails.sfxj}">
										${retDetails.sfxj }(元)
									</c:if>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portlet box grey">
		<div class="portlet-title" ref="form2">
			<div class="caption">
				本级津补&nbsp;&nbsp;
			</div>
			<c:if test="${empty retDetails.bjjbt.sfgz}">(暂未发放)</c:if>
			${retDetails.bjjbt.ffsj }
			<div class="tools">
				<!-- 
					<i class="fa fa-chevron-circle-down Iform2" style="font-size:28px;"></i>
				 -->
				 
				<a href="javascript:;" class="collapse">
				</a>
			</div>
		</div>
		<div class="portlet-body form form2">
			<div class="form-body">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">离休补贴：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.lxbt }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">物业补贴：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.lxbt }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">班车补贴：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.bcbt }</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">提租补贴：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.tzbt }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">适当补贴：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.sdbt }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">特贴：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.tt }</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">未休养：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.wxy }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">应发合计：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.yfhj }</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">代汇：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.dh }</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">扣款合计：</label>
							<div class="controls">
								<p class="c-text">${retDetails.bjjbt.kkhj }</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row"  style="font-size:20px;">
					<div class="col-md-4" style="left:537px;">
						<div class="form-group">
							<label class="control-label">实发工资：</label>
							<div class="controls">
								<p class="c-text">
									<c:if test="${!empty retDetails.bjjbt.sfgz}">
										${retDetails.bjjbt.sfgz }(元)
									</c:if>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	</div>
 </div>
<script>
	$(function(){
		$('.expdata').click(function(){
			if(document.getElementById("RetwageFile").value==""&&document.getElementById("RetiresubsidyFile").value==""){
				alert("您未选中文件！");
				return false;
			}
			//alert("导入成功！！！");
			//return false;
			$('#frm').attr('action','${request.contextPath}/retwages/export').submit();
		});
		$(".portlet-title").click(function(){
			//ShowOrHide($("."+$(this).attr("ref")).get(0),"I"+$(this).attr("ref"));
		});
	});
	//下载模板
	function doDown(str)
	{
		$('#frm').attr('method','post').attr('action','/retment/download?xzmob='+str).submit();
	}
	function ShowOrHide(MyDiv,iName)//展开&收缩
	{
		if(MyDiv.style.display!="none")
		{
			$(MyDiv).slideUp("slow"); 
			$("."+iName).attr("class","fa fa-chevron-circle-left "+iName);
		}
		else{
			$("."+iName).attr("class","fa fa-chevron-circle-down "+iName);
			$(MyDiv).slideDown("slow"); 
		}
	}
</script>
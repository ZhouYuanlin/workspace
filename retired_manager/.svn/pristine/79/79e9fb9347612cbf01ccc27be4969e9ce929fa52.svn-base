<%@page import="cn.uuf.contants.Constants"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<script type="text/javascript" src="${request.contextPath}/defaults/js/bootstrap-typeahead.js"></script>
	<body>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${request.contextPath}/retwages/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="${request.contextPath}/retwages/">
							工资管理</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${request.contextPath}/retwages/">
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
							<form id="frm" action="<c:url value='${request.contextPath}/retwages/modify'/>" class="form-horizontal" method="post">
								<input type="hidden" name="sfzhs" id="sfzhs"/>
								<div class="form-body">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label"><i style="color:red;margin-right:5px;">*</i>姓名：</label>
												<div class="controls">
													<input type="text" id="xm" name="xm" value="${r.xm }" class="form-control col-md-12" name="r.xm" readonly>
													<input type="hidden" name="id" value="${r.id }"/>
													<input type="hidden" name="sfzh" value="${r.sfzh }"/>
												</div>
											</div>
										</div>
										
										<div class="col-md-4">
                                            <div class="form-group">
												<label class="control-label">离退休费：</label>
												<div class="controls">
													<input type="text" id="ltxf" value="${ r.ltxf}" name="ltxf" ref="离退休费" class="form-control col-md-12 digital"/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">生活补：</label>
												<div class="controls">
													<input type="text" name="shb" value="${ r.shb}" ref="生活补" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">交通：</label>
												<div class="controls">
													<input type="text" name="jt" value="${ r.jt}" ref="交通" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">在京补：</label>
												<div class="controls">
													<input type="text" name="zjb" value="${ r.zjb}" ref="在京补" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">电话补助：</label>
												<div class="controls">
													<input type="dhb" name="dhb" ref="电话补助" value="${r.dhb}" id="dhb" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">书报费：</label>
												<div class="controls">
													<input type="text" name="sbf" value="${ r.sbf}" ref="书报费" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">洗理费：</label>
												<div class="controls">
													<input type="text" name="xl" value="${ r.xl}" ref="洗理费" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">护理费：</label>
												<div class="controls">
													<input type="text" name="hl" value="${ r.hl}" ref="护理费" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">自雇费：</label>
												<div class="controls">
													<input type="text" name="zgf" value="${ r.zgf}" ref="自雇费" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">其他费用：</label>
												<div class="controls">
													<input type="text" name="qt" value="${ r.qt}" ref="其他费用" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">其他补贴：</label>
												<div class="controls">
													<input type="text" name="qtbt" value="${ r.qtbt}" ref="其他补贴" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">补工资：</label>
												<div class="controls">
													<input type="text" name="bgz" value="${ r.bgz}" ref="补工资" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">应发小计：</label>
												<div class="controls">
													<input type="text" id="yfxj" value="${ r.yfxj}" ref="应发小计" name="yfxj" class="form-control col-md-12 digital"/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">扣款小计：</label>
												<div class="controls">
													<input type="text" id="gkxj" name="gkxj" ref="扣款小计" value="${ r.gkxj}" class="form-control col-md-12 digital"/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">发放时间：</label>
												<div class="controls">
													<input type="text" id="ffsj" onchange="isOnChange(this,'bffsj')" name="ffsj" value="${ r.ffsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">发放月份：</label>
												<div class="controls">
													<input type="text" id="yf" onchange="isOnChange(this,'ffyf')" name="yf" value="${ r.yf}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm" size="16" readonly/>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label"><i style="color:red;margin-right:5px;">*</i>实发小计：</label>
												<div class="controls">
													<input type="text" id="sfxj" value="${ r.sfxj}" name="sfxj" ref="实发小计" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label">是否<c:if test="${!empty r.bjjbt}">修改津补贴额度</c:if><c:if test="${empty r.bjjbt}">发放津补贴</c:if>：
												</label>
												<div class="controls">
													<input type="radio" name="YesOrNobfbt" style="margin-top: 9px;margin-left: 100px;" checked="checked" value="true"/>是
													<input type="radio" name="YesOrNobfbt" style="margin-left: 100px;" value="false"/>否
												</div>
											</div>
										</div>
									</div>
									<div id="showJBT" style="display:none;">
										<div class="row">
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">离休补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.lxbt" value="${ r.bjjbt.lxbt}" ref="离休补贴" class="form-control col-md-12 digital">
														<input type="hidden" name="bjjbt.id" value="${r.bjjbt.id }"/>
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">物业补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.wybt" value="${ r.bjjbt.wybt}" ref="物业补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">班车补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.bcbt" value="${ r.bjjbt.bcbt}" ref="班车补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">提租补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.tzbt" value="${ r.bjjbt.tzbt}" ref="提租补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">适当补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.sdbt" value="${ r.bjjbt.sdbt}" ref="适当补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">特贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.tt" value="${ r.bjjbt.tt}" ref="特贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">未休养补：</label>
													<div class="controls">
														<input type="text" name="bjjbt.wxy" value="${ r.bjjbt.wxy}" ref="未休养补" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">代汇补：</label>
													<div class="controls">
														<input type="text" name="bjjbt.dh" value="${ r.bjjbt.dh}" ref="代汇" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">应发合计：</label>
													<div class="controls">
														<input type="text" id="yfhj" name="bjjbt.yfhj" value="${ r.bjjbt.yfhj}" class="form-control col-md-12 digital"/>
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">扣款合计：</label>
													<div class="controls">
														<input type="text" id="kkhj" name="bjjbt.kkhj" value="${ r.bjjbt.kkhj}" class="form-control col-md-12 digital"/>
													</div>
												</div>
											</div>
											<!-- 本级津补贴发放时间：本级津补贴发放月份 -->
											<input type="hidden" id="bffsj" name="bjjbt.ffsj" value="${ r.bjjbt.ffsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
											<input type="hidden" id="ffyf" name="bjjbt.ffyf" value="${ r.bjjbt.ffyf}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm" size="16" readonly/>
										</div>
										
											<div class="col-md-12">
	                                           <div class="form-group">
													<label class="control-label"><i style="color:red;margin-right:5px;">*</i>实发津补贴数额：</label>
													<div class="controls">
														<input type="text" id="sfgz" name="bjjbt.sfgz" value="${ r.bjjbt.sfgz}" ref="实际津补贴发放数额" class="form-control col-md-12">
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
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:550px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		 	<jsp:include page="../../beInCommon/_choice.jsp"/><!-- ../activ/oldun/ -->
		</div>
		<script>
		var reg = /^[\d|\.]+$/;//判断数字
		var $sfxs=false;
		function isOnChange(this_,id)//改变时间
		{
			$("#"+id).val(this_.value);
			//alert(this_.value);
		}
		$(function(){
			$(".wzbtn").click(function(){
				
				
				if($('#xm').val() == ""){//姓名的非空验证
					alert("请选择工资方法的对象");
					return false;
				}
				

				if($('#sfxj').val() == "" || !reg.test($('#sfxj').val())){
					alert("实际发放金额为数字，请检查");
					//$("#sfxj").focus();
					return false;
				}
				if($sfxs && ($('#sfgz').val() == "" || !reg.test($('#sfgz').val()))){
					alert("实际发放的津贴补金额为数字，请检查");
					$("#sfgz").focus();
					return false;
				}
				
				$('#frm').attr("action","${request.contextPath}/retwages/modify").submit();
				
				//alert("判断结束");
				//return false;
			});
			
			$("input[name='YesOrNobfbt']").change(function(){//单选按钮的改变事件
				/*if($(this).val()=="true")
				{
					$("#showJBT").slideDown("slow"); 
					$sfxs=true;
				}
				else{
					$("#showJBT").slideUp("slow"); 
					$sfxs=false;
				}*/
				isShow(this);
			});
			$(".digital").blur(function(){
				var allvar=$(".digital");
				var str="";
				var yfxj=0,gkxj=0,yfhj=0,kkhj=0;
				for(var temp in allvar)
				{
					str=allvar[temp].value;
					if(str!= ""&&str!=undefined&&!reg.test(str))
					{
						alert($(allvar[temp]).attr("ref")+"必须为数字！");
						$(allvar[temp]).val("");
					}
					if(str!= ""&&reg.test(str))
					{
						switch(allvar[temp].name)
						{
							case "ltxf":
							case "shb":
							case "jt":
							case "zjb":
							case "qtbt":
							case "bgz":
								yfxj+=parseFloat(str);
								break;
							case "sbf":
							case "xl":
							case "hl":
							case "zgf":
							case "qt":
								gkxj+=parseFloat(str);
								break;
							case "bjjbt.lxbt":
							case "bjjbt.wybt":
							case "bjjbt.bcbt":
							case "bjjbt.tzbt":
							case "bjjbt.sdbt":
							case "bjjbt.tt":
							case "bjjbt.wxy":
							case "bjjbt.dh":
								yfhj+=parseFloat(str);
								break;
						}
					}
				}
				/*$("#yfxj").val(yfxj);
				$("#gkxj").val(gkxj);
				$("#yfhj").val(yfhj);
				$("#kkhj").val(kkhj);
				var temp=yfxj-gkxj;
				if(temp>=0){
					$("#sfxj").val(temp);
				}
				var temp1=yfhj-kkhj;
				if(temp1>=0){
					$("#sfgz").val(temp1);
				}*/
			});
		});
		
		function isShow(or)
		{
			if($(or).val()=="true")
			{
				$("#showJBT").slideDown("slow"); 
				$sfxs=true;
			}
			else{
				$("#showJBT").slideUp("slow"); 
				$sfxs=false;
			}
		}
		function isGetNowDay()//得到当前的日期
		{
			var myDate = new Date();
			var month="",data="";
			if(myDate.getMonth()+1<10){
				month="0"+(myDate.getMonth()+1);
			}
			else{
				month=myDate.getMonth()+1;
			}
			if(myDate.getDate()<10){
				data="0"+myDate.getDate();
			}
			else{
				data=myDate.getDate();
			}
			return myDate.getFullYear()+"-"+month+"-"+data;
		}
		function isOnLoad()//加载时默认的日期
		{

			isShow($("input[name='YesOrNobfbt']"));
			//document.getElementById("yf").value=isGetNowDay();
			//document.getElementById("ffsj").value=isGetNowDay();
		}
		isOnLoad();
		</script>
	</body>
</html>
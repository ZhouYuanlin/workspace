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
							<form id="frm" action="<c:url value='${request.contextPath}/retwages/save'/>" class="form-horizontal" method="post">
								<input type="hidden" name="sfzhs" id="sfzhs"/>
								<div class="form-body">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label"><a href="#showdetail"
													id="approve1" onclick="sele();" class="black" data-toggle="modal"><i style="color:red;margin-right:5px;">*</i>姓名：</a></label>
												<div class="controls">
													<a href="#showdetail" id="approve1" onclick="sele();" class="black" data-toggle="modal">
														<input type="text" id="xm" name="xm" value="${r.ret.xm}" class="form-control col-md-12" name="r.xm" readonly>
														<input type="hidden" id="sfzh" name="sfzh"/>
													</a>
												</div>
											</div>
										</div>
										
										<div class="col-md-4">
                                            <div class="form-group">
												<label class="control-label">离退休费：</label>
												<div class="controls">
													<input type="text" id="ltxf" name="ltxf" ref="离退休费" class="form-control col-md-12 digital"/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">生活补：</label>
												<div class="controls">
													<input type="text" name="shb" ref="生活补" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">交通补：</label>
												<div class="controls">
													<input type="text" name="jt" ref="交通" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">在京补：</label>
												<div class="controls">
													<input type="text" name="zjb" ref="在京补" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">电话补助：</label>
												<div class="controls">
													<input type="text" name="dhb" id="dhb" ref="电话补助" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">书报费：</label>
												<div class="controls">
													<input type="text" name="sbf" ref="书报费" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">洗理费：</label>
												<div class="controls">
													<input type="text" name="xl" ref="洗理费" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">护理费：</label>
												<div class="controls">
													<input type="text" name="hl" ref="护理费" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">自雇费：</label>
												<div class="controls">
													<input type="text" name="zgf" ref="自雇费" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">其他费用：</label>
												<div class="controls">
													<input type="text" name="qt" ref="其他费用" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">其他补贴：</label>
												<div class="controls">
													<input type="text" name="qtbt" ref="其他补贴" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">补工资：</label>
												<div class="controls">
													<input type="text" name="bgz" ref="补工资" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">应发小计：</label>
												<div class="controls">
													<input type="text" id="yfxj" name="yfxj" ref="应发小计"  class="form-control col-md-12 digital"/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">扣款小计：</label>
												<div class="controls">
													<input type="text" id="gkxj" name="gkxj" ref="扣款小计" class="form-control col-md-12 digital"/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">发放时间：</label>
												<div class="controls">
													<input type="text" id="ffsj" onchange="isOnChange(this,'bffsj')" name="ffsj" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
												</div>
											</div>
										</div>
										<div class="col-md-4">
                                           <div class="form-group">
												<label class="control-label">发放月份：</label>
												<div class="controls">
													<input type="text" id="yf" name="yf" onchange="isOnChange(this,'ffyf')" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm" size="16" readonly/>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label"><i style="color:red;margin-right:5px;">*</i>实发小计：</label>
												<div class="controls">
													<input type="text" id="sfxj" name="sfxj" ref="实发小计" class="form-control col-md-12 digital">
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label">是否同时发放津补贴：</label>
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
														<input type="text" name="bjjbt.lxbt" ref="离休补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">物业补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.wybt" ref="物业补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">班车补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.bcbt" ref="班车补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">提租补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.tzbt" ref="提租补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">适当补贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.sdbt" ref="适当补贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">特贴：</label>
													<div class="controls">
														<input type="text" name="bjjbt.tt" ref="特贴" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">未休养补：</label>
													<div class="controls">
														<input type="text" name="bjjbt.wxy" ref="未休养补" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">代汇补：</label>
													<div class="controls">
														<input type="text" name="bjjbt.dh" ref="代汇" class="form-control col-md-12 digital">
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">应发合计：</label>
													<div class="controls">
														<input type="text" id="yfhj" name="bjjbt.yfhj" ref="应发合计" class="form-control col-md-12 digital"/>
													</div>
												</div>
											</div>
											<div class="col-md-4">
	                                           <div class="form-group">
													<label class="control-label">扣款合计：</label>
													<div class="controls">
														<input type="text" id="kkhj" name="bjjbt.kkhj" ref="扣款合计" class="form-control col-md-12 digital"/>
													</div>
												</div>
											</div>
											<!-- 本级津补贴发放时间 及 本级津补贴发放月份 -->
											<input type="hidden" id="bffsj" name="bjjbt.ffsj" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
											<input type="hidden" id="ffyf" name="bjjbt.ffyf" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm" size="16" readonly/>
										</div>
											<div class="col-md-12">
	                                           <div class="form-group">
													<label class="control-label"><i style="color:red;margin-right:5px;">*</i>实发津补贴数额：</label>
													<div class="controls">
														<input type="text" id="sfgz" name="bjjbt.sfgz" ref="实际津补贴发放数额" class="form-control col-md-12">
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
		<!-- 查看详情
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:550px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		  <jsp:include page="_choice.jsp"/>
		</div> -->
		
		<!-- 选择人员 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:570px;margin-left:50%;margin-left:-275px;margin-top:50px;">
		 	<jsp:include page="../../beInCommon/_choice.jsp"/><!-- ../activ/oldun/ -->
		</div>
		<script>
		var reg = /^[\d|\.]+$/;//判断数字
		var $sfxs=false;
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
				
				$('#frm').attr("action","${request.contextPath}/retwages/save").submit();
				
				//alert("判断结束");
				//return false;
			});
			
			$("input[name='YesOrNobfbt']").change(function(){//单选按钮的改变事件
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
							case "dhb":
							case "bgz":
							case "sbf":
							case "xl":
							case "hl":
							case "zgf":
							case "qt":
								yfxj+=parseFloat(str);
								break;
							/*case "sbf":
							case "xl":
							case "hl":
							case "zgf":
							case "qt":
								gkxj+=parseFloat(str);
								break;*/
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
		
		function isOnChange(this_,id)//改变时间
		{
			$("#"+id).val(this_.value);
			//alert(this_.value);
		}
		
		function isShow(or)//是否显示
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
		
		function isGetMothe()//得到当前的月份
		{
			var myDate = new Date();
			var month="";
			if(myDate.getMonth()+1<10){
				month="0"+(myDate.getMonth()+1);
			}
			else{
				month=myDate.getMonth()+1;
			}
			return myDate.getFullYear()+"-"+month;
		}
		
		function isGetNowDay()//得到当前的日期
		{
			var myDate = new Date();
			var data="";
			if(myDate.getDate()<10){
				data="0"+myDate.getDate();
			}
			else{
				data=myDate.getDate();
			}
			return isGetMothe()+"-"+data;
		}
		function isOnLoad()//加载时默认的日期
		{

			isShow($("input[name='YesOrNobfbt']"));
			document.getElementById("yf").value=isGetMothe();
			document.getElementById("ffyf").value=isGetMothe();
			document.getElementById("ffsj").value=isGetNowDay();
			document.getElementById("bffsj").value=isGetNowDay();
		}
		 isOnLoad();
		</script>
	</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="cn.uuf.contants.Constants"%>
<html>
	<head></head>
	<body>
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/defaults/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css"/>
	<link href="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet"/>
	<script src="${request.contextPath}/defaults/plugins/My97DatePicker/WdatePicker.js" type="text/javascript" ></script>
	<script type="text/javascript" src="${request.contextPath}/defaults/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
	<script src="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${request.contextPath}/defaults/js/kindeditor/plugins/code/prettify.js"></script>
	<form id="frm" action="<c:url value='${request.contextPath}/carApplyShow'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/carApplyShow">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/carApplyShow">
							车辆使用情况 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/carApplyShow">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
					<jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
                </div>
              </div>
              </div>
              <div class="row">
					<div class="col-md-12">
			        <div class="portlet box grey">
									<div class="portlet-body form">
										
											<div class="form-body">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">车牌号：</label>
															<div class="controls">
																<input type="text" id="carNumber" name="carNumber" value="${carNumber}" class="form-control col-md-12"/>
																<input type="hidden" id="times" name="times" value="">
																 <c:forEach items="${ls}" var="temp" varStatus="c" begin="0" end="0">
								                                     <c:forEach items="${temp}" var="map" begin="1" end="1">
																	       <c:forEach items="${map.value}" var="carlist">
																	          <input type="hidden" id="onclickState" name="onclickState" value=" ${carlist.useTime}">
																           </c:forEach>
																	 </c:forEach>
																</c:forEach>
																
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">司机：</label>
															<div class="controls">
																<input type="text" id="carDriver" name="carDriver" value="${carDriver}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<%-- <div class="col-md-4">
														<div class="form-group">
															<label class="control-label">时间：</label>
															<div class="controls">
																<select name="times"  id="times" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
										                            <option value="-1" <c:if test="${state == '-1'}">selected</c:if>>上周</option>
										                            <option value="0" <c:if test="${state == '0'}">selected</c:if>>本周</option>
										                            <option value="1" <c:if test="${state == '1'}">selected</c:if>>下周</option>
												             	</select>																
												           	</div>
														</div>
													</div> --%>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" class="btn blue mgr10 wzbtn" onClick="doSearch();"><i class="fa fa-search"></i> 查询 </button> <br>
														</div>
													</div>
													<div class="col-md-12">
														<div Style="margin-left: 0.8% ">
														<!-- margin-left: -530px -->
															<button Style="float:left " type="button" class="btn blue mgr10 wzbtn" onClick="doFront();"><i class="fa fa-search"></i> 上周 </button> 
															<button Style="float:right " type="button" class="btn blue mgr10 wzbtn" onClick="doNext();"><i class="fa fa-search"></i> 下周 </button> 
														</div>
													</div>
												</div>
											</div>
										
									</div>
								</div>  
					</div>
			  </div>
			  <div class="row">
					<div class="col-md-12">
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                	<th width="45" Style="text-align: center;"><b>序号</b></th>
                                    <th width="150" Style="text-align: center;"><b>车辆名称及型号</b></th>
                                     <c:forEach items="${ls}" var="temp" varStatus="c" begin="0" end="0">
	                                     <c:forEach items="${temp}" var="map" begin="0" end="0">
									          <c:forEach items="${map.value}" var="carlist" begin="0" end="0">
									          	  <th Style="text-align: center;">
									          	   <b><fmt:parseDate value="${carlist.useTime}" pattern="yyyy-MM-dd" var="receiveDate"></fmt:parseDate>
         										   <fmt:formatDate value="${receiveDate}" pattern="MM-dd" ></fmt:formatDate></b>
										          	 <b>(周日)</b>
										          </th>
									           </c:forEach>
									      </c:forEach>
										 <c:forEach items="${temp}" var="map" begin="2" end="2">
											   <c:forEach items="${map.value}" var="carlist" begin="0" end="0">
									          	  <th Style="text-align: center;">
									          	  <b> <fmt:parseDate value="${carlist.useTime}" pattern="yyyy-MM-dd" var="receiveDate"></fmt:parseDate>
         										   <fmt:formatDate value="${receiveDate}" pattern="MM-dd" ></fmt:formatDate></b>
										          	<b>(周二)</b>
										          </th>
									           </c:forEach>
										 </c:forEach>
										 <c:forEach items="${temp}" var="map" begin="3" end="3">
										  	   <c:forEach items="${map.value}" var="carlist" begin="0" end="0">
									          	  <th Style="text-align: center;">
									          	  <b> <fmt:parseDate value="${carlist.useTime}" pattern="yyyy-MM-dd" var="receiveDate"></fmt:parseDate>
         										   <fmt:formatDate value="${receiveDate}" pattern="MM-dd" ></fmt:formatDate></b>
										          	 <b>(周三)</b>
										          </th>
									           </c:forEach>
										 </c:forEach>
										 <c:forEach items="${temp}" var="map" begin="4" end="4">
										 	   <c:forEach items="${map.value}" var="carlist" begin="0" end="0">
									          	  <th Style="text-align: center;">
									          	   <b><fmt:parseDate value="${carlist.useTime}" pattern="yyyy-MM-dd" var="receiveDate"></fmt:parseDate>
         										   <fmt:formatDate value="${receiveDate}" pattern="MM-dd" ></fmt:formatDate></b>
										          	<b>(周四)</b>
										          </th>
									           </c:forEach>
										 </c:forEach>
										 <c:forEach items="${temp}" var="map" begin="5" end="5">
										       <c:forEach items="${map.value}" var="carlist" begin="0" end="0">
									          	  <th Style="text-align: center;">
									          	   <b><fmt:parseDate value="${carlist.useTime}" pattern="yyyy-MM-dd" var="receiveDate"></fmt:parseDate>
         										   <fmt:formatDate value="${receiveDate}" pattern="MM-dd" ></fmt:formatDate></b>
										          	 <b>(周五)</b>
										          </th>
									           </c:forEach>
										 </c:forEach>
										 <c:forEach items="${temp}" var="map" begin="6" end="6">
										       <c:forEach items="${map.value}" var="carlist" begin="0" end="0">
									          	  <th Style="text-align: center;">
									          	   <b><fmt:parseDate value="${carlist.useTime}" pattern="yyyy-MM-dd" var="receiveDate"></fmt:parseDate>
         										   <fmt:formatDate value="${receiveDate}" pattern="MM-dd" ></fmt:formatDate></b>
										          	 <b>(周六)</b>
										          </th>
									           </c:forEach>
										 </c:forEach>
										 <c:forEach items="${temp}" var="map" begin="7" end="7">
										       <c:forEach items="${map.value}" var="carlist" begin="0" end="0">
									          	  <th Style="text-align: center;">
									          	   <b><fmt:parseDate value="${carlist.useTime}" pattern="yyyy-MM-dd" var="receiveDate"></fmt:parseDate>
         										   <fmt:formatDate value="${receiveDate}" pattern="MM-dd" ></fmt:formatDate></b>
										          	<b>(周日)</b>
										          </th>
									           </c:forEach>
										 </c:forEach>
									</c:forEach>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${ls}" var="temp" varStatus="c">
                                	 <tr class="odd gradeX">
                                	 	  <td Style="text-align: center;vertical-align:middle;" onclick="">${c.index + 1}</td>
                                	 	  <c:forEach items="${temp}" var="map" begin="0" end="0">
									          <c:forEach items="${map.value}" var="carlist">
									          		<td Style="text-align: center;vertical-align:middle;"><span title="司机 : ${carlist.carinfo.carDriver}&#10电话 : ${carlist.carinfo.tel}">${carlist.carinfo.carNumber}<br>(${carlist.carinfo.carName})</span></td>
									           </c:forEach>
									      </c:forEach>
									      <c:forEach items="${temp}" var="map" begin="1">
									          <td Style="text-align: center;width:12%;">
										           <c:forEach items="${map.value}" var="carlist" varStatus="stauts">
											           <c:if test="${carlist.startTime != null}">	
										          	  		<a Style="margin-top:0px;width:100%;color:white;<c:if  test="${carlist.applyTime != null}">background:rgb(34, 242, 21)</c:if><c:if  test="${carlist.applyTime == null}">background:#35BCF7 </c:if>" title="用车人 : ${carlist.applyName}&#10电话 : ${carlist.tel}&#10用车原因: ${carlist.tel}&#10&#10申请时间: ${carlist.addTime}&#10审核时间: ${carlist.applyTime}" href="#showdetail" ref="${carlist.id},12315" class="btn default btn-xs black" data-toggle="modal">${carlist.startTime}-${carlist.endTime}</a><br>
										          	  		<a Style="width:100%;height:10px;opacity:0;" href="#showdetail" ref="${carlist.carinfo.id},${carlist.useTime}" class="btn default btn-xs black" data-toggle="modal"></a>
										           
                                                       <%-- <c:if test="${stauts.index+1==fn:length(map.value)}">
										          	  		<a Style="margin-top:0px;width:100%;color:white;<c:if  test="${carlist.applyTime != null}">background:rgb(34, 242, 21)</c:if><c:if  test="${carlist.applyTime == null}">background:#35BCF7 </c:if>" title="用车人 : ${carlist.applyName}&#10电话 : ${carlist.tel}&#10用车原因: ${carlist.tel}&#10&#10申请时间: ${carlist.addTime}&#10审核时间: ${carlist.applyTime}" href="#showdetail" ref="${carlist.carinfo.id},${carlist.useTime}" class="btn default btn-xs black" data-toggle="modal">申请</a><br>
											          </c:if>  --%>
											          </c:if>
											           <c:if test="${carlist.startTime == null}">	
										          	  		<a Style="width:100%;height:80px;opacity:0;" href="#showdetail" ref="${carlist.carinfo.id},${carlist.useTime}" class="btn default btn-xs black" data-toggle="modal"></a>
											          </c:if>
									           	   </c:forEach>
									          </td>
									      </c:forEach>
								     </tr>
								 </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">本周没有车辆使用数据</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="rethealth" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<!-- 查看详情 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		  
		</div>
		<script type="text/javascript">
		$(function(){
			$('#xm').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/retment/autoCompleteUser', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#xm'
				,id:1
				,cusReq:selUser
				,view:3
			});
			$('#sfzh').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/retment/autoCompleteUser', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#sfzh'
				,id:1
				,cusReq:selUserSfzh
				,view:3
			});
			$('.black').click(function(){
				var id = $(this).attr("ref");
				var kk = id.split(",");
				$.post('/carApplyShow/ajaxdetail?'+new Date().getTime(),{"id":kk[0],"useTime":kk[1]},function(d){
					$("#showdetail").html(d);
				}); 
			});
		});
		
		//查询到用户放入姓名框中
		function selUser(id){
		   var tid=id.split('-')[1];
		  $("#xm").val(tid);
		}
		//查询到用户放入身份证框中
		function selUserSfzh(id){
		   var tid=id.split('-')[0];
		  $("#sfzh").val(tid);
		}
		
		function doCreate(){
			$('#frm').attr('action','/carApply/create').submit();
		}
		//修改
		function doEdit(){
			if(fnupdate()){
				var val = "";
				$('.checkboxes').each(function(){
					if(this.checked)
						val = $(this).val();
				});
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/carApply/"+val+"/edit";
				frm.submit();
			}
		}
		
		//审核
		function doApply(){
			if(fnupdate()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/carApplyShow/"+val+"/apply";
				frm.submit();
			}
		}
		
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/carApply/delete";
				frm.submit();
			}
		}
		//查询
		function doSearch(){
			var k = true;
			if(k)
				$('#frm').attr('action','/carApplyShow').submit();
			else 
				return false;
		}
		
		//上一周
		function doFront(){
			var k = true;
			$('#times').val("-1");
			if(k)
				$('#frm').attr('action','/carApplyShow').submit();
			else 
				return false;
		}
		
		//下一周
		function doNext(){
			var k = true;
			$('#times').val("1");
			if(k)
				$('#frm').attr('action','/carApplyShow').submit();
			else 
				return false;
		}
		
		</script>
	</body>
</html>
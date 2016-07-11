<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/rethospital'/>" class="form-horizontal" method="post">
		<input id="xzmob" name="xzmob" value="rethospital" type="hidden">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/rethospital">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/rethospital">
							住院管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/rethospital">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<!-- a href="javascript:;;" class="btn blue" onclick="doCreate()"><i class="fa fa-plus"></i> 新增</a> 
                    <a href="javascript:;;" class="btn blue" onclick="doEdit()"><i class="fa fa-pencil-square-o"></i> 修改</a>
					<a href="javascript:;;" class="btn blue" onclick="doDel()"><i class="fa fa-times"></i> 删除</a-->
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
															<label class="control-label">姓名：</label>
															<div class="controls">
																<input type="text" id="xm" name="ret.xm" value="${w.ret.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<input type="text" id="sfzh" name="ret.sfzh" value="${w.ret.sfzh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">原工作单位：</label>
															<div class="controls">
																<select name="ret.dwb.id"  id="ret.dwb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${dwblist}" var="item">
												             			<option value="${item.id}" <c:if test="${w.ret.dwb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">住院日期(起)：</label>
															<div class="controls">
																<input type="text" id="gksj" name="gksj" value="${gksj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">住院日期(止)：</label>
															<div class="controls">
																<input type="text" id="gjsj" name="gjsj" value="${gjsj}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">职务：</label>
															<div class="controls">
																<select name="ret.zwb.id"  id="ret.zwb.id" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
												             		<c:forEach items="${zwblist}" var="item">
												             			<option value="${item.id}" <c:if test="${w.ret.zwb.id == item.id}">selected</c:if>>${item.name}</option>
												             		</c:forEach>
												             	</select>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions fluid">
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-offset-5">
															<button type="button" class="btn blue mgr10 wzbtn" onClick="doSearch();"><i class="fa fa-search"></i> 查询</button> 
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
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover" id="tableSort">
                                <thead>
                                <tr>
                                	<th width="45">序号</th>
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>身份证号</th>
                                    <th>原工作单位</th>
                                    <th>住院日期</th>
                                    <th>医院</th>
                                    <th>科室</th>
                                    <th>楼层</th>
                                    <th>床位</th>
                                    <th>登记人</th>
                                    <th><a href="javascript:void(0)" onclick="$.sortTable.sort('tableSort',12)">登记日期</a></th>
                                    <th>探视人</th>
                                    <th><a href="javascript:void(0)" onclick="$.sortTable.sort('tableSort',14)">探视日期</a></th>
                                    <th>详情</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.ret.xm}</td>
                                    <td>${item.ret.xb}</td>
                                    <td>${item.ret.sfzh}</td>
                                    <td title="${item.ret.dwb.name}"><s:substring length="8" value="${item.ret.dwb.name}"/></td>
                                    <td>${item.zyrq}</td>
                                    <td title="${item.yymc}"><s:substring length="8" value="${item.yymc}"/></td>
                                    <td>${item.yyks}</td>
                                    <td>${item.yylc}</td>
                                    <td>${item.yycw}</td>
                                    <td>${item.djr}</td>
                                    <td>${item.djrq}</td>
                                    <td title="${item.tsry}"><s:substring length="4" value="${item.tsry}"/></td>
                                    <td>${item.tsrq}</td>
                                    <td width="20"><a href="#showdetail" ref="${item.id}" class="btn default btn-xs black" data-toggle="modal">查看</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="rethospital" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<!-- 查看详情 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		  
		</div>
		<script>
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
				$.post('/rethospital/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
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
			$('#frm').attr('action','/rethospital/create').submit();
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
				frm.action = "${request.contextPath}/rethospital/"+val+"/edit";
				frm.submit();
			}
		}
		//删除
		function doDel(){
			if(fnremove()){
				var frm = document.getElementById('frm');
				frm.action = "${request.contextPath}/rethospital/delete";
				frm.submit();
			}
		}
		//导出
		function doExcel(){
			$('#frm').attr("method","post").attr('action','/rethospital/importexecl').submit();
		}
		//导出
		function doXiazai(){
			$('#frm').attr("method","post").attr('action','/rethospital/export').submit();
		}
		//查询
		function doSearch(){
			var k = true;
			if($('#gksj').val() != '' && $('#gjsj').val() != ''){
				if(fnbeginOverEnd($('#gksj').val(),$('#gjsj').val(),'住院时间止不能小于住院时间起')){
					k = false;
				}
			}
			if(k)
				$('#frm').attr('action','/rethospital').submit();
			else 
				return false;
		}
		//下载
		function doDown(){
			$('#frm').attr('method','post').attr('action','/retment/download').submit();
		}
		
		//点击登记日期和探视时间进行排序
		(function($){  
		    //插件  
		    $.extend($,{  
		        //命名空间  
		        sortTable:{  
		            sort:function(tableId,Idx){  
		                var table = document.getElementById(tableId);  //得到table对象
		                var tbody = table.tBodies[0];  //得到table下的tbody
		                var tr = tbody.rows;  //获取行对象 
		                var trValue = new Array();  
		                for (var i=0; i<tr.length; i++ ) {  
		                    trValue[i] = tr[i];  //将表格中各行的信息存储在新建的数组中  
		                }  
		                if (tbody.sortCol == Idx) {  
		                    trValue.reverse(); //如果该列已经进行排序过了，则直接对其反序排列  
		                } else {  
		                    //trValue.sort(compareTrs(Idx));  //进行排序  
		                    trValue.sort(function(tr1, tr2){  
		                        var value1 = tr1.cells[Idx].innerHTML;  
		                        var value2 = tr2.cells[Idx].innerHTML;  
		                        return value2.localeCompare(value1);  //降序
		                       // return value2.localeCompare(value1); //升序
		                    });  
		                }  
		          
		                var fragment = document.createDocumentFragment();  //新建一个代码片段，用于保存排序后的结果  
		                for (var i=0; i<trValue.length; i++ ) {  
		                    fragment.appendChild(trValue[i]);  
		                }  
		          
		                tbody.appendChild(fragment); //将排序的结果替换掉之前的值  
		                tbody.sortCol = Idx;  
		            }  
		        }  
		    });         
		})(jQuery);
		</script>
	</body>
</html>
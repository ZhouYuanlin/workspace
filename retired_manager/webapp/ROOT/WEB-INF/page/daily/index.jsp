<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
	<form id="frm" action="<c:url value='${request.contextPath}/retiredaily'/>" class="form-horizontal" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/retiredaily">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/retiredaily">
							工作日志 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/retiredaily">
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
															<label class="control-label">姓名：</label>
															<div class="controls">
																<input type="text" id="xm" name="xm" value="${w.xm}" class="form-control col-md-12"/>
															</div>
														</div>
													</div>
												<%-- 	<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">身份证号：</label>
															<div class="controls">
																<input type="text" id="sfzh" name="sfzh" value="${w.sfzh}" class="form-control col-md-12"/>
															</div>
														</div>
													</div> --%>
													<div class="col-md-4">
                                                        <div class="form-group">
															<label class="control-label">类型：</label>
															<div class="controls">
																<select name="type" class="form-control col-md-12">
										                            <option value="">----请选择----</option>
										                            <option value="计划" <c:if test="${w.type == '计划'}">selected</c:if>>计划</option>
										                            <option value="日志" <c:if test="${w.type == '日志'}">selected</c:if>>日志</option>
												             	</select>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">发布日期(起)：</label>
															<div class="controls">
																<input type="text" id="st" name="st" value="${st}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">发布日期(止)：</label>
															<div class="controls">
																<input type="text" id="ed" name="ed" value="${ed}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">填写日期(起)：</label>
															<div class="controls">
																<input type="text" id="xrsjst" name="xrsjst" value="${xrsjst}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label class="control-label">填写日期(止)：</label>
															<div class="controls">
																<input type="text" id="xrsjed" name="xrsjend" value="${xrsjend}" class="form-control col-md-12 date-picker" data-date-format="yyyy-mm-dd" size="16" readonly/>
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
                                    <th><a href="javascript:void(0)" onclick="$.sortTable.sort('tableSort',3)">发布日期</a></th>
                                    <th><a href="javascript:void(0)" onclick="$.sortTable.sort('tableSort',4)">填写日期</a></th>
                                    <th>内容</th>
                                    <th>类型</th>
                                    <th>是否已读</th>
                                    <th>重要程度</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                	<td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.xm}</td>
                                    <td><fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd"/></td>
                                    <td><fmt:formatDate value="${item.xrsj}" pattern="yyyy-MM-dd"/></td>
                                    <td title="${item.content}"><s:substring length="20" value="${item.content}"/></td>
                                    <td>${item.type}</td>
                                    <td>${item.status}</td>
                                    <td>${item.sfzy}</td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}"><tr><td colspan="14">没有数据！</td></tr></c:if>
                                </tbody>
                                </table>
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="retiredaily" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<script>
		//查询
		$(document).ready(function (){
			$('#xm').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/retiredaily/autoCompleteUser', 
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
		});

		//查询到用户放入姓名框中
		function selUser(id){
		   var tid=id.split('-')[1];
		  $("#xm").val(tid);
		}
		function doSearch(){
			var k = true;
			if($('#st').val() != '' && $('#ed').val() != ''){
				if(fnbeginOverEnd($('#st').val(),$('#ed').val(),'日期起不能小于日期止')){
					k = false;
				}
			}
			if($('#xrsjst').val() != '' && $('#xrsjed').val() != ''){
				if(fnbeginOverEnd($('#xrsjst').val(),$('#xrsjed').val(),'日期起不能小于日期止')){
					k = false;
				}
			}
			if(k)
				$('#frm').attr('action','/retiredaily').submit();
			else
				return false;
		}
		//导出
		function doXiazai(){
			$('#frm').attr('method','post').attr('action','/retiredaily/doExport').submit();
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
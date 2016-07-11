<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
		<form id="frm" action="" method="post">
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/codesavezdytjb">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/codesavezdytjb">
							快速查询保存自定义条件管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/codesavezdytjb">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
					<a href="javascript:;;" class="btn blue" onclick="doDel()"><i class="fa fa-times"></i> 删除</a>	
                </div>
              </div>
              </div>
              
			  <div class="row">
					<div class="col-md-12">
                    <table style="text-align: center;" class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                	<th width="45">序号</th>
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>快速查询名称</th>
                                    <th>快速查询条件值</th>
                                    <th>所属用户</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td>${c.index + 1}</td>
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td>${item.fattiesName}</td>
                                    <td>${item.fattiesValue}</td>
                                    <td>${item.username}</td>
                                    <td width="150"> <a href="javascript:if(confirm('您确定要删除吗？'))location.href='/codesavezdytjb/delete?id=${item.id}'" class="btn default btn-xs black">删除</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}">
                                	<tr><td colspan="6">没有数据</td></tr>
                                </c:if>
                                </tbody>
                                </table> 
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="codesavezdytjb" includeParams="true" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form> 
		<script>
			function doCreate(){
				$('#frm').attr("action","/codesavezdytjb/create").submit();
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
					frm.action = "${request.contextPath}/codesavezdytjb/"+val+"/edit";
					frm.submit();
				}
			}
			//删除
			function doDel(){
				if(fnremove()){
					var frm = document.getElementById('frm');
					frm.action = "${request.contextPath}/codesavezdytjb/delete";
					frm.submit();
				}
			}
			//查询
			function doSearch(){
				var frm = document.getElementById('frm');
				frm.action = "/codesavezdytjb";
				frm.submit();
				
			}
			//导出
			function doXiazai(){
				$('#frm').attr("method","post").attr('action','/codesavezdytjb/export').submit();
			}
			//导入
			function doExcel(){
				$('#frm').attr('action','/codesavezdytjb/importexecl').submit();
			}
			//下载
			function doDown(){
				$('#frm').attr('method','post').attr('action','/codesavezdytjb/download').submit();
			}
		</script>
	</body>
</html>
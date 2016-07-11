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
							<a href="/codemzb">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/codemzb">
							民族管理 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/codemzb">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<a href="javascript:;;" class="btn blue" onclick="doCreate()"><i class="fa fa-plus"></i> 增加</a> 
                    <a href="javascript:;;" class="btn blue" onclick="doEdit()"><i class="fa fa-pencil-square-o"></i> 修改</a>
					<a href="javascript:;;" class="btn blue" onclick="doDel()"><i class="fa fa-times"></i> 删除</a>	
					<a href="javascript:;;" class="btn blue" onclick="doExcel()"><i class="fa fa-sign-in"></i> 导入</a>
					<a href="javascript:;;" class="btn blue" onclick="doXiazai()"><i class="fa fa-sign-out"></i> 导出</a>
					<a href="javascript:;;" class="btn blue" onclick="doDown()"><i class="fa fa-download"></i> 下载模板</a>					
                </div>
              </div>
              </div>
			  <div class="row">
					<div class="col-md-12">
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                	<th width="45">序号</th>
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>代码</th>
                                    <th>民族名称</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td>${c.index + 1}</td>
                                    <td><input type="checkbox" class="checkboxes" id="id" name="id" value="${item.id}"/></td>
                                    <td>${item.code}</td>
                                    <td>${item.name}</td>
                                    <td width="150"><a href="/codemzb/${item.id}/edit" class="btn default btn-xs black" id="showtoast">编辑</a> <a href="javascript:if(confirm('您确定要删除吗？'))location.href='/codemzb/delete?id=${item.id}'" class="btn default btn-xs black">删除</a></td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}">
                                	<tr><td colspan="4">没有数据</td></tr>
                                </c:if>
                                </tbody>
                                </table> 
							<div class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="codemzb" includeParams="true" styleClass="pages fl_r"/>
							</div>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<script>
			function doCreate(){
				$('#frm').attr("action","/codemzb/create").submit();
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
					frm.action = "${request.contextPath}/codemzb/"+val+"/edit";
					frm.submit();
				}
			}
			//删除
			function doDel(){
				if(fnremove()){
					var frm = document.getElementById('frm');
					frm.action = "${request.contextPath}/codemzb/delete";
					frm.submit();
				}
			}
			//查询
			function doSearch(){
				var frm = document.getElementById('frm');
				frm.action = "/codemzb";
				frm.submit();
				
			}
			//导出
			function doXiazai(){
				$('#frm').attr("method","post").attr('action','/codemzb/export').submit();
			}
			//导入
			function doExcel(){
				$('#frm').attr('action','/codemzb/importexecl').submit();
			}
			//下载
			function doDown(){
				$('#frm').attr('method','post').attr('action','/codemzb/download').submit();
			}
		</script>
	</body>
</html>
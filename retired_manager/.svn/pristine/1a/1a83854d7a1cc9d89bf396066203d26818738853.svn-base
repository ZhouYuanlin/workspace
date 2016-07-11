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
							<a href="/article">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/article">
							文章分享 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/article">
							列表信息</a>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<!-- a href="javascript:;;" class="btn blue" onclick="doCreate()"><i class="fa fa-plus"></i> 上传文章</a> 
					<a href="javascript:;;" class="btn blue" onclick="doDel()"><i class="fa fa-times"></i> 删除</a-->	
					<jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
                </div>
              </div>
              </div>
			  <div class="row">
					<div class="col-md-12">
                    <table class="table table-striped table-bordered table-condensed table-advance table-hover">
                                <thead>
                                <tr>
                                    <th class="table-checkbox" width="45">
                                        <input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" />
                                    </th>
                                    <th>文章名称</th>
									<th>发布人</th>
									<th>发布时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item" varStatus="c">
                                <tr class="odd gradeX">
                                    <td><input type="checkbox" id="id" name="id" class="checkboxes" value="${item.id}"/></td>
                                    <td><a id="showJh" class="showJh"  ref="${item.id}" href="#folderdetail" data-toggle="modal"  target="_blank">${item.title}</a></td>
									<td>${item.zjh }</td>
									<td><fmt:formatDate value = "${item.cdate }" pattern ="yyyy-MM-dd"/> </td>
                                </tr>
                                </c:forEach>
                                <c:if test="${empty list}">
                                	<tr>
                                		<td colspan="6">没有数据</td>
                                	</tr>
                                </c:if>
                                </tbody>
                                </table> 
							<ul class="pagination pull-right">
								<s:pagination page="${paginate.page}" namespace="/" controller="article" includeParams="false" formWay="true" formId="frm" styleClass="pages fl_r"/>
							</ul>
              		</div>
				</div>
			</div>
		</div>
		</form>
		<!-- 在线阅读 -->
		<div class="modal fade" id="folderdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:20px;">
			  <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
			    <h3>在线阅读</h3>
			  </div>
			  <div class="modal-body" style="height:500px">
			  	<div id="showread"></div>
			  </div>
			  <div class="modal-footer">
			  	<button ref="" id="uploadFile" class="btn blue confirm" onclick="uploadFile()">下载</button>
			    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
			  </div>
			</div>
		<script>
		$(function(){
    		$(".showJh").click(function(){
       			var id = $(this).attr("ref");
       			$("#uploadFile").attr("ref",id);
       			$.post('/article/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
    				$("#showread").html(d);
    			});
       		});
    	});
		
		function uploadFile(){
    		var id = $("#uploadFile").attr("ref");
    		window.location.href="${request.contextPath}/article/"+id+"/download";
    	}
		
			function doCreate(){
				$('#frm').attr("action","/article/create").submit();
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
					frm.action = "${request.contextPath}/article/"+val+"/edit";
					frm.submit();
				}
			}
			//查看
			function doView(id){
				frm.action = "${request.contextPath}/article/"+id+"/noschmadetail";
				frm.submit();
			}
			//删除
			function doDel(){
				if(fnremove()){
					var frm = document.getElementById('frm');
					frm.action = "${request.contextPath}/article/delete";
					frm.submit();
				}
			}
			//查询
			function doSearch(){
				$('#frm').attr('action','/article').submit();
			}
		</script>
	</body>
</html>
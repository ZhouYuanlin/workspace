<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<form id="frm" action="<c:url value='${request.contextPath}/folder'/>" class="form-horizontal">
<input type="hidden" name="pid" id="pid" value="${pid}"/>
<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/folder">
							文档中心 </a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<c:if test="${!empty pfolder}"><a class="btn blue backfolder" href="javascript:void(0);" ref="${pfolder.parent.id}"><i class="fa fa-reply"></i>返回</a></c:if>
					<!-- a href="javascript:;;" class="btn blue editfolder"><i class="fa fa-pencil-square-o"></i> 修改</a>
					<a href="javascript:;;" class="btn blue deletfolder"><i class="fa fa-times"></i> 删除</a>
                	<a href="javascript:;;" class="btn blue createfolder"><i class="fa fa-plus"></i> 新建文件夹</a> 
                    <a href="javascript:;;" class="btn blue uploadfile"><i class="fa fa-upload"></i> 上传文档</a--> 
                    <jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
                </div>
              </div>
              </div>
				<table class="table table-advance table-hover down-line">
                       <thead>
                       <tr>
                           <th width="50">序号</th>
                           <th class="table-checkbox" width="45"><input type="checkbox" id="checkbox" onClick="checkAll(this)" class="group-checkable" /></th>
                            <shiro:hasPermission name="退休管理员">
                           <th width="65">排序</th>
                           </shiro:hasPermission>
                           <th><c:if test="${empty pfolder}">我的文件</c:if><c:if test="${!empty pfolder}">${pfolder.fileName}</c:if></th>
                            <shiro:hasPermission name="退休管理员">
                           <th width="160"></th>
                           </shiro:hasPermission>
                           <th width="130">所有者</th>
                           <th width="130">创建时间</th>
                       </tr>
                       </thead>
                       <tbody>
                       <!-- 隐藏的文件夹 创建文件夹使用 -->
                       <tr class="createfload_hide" style="display: none;">
                           <td colspan="3"></td>
                           <td>
                                 <i class="fa fa-folder"></i><input type="text" value="新建文件夹" name="fileName" class="fname"/>
                                 <span class="ensure_create" title="新建"><i class="fa fa-check-circle"></i></span>
                              	<span  class="cancle_create" title="取消"><i class="fa fa-times-circle"></i></span>
                           </td>
                           <td colspan="3"></td>
                       </tr>
                       <thead class="listfolder"><jsp:include page="_trnr.jsp"/></thead>
                       </tbody>
                       </table>
                       </form>
					<div class="pagination pull-right">
						<s:pagination page="${paginate.page}" namespace="/" controller="folder" includeParams="true" styleClass="pages fl_r"/>
					</div>
			</div>
		</div>
	</div>
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
		function uploadFile(){
			var id = $("#uploadFile").attr("ref");
			window.location.href="${request.contextPath}/folder/"+id+"/download";
		}
		$(function(){
			
			
			//返回
			$('.backfolder').click(function(){
				$("#pid").val($(this).attr("ref"));
				$("#frm").attr("action","/folder").submit();
			});
			$('.editfolder').click(function(){
				if(fnupdate()){
					var val = "";
					$('.checkboxes').each(function(){
						if(this.checked)
							val = $(this).val();
					});
					$("#frm").attr("method","post").attr("action","${request.contextPath}/folder/"+val+"/edit").submit();
				}
			});
			//上传文档
			$('.uploadfile').click(function(){
				$("#frm").attr("action","/folder/gotoupload").submit();
			});
			//创建文件夹
			$(".createfolder").click(function(){
				$(".createfload_hide").show();
			});
			$(".cancle_create").click(function(){
				$(".createfload_hide").hide();
			});
			//删除
			$('.deletfolder').click(function(){
				if(fnremove()){
					$('#frm').attr("action","/folder/delete").submit();
				}
			});
			//创建文件
			$(".ensure_create").click(function(){
				var n = $(".fname").val();
				if(n != ""){
					$("#frm").attr("action","/folder/save?fileName="+n).submit();
				}else{
					alert("请输入名称");
					return false;
				}
			});
		});
	
	</script>

</body>
</html>
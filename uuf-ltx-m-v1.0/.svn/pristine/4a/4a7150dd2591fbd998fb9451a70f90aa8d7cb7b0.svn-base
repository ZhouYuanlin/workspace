<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${request.getContextPath}/resources/framework/custom/base/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/jquery.ztree.core-3.5.min.js"></script>
<title>菜单页</title>
<script type="text/javascript">
//tree相关  -->
var id="";
var zTree,selectedNode;//全局变量zTree对象和默认选中节点对象
var setting = {
	data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:""}},callback:{onClick:onClick}
};
var arry = [
	<c:forEach items="${resources}" var="item" varStatus="i">
	{id:${item.id},pId:'${item.parent.id}',name:'${item.resourceName}',<c:if test="${empty item.parent.id}">open:true,</c:if>
			<c:if test="${!empty item.childrens}">iconOpen:"/resources/framework/custom/base/img/ztree/diy/1_open.png",iconClose:"/resources/framework/custom/base/img/ztree/diy/1_close.png"</c:if>
			<c:if test="${empty item.childrens}">icon:"/resources/framework/custom/base/img/ztree/diy/2.png"</c:if>
			}<c:if test="${!i.last}">,</c:if>
	</c:forEach>
	];
function onClick(event, treeId, treeNode, clickFlag){
	id = treeNode.id;
	window.top.iframe.location.href="${request.contextPath}/admin/resource/edit?id="+id;
	//window.location.href="${request.contextPath}/admin/resource/edit?id="+id;
};
$(function(){
	zTree = $.fn.zTree.init($("#tree"), setting, arry);
	//选中方法
	var id='${rId}';
	if(id!=null && id!=''){
		selectedNode=zTree.getNodeByParam('id',id);
		zTree.selectNode(selectedNode);
	}
});
/* function expandTree(level){//展开树（层级）
	var nodes= zTree.transformToArray(zTree.getNodes());
	for(var i=0;i<nodes.length;i++){
		if(nodes[i].level<level){
			zTree.expandNode(nodes[i], true, false, false);
		}
	}
}; */

//删除操作
function delOk(url){
	if(id==""){
		alert("您还没有选择任何节点!");
	}else{
		$.doAjax(url,"POST",{"id":id});
	}
}

</script>
</head>
<body>
	<div class="row">
		<div class="col-md-2" style="border:1px solid #e5e5e5;background-color:#F5F5F5" >
			<div class="form-group">
				<ul id="tree" class="ztree" style="width:225px; overflow:auto;clear: both;height: 1000px; "></ul>
			</div>
		</div>
		<div class="col-md-10">
			<iframe name="iframe" src="${request.getContextPath}/admin/resource/edit?id=${rId}" id="main" frameborder="0" width="100%" height="600px" scrolling="no"></iframe>
		</div>
	</div>
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/defaults/js/jquery.ztree-core.min.js"></script>
<link rel="stylesheet" href="/defaults/css/tree/zTreeStyle.css" type="text/css">
<SCRIPT type="text/javascript">
// tree相关  -->
var zTree,selectedNode;//全局变量zTree对象和默认选中节点对象
var setting = {
	data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:""}},callback:{onClick:onClick}
};
var arry = [
	<c:forEach items="${list}" var="item" varStatus="i">
	{id:${item.id},pId:'${item.parent.id}',name:'${item.name}',
			<c:if test="${!empty item.children}">iconOpen:"/defaults/css/tree/img/diy/1_open.png",iconClose:"/defaults/css/tree/img/diy/1_close.png"</c:if>
			<c:if test="${empty item.children}">icon:"/defaults/css/tree/img/diy/2.png"</c:if>
			}<c:if test="${!i.last}">,</c:if>
	</c:forEach>
	];
function onClick(event, treeId, treeNode, clickFlag){
	window.location.href="${request.contextPath}/resource/"+treeNode.id+"/edit";
};
$(function(){
	zTree = $.fn.zTree.init($("#tree"), setting, arry);
	//选中方法
	var id='${rs.id}';
	if(id!=null && id!=''){
		selectedNode=zTree.getNodeByParam('id',id);
		zTree.selectNode(selectedNode);
	}
});
function expandTree(level){//展开树（层级）
	var nodes= zTree.transformToArray(zTree.getNodes());
	for(var i=0;i<nodes.length;i++){
		if(nodes[i].level<level){
			zTree.expandNode(nodes[i], true, false, false);
		}
	}
};
</SCRIPT>
	<div class="page-sidebar nav-collapse" >
		<div id="gx_1022"> 
			<ul id="tree" class="ztree" style="width:225px; overflow:auto;clear: both;height: 430px; "></ul>
		</div>
	</div>
<script>
  	$(document).ready(function () {
		$('#bodymain').removeClass().addClass('page-header-fixed');
  	});
  </script>
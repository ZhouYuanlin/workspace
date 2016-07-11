﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title> 

<link rel='stylesheet' href='${request.contextPath}/defaults/css/style.css' media='screen' />
<script src="${request.contextPath}/defaults/js/editAndDelete.js" type="text/javascript"></script>
<script src="${request.contextPath}/defaults/js/pic/blocksit.min.js"></script>
</head>
<body>
<form id="frm" action="" class="form-horizontal">
<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/picture">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/picture">
							图片分享</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div  id="caidan" class="operation-btn pull-right">
					<jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>	
					<a class="btn blue" href="javascript:void(0)" onclick="doUpPhotoTo();"><i class="fa fa-sign-out"></i>上传图片到</a>
					
                </div>
              </div>
            </div>
           <div style="background-color:#eee;min-height:600px;overflow:auto;">
           <ul class="shenhetupian">
           		<c:forEach items="${list}" var="item" varStatus="c" >
           			<li class="danzhangtupian">
           				<table>
				        	<tr>
				    			<td>
			                		<a class="zp" href="javascript:void(0)" onclick="doView(${item.id})">
				                		<c:if test="${not empty photoList[c.index]}">
											<img  class="suolietu" src="${photoList[c.index].url}"/>
										</c:if>
										<c:if test="${empty photoList[c.index]}">
											<img  class="suolietu" src="${request.contextPath}/defaults/img/pic/11.png"/>
										</c:if>
										<strong class="zp_sl">${count[c.index]}</strong>
			                		</a>
				                </td>
				        	</tr>
				        </table>
				        <input id='id${item.id }' name='id' value='${item.id}' onclick='doEditAlbum(this)' class='checkboxes id' style='display:block;float:left;margin-left:5px;margin-top:3px;' type="hidden" />
				        <a id="editID" href="javascript:void(0)" onclick="doView(${item.id})">
				        <strong>${item.name}
				        </strong></a><br/>
				        <span class="zuozhe">${item.zjh}</span>
           			</li>
           		</c:forEach>
           </ul>
	 </div>
</div>
</div> 
</form>
<script>
$(document).ready(function() {
	//vendor script
	$('#header')
	.css({ 'top':-50 })
	.delay(1000)
	.animate({'top': 0}, 800);
	
	$('#footer')
	.css({ 'bottom':-15 })
	.delay(1000)
	.animate({'bottom': 0}, 800);
	
	//blocksit define
	$(window).load( function() {
		$('#container').BlocksIt({
			numOfCol: 5,
			offsetX: 8,
			offsetY: 8
		});
	});
	//window resize
	var currentWidth = 1100;
	$(window).resize(function() {
		var winWidth = $(window).width();
		var conWidth;
		if(winWidth < 660) {
			conWidth = 440;
			col = 2
		} else if(winWidth < 880) {
			conWidth = 660;
			col = 3
		} else if(winWidth < 1100) {
			conWidth = 880;
			col = 4;
		} else {
			conWidth = 1100;
			col = 5;
		}
		
		if(conWidth != currentWidth) {
			currentWidth = conWidth;
			$('#container').width(conWidth);
			$('#container').BlocksIt({
				numOfCol: col,
				offsetX: 8,
				offsetY: 8
			});
		}
	});
});
	//查看
	function doView(id){
		$('#frm').attr('method','post').attr('action',"${request.contextPath}/picture/"+id+"/view/s").submit();
	}
	function doViewDetail(id){
		$('#frm').attr('method','post').attr('action',"${request.contextPath}/picture/"+id+"/view").submit();
	}
	//返回上一级
	function doBack(){
		var id="${backid}";
		$('#frm').attr('method','post').attr("action","/picture/"+id+"/back").submit();
	}
	
function doCreate(){
	var id="${backid}";
	$('#frm').attr('method','post').attr('action',"/picture/"+id+"/create2").submit();
}



//修改
function doEdit(){
	$('.id').attr('type','checkbox');
	$('#caidan').html("<a class='btn blue' href='javascript:void(0)' onclick='doExit();'>退出编辑</a>&nbsp;<a class='btn blue' href='javascript:void(0)' onclick='doUpdateAlbum();'><i class='fa fa-pencil-square-o'></i>修改</a>&nbsp;"+
			"<a class='btn blue' href='javascript:void(0)' onclick='doDeleteAlbum();'><i class='fa fa-times'></i>删除</a>");
	/* $('#frm').attr('method','post').attr("action","${request.contextPath}/picture/"+id+"/delGrp").submit();*/
}
//退出编辑操作
function doExit(){
	$('#frm').attr('method','post').attr("action","${request.contextPath}/picture").submit();
}
//点击进入编辑功能后,点击修改时的操作
function doUpdateAlbum(){
	if(pointArr.length>1){
		alert("只能指定单个相册修改!")
		for(var i=0;i<IDArr.length;i++){
			var ID = IDArr[i];
			document.getElementById(ID).checked = false;
		}
		pointArr=[];
		IDArr=[];
		return false;
	}
	if(pointArr.length==0){
		alert("请选择要修改的相册");
		return false;
	}
	$('#frm').attr('method','post').attr("action","${request.contextPath}/picture/"+pointID+"/edit").submit();
}

//删除操作
function doDeleteAlbum(){
	var aldumid = null;
	var photoid =null;
	var id = null;
	if(pointArr.length==0){
		alert("请选择要删除的相册或图片");
		return false;
	}
	for(var i=0;i<pointArr.length;i++){
		if(i==0){
			aldumid=pointArr[i];
		}
		if(i>0 && i<pointArr.length){
			aldumid+=","+pointArr[i];
		}
	}
	if(confirm("是否要删除相册?")){
		$('#frm').attr('method','post').attr("action","${request.contextPath}/picture/"+id+"/"+aldumid+"/"+photoid+"/del").submit();
	}else{
		for(var i=0;i<IDArr.length;i++){
			var ID = IDArr[i];
			document.getElementById(ID).checked = false;
		}
		pointArr=[];
		IDArr=[];
		return false;
	}
}

//删除
function doDel(){
	var id="${backid}";
	$('#frm').attr('method','post').attr("action","${request.contextPath}/picture/"+id+"/appr").submit();
}

function doUpPhotoTo(){
	var id="${backid}";
	$('#frm').attr('method','post').attr("action","/picture/"+id+"/create").submit();
}

</script>

</body>
</html>
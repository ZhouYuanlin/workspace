<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
						<li>
							<i class="fa fa-angle-right"></i>
							<a href="/picture">
							${DocName}</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div id = "caidan" class="operation-btn pull-right">
                	<!-- a href="javascript:;;" class="btn blue" onclick="doCreate()"><i class="fa fa-plus"></i> 上传图片</a>
                	<a href="javascript:;;" class="btn blue" onclick="doEdit()"><i class="fa fa-pencil-square-o"></i> 编辑相册</a> 
					<a href="javascript:;;" class="btn blue" onclick="doDel()"><i class="fa fa-times"></i> 删除图片</a-->
					<a href="javascript:void(0)" class="btn blue" onclick="doBack()">返回上级</a>
					<a class='btn blue' href='javascript:void(0)' onclick='doMove();'>移动相册</a>
					<jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>	
					<a class='btn blue' href='javascript:void(0)' onclick='doUploadPhoto();'>上传图片</a>
                </div>
              </div>
            </div>
           <div style="background-color:#eee;min-height:600px;overflow:auto;">
           <ul class="shenhetupian">
           		<c:forEach items="${list}" var="item" varStatus="c">
           			<li class="danzhangtupian">
           				<table>
				        	<tr>
				    			<td>
				                		<a class="zp" href="javascript:void(0)" onclick="doView(${item.id})">
					                		<c:if test="${not empty photopath[c.index]}">
												<img  class="suolietu" src="${photopath[c.index].url}"/>
												<strong class="zp_sl">${count[c.index]}</strong>
											</c:if>
											<c:if test="${empty photopath[c.index]}">
												<img  class="suolietu" src="${request.contextPath}/defaults/img/pic/11.png"/>
											</c:if>
				                		</a>
				                </td>
				        	</tr>
				        </table>
				        <input id='id${item.id }' name='id' value='${item.id}' onclick='doEditAlbum(this)' class='checkboxes editId' style='display:block;float:left;margin-left:5px;margin-top:3px;' type="hidden"/>
				        <a href="javascript:void(0)" onclick="doView(${item.id})"><strong>${item.name}</strong></a><br/>
				        <span class="zuozhe">${item.zjh}</span>
           			</li>
           		</c:forEach>
           		<c:forEach items="${photolist}" var="item" varStatus="c">
					<li class="danzhangtupian">
				    	<table>
				        	<tr>
				    			<td>
				                		<a href="javascript:void(0)" target="_blank" onclick="doViewDetail(${item.id})">
				                    		<img class="suolietu" src="${item.url }" />
				                        </a>
				                </td>
				        	</tr>
				        </table>
				        <input id='id${item.id }' name='id' value='${item.id}' onclick='doEditPhoto(this)' class='checkboxes editId' style='display:block;float:left;margin-left:5px;margin-top:3px;' type="hidden"/>
				        <span class="zuozhe">${item.zjh}</span><br/>
				        <span><fmt:formatDate value = "${item.cdate}" pattern ="yyyy-MM-dd"/></span>
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
		//frm.action = "${request.contextPath}/picture/"+id+"/view";
		//frm.submit();
	}
	//返回上一级
	function doBack(){
		var id="${backid}";
		$('#frm').attr('method','post').attr('action',"/picture/"+id+"/back").submit();
		//frm.action = "/picture/"+id+"/back";
		//frm.submit();
	}
	
function doCreate(){
	var id="${backid}";
	$('#frm').attr('method','post').attr('action',"/picture/"+id+"/create3").submit();
}
//移动相册
function doMove(){
	$('.editId').attr('data-toggle','model');
	$('.editId').attr('type','checkbox');
	$('#caidan').html("<a class='btn blue' href='javascript:void(0)' onclick='doMovePhoto();'>移动相册</a>");
}
//点击移动相册按钮
/* function doMovePhoto(){
	if (fnmove()) {
		var val = "";
		$('.editId').each(function() {
			if (this.checked)
				val = $(this).val();
		});
		alert(val)
		 $('#frm').attr('method','post').attr('action',"/picture/"+val+"/move").submit();  
	}
} */
//移动相册操作
function doMovePhoto(){
	var photoid = null;
	if(photoArr.length==0){
		alert("请选择要移动的图片");
		return false;
	}
	for(var i=0;i<photoArr.length;i++){
		if(i==0){
			photoid = photoArr[i];
		}
		if(i>0 && i<photoArr.length){
			photoid += ","+photoArr[i];
		}
	}
	if(confirm("是否要移动所选择的图片?")){
		$('#frm').attr('method','post').attr("action","${request.contextPath}/picture/"+photoid+"/move").submit();
	}else{
		for(var i=0;i<IDArr.length;i++){
			var ID = IDArr[i];
			document.getElementById(ID).checked = false;
		}
		for(var i=0;i<photoIDArr.length;i++){
			var ID = photoIDArr[i];
			document.getElementById(ID).checked = false;
		}
		pointArr=[];
		IDArr=[];
		photoArr=[];
		photoIDArr=[];
		return false;
	}
}
//修改
function doEdit(){
	$('.editId').attr('type','checkbox');
	$('#caidan').html("<a class='btn blue' href='javascript:void(0)' onclick='doExit();'>退出编辑</a>&nbsp;<a class='btn blue' href='javascript:void(0)' onclick='doUpdateAlbum();'><i class='fa fa-pencil-square-o'></i>修改</a>&nbsp;"+
			"<a class='btn blue' href='javascript:void(0)' onclick='doDeleteAlbum();'><i class='fa fa-times'></i>删除</a>");
	//var id="${backid}";
	//$('#frm').attr('method','post').attr("action","${request.contextPath}/picture/"+id+"/delGrp").submit();
}
//退出编辑操作
function doExit(){
	var id="${backid}";
	$('#frm').attr('method','post').attr('action',"/picture/"+id+"/view/s").submit();
}
//点击进入编辑功能后,点击修改时的操作
function doUpdateAlbum(){
	if(pointArr.length>0 && photoArr.length>0){
		alert("只能选择单个相册进行修改!");
		if(pointArr.length>0){
			for(var i=0;i<IDArr.length;i++){
				var ID = IDArr[i];
				document.getElementById(ID).checked = false;
			}
			pointArr=[];
			IDArr=[];
		}
		if(photoArr.length>0){
			for(var i=0;i<photoIDArr.length;i++){
				var ID = photoIDArr[i];
				document.getElementById(ID).checked = false;
			}
			photoArr=[];
			photoIDArr=[];
		}
		return false;
	}
	if(pointArr.length>0 && photoArr.length==0){
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

		$('#frm').attr('method','post').attr("action","${request.contextPath}/picture/"+pointID+"/edit").submit();
	}
	if(photoArr.length>0 && pointArr.length==0){
				alert("照片不可编辑...请选择要修改的相册!")
				for(var i=0;i<photoIDArr.length;i++){
					var ID = photoIDArr[i];
					document.getElementById(ID).checked = false;
				}
				photoArr=[];
				photoIDArr=[];
				return false;
	}
	
	if(pointArr.length==0 && photoArr.length==0){
		alert("请选择要修改的相册!");
		return false;
	}
}
//删除操作
function doDeleteAlbum(){
	var albumid = null;
	var photoid = null;
	var id="${backid}";
	
	if(pointArr.length==0 && photoArr.length==0){
		alert("请选择要删除的相册或图片");
		return false;
	}
	for(var i=0;i<pointArr.length;i++){
		if(i==0){
			albumid = pointArr[i];
		}
		if(i>0 && i<pointArr.length){
			albumid += ","+pointArr[i];
		}
	}
	for(var i=0;i<photoArr.length;i++){
		if(i==0){
			photoid = photoArr[i];
		}
		if(i>0 && i<photoArr.length){
			photoid += ","+photoArr[i];
		}
	}
	if(confirm("是否要删除相册或图片?")){
		$('#frm').attr('method','post').attr("action","${request.contextPath}/picture/"+id+"/"+albumid+"/"+photoid+"/del").submit();
	}else{
		for(var i=0;i<IDArr.length;i++){
			var ID = IDArr[i];
			document.getElementById(ID).checked = false;
		}
		for(var i=0;i<photoIDArr.length;i++){
			var ID = photoIDArr[i];
			document.getElementById(ID).checked = false;
		}
		pointArr=[];
		IDArr=[];
		photoArr=[];
		photoIDArr=[];
		return false;
	}
}
	//上传图片
	function doUploadPhoto(){
		var id="${backid}";
		$('#frm').attr('method','post').attr('action',"/picture/"+id+"/upLoadPhoto").submit();
	}
	
/* 	function fnmove() {
        var count = 0;
        $(".editId").each(function () {
            if (this.checked) {
            	count++;
            }
        });
        if (count == 0) {
            alert("请至少选中一项");
            return false;
        }
        if(confirm('确定要移动到指定的相册吗？')){
        	return true;
        }else
        	return false;
       return true; 
    } */
</script>
<!-- 选择要移动的相册 -->
		<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:50px;">
		</div>
</body>
</html>
		

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
						<li>
							<i class="fa fa-angle-right"></i>
							<a href="/picture">
							移动相册</a>
						</li>
					</ul>
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
				        <input id='id${item.id }' name='id' value='${item.id}'  class='checkboxes editId' style='display:block;float:left;margin-left:5px;margin-top:3px;' type="checkbox" />
				        <a id="editID" href="javascript:void(0)" onclick="doView(${item.id})">
				        <strong>${item.name}
				        </strong></a><br/>
				        <span class="zuozhe">${item.zjh}</span>
           			</li>
           		</c:forEach>
           </ul>
		 <div class="form-actions fluid">
									<div class="row">
											<div class="col-md-12">
													<div class="col-md-offset-5">
													      <button type="submit" onclick="doMove()" class="btn blue mgr10 wzbtn"> 移动 </button> 
															</div>
															</div>
														</div>
													</div>
	 </div>
</div>
</div> 
</form>
<script>
//确认移动相册
function doMove(){
	//图片id
	var pid="${pid}";
	if (fnmove()) {
		//相册id
		var val = "";
		$('.editId').each(function() {
			if (this.checked)
				val = $(this).val();
		});
		 $('#frm').attr('method','post').attr('action',"/picture/"+val+","+pid+"/moveSuccess").submit();  
	}
}

/**
* 点击移动
*/	
function fnmove(message) {
    var count = 0;
    var mes;
    $('.checkboxes').each(function(){
        if (this.checked){
        	count++;
        }
    });
    if (count == 0){
    	mes=message==null?'请选中一项':message;
        alert(mes);
        return false;
    }
    if(count>1){
    	mes=message==null?'只能选一行':message;
    	alert(mes);
    	return false;
    }
    return true;
}
</script>
</body>


</html>
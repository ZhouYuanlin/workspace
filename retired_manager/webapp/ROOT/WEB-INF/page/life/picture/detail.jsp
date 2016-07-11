<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
	<link rel="stylesheet" href="${request.contextPath}/defaults/css/style.css" type="text/css">
</head>
<body>
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
							查看图片</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<a class="btn blue" href="/picture/${back}/upLoadPhoto"><i class="fa fa-plus"></i> 上传图片</a>
                </div>
              </div>
              </div>
<div id="mainContainer">

<div id="DHTMLgoodies_panel_one">
	<div class="albumtitle">
    	<a href="${request.contextPath}/picture/${back}/view/s" class="backtohome"><img src="${request.contextPath}/defaults/img/pic/backarrow.png" /></a>
        <span class="albumname">${grp.name}</span>
    </div>
    <div class="albumauthor">
    	此图片由&nbsp;<span>${grp.zjh }</span>&nbsp;于&nbsp;<span><fmt:formatDate value = "${grp.cdate }" pattern ="yyyy-MM-dd"/></span>&nbsp;上传
    </div>
    <div class="albumintroduce" title="${grp.summary }">
    	<s:substring length="50" value="${grp.summary }"/>
    </div>
    <ul class="piclist">
    <c:forEach items="${list}" var="item" varStatus="c">
	<li class="grid" >
		<div class="imgholder">
			<a href="#"><img src="${item.url}"/></a>
		</div>
	</li>
	</c:forEach>
    </ul>
</div>

<!-- Large image div -->
<div id="DHTMLgoodies_largeImage">
        <!-- Table is used to get both vertical and horizontal center alignment -->
	<table>
		<tr>
			<td>

				<!-- The intial shown image -->
     		<ul id="pictureframe" style="display:inline;list-style:none;">
     				<c:forEach items="${list}" var="item" varStatus="c">
					<li style="display:inline;display:none;">
     				<button type="button" class="btn godzan"  id="goodzan" onclick="addZan(${item.id })";>
     				<c:if test="${item.count == null}">
     					<i class="icon-thumbs-up icon-black" style="margin-top:4px;"></i>已赞<span id="zan${item.id }" style="color:red">0</span>次
     				</c:if>
     				<c:if test="${item.count != null}">
     					<i class="icon-thumbs-up icon-black" style="margin-top:4px;"></i>已赞<span id="zan${item.id }" style="color:red">${item.count }</span>次
     				</c:if>	
     				</button>
                		<a href="${item.url }" target="_blank">
                    		<img class="bigimage" src="${item.url }" alt="点击查看原图" title="点击查看原图"/>
                    		<div style = "display:none">${item.id }</div>
                        </a>
                	</li>
					</c:forEach>
	                </ul>
                   	<div class="prepic"></div>
        <div class="nextpic"></div>

			</td>
		</tr>
	</table>
</div>
</div>
</div>
<script>
$(document).ready(function() {
    var a=$("#pictureframe li").length;
	var b=0
	$("#pictureframe li:eq(0)").show();
	$("#pictureframe li:eq(0)").attr("id","current");
	$(".grid:eq(0)").css("backgroundColor","#000");
	$(".prepic").hide();
	$(".prepic").click(function(){
		$("#pictureframe li").hide();
		$("#pictureframe li").attr("id","");
		b=b-1;
		$("#pictureframe li:eq("+b+")").fadeIn(1000);
		$("#pictureframe li:eq("+b+")").attr("id","current");
		$(".grid").css("backgroundColor","#FFF");//asdasdsadsdadasdsad
		$(".grid:eq("+b+")").css("backgroundColor","#000");//adsadasddsa
	if(b==0){
		$(".prepic").fadeOut();
		}else{
			$(".prepic").fadeIn();
		};
	if(b==a-1){
		$(".nextpic").fadeOut();
		}else{
			$(".nextpic").fadeIn();
		};
		
	});
	$(".nextpic").click(function(){
		$("#pictureframe li").hide();
		$("#pictureframe li").attr("id","");
		b=b+1;
		$("#pictureframe li:eq("+b+")").fadeIn(1000);	
		$("#pictureframe li:eq("+b+")").attr("id","current");
		$(".grid").css("backgroundColor","#FFF");//
		$(".grid:eq("+b+")").css("backgroundColor","#000");//
			if(b==0){
		$(".prepic").fadeOut();
		}else{
			$(".prepic").fadeIn();
		};
	if(b==a-1){
		$(".nextpic").fadeOut();
		}else{
			$(".nextpic").fadeIn();
		};
	});
	
	$(".imgholder a").click(function(){
		var d = $(this).parent().parent().index();
		$(".grid").css("backgroundColor","#FFF");
		$(this).parent().parent().css("backgroundColor","#000");
		$("#pictureframe li").hide();
		$("#pictureframe li").attr("id","");
		b=d;
		$("#pictureframe li:eq("+b+")").fadeIn(1000);	
		$("#pictureframe li:eq("+b+")").attr("id","current");
			if(b==0){
		$(".prepic").fadeOut();
		}else{
			$(".prepic").fadeIn();
		};
	if(b==a-1){
		$(".nextpic").fadeOut();
		}else{
			$(".nextpic").fadeIn();
		};
		});
	
});
function addZan(picId){
	$.get('${request.contextPath}/picture/support', 
		{picId:picId},	
		function(data) {
			if(data.toString() == "-FAIL"){
				alert("你已经赞过改图片了，请赞其他图片...");
			}else{
				$("#zan"+picId).text(data.toString());
			}
	});	
};
</script>
</body>
</html>
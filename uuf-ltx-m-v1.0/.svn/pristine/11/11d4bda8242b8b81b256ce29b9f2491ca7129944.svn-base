<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <title>活动详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
	<meta http-equiv="x-rim-auto-match" content="none">
    <link rel="stylesheet" href="${request.getContextPath}/resources/wechat/custom/css/home.css"/>
    <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/css/aui.css" />
    <script type="text/javascript" src="${request.getContextPath}/resources/wechat/script/api.js" ></script>
    <script src="${request.getContextPath}/resources/framework/custom/base/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <style type="text/css">
    .aui-bar-warning {
    	background-color: #1A459E;
	}
	button, .aui-btn{
	display: block;	
	}
	.aui-btn-row:after {
	border-bottom: 0px solid #c8c7cc;
	display: block;
	content: '';
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	-webkit-transform-origin: 0 0;
	-webkit-transform: scale(1);
	pointer-events: none;
}
	
	.aui-btn-row {
    position: static;
    text-align: center;
    padding: 10px;
    }
     .aui-btn-block {
		display: block;
		width: 100%;
		padding: 13px 0;
		margin-bottom: 0;
		font-size: 20px;
	}
    </style>
</head>
<body>
    <div class="IS_fream">
        <div class="IS_banner">
            <img src="${request.getContextPath}/resources/wechat/img/xq_banner.jpg"/>
            <span>(已报名人数:<span class="${activ.id}"><c:if test="${not empty activ.sfzhstr}">${fn:length(fn:split(activ.sfzhstr,','))}</c:if><c:if test="${empty activ.sfzhstr}">0</c:if></span>人)</span>
        </div>
        <div class="IS_content">
            <div class="IS_contentone">
                <h1><b>${activ.name}</b></h1>
                <p class="IS_content_P">${activ.hdsm}</p>
            </div>
            <div class="IS_contenttwo">
                <div class="IS_contenttwo_a">活动时间：</div>
                <div class="IS_contenttwo_b">${activ.hdsj} 至 ${activ.hdsjjz}</div>
            </div>
            <div class="IS_contenttwo">
                <div class="IS_contenttwo_a">负责人：</div>
                <div class="IS_contenttwo_b">${activ.fzr}</div>
            </div>
            <div class="IS_contenttwo">
                <div class="IS_contenttwo_a">联系电话:</div>
                <div class="IS_contenttwo_b"><a style="color: green;" href="tel:${activ.fzrlxdh}">${activ.fzrlxdh}</a></div>
            </div>
            <!-- <div class="IS_contentthree">
                <div class="IS_contentfoot IS_foota">立即报名</div>
            </div>
            <div class="IS_contentthree">
                <div class="IS_contentfoot IS_footb">立即报名</div>
            </div> -->
          
      <div class="aui-line-x"></div>
        <div class="aui-padded-10">
                	 <div class="aui-btn-row" id="${activ.id}">
                	 	<c:choose>
                	 		<c:when test="${fn:contains(activ.sfzhstr, username)}"> 
                	 			<div class="aui-btn aui-btn-warning aui-btn-block" id="cancel" ref="${activ.id}" onclick="cancelApply(this);" style="background-color: #969696;border-color: #969696;">取 消 报 名</div>
                	 		</c:when>
                	 		<c:otherwise>
                	 			<div class="aui-btn aui-btn-warning aui-btn-block" id="confirm" ref="${activ.id}" onclick="apply(this);" >立 即 报 名</div>
                	 		</c:otherwise>
                	 	</c:choose>
   			</div>
       </div>
        </div>
    </div>
</body>
<script type="text/javascript">
//点击立即申请执行事件
	function apply(obj){
		$("#confirm").attr("onclick","");
		var id = $(obj).attr("ref");
		$.ajax({
	            type: "POST",
	            url: "/wechat/activity/apply",
	            data:  {id : id},
	            cache: false,
	            datatype: "json",
	            success: function (d) {
	            	if(d.result=='10001'){
	    				$("#"+id).children().remove();
	    				$("#"+id).append("<div class='aui-btn aui-btn-warning aui-btn-block' id='cancel' ref='"+id+"' onclick='cancelApply(this);' style='background-color: #969696;border-color: #969696;'>取 消 报 名</div>");
	    				$("."+id).text(parseInt($("."+id).text())+1);
	    			}
	            },	               
	             error: function (XMLHttpRequest, textStatus, errorThrown) {
	              	 alert("错误：" + errorThrown);
	              	$("#confirm").attr("onclick","apply(this);");
	            }
	        });
		}
	
	
	//点击取消申请执行事件
	function cancelApply(obj){
		$("#cancel").attr("onclick","");
		var id = $(obj).attr("ref");
		$.ajax({
            type: "POST",
            url: "/wechat/activity/cancelApply",
            data:  {id : id},
            cache: false,
            datatype: "json",
            success: function (d) {
            	if(d.result=='10001'){
    				$("#"+id).children().remove();
    				$("#"+id).append("<div class='aui-btn aui-btn-warning aui-btn-block' id='confirm' ref='"+id+"' onclick='apply(this);'>立 即 报 名</div>");
    				$("."+id).text(parseInt($("."+id).text())-1);
    			}
            },
             error: function (XMLHttpRequest, textStatus, errorThrown) {
              	 alert("错误：" + errorThrown);
              	$("#cancel").attr("onclick","cancelApply(this);");
            }
        });
	}
	</script>
</html>
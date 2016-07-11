<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>日历</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <link rel="stylesheet" href="${request.getContextPath}/resources/wechat/css/aui.css"/>
    <link rel="stylesheet" href="${request.getContextPath}/resources/wechat/css/aui-iconfont.css"/>
    <style type="text/css">
    
		    /* Reset */
		.ui-datepicker,
		.ui-datepicker table,
		.ui-datepicker tr,
		.ui-datepicker td,
		.ui-datepicker th {
			margin: 0;
			padding: 0;
			border: none;
			border-spacing: 0;
		}
		.ui-datepicker, .ui-datepicker table, .ui-datepicker tr, .ui-datepicker td, .ui-datepicker th{
			/*width: 90%;*/
		}
		/* Calendar Wrapper */
		.hongdian{
			color:#8cc1e3;
			height:1px;
			width:1px;
			float:left;
			z-index:5;
			margin-top:-16px;
		/* 	outline:1px solid green; */
			
			margin-left:8px;
		}
		.ui-datepicker {
			display: none;
			width: 100%;
			/*padding: 35px;*/
			cursor: default;
		
			text-transform: uppercase;
			font-family: Tahoma;
			font-size: 12px;
			background: #e8e8e8;
			-webkit-border-radius: 3px;
			-moz-border-radius: 3px;
			border-radius: 3px;
		
			-webkit-box-shadow: 0px 1px 1px rgba(255,255,255, .1), inset 0px 1px 1px rgb(0,0,0);
			-moz-box-shadow: 0px 1px 1px rgba(255,255,255, .1), inset 0px 1px 1px rgb(0,0,0);
			box-shadow: 0px 1px 1px rgba(255,255,255, .1), inset 0px 1px 1px rgb(0,0,0);
		}
		
		/* Calendar Header */
		.ui-datepicker-header {
			position: relative;
			padding-top: 10px;
			padding-bottom: 10px;
			border-bottom: 1px solid #d6d6d6;
		}
		
		.ui-datepicker-title { text-align: center; }
		
		/* Month */
		.ui-datepicker-month {
			position: relative;
			padding-right: 15px;
			color: #565656;
		}
		
		.ui-datepicker-month:before {
			display: block;
			position: absolute;
			top: 5px;
			right: 0;
			width: 5px;
			height: 5px;
			content: '';
		
			background: #a5cd4e;
			background: -moz-linear-gradient(top, #a5cd4e 0%, #6b8f1a 100%);
			background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#a5cd4e), color-stop(100%,#6b8f1a));
			background: -webkit-linear-gradient(top, #a5cd4e 0%,#6b8f1a 100%);
			background: -o-linear-gradient(top, #a5cd4e 0%,#6b8f1a 100%);
			background: -ms-linear-gradient(top, #a5cd4e 0%,#6b8f1a 100%);
			background: linear-gradient(top, #a5cd4e 0%,#6b8f1a 100%);
		
			-webkit-border-radius: 5px;
			-moz-border-radius: 5px;
			border-radius: 5px;
		}
		
		/* Year */
		.ui-datepicker-year {
			padding-left: 8px;
			color: #a8a8a8;
		}
		
		/* Prev Next Month */
		.ui-datepicker-prev,
		.ui-datepicker-next {
			position: absolute;
			top:2%;
			padding: 5px;
			cursor: pointer;
		}
		
		.ui-datepicker-prev {
			left: 35%;
			top:10px;
			padding-left: 0;
		}
		
		.ui-datepicker-next {
			right: 35%;
			top: 10px;
			padding-right: 0;
		}
		
		.ui-datepicker-prev span,
		.ui-datepicker-next span{
			display: block;
			width: 5px;
			height: 10px;
			text-indent: -9999px;
			background-image: url(${request.getContextPath}/resources/wechat/img/arrows.png);
		}
		
		.ui-datepicker-prev span { background-position: 0px 0px; }
		
		.ui-datepicker-next span { background-position: -5px 0px; }
		
		.ui-datepicker-prev-hover span { background-position: 0px -10px; }
		
		.ui-datepicker-next-hover span { background-position: -5px -10px; }
		
		/* Calendar "Days" */
		.ui-datepicker-calendar th {
			padding-top: 15px;
			padding-bottom: 10px;
			text-align: center;
			font-weight: normal;
		}
		
		table{
			width: 100%;
		}
		.ui-datepicker-calendar td {
		/* outline:1px solid red; */
			padding-left: 4%;
			padding-right:14px;
			text-align: center;
			line-height:2em;
		}
		
		.ui-datepicker-calendar .ui-state-default {
			display: block;
			width: 23px;
			float:left;
		/* 	outline:1px solid black; */
		
			text-decoration: none;
			color: #494949;
			
			border: 1px solid transparent;
		}
		
		/* Day Active State*/
		.ui-datepicker-calendar .ui-state-active {
			background-color: #20ac4c;
			border-radius: 100%;
		}
		
		/* Other Months Days*/
		.ui-datepicker-other-month .ui-state-default { color: #939393; }
    </style>
   
</head>
<body>
    <div class="aui-content" id="calendar">

    </div>
    <div class="aui-content">
        <ul class="aui-list-view">
        	<c:forEach items="${list}" var="item">
				<li class="aui-list-view-cell">
	                <p id="time"  class="aui-col-xs-6" style="font-size: 14px">${item.kssj}-${item.jssj}</p>
	                <p class="aui-col-xs-6" style="font-size: 16px">${item.content}</p>
	            </li>
			</c:forEach>
        </ul>
    </div>
    <script type="text/javascript">
    function myfun(){
    	var num = jQuery('table').find("a").length;
    	for(var i=0;i<num;i++){
    		var a =jQuery('table').find("a").eq(i).attr("value");
    		<c:forEach items="${list2}" var="item" varStatus="x">
    			var time ="${item.type}";
    			if(time.toString()==a.toString()){
    				var le=jQuery('table').find("a").eq(i).parent().find("span").length;
    				if(le==0){
    					jQuery('table').find("a").eq(i).parent().append("<span class='hongdian'>●</span>");
    				}
    			} 
    		</c:forEach>
    		
    	}
    	
    }
    
		function getSun(year,mon,day){
			var dateyear=year+'-'+mon+'-'+day;
			var years=year;
			var mons=mon;
			var days=year;
			 $.ajax({
	             url:'${request.getContextPath}/wechat/personal/journalajax',
	             type: 'POST',
	             data:{"dateyear":dateyear},
	             dataType: 'json',
	             timeout: 1000,
	             cache: false,
	             beforeSend: LoadFunction, //加载执行方法  
	             error: erryFunction,  //错误执行方法   
	             success: succFunction //成功执行方法  
	         })
	         function LoadFunction() {
	         }
	         function erryFunction() {
	        	 myfun();
	         }
	         function succFunction(tt) {
	        	 	 myfun();
		             $(".aui-list-view").html("");
		             var json = eval(tt); //数组       
		             $.each(json, function (index, item) {
		                 //循环获取数据  
		                 var content = json[index].content;
		                 var start = json[index].kssj;
		                 var end = json[index].jssj;
		                 $(".aui-list-view").html($(".aui-list-view").html() +"<li class='aui-list-view-cell'> <p id='time' class='aui-col-xs-6' style='font-size: 14px'>"+start+"-"+end+"</p><p class='aui-col-xs-6' style='font-size: 16px'>"+content+"</p></li>"); 
		             });  
		            
	         }  
		}
	</script>
</body>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/jquery.min.js"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/huanyuan.js"></script>
<script type="text/javascript" src="${request.getContextPath}/resources/framework/custom/base/js/home.js"></script>

</html>
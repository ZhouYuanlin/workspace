<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head lang="en">
<meta charset="UTF-8">
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<link rel="stylesheet" href="/defaults/js/person/bootstrap/newpage.css" />
</head>
<body>
<div class="page-content-wrapper">
	<div class="page-content" style="padding: 24px 10px 20px 10px;" >
		<div class="row">
			<div class="col-md-12">
				<ul class="page-breadcrumb breadcrumb">
					<li><i class="fa fa-home"></i> <a href="index.html"> 首页 </a> <i
						class="fa fa-angle-right"></i></li>
					<li><a href="#"> 统计分析 </a> <i class="fa fa-angle-right"></i></li>
					<li><a href="#"> 基本信息 </a></li>
				</ul>
			</div>
		</div>
		<!--中间内容开始-->
		<div class="row mt">
			<div class="col-md-12">
				<div class="col-md-3 col-md-offset-1 tj-headone">
					离退休总人数<span style="color: red; font-size: 18px">100</span>人
				</div>
				<div class="col-md-7 tj-headtwo col-md-offset-1">
					<div class="tj-headtwo-a fl" style="color=white">
						离休比例（<span>20%</span>）
					</div>
					<div class="tj-headtwo-b fl" style="color=white">
						退休比例（<span>50%</span>）
					</div>
				</div>
			</div>
		</div>
		<div class="row mt">
			<div class="col-md-12 tj-twofream">
				<div class="col-md-1 col-xs-3 tj-twoa">性别比例</div>
				<div class="col-md-3 col-xs-3 tj-twob">
					<div class="col-md-12 tj-twob-nv ">
						<div class="col-md-9 tj-nvfarm">
							<ul>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
							</ul>
						</div>
						<div class="col-md-3 tj-nvword">
							<p></p>
							<p></p>
						</div>
					</div>
					<div class="col-md-12 tj-twob-nan">
						<div class="col-md-9 tj-nanfarm">
							<ul>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
							</ul>
						</div>
						<div class="col-md-3 tj-nanword">
							<p></p>
							<p></p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-twoc">
					<div class="col-md-12 tj-twob-nv ">
						<div class="col-md-9 tj-nvfarm">
							<ul>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
							</ul>
						</div>
						<div class="col-md-3 tj-nvword">
							<p></p>
							<p></p>
						</div>
					</div>
					<div class="col-md-12 tj-twob-nan">
						<div class="col-md-9 tj-nanfarm">
							<ul>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
							</ul>
						</div>
						<div class="col-md-3 tj-nanword">
							<p></p>
							<p></p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-twod">
					<div class="col-md-12 tj-twob-nv ">
						<div class="col-md-9 tj-nvfarm">
							<ul>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
								<li>&#xe621;</li>
							</ul>
						</div>
						<div class="col-md-3 tj-nvword">
							<p></p>
							<p></p>
						</div>
					</div>
					<div class="col-md-12 tj-twob-nan">
						<div class="col-md-9 tj-nanfarm">
							<ul>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
								<li>&#xe61e;</li>
							</ul>
						</div>
						<div class="col-md-3 tj-nanword">
							<p></p>
							<p></p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row mt">
			<div class="col-md-12 tj-threefream">
				<div class="col-md-1 col-xs-3 tj-twoa">年龄段分布</div>
				<div class="col-md-3 col-xs-3 tj-three-b" id="main"></div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-three-c" id="main2"></div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-three-d" id="main3"></div>
			</div>
		</div>
		<div class="row mt">
			<div class="col-md-12 tj-threefream">
				<div class="col-md-1 col-xs-3 tj-twoa">年龄分布</div>
				<div class="col-md-3 col-xs-3 tj-three-b" id="main4"></div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-three-c" id="main5"></div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-three-d" id="main6"></div>
			</div>
		</div>
		<div class="row mt">
			<div class="col-md-12 tj-threefream">
				<div class="col-md-1 col-xs-3 tj-twoa">职级分布</div>
				<div class="col-md-3 col-xs-3 tj-three-b" id="main7"></div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-three-c" id="main8"></div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-three-d" id="main9"></div>
			</div>
		</div>
	 	<div class="row mt">
			<div class="col-md-12 tj-threefream">
				<div class="col-md-1 col-xs-6 tj-twoa">离退休时间</div>
				<div class="col-md-3 col-xs-6 tj-three-b" id="main10"></div>
				<div class="col-md-3 col-xs-6 col-md-offset-1 tj-three-c" id="main11"></div>
				<div class="col-md-3 col-xs-6 col-md-offset-1 tj-three-d" id="main12"></div>
			</div>
		</div>
		<div class="row mt">
			<div class="col-md-12 tj-threefream">
				<div class="col-md-1 col-xs-3 tj-twoa">离世时间</div>
				<div class="col-md-3 col-xs-3 tj-three-b" id="main13"></div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-three-c" id="main14"></div>
				<div class="col-md-3 col-xs-3 col-md-offset-1 tj-three-d"id="main15"></div>
			</div>
		</div> 
	</div>
	</div>hhhh
	<div class="page-footer">
		<div class="page-footer-inner">2015 &copy; 离退休干部管理系统.</div>
		<div class="page-footer-tools">
			<span class="go-top"> <i class="fa fa-angle-up"></i>
			</span>
		</div>
	</div>
	<script type="text/javascript" src="/defaults/js/person/echarts.js"></script>
	<script type="text/javascript">
//保留两位小数
var Digit = {};
Digit.round = function(digit, length) {
length = length ? parseInt(length) : 0;
if (length <= 0) return Math.round(digit);
digit = Math.round(digit * Math.pow(10, length)) / Math.pow(10, length);
 return digit;
}
$(document).ready(function() {
	//离退休人员的性别分析图
         var txCount=0;
	     var lxCount=0;
	     var totalCount=0;
		<c:forEach items="${totalList}" var="item" varStatus="x">
		<c:if test="${item[0] == '退休'}">
		txCount=${item[1]}
		</c:if>
	    <c:if test="${item[0] == '离休'}">
		lxCount=${item[1]}
	    </c:if>
	   </c:forEach>
	    totalCount=lxCount+txCount;
	   $(".one-a>span").html(totalCount);
	   $(".tj-headone>span").html(totalCount);
	    var divwidth=$(".tj-headtwo").width()-1;
	   lxweight=lxCount/totalCount*divwidth;
	   txweight=txCount/totalCount*divwidth;
	   lxRate=parseFloat((lxCount/totalCount)*100);
	   result1= Digit.round(lxRate,2);
	   txRate=100-result1;   
    //离退休比例分配
    $(".tj-headtwo-a").css({
        "width": lxweight,
        "background-color": "#26727a",
        "color":"white"
    }).html("离休：" + lxCount+"("+result1+"%"+")");
    $(".tj-headtwo-b").css({
        "width": txweight,
        "background-color": "#b5c334",
        "color":"white"
    }).html("退休：" + txCount+"("+txRate+"%"+")");
   //性别比例
      var womanCount=0;
		    	    var manCount=0;
		    	   <c:forEach items="${sexLxList}" var="item" varStatus="x">
		    		<c:if test="${item[1] == '男'}">
		    		manCount++;
		    		</c:if>
		    		<c:if test="${item[1] == '女'}">
		    		womanCount++;
		    		</c:if>
 	              </c:forEach>
		    	    var womanbili=parseFloat(womanCount/totalCount);
		    	    var manbili=parseFloat(1-(womanCount/totalCount));
		    	    var womanRate=parseFloat((womanCount/totalCount)*100);
		    	    result1=(Digit.round(womanRate,2));
		    	    result2=Digit.round((100-result1),2);
    if(womanbili>0&&womanbili<=0.1){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").eq(0).css({"color":"#fa3f94"}).siblings().css({"color":"#d7d7d8"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").eq(9).css({"color":"#d7d7d8"}).siblings().css({"color":"#3c94cd"});
    }else if(womanbili>0.1&&womanbili<=0.2){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,2).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,8).css({"color":"#3c94cd"});
    }else if(womanbili>0.2&&womanbili<=0.3){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,3).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,7).css({"color":"#3c94cd"});
    }else if(womanbili>0.3&&womanbili<=0.4){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,4).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,6).css({"color":"#3c94cd"});
    }else if(womanbili>0.4&&womanbili<=0.5){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,5).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,5).css({"color":"#3c94cd"});
    }else if(womanbili>0.5&&womanbili<=0.6){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,6).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,4).css({"color":"#3c94cd"});
    }else if(womanbili>0.6&&womanbili<=0.7){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,7).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,3).css({"color":"#3c94cd"});
    }else if(womanbili>0.7&&womanbili<=0.8){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,8).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,2).css({"color":"#3c94cd"});
    }else if(womanbili>0.8&&womanbili<=0.9){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,9).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,1).css({"color":"#3c94cd"});
    }else if(womanbili>0.9&&womanbili<=1){
        $(".tj-twob>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,1).css({"color":"#fa3f94"});
        $(".tj-twob>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,9).css({"color":"#3c94cd"});
    }

    $(".tj-twob>.tj-twob-nv>.tj-nvword>p:nth-child(1)").html((result1)+"%");
    $(".tj-twob>.tj-twob-nv>.tj-nvword>p:nth-child(2)").html(womanCount+"人");
    $(".tj-twob>.tj-twob-nan>.tj-nanword>p:nth-child(1)").html(result2+"%");
    $(".tj-twob>.tj-twob-nan>.tj-nanword>p:nth-child(2)").html(manCount+"人");
    //第二性别比例
     var womanLxCount=0;
		    	    var manLxCount=0;
		    	   <c:forEach items="${sexLxList}" var="item" varStatus="x">
		    		<c:if test="${ item[0]=='离休' && item[1] == '男'}">
		    		manLxCount++;
		    		</c:if>
		    		<c:if test="${ item[0]=='离休'  && item[1] == '女'}">
		    		womanLxCount++;
		    		</c:if>
 	              </c:forEach>
 	                totalLxCount=womanLxCount+manLxCount;
		    	    var womanLxbili=parseFloat(womanLxCount/totalLxCount);
		    	    var manLxbili=parseFloat(1-(womanLxCount/totalLxCount));
		    	    var womanLxRate=parseFloat((womanLxCount/totalLxCount)*100);
		    	    result3=(Digit.round(womanLxRate,2));
		    	    result4=Digit.round((100-result3),2);
    
    
    if(womanLxbili>0&&womanLxbili<=0.1){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").eq(0).css({"color":"#fa3f94"}).siblings().css({"color":"#d7d7d8"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").eq(9).css({"color":"#d7d7d8"}).siblings().css({"color":"#3c94cd"});
    }else if(womanLxbili>0.1&&womanLxbili<=0.2){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,2).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,8).css({"color":"#3c94cd"});
    }else if(womanLxbili>0.2&&womanLxbili<=0.3){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,3).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,7).css({"color":"#3c94cd"});
    }else if(womanLxbili>0.3&&womanLxbili<=0.4){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,4).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,6).css({"color":"#3c94cd"});
    }else if(womanLxbili>0.4&&womanLxbili<=0.5){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,5).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,5).css({"color":"#3c94cd"});
    }else if(womanLxbili>0.5&&womanLxbili<=0.6){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,6).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,4).css({"color":"#3c94cd"});
    }else if(womanLxbili>0.6&&womanLxbili<=0.7){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,7).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,3).css({"color":"#3c94cd"});
    }else if(womanLxbili>0.7&&womanLxbili<=0.8){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,8).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,2).css({"color":"#3c94cd"});
    }else if(womanLxbili>0.8&&womanLxbili<=0.9){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,9).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,1).css({"color":"#3c94cd"});
    }else if(womanLxbili>0.9&&womanLxbili<=1){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,1).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,9).css({"color":"#3c94cd"});
    }

    $(".tj-twoc>.tj-twob-nv>.tj-nvword>p:nth-child(1)").html((result3)+"%");
    $(".tj-twoc>.tj-twob-nv>.tj-nvword>p:nth-child(2)").html(womanLxCount+"人");
    $(".tj-twoc>.tj-twob-nan>.tj-nanword>p:nth-child(1)").html(result4+"%");
    $(".tj-twoc>.tj-twob-nan>.tj-nanword>p:nth-child(2)").html(manLxCount+"人");
    
    //退休人员性别比例
    
       var womanTxCount=0;
		    	    var manTxCount=0;
		    	   <c:forEach items="${sexLxList}" var="item" varStatus="x">
		    		<c:if test="${ item[0]=='退休' && item[1] == '男'}">
		    		manTxCount++;
		    		</c:if>
		    		<c:if test="${ item[0]=='退休'  && item[1] == '女'}">
		    		womanTxCount++;
		    		</c:if>
 	              </c:forEach>
 	                totalTxCount=womanTxCount+manTxCount;
		    	    var womanTxbili=parseFloat(womanTxCount/totalTxCount);
		    	    var manTxbili=parseFloat(1-(womanTxCount/totalTxCount));
		    	    var womanTxRate=parseFloat((womanTxCount/totalTxCount)*100);
		    	    result5=(Digit.round(womanTxRate,2));
		    	    result6=Digit.round(100-result5,2);
    if(womanTxbili>0&&womanTxbili<=0.1){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").eq(0).css({"color":"#fa3f94"}).siblings().css({"color":"#d7d7d8"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").eq(9).css({"color":"#d7d7d8"}).siblings().css({"color":"#3c94cd"});
    }else if(womanTxbili>0.1&&womanTxbili<=0.2){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,2).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,8).css({"color":"#3c94cd"});
    }else if(womanTxbili>0.2&&womanTxbili<=0.3){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,3).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,7).css({"color":"#3c94cd"});
    }else if(womanTxbili>0.3&&womanTxbili<=0.4){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,4).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,6).css({"color":"#3c94cd"});
    }else if(womanTxbili>0.4&&womanTxbili<=0.5){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,5).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,5).css({"color":"#3c94cd"});
    }else if(womanTxbili>0.5&&womanTxbili<=0.6){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,6).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,4).css({"color":"#3c94cd"});
    }else if(womanTxbili>0.6&&womanTxbili<=0.7){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,7).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,3).css({"color":"#3c94cd"});
    }else if(womanTxbili>0.7&&womanTxbili<=0.8){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,8).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,2).css({"color":"#3c94cd"});
    }else if(womanTxbili>0.8&&womanTxbili<=0.9){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,9).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,1).css({"color":"#3c94cd"});
    }else if(womanTxbili>0.9&&womanTxbili<=1){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,1).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,9).css({"color":"#3c94cd"});
    }

    $(".tj-twod>.tj-twob-nv>.tj-nvword>p:nth-child(1)").html((result5)+"%");
    $(".tj-twod>.tj-twob-nv>.tj-nvword>p:nth-child(2)").html(womanTxCount+"人");
    $(".tj-twod>.tj-twob-nan>.tj-nanword>p:nth-child(1)").html(result6+"%");
    $(".tj-twod>.tj-twob-nan>.tj-nanword>p:nth-child(2)").html(manTxCount+"人");

});

// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
// 指定图表的配置项和数据
var option = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['60以下','60-69','70-79','80-89','90以上'],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '人数',
        type: 'bar',
        data: [
				<c:forEach items="${ageMaps}" var="item" varStatus="x">
				<c:forEach items="${item.value}" var="chi" varStatus="c">
					{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
					</c:forEach>
					</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第2个表格
var myChart2 = echarts.init(document.getElementById('main2'));
// 指定图表的配置项和数据
var option2 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['60以下','60-69','70-79','80-89','90以上'],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '人数',
        type: 'bar',
        data: [<c:forEach items="${lxageMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第3个表格
var myChart3 = echarts.init(document.getElementById('main3'));
// 指定图表的配置项和数据
var option3 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['60以下','60-69','70-79','80-89','90以上'],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '人数',
        type: 'bar',
        data: [<c:forEach items="${txageMaps}" var="item" varStatus="x">
		<c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第4个表格
var myChart4 = echarts.init(document.getElementById('main4'));
// 指定图表的配置项和数据
var option4 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'岁',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['最小值','平均值','最大值'],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '年龄',
        type: 'bar',
        data: [<c:forEach items="${ltxAgeMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:Digit.round(${chi[1]},0), name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第4个表格
var myChart5 = echarts.init(document.getElementById('main5'));
// 指定图表的配置项和数据
var option5 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'岁',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['最小值','平均值','最大值'],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '年龄',
        type: 'bar',
        data: [<c:forEach items="${lxAgeMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:Digit.round(${chi[1]},0), name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第4个表格
var myChart6 = echarts.init(document.getElementById('main6'));
// 指定图表的配置项和数据
var option6 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'岁',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['最小值','平均值','最大值'],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '年龄',
        type: 'bar',
        data: [<c:forEach items="${txAgeMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:Digit.round(${chi[1]},0), name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第4个表格
var myChart7 = echarts.init(document.getElementById('main7'));
var option7 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    barWidth:30,
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [ <c:forEach items="${postionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '职务',
        type: 'bar',
        data: [<c:forEach items="${postionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第5个表格
var myChart8 = echarts.init(document.getElementById('main8'));
var option8 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${lxpositionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '职务',
        type: 'bar',
        data: [<c:forEach items="${lxpositionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第6个表格
var myChart9 = echarts.init(document.getElementById('main9'));
var option9 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${txpositionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '职务',
        type: 'bar',
        data: [<c:forEach items="${txpositionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};

//离退休总人数柱状分布图
var myChart10 = echarts.init(document.getElementById('main10'));
var option10 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${ltxMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '退休',
        type: 'bar',
        data: [<c:forEach items="${ltxMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};


//离休柱状分布图
var myChart11 = echarts.init(document.getElementById('main11'));
var option11 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${lxMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离休',
        type: 'bar',
        data: [<c:forEach items="${lxMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//退休柱状分布图
var myChart12 = echarts.init(document.getElementById('main12'));
var option12 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${timepositionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '退休',
        type: 'bar',
        data: [<c:forEach items="${timepositionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第8个表格
var myChart13 = echarts.init(document.getElementById('main13'));
var option13 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${totalDeathMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离世',
        type: 'bar',
        data: [<c:forEach items="${totalDeathMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第7个表格
var myChart14 = echarts.init(document.getElementById('main14'));
var option14= {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${lxDeathMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离世',
        type: 'bar',
        data: [<c:forEach items="${lxDeathMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};
//第7个表格
var myChart15 = echarts.init(document.getElementById('main15'));
var option15= {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25,
        x:40,
        x2:20
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${txDeathMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离世',
        type: 'bar',
        data: [<c:forEach items="${txDeathMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#e25f65','#62a9e1','#8a64ad','#72c380','#e27c54'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter: '{c}'
                }
            }
        }

    }]
};

myChart.setOption(option);
myChart2.setOption(option2);
myChart3.setOption(option3);
myChart4.setOption(option4);
myChart5.setOption(option5);
myChart6.setOption(option6);
myChart7.setOption(option7);
myChart8.setOption(option8);
myChart9.setOption(option9);
myChart10.setOption(option10);
myChart11.setOption(option11);
myChart12.setOption(option12);
myChart13.setOption(option13);
myChart14.setOption(option14);
myChart15.setOption(option15);
</script>
</body>
</html>
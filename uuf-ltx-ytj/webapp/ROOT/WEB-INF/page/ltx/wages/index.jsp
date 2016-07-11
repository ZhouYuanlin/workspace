<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>工资查询</title>
   	<link rel="stylesheet" href="${request.contextPath}/resources/ytj/css/bootstrap.css"/>
    <link rel="stylesheet" href="${request.contextPath}/resources/ytj/css/style.css"/>
    <link rel="stylesheet" href="${request.contextPath}/resources/ytj/common/custom.css"/>
    <script type="text/javascript" src="${request.contextPath}/resources/ytj/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${request.contextPath}/resources/ytj/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../../../resources/ytj/common/main.jsp"></jsp:include>
    <div class="all-baoguoone">
    <div class="container head">
       	<img class="headimg" src="${request.contextPath}/resources/ytj/images/logo.png" alt=""/>
        <span class="headfont">离退休人员多功能触摸自助查询一体机</span>
    </div>
</div>
    <div class="container ps-container-two">
    <div class="row">
        <div class="ps-left fl">
            <jsp:include page="../index/menu.jsp"></jsp:include>
        </div>
         <form id="form" class="form-inline" action="${request.contextPath}/ytj/wages/index" method="post">
        <div class="ps-right fr">
            <div class="row ps-row"  >
                    <div class="form-group col-md-5">
                        <label for="exampleInputName2" class="col-md-5">工资发放月份(起)：</label>
                        <input type="text" style="cursor: pointer;" class="form-control col-md-7 date-picker" id="kssj" name="kssj" value="${kssj}" data-date-format="yyyy-mm" readonly>
                    </div>
                    <div class="form-group col-md-5 col-md-offset-2">
                        <label for="exampleInputEmail2" class="col-md-5">工资发放月份(止)：</label>
                        <input type="text" style="cursor: pointer;" class="form-control col-md-7 date-picker" id="jzsj" name="jzsj" value="${jzsj}" data-date-format="yyyy-mm" readonly>
                    </div>
                
                <div class="btn col-md-12 ps-btn mt-10" onclick="doSearch()">查询</div>
                <div class="col-md-12 mt-10"></div>
                <table class="table table-striped table-bordered text-center">
                    <thead class="mt-10">
                    <tr>
                        <td>序号</td>
                        <td>姓名</td>
                        <td>发放月份</td>
                        <td>财统工资(元)</td>
                        <td>本级经补贴(元)</td>
                        <td>更多的操作</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.content}" var="item" varStatus="c">
	                    <tr>
	                    	<td>${c.index + 1}</td>
	                    	<td>${item.xm}</td>
	                    	<td>${item.yf}</td>
	                    	<td>${item.yfxj}</td>
	                    	<td>${item.bjjbt.sfgz}</td>
	                    	<td><a href="#" ref="${item.id}" onclick="showDetail(this);" class="btn default btn-xs black" data-toggle="modal">查看</a></td>
	                    </tr>
                    </c:forEach>
                     <c:if test="${empty page.content}">
                        <tr><td colspan="12"><h4>没有数据</h4></td></tr>
                    </c:if>
                    </tbody>
                </table>
                <jsp:include page="../_include/_pageinfo.jsp"></jsp:include>
            </div>
        </div>
        </form>
    </div>
</div>
<div class="ps-fix" id="detail"></div>
<div class="mengbu"></div>
</body>
<script>
	//查询
	function doSearch(){
		var flag = true;
		if($('#kssj').val() != '' && $('#jzsj').val() != ''){
			if($('#kssj').val()>$('#jzsj').val()){
				alert("开始时间应该小于结束时间");
				flag = false;
			}
		}
		if(flag){
			$('#form').attr('action','${request.contextPath}/ytj/wages/index').submit();
		}
	}
	
	//查看详情
	function showDetail(obj){
		var id = $(obj).attr("ref");
		$(".ps-fix").css("display","block");
		$(".mengbu").css("display","block")
		$.post('${request.contextPath}/ytj/wages/detail?'+new Date().getTime(),{"id":id,"status":"0"},function(d){
			$("#detail").html(d);
		});
	}

	function lastMonth(obj){
		var id = $(obj).attr("ref");
		$.post('${request.contextPath}/ytj/wages/detail?'+new Date().getTime(),{"id":id,"status":"-1"},function(d){
			$("#detail").html(d);
			if($('#status').val()=="-1"){
				alert("已无更多工资记录!");
			}
		});
	}
	function nextMonth(obj){
		var id = $(obj).attr("ref");
		$.post('${request.contextPath}/ytj/wages/detail?'+new Date().getTime(),{"id":id,"status":"1"},function(d){
			$("#detail").html(d);
			if($('#status').val()=="1"){
				alert("下月工资尚未发放!");
			}
		});
	}
	
	
	$(function(){
		 Metronic.init();
		 $('.date-picker').datepicker({
			rtl: Metronic.isRTL(),
			autoclose: true,
			minViewMode:1,
			language:"cn"
		});
	});

	function bprint(){  
        bdhtml=window.document.body.innerHTML;    
	    sprnstr="<!--startprint-->";    
	    eprnstr="<!--endprint-->"; 
	    sprnstr1="<!--startprint1-->";
	    eprnstr1="<!--endprint1-->";
	    prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18,bdhtml.indexOf(eprnstr));    
	    prnhtml=prnhtml+bdhtml.substring(bdhtml.indexOf(sprnstr1)+19,bdhtml.indexOf(eprnstr1));    
	    window.document.body.innerHTML=prnhtml;  
	   // $('head').html('')
        window.print();  
        window.document.body.innerHTML=bdhtml; 
	}
	
	//关闭详情页面
	function exit(){
       $(".ps-fix").css({"display":"none",cursor: "pointer"});
       $(".mengbu").css("display","none");
	};
</script>
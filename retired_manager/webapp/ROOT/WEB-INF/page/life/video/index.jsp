<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>

<head>
<meta charset="utf-8">
<title></title>
<link rel='stylesheet' href='${request.contextPath}/defaults/css/style.css' media='screen' />
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
							<a href="/video">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/video">
							视频分享</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
					<!-- a class="btn blue" href="<c:url value='${request.contextPath}/video/create'/>"><i class="fa fa-plus"></i> 上传视频</a>
                	<a class="btn blue" href="<c:url value='${request.contextPath}/video/appr'/>"><i class="fa fa-times"></i> 删除视频</a-->
                	<jsp:include page="${request.contextPath}/defaults/layouts/_menu.jsp"/>
                </div>
              </div>
              </div>
              
<ul class="videohome">
	<c:forEach items="${list}" var="item" varStatus="c">
	<li>
    	<a href="javascript:void(0)" onclick="doView(${item.id})">
    	<c:if test="${empty item.slUrl}"><img class="smallpic" src="${request.contextPath}/defaults/img/video/default.jpg"/></c:if>
    	<c:if test="${!empty item.slUrl}"><img class="smallpic" src="${item.slUrl }"/></c:if>
    	</a>
		<a  class="videotitle" href="javascript:void(0)" onclick="doView(${item.id})">${item.title }</a>
        <div class="videointro">
        	<div class="videoname">${item.title }</div>
            <a href="javascript:void(0)" onclick="doView(${item.id})" class="videoplay"><img class="playbutton" src="${request.contextPath}/defaults/img/video/play.png" /></a>
            <div class="videoauthor"><span>${item.zjh }</span>&nbsp;&nbsp;上传于&nbsp;<span><fmt:formatDate value = "${item.cdate}" pattern ="yyyy-MM-dd"/></span> </div>
        </div>
	</li>	
	</c:forEach>
</ul>
</form>
<div class="row-fluid">   
     <div class="pagers"><s:pagination page="${paginate.page}" namespace="/" controller="video" includeParams="true" styleClass="pages fl_r"/></div>
</div>
<script>
$(document).ready(function() {
    $(".videohome li:eq(0)").children("a").children(".smallpic").attr("id","bigpic");
	$(".videohome li:eq(0)").css("width","495px");
    $(".videohome li:eq(0)").css("height","285px");
    $(".videohome li:eq(0)").children(".videotitle").css("width","485px");
    $(".videohome li:eq(0)").children(".videotitle").css("padding-left","5px");
    $(".videohome li:eq(0)").children(".videotitle").css("padding-right","5px");
    $(".videohome li:eq(0)").children(".videotitle").css("background-repeat","repeat-x");
    $(".videohome li:eq(0)").children(".videointro").css("width","495px");
    $(".videohome li:eq(0)").children(".videointro").css("height","285px");
    $(".videohome li:eq(0)").children(".videointro").children(".videoname").attr("id","videoname1");
    $(".videohome li:eq(0)").children(".videointro").children(".videoplay").attr("id","videoplay");
    $(".videohome li:eq(0)").children(".videointro").children(".videoauthor").attr("id","videoauthor");
	$(".videohome li").hover(
	function(){
		$(this).children(".videointro").fadeIn(250);}
	,function(){
		$(this).children(".videointro").fadeOut(100);}
	);
});
	function doCreate(){
		$('#frm').attr('action','/video/create').submit();
	}
	//查看
	function doView(id){
		frm.action = "${request.contextPath}/video/"+id+"/view";
		frm.submit();
	}
	//删除
	function doDel(){
		$('#frm').attr('action',"${request.contextPath}/video/appr").submit();
	}
</script>
</body>
</html>
						
			<script>
			/**$(document).ready(function(){
				$("#approve").click(function(){
					if($("input[name=id]:checked").length==0){
						alert("请选择您要审批的记录！");
						return false;
					}
				});
				$("#modalId").click(function(){
				if($("#spjg").val() == ""){
					alert("审批结果不能为空！");
					return false;
				}
				var spid = new Array();
				$("input[name=id]:checked").each(function(){
					spid.push($(this).val());
				});
				document.getElementById("spid").value = spid;
				$("#modalForm").attr("action","${request.contextPath}/picture/approve").submit();
			});
			}
			);
				
				//查看
				function doView(id){
						frm.action = "${request.contextPath}/video/"+id+"/view";
						frm.submit();
				}
				
				//查询
				function doSearch(){
					var frm = document.getElementById('frm');
					frm.submit();
				}*/
			</script>

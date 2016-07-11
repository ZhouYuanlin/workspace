<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html {width: 100%;height: 100%;margin:0;background:#fff; color:#666; font-size:14px; font-family: "Microsoft YaHei",Verdana, Arial, Helvetica, sans-serif;overflow-y: scroll;}
		#allmap{width:1200px;height:600px;}
		p{margin-left:5px; font-size:14px;}
		ol,ul,li { list-style:none; }
		td,th,caption { font-size:14px; }
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,input,button,textarea,p,blockquote,th,td { margin:0; padding:0; }
		input, textarea, button { font:14px Verdana,Helvetica,Arial,sans-serif; border: 1px solid #333;}
		address, caption, cite, code, dfn, em, strong, th, var { font-style:normal; font-weight:normal;}
		table { border-collapse:collapse; }
		.clear:after {
		    content: "";
		    display: block;
		    clear: both;
		}
		h1, h2, h3, h4, h5, h6 { font-weight:400; font-size:100%; }
		a { color:#666; text-decoration:none; }
		img {
		    vertical-align: middle;
		}
	</style>
	<link rel="stylesheet" href="${request.contextPath}/defaults/css/SearchInfoWindow_min.css"/>
	<link rel="stylesheet" href="${request.contextPath}/defaults/css/pagination.css"/>
	<link href="${request.contextPath}/defaults/css/map/map.css" rel="stylesheet">
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KqBcErtSGgg2CyEYcMNNd1vP"></script>
	<script type="text/javascript" src="${request.contextPath}/defaults/js/jquery.pagination.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
</head>
<body>
<form id="frm" action="<c:url value='${request.contextPath}/retmap'/>" method="post">
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="col-md-12">
			       <div class="portlet box grey">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<div class="controls">
										<div id="allmap"></div>
											<div class="search_box">
												<div class="search_top">
												        <ul class="search_condition clear">
												            <li class="current"><a href="#" onclick="gjdzcx()">地址查询</a></li>
												            <li><a href="#showdetail" id="approve1" class="current" onclick="sele();" data-toggle="modal">姓名查询</a></li>
												        </ul>
												        <div class="controls" id="getXM">
													        <div class="input">
													            <input type="text" name="jtdz" id="jtdz"><span id="cls"></span>
													            <a href="#" onclick="pointDzcx()">查询</a>
													        </div>
												        </div>
											    </div>
												<div id="address">
												</div>
												<div id="selectAddress">
												</div>
												<div id="Pagination" class="pagination" style="margin-left: 10px"></div>
											</div>
									</div>
								</div>
							</div>
							</div>
				        </div>
		       	 </div>
			</div>
		</div>
	</form>
	<div class="controls">
		<input type="hidden" id="sfzh" name="sfzh" value="${r.ret.sfzh}" class="form-control col-md-12" />
	</div>
<!-- 选择人员 -->
<div class="modal fade" id="showdetail" tabindex="-1" role="testModal" aria-hidden="true" style="width:570px;margin-left:50%;margin-left:-275px;margin-top:50px;">
 	<jsp:include page="_choice.jsp"/>
</div>	
<button onclick="" style="color:white blue;background-color: "></button><br>
<script type="text/javascript">
	
	/*
		页面首次加载时的地址
	*/
	// 百度地图API功能
	var map = new BMap.Map("allmap");    
	var point = new BMap.Point(116.404, 39.915);
	map.centerAndZoom(point, 10); // 初始化地图,设置中心点坐标和地图级别。
	map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
	map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
	map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT }));  //右下角，打开
	//给地图添加右键菜单
	var menu = new BMap.ContextMenu();
	var txtMenuItem = [
		{
			text:'放大',
			callback:function(){map.zoomIn()}
		},
		{
			text:'缩小',
			callback:function(){map.zoomOut()}
		}
	];
	for(var i=0; i < txtMenuItem.length; i++){
		menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
	}
	map.addContextMenu(menu);
	//滚轮滚动是否放大缩小
	map.enableScrollWheelZoom(); 
	map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
	//添加控件和比例尺
	var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
	var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角，仅包含平移和缩放按钮
	var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_RIGHT});
	/*缩放控件type有四种类型:
	BMAP_NAVIGATION_CONTROL_SMALL：仅包含平移和缩放按钮；BMAP_NAVIGATION_CONTROL_PAN:仅包含平移按钮；BMAP_NAVIGA */
	//添加控件和比例尺
	map.addControl(top_left_control);           
	map.addControl(mapType2); 

	
/**
 * 鼠标点击根据地质查询时,可以进行输入地址查询
 */
function gjdzcx(){
	location.reload();
	$('#getXM').html("");
	$("#selectAddress").html("");
	$("#address").html("");
	$('#Pagination').html("");
	
	$('#getXM').html("<div class='input'>"+
            "<input type='text' name='jtdz' id='jtdz'><span id='cls'></span>"+
            "<a onclick='pointDzcx()'>查询</a>"+
        "</div>");
	
}
/**
 * 选中某个地址后在地图上检索
 */
var address = "";
function pointJtdz(obj){
	/* $("#selectAddress").html(""); */
	$("#Pagination").html("");
	address = $(obj).attr("ref");
	var subAdd = address.substr(0,2);
	 /* address =document.getElementById(obj.id).text; */
	var map = new BMap.Map("allmap");    
	var local = new BMap.LocalSearch(map, {
		renderOptions:{
			map: map,
			panel: "results",//结果容器id  
			autoViewport: true,   //自动结果标注  
			selectFirstResult: true  , //指定到第一个目标 
			enableRouteSearchBox: true,
			enableRouteInfo:true},
			pageCapacity: 1
	});

	local.search(address);
		
		
		map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
		map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
		map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT }));  //右下角，打开
		//给地图添加右键菜单
		var menu = new BMap.ContextMenu();
		var txtMenuItem = [
			{
				text:'放大',
				callback:function(){map.zoomIn()}
			},
			{
				text:'缩小',
				callback:function(){map.zoomOut()}
			}
		];
		for(var i=0; i < txtMenuItem.length; i++){
			menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
		}
		map.addContextMenu(menu);
		//滚轮滚动是否放大缩小
		map.enableScrollWheelZoom(); 
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
		//添加控件和比例尺
		var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
		var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角，仅包含平移和缩放按钮
		var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_RIGHT});
		/*缩放控件type有四种类型:
		BMAP_NAVIGATION_CONTROL_SMALL：仅包含平移和缩放按钮；BMAP_NAVIGATION_CONTROL_PAN:仅包含平移按钮；BMAP_NAVIGA */
		//添加控件和比例尺
		map.addControl(top_left_control);           
		map.addControl(mapType2); 
		
		

}
/*
	输入地址 显示的姓名 点击链接时填充到上面的姓名中
*/
var djxm="";
function pointDjxm(obj){
	$("#Pagination").html("");
	$('#getXM').html("<div class='controls' id='getXM'>"+
				"<input type='text' id='xm'"+
				"value='${r.ret.xm}' class='form-control col-md-12' readonly>"+
		"</div>");
	var index = obj.id;
	var sfzhcx = document.getElementById("sfzhxc"+index+"").value;
	djxm=document.getElementById("djxmcx"+index+"").value;
	$('#xm').val(djxm);
	$.post('/retmap/ajaxdetail?'+new Date().getTime(),{sfzhcx:sfzhcx},function(d){
		$("#address").html(d);
	});
	$("#selectAddress").html("");
	$("#jtdz").val("");
}

/*
	根据地址查询
*/
//创建检索信息窗口对象
var searchInfoWindow = null;
var index = 0;
var myGeo = new BMap.Geocoder();
var adds = [];
var addr = [];
var n = 0;//计算器
var len = 0;
var addd = [];
function pointDzcx(){
	map.clearOverlays();
	var name = $("#jtdz").val();
	if($.trim(name)==""){
		alert("请输入要定位的人员家庭住址关键字");
		return false;
	}
	//标注前清空数据
	$('#selectAddress').html("");
	adds = [];
	index = 0;
	n=0;
	if($("#jtdz").val()!="" && $("#jtdz").val().trim()!=""){
		$.post('/retmap/ajax?'+new Date().getTime(),{jtdz:$("#jtdz").val()},function(data){
			
			var addressew=$("#jtdz").val();
			var subadd = addressew.substr(0,2);
			var local = new BMap.LocalSearch(map, {
				renderOptions:{
					map: map,
					panel: "results",//结果容器id  
					autoViewport: true,   //自动结果标注  
					selectFirstResult: true  , //指定到第一个目标 
					enableRouteSearchBox: true,
					enableRouteInfo:true},
					pageCapacity: 1
			});

			local.search(subadd);
			setTimeout(function(){
				map.setCenter(subadd);
				map.setZoom(9);  //将视图切换到指定的缩放等级，中心点坐标不变  
	        }, 500);
			var s = data.split(",");
			for(var i=0;i<s.length;i++){
					adds.push(s[i]);
			}
			addr = adds.slice(0,10);
			len = adds.length;
			bdGEO();
			getpagination(len);

		});
		
		
		
			
			
			
			
		$.post('/retmap/ajaxdetail?'+new Date().getTime(),{jtdz:$("#jtdz").val()},function(d){
			if(d != ''){
    			$("#selectAddress").html(d);
			}else{
				clear_overlay();
				alert("没有关键字的家庭住址,请维护后再操作");
			}
			if(adds.length==0){
				$("#Pagination").html("");
			}
			if((len/2)>1){
				$('#countsss').text("共"+len/2+"条结果");
			}
			
    	});
		$('#xm').val("");
		$("#address").html("");
	}else{
		$("#selectAddress").html("");
	}
}

function clear_overlay(){
	$("#selectAddress").hide();
	map.clearOverlays(); 
}
function bdGEO(){
	var add = "";
	if(((index+2)%2)!=0){
		add= addr[index];
	}
	geocodeSearch(add);
	index++;
}
function geocodeSearch(add){
	var addressew=$("#jtdz").val();
	var subadd = addressew.substr(0,2);
	if(index < addr.length){
		setTimeout(window.bdGEO,400);
		if(add!=""){
		myGeo.getPoint(add, function(points){
				$("#selectAddress").show();
				var addressas = new BMap.Point(points.lng, points.lat);
				var labels = new BMap.Label(add,{offset:new BMap.Size(20,-5)});
				labels.setStyle({ 
					fontSize : "14px", 
					border :"0px", 
					fontWeight :"bold"
					});
				addMarker(addressas,add,labels);
		}, subadd);
		}
	} 
}
// 编写自定义函数,创建标注
function addMarker(poi,add,label){
	var content = "";
	var marker = new BMap.Marker(poi);
	map.addOverlay(marker);
	content = "<div style='margin:0;line-height:20px;padding:2px;'>" +
    "地址:"+add+"<br>" +
  "</div>";
	searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
			title  : add,      		 //标题
			width  : 290,             //宽度
			height : 50,              //高度
			panel  : "address",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[
				BMAPLIB_TAB_SEARCH,   //周边检索
				BMAPLIB_TAB_TO_HERE,  //到这里去
				BMAPLIB_TAB_FROM_HERE //从这里出发
			]
	});
 	marker.addEventListener("click", function(e){
	    searchInfoWindow.open(marker);
    });
 	marker.setLabel(label);
	
}
//获取关键字提示框
function getSearchKey(add){
	
	  
}
function pageselectCallback(page_id, jq){
	n=page_id*10;
	addr = adds.slice(page_id*5,page_id*5+5);
	//标注前将之前的数据清空。
	index = 0;
	$('#selectAddress').html('');
	clear_overlay();
	$("#selectAddress").show();
	bdGEO();
}
//分页控件 add by pgf 2014-11-07
function getpagination(counts){
	// 创建分页元素
	$("#Pagination").pagination(counts, {
		num_edge_entries: 2,
		num_display_entries: 3,
		callback: pageselectCallback  //回调函数
	});
}
	
</script>
</body>
</html>
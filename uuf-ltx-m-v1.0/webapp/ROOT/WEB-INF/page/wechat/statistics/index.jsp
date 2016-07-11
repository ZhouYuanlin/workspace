<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>微信统计页面</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
   <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/aui.css" />
    <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/aui-slide.css" />
   <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/aui-iconfont.css" />
   <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/tjym.css"/>
   <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/css/bootstrap/bootstrap-responsive.min.css" />
   <script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/jquery-1.11.2.min.js"></script>
   <script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/echarts.min.js"></script>
   <script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/aui-slide.js"></script>
   <%-- <script type="text/javascript" src="${request.getContextPath}/resources/framework/bootstrap-v3.3.1/js/bootstrap.min.js"></script> --%>
  
</head>
<body>
<div class="mt20"></div>
<div class="aui-padded-10" style="background-color: white !important;">
    <div id="yuanboth">

    </div>
</div>
<div id="aui-slide" class="mt20">
    <div class="aui-slide-wrap" >
        <div class="aui-slide-node">
            <div id="yuan1" class="aui-col-xs-12">
            </div>
            <div style="z-index:1;color: red;position: absolute;top: 20px;right: 20px">
                <p class="p1"><span style="color: #009cf3;">&#xe645;</span>&nbsp;男性</p>
                <p class="p2"><span style="color: #f7888f;">&#xe647;</span>&nbsp;女性</p>
            </div>
        </div>
        <div class="aui-slide-node">
            <div id="yuan2" class="aui-col-xs-12">
            </div>
            <div style="z-index:1;color: red;position: absolute;top: 20px;right: 20px">
                <p class="p1"><span style="color: #009cf3;">&#xe645;</span>&nbsp;男性</p>
                <p class="p2"><span style="color: #f7888f;">&#xe647;</span>&nbsp;女性</p>
            </div>
        </div>
        <div class="aui-slide-node bg-dark">
            <div id="yuan3" class="aui-col-xs-12">
            </div>
            <div style="z-index:1;color: red;position: absolute;top: 20px;right: 20px">
                <p class="p1"><span style="color: #009cf3;">&#xe645;</span>&nbsp;男性</p>
                <p class="p2"><span style="color: #f7888f;">&#xe647;</span>&nbsp;女性</p>
            </div>
        </div>
    </div>
    <div class="aui-slide-page-wrap"></div>
</div>
<div class="aui-text-center">
    <!--<h2>性别比例</h2>-->
</div>
<div id="aui-slide1" class="mt20">
    <div class="aui-slide-wrap" >
        <div class="aui-slide-node">
                <div id="main" class="aui-col-xs-12">

                </div>
        </div>
        <div class="aui-slide-node">
                <div id="main2" class="aui-col-xs-12">

                </div>
        </div>
        <div class="aui-slide-node bg-dark">
                <div id="main3" class="aui-col-xs-12">

                </div>
        </div>
    </div>
    <div class="aui-slide-page-wrap"></div>
</div>
<div class=" aui-text-center">
    <span style="font-size: 20px;line-height: 40px;font-weight: bolder;color: #333">年龄段分布</span>
</div>
<div id="aui-slide2" class="mt20">
    <div class="aui-slide-wrap" >
        <div class="aui-slide-node">
                <div id="main4" class="aui-col-xs-12">

                </div>
        </div>
        <div class="aui-slide-node">
                <div id="main5" class="aui-col-xs-12">

                </div>
        </div>
        <div class="aui-slide-node bg-dark">
                <div id="main6" class="aui-col-xs-12">

                </div>
        </div>
    </div>
    <div class="aui-slide-page-wrap"></div>
</div>
<div class=" aui-text-center">
    <span style="font-size: 20px;line-height: 40px;font-weight: bolder;color: #333">年龄分布</span>
</div>
<div id="aui-slide3" class="mt20">
    <div class="aui-slide-wrap" >
        <div class="aui-slide-node">
            <div id="main7" class="aui-col-xs-12">

            </div>
        </div>
        <div class="aui-slide-node">
            <div id="main8" class="aui-col-xs-12">

            </div>
        </div>
        <div class="aui-slide-node bg-dark">
            <div id="main9" class="aui-col-xs-12">

            </div>
        </div>
    </div>
    <div class="aui-slide-page-wrap"></div>
</div>
<div class=" aui-text-center">
    <span style="font-size: 20px;line-height: 40px;font-weight: bolder;color: #333">离退休职级比例</span>
</div>
<div id="aui-slide4" class="mt20">
    <div class="aui-slide-wrap" >
        <div class="aui-slide-node">
            <div id="main10" class="aui-col-xs-12">

            </div>
        </div>
        <div class="aui-slide-node">
            <div id="main11" class="aui-col-xs-12">

            </div>
        </div>
        <div class="aui-slide-node bg-dark">
            <div id="main12" class="aui-col-xs-12">

            </div>
        </div>
    </div>
    <div class="aui-slide-page-wrap"></div>
</div>
<div class=" aui-text-center">
    <span style="font-size: 20px;line-height: 40px;font-weight: bolder;color: #333">离退休年份分布</span>
</div>
<div id="aui-slide5" class="mt20">
    <div class="aui-slide-wrap" >
        <div class="aui-slide-node">
            <div id="main13" class="aui-col-xs-12">

            </div>
        </div>
        <div class="aui-slide-node">
            <div id="main14" class="aui-col-xs-12">

            </div>
        </div>
        <div class="aui-slide-node bg-dark">
            <div id="main15" class="aui-col-xs-12">

            </div>
        </div>
    </div>
    <div class="aui-slide-page-wrap"></div>
    <div class=" aui-text-center">
        <span style="font-size: 20px;line-height: 40px;font-weight: bolder;color: #333">离退休离世分布</span>
    </div>
</div>
</body>
<script type="text/javascript" >
/*轮播组件*/
var slide= new auiSlide({
    container:document.getElementById("aui-slide"),
    //"width":300,
    "height":240,
    "speed":500,
    //"autoPlay": 3000, //自动播放
    "loop":true,
    "pageShow":true,
    "pageStyle":'line',
    'dotPosition':'center'
})
var slide1= new auiSlide({
    container:document.getElementById("aui-slide1"),
     //"width":300,
    "height":240,
    "speed":500,
    //"autoPlay": 3000, //自动播放
    "loop":true,
    "pageShow":true,
    "pageStyle":'line',
    'dotPosition':'center'
})
var slide2= new auiSlide({
    container:document.getElementById("aui-slide2"),
    //"width":300,
    "height":240,
    "speed":500,
    //"autoPlay": 3000, //自动播放
    "loop":true,
    "pageShow":true,
    "pageStyle":'line',
    'dotPosition':'center'
})
var slide3= new auiSlide({
    container:document.getElementById("aui-slide3"),
    //"width":300,
    "height":240,
    "speed":500,
    //"autoPlay": 3000, //自动播放
    "loop":true,
    "pageShow":true,
    "pageStyle":'line',
    'dotPosition':'center'
})
var slide4= new auiSlide({
    container:document.getElementById("aui-slide4"),
    //"width":300,
    "height":240,
    "speed":500,
    //"autoPlay": 3000, //自动播放
    "loop":true,
    "pageShow":true,
    "pageStyle":'line',
    'dotPosition':'center'
})
var slide5= new auiSlide({
    container:document.getElementById("aui-slide5"),
    //"width":300,
    "height":240,
    "speed":500,
    //"autoPlay": 3000, //自动播放
    "loop":true,
    "pageShow":true,
    "pageStyle":'line',
    'dotPosition':'center'
})

//保留两位小数
var Digit = {};
Digit.round = function(digit, length) {
length = length ? parseInt(length) : 0;
if (length <= 0) return Math.round(digit);
digit = Math.round(digit * Math.pow(10, length)) / Math.pow(10, length);
 return digit;
}
/*柱状图*/
// 基于准备好的dom，初始化echarts实例
//年龄段分布
var myChart = echarts.init(document.getElementById('main'));
// 指定图表的配置项和数据
var option = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离退休',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y:40,
        y2:50
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
    //barWidth:30,
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
        data: [<c:forEach items="${ageMaps}" var="item" varStatus="x">
		<c:forEach items="${item.value}" var="chi" varStatus="c">
		{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		</c:forEach>
		</c:forEach>],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
'#0d88ff','#e35b67','#8d33e0','#32cd33','#ff5c21'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter:  '{c}'
                }
            }
        }

    }]
};
var myChart2 = echarts.init(document.getElementById('main2'));
// 指定图表的配置项和数据
var option2 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离休',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
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
'#0d88ff','#e35b67','#8d33e0','#32cd33','#ff5c21'
                    ];
                    return colorList[params.dataIndex]
                },
                label: {
                    show: true,
                    position: 'top',
                    formatter:  '{c}'
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
    title : {
        text: '退休',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
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
'#0d88ff','#e35b67','#8d33e0','#32cd33','#ff5c21'
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
//年龄按平均年龄，最大年龄，最小年龄分布
var myChart4 = echarts.init(document.getElementById('main4'));
// 指定图表的配置项和数据
var option4 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'岁',  

            show: true  

        },
    title : {
        text: '离退休',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
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
'#ff8643','#2191ff','#32cd33'
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
var myChart5 = echarts.init(document.getElementById('main5'));
//指定图表的配置项和数据
var option5 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'岁',  

            show: true  

        },
 title : {
     text: '离休',
     x:'center',
     textStyle:{
         fontSize:18,
         fontWeight:100
     }
 },
 calculable: true,
 //控制柱状图大小
 grid: {
     borderWidth: 0,
     y: 40,
     y2:50
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
 //barWidth:30,
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
'#ff8643','#2191ff','#32cd33'
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
var myChart6 = echarts.init(document.getElementById('main6'));
//指定图表的配置项和数据
var option6 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'岁',  

            show: true  

        },
 title : {
     text: '退休',
     x:'center',
     textStyle:{
         fontSize:18,
         fontWeight:100
     }
 },
 calculable: true,
 //控制柱状图大小
 grid: {
     borderWidth: 0,
     y: 40,
     y2:50
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
 //barWidth:30,
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
'#ff8643','#2191ff','#32cd33'
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
//职级分布
var myChart7 = echarts.init(document.getElementById('main7'));
var option7 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离退休职级比例',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: [<c:forEach items="${postionMaps}" var="item" varStatus="x">
        <c:forEach items="${item.value}" var="chi" varStatus="c">"${chi[0]}"<c:if test="${!c.last}">,</c:if></c:forEach>
		</c:forEach>],
        splitLine:{
            show:false
        }
    },
    //Y轴大小
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离退休职级比例',
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
var myChart8 = echarts.init(document.getElementById('main8'));
var option8 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离休职级比例',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离休职级比例',
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
    title : {
        text: '退休职级比例',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '退休职级比例',
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
//第离退休按时间分布
var myChart10 = echarts.init(document.getElementById('main10'));
var option10 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离退休年份分布',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 49,
        y2:50
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
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离退休年份分布',
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
'#e25f65','#8a64ad','#e27c54','#62a9e1','#72c380'
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
var myChart11 = echarts.init(document.getElementById('main11'));
var option11 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离休年份分布',
        x:'center'
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离休年份分布',
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
'#e25f65','#8a64ad','#e27c54','#62a9e1','#72c380'
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
var myChart12 = echarts.init(document.getElementById('main12'));
var option12 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '退休年份分布',
        x:'center'
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '退休年份分布',
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
'#e25f65','#8a64ad','#e27c54','#62a9e1','#72c380'
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
//离世分布
var myChart13 = echarts.init(document.getElementById('main13'));
var option13 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离退休离世分布',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离退休离世分布',
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
'#e25f65','#e27c54','#8a64ad','#62a9e1','#72c380'
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
var option14 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离休离世分布',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '离休离世分布',
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
'#e25f65','#e27c54','#8a64ad','#62a9e1','#72c380'
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
    title : {
        text: '退休离世分布',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 40,
        y2:50
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
    //barWidth:30,
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    //柱状图数据
    series: [{
        name: '退休离世分布',
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
'#e25f65','#e27c54','#8a64ad','#62a9e1','#72c380'
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


/*饼图*/
var myChart16= echarts.init(document.getElementById('yuan1'));
var option16 = {
	tooltip: {},
    title : {
        text: '离退休总比例',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    color:['#009cf3', '#f7888f'],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    calculable : true,
    series : [
        {
            name:'性别比例',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
					<c:forEach items="${sexLtxMaps}" var="item" varStatus="x">
					<c:forEach items="${item.value}" var="chi" varStatus="c">
					{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}性比例</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
					</c:forEach>
					</c:forEach>

            ]
        }
    ]
};
myChart16.setOption(option16);
var myChart17= echarts.init(document.getElementById('yuan2'));
var option17 = {
	tooltip: {},
    title : {
        text: '离休比例',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    color:['#df6164', '#62a9e1'],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    calculable : true,
    series : [
        {
            name:'性别比例',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
			<c:forEach items="${sexLxMaps}" var="item" varStatus="x">
			<c:forEach items="${item.value}" var="chi" varStatus="c">
			{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}性比例</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
			</c:forEach>
			</c:forEach>

            ]
        }
    ]
};
myChart17.setOption(option17);
var myChart18= echarts.init(document.getElementById('yuan3'));
var option18= {
	tooltip: {},
    title : {
        text: '退休比例',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    color:['#df6164', '#62a9e1'],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
   /*  toolbox: {
        show : true,
        feature : {
            //mark : {show: true},
            //dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    }, */
    calculable : true,
    series : [
        {
            name:'性别比例',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
<c:forEach items="${sextxMaps}" var="item" varStatus="x">
<c:forEach items="${item.value}" var="chi" varStatus="c">
{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}性比例</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
</c:forEach>
</c:forEach>

            ]
        }
    ]
};
myChart18.setOption(option18);
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
var myChart19= echarts.init(document.getElementById('yuanboth'));
var option19 = {
		tooltip: {  
			  
            trigger: 'item',  

            formatter: '{b} : {c}'+'人',  

            show: true  

        },
    title : {
        text: '离退休总人数：'+totalCount+'人',
        x:'center',
        textStyle:{
            fontSize:18,
            fontWeight:100
        }
    },
    color:['#4d7ad5', '#f28041'],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    calculable : true,
    series : [
        {
            //name:'离退休比例',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
<c:forEach items="${ltxTotalMaps}" var="item" varStatus="x">
<c:forEach items="${item.value}" var="chi" varStatus="c">
{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}人数及比例</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
</c:forEach>
</c:forEach>

            ]
        }
    ]
};
myChart19.setOption(option19);
</script>
</html>
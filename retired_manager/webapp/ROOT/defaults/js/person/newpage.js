$(document).ready(function() {
    var countnum = 200;
    var lxnum = 100;
    var txnum = countnum - lxnum;
    $(".tj-headone>span").html(countnum);
    var divwidth=$(".tj-headtwo").width();
    //alert(divwidth)
    lxweight = lxnum / countnum * divwidth;
    txweight = txnum / countnum * divwidth;
    //alert(txweight);
    //离退休比例分配
    $(".tj-headtwo-a").css({
        "width": lxweight,
        "background-color": "#26727a"
    }).html("离休人数" + parseFloat((lxnum / countnum) * 100) + "%");
    $(".tj-headtwo-b").css({
        "width": txweight,
        "background-color": "#b5c334"
    }).html("退休人数" + (100 - parseFloat((lxnum / countnum) * 100) + "%"));
   //性别比例
    var womannum=50;
    var mannum=countnum-womannum;
    var womanbili=parseFloat(womannum/countnum);
    var manbili=parseFloat(1-(womannum/countnum));
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

    $(".tj-twob>.tj-twob-nv>.tj-nvword>p:nth-child(1)").html((womanbili*100)+"%");
    $(".tj-twob>.tj-twob-nv>.tj-nvword>p:nth-child(2)").html("女"+womannum+"人");
    $(".tj-twob>.tj-twob-nan>.tj-nanword>p:nth-child(1)").html(100*(1-womanbili)+"%");
    $(".tj-twob>.tj-twob-nan>.tj-nanword>p:nth-child(2)").html("男"+mannum+"人");
    //第二性别比例
    if(womanbili>0&&womanbili<=0.1){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").eq(0).css({"color":"#fa3f94"}).siblings().css({"color":"#d7d7d8"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").eq(9).css({"color":"#d7d7d8"}).siblings().css({"color":"#3c94cd"});
    }else if(womanbili>0.1&&womanbili<=0.2){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,2).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,8).css({"color":"#3c94cd"});
    }else if(womanbili>0.2&&womanbili<=0.3){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,3).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,7).css({"color":"#3c94cd"});
    }else if(womanbili>0.3&&womanbili<=0.4){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,4).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,6).css({"color":"#3c94cd"});
    }else if(womanbili>0.4&&womanbili<=0.5){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,5).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,5).css({"color":"#3c94cd"});
    }else if(womanbili>0.5&&womanbili<=0.6){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,6).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,4).css({"color":"#3c94cd"});
    }else if(womanbili>0.6&&womanbili<=0.7){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,7).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,3).css({"color":"#3c94cd"});
    }else if(womanbili>0.7&&womanbili<=0.8){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,8).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,2).css({"color":"#3c94cd"});
    }else if(womanbili>0.8&&womanbili<=0.9){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,9).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,1).css({"color":"#3c94cd"});
    }else if(womanbili>0.9&&womanbili<=1){
        $(".tj-twoc>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,1).css({"color":"#fa3f94"});
        $(".tj-twoc>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,9).css({"color":"#3c94cd"});
    }

    $(".tj-twoc>.tj-twob-nv>.tj-nvword>p:nth-child(1)").html((womanbili*100)+"%");
    $(".tj-twoc>.tj-twob-nv>.tj-nvword>p:nth-child(2)").html("女"+womannum+"人");
    $(".tj-twoc>.tj-twob-nan>.tj-nanword>p:nth-child(1)").html(100*(1-womanbili)+"%");
    $(".tj-twoc>.tj-twob-nan>.tj-nanword>p:nth-child(2)").html("男"+mannum+"人");
    //第二性别比例
    if(womanbili>0&&womanbili<=0.1){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").eq(0).css({"color":"#fa3f94"}).siblings().css({"color":"#d7d7d8"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").eq(9).css({"color":"#d7d7d8"}).siblings().css({"color":"#3c94cd"});
    }else if(womanbili>0.1&&womanbili<=0.2){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,2).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,8).css({"color":"#3c94cd"});
    }else if(womanbili>0.2&&womanbili<=0.3){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,3).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,7).css({"color":"#3c94cd"});
    }else if(womanbili>0.3&&womanbili<=0.4){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,4).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,6).css({"color":"#3c94cd"});
    }else if(womanbili>0.4&&womanbili<=0.5){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,5).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,5).css({"color":"#3c94cd"});
    }else if(womanbili>0.5&&womanbili<=0.6){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,6).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,4).css({"color":"#3c94cd"});
    }else if(womanbili>0.6&&womanbili<=0.7){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,7).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,3).css({"color":"#3c94cd"});
    }else if(womanbili>0.7&&womanbili<=0.8){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,8).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,2).css({"color":"#3c94cd"});
    }else if(womanbili>0.8&&womanbili<=0.9){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,9).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,1).css({"color":"#3c94cd"});
    }else if(womanbili>0.9&&womanbili<=1){
        $(".tj-twod>.tj-twob-nv>.tj-nvfarm>ul>li").slice(0,1).css({"color":"#fa3f94"});
        $(".tj-twod>.tj-twob-nan>.tj-nanfarm>ul>li").slice(0,9).css({"color":"#3c94cd"});
    }

    $(".tj-twod>.tj-twob-nv>.tj-nvword>p:nth-child(1)").html((womanbili*100)+"%");
    $(".tj-twod>.tj-twob-nv>.tj-nvword>p:nth-child(2)").html("女"+womannum+"人");
    $(".tj-twod>.tj-twob-nan>.tj-nanword>p:nth-child(1)").html(100*(1-womanbili)+"%");
    $(".tj-twod>.tj-twob-nan>.tj-nanword>p:nth-child(2)").html("男"+mannum+"人");

});

// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
// 指定图表的配置项和数据
var option = {
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
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
        data: [12, 21, 10, 4, 12],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
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
        data: [12, 21, 10, 4, 12],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
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
        data: [12, 21, 10, 4, 12],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
var option4 = {
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
    },
    //X轴大小
    barWidth:30,
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['局长','主任','科长','所长','厅长'],
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
        data: [15, 7, 10, 5, 3],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
var myChart5 = echarts.init(document.getElementById('main5'));
var option5 = {
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['局长','主任','科长','所长','厅长'],
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
        data: [2, 7, 5, 12, 17],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
var myChart6 = echarts.init(document.getElementById('main6'));
var option6 = {
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['局长','主任','科长','所长','厅长'],
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
        data: [5,12,8,4,13],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
var myChart7 = echarts.init(document.getElementById('main7'));
var option7 = {
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['2013','2014','2015','2016'],
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
        data: [6,5,25,23],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
var myChart8 = echarts.init(document.getElementById('main8'));
var option8 = {
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['2013','2014','2015','2016'],
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
        data: [7,5,8,4],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
var myChart9 = echarts.init(document.getElementById('main9'));
var option9 = {
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['2013','2014','2015','2016'],
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
        data: [5,12,8,4],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
var myChart10 = echarts.init(document.getElementById('main10'));
var option10= {
    tooltip: {},
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 25,
        y2:25
    },
    //X轴大小
    xAxis: {
        type: 'category',
        axisLabel: {
            interval: 0
        },
        data: ['2013','2014','2015','2016'],
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
        data: [4,5,8,6,1],

        itemStyle: {
            normal: {
                color: function(params) {
                    // build a color map as your need.
                    var colorList = [
                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'
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
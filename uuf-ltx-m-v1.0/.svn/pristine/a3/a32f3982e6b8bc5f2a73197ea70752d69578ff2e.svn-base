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

/*柱状图*/
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
// 指定图表的配置项和数据
var option = {
    title : {
        text: '离退休',
        x:'center',
        textStyle:{
          fontsize:12,
          fontstyle:'oblique',
          fontweight:'lighter'
        }
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 30,
        y2:30
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
        data: [120, 210, 100, 900, 120],

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
var myChart2 = echarts.init(document.getElementById('main2'));
// 指定图表的配置项和数据
var option2 = {
    tooltip: {},
    title : {
        text: '离休',
        x:'center'
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 30,
        y2:30
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
    title : {
        text: '退休',
        x:'center'
    },
    calculable: true,
    //控制柱状图大小
    grid: {
        borderWidth: 0,
        y: 30,
        y2:30
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
    title : {
        text: '离退休',
        x:'center'
    },
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
    //barWidth:30,
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
var myChart5 = echarts.init(document.getElementById('main5'));
var option5 = {
    title : {
        text: '离休',
        x:'center'
    },
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
    //barWidth:30,
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
    title : {
        text: '退休',
        x:'center'
    },
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
    //barWidth:30,
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
    title : {
        text: '离退休',
        x:'center'
    },
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
    //barWidth:30,
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
var myChart8 = echarts.init(document.getElementById('main8'));
var option8 = {
    title : {
        text: '离休',
        x:'center'
    },
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
    //barWidth:30,
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
var myChart9 = echarts.init(document.getElementById('main9'));
var option9 = {
    title : {
        text: '退休',
        x:'center'
    },
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
    //barWidth:30,
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
var myChart10 = echarts.init(document.getElementById('main10'));
var option10 = {
    title : {
        text: '离退休',
        x:'center'
    },
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
    //barWidth:30,
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
var myChart11 = echarts.init(document.getElementById('main11'));
var option11 = {
    title : {
        text: '离休',
        x:'center'
    },
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
    //barWidth:30,
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
var myChart12 = echarts.init(document.getElementById('main12'));
var option12= {
    title : {
        text: '退休',
        x:'center'
    },
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
    //barWidth:30,
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
myChart11.setOption(option11);
myChart12.setOption(option12);


/*饼图*/
var myChart13= echarts.init(document.getElementById('yuan1'));
var option13 = {
    title : {
        text: '离退休总比例',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    toolbox: {
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
    },
    calculable : true,
    series : [
        {
            name:'离退休比例',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'女性比例'},
                {value:310, name:'男性比例'}

            ]
        }
    ]
};
myChart13.setOption(option13);
var myChart14= echarts.init(document.getElementById('yuan2'));
var option14 = {
    title : {
        text: '离休比例',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    toolbox: {
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
    },
    calculable : true,
    series : [
        {
            name:'离退休比例',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'女性比例'},
                {value:310, name:'男性比例'}

            ]
        }
    ]
};
myChart14.setOption(option14);
var myChart15= echarts.init(document.getElementById('yuan3'));
var option15 = {
    title : {
        text: '退休比例',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    toolbox: {
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
    },
    calculable : true,
    series : [
        {
            name:'离退休比例',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'女性比例'},
                {value:310, name:'男性比例'}

            ]
        }
    ]
};
myChart15.setOption(option15);
var no=100;
/*总比例*/
//$(document).ready(function(){
//    var countnum = 200;
//    var lxnum = 50;
//    var txnum = countnum - lxnum;
//    var divwidth=$(".xiuboth").width();
//    lxweight = lxnum / countnum * divwidth+"px";
//    txweight = txnum / countnum * divwidth+"px";
//    //alert(lxweight)
//    //alert(txweight)
//    //离退休比例分配
//    $(".lixiu").css({
//        "width":lxweight,
//        "background-color": "#26727a",
//        "transition": "all .5s linear"
//    }).html("退休人数" + (100 - parseFloat((lxnum / countnum) * 100) + "%"));
//    $(".tuixiu").css({
//        "width":txweight,
//        "background-color": "#b5c334",
//        "transition": "all .5s linear"
//    }).html("退休人数" + (100 - parseFloat((lxnum / countnum) * 100) + "%"));
//})
var myChart16= echarts.init(document.getElementById('yuanboth'));
var option16 = {
    title : {
        text: '离退休总'+no+'人',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
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
    },
    calculable : true,
    series : [
        {
            //name:'离退休比例',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'离休'},
                {value:310, name:'退休'}

            ]
        }
    ]
};
myChart16.setOption(option16);
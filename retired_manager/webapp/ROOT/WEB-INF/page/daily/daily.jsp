<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head></head>
<body>
<link rel="stylesheet" type="text/css" href="${request.contextPath}/defaults/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css"/>
<link href="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet"/>
<script src="${request.contextPath}/defaults/plugins/My97DatePicker/WdatePicker.js" type="text/javascript" ></script>
<script type="text/javascript" src="${request.contextPath}/defaults/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
<script src="${request.contextPath}/defaults/plugins/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
	<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<ul class="page-breadcrumb breadcrumb">
							<li>
								<i class="fa fa-home"></i>
								<a href="/">
								首页 </a>
								<i class="fa fa-angle-right"></i>
							</li>
							<li> 
								<a href="/workdaily">
								工作日志 </a>
							</li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12">
					<div class="">
						<div id="calendar" class="has-toolbar">
						</div>
					</div>
					</div>
				</div>	
				</div>
			</div>
			
			<!-- 日程事件窗口 -->
			<div class="modal fade" id="dateModal" aria-hidden="true" style="width:850px;margin-left:50%;margin-left:-425px;margin-top:20px;">
			  <jsp:include page="_info.jsp"/>
			</div>
			<script type="text/javascript">
				$(function(){
					Calendar();
					<c:if test="${w.status == '1' || w.status == '2'}">
						var d = $.fullCalendar.formatDate(new Date(), "yyyyMMddHHmmss");
						$.post('/workdaily/ajaxCreate?'+new Date().getTime(),{"d":d,"t":'${w.status}'},function(d){
							$("#dateModal").html(d);
						});
						$('#dateModal').modal();
					</c:if>
				});
					var Calendar = function () {
					var date = new Date();
					var d = date.getDate();
					var m = date.getMonth();
					var y = date.getFullYear();
					$('#calendar').fullCalendar({
				            theme: false,
							height: 650,
				            header: {
								left:'prevYear,nextYear',//'prev,next today',
								center: 'title',
								right: 'prev,next today'

				            },
				         
				            monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
				            monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
				            dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
				            dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
				            today: ["今天"],
				            firstDay: 1,
				            buttonText: {
				                today: '本月',
				                month: '月',
				                week: '周',
				                day: '日',
				                prev: '上一月',
				                next: '下一月'
				            },
							eventLimit: true,
				            editable: false,//判断该日程能否拖动
				            //后台数据填充
							events: function(start, end , callback){//生成日历
						        var events = [];
						        $.ajax({
						            'url':"${request.contextPath}/workdaily/ajaxcanlendar?time="+new Date().getTime(),
						            'data': {                
						                startDate:$.fullCalendar.formatDate(start,"yyyy-MM-dd HH:mm:ss"),
						                endDate:$.fullCalendar.formatDate(end,"yyyy-MM-dd HH:mm:ss")       
						            },
						            'dataType': 'json',
						            'type': 'post',
						            'error': function(data){
						                alert("数据获取失败");
						                return false;
						             },
						            'success': function(doc) {
						                $(doc).each(function(i) {
						                    events.push({
						                        title: doc[i].title.length > 10 ? doc[i].title.substring(0,10)+"..." : doc[i].title,
						                        id:doc[i].id,
						                        content:doc[i].content,
						                        backgroundColor:doc[i].backgroundColor,
						                        start: doc[i].start
						                    });
						                });
						                callback(events);//
						            }
						        }); 
						        },
							dayClick: function(date, allDay, jsEvent, view) {
								var d = $.fullCalendar.formatDate(date, "yyyyMMddhhmmss");
								$.post('/workdaily/ajaxCreate?'+new Date().getTime(),{"d":d},function(d){
									$("#dateModal").html(d);
								});
								$('#dateModal').modal();
							},
							eventClick: function(event) {
								$.post('/workdaily/ajaxCreate?'+new Date().getTime(),{"id":event.id},function(d){
									$("#dateModal").html(d);
								});
								$('#dateModal').modal();
							},
							eventMouseover: function (calEvent, jsEvent, view) {
				                var fstart = $.fullCalendar.formatDate(calEvent.start, "yyyy/MM/dd");
				                //var fend = calEvent.end;
				                $(this).attr('title', fstart + "标题" + " : " + calEvent.content);
				                $(this).css('font-weight', 'normal');
				                /**$(this).tooltip({
				                    effect: 'toggle',
				                    cancelDefault: true
				                });*/
				            },
						});
					}
			</script>
</body>
</html>
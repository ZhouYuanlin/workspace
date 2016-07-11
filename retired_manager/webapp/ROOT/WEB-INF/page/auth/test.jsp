<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!--[if IE 7]> <html lang="en" class="ie7 no-js"> <![endif]-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>离退休干部管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<link href="css/main.css" rel="stylesheet" type="text/css"/>
<link href="css/page-monitor.css" rel="stylesheet" type="text/css"/>
</head>

<body class="page-header-fixed page-full-width page-hidden-breadcrumb page-portal">
<div class="page-header navbar navbar-fixed-top"> 
  <div class="page-header-inner"> 
    <div class="page-logo"> <a href="index.html"> 离退休干部管理系统</a> </div>
    <div class="hor-menu hor-menu-light hidden-sm hidden-xs">
			<ul class="nav navbar-nav">
				<li><a href="index.html"><i class="fa fa-home"></i>首 页</a></li>
				<li class="classic-menu-dropdown active">
				<a href="#"><i class="fa fa-user"></i>人员信息<span class="selected"></span></a>
				</li>
				<li><a href="#"><i class="fa fa-star"></i>党员管理</a></li>
				<li><a href="#"><i class="fa fa-gift"></i>慰问服务</a></li>
				<li><a href="#"><i class="fa fa-flag"></i>活动管理</a></li>
				<li><a href="#"><i class="fa fa-bookmark"></i>表彰管理</a></li>
				<li><a href="#"><i class="fa fa-medkit"></i>医疗健康</a></li>
			</ul>
    </div>
    <div class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </div>
    <div class="top-menu">
      <ul class="nav navbar-nav pull-right">
        <li class="dropdown dropdown-user"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> <span class="username"><i class="fa fa-user"></i> Admin </span> <i class="fa fa-angle-down"></i> </a>
          <ul class="dropdown-menu">
            <li> <a href="extra_profile.html"> <i class="fa fa-gift"></i> 风格设置 </a> </li>
            <li> <a href="#"> <i class="fa fa-gear"></i> 系统设置 </a> </li>
            <li class="divider"> </li>
            <li> <a href="login.html"> <i class="fa fa-key"></i> 退出 </a> </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</div>
<div class="clearfix"> </div>
<div class="page-container"> 
  <div class="page-content-wrapper">
    <div class="page-content"> 
      <div class="row">
        <div class="col-md-12"> 
          <ul class="page-breadcrumb breadcrumb">
            <li> <i class="fa fa-home"></i> <a href="index.html"> 首页 </a> <i class="fa fa-angle-right"></i> </li>
            <li> <a href="#"> 综合门户 </a> <i class="fa fa-angle-right"></i> </li>
          </ul>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4 col-sm-12">
          <div class="portlet box grey">
            <div class="portlet-title">
              <div class="caption">用户信息</div>
              <div class="tools"> <a href="" class="collapse"></a> </div>
            </div>
            <div class="portlet-body" style="height:240px;">
            <div class="scroller-div"  style="height:210px;">
				<div class="media">
						<a href="#" class="pull-left user-photo">
						<img alt="" src="img/none.jpg" class="media-object">
						</a>
						<div class="media-body">
							<h4>你好，周丽文<span>
							</h4>
							<p class="media-txt">
								 变化是永恒的主题，不变是相对的定义。节气在变，从寒露到霜降，从小雪到大雪，不变的是依然的牵挂。早上好！愿你快乐幸福每一天！
							</p>
						</div>
				</div>
				<p class="mgt10"> <a href="#" class="btn bg-green-meadow btn-sm"><i class="fa fa-bullhorn icon"></i> 生日提示</a>
				今日有  <span class="label label-success"> 0</span> 人，本周有  <span class="label label-success"> 3</span> 人，本月有  <span class="label label-success"> 4</span>人</p>
			</div>
            </div>
          </div>
        </div>
        <div class="col-md-4 col-sm-12"> 
          <!-- BEGIN BASIC CHART PORTLET-->
          <div class="portlet box grey">
            <div class="portlet-title">
              <div class="caption"> 个人待办 </div>
              <div class="tools"> <a href="" class="collapse"> </a> </div>
            </div>
            <div class="portlet-body">
              <div class="search-div"  style="height:210px;">
				<ul class="list-group">
									<li class="list-group-item">
										<a href="#">今日待办项 <span class="badge badge-warning pull-right">5</span></a>
									</li>
									<li class="list-group-item">
										<a href="#">本周待办项 <span class="badge badge-warning pull-right">32</span></a>
									</li>
									<li class="list-group-item">
										<a href="#"><span class="badge badge-success pull-right">76</span>本月待办项 </a>
									</li>
								</ul>
								<a href="#" class="btn blue">工作管理</a>
								<a href="#" class="btn blue">新建计划</a>
                </div>
            </div>
          </div>
        </div>
        <div class="col-md-4 col-sm-12"> 
          <div class="portlet box grey">
            <div class="portlet-title">
              <div class="caption"> 通知公告 </div>
              <div class="tools"> <a href="" class="collapse"></a> </div>
            </div>
            <div class="portlet-body" >
			  <div class="list list-news" style="height:210px;">
				<dl><dt><a href="#">2015年中秋节放假通知</a></dt><dd>10.14</dd></dl>
				<dl><dt><a href="#">第三方支付创新，让商户永远保持在行业前</a></dt><dd>09.28</dd></dl>
				<dl><dt><a href="#">第三方支付管理办法征求意见结束 9月份有...</a></dt><dd>09.06</dd></dl>
				<dl><dt><a href="#">互联网金融之第三方支付行情分析</a></dt><dd>07.23</dd></dl>
				<dl><dt><a href="#">互联网金融加强资金池监管 明确第三方存...</a></dt><dd>07.20</dd></dl>
				<dl><dt><a href="#">关于参会信息化研讨...</a></dt><dd>07.20</dd></dl>
				<dl><dt></dt><dd class="more_list"><a href="#"><i class="fa fa-plus-circle icon"></i> 更多</a></dd></dl>
				
			  </div>

            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-8 col-sm-12">
          <div class="portlet box grey">
            <div class="portlet-title">
              <div class="caption">全局工作</div>
              <div class="tools"> <a href="" class="collapse"></a> </div>
            </div>
            <div class="portlet-body" >
			<div style="height:210px;">
				<a href="#" class="btn blue btn-sm"><i class="fa fa-bookmark icon"></i> 2015年年度工作计划</a>
				<div class="mgt5">
							  <div class="row">
								<div class="col-md-4 col-sm-12">
								<table class="table table-striped table-advance table-hover">
								<thead>
								<tr>
									<th>
										 周计划
									</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td>
										 <a href="#">周计划（9.7-9.11）</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="#">周计划（8.31-9.4）</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="#">周计划（8.24-8.28）</a>
									</td>
								</tr>
								<tr>
									<td>
										 <a href="#">周计划（8.24-8.28）</a>
									</td>
								</tr>
								</tbody>
								</table>
								</div>
							<div class="col-md-4 col-sm-12">
								<table class="table table-striped table-advance table-hover">
								<thead>
								<tr>
									<th>
										 月重点工作
									</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td>
										 <a href="#">9月重点工作</a>

									</td>
								</tr>
								<tr>
									<td>
										 <a href="#">8月重点工作</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="#">7月重点工作</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="#">6月工作月报</a>
									</td>
								</tr>
								</tbody>
								</table>
							</div>
							<div class="col-md-4 col-sm-12">
								<table class="table table-striped table-advance table-hover">
								<thead>
								<tr>
									<th>
										 工作月报
									</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td><a href="#">9月工作月报</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="#">8月工作月报</a>
									</td>
								</tr>
								<tr>
									<td>
										 <a href="#">7月工作月报</a>
									</td>
								</tr>
								<tr>
									<td>
									<a href="#">7月重点工作</a>
									</td>
								</tr>
								</tbody>
								</table>
							</div>
							</div>							
							</div>
              </div>
          </div>
		  </div>
        </div>
        <div class="col-md-4 col-sm-12">
          <div class="portlet box grey">
            <div class="portlet-title">
              <div class="caption"> 工作资料 </div>
              <div class="tools"> <a href="" class="collapse"> </a> </div>
            </div>
            <div class="portlet-body">
              <div class="tiles"  style="height:210px;">
                <div class="tile bg-blue-steel">
                  <div class="tile-body"> <i class="fa fa-briefcase"></i> </div>
                  <div class="tile-object">
                    <div class="name"> 工作手册 </div>
                    <div class="number"> 124 </div>
                  </div>
                </div>
                <div class="tile bg-green-meadow">
                  <div class="tile-body"> <i class="fa fa-files-o"></i> </div>
                  <div class="tile-object">
                    <div class="name"> 规章制度 </div>
                    <div class="number"> 690 </div>
                  </div>
                </div>
                <div class="tile bg-red-sunglo">
                  <div class="tile-body"> <i class="fa fa-picture-o"></i> </div>
                  <div class="tile-object">
                    <div class="name"> 通讯录 </div>
                    <div class="number"> 125 </div>
                  </div>
                </div>
                <div class="tile bg-yellow-lemon">
                  <div class="tile-body"> <i class="fa fa-desktop"></i> </div>
                  <div class="tile-object">
                    <div class="name"> 便捷服务 </div>
                    <div class="number"> 34 </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
      <div class="row">
        <div class="col-md-12 col-sm-12"> 
          <!-- BEGIN BASIC CHART PORTLET-->
          <div class="portlet box grey">
            <div class="portlet-title">
              <div class="caption"> 离退休干部数据统计分析 </div>
              <div class="actions"> <a href="#" class="btn">更多</a> </div>
            </div>
            <div class="portlet-body">
              <div class="scroller-div"  style="height:240px;">
			  <img src="img/u44.png" />
			  <img src="img/u46.png" />
			  <img src="img/u48.png" />
			  <img src="img/u50.png" />
			  <img src="img/u52.png" />
			  </div>
              
            </div>
          </div>
        </div>

      </div>

    </div>
    <!-- END CONTENT --> 
  </div>
</div>
<!-- END CONTAINER --> 
<!-- BEGIN FOOTER -->
<div class="page-footer">
  <div class="page-footer-inner"> 2014 &copy; 离退休干部管理系统. </div>
  <div class="page-footer-tools"> <span class="go-top"> <i class="fa fa-angle-up"></i> </span> </div>
</div>
<!-- END FOOTER --> 
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) --> 
<!-- BEGIN CORE PLUGINS --> 

<script src="plugins/excanvas.min.js"></script>
<script src="plugins/respond.min.js"></script>

<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<script src="js/metronic.js" type="text/javascript"></script>
<script src="js/layout.js" type="text/javascript"></script>
<script>
jQuery(document).ready(function() {    
   Metronic.init(); // init metronic core components
   Layout.init(); // init current layout
});
</script>

</script> 
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
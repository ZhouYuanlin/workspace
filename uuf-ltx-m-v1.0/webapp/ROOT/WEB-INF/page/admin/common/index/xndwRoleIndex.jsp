<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>校内单位角色首页</title>
</head>
<body>
	<div class="row">
		<div class="col-md-4 col-sm-12">
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">用户信息</div>
					<div class="tools">
						<a href="" class="collapse"></a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="scroller-div" style="height: 160px;">
						<div class="media">
							<a href="#" class="pull-left user-photo"> 
								<img alt=""
								src="${request.getContextPath}/resources/framework/custom/base/img/none.jpg" class="media-object">
							</a>
							<div class="media-body">
								<h4>
									你好，<shiro:principal property="xm"/><span>
								</h4>
								<p class="media-txt">变化是永恒的主题，不变是相对的定义。愿你快乐幸福每一天！</p>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-12">
			<!-- BEGIN BASIC CHART PORTLET-->
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">个人待办</div>
					<div class="tools">
						<a href="" class="collapse"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="search-div" style="height: 160px;">
						<ul class="list-group">
							<li class="list-group-item">
							<a href="${request.getContextPath}/admin/qgzx/gwsp?ygdwspzt=DSP">待审批岗位申请人数<span
									class="badge badge-danger pull-right">${dspsqs}</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-12">
			<!-- BEGIN BASIC CHART PORTLET-->
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">通知公告</div>
					<div class="tools">
						<a href="" class="collapse"></a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="list list-news" style="height: 160px;">
						<dl>
							<dt>
								暂时没有通知公告！
							</dt>
							<dd></dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-12">
			<!-- BEGIN BASIC CHART PORTLET-->
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">经济困难生</div>
					<div class="tools">
						<a href="" class="collapse"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="search-div" style="height: 160px;">
						<dl>
							<dt>
								此版块待开放！
							</dt>
							<dd></dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-12">
			<!-- BEGIN BASIC CHART PORTLET-->
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">勤工助学</div>
					<div class="tools">
						<a href="" class="collapse"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="search-div" style="height: 160px;">
						<ul class="list-group">
							<li class="list-group-item">
							<a href="${request.getContextPath}/admin/qgzx/gwsp">勤工助学总人数<span
									class="badge badge-danger pull-right">${ytgdsqs}</span></a></li>
							<li class="list-group-item">
							<a href="${request.getContextPath}/admin/qgzx/gwsp?ygdwspzt=TG&sfpks=true">经济困难生申请数<span
									class="badge badge-danger pull-right">${jjknssqs}</span></a></li>
							<li class="list-group-item">		
							<a href="${request.getContextPath}/admin/qgzx/bcgl">累计勤工助学时间<span
									class="badge badge-danger pull-right">${gzgs}小时</span></a></li>
							<li class="list-group-item">		
							<a href="${request.getContextPath}/admin/qgzx/bcgl">累计发放勤工助学报酬金额<span
									class="badge badge-danger pull-right">${gzzje}元</span></a></li>				
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-12">
			<!-- BEGIN BASIC CHART PORTLET-->
			<div class="portlet box grey">
				<div class="portlet-title">
					<div class="caption">微心愿</div>
					<div class="tools">
						<a href="" class="collapse"> </a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="search-div" style="height: 160px;">
						<dl>
							<dt>
								此版块待开放！
							</dt>
							<dd></dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
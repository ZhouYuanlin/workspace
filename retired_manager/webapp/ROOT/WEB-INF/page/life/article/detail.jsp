<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
		<script type="text/javascript" src="${request.contextPath}/defaults/js/article/lrtk.js"></script>
		<script type="text/javascript" src="${request.contextPath}/defaults/scripts/js/article/jquery.overlay.min.js"></script>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/article">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/article">
							文章分享</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/article">
							详情</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<a class="btn blue" href="javascript:void(0);" onclick="javascript:history.go(-1)" ><i class="fa fa-reply"></i>返回</a>
                	<a href="${request.contextPath}/article/${f.id }/download" class="btn blue"><i class="fa fa-plus"></i>下载文档</a> 
                </div>
              </div>
              </div>
			  <div class="row">
					<div class="col-md-12">
						<jsp:include page="../../folder/_swffile.jsp"/>
              		</div>
				</div>
			</div>
		</div>
	</body>
</html>
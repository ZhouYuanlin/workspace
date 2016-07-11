<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head></head>
	<body>
		<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/folder">
							首页 </a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li> 
							<a href="/folder">
							文档中心</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/folder">
							详情</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 clearfix">
                <div class="operation-btn pull-right">
                	<a class="btn blue" href="javascript:void(0);" onclick="javascript:history.go(-1)" ><i class="fa fa-reply"></i>返回</a>
                	<a href="${request.contextPath}/folder/${f.id }/download" class="btn blue"><i class="fa fa-plus"></i>下载文档</a> 
                </div>
              </div>
              </div>
			  <div class="row">
					<div class="col-md-12">
						<jsp:include page="_read.jsp"/>
              		</div>
				</div>
			</div>
		</div>
	</body>
</html>
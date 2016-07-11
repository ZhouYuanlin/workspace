<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
    <link rel="stylesheet" href="${request.contextPath}/resources/ytj/css/bootstrap.css"/>
    <link rel="stylesheet" href="${request.contextPath}/resources/ytj/css/style.css"/>
</head>
<body>
<div class="all-baoguoone">
    <div class="container head">
        <img class="headimg" src="${request.contextPath}/resources/ytj/images/logo.png" alt=""/>
        <span class="headfont">离退休人员多功能触摸自助查询一体机</span>
    </div>
</div>
<div class="container ps-container-two">
    <div class="row">
        <div class="ps-left fl">
            <jsp:include page="../index/menu.jsp"></jsp:include>
        </div>
        <div class="ps-right fr">
               <div class="col-md-12 pn-bg"><h4>个人信息</h4></div>
                <div class="col-md-12 pn-border">
                    <div class="col-md-4"><h5>姓名：<span>${retment.xm}</span></h5></div>
                    <div class="col-md-4"><h5>性别：<span>${retment.xb}</span></h5></div>
                    <div class="col-md-4"><h5>民族：<span>${retment.mzb.name}</span></h5></div>
                    <div class="col-md-4"><h5>籍贯：<span>${retment.jg}</span></h5></div>
                    <div class="col-md-4"><h5>学历：<span>${retment.grxl}</span></h5></div>
                    <div class="col-md-4"><h5>政治面貌：<span>${retment.zzmm.name}</span></h5></div>
                    <div class="col-md-4"><h5>身份证号码：<span>${retment.sfzh}</span></h5></div>
                    <div class="col-md-4"><h5>出生日期：<span>${retment.csrq}</span></h5></div>
                    <div class="col-md-4"><h5>婚姻状况：<span>${retment.fyzk}</span></h5></div>
                    <div class="col-md-4"><h5>是否失能：<span>${retment.sssn}</span></h5></div>
                    <div class="col-md-4"><h5>是否孤寡：<span>${retment.sfgg}</span></h5></div>
                    <div class="col-md-4"><h5>是否独居：<span>${retment.sfdj}</span></h5></div>
                    <div class="col-md-4"><h5>是否保健干部：<span>${retment.sfbjgb}</span></h5></div>
                    <div class="col-md-4"><h5>护照号码：<span>${retment.fzhm}</span></h5></div>
                    <div class="col-md-4"><h5>现享受待遇：<span>${retment.xsdy}</span></h5></div>
                </div>
            <div class="col-md-12 pn-bg mt-10"><h4>工作信息</h4></div>
            <div class="col-md-12 pn-border">
                <div class="col-md-4"><h5>原工作单位：<span>${retment.dwb.name}</span></h5></div>
                <div class="col-md-4"><h5>职务：<span>${retment.zwb.name}</span></h5></div>
                <div class="col-md-4"><h5>职级：<span>${retment.zjb.name}</span></h5></div>
                <div class="col-md-4"><h5>参加工作时间：<span>${retment.gzsj}</span></h5></div>
                <div class="col-md-4"><h5>离退休时间：<span>${retment.lxsj}</span></h5></div>
                <div class="col-md-4"><h5>离退休类别：<span>${retment.lxb.name}</span></h5></div>
            </div>
            <div class="col-md-12 pn-bg mt-10"><h4>家庭信息</h4></div>
            <div class="col-md-12 pn-border">
                <div class="col-md-6"><h5>家庭住址：<span>${family.jtdz}</span></h5></div>
                <div class="col-md-6"><h5>联系电话：<span>${family.jtdh}</span></h5></div>
                <div class="col-md-6"><h5>手机：<span>${retment.lxdh}</span></h5></div>
                <div class="col-md-6"><h5>邮编：<span>${family.yzbm}</span></h5></div>
            
            <div class="col-md-12 pn-bg mt-10" style="background-color: #F2F2F2;"><h4>成员</h4></div>
            <table class="table table-striped table-bordered text-center">
                <tbody>
                <tr>
                    <td>姓名</td>
                    <td>关系</td>
                    <td>工作单位</td>
                    <td>职务</td>
                    <td>联系电话</td>
                    <td>居住关系</td>
                </tr>
                <c:forEach items="${retment.members}" var="item">
                	<tr>
	                    <td>${item.mxm}</td>
	                    <td>${item.mgx}</td>
	                    <td>${item.mgzdw}</td>
	                    <td>${item.mzw}</td>
	                    <td>${item.mdh}</td>
	                    <td>${item.mjzgx}</td>
               		</tr>
                </c:forEach>
                </tbody>
                </table>
                </div>
           </div>
        </div>
    </div>
</body>
<script type="text/javascript">
</script>
</html>
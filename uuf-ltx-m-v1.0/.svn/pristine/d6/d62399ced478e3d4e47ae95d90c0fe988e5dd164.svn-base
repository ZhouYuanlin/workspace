<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <title>工资详情</title>
    <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/css/aui.css" />
    <script type="text/javascript" src="${request.getContextPath}/resources/wechat/script/api.js" ></script>
    <script src="${request.getContextPath}/resources/framework/custom/base/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <style type="text/css">
	.aui-arrow-right:after{
		color:#FFFFFF;
	}
	.back {
    color: #666;
    background-color: #fff;
    </style>
</head>
<body>
	<p class="aui-padded-10 aui-text-center"><strong>基本信息</strong></p>
    <div class="aui-card">
        <ul class="aui-list-view">
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	姓名
                	<span class="aui-badge back">${retirewages.xm}</span>
                </a>	
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	身份证号码
                	<span class="aui-badge back">${retirewages.sfzh}</span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  发放月份
                	<span class="aui-badge back">${retirewages.yf}</span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  总计
                	<span class="aui-badge back"><c:if test="${not empty (retirewages.sfxj+retirewages.bjjbt.sfgz)}"><fmt:formatNumber type="number" value="${retirewages.sfxj+retirewages.bjjbt.sfgz}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	 <c:if test="${empty (retirewages.sfxj+retirewages.bjjbt.sfgz)}">0.00 元</c:if>
                	</span>
                </a>
            </li>
        </ul>
    </div>
    <!-- aui-badge-danger -->
    <p class="aui-padded-10 aui-text-center"><strong>财统工资</strong></p>
    <div class="aui-card">
        <ul class="aui-list-view">
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	离退休费
                	<span class="aui-badge back"><c:if test="${not empty retirewages.ltxf}"><fmt:formatNumber type="number" value="${retirewages.ltxf}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.ltxf}">0.00 元</c:if></span>
                </a>	
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	生活补
                	<span class="aui-badge back"><c:if test="${not empty retirewages.shb}"><fmt:formatNumber type="number" value="${retirewages.shb}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.shb}">0.00 元</c:if></span>
                </a>	
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  交通
                	<span class="aui-badge back"><c:if test="${not empty retirewages.jt}"><fmt:formatNumber type="number" value="${retirewages.jt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.jt}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  在京补
                	<span class="aui-badge back"><c:if test="${not empty retirewages.zjb}"><fmt:formatNumber type="number" value="${retirewages.zjb}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.zjb}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  电话补
                	<span class="aui-badge back"><c:if test="${not empty retirewages.dhb}"><fmt:formatNumber type="number" value="${retirewages.dhb}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.dhb}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  书报费
                	<span class="aui-badge back"><c:if test="${not empty retirewages.sbf}"><fmt:formatNumber type="number" value="${retirewages.sbf}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.sbf}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  洗理费
                	<span class="aui-badge back"><c:if test="${not empty retirewages.xl}"><fmt:formatNumber type="number" value="${retirewages.xl}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.xl}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  护理费
                	<span class="aui-badge back"><c:if test="${not empty retirewages.hl}"><fmt:formatNumber type="number" value="${retirewages.hl}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.hl}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	 自雇费
                	<span class="aui-badge back"><c:if test="${not empty retirewages.zgf}"><fmt:formatNumber type="number" value="${retirewages.zgf}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.zgf}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	 其他费用
                	<span class="aui-badge back"><c:if test="${not empty retirewages.qt}"><fmt:formatNumber type="number" value="${retirewages.qt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.qt}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	 其他补贴
                	<span class="aui-badge back"><c:if test="${not empty retirewages.qtbt}"><fmt:formatNumber type="number" value="${retirewages.qtbt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.qtbt}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	 补工资
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bgz}"><fmt:formatNumber type="number" value="${retirewages.bgz}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bgz}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	扣款小计
                	<span class="aui-badge back"><c:if test="${not empty retirewages.gkxj}"><fmt:formatNumber type="number" value="${retirewages.gkxj}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.gkxj}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	应发小计
                	<span class="aui-badge back"><c:if test="${not empty retirewages.yfxj}"><fmt:formatNumber type="number" value="${retirewages.yfxj}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.yfxj}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  实发小计
                	<span class="aui-badge back"><c:if test="${not empty retirewages.sfxj}"><fmt:formatNumber type="number" value="${retirewages.sfxj}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.sfxj}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  发放时间
                	<span class="aui-badge back">${retirewages.ffsj}</span>
                </a>
            </li>
        </ul>
    </div>
    
    <p class="aui-padded-10 aui-text-center"><strong>本级津补贴</strong></p>
    <div class="aui-card">
        <ul class="aui-list-view">
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	离休补贴
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.lxbt}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.lxbt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.lxbt}">0.00 元</c:if></span>
                </a>	
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	物业补贴
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.wybt}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.wybt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.wybt}">0.00 元</c:if></span>
                </a>	
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	班车补贴
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.bcbt}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.bcbt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.bcbt}">0.00 元</c:if></span>
                </a>	
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	提租补贴
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.tzbt}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.tzbt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.tzbt}">0.00 元</c:if></span>
                </a>	
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	适当补贴
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.sdbt}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.sdbt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.sdbt}">0.00  元</c:if></span>
                </a>	
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  特贴
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.tt}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.tt}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.tt}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  代汇补
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.dh}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.dh}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.dh}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  未修养补
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.wxy}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.wxy}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.wxy}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	 扣款小计
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.kkhj}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.kkhj}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.kkhj}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  应发小计
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.yfhj}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.yfhj}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.yfhj}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  实发小计
                	<span class="aui-badge back"><c:if test="${not empty retirewages.bjjbt.sfgz}"><fmt:formatNumber type="number" value="${retirewages.bjjbt.sfgz}" pattern="0.00" maxFractionDigits="2"/> 元</c:if>
                	<c:if test="${empty retirewages.bjjbt.sfgz}">0.00 元</c:if></span>
                </a>
            </li>
            <li class="aui-list-view-cell">
            	<a class="aui-arrow-right">
                	  发放时间
                	<span class="aui-badge back">${retirewages.bjjbt.ffsj}</span>
                </a>
            </li>
        </ul>
    </div>
</body>
</html>
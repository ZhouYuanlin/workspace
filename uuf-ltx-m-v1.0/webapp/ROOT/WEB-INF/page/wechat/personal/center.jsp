<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人中心</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <link rel="stylesheet" type="text/css" href="${request.getContextPath}/resources/wechat/css/aui.css"/>
    <script type="text/javascript" src="${request.getContextPath}/resources/wechat/script/api.js" ></script>
    <script src="${request.getContextPath}/resources/framework/custom/base/js/jquery-1.8.3.min.js" type="text/javascript"></script>
</head>
<style>
.my-header {
    background-color: #e74c3c;
    position: relative;
    margin-bottom: 0;
}
.my-info {
    position: relative;
    padding: 20px 0;
    width: 100%;
    bottom: 0;
    text-align: center;
    vertical-align: center;
}
.my-info img {
    width: 80px;
    height: 80px;
    border-radius: 50%;
}
.my-info p.nickname {
    margin-top: 5px;
    color: #ffffff;
    font-size: 18px;
}
.aui-list-view-cell {
    line-height: 26px;
}
.amount-info {
    background-color: #ffffff;
    overflow: hidden;
}
.amount-info p {
    font-size: 0.75em;
}
.amount-info p strong {
    font-size: 18px;
}
.aui-list-view-cell {
    line-height: 26px;
}
.amount-info .aui-col-xs-4 {
    padding: 15px 0;
    position: relative;
    height: 80px;
}
.amount-info .aui-col-xs-4:after {
    border-left: 1px solid #ddd;
    display: block;
    content: '';
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    -webkit-transform-origin: 0 0;
    -webkit-transform: scale(1);
    pointer-events: none;
}
.amount-info .aui-col-xs-4:first-child:after {
    border:none;
}
@media only screen and (-webkit-min-device-pixel-ratio: 1.5) {
    .amount-info .aui-col-xs-4:after {
        right: -100%;
        bottom: -100%;
        -webkit-transform: scale(0.5);
    }
}
</style>
<body>
    <div class="aui-content my-header">
        <div class="my-info">
            <img src="${request.getContextPath}/resources/wechat/img/noavatar.gif" />
        </div>
    </div>
   
   <div style="height: 20px;"></div>
    <div class="aui-content">
        <ul class="aui-list-view aui-in">
            <li class="aui-list-view-cell" onclick="openWin('${request.getContextPath}/wechat/personal/information')">
                <i class="aui-iconfont aui-icon-profile aui-bg-info" ></i>个人资料
            </li>
            <li class="aui-list-view-cell" onclick="openWin('${request.getContextPath}/wechat/personal/pwdreset')">
                <i class="aui-iconfont aui-icon-pay aui-bg-danger"></i>密码修改
            </li>
        </ul>
    </div>
    <div class="aui-padded-20">
     <div class="aui-btn aui-btn-success aui-btn-block" onclick="openWin('${request.getContextPath}/wechat/personal/exitAccount')">退出当前账号</div>
    </div>
   
</body>

<script type="text/javascript">

$(document).ready(function(){
	var flag = "${message}";
	if(flag!=""){
		if(flag=="false"){
			alert("密码重置失败,请重试!");
		}
	}
});
function openWin(url){
	window.location.href=url;
}
</script>
</html>
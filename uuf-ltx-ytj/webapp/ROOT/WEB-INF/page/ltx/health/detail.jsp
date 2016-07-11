<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
	span {
		color: #808080;
	}
	textarea{
		color: #808080; 
	}
</style>
     <div class="container fix">
        <div class="row">
            <div class="col-md-12 pn-bg">
                <div class="col-md-11"><h4>${rethealth.tjsj}体检信息</h4></div>
                <div class="col-md-1 text-right guanbi" style="cursor: pointer;" onclick="exit();"><h4>X</h4></div>
            </div>
        </div>
         	<div style="margin-top: 20px;"></div>
            <div class="col-md-4 col-md-offset-1"><h5>姓名：<span>${rethealth.ret.xm}</span></h5></div>
            <div class="col-md-4 col-md-offset-1"><h5>身份证号：<span>${rethealth.ret.sfzh}</span></h5></div>
            <div class="col-md-4 col-md-offset-1"><h5>性别：<span>${rethealth.ret.xb}</span></h5></div>
            <div class="col-md-4 col-md-offset-1"><h5>民族：<span>${rethealth.ret.mzb.name}</span></h5></div>
            <div class="col-md-4 col-md-offset-1"><h5>原工作单位：<span>${rethealth.ret.dwb.name}</span></h5></div>
            <div class="col-md-4 col-md-offset-1"><h5>职务：<span>${rethealth.ret.zwb.name}</span></h5></div>
            <div class="col-md-4 col-md-offset-1"><h5>体检时间：<span>${rethealth.tjsj}</span></h5></div>
            <div class="col-md-4 col-md-offset-1"><h5>体检医院：<span>${rethealth.tjyy}</span></h5></div>
            <div class="col-md-10 col-md-offset-1"><h5>体检结果：</h5></div>
            <div class="col-md-10 col-md-offset-1"><h5><textarea style="width: 600px;height: 100px;">${rethealth.tjjg}</textarea></h5></div>
                
            <div class="col-md-12">
                <div class="col-md-1 col-md-offset-8 daying mt-5"><h4>打印</h4></div>
                <div class="col-md-1 col-md-offset-1 guanbi2 mt-5" onclick="exit();"><h4>关闭</h4></div>
            </div>
</div>

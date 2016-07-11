<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <div class="container fix">
    
        <div class="row">
            <div class="col-md-12 pn-bg">
                <div class="col-md-11"><h4>工资详情</h4></div>
                <input type="hidden" id="status" value="${status}">
                <div class="col-md-1 text-right guanbi" style="cursor: pointer;" onclick="exit();"><h4>X</h4></div>
            </div>
        </div>
        
        <div class="row fix-row mt-10">
            <div class="col-md-12 text-center">
                <div class="col-md-2 col-md-offset-1 fix-shang" style="cursor: pointer;" ref="${retirewages.id}" onclick="lastMonth(this);" >上一个月</div>
<!--startprint-->
                <div class="col-md-4 col-md-offset-1 fix-month" >发放月份：<span>
                	<c:if test="${empty retirewages.yf}">${retirewages.bjjbt.ffyf }</c:if>
					<c:if test="${!empty retirewages.yf}" >${retirewages.yf}</c:if>
                </span></div>
<!--endprint-->
                <div class="col-md-2 col-md-offset-1 fix-xia" style="cursor: pointer;" ref="${retirewages.id}" onclick="nextMonth(this);">下一个月</div>
            </div>
<!--startprint1-->
            <div class="col-md-10 col-md-offset-1">
                <div class="col-md-12 pn-bg mt-10"><h4>基本信息</h4></div>
                <div class="col-md-12 pn-border text-center">
                    <div class="col-md-3 col-md-offset-1 mt-5"><h5>姓名：<span>${retirewages.xm}</span></h5></div>
                    <div class="col-md-3 col-md-offset-2 mt-5"><h5>总计：<span>${retirewages.sfxj+retirewages.bjjbt.sfgz}(元)</span></h5></div>
                </div>
            </div>
            <div class="col-md-10 col-md-offset-1">
            <div class="col-md-12 pn-bg mt-10"><h4>财统工资</h4></div>
            <div class="col-md-12 pn-border text-left">
                <div class="col-md-3 col-md-offset-1"><h5>离退休费：<span>${retirewages.ltxf}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>生活补助：<span>${retirewages.shb}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>交通：<span>${retirewages.jt}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>在京补：<span>${retirewages.zjb}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>电话：<span>${retirewages.dhb}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>书报费：<span>${retirewages.sbf}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>洗理：<span>${retirewages.xl}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>护理：<span>${retirewages.hl}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>自雇费：<span>${retirewages.zgf}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>其他：<span>${retirewages.qt}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>其他补贴：<span>${retirewages.qtbt}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>补工资：<span>${retirewages.bgz}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>应发小计：<span>${retirewages.yfxj}</span></h5></div>
                <div class="col-md-3 col-md-offset-1"><h5>扣款小计：<span>${retirewages.gkxj}</span></h5></div>
                <div class="col-md-10 text-right">
                	<h5>实发小计：
                		<span>
                			<c:if test="${!empty retirewages.sfxj}">
								${retirewages.sfxj }(元)
							</c:if>
						</span>
					</h5>
				</div>
            </div>
<!--endprint1-->
            </div>

            <div class="col-md-12">
                <div class="col-md-1 col-md-offset-8 daying mt-5" id="bprint" value="打印" type="button" onclick="bprint()"><h4>打印</h4></div>
                <div class="col-md-1 col-md-offset-1 guanbi2 mt-5" onclick="exit();"><h4>关闭</h4></div>
            </div>
        </div>
</div>



<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="portlet-body form select-warp clasdwb" style="display:none">
	<div class="panel panel-default checkbox-list">
	  <div class="panel-body">
		<dl class="select-body">
		<c:forEach items="${dwblist}" var="item">
			<dd><label class="" title="${item.name}"><input type="checkbox" id="bz" name="bz" value="${item.id}" onclick="addselectdwb(this)" class="clavaldwb" ref="${item.name}" <c:if test='${fn:contains(ret.bz,item.id)}'>checked=true;</c:if>>${item.name}</label></dd>
		</c:forEach>
		</dl>
		<dl class="selected-warp">
		<dt>已选条件：</dt>
		<div class="checkvaldwb">
			<c:forEach items="${dwblist}" var="item">
				<c:if test="${fn:contains(ret.bz,item.id)}">
					<dd onclick='delvaldwb(this)' ref='${item.id}'><i class='fa fa-times'></i>${item.name}</dd>
				</c:if>
			</c:forEach>
			</div>
			</dl>
			<div class="select-foot">
			<button type="button" class="btn blue mgr20 adddwb">确定</button>
			<button type="button" class="btn blue mgr20 hidedwb">隐藏</button>
			<button type="button" class="btn blue mgr20 canceldwb">清空</button> 
			<div>
		  </div>
		</div>
		</div>
	</div>
</div>
<script>
	$(function(){
		//显示
		$('.showdwb').click(function(){
			$('.claszwb').hide();
			$('.claszjb').hide();
			$('.clasdwb').show();
		});//隐藏
		$('.hidedwb').click(function(){
			$('.clasdwb').hide();
		});
		//清空
		$('.canceldwb').click(function(){
			$('.clavaldwb').each(function(){
				if($(this).prop('checked'))
					$(this).attr('checked',false);
			});
			$('.checkvaldwb').html('');
			$('.showdwb').val('');
		});
		//先中或取消选中
		$('.adddwb').click(function(){
			$('.clasdwb').hide();
		});
	});
	//先中或取消选中
	function addselectdwb(o){
		var html = "",hts="";
		$('.clavaldwb').each(function(){
			if($(this).prop('checked')){
				hts += $(this).attr('ref') + " ";
				html += "<dd onclick='delvaldwb(this)' ref='"+$(this).val()+"'><i class='fa fa-times'></i>"+$(this).attr('ref')+"</dd>";
			}
		});
		$('.checkvaldwb').html('').prepend(html);
		$('.showdwb').val(hts);
	}
	function delvaldwb(o){
		var v = $(o).attr('ref'),html="",hts="";
		$('.clavaldwb').each(function(){
			if(v == $(this).val())
				$(this).attr('checked',false);
		});
		$('.clavaldwb').each(function(){
			if($(this).prop('checked')){
				hts += $(this).attr('ref') + " ";
				html += "<dd onclick='delvaldwb(this)' ref='"+$(this).val()+"'><i class='fa fa-times'></i>"+$(this).attr('ref')+"</dd>";
			}
		});
		$('.checkvaldwb').html('').prepend(html);
		$('.showdwb').val(hts);
	}
</script>
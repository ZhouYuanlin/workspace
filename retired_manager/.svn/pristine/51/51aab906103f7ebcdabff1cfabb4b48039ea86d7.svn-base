<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="portlet-body form select-warp claszwb" style="display:none">
	<div class="panel panel-default checkbox-list">
	  <div class="panel-body">
		<dl class="select-body">
		<c:forEach items="${zwblist}" var="item">
			<dd><label class="" title="${item.name}"><input type="checkbox" id="sfyfz" name="sfyfz" value="${item.id}" onclick="addselectzwb(this)" class="clavalzwb" ref="${item.name}" <c:if test='${fn:contains(ret.sfyfz,item.id)}'>checked=true;</c:if>>${item.name}</label></dd>
		</c:forEach>
		</dl>
		<dl class="selected-warp">
		<dt>已选条件：</dt>
		<div class="checkvalzwb">
			<c:forEach items="${zwblist}" var="item">
				<c:if test="${fn:contains(ret.sfyfz,item.id)}">
					<dd onclick='delvalzwb(this)' ref='${item.id}'><i class='fa fa-times'></i>${item.name}</dd>
				</c:if>
			</c:forEach>
			</div>
			</dl>
			<div class="select-foot">
			<button type="button" class="btn blue mgr20 addzwb">确定</button>
			<button type="button" class="btn blue mgr20 hidezwb">隐藏</button>
			<button type="button" class="btn blue mgr20 cancelzwb">清空</button> 
			<div>
		  </div>
		</div>
		</div>
	</div>
</div>
<script>
	$(function(){
		//显示
		$('.showzwb').click(function(){
			$('.claszjb').hide();
			$('.clasdwb').hide();
			$('.claszwb').show();
		});//隐藏
		$('.hidezwb').click(function(){
			$('.claszwb').hide();
		});
		//清空
		$('.cancelzwb').click(function(){
			$('.clavalzwb').each(function(){
				if($(this).prop('checked'))
					$(this).attr('checked',false);
			});
			$('.checkvalzwb').html('');
			$('.showzwb').val('');
		});
		//先中或取消选中
		$('.addzwb').click(function(){
			$('.claszwb').hide();
		});
	});
	//先中或取消选中
	function addselectzwb(o){
		var html = "",hts="";
		$('.clavalzwb').each(function(){
			if($(this).prop('checked')){
				hts += $(this).attr('ref') + " ";
				html += "<dd onclick='delvalzwb(this)' ref='"+$(this).val()+"'><i class='fa fa-times'></i>"+$(this).attr('ref')+"</dd>";
			}
		});
		$('.checkvalzwb').html('').prepend(html);
		$('.showzwb').val(hts);
	}
	function delvalzwb(o){
		var v = $(o).attr('ref'),html="",hts="";
		$('.clavalzwb').each(function(){
			if(v == $(this).val())
				$(this).attr('checked',false);
		});
		$('.clavalzwb').each(function(){
			if($(this).prop('checked')){
				hts += $(this).attr('ref') + " ";
				html += "<dd onclick='delvalzwb(this)' ref='"+$(this).val()+"'><i class='fa fa-times'></i>"+$(this).attr('ref')+"</dd>";
			}
		});
		$('.checkvalzwb').html('').prepend(html);
		$('.showzwb').val(hts);
	}
</script>
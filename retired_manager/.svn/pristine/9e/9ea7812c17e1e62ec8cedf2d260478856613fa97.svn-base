<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="portlet-body form select-warp claszjb" style="display:none">
	<div class="panel panel-default checkbox-list">
	  <div class="panel-body">
		<dl class="select-body">
		<c:forEach items="${zjblist}" var="item">
			<dd><label class="" title="${item.name}"><input type="checkbox" id="qq" name="qq" value="${item.id}" onclick="addselect(this)" class="claval" ref="${item.name}" <c:if test='${fn:contains(ret.qq,item.id)}'>checked=true;</c:if>>${item.name}</label></dd>
		</c:forEach>
		</dl>
		<dl class="selected-warp">
		<dt>已选条件：</dt>
		<div class="checkval">
			<c:forEach items="${zjblist}" var="item">
				<c:if test="${fn:contains(ret.qq,item.id)}">
					<dd onclick='delval(this)' ref='${item.id}'><i class='fa fa-times'></i>${item.name}</dd>
				</c:if>
			</c:forEach>
			</div>
			</dl>
			<div class="select-foot">
			<button type="button" class="btn blue mgr20 addzjb">确定</button>
			<button type="button" class="btn blue mgr20 hidezjb">隐藏</button>
			<button type="button" class="btn blue mgr20 cancelzjb">清空</button> 
			<div>
		  </div>
		</div>
		</div>
	</div>
</div>
<script>
	$(function(){
		//显示
		$('.showzjb').click(function(){
			$('.claszwb').hide();
			$('.clasdwb').hide();
			$('.claszjb').show();
		});//隐藏
		$('.hidezjb').click(function(){
			$('.claszjb').hide();
		});
		//清空
		$('.cancelzjb').click(function(){
			$('.claval').each(function(){
				if($(this).prop('checked'))
					$(this).attr('checked',false);
			});
			$('.checkval').html('');
			$('.showzjb').val('');
		});
		//先中或取消选中
		$('.addzjb').click(function(){
			$('.claszjb').hide();
		});
	});
	//先中或取消选中
	function addselect(o){
		var html = "",hts="";
		$('.claval').each(function(){
			if($(this).prop('checked')){
				hts += $(this).attr('ref') + " ";
				html += "<dd onclick='delval(this)' ref='"+$(this).val()+"'><i class='fa fa-times'></i>"+$(this).attr('ref')+"</dd>";
			}
		});
		$('.checkval').html('').prepend(html);
		$('.showzjb').val(hts);
	}
	function delval(o){
		var v = $(o).attr('ref'),html="",hts="";
		$('.claval').each(function(){
			if(v == $(this).val())
				$(this).attr('checked',false);
		});
		$('.claval').each(function(){
			if($(this).prop('checked')){
				hts += $(this).attr('ref') + " ";
				html += "<dd onclick='delval(this)' ref='"+$(this).val()+"'><i class='fa fa-times'></i>"+$(this).attr('ref')+"</dd>";
			}
		});
		$('.checkval').html('').prepend(html);
		$('.showzjb').val(hts);
	}
</script>
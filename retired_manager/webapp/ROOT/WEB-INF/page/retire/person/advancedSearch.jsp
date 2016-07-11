<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<div class="modal-header" style="background-color: white;">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
	    <h2>查询条件</h2>
	 </div>
	<div class="modal-body">
	<div class="form-body">
		
		<%--显示已保存的查询条件部分 --%>
		<c:forEach items="${saveZdytjblist}" var="item">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						
							<div class="row">
								<div class="col-md-8">
										<input type="text" id="fattie" name="fattie" value="${item.fattiesName}" class='form-control' readonly/>
								</div>
								<a href="javascript:;;" class="btn default btn-xs black"  ref="${item.id}" onclick="deleteFatties(this);" style="margin:0px 5px 0px 5px;background-color: #19A2DE;padding:5px 15px 6px 15px;color: white;"><i class="fa fa-times"></i></a>
								<a href="javascript:;;" data-toggle="modal" ref="${item.fattiesValue}" onclick="fattiesSearch(this);"><button type="button" id="advanced" class="btn blue mgr10" style="padding: 5px 27px 6px 27px;"><i class="fa fa-search"></i>快速查询</button></a> 
							</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<div style="height: 15px;"></div>
		
		<%-- 保存查询条件部分 --%>
		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<div class="row">
						<div class="col-md-8">
							<input type="text" id="fattiesName" name="fattiesName" class='form-control' placeholder="如需此次条件,请输入名称保存为快速查询!"/>
						</div>
						<a href="#" data-toggle="modal"><button type="button" id="advanced" class="btn blue mgr10" onclick="saveFatties();" style=" margin:0px 5px 0px 5px;padding: 5px 19px 6px 19px;"><i class="fa fa-search"></i>保 存 为 快 速 查 询</button></a> 
					</div>
				</div>
			</div>
		</div>
		<div style="height: 20px;"></div>
		
		<%--自定义查询条件部分 --%>
		<div class="row">
				<div class="col-md-12">
					<div class="form-group whereContainer">
						<div class="advanceds_s">
							<div class="row mgb10">
									<div class="col-md-3">
										<select id="concolumn" name="concolumn" class="form-control" onchange="searchKeyChange(this);">
												<c:forEach items="${zdytjbList}" var="item" varStatus="c">
													<c:choose>
														<c:when test="${!fn:contains(item.zdywm,'.')}">
															<option value="${item.zdywm}">${item.zdzwm}</option>
														</c:when>
														<c:when test="${fn:contains(item.zdywm,'.')}">
															<option value="${fn:substringBefore(item.zdywm,'.')}_id">${item.zdzwm}</option>
														</c:when>
													</c:choose>
												</c:forEach>
										</select>
									</div>
									<div class="col-md-2">
										<select id="logicv" name="logicv" class="form-control">
											<option value=" =">等于</option>
											<option value=" !=">不等于</option>
											<option value=" &gt;">大于</option>
											<option value=" &lt;">小于</option>
											<option value=" like">包含</option>
											<option value=" not like">不包含</option>
										</select>
									</div>
									<div class="col-md-3 clasvalue">
										<input type="text" id="convalue" name="convalue" value="" class='form-control' placeholder="请输入条件"/>
									</div>
									<div class="col-md-2">
										<select id="conditionv" name="conditionv" class="form-control">
											<option value=" and "> AND </option>
											<option value=" or "> OR </option>
										</select>
									</div>
									<a href="javascript:;;" class="btn default btn-xs black"  onclick="addWhere()"><i class="fa fa-plus"></i></a>
									<a href="javascript:;;" class="btn default btn-xs black" onclick="removeWhere(this)"><i class="fa fa-times"></i></a>
								</div>
              				</div>
						</div>
					</div>
				</div>
			</div>
			</div>
	    <div class="modal-footer">
			<button class="btn blue mgr10 advancesearchchildren" type="button" id="advanSearch">查询</button>
			<button class="btn" data-dismiss="modal" type="button" aria-hidden="true">关闭</button>
		</div>
<script>
var whereElement;
$(function(){
	whereElement = $(".advanceds_s").clone();//克隆一个查询条件框保存备用
	$('#advanSearch').click(function(){
		var n=0,c = $('.mgb10').length,s='';
		$('.mgb10').each(function(){
			if($(this).find('#convalue').val() != ''){
				s += (n == 0 ? '(' : '') +$(this).find('#concolumn').val() + $(this).find('#logicv').val()+' ' + ($(this).find('#logicv').val().indexOf('like') != -1 ? "'%" + $(this).find('#convalue').val()+"%'" : "'"+$(this).find('#convalue').val()+"'") + (n != c - 1 ? $(this).find('#conditionv').val() : ')');
			}else{
				alert('您有未完成条件，请完成或删除项！');
				s="";
				return false;
			}
			n++;
		});
		if(s != ''){
			$('#advancedSearch').val(s);
			$('#frm').attr('action','/retment').submit();
		}
	});
});
//增加一行
function addWhere(){
	$('.whereContainer').append(whereElement.html());
}
//删除一行
function removeWhere(obj){
	if($('.mgb10').length > 1){
		$(obj).parent().remove();
	}else{
		alert('请您手下留情');
	}
}

//实现快速查询
function fattiesSearch(obj){
	var value = $(obj).attr("ref");
	$('#advancedSearch').val(value);
	$('#frm').attr('action','/retment').submit();
}


//保存快速查询条件
function saveFatties(){
	var n=0,c = $('.mgb10').length,s='';
	$('.mgb10').each(function(){
		if($(this).find('#convalue').val() != ''){
			s += (n == 0 ? '(' : '') +$(this).find('#concolumn').val() + $(this).find('#logicv').val()+' ' + ($(this).find('#logicv').val().indexOf('like') != -1 ? "'%" + $(this).find('#convalue').val()+"%'" : "'"+$(this).find('#convalue').val()+"'") + (n != c - 1 ? $(this).find('#conditionv').val() : ')');
		}else{
			alert('您没有完整填充任一条件，请完成或删除项!');
			s="";
			return false;
		}
		n++;
	});
	if(s != ''){
		var fattiesName = $('#fattiesName').val();
		var fattiesValue = s;
		if(fattiesName=="" && fattiesName.trim()==""){
			alert("请输入保存快速查询的名称!");
			return false;
		}
		$.post('/retment/saveFatties?'+new Date().getTime(),{fattiesName:fattiesName,fattiesValue:fattiesValue},function(d){
			if(d=="success"){
				alert("保存成功!");
				$("#advancedpage").html();
				$.post('/retment/advancedSearch?'+new Date().getTime(),function(d){
					$("#advancedpage").html(d);
				});
			}
			if(d=="maxCount"){
				alert("最多可保存 3 条快速查询数据,如需继续保存,请先删除部分已保存条件!");
			}
			if(d=="fail"){
				alert("保存条件失败,请与管理员联系!");
			}
		});
	}
}

//删除快速查询保存条件
function deleteFatties(obj){
	var id = $(obj).attr("ref");
	 if(confirm("确定删除改条件?")){
		$.post('/retment/deleteFatties?'+new Date().getTime(),{id:id},function(d){
			if(d=="success"){
				alert("删除成功!");
				$("#advancedpage").html();
				$.post('/retment/advancedSearch?'+new Date().getTime(),function(d){
					$("#advancedpage").html(d);
				});
			}
			if(d=="fail"){
				alert("删除条件失败,请与管理员联系!");
			}
		});
	 }
}
</script>
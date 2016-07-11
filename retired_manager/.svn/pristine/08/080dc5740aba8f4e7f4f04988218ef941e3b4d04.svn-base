<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<script type="text/javascript" src="${request.contextPath}/defaults/js/bootstrap-typeahead.js"></script>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>请根据条件选择姓名</h3>
		  </div>
		  <div class="modal-body" style="height:320px;">
		    <div class="form">
		        <!-- <form action="#" class="form-horizontal"> -->
		          <div class="form-body">
					<table width="530" height="283" border="0">
              	 	  <tr>  
					    <td height="21" colspan="4">姓名/工号：<input type="text" id="xmAndSfzh" autocomplete="off" data-provide="typeahead" data-items="4" data-source='data'/>
					    <input type="hidden" name="sfzh" id="sfzh"/>	
					    </td>  
					  </tr>
					  <tr>
					  	<td>请选择查询姓名的类型</td>
					  </tr>
					  <tr>
					  	<td width="170"><input type="button" id="dwBtn" style="background-color: #19A2DE;color: white;" value="工作单位"/>或
					  		<input type="button" id="dzbBtn" style="background-color: #19A2DE;color: white;" value="所在党支部"/></td>
					  </tr>
					  
					  
					  <tr>
					  	<td id="dwbAndDzb" width="72" rowspan="7">  
						    <select name = "dwList" id="dwList" onChange="changeUnit(this);" style="width:150px; height:180px;" size="12" >  
						       <c:forEach items="${dwblist}" var="item"	>
						       		<c:if test="${item.sfejdw=='是'}">
						          	 	<option value="${item.id }">${item.name}</option>
						          	 </c:if>  
						       </c:forEach>
						    </select>
					    </td>   
					  	<%-- <td id="dzb" width="72" rowspan="7">  
						    <select name = "dzbList" id="dzbList" onChange="changeUnit(this);" style="width:150px; height:180px;" size="12" >  
						       <c:forEach items="${dzblist}" var="item"	>
						          	 <option value="${item.id }">${item.dzbmc}</option>  
						       </c:forEach>
						    </select>  
					    </td> --%>
					    <td width="72" rowspan="7">  
					    <select id="leftop" multiple="multiple" size="12" style="width:150px; height:180px;">  
	
					    </select>  
					    </td>  
					    <td width="70" height="21"> </td>  
					      
					    <td colspan="2" rowspan="7">  
					    <select id="rightop" multiple="multiple" size="12" style="width:150px; height:180px;">  
					    	<c:if test="${!empty p.xm}">
					    	<c:forTokens items="${p.xm}" var="re" delims=";" varStatus="c">
					    		<option>${re}</option>
					    	</c:forTokens>
					    	</c:if>
					    </select>  
					    </td>  
					  </tr>  
					  <tr>  
					    <td height="36" align="center" valign="middle"><input id="leftbtn" type="button" value="&gt;&gt;"/></td>  
					  </tr>  
					  <tr>  
					    <td height="27" align="center"> </td>  
					  </tr> 
					  <tr>  
					    <td height="37" align="center" valign="middle"> </td>  
					  </tr>  
					  <tr>  
					    <td height="36" align="center" valign="middle"><input id="rightbtn" type="button" value="&lt;&lt;"/></td>  
					  </tr>  
					  <tr>  
					    <td height="21" align="center" valign="middle"> </td>  
					  </tr>  
					  <tr>  
					    <td height="21" colspan="4"> </td>  
					  </tr>  
					</table> 
		          </div>
		       <!--  </form> -->
		    </div>
		  </div>
		  <div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue btn-primary">确定</button>
		    
		  </div>
		  <script>
		 
		  $(document).ready(function (){
		  	$('#xmAndSfzh').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/retment/autoCompleteUser', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#sfzh'
				,id:1
				,cusReq:selUser
				,view:3
			});
		    $(".btn-primary").click(function(){
			    	
		    		$("#xm").val('');
		            var count=$("#rightop option").length;
	            	var array=new Array();
		            var xmArr=new Array();
		            if(count==0){
		            	$("#xm").val(array);
		            }else{
				      	for(var i=0;i<count;i++){
				      		if($("#rightop").get(0).options[i].value!=null && !$("#rightop").get(0).options[i].value=="")
				           	array.push($("#rightop").get(0).options[i].value);
				      		xmArr.push($("#rightop").get(0).options[i].text);
				     	}
				      	if(xmArr.length>0){
				      		xmArr=xmArr.join(";");
				      		$("#xm").val(xmArr);
				      		$('#sfzh').val(array);
				      	}		            
		            }
		            if($("#xm").val()==""){
		            	alert('根具姓名未找到退休人员家庭地址！');
						$("#sfzh").focus();
						$("#sfzh").val("");
						$("#xm").val("");
						$("#xb").text("");
						$("#dwb").text("");
						$("#mzb").text("");
						$("#lxb").text("");
						$("#dfjs").val("");
						$("#save").attr({
							"disabled" : "disabled"
						});
		            }
		            if ($("#xm").val() != "") {
						$(".btn-primary").removeAttr("disabled");
						$.get("/retmap/beforeFind?" + new Date().getTime(), {
							sfzh : $("#sfzh").val()
						}, function(data) {
							if (data != "") {
								alert('根具姓名未找到退休人员家庭地址！');
								$("#sfzh").focus();
								$("#sfzh").val("");
								$("#xm").val("");
								$("#xb").text("");
								$("#dwb").text("");
								$("#mzb").text("");
								$("#lxb").text("");
								$("#dfjs").val("");
								$("#save").attr({
									"disabled" : "disabled"
								});
							} else {
								$.post("/retmap/querybysfzh/json?"
										+ (new Date()).getTime(), {
									sfzh : $("#sfzh").val()
								}, function(d) {
									$.each($.parseJSON(d), function(i, e) {
										$("#sfzh").text(e.sfzh);
										$("#xm").val(e.xm);
										$("#xb").text(e.xb);
										$("#dwb").text(e.dwb);
										$("#mzb").text(e.mzb);
										$("#lxb").text(e.lxb);
										$("#dfjs").val(e.dfjs);
										$("#party").text(e.party);
									});
								});
							}
						});
						
					}
		            $("#selectAddress").html("");
		            $("#jtdz").val("");
		           	$("#dwList").val("");
		            
		            $.post('/retmap/ajaxdetail?'+new Date().getTime(),{sfzh:$("#sfzh").val()},function(d){
			    		$("#address").html(d);
			    	});
		            
						
		           
		    });
		  //为添加按钮增加事件  
		    $("#leftbtn").click(function (){
		    	 var count = $('#rightop').find('option').length;
			     if(count>0){
			    	 alert("只能选择一个人名!");
			    	 return false;
			     }
		        //获取选择的值  
		        $("#leftop option:selected").each(function (i,o){ 
		            //判断右侧框对象是否已存在
		            var flag=isExistOption("rightop",o.value);
				    
		            //在右边添加所选值，并且添加之后在左边删除所选值  
		            if(!flag){
		            	$("#rightop").append("<option value='"+o.value+"'>"+o.text+"</option>");  
		            }
		        }).remove();  
		          
		    });  
		      
		    //为删除按钮增加事件  
		    $("#rightbtn").click(function (){  
		        //获取所选择的值  
		        $("#rightop option:selected").each(function (i,o){
		            //判断左侧框对象是否已存在
		            var flag=isExistOption("leftop",o.value);
		            //在左边添加所选值，并且添加之后删除右侧值  
		            if(!flag){
		            	$("#leftop").append("<option value='"+o.value+"'>"+o.text+"</option>");  
		            }
		        }).remove();  
		          
		    }); 
		    $(".black").click(function(){
		    	$("#leftop option").each(function(){
		    		var oldRes=$("#xzcy").val();
		    		if(oldRes!=null){
		    			var oldArr=oldRes.split(";");
		    			for(var j=0;j<oldArr.length;j++){
		    				if(oldArr[j]==this.value){
		    					$("#rightop").append("<option value='"+this.value+"'>"+this.text+"</option>")
		    					$(this).remove();
		    				}
		    			}
		    		}
		    		
		    	})
			}); 
	});
		  
		  function sele(){
			  $('#getXM').html("");
			  $('#getXM').html("<div class='controls' id='getXM'>"+
							"<div class='input'><input type='text' id='xm'"+
							"value='${r.ret.xm}' readonly>"+
					"</div></div>");
			  $('#xmAndSfzh').val("");
			  $('#leftop').text("");
			  $('#rightop').text("");
			  $('#Pagination').html("");
		  }
		  function changeUnit(obj){
				var oid=$(obj).val();
				$.ajax({url:"/retment/selUnit",
						type:"post",
						data:"id="+oid,
						dataType:"json",
						success:function(data){
						if(data!=null){
							var res=eval(data);
							$("#leftop").empty();
							$.each(res,function(i){
								$("#leftop").append("<option value='"+this.sfzh+"'>"+this.xm+"</option>"); 
							});
							}
						},
						error:function(){
							alert("数据获取失败");
						}
				})
			}
		  function changeUnit2(obj){
				var oid=$(obj).val();
				$.ajax({url:"/retment/selUnit2",
						type:"post",
						data:"id="+oid,
						dataType:"json",
						success:function(data){
						if(data!=null){
							var res=eval(data);
							$("#leftop").empty();
							$.each(res,function(i){
								$("#leftop").append("<option value='"+this.sfzh+"'>"+this.xm+"</option>"); 
							});
							}
						},
						error:function(){
							alert("数据获取失败");
						}
				})
			}
		 
		//查询到用户放入右侧下拉框
			function selUser(id){
			   var tid=id.split('-')[0];
				  var flag=isExistOption("rightop",tid);
				  if(!flag){
					  $("#rightop").append("<option value='"+tid+"'>"+id.split('-')[1]+"</option>")
				  }
			   
			}
			//判断select中是否存在值为value的项   
			function isExistOption(id,value) {   
			    var isExist = false;   
			     var count = $('#'+id).find('option').length;
			      for(var i=0;i<count;i++)      
			      {      
			         if($('#'+id).get(0).options[i].value == value)      
			             {      
			                   isExist = true;      
			                   break;      
			             }      
			        }      
			        return isExist;   
			};
			
			 $('#dwBtn').click(function(){
				 $('#dwbAndDzb').children('select').remove();
				  $('#dwbAndDzb').append("<select name = 'dwList' id='dwList' onChange='changeUnit(this);' style='width:150px; height:180px;' size='12' > <c:forEach items='${dwblist}' var='item'	> <option value='${item.id }'>${item.name}</option></c:forEach></select>");
				});
			  $('#dzbBtn').click(function(){
				  $('#dwbAndDzb').children('select').remove();
				  $('#dwbAndDzb').append("<select name = 'dzbList' id='dzbList' onChange='changeUnit2(this);' style='width:150px; height:180px;' size='12' > <c:forEach items='${dzblist}' var='item'	> <option value='${item.id }'>${item.dzbmc}</option></c:forEach></select>");
				});
		  </script>
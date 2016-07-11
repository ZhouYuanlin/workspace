<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
		    <h3>请选择支部书记</h3>
		  </div>
		  <div class="modal-body" style="height:320px;">
		    <div class="form">
		        <form action="#" class="form-horizontal">
		          <div class="form-body">
					<table width="387" height="283" border="0">
              	 	  <tr>  
					    <td height="21" colspan="4">姓名/工号：<input type="text" id="xm" autocomplete="off" data-provide="typeahead" data-items="4" data-source='data'/>
					    <input type="hidden" name="sfzh" id="sfzh"/>	
					    </td>  
					  </tr>
					  <tr>
					  	<td width="72" rowspan="7">  
						    <select name = "dep" id="dep" onChange="changeZbsj(this);" style="width:150px; height:180px;" size="12" >  
						       <c:if test="${empty plist}">
						       <c:forEach items="${dwblist}" var="item"	>
						          	 <option value="${item.id }">${item.name}</option>  
						       </c:forEach>
						       </c:if>
						       <c:if test="${!empty plist}">
						       	<c:forEach items="${plist}" var="item">
						          	 <option value="${item.id }">${item.dzbmc}</option>  
						       </c:forEach>
						       </c:if>
						    </select>  
					    </td>   
					    <td width="72" rowspan="7">  
					    <select id="leftopsj" multiple="multiple" size="12" style="width:150px; height:180px;">  
	
					    </select>  
					    </td>  
					    <td width="70" height="21"> </td>  
					      
					    <td colspan="2" rowspan="7">  
					    <select id="rightopsj" multiple="multiple" size="12" style="width:150px; height:180px;"> 
					    	<c:forTokens items="${r.dzbsj}" delims=";" var="z">
					    		<option value="${z}">${z}</option>
					    	</c:forTokens> 
					    </select>  
					    </td>  
					  </tr>  
					  <tr>  
					    <td height="36" align="center" valign="middle"><input id="leftbtnsj" type="button" value="&gt;&gt;"/></td>  
					  </tr>  
					  <tr>  
					    <td height="27" align="center"> </td>  
					  </tr> 
					  <tr>  
					    <td height="37" align="center" valign="middle"> </td>  
					  </tr>  
					  <tr>  
					    <td height="36" align="center" valign="middle"><input id="rightbtnsj" type="button" value="&lt;&lt;"/></td>  
					  </tr>  
					  <tr>  
					    <td height="21" align="center" valign="middle"> </td>  
					  </tr>  
					  <tr>  
					    <td height="21" colspan="4"> </td>  
					  </tr>  
					</table> 
		          </div>
		        </form>
		    </div>
		  </div>
		  <div class="modal-footer">
		    <button data-dismiss="modal" class="btn blue confirm">关闭</button>
		    <button data-dismiss="modal" class="btn blue btn-primary">保存</button>
		  </div>
		  <script>
		  $(document).ready(function (){
		  	$('#xm').typeahead({
		    	source: function (query, process) {
			        return $.post('${request.contextPath}/retment/autoCompleteUser', 
			        { query:query}, 
			        function (data) {
			            return process(data);
			        });
			    }
				,param:'#sfzh'
				,id:1
				,cusReq:selUsers
				,view:3
			});
		    $(".btn-primary").click(function(){
		    		$("#dzbsj").val('');
		            var count=$("#rightopsj option").length;
	            	var array=new Array();
		            var xmArr=new Array();
		            if(count==0){
		            	$("#dzbsj").val(array);
		            }else{
				      	for(var i=0;i<count;i++){
				      		if($("#rightopsj").get(0).options[i].value!=null && !$("#rightopsj").get(0).options[i].value=="")
				           	array.push($("#rightopsj").get(0).options[i].value);
				      		xmArr.push($("#rightopsj").get(0).options[i].text);
				     	}
				      	if(xmArr.length>0){
				      		xmArr=xmArr.join(";");
				      		$("#dzbsj").val(xmArr);
				      	}		            
		            }
		    });
		  //为添加按钮增加事件  
		    $("#leftbtnsj").click(function (){  
		        //获取选择的值  
		        $("#leftopsj option:selected").each(function (i,o){ 
		            //判断右侧框对象是否已存在
		            var flag=isExistOptions("rightopsj",o.value);
				    
		            //在右边添加所选值，并且添加之后在左边删除所选值  
		            if(!flag){
		            	$("#rightopsj").append("<option value='"+o.value+"'>"+o.text+"</option>");  
		            }
		        }).remove();  
		          
		    });  
		      
		    //为删除按钮增加事件  
		    $("#rightbtnsj").click(function (){  
		        //获取所选择的值  
		        $("#rightopsj option:selected").each(function (i,o){
		            //判断左侧框对象是否已存在
		            var flag=isExistOptions("leftopsj",o.value);
		            //在左边添加所选值，并且添加之后删除右侧值  
		            if(!flag){
		            	$("#leftopsj").append("<option value='"+o.value+"'>"+o.text+"</option>");  
		            }
		        }).remove();  
		          
		    }); 
		    $(".black").click(function(){
		    	$("#leftopsj option").each(function(){
		    		var oldRes=$("#dzbsj").val();
		    		if(oldRes!=null){
		    			var oldArr=oldRes.split(";");
		    			for(var j=0;j<oldArr.length;j++){
		    				if(oldArr[j]==this.value){
		    					$("#rightopsj").append("<option value='"+this.value+"'>"+this.text+"</option>")
		    					$(this).remove();
		    				}
		    			}
		    		}
		    		
		    	})
			}); 
	});
		  function changeZbsj(obj){
				var oid=$(obj).val();
				$.ajax({url:"<c:if test='${empty plist}'>/retment/selUnit</c:if><c:if test='${!empty plist}'>/retparty/selUnit</c:if>",
						type:"post",
						data:"id="+oid,
						dataType:"json",
						success:function(data){
						if(data!=null){
							var res=eval(data);
							$("#leftopsj").empty();
							$.each(res,function(i){
								$("#leftopsj").append("<option value='"+this.sfzh+"'>"+this.xm+"</option>"); 
							});
							}
						},
						error:function(){
							alert("数据获取失败");
						}
				})
			}
		//查询到用户放入右侧下拉框
			function selUsers(id){
			   var tid=id.split('-')[0];
				  var flag=isExistOptions("rightopsj",tid);
				  if(!flag){
					  $("#rightopsj").append("<option value='"+tid+"'>"+id.split('-')[1]+"</option>")
				  }
			   
			}
			//判断select中是否存在值为value的项   
			function isExistOptions(id,value) {   
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
			} 
		  </script>
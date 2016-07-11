<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="name" %>
<%@ attribute name="showText" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="srcImg" %>
<%@ attribute name="deleteFunc" %>
<%@ attribute name="styleClass" %>
<%@ attribute name="fileTypes" %>
<%@ attribute name="sizeLimit" required="true"  %>
<%@ attribute name="uploadType" %>
<%@ attribute name="type" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="${pageContext.request.contextPath}/swfupload/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/swfupload/swfupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/swfupload/fileprogress.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/swfupload/handlersConfig.js"></script>
<c:if test="${empty fileTypes }">
  <c:set var="fileTypes" value="*.*"/>
</c:if>
<c:if test="${empty sizeLimit }">
  <c:set var="sizeLimit" value="20 MB"/>
</c:if>
<script type="text/javascript">
	
	
	jQuery(document).ready(function(){
	var currIds = "${id }";
	var uploadType = "${uploadType }";
	var curType = "${type}";//1为图片，2为其他
	var nameStr = "${name}";
	var hrefUrl = "";
	var swfu;
	var htmlBody="";
	var uploadserviceurl="";
	var imghiddenUrl="";
	var hideTextId="";
		var ids= new Array(); //定义一数组
		ids=currIds.split(","); //字符分割 
		uploadserviceurl=$("#uploadserviceurl").val();
		for (var i=0;i<ids.length ;i++ ){   
	        hideTextId = ids[i];
	        
	        imghiddenUrl=$("#"+hideTextId+"Hidden").val();
	        uploadType=$("#"+hideTextId+"UploadType").val();
	     	nameStr=$("#"+hideTextId+"Name").val();
			imghiddenUrl = "${srcImg}";
	     	if(curType==1){
				hrefUrl="/swf/upload";
			}else if(curType==2){
				hrefUrl="/swf/upload";
			}
		htmlBody="<input type=\"hidden\" id=\""+hideTextId+"curType\" value=\""+curType+"\" /><span id=\"spanButtonPlaceholder"+hideTextId+"\"></span><input type=\"hidden\" name=\""+nameStr+"\" id=\"hideTextId"+hideTextId+"\" value=\""+imghiddenUrl+"\"/>";
		if(imghiddenUrl !=null && imghiddenUrl!=''){
			if(curType == 1){
				htmlBody+="<div class=\"flash\" id=\"fsUploadProgress"+hideTextId+"\"><img src=\"/"+imghiddenUrl+"\" id=\"srcImg"+hideTextId+"\"/>"
			+"<img src=\"${pageContext.request.contextPath}/userdo/images/del_ico.jpg\" onclick=\"deleteSrcImg('"+hideTextId+"')\" alt=\"\" style=\"padding-left:5px\"/>";
			}else{
				htmlBody+="<div class=\"flash\" id=\"fsUploadProgress"+hideTextId+"\">" +"当前文件路径：<b id=\"successuploadpath\">"+getPageDomain()+"/"+imghiddenUrl+"</b>"
			+"<img src=\"${pageContext.request.contextPath}/userdo/images/del_ico.jpg\" onclick=\"deleteSrcImg('"+hideTextId+"')\" alt=\"\" style=\"padding-left:5px\"/>";
			}
		}else{
			htmlBody+="<div class=\"flash\" id=\"fsUploadProgress"+hideTextId+"\" style=\"display:none\">";
		}
		htmlBody+="</div>";
		$("#"+hideTextId).append($(htmlBody));
		
		 var settings = {
			upload_url: "${pageContext.request.contextPath}"+"/admin/upload/swfupload",
			file_post_name: "resume_file",

			file_size_limit : "20MB",
			file_types : "*.*",
			file_types_description : "选择文件",
			file_upload_limit : "0",
			file_queue_limit : "1",

			file_dialog_start_handler: fileDialogStart,
			file_queued_handler : fileQueued,
			file_queue_error_handler : fileQueueError,
			file_dialog_complete_handler : fileDialogComplete,
			upload_progress_handler : uploadProgress,
			upload_error_handler : uploadError,
			upload_success_handler : uploadSuccess,
			upload_complete_handler : uploadComplete,
			button_image_url : "${pageContext.request.contextPath}/userdo/images/upload.gif",
			button_placeholder_id : "spanButtonPlaceholder"+hideTextId,
			button_width: 63,
			button_height: 22,
			flash_url : "${pageContext.request.contextPath}/swfupload/swfupload.swf",
			custom_settings : {
				progress_target : "fsUploadProgress"+hideTextId,
				cancelButtonId : "btnCancel",
				upload_successful : false
			},
			debug: false
		};
		
		var swfu = new SWFUpload(settings);
	    } 						
		
	});
	
	function deleteSrcImg(hideTextId){
		deletePic("fsUploadProgress"+hideTextId,"hideTextId"+hideTextId);
	}
</script>
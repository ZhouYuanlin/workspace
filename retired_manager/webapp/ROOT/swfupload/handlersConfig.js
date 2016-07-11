var formChecker = null;

 // Called by the queue complete handler to submit the form
function uploadDone() {
	try {
		//document.forms[0].submit();
	} catch (ex) {
		alert("上传文件出现错误");
	}
}

function fileDialogStart() {
	//var txtFileName = document.getElementById("uploadText");
	//txtFileName.value = "";

	this.cancelUpload();
}


function fileQueueError(file, errorCode, message)  {
	try {
		// Handle this error separately because we don't want to create a FileProgress element for it.
		switch (errorCode) {
		case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
			alert("只可选择一个文件");
			return;
		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
			alert("上传文件大小超过限制.");
			this.debug("Error Code: File too big, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			return;
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
			alert("不能上传空文件");
			this.debug("Error Code: Zero byte file, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			return;
		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
			alert("不允许的文件格式");
			this.debug("Error Code: Invalid File Type, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			return;
		default:
			//alert("An error occurred in the upload. Try again later.");
			alert("上传出错");
			this.debug("Error Code: " + errorCode + ", File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			return;
		}
	} catch (e) {
	}
}

function fileQueued(file) {
	try {
		//var txtFileName = document.getElementById("uploadText");
		//txtFileName.value = file.name;
	} catch (e) {
	}

}
function fileDialogComplete(numFilesSelected, numFilesQueued) {
	try {
		/* I want auto start the upload and I can do that here */
		this.startUpload();
	} catch (ex)  {
        this.debug(ex);
	}
}

function uploadProgress(file, bytesLoaded, bytesTotal) {
	try {
		document.getElementById(this.settings.custom_settings.progress_target).style.display = "block";
		var percent = Math.ceil((bytesLoaded / bytesTotal) * 100);

		file.id = "singlefile";	// This makes it so FileProgress only makes a single UI element, instead of one for each file
		var progress = new FileProgress(file, this.customSettings.progress_target);
		progress.setProgress(percent);
		progress.setStatus("正在上传...");
	} catch (e) {
	}
	
}


function uploadSuccess(file, serverData) {
	try {
		var curType = $("#curType").val();
		file.id = "singlefile";	// This makes it so FileProgress only makes a single UI element, instead of one for each file
		var progress_target = this.customSettings.progress_target;
		var progress = new FileProgress(file, progress_target);
		progress.setComplete();
		progress.setStatus("上传完成.");
		progress.toggleCancel(false);
		if (serverData === "FAILED") {
			this.customSettings.upload_successful = false;
		} else {
			this.customSettings.upload_successful = true;
			var hideTextId = "hideTextId"+progress_target.substring("fsUploadProgress".length,progress_target.length);
			document.getElementById(hideTextId).value = serverData;
			var img = new Image();
			img.onload = function(){
			  if(img.width > 85)
				  img.width = 85;
			  if(img.height > 85)
				  img.height = 85;
			}
			img.src ="/"+serverData;//getPageDomain()+"/"+serverData;
			document.getElementById(progress_target).innerHTML = "";
			curType =document.getElementById(progress_target.substring("fsUploadProgress".length,progress_target.length)+"curType").value;
			if(curType == 1){
				$("#"+progress_target).append(img);
			}else{
				$("#"+progress_target).append("当前文件路径：<b id=\"successuploadpath\">/"+serverData+"</b>");
			}
			var currHtml="<img style=\"padding-left:5px\" alt=\"删除\" src=\"/userdo/images/del_ico.jpg\" onclick=\"deletePic('"+progress_target+"','"+hideTextId+"')\"/>";
			
			$("#"+progress_target).append(currHtml);
		}
		
	} catch (e) {
	}
}

function deletePic(progress_target,hideTextId){
	//document.getElementById("uploadText").value = "";
	$("#"+hideTextId).val("");
	var progress = document.getElementById(progress_target);
	var childs = progress.childNodes.length;
	for(i=0;i<childs;i++){
		progress.removeChild(progress.childNodes[0]);
	}
	progress.style.display = "none";
}

function uploadComplete(file) {
	try {
		if (this.customSettings.upload_successful) {
			//this.setButtonDisabled(true);
			uploadDone();
		} else {
			file.id = "singlefile";	// This makes it so FileProgress only makes a single UI element, instead of one for each file
			var progress = new FileProgress(file, this.customSettings.progress_target);
			progress.setError();
			progress.setStatus("上传被拒");
			progress.toggleCancel(false);
			
			var txtFileName = document.getElementById("uploadText");
			txtFileName.value = "";

		}
	} catch (e) {
	}
}

function uploadError(file, errorCode, message) {
	try {
		
		if (errorCode === SWFUpload.UPLOAD_ERROR.FILE_CANCELLED) {
			// Don't show cancelled error boxes
			return;
		}
		
		var txtFileName = document.getElementById("uploadText");
		txtFileName.value = "";
		
		// Handle this error separately because we don't want to create a FileProgress element for it.
		switch (errorCode) {
		//case SWFUpload.UPLOAD_ERROR.MISSING_UPLOAD_URL:
		//	alert("There was a configuration error.  You will not be able to upload a resume at this time.");
		//	this.debug("Error Code: No backend file, File name: " + file.name + ", Message: " + message);
		//	return;
		//case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
		//	alert("You may only upload 1 file.");
		//	this.debug("Error Code: Upload Limit Exceeded, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
		//	return;
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
			break;
		default:
			//alert("An error occurred in the upload. Try again later.");
			alert("上传出现错误，请等会再试");
			this.debug("Error Code: " + errorCode + ", File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			return;
		}

		file.id = "singlefile";	// This makes it so FileProgress only makes a single UI element, instead of one for each file
		var progress = new FileProgress(file, this.customSettings.progress_target);
		progress.setError();
		progress.toggleCancel(false);

		switch (errorCode) {
		case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:
			//progress.setStatus("Upload Error");
			progress.setStatus("上传出错");
			this.debug("Error Code: HTTP Error, File name: " + file.name + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:
			//progress.setStatus("Upload Failed.");
			progress.setStatus("上传失败");
			this.debug("Error Code: Upload Failed, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.IO_ERROR:
			//progress.setStatus("Server (IO) Error");
			progress.setStatus("上传出错");
			this.debug("Error Code: IO Error, File name: " + file.name + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:
			//progress.setStatus("Security Error");
			progress.setStatus("上传安全受限");
			this.debug("Error Code: Security Error, File name: " + file.name + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
			//progress.setStatus("Upload Cancelled");
			progress.setStatus("上传被取消");
			this.debug("Error Code: Upload Cancelled, File name: " + file.name + ", Message: " + message);
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
			//progress.setStatus("Upload Stopped");
			progress.setStatus("上传中止");
			this.debug("Error Code: Upload Stopped, File name: " + file.name + ", Message: " + message);
			break;
		}
	} catch (ex) {
	}
}

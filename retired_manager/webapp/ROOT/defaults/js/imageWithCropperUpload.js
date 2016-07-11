/*
 * 图片上传
 * 依赖于uploadify组件
 */

/*
 * attachment upload plugin init
 * @contextPath web上下文路径
 */
KindEditor.ready(function(K) {
	var editor = K.editor({
		allowFileManager : true,
		uploadJson : '/imageUpload?type=avator'
	});
	
	K('#imageWithCropperUpload').click(function() {
		editor.loadPlugin('image', function() {
			editor.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#uploadFileText1').val(),
				clickFn : function(url,title,width) {
					if(width.messsage!=null&&decodeURI(width.messsage)=="请上传jpg|JPG|png|jpeg|gif格式的图片！"){
						alert(decodeURI(width.messsage));
						return;
					}
					uploadSuccess(width,url,title);
					editor.hideDialog();
				}
			});
		});
	});
});

function uploadSuccess(data,url,title){
   	if (data.success) {
   		hideUploadOperationZone();
   		var $imageOriginal = $('#imageOriginal'); 
   		var imagePath = contextPath + '/' + data.fileInfo.filePath + '/' + data.fileInfo.saveFileName + '?t=' + (new Date()).getTime();
   		$imageOriginal.attr('src', imagePath);
   		//$imageOriginal.attr('width', data.fileInfo.width+"px");
   		//$imageOriginal.attr('height', data.fileInfo.height+"px");
   		$imageOriginal.css('width', data.fileInfo.width+"px");
   		$imageOriginal.css('height', data.fileInfo.height+"px");
   		$('#disabledInput').val(data.url);
   		$('#imageBig').attr('src', imagePath);
	    $('#imageMedium').attr('src', imagePath);
	    $('#imageThumb').attr('src', imagePath);
	    $('#imageScaleWidth').val(data.fileInfo.width);
	    $('#imageScaleHeight').val(data.fileInfo.height);
		$('#imageOriginalName').val(data.fileInfo.saveFileName);
	    var w=data.fileInfo.width, h=data.fileInfo.height;
	    var x1=0, y1=0, x2=0, y2=0, f=180;
	    if (w < h) {
	    	if (w < f) {
	    		f = w;
	    	}
	    } else {
	    	if (h < f) {
	    		f = h;
	    	}
	    }
		x1 = Math.round((w - f)/2);
		x2 = parseInt(x1) + parseInt(f);
		y1 = Math.round((h - f)/2);
		y2 = parseInt(y1) + parseInt(f);
		$imageOriginal.imgAreaSelect({ aspectRatio: '1:1', handles: true,
			fadeSpeed: 200, onSelectChange: preview, x1: x1, y1: y1, x2: x2, y2: y2,minHeight:90,minWidth:90 });
		_preview(f, f, x1, y1, x2, y2);
    } else {
	    $('#imageWithCropperUpload-operation-zone-content').html('<div style="text-align:center">' + data.messsage + '</div>'
	    		+ '<div style="text-align:center;padding-top:20px"><input type="button" value="关闭" onclick="hideUploadOperationZone()" /></div>'
	    );												    	
    }
}


function imageWithCropperUploadInit(contextPath, fileSizeLimit) {
	contextPath = contextPath != null ? contextPath : '';
	$('#imageWithCropperUpload').uploadify({
		'swf'      : contextPath + '/defaults/images/jquery_uploadify/uploadify.swf',
		'uploader' : contextPath + '/imageUpload?type=avator',
		'multi'	   : false,
		'uploadLimit'	: 1000,
		'fileTypeExts' 	: '*.jpg',
		'fileSizeLimit'	: fileSizeLimit || 1000,
		'buttonText'	: '上传图片',
		'height'	: 18,
		'width'		: 200,
		'queueID' : 'imageWithCropperUpload-operation-zone-queue',
		'baiingStyle' : true,
		'overrideEvents'   :['onSelectError','onDialogClose'],
		'onSelectError'	   : function(file,errorCode,errorMsg) {
								var msg = null;
								switch(errorCode) {
									case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
										msg = '队列中的上传文件数量超过了最大值';
										break;
									case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
										msg = '图片过大，请上传小于1M的图片';
										break;
									case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
										msg = '文件' + file.name + '" 是0kb, 请上传正确的图片';
										break;
									case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
										msg = '不支持的图片文件类型';
										break;
								}
								if (msg.length > 0)
									alert(msg + '!');
						}, 
		'onUploadStart'	    : function() {
							$('#imageWithCropperUpload').uploadify('disable', true);
							displayUploadOperationZone($('#imageWithCropperUpload-button').find('a.imageWithCropperUpload-link'));
						},
		'onUploadProgress'	: function() {
							$('#imageWithCropperUpload-operation-zone-content').html('<div style="padding:35px 0 0 70px"><div><img src="' + contextPath + '/defaults/images/spinner.gif" style="float:left;margin-right:2px" /><span style="float:left">图片正在上传，请等待...</span></div><div style="clear:both;text-indent:40px;padding-top:20px"><input type="button" value="取消上传" onclick="$(\'#imageWithCropperUpload\').uploadify(\'cancel\');$(\'#imageWithCropperUpload-operation-zone-content\').html(\'\');$(\'#imageWithCropperUpload-operation-zone\').hide()" /></div></div>');
						},
		'onUploadSuccess'	: function(file, data, response) {
						  	var data = eval("(" + data + ")");
						   	if (data.success) {
						   		hideUploadOperationZone();
						   		var $imageOriginal = $('#imageOriginal'); 
						   		var imagePath = contextPath + '/' + data.fileInfo.filePath + '/' + data.fileInfo.saveFileName + '?t=' + (new Date()).getTime();
						   		$imageOriginal.attr('src', imagePath);
						   		$imageOriginal.attr('width', data.fileInfo.width);
						   		$imageOriginal.attr('height', data.fileInfo.height);
						   		$('#imageBig').attr('src', imagePath);
							    $('#imageMedium').attr('src', imagePath);
							    $('#imageThumb').attr('src', imagePath);
							    $('#imageScaleWidth').val(data.fileInfo.width);
							    $('#imageScaleHeight').val(data.fileInfo.height);
								$('#imageOriginalName').val(data.fileInfo.saveFileName);
							    var w=data.fileInfo.width, h=data.fileInfo.height;
							    var x1=0, y1=0, x2=0, y2=0, f=180;
							    if (w < h) {
							    	if (w < f) {
							    		f = w;
							    	}
							    } else {
							    	if (h < f) {
							    		f = h;
							    	}
							    }
					    		x1 = Math.round((w - f)/2);
					    		x2 = parseInt(x1) + parseInt(f);
					    		y1 = Math.round((h - f)/2);
					    		y2 = parseInt(y1) + parseInt(f);
					    		
					    		$imageOriginal.imgAreaSelect({ aspectRatio: '1:1', handles: true,
									fadeSpeed: 200, onSelectChange: preview, x1: x1, y1: y1, x2: x2, y2: y2,minHeight:90,minWidth:90 });
								_preview(f, f, x1, y1, x2, y2);
						    } else {
							    $('#imageWithCropperUpload-operation-zone-content').html('<div style="text-align:center">' + data.messsage + '</div>'
							    		+ '<div style="text-align:center;padding-top:20px"><input type="button" value="关闭" onclick="hideUploadOperationZone()" /></div>'
							    );												    	
						    }
						},
		'onUploadError'		: function() {
						    $('#imageWithCropperUpload-operation-zone-content').html('<div style="text-align:center">IO错误！</div>'
						    		+ '<div style="text-align:center;padding-top:20px"><input type="button" value="关闭" onclick="hideUploadOperationZone()" /></div>'
						    );				
						},
		'onUploadComplete' 	: function() {
							$('#imageWithCropperUpload').uploadify('disable', false);
						}
	});
}
function hideUploadOperationZone() {
	$('#imageWithCropperUpload-operation-zone').hide();
}
function displayUploadOperationZone(thiz) {
	if (thiz == null) return;
	var localThiz = $(thiz);
	var uploadOperationZone = $('#imageWithCropperUpload-operation-zone');
	uploadOperationZone.css({
		top :localThiz.offset().top + localThiz.outerHeight() + 8,
		left:localThiz.offset().left
	});
	uploadOperationZone.show();	
}
function _preview(width, height, x1, y1, x2, y2) {	
	var scaleX = 180 / width;
	var scaleY = 180 / height;

	var scaleW = $('#imageScaleWidth').val();
	var scaleH = $('#imageScaleHeight').val();
	
	$('#imageBig').css({
		width: Math.round(scaleX * scaleW),
		height: Math.round(scaleY * scaleH),
		marginLeft: -Math.round(scaleX * x1),
		marginTop: -Math.round(scaleY * y1)
	});
	
	scaleX = 90 / width;
	scaleY = 90 / height;
	
	$('#imageMedium').css({
		width: Math.round(scaleX * scaleW),
		height: Math.round(scaleY * scaleH),
		marginLeft: -Math.round(scaleX * x1),
		marginTop: -Math.round(scaleY * y1)
	});
	
	scaleX = 50 / width;
	scaleY = 50 / height;
	
	$('#imageThumb').css({
		width: Math.round(scaleX * scaleW),
		height: Math.round(scaleY * scaleH),
		marginLeft: -Math.round(scaleX * x1),
		marginTop: -Math.round(scaleY * y1)
	});

	$('#imageScaleX1').val(x1);
	$('#imageScaleY1').val(y1);
	$('#imageScaleX2').val(x2);
	$('#imageScaleY2').val(y2);  
}
function preview(img, selection) {
	if (!selection.width || !selection.height)
		return;
	_preview(selection.width, selection.height, selection.x1, 
			selection.y1, selection.x2, selection.y2);
}
var pointArr = new Array(); //选中的是所有已checkbox的id集合 相册
var photoArr = new Array();	//选中的是所有已checkbox的id集合 照片
var pointID = null;			//最终选中要修改的相册
var IDArr = new Array();   //相册的ID集
var photoIDArr = new Array();	//相片的ID集
var photoID = null;    			//最终选择要修改的图片
//点击某个checkbox时触发事件	
function doEditAlbum(obj){
	pointID = document.getElementById(obj.id).value;
	if(document.getElementById(obj.id).checked == true){
		pointArr.push(document.getElementById(obj.id).value);
		IDArr.push(obj.id);
	}else{
		for(var i=0;i<pointArr.length;i++){
			if(pointArr[i]==document.getElementById(obj.id).value){
				pointArr.splice(i);
			}
		}
		for(var i=0;i<IDArr.length;i++){
			if(IDArr[i]==obj.id){
				IDArr.splice(i);
			}
		}
	}
}
//点击某个checkbox时触发事件
function doEditPhoto(obj){
	photoID = document.getElementById(obj.id).value;
	if(document.getElementById(obj.id).checked == true){
		photoArr.push(document.getElementById(obj.id).value);
		photoIDArr.push(obj.id);
	}else{
		for(var i=0;i<photoArr.length;i++){
			if(photoArr[i]==document.getElementById(obj.id).value){
				photoArr.splice(i);
			}
		}
		for(var i=0;i<IDArr.length;i++){
			if(photoIDArr[i]==obj.id){
				photoIDArr.splice(i);
			}
		}
	}
}


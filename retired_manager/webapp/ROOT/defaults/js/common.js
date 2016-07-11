	/**
	 * 全选反选
	 */
	function checkAll(obj){ 
		$('.checkboxes').each(function(){
			if(obj.checked){
				$(this).prop('checked',true);
			}else
				$(this).prop('checked',false);
		});
	}
	/**
	* 修改
	*/	
	function fnupdate(message) {
        var count = 0;
        var mes;
        $('.checkboxes').each(function(){
            if (this.checked){
            	count++;
            }
        });
        if (count == 0){
        	mes=message==null?'请选中一项':message;
            alert(mes);
            return false;
        }
        if(count>1){
        	mes=message==null?'只能选一行':message;
        	alert(mes);
        	return false;
        }
        return true;
    }
    /**
    * 删除
    */
	function fnremove() {
        var count = 0;
        $(".checkboxes").each(function () {
            if (this.checked) {
            	count++;
            }
        });
        if (count == 0) {
            alert("请至少选中一项");
            return false;
        }
        if(confirm('确定要删除吗？')){
        	return true;
        }else
        	return false;
       return true; 
    }
	   /**
	    * 移动
	    */
		function fnupmove() {
	        var count = 0;
	        $(".checkboxes").each(function () {
	            if (this.checked) {
	            	count++;
	            }
	        });
	        if (count == 0) {
	            alert("请至少选中一项");
	            return false;
	        }
	        if(confirm('确定要移到该相册吗？')){
	        	return true;
	        }else
	        	return false;
	       return true; 
	    }
	/**
	* 判断开始日期是否大于结束日期时间
	*/
	function fnbeginOverEnd(begin,end,message){
		begin = new Date(begin.replace("-", "/").replace("-", "/"));
		end = new Date(end.replace("-", "/").replace("-", "/"));
		if(begin - end >=0){
			message=message==null?'结束日期必须大于开始日期':message;
			alert(message);
			return true;
		}else{
			return false;
		}
	}
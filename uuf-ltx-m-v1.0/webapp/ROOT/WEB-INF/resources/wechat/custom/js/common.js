
			function SetCookie(name,value)//两个参数，一个是cookie的名子，一个是值
			{
			    var Days = 30; //此 cookie 将被保存 30 天
			    var exp  = new Date();    //new Date("December 31, 9998");
			    exp.setTime(exp.getTime() + Days*24*60*60*1000);
			    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
			}
			
			function getCookie(name)//取cookies函数        
			{
			    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
			     if(arr != null) return unescape(arr[2]); return null;
			
			}
			
			function delCookie(name)//删除cookie
			{
			    var exp = new Date();
			    exp.setTime(exp.getTime() - 1);
			    var cval=getCookie(name);
			    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
			}








// 添加Cookie
function addCookie(name, value, options) {
	if (arguments.length > 1 && name != null) {
		if (options == null) {
			options = {};
		}
		if (value == null) {
			options.expires = -1;
		}
		if (typeof options.expires == "number") {
			var time = options.expires;
			var expires = options.expires = new Date();
			expires.setTime(expires.getTime() + time * 1000);
		}
		document.cookie = encodeURIComponent(String(name)) + "=" + encodeURIComponent(String(value)) + (options.expires ? "; expires=" + options.expires.toUTCString() : "") + (options.path ? "; path=" + options.path : "") + (options.domain ? "; domain=" + options.domain : ""), (options.secure ? "; secure" : "");
	}
}

// 获取Cookie
function getCookie(name) {
	if (name != null) {
		var value = new RegExp("(?:^|; )" + encodeURIComponent(String(name)) + "=([^;]*)").exec(document.cookie);
		return value ? decodeURIComponent(value[1]) : null;
	}
}

// 移除Cookie
function removeCookie(name, options) {
	addCookie(name, null, {expires:-1});
}
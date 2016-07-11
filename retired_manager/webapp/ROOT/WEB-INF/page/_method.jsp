<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--a href="javascript:;;" class="btn blue" onclick="doExcel()"><i class="fa fa-sign-in"></i> 导入</a>
<a href="javascript:;;" class="btn blue" onclick="doXiazai()"><i class="fa fa-sign-out"></i> 导出</a>
<a href="javascript:;;" class="btn blue" onclick="doDown()"><i class="fa fa-download"></i> 下载模板</a-->
<script>
//导入
function doExcel(){
	$('#frm').attr('action','/retment/importexecl').submit();
}
//下载
function doDown(){
	$('#frm').attr('method','post').attr('action','/retment/download').submit();
}
</script>
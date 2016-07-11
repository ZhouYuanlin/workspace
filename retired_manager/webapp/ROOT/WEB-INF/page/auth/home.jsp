<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uufocus.com/taglib" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
</head>
<body>
	<link href="/defaults/css/page-monitor.css" rel="stylesheet"
		type="text/css" />
	<script src="/defaults/plugins/echarts/dist/echarts.js"></script>
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<ul class="page-breadcrumb breadcrumb">
						<li><i class="fa fa-home"></i> <a href="/"> 首页 </a> <i
							class="fa fa-angle-right"></i></li>
						<li><a href="#"> 综合门户 </a> <i class="fa fa-angle-right"></i>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-sm-12">
					<div class="portlet box grey">
						<div class="portlet-title">
							<div class="caption">用户信息</div>
							<div class="tools">
								<a href="" class="collapse"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="scroller-div" style="height: 160px;">
								<div class="media">
									<a href="/avator" class="pull-left user-photo"> <c:if
											test="${empty u.imgsfsc}">
											<img alt="" src="/defaults/img/none.jpg" class="media-object">
										</c:if> <c:if test="${!empty u.imgsfsc}">
											<s:image id="imageThumb" user="${u.sfzh}" size="zoom"
												width="120" height="130" />
										</c:if>
									</a>
									<div class="media-body">
										<h4>
											您好，
											<shiro:principal property="realname" />
											<span>
										</h4>
										<p class="media-txt">${marke.content}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="portlet box grey">
						<div class="portlet-title">
							<div class="caption">个人待办</div>
							<div class="tools">
								<a href="" class="collapse"> </a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="search-div" style="height: 160px;">
								<ul class="list-group">
									<li class="list-group-item"><a href="/workdaily">今日待办工作
											<span class="badge badge-danger pull-right">${curd}</span>
									</a></li>
									<li class="list-group-item"><a href="/workdaily">本周待办工作
											<span class="badge badge-warning pull-right">${curw}</span>
									</a></li>
									<li class="list-group-item"><a href="/workdaily"><span
											class="badge badge-success pull-right">${curm}</span>本月待办项 </a></li>
								</ul>
								<a href="/workdaily" class="btn blue">工作管理</a> <a
									href="/workdaily?status=1" class="btn blue">新建日志</a> <a
									href="/workdaily?status=2" class="btn blue">新建计划</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="portlet box grey">
						<div class="portlet-title">
							<div class="caption">通知公告</div>
							<div class="tools">
								<a href="javascript:;;" class="collapse"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="list list-news" style="height: 160px;">
								<c:forEach items="${nlist}" var="item">
									<dl>
										<dt>
											<a href="#showdetail" ref="${item.id}" class="black"
												data-toggle="modal" title="${item.title}"><s:substring
													length="25" value="${item.title}" clean="true" /></a>
										</dt>
										<dd>
											<fmt:formatDate value="${item.createDate}" pattern="MM.dd" />
										</dd>
									</dl>
								</c:forEach>
								<dl>
									<dt></dt>
									<dd class="more_list">
										<a href="/retirenotice"><i class="fa fa-plus-circle icon"></i>
											更多</a>
									</dd>
								</dl>

							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 col-sm-12">
					<div class="portlet box grey">
						<div class="portlet-title">
							<div class="caption">全局工作</div>
							<div class="tools">
								<a href="" class="collapse"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div style="height: 210px;">

								<!-- 
						<a href="#folderdetail" class="showuf" ref="${chi.id}" data-toggle="modal" ref ="${chi.id}">
					 -->
								<s:substring length="17" value="${chi.fileName}" clean="true" />


								<a id="showJh" href="#folderdetail" data-toggle="modal"
									ref="${flist[0].children[0].id}" class="btn blue btn-sm"
									target="_blank"><i class="fa fa-bookmark icon"></i>${flist[0].children[0].fileName}</a>
								<div class="mgt5">
									<div class="row">
										<c:forEach items="${flist}" var="item" varStatus="c">
											<c:if test="${!c.first}">
												<div class="col-md-4 col-sm-12">
													<table
														class="table table-striped table-advance table-hover">
														<thead>
															<tr>
																<th>${item.fileName}</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${item.children}" var="chi"
																varStatus="c">
																<c:if test="${c.index < 4}">
																	<tr>
																		<td><a href="#folderdetail" class="showuf"
																			ref="${chi.id}" data-toggle="modal"> <s:substring
																					length="17" value="${chi.fileName}" clean="true" />
																		</a> <!-- 
														 <a href="/folder/${chi.id}/noschmadetail" target="_blank"  data-toggle="modal" title="预览文档" class="showuf" ref ="${chi.id}"><s:substring length="17" value="${chi.fileName}" clean="true"/></a>
														  --></td>
																	</tr>
																</c:if>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="portlet box grey">
						<div class="portlet-title">
							<div class="caption">工作资料</div>
							<div class="tools">
								<a href="" class="collapse"> </a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="tiles" style="height: 210px;">
								<div class="tile bg-blue-steel">
									<a href="/folder?pid=24401"><div class="tile-body">
											<i class="fa fa-briefcase"></i>
										</div>
										<div class="tile-object">
											<div class="name">工作手册</div>
										</div></a>
								</div>
								<div class="tile bg-red-sunglo">
									<a href="/retrecord"><div class="tile-body">
											<i class="fa fa-picture-o"></i>
										</div>
										<div class="tile-object">
											<div class="name">通讯录</div>
										</div></a>
								</div>
								<div class="tile bg-yellow-lemon">
									<a href="/folder?pid=36300"><div class="tile-body">
											<i class="fa fa-desktop"></i>
										</div>
										<div class="tile-object">
											<div class="name">工作记录</div>
										</div> </a>
								</div>
								<div class="tile bg-green-meadow">
									<a href="/folder?pid=69405"><div class="tile-body">
											<i class="fa fa-files-o"></i>
										</div> <!-- ?pid=69405&fileName=新建文件夹 --> <!-- 首页点击政策文件时跳转的页面  左侧注释为跳转到文档管理中的政策文件的路径 -->
										<div class="tile-object">
											<div class="name">政策文件</div>
										</div> </a>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="portlet box grey">
						<div class="portlet-title">
							<div class="caption">离退休干部数据统计分析</div>
							<div class="actions"></div>
						</div>
						<div class="portlet-body">
							<div class="row">
								<div id="ec1" class="col-md-2" style="height: 260px;"></div>
								<div id="ec2" class="col-md-2" style="height: 260px;"></div>
								<div id="ec3" class="col-md-2" style="height: 260px;"></div>
								<div id="ec4" class="col-md-2" style="height: 260px;"></div>
								<div id="ec5" class="col-md-2" style="height: 260px;"></div>
								<div id="ec6" class="col-md-2" style="height: 260px;"></div>
							</div>

						</div>
					</div>
				</div>

			</div>

		</div>
	</div>
	<!-- 查看详情 -->
	<div class="modal fade" id="showdetail" tabindex="-1" role="testModal"
		aria-hidden="true"
		style="width: 850px; margin-left: 50%; margin-left: -425px; margin-top: 20px;">
	</div>
	<!-- 在线阅读 -->
	<div class="modal fade" id="folderdetail" tabindex="-1"
		role="testModal" aria-hidden="true"
		style="width: 850px; margin-left: 50%; margin-left: -425px; margin-top: 20px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3>在线阅读</h3>
		</div>
		<div class="modal-body" style="height: 500px">
			<div id="showread"></div>
		</div>
		<div class="modal-footer">
			<button ref="" id="uploadFile" class="btn blue confirm"
				onclick="uploadFile()">下载</button>
			<button data-dismiss="modal" class="btn blue confirm">关闭</button>
		</div>
	</div>

	<!-- 在线阅读 -->
	<div class="modal fade" id="showDoc" tabindex="-1" role="testModal"
		aria-hidden="true"
		style="width: 850px; margin-left: 50%; margin-left: -425px; margin-top: 20px;">
	</div>



	<script>
		    	$(function(){
		    		$('.black').click(function(){
						var id = $(this).attr("ref");
						$.post('/retirenotice/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
							$("#showdetail").html(d);
						});
					});
		    		
		    		$(".showuf,#showJh").click(function(){
		       			var id = $(this).attr("ref");
		       			$("#uploadFile").attr("ref",id);
		       			$.post('/folder/ajaxdetail?'+new Date().getTime(),{"id":id},function(d){
		    				$("#showread").html(d);
		    			});
		       		});
		    		
		    		$('.page-header-fixed').removeClass('page-header-fixed').addClass("page-header-fixed page-full-width page-hidden-breadcrumb page-portal");
		    	});
		    	
		    	function uploadFile(){
		    		var id = $("#uploadFile").attr("ref");
		    		window.location.href="${request.contextPath}/folder/"+id+"/download";
		    	}
		    	//统计
		    	
		    <c:forEach items="${maps}" var="item" varStatus="s">
		    <c:set var='count' value='0'/>
		    <c:set var='count' value='0'/>
		    <c:forEach items="${item.value}" var="chi">
		    <c:set var='count' value='${chi[1] + count}'/>
		    </c:forEach>
		    	require.config({
		    		paths: {
		    			echarts: '/defaults/plugins/echarts/dist'
		    		}
		    		});
		    	require(
		    			[
		    				'echarts',
		    				'echarts/chart/pie'  // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
		    				//'echarts/chart/bar'
		    			],
		    			function (ec) {
		    				var myChart = ec.init(document.getElementById('ec${s.index + 1}'));
		    				var option = {
		    					title : {
		    						text : '${fn:split(item.key,";")[0]}',
		    						x : 'center',
		    						y : 'top',
		    						padding : 0
		    					},
		    					color : [ <c:forEach items="${item.value}" var="chi" varStatus="c">"${fn:split(item.key,';')[c.index + 1]}"<c:if test="${!c.last}">,</c:if></c:forEach> ],
		    					tooltip : {
		    						
		    						trigger: 'item', 
		    						showDelay : 0,
		    						hideDelay : 0,
		    						transitionDuration : 0,
		    						formatter: "{a} <br/>{b} : {c} ({d}%)",
		    						position: function (p) {
		    	                           // 位置回调
		    	                           // console.log && console.log(p);
		    							   var positionconctrl = $(".zr-element").width()/2;//这个选择器选得不精准
		    							   var positionconctrl = $(".zr-element").height()/2;
		    							   if(p[0]>positionconctrl){
		    								   p[0]=p[0]-150;//在右侧的放到左侧 150是估值 没研究如何得到当前tooltip尺寸
		    								}else{
		    								   p[0]=p[0]-20; //在左侧的缩短tooltip框与鼠标的距离
		    								};
		    							   if(p[1]>positionconctrl){
		    								   p[1]=p[1]-30; //在下侧的tooltip往上偏移 30是估值 防止鼠标在动画过程中位于tooltip上
		    								}else{
		    								   p[1]=p[1]+30; //在上侧的tooltip往下偏移
		    								};
		    								
		    	                           return [p[0], p[1]];//返回值
		    	                       },
		    						
		    					},
		    					legend: {
		    						orient : 'horizontal',
		    						x : 'center',
		    						y : 'bottom',
		    						<c:choose>
		    							<c:when test="${s.index == 2}">
		    							padding:['0','0','0','0'],
		    							</c:when>
		    							<c:otherwise>
		    							padding:['0' ,'0', '0' ,'0'],
		    							</c:otherwise>
		    						</c:choose>
		    						data:[<c:forEach items="${item.value}" var="chi" varStatus="c">
		    						<c:if test='${!empty chi[0]}'>'${chi[0]}'</c:if><c:if test='${empty chi[0]}'>'空'</c:if><c:if test="${!c.last}">,</c:if></c:forEach>]
		    					},
		    					calculable : true,
		    					series : [
		    						{
		    							name:'所占比例',
		    							type:'pie',
		    							radius : ['45%','60%'],
		    							itemStyle : {
		    								normal : {
		    									label : {
		    										show : false
		    									},
		    									labelLine : {
		    										show : false
		    									}
		    								},
		    								emphasis : {
		    									label : {
		    										show : true,
		    										position : 'center',
		    										textStyle : {
		    											fontSize : '30',
		    											fontWeight : 'bold'
		    										}
		    									}
		    								}
		    							},
		    							data:[
											<c:forEach items="${item.value}" var="chi" varStatus="c">
		    									{value:${chi[1]}, name:'<c:if test="${!empty chi[0]}">${chi[0]}</c:if><c:if test="${empty chi[0]}">空</c:if>'}<c:if test="${!c.last}">,</c:if>
		    								</c:forEach>
		    							]
		    						}
		    					]
		    				};
		    				myChart.setOption(option);
		    			}
		    		);
		    	</c:forEach>
		    	
		    	
		    </script>
</body>
</html>
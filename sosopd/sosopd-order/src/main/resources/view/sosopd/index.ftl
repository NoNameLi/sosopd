<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="sosopd">
	<meta name="author" content="sosopd">
	
	<!-- 加载CSS -- begin -->
	<#include "./layout_inspinia/loadcss.ftl">
	<!-- 加载CSS -- end -->
	
	<!-- custom style 
	<link href="${resources}/css/index.css" rel="stylesheet">-->
	<!-- 加载JS -- end -->
	
</head>

<body>
	<div id="wrapper">
		<div class="container">
			<div id = "title" class="container-fluid" >
				<div class="row-fluid">
					<div class="navbar navbar-default">
						<div class = "container">
							<div class="navbar-header">
								<span>XXXXXXXX</span>
							</div>			
							<div class="navbar-collapse collapse navbar-right">
								<span>{{userName}}</span>
							</div>
						</div>
					</div>
				</div>
			</div>		
			<div class="container-fluid" >
				<div class="row-fluid">
					<div class="col-sm-12 col-md-12">
						<div class="tabbable" id="tabs">
							<ul class="nav nav-tabs" >
								<li class="active"><a href="#tab-1" data-toggle="tab">派单查询</a></li>
								<li><a href="#tab-2" data-toggle="tab">导入工单</a></li>
								<li><a href="#tab-3" data-toggle="tab">粘贴建单</a></li>
								<li><a href="#tab-4" data-toggle="tab">新增工单</a></li>
								<li class="col-sm-offset-5 col-md-offset-5"><a href="#tab-5" data-toggle="tab">添加平台账号</a></li>
								<li><a href="#tab-6" data-toggle="tab">设置</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="tab-1">
									<iframe v-bind:src="tab_1_url" @load="iframeLoaded" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%" ></iframe>    
								</div>
								<div class="tab-pane" id="tab-2">
									<iframe v-bind:src="tab_2_url" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%" height="80%"></iframe>
								</div>
								<div class="tab-pane" id="tab-3">
									<iframe v-bind:src="tab_3_url" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%" height="80%"></iframe>
								</div>
								<div class="tab-pane" id="tab-4">
									<iframe v-bind:src="tab_4_url" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%" height="80%"></iframe>
								</div>
								<div class="tab-pane" id="tab-5">
									<iframe v-bind:src="tab_5_url" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%" height="80%"></iframe>
								</div>
								<div class="tab-pane" id="tab-6">
									<iframe v-bind:src="tab_6_url" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%" height="80%"></iframe>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</div>
	
	<!-- 加载JS -- begin -->
	<#include "./layout_inspinia/loadjs.ftl">
	<!-- 加载JS -- end -->
	
	<!-- Custom module scripts -->
	<script src="${resources}/js/index.js"></script>
	<!-- 加载JS -- end -->

</body>
</html>

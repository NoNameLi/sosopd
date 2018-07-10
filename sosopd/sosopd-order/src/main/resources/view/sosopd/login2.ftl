<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="登录页面">
	<meta name="author" content="sosopd">
	
	<!-- 加载CSS -- begin -->
	<#include "./layout_inspinia/loadcss.ftl">
	<!-- 加载CSS -- end -->
	
	<!-- custom style -->
	<link href="css/login.css" rel="stylesheet">
	<!-- 加载JS -- end -->
	
</head>

<body>
	<h2>欢迎使用</h2>
	<div id="wrapper">
		<div class="form-detail">
			<div class="form-group m-r-sm">
				<label>用户名：</label> <input name="uname"  type="text" v-model="uname"/>
			</div>
			<div class="form-group m-r-sm">
				<label>密码：</label> <input name="passwd" type="password" v-model="passwd"/>
			</div>
			<div class="form-group m-r-sm">
				<button @click="login()" type="button" class="btn btn-primary"> <i class="fa fa-search"></i> 登录</button>
				<button @click="create()" type="button" class="btn btn-primary"> <i class="fa fa-edit"></i> 注册</button>
			</div>
			
			<div class="form-group m-r-sm" v-show="loginMsgShow">
				<label class="control-label m-r-sm p-t-xs text-center">{{loginMsg}}</label>
			</div>
			
		</div>
	</div>
	<!-- 加载JS -- begin -->
	<#include "./layout_inspinia/loadjs.ftl">
	
	<!-- Custom module scripts -->
	<script src="${resources}/js/login.js"></script>
	<!-- 加载JS -- end -->

</body>
</html>

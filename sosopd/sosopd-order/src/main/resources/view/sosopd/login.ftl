<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <meta charset="utf-8" />
    <title>用户登录</title>
   	<!-- 加载CSS -- begin -->
	<#include "./layout_inspinia/loadcss.ftl">
	<!-- 加载CSS -- end -->
	
	<!-- custom style -->
	<link href="${resources}/css/login.css" rel="stylesheet">
	<!-- 加载JS -- end -->
</head>
<body>
	<div id="wrapper">
		<div class = "login-box">
			<div class="login-align"> 
			   	<div class="login-title"> 
			    	<!-- <img src="" />-->
			    	<span>搜搜派单</span>
			   	</div> 
			   	<form class="el-form login-form">
			    	<div class="el-form-item">
				     	<label class="el-form-item__label">账号</label>
				     	<div class="el-form-item__content">
				      		<div class="el-input">
				       			<input autocomplete="off" placeholder="请输入账号" type="text" rows="2" validateevent="true" class="el-input__inner" v-model="uname"/>	
				      		</div>
			     		</div>
			    	</div> 
				    <div class="el-form-item">
				     	<label class="el-form-item__label">密码</label>
				     	<div class="el-form-item__content">
				      		<div class="el-input">
				       			<input autocomplete="off" placeholder="请输入密码" type="password" rows="2" validateevent="true" class="el-input__inner" v-model="passwd"/>
				      		</div>
				     	</div>
				    </div> 
				    <div class="el-form-item">
				     	<div class="el-form-item__content">
				      		<button type="button" class="el-button login-btn el-button--primary" @click="login()"><span>登 录</span></button>
				     	</div>
				    </div>
			   	</form>
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
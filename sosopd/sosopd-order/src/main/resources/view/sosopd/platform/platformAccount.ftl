<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>

<body>
	<h2>用户账号管理</h2>
	
	<div id="wrapper" v-cloak class ="padding-top-15px">
	
		<div id="normalOperator" class="col-xs-12 col-sm-12 col-md-12">
			<div class="col-xs-8 col-sm-8 col-md-8">
				<div class= "row">
					<h4>添加平台账号</h4>
				</div>
				<div class= "row">
					<div class="col-xs-4 col-sm-4 col-md-4">
						选择派单平台：
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
					</div>
					<div class="col-xs-4 col-sm-4 col-md-4">
					</div>
				</div>
				
				<div class= "row">
					<div class="col-xs-4 col-sm-4 col-md-4">
						平台登录地址：
					</div>
					<div class="col-xs-8 col-sm-8 col-md-8">
						<input class ="form-control" type ="text"/>
					</div>
				</div>
				
				<div class= "row">
					<div class="col-xs-4 col-sm-4 col-md-4">
						平台登录账号：
					</div>
					<div class="col-xs-8 col-sm-8 col-md-8">
						<input class ="form-control" type ="text"/>
					</div>
				</div>
				
				<div class= "row">
					<div class="col-xs-4 col-sm-4 col-md-4">
						平台登录密码：
					</div>
					<div class="col-xs-8 col-sm-8 col-md-8">
						<input class ="form-control" type ="text"/>
					</div>
				</div>	
			
			</div>
			
			<div class="col-xs-4 col-sm-4 col-md-4">
			
			</div>
		
		
		
		
		
		
		
			<div class="col-xs-3 col-sm-3 col-md-3">
				<div class = "row">
					<span v-for = "(item,index) in orderStatusCondition" class="col-xs-3 col-sm-3 col-md-3"  v-bind:class="{active: item.active}" v-on:click="changOrderStatus(index)">
							{{item.name}}
					</span>
				</div>
			</div>
			
			<div class="col-xs-1 col-sm-1 col-md-1">
				<div class="row">
					<input v-model="searchKey" id="searchKey" type="text" class="form-control keyword-ipt" placeholder="关键字" style="font-size: 12px;"/>
					<i class="fa fa-search inlay" @click="draw(true)"></i>
				</div>
			</div>
			<div class="col-xs-2 col-sm-2 col-md-2">
				<div class="row" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div id="createDate_div" class="input-daterange">
							<input id="createDate_search_daterange"
								class="form-control pointer fillet" type="text"
								value="" readonly="readonly" 
								placeholder="下单时间" /> 
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-xs-2 col-sm-2 col-md-2">
				 <div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div>
							<input v-model="addressId" class= "form-control fillet" id="address" type="text" placeholder="工单地址"/>
							<div v-show="addressSelect">
								<span class="aa-dropdown-menu" role="listbox" id="addSelect" style="position: absolute;top: 100%;z-index: 100;left: 0px;right: auto;display: none;">
									<div class="aa-dataset-1"></div>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-xs-2 col-sm-2 col-md-2">
				 <div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<select id="third_platform" v-model="platform" class= "form-control fillet">
							<option value="">全部平台</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-xs-2 col-sm-2 col-md-2">
				 <div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<select id="order_type" v-model="orderType" class= "form-control fillet"> 
							<option value="">全部类型</option>	
						</select>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	<!-- 加载JS -- begin 
	<script src="${resources}/js/test.js"></script>-->
	
	<!-- Custom module scripts -->
	<!-- 加载JS -- end -->

</body>
</html>

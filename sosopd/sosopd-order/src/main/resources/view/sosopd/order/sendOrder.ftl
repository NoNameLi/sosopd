<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>

<body>
	<!-- 加载CSS -- begin -->
	<#include "./layout_inspinia/loadcss.ftl">
	<!-- 加载CSS -- end -->
	
	<!-- custom style -->
	<link href="${resources}/css/order/order.css" rel="stylesheet">
	<!-- 加载JS -- end -->
	
	<div id="wrapper" v-cloak class ="padding-top-15px">
		
		<div class="col-xs-12 col-sm-12 col-md-12">
			<span>已选中{{selectOrders.length}}张单，派给：</span>
		</div>
		
		<div class="col-xs-12 col-sm-12 col-md-12 cursor" >
			<div id="box_card" class="row">
				<div class="tab-card">
				
					<div class="col-xs-2 col-sm-2 col-md-2 payment-card requisition-card " style="width: 140px" v-on:click="confirm(item.id)"  v-for= "item in userPlatformAccounts">
						<div class="mc">
							<div>{{item.account}}</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
	</div>
	
	<!-- 加载JS -- begin -->
	<#include "./layout_inspinia/loadjs.ftl">
	
	<!-- Custom module scripts -->
	<script src="${resources}/js/module/order/sendOrder.js"></script>
	<!-- 加载JS -- end -->

</body>
</html>

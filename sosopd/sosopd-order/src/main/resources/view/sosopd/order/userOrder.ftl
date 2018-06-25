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
		<div id="title" class="col-xs-12 col-sm-12 col-md-12">
			<!-- 
			<div class="col-xs-2 col-sm-2 col-md-2">
				<div class="row">
					<input type="radio" v-model="orderStatus" value="">全部</input>
				</div>
			</div>
			 -->
			<div class="col-xs-2 col-sm-2 col-md-2">
				<div class="row">
					<input v-model="searchKey" id="searchKey" type="text" class="form-control keyword-ipt" placeholder="输入关键字查询" style="font-size: 12px;"/>
					<i class="fa fa-search inlay"></i>
				</div>
			</div>
			<div class="col-xs-3 col-sm-3 col-md-3">
				<div class="row" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div id="createDate_div" class="input-daterange">
							<input id="createDate_search_daterange"
								class="form-control pointer fillet" type="text"
								value="" readonly="readonly" v-model="createDateTimeRange"
								placeholder="下单时间" /> 
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-xs-3 col-sm-3 col-md-3">
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
						<select id="orderType" v-model="orderType" class= "form-control fillet" > 
							<option value="">全部类型</option>	
						</select>
					</div>
				</div>
			</div>
		</div>
		
		
		<div data-step="3" data-intro="这里是表格展示区，工单数据的显示，可以进行分页和排序等操作！" id="table_responsive" class="">
			<table id="datatable" class="table data-table table-striped table-bordered-- table-hover tooltip-demo">
				
			</table>
		</div>
		
		
	</div>
	
	<!-- 加载JS -- begin -->
	<#include "./layout_inspinia/loadjs.ftl">
	
	<!-- Custom module scripts -->
	<script src="${resources}/js/module/order/userOrder.js"></script>
	<!-- 加载JS -- end -->

</body>
</html>

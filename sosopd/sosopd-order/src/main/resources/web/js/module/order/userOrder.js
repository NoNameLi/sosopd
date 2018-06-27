/**
 * 工单“工单管理”页面组件scripts
 */

var vm = new Vue({
	el: '#wrapper',
	data: {
		tableInitCount: 0, // 结算单列表初始化记数
		
		orderStatus : "",
		searchKey : "",
		createDateTimeStart : moment().startOf('day').format('YYYY/MM/DD'),
		createDateTimeEnd : moment().format('YYYY/MM/DD'),
		addressId : "",
		platform : "",
		orderType : "",

		orderStatusCondition:[
			{"name":"全部","value":"","active":true},
			{"name":"派单失败","value":"send_fail","active":false},
			{"name":"未派单","value":"no_send","active":false},
			{"name":"已派单","value":"sended","active":false}
		],
		
		platformCondition:[{"text":"中国联保","id":"01"},{"text":"日日顺","id":"02"}],
		
		orderTypeCondition:[{"text":"维修","id":1},{"text":"安装","id":2}],
		
		province:[{"name":"全国","value":""},{"name":"广东省","value":"01"},{"name":"河南省","value":"02"}],
		
		
		addressSelect:true
		
	},
	methods: {
		
		/* 取选择的范围时间 */
		formatRangeDate : function(id) {
			var rangeDate = $("#" + id).val();
			var startDate = null;
			var endDate = null;
			if (rangeDate) {
				var dateArr = rangeDate.split(' - ');
				if (dateArr && dateArr.length) {
					startDate = (dateArr[0].replace(/\//g, '-')) + " 00:00:00";
					endDate = (dateArr[1].replace(/\//g, '-')) + " 23:59:59";
				}
			}
			return {
				startDate : startDate,
				endDate : endDate
			};
		},
		
		setHttpParams:function(){
			return {
				// 状态
				orderState:this.getActiveOrderStatusValue(),
				// 关键字
				key:this.searchKey,
				// 时间范围
				createDatetimeStart:this.createDateTimeStart + ' 00:00:00',
				createDatetimeEnd:this.createDateTimeEnd + ' 23:59:59',
				// 地址
				provinceId:"",
				cityId:"",
				districyId:"",
				// 平台
				platform:this.platform,
				// 维修
				orderServiceType:this.orderType,
				
			};
		},
		
		resetOrderStatus:function(){
			this.orderStatusCondition[0].active = true;
			for(var i = 1;i < this.orderStatusCondition.length;i++){
				this.orderStatusCondition[i].active=false;
			}
		},
		
		changOrderStatus:function(index){
			this.resetOrderStatus();
			vm.orderStatusCondition[0].active=false;
			vm.orderStatusCondition[index].active = true;
			this.draw(true);
		},
		getActiveOrderStatusValue:function(){
			for(var i = 1;i < this.orderStatusCondition.length;i++){
				if(this.orderStatusCondition[i].active){
					return this.orderStatusCondition[i].value;
				}
			}
			return "";
		},
		
		urlRequestRouter:function(){
			return contextPath + "/sosopd/order/list.json";
		},
		
		initDataTable : function(onlyInitTable) {
//			if(!onlyInitTable){
//				layerLoading();
//			}
			// 设置查询参数
			var params = this.setHttpParams();
			var url = this.urlRequestRouter();
			// 初始化结算单列表datatable
			$("#datatable").dataTable({
				language: datatable_cn,
				"serverSide": true,
				"ajax": {
					"url": url,
					"type": "POST",
					"data": function(d){
						// 设置排序参数
						setSortCondition(d);
						// 添加额外的参数发送到服务器（搜索栏的查询参数）
						d = Object.assign(d, params);
					},
					error : function(res) {
						layer.msg("查询数据失败", {icon:5});
					}
				},
				"destroy": true,
				"scrollX": true,
				"sScrollX": "100%", //表格的宽度
				"sScrollXInner": "100%", //表格的内容宽度
				"scrollY":"100%",
				"bScrollCollapse": true, //当显示的数据不足以支撑表格的默认的高度时，依然显示纵向的滚动条。(默认是false)
				"dom": 'rt<"dt-length" li><"dt-page" p>',
				"rowId": 'orderId',
				"columns": [
					{"data": "orderId", "title": "", "orderable": false, "orderData": 0, className:"text-center serial-num", "visible": true},
					
					{"data": "brand", "title": "品牌产品", className:"text-center", "createdCell": function(td,cd,rd,r,c){
						$(td).html(rd.brand + " " + rd.product);
					}, "width": '8%'},
					{"data": "serviceTypeName", "title": "类型", className:"text-center", "createdCell" : DT_emptyFmatter, "width": '8%'},
					{"data": "custName", "title": "顾客信息", className:"text-center", "createdCell" : function(td,cd,rd,r,c) {
						$(td).html(rd.custName + " " + rd.custPhone);
					}, "width": '8%'},
					{"data": "custAddress", "title": "顾客地址", className:"text-center", "createdCell" : function(td,cd,rd,r,c) {
						$(td).html((rd.custProvinceName?rd.custProvinceName+' ':'') + (rd.custCityName?rd.custCityName+' ':'') + (rd.custCountyName?rd.custCountyName:'')  + (rd.custAddress?rd.custAddress:''));
					}, "width": '10%'},
					{"data": "productModel", "title": "产品型号", className:"text-center", "createdCell" : function(td,cd,rd,r,c) {
						$(td).html(rd.productModel?rd.productModel:"--");
					}, "width": '10%'},
					{"data": "productCount", "title": "数量", className:"text-center", "createdCell": DT_emptyFmatter, "width": '8%'},
					{"data": "guaranteeName", "title": "质保", className:"text-center", "createdCell": DT_emptyFmatter, "width": '8%'},
					{"data": "remark", "title": "备注", className:"text-center", "createdCell": function(td,cd,rd,r,c){
						$(td).html(rd.remark?rd.remark:"--");
					}, "width": '8%'}
				],
				"columnDefs": [ // 自定义列
					{
						"targets": [0], // 需要操作的目标列，下标从 0 开始
						"searchable": false, // 操作列不参与搜索
						"data": "orderId", // 需要的某一列数据对应的属性名
						"render": function(data, type, full) { // 返回需要显示的内容方法
							var optHtml = '<div class="checkbox checkbox-success p-w-xs">\
								<input id="checkbox'+data+'" type="checkbox" name="order-select" value='+full.orderId+'>\
								<label for="checkbox'+data+'"></label>\
							</div>';
							return optHtml;
						}
						
					}
				],
				"initComplete" : function(settings, json) {
					// 计算左侧table最大显示的高度（不超出屏幕）
					vm.reDrawTableHeight();
				},
				"preDrawCallback": function( settings ) {
				},
				"drawCallback": function( settings ) {
					// 计算左侧table最大显示的高度（不超出屏幕）
					vm.reDrawTableHeight();
				}
			}).on('xhr.dt', function(e, settings, json, xhr) { });
			
			// 绑定table中行的点击选中事件
			if(this.tableInitCount==0){
				$('#checkbox').on({
					click: function (event) {
						if(event.target.nodeName!='A'){ // 链接点击时取消冒泡
							var $this = $(this);
							$('#datatable').find('tbody tr').each(function(i,e){
								var checkDom = $(e).find("input[type='checkbox']");
								var selectedCount = $("tbody input[type='checkbox']:checked").length;
								if(checkDom.length>0){
									checkDom[0].checked = $this[0].checked;
									$this[0].checked?$(e).addClass('selected'):$(e).removeClass('selected');
								}
							});
							
							vm.checkCount = $("tbody input[type='checkbox']:checked").length;
						}
					}
				});
				$('#datatable tbody').on({
					click: function (event) {
						if($(this).find('[type="checkbox"]').length){
							if(event.target.nodeName!='A'){ // 链接点击时取消冒泡
								var $this = $(this);
								if($this.hasClass('selected')){
									$this.removeClass('selected');
									$this.find('[type="checkbox"]')[0].checked=false;
								} else {
									$this.addClass('selected');
									$this.find('[type="checkbox"]')[0].checked=true;
								}
								vm.checkCount = $("tbody input[type='checkbox']:checked").length;
								var checkDom = $("tbody").find("input[type='checkbox']").length;
								//判断是否全部选中
								if(vm.checkCount<checkDom){
									$('#checkbox')[0].checked=false;
								}else{
									$('#checkbox')[0].checked=true;
								}
							}
						}else{
							return;
						}
					}
					
				}, 'tr');
				this.tableInitCount=1;
			}
		},
		/* 重绘左侧table最大显示的高度（不超出屏幕） */
		reDrawTableHeight: function(){
			var tbodyHeight = $('#datatable tbody').height();
			var fixedTableHeight = $(window).height() - $('#datatable')[0].offsetTop - 80;
			// table内容高度超出整屏最大可显示高度时显示滚动条
			if(fixedTableHeight < tbodyHeight && fixedTableHeight>0){
				$('#datatable').css('height', fixedTableHeight+'px');
			} else {
				$('#datatable').css('height', 'auto');
			}
		},
		/* 刷新table */
		refresh:function(onlyInitTable){
			vm.draw(onlyInitTable);
		},
		
		change:function(){
			console.log("call change");
		},
		
		
		draw: function(onlyInitTable){
			if(!onlyInitTable){
				layer.closeAll();
				// 记录当前页码刷新
				$('#datatable').DataTable().ajax.reload(null,false);
			} else {
				// 重新加载列表
				vm.initDataTable(onlyInitTable);
			}
		},
		// 重新计算表格内容高度
		refreshTableHeight: function(){
			var height = $(window).height() 
			- $('#title').outerHeight(true) // 标题高度
				- $('#datatable_wrapper .dataTables_scrollHead').outerHeight(true) // 表头高度
				- $('#datatable_wrapper .dt-length').outerHeight(true) // 表尾高度
				- 60; 
			$('#datatable_wrapper .dataTables_scrollBody').css({"height":height+"px","max-height":height+"px"});
			return height;
		},
		
		initPlatformData:function(){
			var vm = this;
			$.ajax({
				url : contextPath + '/sosopd/thirdplatform/getPresetPlatform.json',
				type : 'GET',
				success : function(res) {
					if(res.meta.success){
						vm.platformCondition=res.data;
						
						$('#third_platform').select2({
							data: vm.platformCondition
						}).on("change",function(e){
							vm.platform = $(this).val();
							vm.draw(true);
						});
						//$('#third_platform').val(vm.platform).trigger('change');
					}else{
						layer.msg(res.meta.message, {icon:5});
					}
				},
				error : function(res) {
					layer.msg("合作商初始化失败", {icon:5});
				}
			});
		},
		initOrderType:function(){
			var vm = this;
			$.ajax({
				url : contextPath + '/sosopd/systemDictionary/getOrderTypeBriefly.json',
				type : 'GET',
				success : function(res) {
					if(res.meta.success){
						vm.orderTypeCondition=res.data;
						
						$('#order_type').select2({
							data: vm.orderTypeCondition
						}).on("change",function(e){
							vm.orderType = $(this).val();
							vm.draw(true);
						});
						//$('#order_type').val(vm.orderType).trigger('change');
						
					}else{
						layer.msg(res.meta.message, {icon:5});
					}
				},
				error : function(res) {
					layer.msg("工单类型初始化失败", {icon:5});
				}
			});
		}
	},
	mounted: function(){
		var vm = this;
		$('.pointer').daterangepicker({
			showDropdowns : true,
			showWeekNumbers : false, // 是否显示第几周
			timePicker : false, // 是否显示小时和分钟
			//singleDatePicker : true,
			ranges : {
				'今日' : [moment().startOf('day'), moment()],
				'昨日' : [moment().subtract(1, 'days').startOf('day'), moment().subtract(1, 'days').endOf('day')],
				'本月': [moment().startOf('month'), moment()],
				'上月': [moment().subtract(1, 'months').startOf('month'), moment().subtract(1, 'months').endOf('month')],
				'最近7日' : [moment().subtract(6, 'days'), moment()],
				'最近30日' : [moment().subtract(29, 'days'), moment()]
			},
			opens : 'right', // 日期选择框的弹出位置
			applyClass : 'btn-primary',
			cancelClass : 'btn-white',
			format : 'YYYY/MM/DD', // 控件中from和to 显示的日期格式
			separator : ' - ',
			locale : daterangepicker_cn
		}, function(start, end, label) { // 选择日期后回调
			vm.createDateTimeStart = start.format('YYYY/MM/DD'); 
			vm.createDateTimeEnd = end.format('YYYY/MM/DD');
			vm.draw(true);
		}).change(function() {
			// 显示/隐藏clear按钮
		});
		
		this.initOrderType();
		
		this.initPlatformData();
		
		this.initDataTable();

		$('#createDate_search_daterange').val(this.createDateTimeStart + ' - ' + this.createDateTimeEnd);
		//** 屏幕变更时重新计算表格内容高度
		$(window).resize(function(){
			vm.refreshTableHeight();
		});
		
	}
});
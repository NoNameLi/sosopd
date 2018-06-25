/*!
 * Weixiuhui Copyright (c) 2015 Tangqy,
 * 扳手系统共通scripts
 */

/** 项目页面初始化后共通scripts... */
$(document).ready(function(){
	/*
	 * jQuery validation plugin 提示信息中文汉化
	 * Locale: ZH (Chinese, 中文 (Zhōngwén), 汉语, 漢語)
	 */
	$.extend($.validator.messages, {
		required: "这是必填字段",
		remote: "请修正此字段",
		email: "请输入有效的电子邮件地址",
		url: "请输入有效的网址",
		date: "请输入有效的日期",
		dateISO: "请输入有效的日期 (YYYY-MM-DD)",
		number: "请输入有效的数字",
		digits: "只能输入数字",
		creditcard: "请输入有效的信用卡号码",
		equalTo: "你的输入不相同",
		extension: "请输入有效的后缀",
		maxlength: $.validator.format("最多可以输入 {0} 个字符"),
		minlength: $.validator.format("最少要输入 {0} 个字符"),
		rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
		range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
		max: $.validator.format("请输入不大于 {0} 的数值"),
		min: $.validator.format("请输入不小于 {0} 的数值")
	});
	
	// 手机号码验证  
	jQuery.validator.addMethod("isMobile", function(value, element) {
		var length = value.length;
		var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
		return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请输入正确的手机号码");
	
	/* i-checks plugin */
	$('.i-checks').iCheck({
		checkboxClass: 'icheckbox_square-green',
		radioClass: 'iradio_square-green'
	});

	/* 页面存在iframe-tabs时绑定点击后重新加载当前页宽高的事件 */
	if($('.iframe-tabs a[data-toggle="tab"]').length || $('.iframe-tabs a[data-toggle="tab1"]').length){
		window.onload = function(){
			changeIframeHeight();
		}
		//当浏览器窗口大小改变时，设置显示内容的高度
		window.onresize=function(){
			changeIframeHeight();
		}
	}
	
});

/** Daterangepicker中文化参数 */
var daterangepicker_cn = {
	applyLabel : '确定',
	cancelLabel : '取消',
	fromLabel : '开始时间',
	toLabel : '结束时间',
	customRangeLabel : '自定义',
	daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
	monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
			'七月', '八月', '九月', '十月', '十一月', '十二月' ],
	firstDay : 1
}

/** Datatable中文化参数 */
var datatable_cn = {
	"sProcessing": "处理中...",
	"sLengthMenu": "显示 _MENU_ 项",
	"sZeroRecords": "没有匹配结果",
	"sInfo": "第 _START_ 至 _END_ 项，共 _TOTAL_ 项",
	"sInfoEmpty": "第 0 至 0 项，共 0 项",
	"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
	"sInfoPostFix": "",
	"sSearch": "搜索:",
	"sSearchPlaceholder": "快速查找",
	"sUrl": "",
	"sEmptyTable": "<i class='fa fa-frown-o'></i> 暂时没有数据",
	"sLoadingRecords": "载入中...",
	"sInfoThousands": ",",
	"oPaginate": {
		"sFirst": "首页",
		"sPrevious": "上页",
		"sNext": "下页",
		"sLast": "末页"
	},
	"oAria": {
		"sSortAscending": ": 以升序排列此列",
		"sSortDescending": ": 以降序排列此列"
	}
};

/** Datatable custom script */
// 定义Datatables出错时控制台抛出异常，不直接alert显示任何错误信息
$.fn.dataTable.ext.errMode = 'throw';
// 设置datatable传到服务器端排序的参数
function setSortCondition(data){
	var dColumns = data.columns, // datatables中所有的列
	dOrder = data.order; // datatables中要排序的列
	if(data.order && data.order.length){
		// 取的第一个要排序的列下标
		var orderColumn = data.order[0].column, // 排序列下标{Intager}
		orderDir = data.order[0].dir; // 排序方式{String} "asc" "desc"
		// 根据排序列下标取的排序列的Name
		var orderColumnName = dColumns[orderColumn].data;
		// 添加排序的参数发送到服务器
		data.sortCondition = orderColumnName+' '+orderDir;
	}
}

/** Datatable formater script */
// 格式化日期
function DT_dateTimeFmatter(td, cellData, rowData, row, col) {
	$(td).html(cellData?formatDate(new Date(cellData),'yyyy/MM/dd HH:mm:ss'):'--');
}
// 格式化日期（精简）
function DT_dateTimeSimpleFmatter(td, cellData, rowData, row, col) {
	$(td).html(cellData?formatDate(new Date(cellData),'yy/MM/dd HH:mm'):'--');
}
// 空内容格式化
function DT_emptyFmatter(td, cellData, rowData, row, col) {
	if(cellData===0){ // ''==0 --> true
		$(td).html(cellData);
	} else {
		$(td).html(cellData?cellData:'--');
	}
}
// 金额格式化
function DT_moneyFmatter(td, cellData, rowData, row, col) {
	if(cellData===0){
		$(td).html('￥'+cellData);
	} else {
		$(td).html(cellData?'￥'+toThousands(cellData):'--');
	}
}

/** 记录layer的页面loading框 */
/*var layerIndex = layer.msg('加载中', {
	icon: 16,
	shade: 0.01
});*/
// 上面的loading存在问题，当操作完成后layer.msg的成功提示消息会被这个msg做的loading覆盖
// 所以使用layer.open做一个loading框
function layerLoading(){
	var layerIndex = layer.open({
		type: 1,
		title: false,
		closeBtn: 0,
		shade: 0.01,
		skin: 'no-shadow layer-loading-custom',
		content: '<div class="layui-layer-dialog layui-layer-msg " style="width:180px;"><div id="" class="layui-layer-content layui-layer-padding"><i class="layui-layer-ico layui-layer-ico16"></i>加载中</div><span class="layui-layer-setwin"></span></div>'
	});
	return layerIndex;
	// **** 关闭的方法
	//layer.close(layerIndex);
}

/**
 * 共通iframe-tabs组件初始化
 * @param tabsData tab的地址集
 * 		{
 * 			"id" : "tab-1",
 * 			"url" : contextPath+"/wms/storage/inventoryMgmt.html"
 * 		},
 * 		{
 * 			"id" : "tab-2",
 * 			"url" : stsUrl+"/master/accessory/platform_asm_list_apply.html"
 * 		}
 * @param currentTabId 默认显示的tab的id
 */
function initIframeTabs(tabsData, currentTabId) {
	if(currentTabId){
		// 默认显示的tab按钮
		$('[href="#'+currentTabId+'"]').parent().addClass('active').siblings('.active').removeClass('active');
		// 默认显示的tab-iframe页面
		$("#"+currentTabId).addClass('active').siblings('.active').removeClass('active');
		for (var i = 0; i < tabsData.length; i++) {
			if(tabsData[i].id==currentTabId){
				$('#'+currentTabId).html('<div class="panel-body no-border iframe-body">\
							<iframe scrolling="no" frameborder="0" src="'+tabsData[i].url+'"></iframe>\
						</div>');
			}
		}
	}
	//** 绑定tab里按钮的点击事件，点击后加载相应tabid下的url
	if($('.iframe-tabs a[data-toggle="tab1"]').length){
		$('.iframe-tabs a[data-toggle="tab1"]').on('click', function(){
			var $this = $(this),
			tabId = $this.attr('href').replace('#','');
			if(!$this.parent().hasClass('active')){ // 正在显示的tab点击后不做操作
				// 选中并加载当前tab页内容
				$this.parent().addClass('active').siblings('.active').removeClass('active');
				$('#'+tabId).addClass('active').siblings('.active').removeClass('active');
				// 在 data-toggle="tab" 的tab显示后再加载iframe
				if(tabId && $('#'+tabId).find('iframe').length==0){
					for (var i = 0; i < tabsData.length; i++) {
						if(tabsData[i].id==tabId){
							$('#'+tabId).html('<div class="panel-body no-border iframe-body">\
										<iframe scrolling="no" frameborder="0" src="'+tabsData[i].url+'"></iframe>\
									</div>');
						}
					}
				}
				// 重新计算当前iframe的宽高
				changeIframeHeight();
			}
		});
	}
}
/** 修改iframe-tabs页面的宽高 */
function changeIframeHeight(){
	if($('.tab-pane.active > .iframe-body > iframe').length){
		var h = document.documentElement.clientHeight; //获取页面可见高度
		$('.tab-pane.active > .iframe-body > iframe')[0].style.height = h -5 -15 -43 -5+"px";
	}
}
/** 刷新当前显示的tab页中的iframe */
function refreshCurrentIframe(){
	var $currentIframe = $('.tab-pane.active > .iframe-body > iframe');
	if($currentIframe && $currentIframe.length){
		var currUrl = $currentIframe.attr('src');
		$currentIframe.attr('src', currUrl);
	}
}

/** 获取网页元素的相对位置 -- 指该元素左上角相对于浏览器窗口左上角的坐标 */
function getElementLeft(element){
	var actualLeft = element.offsetLeft;
	var current = element.offsetParent;
	while (current !== null){
		actualLeft += current.offsetLeft;
		current = current.offsetParent;
	}
	return actualLeft;
}
function getElementTop(element){
	var actualTop = element.offsetTop;
	var current = element.offsetParent;
	while (current !== null){
		actualTop += current.offsetTop;
		current = current.offsetParent;
	}
	return actualTop;
}

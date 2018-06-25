/**
 * 工单“工单管理”页面组件scripts
 */

var vm = new Vue({
	el: '#wrapper',
	data: {
		userName:userName,
		tab_1_url:"order/userOrder.html",
		tab_2_url:"order/importOrder.html",
		tab_3_url:"order/pasteOrder.html",
		tab_4_url:"order/addOrder.html",
		tab_5_url:"platform/platformAccount.html",
		tab_6_url:"setting.html",
		
	},
	methods: {
		
		iframeLoaded : function(){
			var height = $(window).height() - $('#title').outerHeight(true) - 100;
			console.log(height);
			$("iframe").height(height);
			   
		}
	},
	mounted: function(){

	}
});
/**
 * 工单“工单管理”页面组件scripts
 */

var vm = new Vue({
	el: '#wrapper',
	data: {
		selectOrders:getQuery("orderIds").split(","),
		
		userPlatformAccounts:[]
	},
	methods: {
		
		initPlatformData:function(){
			var vm = this;
			$.ajax({
				url : contextPath + '/sosopd/thirdplatformAccount/getUserPlatformAccount.json',
				type : 'GET',
				success : function(res) {
					if(res.meta.success){
						vm.userPlatformAccounts = res.data;
					}else{
						layer.msg(res.meta.message, {icon:5});
					}
				},
				error : function(res) {
					layer.msg("合作商初始化失败", {icon:5});
				}
			});
		},
		confirm:function(platformAccountId){
			var vm = this;
			$.ajax({
				url : contextPath + '/sosopd/order/sendOrderToPlatform.json',
				type : 'POST',
				data : {platformAccountId:platformAccountId,orderIds:vm.selectOrders},
				success : function(res) {
					if(res.meta.success){
						layer.closeAll();
					}else{
						layer.msg(res.meta.message, {icon:5});
					}
				},
				error : function(res) {
					layer.msg(res.meta.message, {icon:5});
				}
			});
		}
	},
	mounted: function(){
		this.initPlatformData();
	}
});
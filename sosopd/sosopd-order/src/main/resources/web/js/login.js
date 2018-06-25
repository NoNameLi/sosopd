/**
 * 工单“工单管理”页面组件scripts
 */

var vm = new Vue({
	el: '#wrapper',
	data: {
		uname:null,
		passwd:null,
		loginMsg:null,
		loginMsgShow:false
	},
	methods: {
		getLoginParams : function(){
			var params ={
					account:this.uname,
					password:this.passwd,
			};
			return params;
		},
		login : function(){
			var vm = this;
			$.ajax({
				url : contextPath + '/sosopd/login2.json',
				data : vm.getLoginParams(),
				type : 'POST',
				success : function(res) {
					if(res.meta.success){
						window.location.href=res.data;
					}else{
						vm.loginMsg = res.meta.message;
						vm.loginMsgShow = true;
					}
				}
			});
			
		},
		
		create : function(){
			var vm = this;
			$.ajax({
				url : contextPath + '/sosopd/user/createUser.json',
				data : vm.getLoginParams(),
				type : 'POST',
				success : function(res) {
					if(res.meta.success){
						vm.loginMsg = res.data;
					}else{
						vm.loginMsg = res.meta.message;
					}
					vm.loginMsgShow = true;
				}
			});
		}
	},
	mounted: function(){

	}
});
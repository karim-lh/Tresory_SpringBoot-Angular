(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('DashbordController', DashbordController);
DashbordController.$inject = [ 'Account','$window', '$scope','Dashbord' ,'$state','Notification','$rootScope','$http'];

function DashbordController(Account,$window, $scope,Dashbord,$state,Notification,$rootScope,$http) {

	
	var ctrl = this;
	document.title = 'dashbord';
	ctrl.profil = "agentSaisie";
//	ctrl.passer=passer();
	ctrl.demandes = [];
	ctrl.loadAll = loadAll();
	ctrl.loadAll;
  
	function details ()
	{
		//console.log("going to details");
		$state.go('dashbord.detail');
	}
	
	
	
	
	function loadAll() {
		Notification.query(function(data){
			ctrl.demandes = data;
			//console.log(ctrl.demandes);
		});
	}

	function onSuccess(data) {
		ctrl.demandes = data;
		
	}
	
	

	


	

	
}
})();

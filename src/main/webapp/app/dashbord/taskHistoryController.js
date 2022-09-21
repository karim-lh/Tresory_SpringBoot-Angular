(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('TaskHistoryController', TaskHistoryController);
TaskHistoryController.$inject = [ '$stateParams',
		'$uibModalInstance', '$scope', '$http'];

function TaskHistoryController($stateParams, $uibModalInstance,
		$scope, $http) {
	var ctrl = this;
 
	
	console.log("loaded");
	var id=$stateParams.id;
	console.log(id);
	link="http://localhost:9090/ERP/api/history/"+id;
	console.log("link est", link);
	$http.get(link).then(function(data)
			
	{
//		ctrl.taskHistory=data.data;
		console.log(data);
	}
	
	)
			

	function close() {
		$uibModalInstance.dismiss('cancel');

	}

	
}
})();

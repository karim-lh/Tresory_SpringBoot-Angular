(function() {
	'use strict';

	angular.module('tresorerieApp').controller('ReglementDepenseController',
			ReglementDepenseController);
	ReglementDepenseController.$inject = [ 'Reglement' ,'$http'];

	function ReglementDepenseController(Reglement,$http) {
		document.title = "les reglements des reglements";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.reglements = [];

		ctrl.loadAll();
		function loadAll() {
			$http.get("/api/piece-depense").success(function(data) {
				ctrl.reglements = data;
			})
		}

		function onSuccess(data) {
			ctrl.reglements = data;
		}

	}
})();

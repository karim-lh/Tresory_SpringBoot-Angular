(function() {
	'use strict';

	angular.module('tresorerieApp').controller('MouvementDepenseController',
			MouvementDepenseController);
	MouvementDepenseController.$inject = [ 'Depense', 'Mouvement','$http' ];

	function MouvementDepenseController(Depense, Mouvement,$http) {
		document.title = "les mouvements des depenses";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.depenses = [];
		ctrl.mvt = [];
		ctrl.loadAll();
		function loadAll() {
			$http.get("/api/all-depense").success(function(data)
					{
				   ctrl.depenses=data;
					})
		}

		function onSuccess(data) {
			ctrl.depenses = data;

		}

	}
})();

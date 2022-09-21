(function() {
	'use strict';

	angular.module('tresorerieApp').controller('MouvementController',
			MouvementController);
	MouvementController.$inject = [ 'Mouvement' ];

	function MouvementController(Mouvement) {
		document.title = "les mouvements";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.mouvements = [];
		ctrl.loadAll();
		function loadAll() {
			Mouvement.query(onSuccess); // service
		}

		function onSuccess(data) {
			ctrl.mouvements = data;

		}

	}
})();

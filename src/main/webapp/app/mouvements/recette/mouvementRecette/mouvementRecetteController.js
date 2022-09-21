(function() {
	'use strict';

	angular.module('tresorerieApp').controller('MouvementRecetteController',
			MouvementRecetteController);
	MouvementRecetteController.$inject = [ 'Mouvement', 'Recette','$http' ];

	function MouvementRecetteController(Mouvement, Recette,$http) {
		document.title = "les mouvements des recettes";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.mvt = [];
		ctrl.recettes = [];

		ctrl.loadAll();
		function loadAll() {
			$http.get("/api/all-recette").success(function(data)
					{
				   ctrl.recettes=data;
					})
		}


		function onSuccess(data) {
			ctrl.recettes = data;

		}

	}

})();

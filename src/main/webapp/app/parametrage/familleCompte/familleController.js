(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('FamilleController', FamilleController);
	FamilleController.$inject = [ 'Famille'];

	function FamilleController(Famille) {
		document.title ="les familles des comptes";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.familles = [];
		ctrl.loadAll();
		function loadAll() {
			Famille.query(onSuccess); //service
		}

		function onSuccess(data) {
			ctrl.familles = data;
		}


	}

	})();

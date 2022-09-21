(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('CompteController', CompteController);
	CompteController.$inject = [ 'Compte'];

	function CompteController(Compte) {
		var ctrl = this;
		document.title = "les comptes des tresorerie";
		ctrl.loadAll = loadAll;
		ctrl.comptes = [];
		ctrl.loadAll();
		ctrl.title="compte des treosrerie";
		function loadAll() {
			Compte.query(onSuccess); //service
		}

		function onSuccess(data) {
			ctrl.comptes = data;
		}


	}
	})();


(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('BanqueController', BanqueController);
	BanqueController.$inject = [ 'Banque'];

	function BanqueController(Banque) {
		var ctrl = this;
		document.title ="les banques";
		ctrl.loadAll = loadAll;
		ctrl.banques = [];
		ctrl.loadAll();
		function loadAll() {
			Banque.query(onSuccess); //service
		}

		function onSuccess(data) {
			ctrl.banques = data;
		}


	}

	})();

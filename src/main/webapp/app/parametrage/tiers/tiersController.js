(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('TiersController', TiersController);
	TiersController.$inject = [ 'Tiers'];

	function TiersController(Tiers) {
		
		document.title ="les tiers";
		var ctrl = this;
		
		ctrl.loadAll = loadAll;
		ctrl.tierss = [];
		ctrl.loadAll();
		function loadAll() {
			Tiers.query(onSuccess); //service
		}

		function onSuccess(data) {
			ctrl.tierss = data;
		}


	}
	})();


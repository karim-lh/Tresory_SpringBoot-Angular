(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('FluxController', FluxController);
	FluxController.$inject = [ 'Flux'];

	function FluxController(Flux) {
		document.title ="les flux des tresorerie";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.fluxs = [];
		
		ctrl.loadAll();
		function loadAll() {
			Flux.query(onSuccess); //service
		}

		function onSuccess(data) {
			ctrl.fluxs = data;
		}
		

	}

	})();

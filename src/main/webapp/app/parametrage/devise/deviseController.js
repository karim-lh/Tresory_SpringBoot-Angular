(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('DeviseController', DeviseController);
	DeviseController.$inject = [ 'Devise'];

	function DeviseController(Devise) {
		document.title ="les devises";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.devises = [];
		ctrl.loadAll();
		function loadAll() {
			Devise.query(onSuccess); //service
		}

		function onSuccess(data) {
			ctrl.devises = data;
		}


	}
	})();


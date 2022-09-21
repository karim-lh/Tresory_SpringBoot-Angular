(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('ReglementDepenseController', ReglementDepenseController);
    ReglementDepenseController.$inject = [ 'ReglementDepense','$http'];

	function ReglementDepenseController( ReglementDepense,$http) {
		document.title ="les reglements des reglements";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.reglements = [];
		
		ctrl.loadAll();
		function loadAll() {
			$http.get("/api/piece-recette").success(function(data)
			{
				ctrl.reglements = data;
			}		
			)
		}

		function onSuccess(data) {
			ctrl.reglements = data;
		}
		

	}

	})();

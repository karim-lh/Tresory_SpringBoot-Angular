(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('AgenceBancaireController', AgenceBancaireController);
	AgenceBancaireController.$inject = [ 'AgenceBancaire'];

	function AgenceBancaireController(AgenceBancaire) {
		document.title ="les agences bancaire";
		var ctrl = this;
		ctrl.loadAll = loadAll;
		ctrl.agencesBancaire = [];
		
		ctrl.loadAll();
		function loadAll() {
			AgenceBancaire.query(onSuccess); //service
		}

		function onSuccess(data) {
			ctrl.agencesBancaire = data;
		}
		

	}

	})();

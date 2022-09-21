(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('DepenseDetailController', DepenseDetailController);
DepenseDetailController.$inject = [ 'Depense','entity','$stateParams'];

	function DepenseDetailController( Depense,entity,$stateParams) {
	
		var ctrl=this;
		ctrl.mouvementDepense=entity;


	
	}
	})();

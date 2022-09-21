(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('DeviseDialogController', DeviseDialogController);

	DeviseDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'Devise','Pays' ];

	function DeviseDialogController($stateParams, $uibModalInstance, entity,
			Devise,Pays) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.devise = entity;
		

		function onSuccess(data) {
			ctrl.devises = data;
		}
		function cancel() {
			$uibModalInstance.dismiss('cancel');
		}

		function onSaveSuccess(result) {
			ctrl.isSaving = false;
			$uibModalInstance.close(result);
		}

		function onSaveError() {
			ctrl.isSaving = false;
		}

		function save() {
			ctrl.isSaving = true;
			if (ctrl.devise.idDevise !== null) {
				Devise.save(ctrl.devise, onSaveSuccess, onSaveError);
			} else {
				Devise.save(ctrl.devise, onSaveSuccess, onSaveError);
			}
		}
		
		
		
		
		//get all pays
		ctrl.pays= entity;
		ctrl.loadAllPays = loadAllPays;
		ctrl.payss = [];
		ctrl.loadAllPays();

		function loadAllPays() {
			Pays.query(onSuccessPays);
		}
      
		function onSuccessPays(data) {
			ctrl.payss = data;
		}
		
	}

})();

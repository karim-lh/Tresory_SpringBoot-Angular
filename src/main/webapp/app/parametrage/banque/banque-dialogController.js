(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('BanqueDialogController', BanqueDialogController);
	BanqueDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'Banque' ];

	function BanqueDialogController($stateParams, $uibModalInstance, entity,
			Banque) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.Banque = entity;
		

		function onSuccess(data) {
			ctrl.banques = data;
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
		
			if (ctrl.Banque.idBanque !== null) {
				Banque.save(ctrl.banque, onSaveSuccess, onSaveError);
			} else {
				Banque.save(ctrl.banque, onSaveSuccess, onSaveError);
			}
		}
	}
	})();


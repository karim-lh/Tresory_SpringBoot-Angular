(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('FamilleDialogController', FamilleDialogController);
	FamilleDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'Famille' ];

	function FamilleDialogController($stateParams, $uibModalInstance, entity,
			Famille) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.famille = entity;
		

		function onSuccess(data) {
			ctrl.famille = data;
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
			if (ctrl.famille.idFamille !== null) {
				Famille.save(ctrl.famille, onSaveSuccess, onSaveError);
			} else {
				Famille.save(ctrl.famille, onSaveSuccess, onSaveError);
			}
		}
	}

	})();

(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('FluxDialogController', FluxDialogController);

	FluxDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'Flux' ];

	function FluxDialogController($stateParams, $uibModalInstance, entity,
			Flux) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.flux = entity;
		

		function onSuccess(data) {
			ctrl.fluxs = data;
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
			if (ctrl.flux.idFluxTresorerie !== null) {
				Flux.save(ctrl.flux, onSaveSuccess, onSaveError);
			} else {
				Flux.save(ctrl.flux, onSaveSuccess, onSaveError);
			}
		}
	}
	})();


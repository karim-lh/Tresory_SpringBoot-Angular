(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('JournalDialogController', JournalDialogController);

	JournalDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'Journal' ];

	function JournalDialogController($stateParams, $uibModalInstance, entity,
			Journal) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.journal = entity;
		

		function onSuccess(data) {
			ctrl.journaux = data;
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
			if (ctrl.journal.id !== null) {
				Journal.save(ctrl.journal, onSaveSuccess, onSaveError);
			} else {
				Journal.save(ctrl.journal, onSaveSuccess, onSaveError);
			}
		}
	}
	})();


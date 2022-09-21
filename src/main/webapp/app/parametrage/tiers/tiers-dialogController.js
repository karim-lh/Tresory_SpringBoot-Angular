(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('TiersDialogController', TiersDialogController);

	TiersDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'Tiers','PersonnePhysique'];

	function TiersDialogController($stateParams, $uibModalInstance, entity,
			Tiers,PersonnePhysique) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.tiers = entity;
		
		
		
		ctrl.test = test;

		function test() {

			document.getElementById('com').style.display = 'block';
			console.log(ctrl.form);
			if (ctrl.form == "PH") {
				console.log('showin PH');
				document.getElementById('PH').style.display = 'block';
				console.log('hidin PM');
				document.getElementById('PM').style.display = 'none';
			}

			if (ctrl.form == "PM") {
				console.log('showin PM');
				document.getElementById('PM').style.display = 'block';
				console.log('hiding PH');
				document.getElementById('PH').style.display = 'none';
			}

		}
		
		

		function onSuccess(data) {
			ctrl.tierss = data;
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
			console.log("saving fournisseur + "+ ctrl.fournisseur);
			if (ctrl.fournisseur.idFournisseur !== null) {
				if (ctrl.form == "PM")

					PersonneMorale.save(ctrl.fournisseur, onSaveSuccess,
							onSaveError);
				else if (ctrl.form == "PH")
					PersonnePhysique.save(ctrl.fournisseur, onSaveSuccess,
							onSaveError)
			} else {
				if (ctrl.form == "PM")

					PersonneMorale.save(ctrl.fournisseur, onSaveSuccess,
							onSaveError);
				else if (ctrl.form == "PH")
					PersonnePhysique.save(ctrl.fournisseur, onSaveSuccess,
							onSaveError)
			}
		}
	}

	})();

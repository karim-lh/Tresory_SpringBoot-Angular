(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('AgenceBancaireDialogController', AgenceBancaireDialogController);

	AgenceBancaireDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'AgenceBancaire','Banque'  ];

	function AgenceBancaireDialogController($stateParams, $uibModalInstance, entity,
			AgenceBancaire,Banque) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.agenceBancaire = entity;
		

		function onSuccess(data) {
			ctrl.agencesBancaire = data;
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
			console.log(ctrl.agenceBancaire);
			if (ctrl.agenceBancaire.idAgence !== null) {
				AgenceBancaire.save(ctrl.agenceBancaire, onSaveSuccess, onSaveError);
			} else {
				AgenceBancaire.save(ctrl.agenceBancaire, onSaveSuccess, onSaveError);
			}
		}
		
		
		//get banques in agence
		ctrl.banque= entity;
		ctrl.loadAllBanques = loadAllBanques;
		ctrl.banques = [];
		ctrl.loadAllBanques();

		function loadAllBanques() {
			Banque.query(onSuccessBanque);
		}
      
		function onSuccessBanque(data) {
			ctrl.banques = data;
		}
		
	}
	})();


(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('CompteDialogController', CompteDialogController);

	CompteDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'Compte','AgenceBancaire','Famille' ,'CompteComptable','Journal'];

	function CompteDialogController($stateParams, $uibModalInstance, entity,
			Compte,AgenceBancaire,Famille,CompteComptable,Journal) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.Compte = entity;
		
		

		function onSuccess(data) {
			ctrl.comptes = data;
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
		
			if (ctrl.Compte.idCompte !== null) {
				Compte.save(ctrl.compte, onSaveSuccess, onSaveError);
			} else {
				Compte.save(ctrl.compte, onSaveSuccess, onSaveError);
			}
			
			
		}
		
		
//		service get agences
		ctrl.agence= entity;
		ctrl.loadAllAgences = loadAllAgences;
		ctrl.agences = [];
		ctrl.loadAllAgences();

		function loadAllAgences() {
			AgenceBancaire.query(onSuccessAgence);
		}
      
		function onSuccessAgence(data) {
			ctrl.agences = data;
		}
		
		
		
		
		//service get familles
		
		ctrl.famille= entity;
		ctrl.loadAllFamilles = loadAllFamilles;
		ctrl.familles = [];
		ctrl.loadAllFamilles();

		function loadAllFamilles() {
			Famille.query(onSuccessFamille);
		}
      
		function onSuccessFamille(data) {
			ctrl.familles = data;
		}
		//service get compte comptable
	
		ctrl.compteComptable= entity;
		ctrl.loadAllComptesComptables = loadAllComptesComptables;
		ctrl.comptesComptables = [];
		ctrl.loadAllComptesComptables();

		function loadAllComptesComptables() {
			CompteComptable.query(onSuccessCompteComptable);
		}
      
		function onSuccessCompteComptable(data) {
			ctrl.comptesComptables = data;
		}
		
		//service get all journaux
		
		ctrl.journal= entity;
		ctrl.loadAllJournaux = loadAllJournaux;
		ctrl.journaux = [];
		ctrl.loadAllJournaux();

		function loadAllJournaux() {
			Journal.query(onSuccessJournal);
		}
      
		function onSuccessJournal(data) {
			ctrl.journaux = data;
		}
	}
	})();


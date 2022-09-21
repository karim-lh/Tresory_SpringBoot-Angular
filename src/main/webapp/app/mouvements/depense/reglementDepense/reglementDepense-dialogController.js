(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('ReglementDialogController', ReglementDialogController);
	ReglementDialogController.$inject = [ '$stateParams', '$uibModalInstance',
			'entity', 'Reglement' ,'Mouvement','Tiers','$http'];

	function ReglementDialogController($stateParams, $uibModalInstance, entity,
			Reglement,Mouvement,Tiers,$http) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.reglementDepense = entity;
		 ctrl.modes=[];

		$http.get("/api/mode-paiement").success(function(data)
				{
			   ctrl.modes=data;
				})
		
		function onSuccess(data) {
			ctrl.depenses = data;
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
			console.log("entered");
			
			console.log(ctrl.reglementDepense);
			if (ctrl.reglementDepense.idPiecePaiementMvt !== null) {
				Reglement.save(ctrl.reglementDepense, onSaveSuccess, onSaveError);
			} else {
				Reglement.save(ctrl.reglementDepense, onSaveSuccess, onSaveError);
			}
		}
		
		
		
		//service get all tiers
		ctrl.loadAllTiers=loadAllTiers;
		ctrl.tierss = [];
		ctrl.loadAllTiers();
		function loadAllTiers() {
			Tiers.query(onSuccessTiers); //service
		}

		function onSuccessTiers(data) {
			ctrl.tierss = data;
		}

	
		//service get depenses
		ctrl.loadAllDepenses=loadAllDepenses;
		ctrl.depenses = [];
		ctrl.loadAllDepenses();
		function loadAllDepenses() {
			Mouvement.query(onSuccessDepenses); //service
		}

		function onSuccessDepenses(data) {
			ctrl.depenses = data;
		}

		
  ctrl.find=find;
  function find()
  {
	  for (i=0;i<ctrl.depenses.length;i++)
	   {
		  if (ctrl.depenses[i].idMouvement==ctrl.num)
			  {
			  ctrl.mvt=ctrl.depenses[i];
			  console.log("found");
			  }
	   }
  }

		
	}
	})();


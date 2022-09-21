(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('MouvementRecetteDialogController', MouvementRecetteDialogController);
	MouvementRecetteDialogController.$inject = ['$scope', '$stateParams', '$uibModalInstance',
			'entity', 'Tiers','Devise' ,'Compte','Demandeur','Flux', 'entity1','$http','Demande'];

	function MouvementRecetteDialogController($scope,$stateParams, $uibModalInstance, entity,
			Tiers,Devise,Compte,Demandeur,Flux, entity1,$http,Demande) {
		var ctrl = this;
		ctrl.cancel = cancel;
		ctrl.save = save;
		ctrl.mouvementRecette = entity;
		ctrl.demande = entity1;
		

		function onSuccess(data) {
			ctrl.recettes = data;
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

//		function save() {
//			ctrl.isSaving = true;
//			console.log("demande");
//			ctrl.mouvementRecette.typeMouvement="recette";
//			ctrl.demande.mouvement = ctrl.mouvementRecette;
//			Demande.save(ctrl.demande);
//			console.log(ctrl.demande.observartion);
//			$uibModalInstance.dismiss('dismiss');
//				
//			
//		}
		
		
		function onSaveSuccess(result) {
			ctrl.isSaving = false;
			$uibModalInstance.close(result);
			console.log("done sending mouvement with id");
			console.log(ctrl.mouvementRecette.idMouvement);
			
			console.log("sending files ....");
			var fd = new FormData();
            fd.append('file', $scope.myFile);
            fd.append('folderParent', "Recette");
            console.log("id mouvement is ");
            console.log(result.mouvement.idMouvement);
            fd.append('folderName',result.mouvement.idMouvement);
            fd.append('name', $scope.myFile.name);
          
           console.log(result.idDemande);
            $http.post("http://localhost:9090/ERP/api/file", fd, {
                           transformRequest : angular.identity,
                           headers : {
                                           'Content-Type' : undefined
                           }
            }).then(function(data)
            		
            {
            	console.log("sended succfully");
            }
            
            );
		}

		function onSaveError() {
			ctrl.isSaving = false;
		}

		function save() {
			ctrl.isSaving = true;
			ctrl.mouvementRecette.typeMouvement="recette";
			console.log("trying to save...");
			console.log(ctrl.mouvementRecette);
			ctrl.demande.mouvement = ctrl.mouvementRecette;
		
				Demande.save(ctrl.demande, onSaveSuccess, onSaveError);
				console.log(ctrl.demande.mouvement.idMouvement);
			
		}
		
		
		
		
		// get all devises
		
//service get all devises
		
		ctrl.loadAllDevises = loadAllDevises;
		ctrl.devises = [];
		ctrl.loadAllDevises();
		function loadAllDevises() {
			Devise.query(onSuccessDevise); //service
		}

		function onSuccessDevise(data) {
			ctrl.devises = data;
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

		//get all tresorerie accounts
		
		ctrl.loadAllAcc = loadAllAcc;
		ctrl.comptes = [];
		ctrl.loadAllAcc();
		function loadAllAcc() {
			Compte.query(onSuccessAcc); //service
		}

		function onSuccessAcc(data) {
			ctrl.comptes = data;
			console.log("work");
		}
		
		
//get all Demandeurs
		
		ctrl.loadAllD = loadAllD;
		ctrl.demandeurs = [];
		ctrl.loadAllD();
		function loadAllD() {
			Demandeur.query(onSuccessD); //service
		}

		function onSuccessD(data) {
			ctrl.demandeurs = data;
			console.log(ctrl.demandeurs);
		}
		
//get allflux
		
		ctrl.loadAllF = loadAllF;
		ctrl.fluxs = [];
		ctrl.loadAllF();
		
		function loadAllF() {
			Flux.query(onSuccessF); //service
		}

		function onSuccessF(data) {
			ctrl.fluxs = data;
			console.log(ctrl.fluxs);
		}
		
		
		
		
		
	
	
		
	}
	})();


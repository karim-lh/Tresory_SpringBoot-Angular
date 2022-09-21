(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('DashbordDetailController', DashbordDetailController);
DashbordDetailController.$inject = [ '$stateParams', 'Dashbord',
		'$uibModalInstance', '$scope', '$http', 'entity', '$state', 'Steps','Notification','$window' ];

function DashbordDetailController($stateParams, Dashbord, $uibModalInstance,
		$scope, $http, entity, $state, Steps,Notification,$window) {
	var ctrl = this;

	ctrl.close = close;
	ctrl.demande = entity;
	ctrl.save = save;
	ctrl.re=[];
	ctrl.pieces=[];
console.log(ctrl.demande);
var link="";	
ctrl.getFile=getFile();
ctrl.getFile;
function getFile()
{
	console.log("searching files..... ");
	if (ctrl.demande.mouvement.typeMouvement=="depense")
	link="/api/file?path=/PFE/Depense/"+ctrl.demande.mouvement.idMouvement;
	else
		link="/api/file?path=/PFE/Recette/"+ctrl.demande.mouvement.idMouvement;
	console.log(link);
 $http.get(link).then(function(data)
 		 {
	       ctrl.pieces=data.data;
	       console.log("pieces found");
	       console.log(ctrl.pieces);
	      
 		 }
 
 )
 

}
	
	function save(){
		
		ctrl.demande.observation=ctrl.observation;
		if (ctrl.demande.idDemande !== null) {

			Notification.save(ctrl.demande, onSaveSuccess,
						onSaveError);
		}
		else
			Notification.save(ctrl.demande, onSaveSuccess,
					onSaveError);
		
		
	}
	
	if(ctrl.demande.taskName == "Avis chef service trésorie"){
		ctrl.decision = ['ACCORD', 'CI', 'REJET'];
		//console.log("aaaaa");
	}
	if(ctrl.demande.taskName == "Signature directeur financier"){
		ctrl.decision = ['SIGNATURE', 'CI', 'REJET'];
	}
	if(ctrl.demande.taskName == "Complément d'information"){
		ctrl.decision = ['Retour ci'];
	}
	if(ctrl.demande.taskName == "Notification"){
		ctrl.decision = ['CLOTURE'];
	}
	
	function onSaveSuccess(result) {
		ctrl.isSaving = false;
		$uibModalInstance.close(result);
	}

	function onSaveError() {
		ctrl.isSaving = false;
	}

	




	function close() {
		$uibModalInstance.dismiss('cancel');

	}

	
	ctrl.openFile=openFile;
	
	function openFile(name)
	{
		id=name.split("/");
		link="http://127.0.0.1:9876/share/proxy/alfresco/slingshot/node/content/workspace/SpacesStore/"+id[3];
		console.log("trying to open file with link");
		console.log(link);
		$window.open(link);
	}
	


}
})();


(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('JournalController', JournalController);
JournalController.$inject = [ 'Journal','$scope' ];

function JournalController(Journal,$scope) {
	document.title = "les journaux";
	var ctrl = this;
	ctrl.loadAll = loadAll;
	ctrl.journaux = [];
	ctrl.loadAll();
	function loadAll() {
		Journal.query(onSuccess); // service
	}

	function onSuccess(data) {
		ctrl.journaux = data;
	}

//	ctrl.find = function(x) {
//		i = 0;
//
//		while (i < ctrl.journaux.length) {
//			//console.log(ctrl.journaux[i].codeJournal);
//			if (ctrl.journaux[i].codeJournal == x) {
//				j = ctrl.journal[i];
//				
//				
//			 console.log("found");
//			
//			
//			}
//				i++;
//
//		}
//		
//		showval(j);
//
//	}
//	showval=function(j)
//	{
//		ctrl.libelle=j.libelleJournal;
//	}
}
	})();

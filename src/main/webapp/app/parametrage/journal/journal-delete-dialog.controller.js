
      (function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .controller('JournalDeleteController', JournalDeleteController);
    JournalDeleteController.$inject = ['$uibModalInstance','entity', 'Journal'];

    function JournalDeleteController ($uibModalInstance,entity,Journal) {
    	var ctrl = this;
    	ctrl.journal = entity;
    	ctrl.ok =function confirmDelete (id) {
              Journal.delete({id: id},
                      function () {
                          $uibModalInstance.close(true);
                      });
              }

    	  ctrl.cancel =function clear () {
              $uibModalInstance.dismiss('cancel');
          }
    }

	})();


(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Demande', Demande);

	

    Demande.$inject = ['$resource'];

    function Demande ($resource) {             //service
        var service = $resource('api/demandeMouvement/:id',{
                        'save': { method:'POST' },
           'update': { method:'PUT' }
           
        });

        return service;
    }
})();

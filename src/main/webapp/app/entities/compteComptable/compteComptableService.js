(function() {
	'use strict';

	angular.module('tresorerieApp').factory('CompteComptable', CompteComptable);

	

    CompteComptable.$inject = ['$resource'];

    function CompteComptable ($resource) {             //service
        var service = $resource('api/compteComptable/:id',{
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'save': { method:'POST' }
          ,
          'update': { method:'PUT' },
            'delete':{ method:'DELETE'}
        });

        return service;
    }
})();

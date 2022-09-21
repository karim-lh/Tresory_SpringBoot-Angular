(function() {
	'use strict';

	angular.module('tresorerieApp').factory('AgenceBancaire', AgenceBancaire);

	

    AgenceBancaire.$inject = ['$resource'];

    function AgenceBancaire ($resource) {             //service
        var service = $resource('api/agenceBancaire/:id',{
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'save': { method:'POST' }
            /*
,          'update': { method:'PUT' },
         'delete':{ method:'DELETE'}*/
        });

        return service;
    }
})();

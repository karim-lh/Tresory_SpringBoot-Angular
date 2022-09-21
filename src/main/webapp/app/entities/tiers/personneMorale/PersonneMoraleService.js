(function() {
	'use strict';

	angular.module('tresorerieApp').factory('PersonneMorale', PersonneMorale);

	
    PersonneMorale.$inject = ['$resource'];

    function PersonneMorale ($resource) {             //service
        var service = $resource('api/PersonneMorale/:id',{
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

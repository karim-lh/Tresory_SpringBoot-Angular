(function() {
	'use strict';

	angular.module('tresorerieApp').factory('PersonnePhysique', PersonnePhysique);

	

    PersonnePhysique.$inject = ['$resource'];

    function PersonnePhysique ($resource) {             //service
        var service = $resource('api/PersonnePhysique/:id',{
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

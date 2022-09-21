(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Pays', Pays);

	
    Pays.$inject = ['$resource'];

    function Pays ($resource) {             //service
        var service = $resource('api/pays/:id',{
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

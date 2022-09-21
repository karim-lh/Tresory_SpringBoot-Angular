(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Banque', Banque);

	

    Banque.$inject = ['$resource'];

    function Banque ($resource) {             //service
        var service = $resource('api/banque/:id',{
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

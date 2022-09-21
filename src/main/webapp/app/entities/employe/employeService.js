(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Employe', Employe);

	

    Employe.$inject = ['$resource'];

    function Employe ($resource) {             //service
        var service = $resource('api/employe/:id',{
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'save': { method:'POST' },
           'update': { method:'PUT' },
            'delete':{ method:'DELETE'}
        });

        return service;
    }
})();

(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Devise', Devise);

	

    Devise.$inject = ['$resource'];

    function Devise ($resource) {             //service
        var service = $resource('api/devise/:id',{
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

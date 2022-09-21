(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Recette', Recette);

	
        Recette.$inject = ['$resource'];

    function Recette ($resource) {             //service
        var service = $resource('api/recette/:id',{
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            }
        });

        return service;
    }
})();

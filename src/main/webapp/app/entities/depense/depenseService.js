
(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Depense', Depense);

	
        Depense.$inject = ['$resource'];

    function Depense ($resource) {             //service
        var service = $resource('api/depense/:id',{
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
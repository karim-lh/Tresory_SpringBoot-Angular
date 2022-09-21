(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Dashbord', Dashbord);


    Dashbord.$inject = ['$resource'];

    function Dashbord ($resource) {
        var service = $resource('api/demandesMvt/demandeur/:id',{
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
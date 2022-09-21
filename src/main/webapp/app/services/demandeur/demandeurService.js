
        (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('Demandeur', Demandeur);

    Demandeur.$inject = ['$resource'];

    function Demandeur ($resource) {             //service
        var service = $resource('api/demandeur/:id',{
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
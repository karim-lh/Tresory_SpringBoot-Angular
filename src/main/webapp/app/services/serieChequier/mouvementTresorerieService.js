
        (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('Mouvement', Mouvement);

    Mouvement.$inject = ['$resource'];

    function Mouvement ($resource) {             //service
        var service = $resource('api/mouvementTresorerie/:id',{
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

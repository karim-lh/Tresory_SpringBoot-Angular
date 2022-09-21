
        (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('Famille', Famille);

    Famille.$inject = ['$resource'];

    function Famille ($resource) {             //service
        var service = $resource('api/familleCompte/:id',{
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



        (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('Compte', Compte);

    Compte.$inject = ['$resource'];

    function Compte ($resource) {             //service
        var service = $resource('api/compteTresorerie/:id',{
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

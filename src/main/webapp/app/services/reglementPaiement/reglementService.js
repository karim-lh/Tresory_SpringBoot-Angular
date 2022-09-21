
        (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('Reglement', Reglement);

        Reglement.$inject = ['$resource'];

    function Reglement ($resource) {             //service
        var service = $resource('api/piecePaiementMvt/:id',{
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'save': { method:'POST' }
            
,        'update': { method:'PUT' },
         'delete':{ method:'DELETE'}
        });

        return service;
    }
})();


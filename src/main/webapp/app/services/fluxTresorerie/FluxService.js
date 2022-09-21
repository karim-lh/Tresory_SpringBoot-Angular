
        (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('Flux', Flux);

    Flux.$inject = ['$resource'];

    function Flux ($resource) {             //service
        var service = $resource('api/fluxTreosorerie/:id',{
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'save': { method:'POST' }
            /*
,          'update': { method:'PUT' },
         'delete':{ method:'DELETE'}*/
        });

        return service;
    }

})();

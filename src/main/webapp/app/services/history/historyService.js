
        (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('History', History);


    History.$inject = ['$resource'];

    function History ($resource) {             //service
        var service = $resource('api/history/:id',{
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            }
//            ,
//            'save': { method:'POST' }
//            /*
//,          'update': { method:'PUT' },
//         'delete':{ method:'DELETE'}*/
        });

        return service;
    }
})();


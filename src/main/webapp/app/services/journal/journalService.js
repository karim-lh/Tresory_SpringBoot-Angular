
        (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('Journal', Journal);


    Journal.$inject = ['$resource'];

    function Journal ($resource) {             //service
        var service = $resource('api/journal/:id',{
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


       (function () {
    'use strict';

    angular
        .module('tresorerieApp')
        .factory('Notification', Notification);

    Notification.$inject = ['$resource'];

    function Notification ($resource) {             //service
        var service = $resource('api/notifications/:id',{
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET'
            },
            'save': { method:'POST' },
           'update': { method:'PUT' },
            'delete':{ method:'DELETE'}
        });

        return service;
    }

})();

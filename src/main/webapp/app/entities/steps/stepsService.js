(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Steps', Steps);

	

    Steps.$inject = ['$resource'];

    function Steps ($resource) {             //service
        var service = $resource('api/steps/:id',{
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
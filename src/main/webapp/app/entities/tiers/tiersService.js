(function() {
	'use strict';

	angular.module('tresorerieApp').factory('Tiers', Tiers);

	Tiers.$inject = [ '$resource' ];

	function Tiers($resource) { // service
		var service = $resource('api/tiers/:id', {
			'query' : {
				method : 'GET',
				isArray : true
			},
			'get' : {
				method : 'GET',
				transformResponse : function(data) {
					data = angular.fromJson(data);
					return data;
				}
			},
			'save' : {
				method : 'POST'
			},
			'update' : {
				method : 'PUT'
			},
			'delete' : {
				method : 'DELETE'
			}
		});

		return service;
	}

})();

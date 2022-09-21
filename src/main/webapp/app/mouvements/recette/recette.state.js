
(function() {
	'use strict';

	angular.module('tresorerieApp').config(stateConfig);

	stateConfig.$inject = [ '$stateProvider' ];

	function stateConfig($stateProvider) {
		$stateProvider

		.state('recette', {
			parent : 'app',
			url : '/recette',
			data : {
				authorities : []
			},
			views : {
				'content@' : {
					templateUrl : 'app/mouvements/recette/recette.html'

				}
			},
			resolve : {
				translatePartialLoader : [ '$translate',
						'$translatePartialLoader',
						function($translate, $translatePartialLoader) {
							$translatePartialLoader.addPart('home');
							return $translate.refresh();
						} ]
			}
		})
	}
})();

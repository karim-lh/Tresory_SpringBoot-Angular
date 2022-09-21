//(function() {
//	'use strict';
//
//	angular.module('tresorerieApp').config(stateConfig);
//
//	stateConfig.$inject = [ '$stateProvider' ];
//
//	function stateConfig($stateProvider) {
//
//		$stateProvider
//				.state(
//						'suivicheque',
//						{
//							url : '/suivi-cheque',
//
//							views : {
//								'content@' : {
//
//									templateUrl : 'app/mouvements/suivichequier/suivicheque.html'
//								/*
//								 * controller :'FamilleController',
//								 * controllerAs: 'ctrl'
//								 */
//								},
//
//								'progress' : {
//									templateUrl : 'app/mouvements/suivichequier/suivichequeProgress.html'
//
//								}
//							}
//						})
//	}
//
//});
//

(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        
        .state('suivicheque', {
            parent: 'recette',
            url: '/suivi-cheque',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/mouvements/suivichequier/suivicheque.html',
                    controller: 'FamilleController',
                    controllerAs: 'ctrl'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('home');
                    return $translate.refresh();
                }]
            }
        })
    }
})();


(function() {
	'use strict';

	angular.module('tresorerieApp').config(stateConfig);

	stateConfig.$inject = [ '$stateProvider' ];

	function stateConfig($stateProvider) {
		$stateProvider

				.state(
						'recette.reglement',
						{
							parent : 'recette',
							url : '/reglement',
							data : {
								authorities : []
							},
							views : {
								'contentMvtRecette' : {
									templateUrl : 'app/mouvements/recette/reglementRecette/ReglementDepense.html',
									controller : 'ReglementDepenseController',
									controllerAs : 'ctrl'
								}
							},
							resolve : {
								translatePartialLoader : [
										'$translate',
										'$translatePartialLoader',
										function($translate,
												$translatePartialLoader) {
											$translatePartialLoader
													.addPart('home');
											return $translate.refresh();
										} ]
							}
						})

						
						   
        
                
        .state('recette.reglement.new', {
            parent: 'recette.reglement',
            url: '/new',
            data: {
                authorities: []
            },
          onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
          $uibModal.open({
              templateUrl: 'app/mouvements/recette/reglementRecette/reglementDepense-dialog.html',
              controller: 'ReglementRecetteDialogController',
              controllerAs: 'ctrl',
              backdrop: 'static',
              size: 'lg',
              resolve: {
                entity: function () {
                    return {
                        
                    	
                    	
                    	
                    };
                },
        
        entity1: function () {
            return {
              
            };
          }
              }
          }).result.then(function() {
              $state.go('recette.reglement', null, { reload: 'recette.reglement' });
          }, function() {
              $state.go('recette.reglement');
          });
      }]
        })
	}
})();
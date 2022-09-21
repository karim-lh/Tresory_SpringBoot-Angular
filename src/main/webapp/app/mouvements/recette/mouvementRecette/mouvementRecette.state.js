
(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        
        .state('recette.mouvementRecette', {
            parent: 'recette',
            url: '/contentMvtRecette',
            data: {
                authorities: []
            },
            views: {
                'contentMvtRecette': {
                    templateUrl: 'app/mouvements/recette/mouvementRecette/mouvementRecette.html',
                    controller: 'MouvementRecetteController',
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
        
        
        
                
        .state('recette.mouvementRecette.new', {
            parent: 'recette.mouvementRecette',
            url: '/new',
            data: {
                authorities: []
            },
          onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
          $uibModal.open({
              templateUrl: 'app/mouvements/recette/mouvementRecette/mouvementRecette-dialog.html',
              controller: 'MouvementRecetteDialogController',
              controllerAs: 'ctrl',
              backdrop: 'static',
              size: 'lg',
              resolve: {
                entity: function () {
                    return {
                        
                    	idMouvement: null,
                    	  numMouvement: null,
                    	  dateMouvement: null,
                    	  montantMouvement: null,
                    	  tauxChangeMouvement:null,
                    	  objetMouvement: null,
                    	  libelleMouvement: null,
                    	  typeMouvement: null,
                    	  compteTresorerie: null,
                    	  demandeur: null,
                    	  devise: null,
                    	  fluxTresorerie: null,
                    	  tiers: null,
                    	  user: null,
                    	
                    	
                    };
                },
        
        entity1: function () {
            return {
                
            	idDemande:null,
            	dateCreation:null,
            dateSignature:null,
            typeDemande:null,
            initiateur:null,
            singnataire:null,
            statut:null,
            decision:null,
            decideur:null,
            observation:null,
            mouvement:null
            };
          }
              }
          }).result.then(function() {
              $state.go('recette.mouvementRecette', null, { reload: 'recette.mouvementRecette' });
          }, function() {
              $state.go('recette.mouvementRecette');
          });
      }]
        })
    }
})();
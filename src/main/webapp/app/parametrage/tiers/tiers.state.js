(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('tiers', {
            parent: 'app',
            url: '/tiers',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                	templateUrl:'app/parametrage/tiers/tiers.html',
        	    	   controller :'TiersController',
       	    	    controllerAs: 'ctrl'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    
                    return $translate.refresh();
                }]
            }
        })
          .state('tiers.new', {
            url: '/Ajout',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/parametrage/tiers/tiers-dialog.html',
                    controller: 'TiersDialogController',
                    controllerAs: 'ctrl',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                               
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tiers', null, { reload: true });
                }, function() {
                    $state.go('tiers');
                });
            }]
        })
    }
})();

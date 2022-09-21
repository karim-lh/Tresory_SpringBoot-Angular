(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('flux', {
            parent: 'app',
            url: '/flux',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                	templateUrl:'app/parametrage/flux/flux.html',
         	    	  controller :'FluxController',
        	    	    controllerAs: 'ctrl'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    return $translate.refresh();
                }]
            }
        })
          .state('flux.new', {
            url: '/Ajout',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/parametrage/flux/flux-dialog.html',
                    controller: 'FluxDialogController',
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
                    $state.go('flux', null, { reload: true });
                }, function() {
                    $state.go('flux');
                });
            }]
        })
    }
})();

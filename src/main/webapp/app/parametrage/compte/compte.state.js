(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('compteTresorerie', {
            parent: 'app',
            url: '/compte',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                	templateUrl:'app/parametrage/compte/compte.html',
        	    	   controller :'CompteController',
       	    	    controllerAs: 'ctrl'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    return $translate.refresh();
                }]
            }
        })
        .state('compteTresorerie.new', {
            url: '/Ajout',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/parametrage/compte/compte-dialog.html',
                    controller: 'CompteDialogController',
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
                    $state.go('compteTresorerie', null, { reload: true });
                }, function() {
                    $state.go('compteTresorerie');
                });
            }]
        })
    }
    
})();

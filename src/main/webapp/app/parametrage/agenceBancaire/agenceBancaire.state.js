(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('agenceBancaire', {
            parent: 'app',
            url: '/agenceBancaire',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                	templateUrl:'app/parametrage/agenceBancaire/agenceBancaire.html',
        	    	   controller :'AgenceBancaireController',
       	    	    controllerAs: 'ctrl'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    return $translate.refresh();
                }]
            }
        })
        
         .state('agenceBancaire.new', {
            url: '/Ajout',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/parametrage/agenceBancaire/agenceBancaire-dialog.html',
                    controller: 'AgenceBancaireDialogController',
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
                    $state.go('agenceBancaire', null, { reload: true });
                }, function() {
                    $state.go('agenceBancaire');
                });
            }]
        })
    }
})();

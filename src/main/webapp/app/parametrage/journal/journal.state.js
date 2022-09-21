(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('journal', {
            parent: 'app',
            url: '/journal',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                	templateUrl:'app/parametrage/journal/journal.html',
     	    	   controller :'JournalController',
     	    	    controllerAs: 'ctrl'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    return $translate.refresh();
                }]
            }
        })
             .state('journal.new', {
            url: '/Ajout',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/parametrage/journal/journal-dialog.html',
                    controller: 'JournalDialogController',
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
                    $state.go('journal', null, { reload: true });
                }, function() {
                    $state.go('journal');
                });
            }]
        })
         .state('journal.delete', {
            url: '/Delete',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/parametrage/journal/journal-delete-dialog.html',
                    controller: 'JournalDeleteController',
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
                    $state.go('journal', null, { reload: true });
                }, function() {
                    $state.go('journal');
                });
            }]
        })
    }
})();

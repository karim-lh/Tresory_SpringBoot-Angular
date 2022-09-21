(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('dashbord', {
            parent: 'app',
            url: '/dashbord',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/dashbord/dashbord.html',
                    controller: 'DashbordController',
                    controllerAs: 'ctrl'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('home');
                    return $translate.refresh();
                }]
            }
        });
    }
})();

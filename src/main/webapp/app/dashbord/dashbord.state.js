					
						
(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        
        .state('dashboard', {
            parent: 'app',
            url: '/dashboard',
            data: {
                authorities: []
            },
            views: {
                'content@': {
					templateUrl : 'app/dashbord/dashbord.html',
					controller : 'DashbordController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('home');
                    return $translate.refresh();
                }]
            }
        })
        
        
        
     
				.state(

						'dashbord.detail',
						{
							parent : 'dashbord',
							url : 'detail/{id}',
							onEnter : [
									'$stateParams',
									'$state',
									'$uibModal',
									function($stateParams, $state, $uibModal) {
										$uibModal
												.open({
													animation : true,
													ariaLabelledBy : 'modal-title',
													ariaDescribedBy : 'modal-body',
													templateUrl : 'app/dashbord/dashbordDetail.html',
													controller : 'DashbordDetailController',
													controllerAs : 'ctrl',
													size : 'lg',
													resolve : {
														entity : [
																'Notification',
																function(
																		Notification) {
																	return Notification
																			.get({
																				id : $stateParams.id
																			}).$promise;
																} ]
													}
												}).result.then(function() {
											$state.go('dashbord', null, {
												reload : true
											});
										}, function() {
											$state.go('dashbord');
										});
									} ]
						})

				.state(
						'dashbord.history',
						{
							parent : 'dashbord',
							url : 'task/{id}',
							onEnter : [
									'$stateParams',
									'$state',
									'$uibModal',
									function($stateParams, $state, $uibModal) {
										$uibModal
												.open({
													animation : true,
													ariaLabelledBy : 'modal-title',
													ariaDescribedBy : 'modal-body',
													templateUrl : 'app/dashbord/taskHistory.html',
													controller : 'TaskHistoryController',
													controllerAs : 'ctrl',
													size : 'lg',
													resolve : {
														entity : [
																'$stateParams',
																function(
																		$stateParams) {
																	return $stateParams.id;
																} ]

													}
												}).result.then(function() {

											$state.go('dashbord');
										});
									} ]
						})   
        
        
        
        
        
        
    }
})();
						
						
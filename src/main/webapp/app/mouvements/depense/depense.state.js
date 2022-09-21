//
//(function() {
//    'use strict';
//
//    angular
//        .module('tresorerieApp')
//        .config(stateConfig);
//
//    stateConfig.$inject = ['$stateProvider'];
//
//    function stateConfig($stateProvider) {
//  $stateProvider
//  .state('depense', {
//    url: '/mouvements/depense',
//   
//       views:
//    	   {
//    	       'content@':{
//    	    	   
//    	    	   templateUrl:'app/mouvements/depense/depense.html'
//   	    	  /* controller :'FamilleController',
//  	    	    controllerAs: 'ctrl'*/
//    	       },
//             
//              'progress':
//            	  {
//            	     templateUrl :'app/mouvements/depense/depenseProgress.html'
//    	   
//    	   }
// 
//}
//})
//
//}});

(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        
        .state('depense', {
            parent: 'app',
            url: '/depense',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/mouvements/depense/depense.html',
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

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
//  .state('mouvementTresorerie', {
//    url: '/les-mouvements',
//    
//       views:
//    	   {
//    	       'content@':{
//    	    	   
//    	    	   templateUrl:'app/mouvements/mouvementTresorerie.html',
//    	    	   controller :'MouvementController',
//    	    	    controllerAs: 'ctrl'
//    	       },
//             
//              'progress':
//            	  {
//            	     template :'<div class="container"> <div class="row"><div class="col-lg-10"><h3 class="page-header"><i class="fa fa-files-o"></i> Les mouvements</h3><ol class="breadcrumb"><li><i class="fa fa-home"></i><a ui-sref="/"></a></li><li><i class="icon_document_alt"></i>mouvements</li><li><i class="fa fa-files-o"></i></li></ol></div></div></div>'
//            	  }
//    	   
//    	   }
//  })
// 
//  
//  
//}});

(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('mouvementTresorerie', {
            parent: 'app',
            url: '/les-mouvements',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/mouvements/mouvementTresorerie.html',
                    controller: 'MouvementController',
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


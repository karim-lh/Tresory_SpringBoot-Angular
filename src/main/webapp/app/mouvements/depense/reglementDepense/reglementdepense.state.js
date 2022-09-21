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
//  .state('depense.reglementDepense', {
//    url: '/reglement-depense',
//   
//       views:
//    	   {
//    	       'contentMvtDepense':{
//    	    	 
//   	    	   templateUrl:'app/mouvements/depense/reglementDepense/ReglementDepense.html',
//    	     controller :'ReglementDepenseController',
// 	    	    controllerAs: 'ctrl'
//    	       }
////  	    	    	,
////             
////              'progress':
////            	  {
////            	     templateUrl :'app/reglements/depense/reglementDepense/progress.html'
////    	   
////    	   }
// 
//
//    	   
//    	   }
//})
//
//.state('depense.reglementDepense.new', {
//    parent: 'depense.reglementDepense',
//     url: '/new',
//     data: {
//         authorities: ['WF_EMPLOYE']
//     },
//     onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
//         $uibModal.open({
//             templateUrl: 'app/mouvements/depense/reglementDepense/reglementDepense-dialog.html',
//             controller: 'ReglementDepenseDialogController',
//             controllerAs: 'ctrl',
//             backdrop: 'static',
//             size: 'xs',
//             resolve: {
//                 entity: function () {
//                     return {
//                     
////                     	idAgence:null,
////                     	
////                     libelleAgenceBancaire:null,
////                     	
////                      numTel:null,
////                     siege :null,
////                      emailContact:null    
////                     
//                     };
//                 }
//             }
//         }).result.then(function() {
//             $state.go('depense.reglementDepense', null, { reload: 'depense.reglementDepense' });
//         }, function() {
//             $state.go('depense.reglementDepense');
//         });
//     }]
// })
//
//    
//
//  }});
(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        
        .state('depense.reglementDepense', {
            parent: 'depense',
            url: '/contentMvtDepense',
            data: {
                authorities: []
            },
            views: {
                'contentMvtDepense': {
                    templateUrl: 'app/mouvements/depense/reglementDepense/ReglementDepense.html',
                    controller: 'ReglementDepenseController',
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
        
        
        
                
        .state('depense.reglementDepense.new', {
            parent: 'depense.reglementDepense',
            url: '/new',
            data: {
                authorities: []
            },
          onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
          $uibModal.open({
              templateUrl: 'app/mouvements/depense/reglementDepense/reglementDepense-dialog.html',
              controller: 'ReglementDialogController',
              controllerAs: 'ctrl',
              backdrop: 'static',
              size: 'lg',
              resolve: {
                  entity: function () {
                      return {
                          
//                    		idAgence:null,
//                     	
//                     libelleAgenceBancaire:null,
//                     	
//                      numTel:null,
//                     siege :null,
//                      emailContact:null    
//                      	
                      };
                  },
          
          
          
              }
          }).result.then(function() {
              $state.go('depense.reglementDepense', null, { reload: 'depense.reglementDepense' });
          }, function() {
              $state.go('depense.reglementDepense');
          });
      }]
        })
    }
})();
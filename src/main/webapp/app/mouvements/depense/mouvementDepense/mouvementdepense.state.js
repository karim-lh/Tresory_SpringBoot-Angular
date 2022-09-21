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
//    return {
//        require: 'ngModel',
//        restrict: 'A',
//        link: function(scope, el, attrs, ngModel) {
//            var model = $parse(attrs.ngModel);
//            var modelSetter = model.assign;
//            var maxSize = 1048576000; //2000 B
//            el.bind('change', function() {
//
//                scope.$apply(function() {
//                 
//                    if (el[0].files.length > 1) {
//                        modelSetter(scope, el[0].files);
//                    } else {
//                        modelSetter(scope, el[0].files[0]);
//                    }
//                    var fileSize = el[0].files[0].size;
//                    if (fileSize > maxSize) {
//                       console.log("taille depassé");
//                    }
//                });
//            });
//        }
//    }
//
//    }});
//
//
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
//    return {
//        restrict: 'A',
//        link: function(scope, element, attrs) {
//            var model = $parse(attrs.fileModel);
//            var modelSetter = model.assign;
//           
//            element.bind('change', function(){
//                scope.$apply(function(){
//                    modelSetter(scope, element[0].files[0]);
//                });
//            });
//        }
//    };
//
//    }});
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
//  .state('depense.mouvementDepense', {
//   
//       views:
//    	   {
//    	       'contentMvtDepense':{
//    	    	   
//    	    	   templateUrl:'app/mouvements/depense/mouvementDepense/mouvementDepense.html',
//   	    	  controller :'MouvementDepenseController',
//  	    	    controllerAs: 'ctrl'
//    	       }
//  	    	    	,
//             
//              'progress':
//            	  {
//            	     templateUrl :'app/mouvements/depense/mouvementDepense/progress.html'
//    	   
//    	   }
// 
//}
//})
//
//
//     .state('depense.mouvementDepense.new', {
//           parent: 'depense.mouvementDepense',
//            url: '/new',
//            data: {
//                authorities: ['WF_EMPLOYE']
//            },
//            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
//                $uibModal.open({
//                    templateUrl: 'app/mouvements/depense/mouvementDepense/mouvementDepense-dialog.html',
//                    controller: 'MouvementDepenseDialogController',
//                    controllerAs: 'ctrl',
//                    backdrop: 'static',
//                    size: 'lg',
//                    resolve: {
//                        entity: function () {
//                            return {
//                                
//                            	idMouvement: null,
//                            	  numMouvement: null,
//                            	  dateMouvement: null,
//                            	  montantHT: null,
//                            	  montantTaxe :null,
//                            	  tauxChangeMouvement:null,
//                            	  objetMouvement: null,
//                            	  libelleMouvement: null,
//                            	  typeMouvement: null,
//                            	  compteTresorerie: null,
//                            	  demandeur: null,
//                            	  sold:null,
//                            	  devise: null,
//                            	  fluxTresorerie: null,
//                            	  tiers: null,
//                            	  user: null,
//                            	
//                            	
//                            };
//                        },
//                
//                entity1: function () {
//                    return {
//                        
//                    	idDemande:null,
//                    	dateCreation:null,
//                    dateSignature:null,
//                    typeDemande:null,
//                    initiateur:null,
//                    singnataire:null,
//                    statut:null,
//                    decision:null,
//                    decideur:null,
//                    observation:null,
//                    mouvement:null
//                    };
//                }
//                    }
//                }).result.then(function() {
//                    $state.go('depense.mouvementDepense', null, { reload: 'depense.mouvementDepense' });
//                }, function() {
//                    $state.go('depense.mouvementDepense');
//                });
//            }]
//        })
//        
//      .state('depense.mouvementDepense.detail', {
//          
//            url: '/{id}',
//            parent: 'depense.mouvementDepense',
//            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
//                $uibModal.open({
//                    templateUrl: 'app/mouvements/depense/mouvementDepense/depenseDetail.html',
//                    controller: 'DepenseDetailController',
//                    controllerAs: 'ctrl',
//                    backdrop: 'static',
//                    size: 'lg'
//                    	,
//                    resolve:  {entity: ['Mouvement', function(Mouvement) {
//                        return Mouvement.get({id : $stateParams.id}).$promise;
//                    }]
//                }
//            })
//            
//           
//        }]
//    })  
//    
//
//
//    }});



(function() {
    'use strict';

    angular
        .module('tresorerieApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        
        .state('depense.mouvementDepense', {
            parent: 'depense',
            url: '/contentDepense',
            data: {
                authorities: []
            },
            views: {
                'contentMvtDepense': {
                    templateUrl: 'app/mouvements/depense/mouvementDepense/mouvementDepense.html',
                    controller: 'MouvementDepenseController',
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
        
        
        
                
        .state('depense.mouvementDepense.new', {
            parent: 'depense.mouvementDepense',
            url: '/new',
            data: {
                authorities: []
            },
          onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
          $uibModal.open({
              templateUrl: 'app/mouvements/depense/mouvementDepense/mouvementDepense-dialog.html',
              controller: 'MouvementDepenseDialogController',
              controllerAs: 'ctrl',
              backdrop: 'static',
              size: 'lg',
              resolve: {
                  entity: function () {
                      return {
                          
                      	idMouvement: null,
                      	  numMouvement: null,
                      	  dateMouvement: null,
                      	  montantHT: null,
                      	  montantTaxe :null,
                      	  tauxChangeMouvement:null,
                      	  objetMouvement: null,
                      	  libelleMouvement: null,
                      	  typeMouvement: null,
                      	  compteTresorerie: null,
                      	  demandeur: null,
                      	  sold:null,
                      	  devise: null,
                      	  fluxTresorerie: null,
                      	  tiers: null,
                      	  user: null,
                      	
                      	
                      };
                  },
          
          entity1: function () {
              return {
                  
              	idDemande:null,
              	dateCreation:null,
              dateSignature:null,
              typeDemande:null,
              initiateur:null,
              singnataire:null,
              statut:null,
              decision:null,
              decideur:null,
              observation:null,
              mouvement:null
              };
          }
              }
          }).result.then(function() {
              $state.go('depense.mouvementDepense', null, { reload: 'depense.mouvementDepense' });
          }, function() {
              $state.go('depense.mouvementDepense');
          });
      }]
        })
    }
})();

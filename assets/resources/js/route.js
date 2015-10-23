(function(){

	function config($stateProvider, $urlRouterProvider) {
	    $urlRouterProvider.otherwise("/product/info");
	    $stateProvider
	        .state('product', {
	            abstract: true,
	            url: "/product",
	            templateUrl: "/view/common/content.html"

	        })
			.state('product.info',{
				url:"/info",
				templateUrl:"/view/product/info.html",
				controller:"productCtrl as vm"
			})
            .state('product.material',{
                url:"/material",
                templateUrl:"/view/material/material.html",
                controller:"materialCtrl as vm"
            })
            .state('goods', {
                abstract: true,
                url: "/goods"
            })
            .state('goods.manage',{
                url:"/manage",
                templateUrl:"/view/goods/goodManage.html",
                controller:"goodsCtrl as vm"
            })

            
    }
	
	
	angular
	.module('zhilu')
	.config(config)
	.run(function($rootScope, $state) {
		$rootScope.$state = $state;
	});
})();

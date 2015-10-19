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
            .state('user', {
                abstract: true,
                url: "/user",
                templateUrl: "/view/user/user.html",
                controller: 'UserCtrl as vm'
            })


            
    }
	
	
	angular
	.module('zhilu')
	.config(config)
	.run(function($rootScope, $state) {
		$rootScope.$state = $state;
	});
})();

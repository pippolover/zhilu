	function productInfoService($http){
	    return {
			queryProductInfo:function(productId,callback){
				var uri = '/webapi/product/'+productId;
				$http.get(uri).success(function(data){
					callback(data.result);
				})
			}
	        
	    };
	}

	





	angular
    .module('zhilu')
    .factory('productInfoService', productInfoService)



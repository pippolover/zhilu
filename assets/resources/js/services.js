	function productInfoService($http,$modal){
	    return {
			queryProductInfo:function(productId,callback){
				var uri = '/webapi/product/'+productId;
				$http.get(uri).success(function(data){
					callback(data.result);
				})
			},

            queryAllProductInfo:function(callback){
                var uri = '/webapi/product/all';
                $http.get(uri).success(function(data){
                    callback(data.result);
                })
            },

            addProductInfo:function(productInfo,$modal){
                $http({
                    url:'/webapi/product/',
                    method :'POST',
                    data:JSON.stringify({
                        batch:productInfo.batch,
                        color:productInfo.color,
                        orderNum: productInfo.orderNum,
                        season: productInfo.season,
                        price: productInfo.price,
                        category:productInfo.category
                    }),
                    headers: {'Content-Type': 'application/json'}
                }).success(function(data, status, headers, config){
                    console.log("add product info success");
                    $modal.close('success');
                }).error(function(data, status, headers, config){
                    console.log("add product info fails");
                });
            }
	        
	    };
	}

	





	angular
    .module('zhilu')
    .factory('productInfoService', productInfoService)



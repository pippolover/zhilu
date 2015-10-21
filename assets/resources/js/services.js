	function productInfoService($http,$modal){
	    return {
			queryProductInfo:function(productId,callback){
				var uri = '/webapi/product/'+productId;
				$http.get(uri).success(function(data){
					callback(data.result);
				})
			},
            fuzzyQueryProductInfo:function(productId,callback){
                var uri = '/webapi/product/fuzzy?query='+productId;
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

            checkMaterialValid:function(ids,callback){
                var uri = '/webapi/material/isValid?idString='+ids;
                $http.get(uri).success(function(data){
                    callback(data);
                })
            },

            checkAccessoryValid:function(ids,callback){
                var uri = '/webapi/accessory/isValid?idString='+ids;
                $http.get(uri).success(function(data){
                    callback(data);
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
                        category:productInfo.category,
                        accessorys:productInfo.accessorys,
                        materials:productInfo.materials
                    }),
                    headers: {'Content-Type': 'application/json'}
                }).success(function(data, status, headers, config){
                    console.log("add product info success");
                    $modal.close('success');
                }).error(function(data, status, headers, config){
                    console.log("add product info fails");
                });
            },

            addAccessoryInfo:function(accessory,$modal){
                $http({
                    url:'/webapi/accessory',
                    method :'POST',
                    data:JSON.stringify({
                        uniqueId:accessory.uniqueId,
                        type:accessory.type,
                        specs:accessory.specs,
                        num: accessory.num,
                        component: accessory.component,
                        price: accessory.price,
                        factory:accessory.factory
                    }),
                    headers: {'Content-Type': 'application/json'}
                }).success(function(data, status, headers, config){
                    console.log("add accessory info success");
                    $modal.close('success');
                }).error(function(data, status, headers, config){
                    console.log("add accessory info fails");
                });
            },

            addMaterialInfo:function(material,$modal){
                $http({
                    url:'/webapi/material',
                    method :'POST',
                    data:JSON.stringify({
                        uniqueId:material.uniqueId,
                        type:material.type,
                        width:material.width,
                        num: material.num,
                        component: material.component,
                        price: material.price,
                        factory:material.factory
                    }),
                    headers: {'Content-Type': 'application/json'}
                }).success(function(data, status, headers, config){
                    console.log("add material info success");
                    $modal.close('success');
                }).error(function(data, status, headers, config){
                    console.log("add material info fails");
                });
            }
	        
	    };
	}

	





	angular
    .module('zhilu')
    .factory('productInfoService', productInfoService)



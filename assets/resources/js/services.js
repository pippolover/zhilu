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
            },

            //添加vender
            addVender:function(vender,$modal){
                $http({
                    url:'/webapi/vendor',
                    method:'POST',
                    data:JSON.stringify({
                        district:vender.district,
                        contacter:vender.contacter,
                        mobile:vender.mobile,
                        address:vender.address
                    }),
                    headers: {'Content-Type': 'application/json'}
                }).success(function(data, status, headers, config){
                    console.log("add vender info success");
                    $modal.close('success');
                }).error(function(data, status, headers, config){
                    console.log("add vender info fails");
                })
            },


            //update vender
            updateVender:function(vender,$modal){
                $http({
                    url:'/webapi/vendor',
                    method:'PUT',
                    data:JSON.stringify({
                        id:vender.id,
                        district:vender.district,
                        contacter:vender.contacter,
                        mobile:vender.mobile,
                        address:vender.address
                    }),
                    headers: {'Content-Type': 'application/json'}
                }).success(function(data, status, headers, config){
                    console.log("update vender info success");
                    $modal.close('success');
                }).error(function(data, status, headers, config){
                    console.log("update vender info fails");
                })
            },


            getVendorAll:function(callback){
                var uri = '/webapi/vendor/all';
                $http.get(uri).success(function(data){
                    callback(data);
                })
            },

            addOrder:function(order,$modal){
                $http({
                    url:'/webapi/order',
                    method:'POST',
                    data:JSON.stringify({
                        vendorId:order.vendor.id,
                        productId:order.product.id,
                        num:order.num
                    }),
                    headers: {'Content-Type': 'application/json'}
                }).success(function(data, status, headers, config){
                    console.log("add order info success");
                    $modal.close('success');
                }).error(function(data, status, headers, config){
                    console.log("add order info fails");
                })
            },

            getOrderByProduct:function(callback){
                var uri = "/webapi/order/all";
                $http.get(uri).success(function(data){
                    callback(data.result);
                })
            },

            //获得指定款式的订单详情
            getOrderByProductDetail:function(productId,callback){
                var uri = "/webapi/order?productId="+productId;
                $http.get(uri).success(function(data){
                    callback(data.result);
                })
            },

            //获得指定款式的订单流水
            getOrderTransactionByProduct:function(productId,callback){
                var uri = "/webapi/order/transaction?productId="+productId;
                $http.get(uri).success(function(data){
                    callback(data.result);
                })
            }


	    };
	}


	angular
    .module('zhilu')
    .factory('productInfoService', productInfoService);



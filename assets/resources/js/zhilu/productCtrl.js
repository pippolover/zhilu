function productCtrl($scope, $http, $location, $document, $window,$modal,$timeout,$stateParams,$state,productInfoService) {
    $scope.queryProduct = queryProduct;

    $scope.add = 0;
    var vm = this;

    function queryProduct(productId){

        productInfoService.queryProductInfo(productId,function(res){
            $scope.product = {};
            vm.add = 1;
            $scope.product.id = productId;
            $scope.product.batch = res.batch;
            $scope.product.color = res.color;
            $scope.product.sequence = res.sequence;
            $scope.product.season = res.season;
            $scope.product.orderNum = res.orderNum;
            $scope.productNum = res.orderNum;
            console.log('product', $scope.product);
        })
    }
}

angular
    .module('zhilu')
    .controller('productCtrl', productCtrl);

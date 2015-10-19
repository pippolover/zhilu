function productCtrl($scope, $http, $location, $document, $window,$modal,$timeout,$stateParams,$state,productInfoService) {
    $scope.queryProduct = queryProduct;
    $scope.showAddProduct = showAddProduct;
    $scope.add = 0;
    var vm = this;


    console.log("query all product");
    queryAllProduct();


    function queryProduct(productId) {

        productInfoService.queryProductInfo(productId, function (res) {
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

    function queryAllProduct(){
        productInfoService.queryAllProductInfo(function(res){
            $scope.productList = res;
        })
    }

    function showAddProduct() {
        var modalInstance = $modal.open({
            templateUrl: 'product/partials/product.add.tpl.html',
            scope: $scope,
            controller: 'ModalInstanceCtrl',
            size: "lg"
        });
    }

    // table control

}

function ModalInstanceCtrl($scope, $modalInstance,productInfoService) {
    $scope.addProductInfo = addProductInfo;

    function addProductInfo(){
        console.log($scope.product);
        productInfoService.addProductInfo($scope.product, $modalInstance);
    }

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}


angular
    .module('zhilu')
    .controller('productCtrl', productCtrl)
    .controller('ModalInstanceCtrl', ModalInstanceCtrl);

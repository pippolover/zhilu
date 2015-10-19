function productCtrl($scope, $http, $location, $document, $window,$modal,$timeout,$stateParams,$state,productInfoService) {
    $scope.queryProduct = queryProduct;
    $scope.showAddProduct = showAddProduct;
    $scope.add = 0;
    var vm = this;

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

    function showAddProduct() {
        var modalInstance = $modal.open({
            templateUrl: 'product/partials/product.add.tpl.html',
            scope: $scope,
            controller: 'ModalInstanceCtrl',
            size: "lg"
        });
    }
}

function ModalInstanceCtrl($scope, $modalInstance) {
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}


angular
    .module('zhilu')
    .controller('productCtrl', productCtrl)
    .controller('ModalInstanceCtrl', ModalInstanceCtrl);

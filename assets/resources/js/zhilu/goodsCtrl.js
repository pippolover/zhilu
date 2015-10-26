function goodsCtrl($scope, $http, $location, $document, $window,$modal,$timeout,$stateParams,$state,productInfoService) {
    var vm = this;
    $scope.showAddVender = showAddVender;
    $scope.showAddOrder = showAddOrder;
    $scope.getDetail = showOrderDetail;
    $scope.queryOrderList=  queryOrderList;

    function showAddVender(isUpdate){
        $scope.vender = {};
        //如果是update，提前获取数据

        var materialModal = $modal.open({
            templateUrl:'goods/partials/vender.tpl.html',
            scope:$scope,
            controller:'VenderInstanceCtrl',
            size:'lg'
        })
    }

    //添加订单
    function showAddOrder(){
        productInfoService.getVendorAll(function(res){
            $scope.vendorList = res.result;
        });
        productInfoService.queryAllProductInfo(function(res){
            $scope.productList = res;
        });
        $scope.order = {};
        var orderModal = $modal.open({
            templateUrl:'goods/partials/order.tpl.html',
            scope:$scope,
            controller:'orderInstanceCtrl',
            size:'lg'
        })
    }

    //查看指定款式的订单详情
    function showOrderDetail(productId){
        productInfoService.getOrderByProductDetail(productId,function(res){
            $scope.orderListByVendor = res;
        });
        $scope.currentProductId = productId;

        //获取订单流水
        productInfoService.getOrderTransactionByProduct(productId,function(res){
            $scope.orderTransactionList = res;
        });
        var orderDetailModal = $modal.open({
            templateUrl:'goods/partials/order.detail.html',
            scope:$scope,
            controller:'orderInstanceCtrl',
            size:'lg'
        })
    }

    function queryOrderList(){
        productInfoService.getOrderByProduct(function(res){
            $scope.orderList = res;
        })
    }
    queryOrderList();


}

function VenderInstanceCtrl($scope, $modalInstance,productInfoService) {
    $scope.addVender = addVender;
    function addVender(){
        productInfoService.addVender($scope.vender,$modalInstance)
    }

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}

function orderInstanceCtrl($scope, $modalInstance,productInfoService) {
    $scope.addOrder = addOrder;
    function addOrder() {
        productInfoService.addOrder($scope.order, $modalInstance);
        $scope.queryOrderList();
    }



    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}


angular
    .module('zhilu')
    .controller('goodsCtrl', goodsCtrl)
    .controller('VenderInstanceCtrl',VenderInstanceCtrl)
    .controller('orderInstanceCtrl',orderInstanceCtrl);
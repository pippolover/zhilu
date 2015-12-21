/**货品管理controller，对应goodManage.html **/
function goodsCtrl($scope, $http, $location, $document, $window,$modal,$timeout,$stateParams,$state,productInfoService) {
    var vm = this;
    $scope.showAddVender = showAddVender;
    $scope.showAddOrder = showAddOrder;
    $scope.showUpdateVender = showUpdateVender;
    $scope.getDetail = showOrderDetail;
    $scope.queryOrderList=  queryOrderList;
    $scope.getAlreadyProduction = getAlreadyProduction;

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

    //获取指定款式已生产的数量
    function getAlreadyProduction(productId){
      productInfoService.getProductionNumByProduct(productId,function(res){
        $scope.alreadyProduction = res;
      });
    }

    function getAlreadyDelivery(productId){
        productInfoService.getDeliveryNumByProduct(productId,function(res){
            $scope.alreadyDelivery = res;
        })
    }

    //查看指定款式的订单详情
    function showOrderDetail(productId,productNum){
        productInfoService.getOrderByProductDetail(productId,function(res){
            $scope.orderListByVendor = res;
        });
        $scope.currentProductId = productId;
        //总的订单量
        $scope.currentProductTotalNum = productNum;
        $scope.availNum = productNum - $scope.alreadyProduction;

        //获取款式的已生产数量
        getAlreadyProduction(productId);
        //获取已出库的数量
        getAlreadyDelivery(productId);
        //获取订单流水
        productInfoService.getOrderTransactionByProduct(productId,function(res){
            $scope.orderTransactionList = res;
        });
        var orderDetailModal = $modal.open({
            templateUrl:'goods/partials/order.detail.html',
            scope:$scope,
            controller:'orderInstanceCtrl',
            windowClass: 'large-modal-window'
        })
    }

    function queryOrderList(){
        productInfoService.getOrderByProduct(function(res){
            $scope.orderList = res;
        })
    }
    queryOrderList();

    //显示订货商列表
    function showUpdateVender(){
      productInfoService.getVendorAll(function(res){
        $scope.venderList = res.result;
      });

      $scope.disableEditVender = "disabled";
      $scope.editMode = false;
      var venderListModal = $modal.open({
        templateUrl:'goods/partials/vender.list.tpl.html',
        scope:$scope,
        controller:'VenderInstanceCtrl',
        windowClass: 'large-modal-window'
        // size:'lg'
      })
    }


}

/**vender创建和修改的的 ctrl **/
function VenderInstanceCtrl($scope, $modalInstance,productInfoService) {
    $scope.addVender = addVender;
    $scope.enterEditMode = enterEditMode;
    $scope.updateVender = updateVender;
    function addVender(){
        productInfoService.addVender($scope.vender,$modalInstance)
    }

    function enterEditMode(){
      $scope.disableEditVender = "";
      $scope.editMode = true;
    }
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    function updateVender(vender){
      console.log(vender);
      productInfoService.updateVender(vender,$modalInstance);
      $scope.editMode = false;
    }
}

/** 订单创建和修改的ctrl **/
function orderInstanceCtrl($scope,$modal,$state, $modalInstance,productInfoService) {
    $scope.addOrder = addOrder;
    $scope.showdeliveryModal = showdeliveryModal;
    $scope.addDeliveryInfo = addDeliveryInfo;
    $scope.showAddProduction = showAddProduction;
    $scope.addProduction = addProduction;
    $scope.deliveryInfo;
    function addOrder() {
        productInfoService.addOrder($scope.order, $modalInstance);
        $scope.queryOrderList();
    }

    function showdeliveryModal(order){
      var order = order;
      var venderListModal = $modal.open({
          templateUrl:'goods/partials/Delivery.tpl.html',
          scope:$scope,
          controller:'orderInstanceCtrl',
          windowClass: 'large-modal-window',
          resolve:{
              deliveryInfo:function(){
                  deliveryInfo = {};
                  deliveryInfo.productId = $scope.currentProductId;
                  deliveryInfo.venderId = order.vendor.id;
                  deliveryInfo.venderDistrict = order.vendor.district;
                  $scope.deliveryInfo = deliveryInfo;
                  return deliveryInfo;
              }
          }
      })
    }

    //增加发货信息
    function addDeliveryInfo(deliveryInfo){
        productInfoService.addDeliveryInfo(deliveryInfo,$modalInstance);
        $state.reload();
    }


    //增加入库信息
    function showAddProduction (){
      var venderListModal = $modal.open({
        templateUrl : 'goods/partials/production.add.tpl.html',
        scope : $scope,
        controller : 'orderInstanceCtrl',
        size: 'lg'
      })
    }

    // 入库操作
    function addProduction(production){
        console.log($scope.production);
      production.productId = $scope.currentProductId;
      productInfoService.addProduction(production,$modalInstance);
      $scope.getAlreadyProduction($scope.currentProductId);
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

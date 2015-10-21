function productCtrl($scope, $http, $location, $document, $window,$modal,$timeout,$stateParams,$state,productInfoService) {
    var vm = this;
    $scope.getProduct = getProduct;
    $scope.showAddProduct = showAddProduct;
    $scope.showAddAccessory = showAddAccessary;
    $scope.showAddMaterial = showAddMaterial;
    $scope.fuzzyQuery = fuzzyQuery;
    $scope.add = 0;



    console.log("query all product");
    queryAllProduct();


    function getProduct(productId) {

        productInfoService.queryProductInfo(productId, function (res) {
            $scope.product = {};
            vm.add = 1;
            $scope.product = res;
            showProductInfo();
            console.log('product', $scope.product);
        })
    }

    function queryAllProduct(){
        productInfoService.queryAllProductInfo(function(res){
            $scope.productList = res;
        })
    }

    //模糊查询
    function fuzzyQuery(query){
        productInfoService.fuzzyQueryProductInfo(query,function(res){
            $scope.productList = res;
        })

    }

    function showProductInfo(){
        var productInfoModal = $modal.open({
            templateUrl:'product/partials/product.info.tpl.html',
            scope:$scope,
            controller:'ModalInstanceCtrl',
            size:'lg'
        })
    }

    function showAddAccessary(){
        var accessaryModal = $modal.open({
            templateUrl:'product/partials/accessory.add.tpl.html',
            scope:$scope,
            controller:'AccessaryModalInstanceCtrl',
            size:'lg'
        })
    }

    function showAddMaterial(){
        var materialModal = $modal.open({
            templateUrl:'product/partials/material.add.tpl.html',
            scope:$scope,
            controller:'MaterialInstanceCtrl',
            size:'lg'
        })
    }

    function showAddProduct() {
        var modalInstance = $modal.open({
            templateUrl: 'product/partials/product.add.tpl.html',
            scope: $scope,
            controller: 'ModalInstanceCtrl',
            size: 'lg'
        });
    }

    // table control

}
//款式基础信息 modal controller
function ModalInstanceCtrl($scope, $modalInstance,productInfoService) {
    $scope.addProductInfo = addProductInfo;
    $scope.checkAccessoryValid = checkAccessoryValid;
    $scope.checkMaterialValid = checkMaterialValid;
    $scope.materialerrorMsg = null;
    $scope.accessoryerrorMsg = null;

    function addProductInfo(){
        console.log($scope.product);
        productInfoService.addProductInfo($scope.product, $modalInstance);
    }

    function checkAccessoryValid(){
        productInfoService.checkAccessoryValid($scope.product.accessorys,function(res){
            $scope.accessoryerrorMsg = null;
            if(!res.success){
                $scope.accessoryerrorMsg = res.errorMessage;
            }
        });
    }

    function checkMaterialValid(){
        productInfoService.checkMaterialValid($scope.product.materials,function(res){
            $scope.materialerrorMsg = null;
            if(!res.success){
                $scope.materialerrorMsg = res.errorMessage;
            }
        });
    }

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}

//面料 controller
function MaterialInstanceCtrl($scope, $modalInstance,productInfoService) {
    $scope.addMaterialInfo = addMaterial;

    function addMaterial(){
        console.log($scope.material);
        productInfoService.addMaterialInfo($scope.material, $modalInstance);
    }

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}

//辅料 controller
function AccessaryModalInstanceCtrl($scope, $modalInstance,productInfoService) {
    $scope.addAccessoryInfo = addAccessoryInfo;

    function addAccessoryInfo(){
        console.log($scope.accessory);
        productInfoService.addAccessoryInfo($scope.accessory, $modalInstance);
    }

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}




angular
    .module('zhilu')
    .controller('productCtrl', productCtrl)
    .controller('ModalInstanceCtrl', ModalInstanceCtrl)
    .controller('AccessaryModalInstanceCtrl', AccessaryModalInstanceCtrl)
    .controller('MaterialInstanceCtrl', MaterialInstanceCtrl);

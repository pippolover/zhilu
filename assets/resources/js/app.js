
(function () {
    angular.module('zhilu', [
        'ui.router',                    // Routing
        'ui.bootstrap',                 // Bootstrap
        'ui.checkbox',                  // Custom checkbox
        'codemwnci.markdown-edit-preview',
        'angularFileUpload',
        'ui.select',// ui-select
        "ngSanitize",
        "com.2fdevs.videogular",
        "com.2fdevs.videogular.plugins.controls",
        "com.2fdevs.videogular.plugins.overlayplay",
        "com.2fdevs.videogular.plugins.poster"
    ])
    .run(function($http, $rootScope,$location){
        
        var url=$location.$$absUrl;

    });
})();
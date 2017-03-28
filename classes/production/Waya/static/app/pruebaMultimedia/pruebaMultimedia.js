'use strict';

angular.module('myApp.pruebaMultimedia', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/pruebaMultimedia', {
    templateUrl: 'pruebaMultimedia/pruebaMultimedia.html',
    controller: 'pruebaMultimediaCtrl'
  });
}])

.controller('pruebaMultimediaCtrl', ['$scope', 'fileUpload',function($scope,fileUpload) {
        $scope.file = "";
        $scope.agregar = function() {
            var file = $scope.myFile;
            console.log(file);
            var uploadUrl = 'http://localhost:8080/multimedia/1';
            fileUpload.uploadFileToUrl(file, uploadUrl);
        };
}])
.directive('fileModel', ['$parse', function ($parse) {
     return {
         restrict: 'A',
         link: function(scope, element, attrs) {
             var model = $parse(attrs.fileModel);
             var modelSetter = model.assign;

             element.bind('change', function(){
                 scope.$apply(function(){
                     modelSetter(scope, element[0].files[0]);
                 });
             });
         }
     };
 }]);;
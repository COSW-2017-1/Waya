'use strict';

angular.module('myApp.ingreso', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ingreso', {
    templateUrl: 'ingreso/ingreso.html',
    controller: 'IngresoCtrl'
  });
}])

.controller('IngresoCtrl', ['$scope', 'fabrica', function($scope, fabrica) {
        $scope.listado= fabrica.getListado();
        $scope.propertyName = 'cover';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };




}]);
'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registro', {
    templateUrl: 'registro/registro.html',
    controller: 'RegistroCtrl'
  });
}])

.controller('RegistroCtrl', ['$scope', 'fabrica', function($scope, fabrica) {
        $scope.listado= fabrica.getListado();
        $scope.propertyName = 'cover';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };




}]);
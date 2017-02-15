'use strict';

angular.module('myApp.ingresarBar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ingresarBar', {
    templateUrl: 'ingresarBar/ingresarBar.html',
    controller: 'IngresarBarCtrl'
  });
}])

.controller('IngresarBarCtrl', ['$scope', 'fabrica', function ($scope, fabrica)  {
      $scope.add=function(){
        var bar={"nombre":$scope.nombre,"direccion":$scope.direccion,"telefono":$scope.telefono,"cover":$scope.cover};
        fabrica.addTodo(bar);
      }
}]);
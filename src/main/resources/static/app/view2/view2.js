'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope', 'fabrica', function ($scope, fabrica)  {
      $scope.add=function(){
        var bar={"nombre":$scope.nombre,"direccion":$scope.direccion,"telefono":$scope.telefono,"cover":$scope.cover};
        fabrica.addTodo(bar);
      }
}]);
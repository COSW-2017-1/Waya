'use strict';

angular.module('myApp.ingresarBar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ingresarBar', {
    templateUrl: 'ingresarBar/ingresarBar.html',
    controller: 'IngresarBarCtrl'
  });
}])

/**
Implementación básica sin API

.controller('IngresarBarCtrl', ['$scope', 'fabrica', function ($scope, fabrica)  {
      $scope.add=function(){
        var bar={"logo":$scope.logo,"name":$scope.name,"id":$scope.id,"descripcion":$scope.descripcion,"horario":$scope.horario};
        fabrica.addTodo(bar);
      }
}]);

*/
.controller('IngresarBarCtrl', ['$scope', 'bares', function ($scope,bares)  {
      $scope.add=function(){
        var bar={"logo":$scope.logo,"name":$scope.name,"descripcion":$scope.descripcion,"horario":$scope.horario,
        "direccion":$scope.direccion,"latitud":$scope.latitud,"longitud":$scope.longitud,"tipo":$scope.tipo};
        bares.save(bar);
        //Aqui se añade el metodo creado para que se añada al mapa
        createFeature($scope.latitud,$scope.longitud,"cover");
      }

}]);
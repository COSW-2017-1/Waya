'use strict';

angular.module('myApp.obtenerBares', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/obtenerBares', {
    templateUrl: 'obtenerBares/obtenerBares.html',
    controller: 'obtenerBaresCtrl'
  });
}])

/*
.controller('obtenerBaresCtrl', ['$scope', 'fabrica', function($scope, fabrica) {
        $scope.listado= fabrica.getListado();
        $scope.propertyName = 'name';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };



}]);

*/
.controller('obtenerBaresCtrl', ['$scope', 'bares', 'baresFabrica', function($scope, bares, baresFabrica) {
        $scope.listado= bares.query();
        $scope.propertyName = 'name';
        $scope.data ="";
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };
        $scope.buscar = function(){
            baresFabrica.buscar($scope.data);
        };
		$scope.ir = function(idx){
             window.location = "http://wayafiesta.herokuapp.com/app/index.html#!/detalleBar/"+(idx+1);
        };





}]);
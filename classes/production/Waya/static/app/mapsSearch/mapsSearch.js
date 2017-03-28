'use strict';

angular.module('myApp.mapsSearch', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mapsSearch', {
    templateUrl: 'mapsSearch/mapsSearch.html',
    controller: 'MapsSearchCtrl'
  });
}])

.controller('MapsSearchCtrl', ['$scope', 'fabrica', function($scope, fabrica) {
        $scope.listado= fabrica.getListado();
        $scope.propertyName = 'cover';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };
}]);
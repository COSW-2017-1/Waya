'use strict';

angular.module('myApp.detalleBar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/detalleBar', {
    templateUrl: 'detalleBar/detalleBar.html',
    controller: 'DetalleBarCtrl'
  });
}])

.controller('DetalleBarCtrl', ['$scope', 'bares', function ($scope,bares)  {


}]);
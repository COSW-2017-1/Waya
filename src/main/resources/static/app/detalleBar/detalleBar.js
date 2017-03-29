'use strict';

angular.module('myApp.detalleBar', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/detalleBar/:nBar', {
    templateUrl: 'detalleBar/detalleBar.html',
    controller: 'DetalleBarCtrl'
  });
}])

.controller('DetalleBarCtrl', ['$scope', 'bares', '$routeParams', function ($scope,bares,$routeParams)  {
    var nBar =$routeParams.nBar;
    bares.get({id:nBar}, function(bar) {
        console.log(bar);
        $scope.bar=bar;
    });
}]);
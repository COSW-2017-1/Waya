'use strict';

angular.module('myApp.ingreso', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ingreso', {
    templateUrl: 'ingreso/ingreso.html',
    controller: 'IngresoCtrl'
  });
}])
.controller('IngresoCtrl', function($rootScope, $scope, $http, $location) {

    var authenticate = function (credentials, callback) {
          var headers = credentials ? {authorization: "Basic " + btoa(credentials.username + ":" + credentials.password)} : {};

          $http.get('user', {headers : headers}).then(function(response) {
                if (response.data.name) {
                  $rootScope.authenticated = true;
                } else {
                  $rootScope.authenticated = false;
                }
                callback && callback();
              }, function() {
                $rootScope.authenticated = false;
                callback && callback();
              });
      };

      authenticate();
      $scope.credentials = {};
      $scope.login = function () {
          authenticate($scope.credentials, function () {
              if ($rootScope.authenticated) {
                  $location.path("/");
                  $scope.error = false;
              } else {
                  $location.path("/login");
                  $scope.error = true;
              }
          });
      };
});
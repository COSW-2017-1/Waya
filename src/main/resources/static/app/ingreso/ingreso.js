'use strict';

angular.module('myApp.ingreso', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ingreso', {
    templateUrl: 'ingreso/ingreso.html',
    controller: 'IngresoCtrl'
  });
}])
.controller('IngresoCtrl', function($rootScope, $scope, $http, $location, $mdDialog) {

    $rootScope.emailito = $scope.email;
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
      $scope.login = function (ev) {
          authenticate($scope.credentials, function () {
              if ($rootScope.authenticated) {
                  $location.path("/");
                  $scope.error = false;

                  $mdDialog.show(
                        $mdDialog.alert()
                          .parent(angular.element(document.querySelector('#popupContainer')))
                          .clickOutsideToClose(true)
                          .title('Alerta')
                          .textContent('Bienvenido ' + $scope.credentials.username)
                          .ariaLabel('Ingreso completado')
                          .ok('Aceptar')
                          .targetEvent(ev)
                  );
              } else {
                  $location.path("/login");
                  $scope.error = true;
              }
          });
      };
});
'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngMaterial',
  'myApp.landing',
  'myApp.ingresarBar',
  'myApp.ingreso',
  'myApp.mapsSearch',
  'myApp.obtenerBares',
  'myApp.registro',
  'services.listFactory',
  'myApp.version',
  'myApp.pruebaMultimedia'
])
.config(['$locationProvider', '$routeProvider','$httpProvider', function($locationProvider, $routeProvider, $httpProvider) {
  $locationProvider.hashPrefix('!');
  $routeProvider.otherwise({redirectTo: '/landing'});
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])
.controller('LogOutController', function($rootScope, $scope, $http, $location, $mdDialog) {

    $scope.logout = function (ev) {
        $mdDialog.show(
              $mdDialog.alert()
                .parent(angular.element(document.querySelector('#popupContainer')))
                .clickOutsideToClose(true)
                .title('Alerta')
                .textContent('La sesíon de usuario ha sido cerrada exitosamente')
                .ariaLabel('Sesíon cerrada')
                .ok('Aceptar')
                .targetEvent(ev)
        );

        $http.post('/logout', {}).finally(function () {
            $rootScope.authenticated = false;
            $location.path("/");
        });
    };
});

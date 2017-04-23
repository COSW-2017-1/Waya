'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registro', {
    templateUrl: 'registro/registro.html',
    controller: 'RegistroCtrl'
  });
}])
.controller('RegistroCtrl', function($rootScope, $scope, $http, $location, $mdDialog) {
    $scope.registrer = function(ev) {
    $scope.user.details.email = $rootScope.emailito;
        $http.post('/app/user/registrer', JSON.stringify($scope.user), {headers: {'Content-Type': 'application/json'}})
            .then( function() {
                $rootScope.authenticated = true;
                $location.path("/");

                $mdDialog.show(
                      $mdDialog.alert()
                        .parent(angular.element(document.querySelector('#popupContainer')))
                        .clickOutsideToClose(true)
                        .title('Alerta')
                        .textContent('Bienvenido ' + $scope.user.username)
                        .ariaLabel('Registro completado')
                        .ok('Aceptar')
                        .targetEvent(ev)
                );
            }, function() {
                //Failure
            });
    };

});
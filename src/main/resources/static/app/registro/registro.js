'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registro', {
    templateUrl: 'registro/registro.html',
    controller: 'RegistroCtrl'
  });
}])
.controller('RegistroCtrl', function($rootScope, $scope, $http, $location) {
    $scope.registrer = function() {
        $http.post('/app/user/registrer', JSON.stringify($scope.user), {headers: {'Content-Type': 'application/json'}}).then( function() {
                $rootScope.authenticated = true;
                $location.path("/");
            }, function() {
                //Failure
            });
    };

});
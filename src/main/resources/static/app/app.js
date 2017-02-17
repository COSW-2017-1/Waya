'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.landing',
  'myApp.ingresarBar',
  'myApp.ingreso',
  'myApp.registro',
  'myApp.obtenerBares',
  'services.listFactory',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/landing'});
}]);

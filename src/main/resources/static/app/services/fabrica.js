'use strict';
angular.module('services.listFactory', ['ngRoute', 'ngResource'])

    .factory('fabrica', function () {
        var data = {
            listado: []
        };
        return {
            getListado: function () {
                return data.listado;
            },
            addTodo: function (todo) {
                data.listado.push(todo);
            }};
    })
    .factory('bares', function($resource) {
                return $resource('/bares/:id');
            });

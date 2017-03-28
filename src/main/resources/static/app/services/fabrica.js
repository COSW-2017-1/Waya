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
            })
    .service('fileUpload', ['$http', function ($http) {
        this.uploadFileToUrl = function(file, uploadUrl){
            var fd = new FormData();
            console.log("llego");
            fd.append('file', file);
            $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })
            .then(function(){
                console.log("sirvio---------------------------------------------------------------");
            });
        }
    }])
    .factory('baresFabrica', function(bares) {
        return {
            buscar: function (texto) {
                console.log("entrooooooooo a buscar");
                bares.query(function(resp){
                    console.log(texto);
                    console.log(resp);
                });
            },
            parseBuscar: function (todo) {
                bares.query();
            }};
    });

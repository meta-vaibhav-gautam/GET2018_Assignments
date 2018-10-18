'use strict';

angular.
    module('userList').
    component('userList', {
        templateUrl: 'UserList/user-list.template.html',
        controller: function UserListController($scope, $http) {

            var self = this;

            $http.get('http://localhost:3000/user').then(function (response) {
                self.users = response.data;
            });

            $scope.postData = function () {
                $http({
                    method: 'POST',
                    url: 'http://localhost:3000/user/',
                    data: $scope.user,
                    dataType: 'json'
                });

                window.location.reload();
            };

            $scope.putData = function (user) {
                $http({
                    method: 'PUT',
                    url: 'http://localhost:3000/user/'+user.id,
                    data: user,
                    dataType: 'json'
                });

                window.location.reload();
            };

            $scope.show = function (userData) {
                $scope.userData = userData;
            }
        }
    });
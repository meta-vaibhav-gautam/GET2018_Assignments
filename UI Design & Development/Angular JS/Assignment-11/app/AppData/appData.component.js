'use strict';

angular.
    module('app_data').
    component('appData', {
        templateUrl: 'AppData/appData.template.html',
        controller: function appDataController($scope, $http) {

            var self = this;
            this.cartItemCount = 0;

            $http.get('http://localhost:3000/items').then(function (response) {
                self.items = response.data;
            });

            $scope.postData = function () {
                $http({
                    method: 'POST',
                    url: 'http://localhost:3000/items/',
                    data: $scope.item,
                    dataType: 'json'
                });

                window.location.reload();
            };

            $scope.addItemToCart = function (item) {
                self.cartItemCount = self.cartItemCount + 1;

                $http.get('http://localhost:3000/cart/' + item.id)
                    .then(
                        function successCallback(response) {
                            response.data.count += 1;
                            response.data.price = response.data.count * response.data.price;
                            $http({
                                method: 'PUT',
                                url: 'http://localhost:3000/cart/' + item.id,
                                data: response.data,
                                dataType: 'json'
                            });
                        },

                        function errorCallback(response) {
                            var cartData = {
                                "id": item.id,
                                "title": item.name,
                                "price": item.price,
                                "imageUrl": item.imageUrl,
                                "count": 1
                            }
                            $http({
                                method: 'POST',
                                url: 'http://localhost:3000/cart/',
                                data: cartData,
                                dataType: 'json'
                            })
                        }
                    );
            }
        }
    });
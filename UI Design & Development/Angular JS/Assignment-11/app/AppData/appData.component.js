'use strict';

angular.
    module('app_data').
    component('appData', {
        templateUrl: 'AppData/appData.template.html',
        controller: function appDataController($scope, $http) {

            var self = this;
            this.cartItemCount = 0;
            this.isItemAdded = [false];
            this.itemCounts = [];

            $http.get('http://localhost:3000/cart').then(function (response) {
                let cartDataLength = response.data.length;
                self.cartItemCount = cartDataLength;

                for (let i = 0; i < cartDataLength; i++) {
                    self.isItemAdded[(response.data[i].id)] = true;
                    self.itemCounts[(response.data[i]).id] = response.data[i].count;
                }
            });

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

            $scope.addItemToCart = function (item, operation) {

                $http.get('http://localhost:3000/cart/' + item.id)
                    .then(
                    function successCallback(response) {

                        if (operation == "increase") {
                            response.data.count += 1;
                            self.itemCounts[item.id] += 1;
                            self.cartItemCount = self.cartItemCount + 1;
                            response.data.price = response.data.count * item.price;
                            $http({
                                method: 'PUT',
                                url: 'http://localhost:3000/cart/' + item.id,
                                data: response.data,
                                dataType: 'json'
                            });
                        }

                        if (operation == "decrease") {

                            if (response.data.count == 1) {
                                $http({
                                    method: 'DELETE',
                                    url: 'http://localhost:3000/cart/' + item.id,
                                });
                                self.cartItemCount = self.cartItemCount - 1;
                                self.isItemAdded[item.id] = false;
                            } else {
                                response.data.count -= 1;
                            }
                            self.itemCounts[item.id] -= 1;
                            self.cartItemCount = self.cartItemCount - 1;
                            response.data.price = response.data.count * item.price;
                            $http({
                                method: 'PUT',
                                url: 'http://localhost:3000/cart/' + item.id,
                                data: response.data,
                                dataType: 'json'
                            });
                        }
                    },

                    function errorCallback(response) {
                        self.cartItemCount = self.cartItemCount + 1;
                        var cartData = {
                            "id": item.id,
                            "title": item.name,
                            "price": item.price,
                            "image": item.imgUrl,
                            "count": 1
                        }
                        self.itemCounts[cartData.id] = 1;
                        $http({
                            method: 'POST',
                            url: 'http://localhost:3000/cart/',
                            data: cartData,
                            dataType: 'json'
                        })
                        self.isItemAdded[item.id] = true;
                    }
                    );
            }
        }
    });
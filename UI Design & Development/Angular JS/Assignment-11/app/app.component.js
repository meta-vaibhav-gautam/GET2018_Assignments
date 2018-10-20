angular.module('app').
    component('headerContent', {
        templateUrl: 'app.template.html',
        controller: function ($scope, $http) {

            var self = this;
            this.cartItemCount = 0;

            $http.get('http://localhost:3000/cart').then(function (response) {
                let cartDataLength = response.data.length;

                for (let i = 0; i < cartDataLength; i++) {
                    self.cartItemCount += response.data[i].count;
                }
            });
        }
    });
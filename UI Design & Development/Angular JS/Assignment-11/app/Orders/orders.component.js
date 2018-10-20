angular.module('orders').component('orders', {
    templateUrl: "Orders/orders.template.html",
    controller: function ordersController($scope, $http) {
        var self = this;
        this.cartItems = [];
        this.isItemAdded = [false];
        this.itemsCount = 0;
        this.totalPrice = 0;

        $http.get('http://localhost:3000/cart').then(function (response) {
            self.items = response.data;
            this.cartItems = response.data;
            for (let i = 0; i < response.data.length; i++) {
                self.itemsCount += response.data[i].count;
                self.totalPrice += response.data[i].price;
            }
        });

        $http.get('http://localhost:4000/orders').then(function (response) {
            self.orders = response.data;
        });
    }
});

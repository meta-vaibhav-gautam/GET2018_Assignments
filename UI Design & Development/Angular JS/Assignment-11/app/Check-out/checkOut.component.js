angular.module('checkOut').component('checkOut', {
  templateUrl: "Check-out/checkOut.template.html",
  controller: function checkOutController($scope, $http) {
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

    $scope.placeOrder = function () {
      var order = {
        "customerName": $scope.customer.name,
        "customerAddress" : $scope.customer.addressLine1+", "+$scope.customer.addressLine2,
        "customerCity" : $scope.customer.city,
        "orderDate" : new Date().getDate()+'/'+(new Date().getMonth()+1)+'/'+new Date().getFullYear(),
        "items" : self.items
      }
      $http({
        method: 'POST',
        url: 'http://localhost:4000/orders/',
        data: order,
        dataType: 'json'
      });
      $scope.clearCart();
    };

    $scope.clearCart = function () {
      for (let i = 0; i < cartItems.length; i++) {
        $http({
          method: 'DELETE',
          url: 'http://localhost:3000/cart/' + cartItems[i].id,
        });
      }
    }
  }
});

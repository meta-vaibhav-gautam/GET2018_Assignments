angular.module('cartDetail').component('cartDetail', {
  templateUrl: "Cart-detail/cart-detail.template.html",
  controller: function cartController($scope, $http) {
    var self = this;
    this.cartItems = [];
    this.cartItemCount = 0;
    this.isItemAdded = [false];
    this.itemCounts = [];
    this.totalPrice = 0;

    $http.get('http://localhost:3000/cart').then(function (response) {
      self.items = response.data;
      this.cartItems = response.data;
      let cartDataLength = response.data.length;
      self.cartItemCount = cartDataLength;

      for (let i = 0; i < cartDataLength; i++) {
        self.isItemAdded[(response.data[i].id)] = true;
        self.itemCounts[(response.data[i]).id] = response.data[i].count;
        self.totalPrice += response.data[i].price;
      }
    });

    $scope.addItemToCart = function (item, operation) {
      let itemUnitPrice = (item.price / item.count);
      if (operation == "increase") {
        item.count += 1;
        self.itemCounts[item.id] += 1;
        item.price = item.count * itemUnitPrice;
        self.totalPrice += itemUnitPrice;
        $http({
          method: 'PUT',
          url: 'http://localhost:3000/cart/' + item.id,
          data: item,
          dataType: 'json'
        });
      }

      if (operation == "decrease") {

        if (item.count == 1) {
          $http({
            method: 'DELETE',
            url: 'http://localhost:3000/cart/' + item.id,
          });
          self.cartItemCount = self.cartItemCount - 1;
          self.isItemAdded[item.id] = false;
          window.location.reload();
        } else {
          item.count -= 1;
        }
        self.itemCounts[item.id] -= 1;
        item.price = item.count * itemUnitPrice;
        self.totalPrice -= itemUnitPrice;
        $http({
          method: 'PUT',
          url: 'http://localhost:3000/cart/' + item.id,
          data: item,
          dataType: 'json'
        });
      }
    }

    $scope.clearCart = function () {
      for (let i = 0; i < cartItems.length; i++) {
        $http({
          method: 'DELETE',
          url: 'http://localhost:3000/cart/' + cartItems[i].id,
        });
      }
      window.location.reload();
    }
  }
});

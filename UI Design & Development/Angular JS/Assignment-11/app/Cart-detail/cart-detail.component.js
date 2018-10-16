angular.module('cartDetail').component('cartDetail',{
    templateUrl:"Cart-detail/cart-detail.template.html",
    controller : ['$routeParams',
    function cartController($routeParams) {
      this.title = "CART";
    }
  ]
});

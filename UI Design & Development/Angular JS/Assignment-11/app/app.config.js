angular.
  module('app').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/', {
          template: '<app-data></app-data>'
        }).
        when('/shopping-cart', {
          template: '<header-content></header-content> <cart-detail></cart-detail>'
        }).
        when('/check-out', {
          template: '<header-content></header-content> <check-out></check-out>'
        }).
        when('/order-success', {
          template: '<header-content></header-content> <order-success></order-success>'
        }).
        when('/admin/orders', {
          template: '<header-content></header-content> <orders></orders>'
        }).
        otherwise('');
    }
  ]);
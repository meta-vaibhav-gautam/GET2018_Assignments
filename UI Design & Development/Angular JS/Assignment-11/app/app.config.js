angular.
  module('app').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/', {
          template: '<app-data></app-data>'
        }).
        when('/cart', {
          template: '<cart-detail></cart-detail>'
        }).
        otherwise('');
    }
  ]);
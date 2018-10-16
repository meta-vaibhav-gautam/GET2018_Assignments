angular.
  module('app').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/', {
          template: '<main-content></main-content>'
        }).
        when('/cart', {
          template: '<cart-detail></cart-detail>'
        }).
        otherwise('/app');
    }
  ]);
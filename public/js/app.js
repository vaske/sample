// Declare app level module which depends on filters, and services
angular.module('sample', ['ngResource', 'ngRoute', 'ui.bootstrap', 'ui.date'])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/company/companies.html',
        controller: 'HomeController'})
      .otherwise({redirectTo: '/'});
  }]);

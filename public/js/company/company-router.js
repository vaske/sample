'use strict';

angular.module('sample')
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/companies', {
        templateUrl: 'views/company/companies.html',
        controller: 'CompanyController',
        resolve:{
          resolvedCompany: ['Company', function (Company) {
            return Company.query();
          }]
        }
      })
    }]);

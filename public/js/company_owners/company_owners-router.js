'use strict';

angular.module('sample')
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/company_owners', {
        templateUrl: 'views/company_owners/company_owners.html',
        controller: 'Company_ownersController',
        resolve:{
          resolvedCompany_owners: ['Company_owners', function (Company_owners) {
            return Company_owners.query();
          }]
        }
      })
    }]);

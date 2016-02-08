'use strict';

angular.module('sample')
  .factory('Company_owners', ['$resource', function ($resource) {
    return $resource('sample/company_owners/:id', {}, {
      'query': { method: 'GET', isArray: true},
      'get': { method: 'GET'},
      'update': { method: 'PUT'}
    });
  }]);

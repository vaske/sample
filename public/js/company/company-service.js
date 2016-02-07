'use strict';

angular.module('sample')
  .factory('Company', ['$resource', function ($resource) {
    return $resource('sample/companies/:id', {}, {
      'query': { method: 'GET', isArray: true},
      'get': { method: 'GET'},
      'update': { method: 'PUT'}
    });
  }]);

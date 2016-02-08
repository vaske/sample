'use strict';

angular.module('sample')
  .controller('Company_ownersController', ['$scope', '$modal', 'resolvedCompany_owners', 'Company_owners',
    function ($scope, $modal, resolvedCompany_owners, Company_owners) {

      $scope.company_owners = resolvedCompany_owners;


      $scope.create = function () {
        $scope.clear();
        $scope.open();
      };

      $scope.update = function (id) {
        $scope.company_owners = Company_owners.get({id: id});
        $scope.open(id);
      };

      $scope.delete = function (id) {
        Company_owners.delete({id: id},
          function () {
            $scope.company_owners = Company_owners.query();
          });
      };

      $scope.save = function (id) {
        if (id) {
          Company_owners.update({id: id}, $scope.company_owners,
            function () {
              $scope.company_owners = Company_owners.query();
              $scope.clear();
            });
        } else {
          Company_owners.save($scope.company_owners,
            function () {
              $scope.company_owners = Company_owners.query();
              $scope.clear();
            });
        }
      };

      $scope.clear = function () {
        $scope.company_owners = {

          "company_id": "",

          "owner_name": "",

          "id": ""
        };
      };

      $scope.open = function (id) {
        var company_ownersSave = $modal.open({
          templateUrl: 'company_owners-save.html',
          controller: 'Company_ownersSaveController',
          resolve: {
            company_owners: function () {
              return $scope.company_owners;
            }
          }
        });

        company_ownersSave.result.then(function (entity) {
          $scope.company_owners = entity;
          $scope.save(id);
        });
      };
    }])
  .controller('Company_ownersSaveController', ['$scope', '$modalInstance', 'company_owners',
    function ($scope, $modalInstance, company_owners) {
      $scope.company_owners = company_owners;

      $scope.ok = function () {
        $modalInstance.close($scope.company_owners);
      };

      $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
      };
    }]);

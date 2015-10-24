'use strict';

angular.module('app')
  .controller('RootController', ['$scope', '$modal', function ($scope, $modal) {
      $scope.loginShow = function () {
          var dailog = $modal.open({
              templateUrl: 'login/login.view.html',
              controller: LoginController,
              size: 'lg'
          });
      };

      var LoginController = function ($scope, $modalInstance) {
          //$scope.search = {};
          //$scope.search.completed = '';
          //$scope.history = workoutHistoryTracker.getHistory();

          $scope.ok = function () {
              $modalInstance.close();
          };
      };
        LoginController['$inject'] = ['$scope', '$modalInstance'];

      $scope.$on('$routeChangeSuccess', function (e, current,previous) {
          $scope.currentRoute = current;
      });

  }]);

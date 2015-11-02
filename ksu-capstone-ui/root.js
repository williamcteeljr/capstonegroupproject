'use strict';

angular.module('app')
  .controller('RootController', ['$scope', '$modal' , '$http', function ($scope, $modal , $http) {

      $scope.loginShow = function () {
          var dailog = $modal.open({
              templateUrl: 'login/login.view.html',
              controller: LoginController,
              size: 'lg'
          });
      };

      var LoginController = function ($scope, $modalInstance , $http) {
          $scope.form = {};
          //$scope.search = {};
          //$scope.search.completed = '';
          //$scope.history = workoutHistoryTracker.getHistory();


          $scope.ok = function () {
              $modalInstance.close();
          };

          $scope.register = function() {
              $modalInstance.close();

              var dailog = $modal.open({
                  templateUrl: 'register/register.view.html',
                  controller : RegisterLoginController
              });
          }


          $scope.validatelogin = function() {

              if($scope.form.username === 'admin' && $scope.form.password === 'admin'){

                  alert('success');
                  $modalInstance.close();
                  return true;
              }

             // var data = { userName : 'admin' ,  passWord : 'admin' };

          /*    var data = { userName : $scope.form.username ,
                  passWord : $scope.form.password };*/

              var data = JSON.stringify({ userName : $scope.form.username
                  , passWord : $scope.form.password });

              $http.post("http://localhost:8090/ksu-capstone-project-app/rest/userservice/userauth", data)
                  .success(function(data, status) {
                      alert('successfully logged in ');
                      $modalInstance.close();
                  })
          }


      };
        LoginController['$inject'] = ['$scope', '$modalInstance' , '$http'];

      $scope.$on('$routeChangeSuccess', function (e, current,previous) {
          $scope.currentRoute = current;
      });

  }]);

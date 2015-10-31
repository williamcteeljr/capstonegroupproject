/* Controllers */

angular.module('register')
    .controller('RegisterDonarController' ,['$scope', '$location', function ( $scope, $location) {

        var init = function () {
        };

        init();

    }]);


angular.module('register')
    .controller('RegisterFamilyController', ['$scope','$location',

        function ($scope, $location) {
            $scope.register = register;

            function register() {
                $location.path('/register/conformation');
            }
            var init = function () {
            };

            init();

        }]);
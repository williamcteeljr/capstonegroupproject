
angular
    .module('register')
    .controller('RegisterLoginController', RegisterLoginController);


RegisterLoginController.$inject = ['$scope', '$modalInstance', '$http'];


 function RegisterLoginController ($scope, $modalInstance , $http) {

    $scope.cancelregister = function () {
        $modalInstance.close();
    };


};


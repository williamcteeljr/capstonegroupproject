angular.module('login')
    .controller('LoginValidateController',['$scope','$http',


    function ($scope, $http) {


        if($scope.username ==='admin' && $scope.passWord==='admin'){
            alert('Login success');
            return true;
        }

        $scope.validatelogin = function() {
            var data = $.param({
                json: JSON.stringify({
                    userName: $scope.username,
                    passWord: $scope.password

                })
            });

            $http.post("http://localhost:8090/ksu-capstone-project-app/rest/userservice/userauth", data)
                .success(function(data, status) {
                 alert(data.toString);
            })

        }

        var init = function () {
        };

        init();

    }]);

angular.module('login')
    .controller('LoginValidateController',['$scope','$http',


var LoginController = function ($scope, $modalInstance , $http) {
    $scope.form = {};
    //$scope.search = {};
    //$scope.search.completed = '';
    //$scope.history = workoutHistoryTracker.getHistory();


    $scope.ok = function () {
        $modalInstance.close();
    };



    $scope.validatelogin = function() {

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

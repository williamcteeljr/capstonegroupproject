//Define an angular module for our app
var sampleApp = angular.module('sampleApp', []);

//Define Routing for app
//Uri /AddNewOrder -> template AddOrder.html and Controller AddOrderController
//Uri /ShowOrders -> template ShowOrders.html and Controller AddOrderController
sampleApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/landing/home.html',
		controller : 'HomeController',
		controllerAs: 'vm'
	}).when('/Donate', {
		templateUrl : '/landing/donate.html',
		controller : 'DonateController',
		controllerAs: 'vm'
	}).when('/Login', {
		templateUrl : '/login/login.view.html',
		controller : 'LoginController',
		controllerAs: 'vm'
	}).when('/Family', {
		templateUrl : '/landing/family.html',
		controller : 'FamilyController',
		controllerAs: 'vm'
	}).when('/Admin', {
		templateUrl : '/landing/admin.html',
		controller : 'AdminController',
		controllerAs: 'vm'
	}).when('/Contact', {
		templateUrl : '/landing/contact.html',
		controller : 'ContactController',
		controllerAs: 'vm'
	}).otherwise({
		redirectTo : '/Home'
	});
} ]);

sampleApp.controller('HomeController', function($scope) {

	$scope.message = 'This is Add new order screen';

});

sampleApp.controller('DonateController', function($scope) {

	$scope.message = 'This is Show orders screen';

});

sampleApp.controller('FamilyController', function($scope) {

	$scope.message = 'This is Show orders screen';

});

sampleApp.controller('ContactController', function($scope) {

	$scope.message = 'This is Show orders screen';

});

sampleApp.controller('AdminController', function($scope) {

	$scope.message = 'This is Show orders screen';

});

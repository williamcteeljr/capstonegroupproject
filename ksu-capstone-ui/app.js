//Define an angular module for our app
var sampleApp = angular.module('app',

	['ui.bootstrap']
);




sampleApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/Home', {
		templateUrl : '/landing/home.html',
		controller : 'HomeController',
		controllerAs: 'vm'
	}).when('/Donate', {
		templateUrl : '/landing/donate.html',
		controller : 'DonateController',
		controllerAs: 'vm'
	}).when('/Register', {
		templateUrl : '/landing/register.html',
		controller : 'RegisterController',
		controllerAs: 'vm'
	}).when('/Faq', {
		templateUrl : '/landing/faq.html',
		controller : 'FaqController',
		controllerAs: 'vm'
	}).when('/AboutUs', {
		templateUrl : '/landing/aboutus.html',
		controller : 'AboutUsController',
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
		redirectTo : '/Admin'
	});
} ]);



sampleApp.controller('FaqController', function($scope) {

	$scope.message = 'This is Add new order screen';

});

sampleApp.controller('HomeController', function($scope) {

	$scope.message = 'This is Add new order screen';

});

sampleApp.controller('RegisterController', function($scope) {

	$scope.message = 'This is Add new order screen';

});

sampleApp.controller('DonateController', function($scope) {

	$scope.message = 'This is Show orders screen';

});

sampleApp.controller('AboutUsController', function($scope) {

	$scope.message = 'This is Show orders screen';

});

sampleApp.controller('ContactController', function($scope) {

	$scope.message = 'This is Show orders screen';

});

sampleApp.controller('AdminController', function($scope) {

	$scope.message = 'This is Show orders screen';

});

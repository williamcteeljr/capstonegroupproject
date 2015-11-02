'use strict';

angular.module('app', ['ngRoute', 'ui.bootstrap','ngMessages', 'register', 'login', 'donate']).
	config(function ($routeProvider ,  $sceDelegateProvider ) {


		$routeProvider.when('/Home', { templateUrl: 'landing/home.html' });
		$routeProvider.when('/Donate',
			{ templateUrl: 'donate/donate.html',
			controller: 'StoreController'
		});

		$routeProvider.when('/Admin', { templateUrl: 'landing/admin.html' });
		$routeProvider.when('/Contact', { templateUrl: 'landing/contact.html' });
		$routeProvider.when('/AboutUs', { templateUrl: 'landing/aboutus.html' });
		$routeProvider.when('/Register', { templateUrl: 'landing/register.html' });





		$routeProvider.when('/register/family', {
			templateUrl: 'register/family.html',
			controller: 'RegisterFamilyController'
		});

		$routeProvider.when('/register/conformation', {
			templateUrl: 'register/conformation.html'
		});


		$routeProvider.when('/register/donar', {
			templateUrl: 'register/donar.html',
			controller: 'RegisterDonarController'
		});

		$routeProvider.when('/register/donar/conformation', {
			templateUrl: 'register/conformation.html'
		});

		$routeProvider.when('/register/family/conformation', {
			templateUrl: 'register/family-conform.html'
		});

		$routeProvider.when('/donate/familydonation', {
			templateUrl: 'donate/family-donation.html'
		});

		$routeProvider.when('/donate/conformation', {
			templateUrl: 'donate/donate-conformation.html'
		});

		$routeProvider.otherwise({ redirectTo: '/Home' });

		$sceDelegateProvider.resourceUrlWhitelist([
			// Allow same origin resource loads.
			'self',
			// Allow loading from our assets domain.  Notice the difference between * and **.
			'http://!*.youtube.com/!**']);
	});


angular.module('register', []);
angular.module('login', []);
angular.module('donate', []);

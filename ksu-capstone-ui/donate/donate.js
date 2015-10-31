
angular.module('donate')
    .controller('StoreController', ['$scope',

        function ($scope) {
            $scope.products
                = [{
                name: 'Azurite',
                description: "Some gems have hidden qualities beyond their luster, beyond their shine... Azurite is one of those gems.",
                shine: 8,
                price: 110.50,
                rarity: 7,
                color: '#CCC',
                faces: 14,
                images: [
                    "images/admin.png",
                    "images/contact.jpeg",
                    "images/donate.jpeg"
                ]
            }, {
                name: 'Bloodstone',
                description: "Origin of the Bloodstone is unknown, hence its low value. It has a very high shine and 12 sides, however.",
                shine: 9,
                price: 22.90,
                rarity: 6,
                color: '#EEE',
                faces: 12,
                images: [
                    "images/admin.png",
                    "images/contact.jpeg",
                    "images/donate.jpeg"
                ]
            }, {
                name: 'Zircon',
                description: "Zircon is our most coveted and sought after gem. You will pay much to be the proud owner of this gorgeous and high shine gem.",
                shine: 70,
                price: 1100,
                rarity: 2,
                color: '#000',
                faces: 6,
                images: [
                    "images/admin.png",
                    "images/contact.jpeg",
                    "images/donate.jpeg"
                ]
            }];






            var init = function () {
            };

            init();

        }]);




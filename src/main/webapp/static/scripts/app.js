'use strict';

var app = angular.module('app', []);

/**
 * Header controller.
 */
app.controller('HeaderController', ['$scope', '$timeout', function ($scope, $timeout) {

    $scope.isSearchClicked = false;

    $scope.toggleInput = function () {
        $scope.isSearchClicked = !$scope.isSearchClicked;
        if ($scope.isSearchClicked) {
            $timeout(function () {
                jQuery("#search-input").focus();
            }, 150);

        }
    };

}]);

/**
 * Slider controller.
 */
app.controller('SliderController', ['$scope', function ($scope) {

    $scope.init = function () {
        jQuery('.tp-banner').revolution(
            {
                //delay: 6000,
                //startwidth: 1170,
                //startheight: 600,
                //fullScreen: 'off',
                //forceFullWidth: 'off'
            });
    };

}]);
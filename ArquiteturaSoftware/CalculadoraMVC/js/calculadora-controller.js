app.controller('CalculadoraController', function ($scope) {

    $scope.numUm = 0 ;
    $scope.numDois = 0;
    $scope.resultado = 0;

    $scope.somar = function () {
        $scope.resultado =  parseInt($scope.numUm) + parseInt($scope.numDois)  ;
    }

});
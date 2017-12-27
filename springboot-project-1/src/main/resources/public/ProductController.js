var app = angular.module('springDemo', [])

.controller('Products', function($scope, $http) {
	$scope.urlService = "/products";
	$scope.showListProducts = true;
	$scope.showDivs = function(productList){	
		if (productList){
			$scope.showNewForm = false;
			$scope.showListProducts = true;			
		}
	}
	
	$scope.reset = function(form) {
    if (form) {
      form.$setPristine();
      form.$setUntouched();
    }
  };
  
	//Get product list
	$scope.getProducts = function(){
		$http.get($scope.urlService).
			then(function(response) {
				$scope.products = response.data;				
			});
		$scope.searchText = "";
	}
	
	//Get product by ID
	$scope.getProductById = function(id){
		$http.get($scope.urlService+"/"+id).
			then(function(response) {
				$scope.product = response.data;
				$scope.showDetail();				
			});
		$scope.searchText = "";		
	}
	

	//Search Products
	$scope.searchProducts = function (){
		$http.get($scope.urlService+"/"+$scope.searchType+"/"+$scope.searchText).
			then(function(response) {
				$scope.products = response.data;
			});
	}
	
	$scope.showDetail = function(){		
		$scope.showDivs(false);
		$scope.formTitle = "Show Product"
		$scope.id = $scope.product.id;
		$scope.productName = $scope.product.productName;
		$scope.color = $scope.product.color;
		$scope.style = $scope.product.style;
		$scope.category = $scope.product.category;
	}
	

});


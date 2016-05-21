// The root URL for the RESTful services
var rootURL = "http://localhost:8080/soa/rest/ECommerce/allproducts";
var currentProduct;

// Retrieve wine list when application starts 
findAll();

/**
* 页面加载时写表格
*/
function listitems()
{
	var list = '{ "products" : [' +
		'{ "id":"1" , "name":"Game of Throne", "description":"book", "price":"6", "stock":"22" },' +
		'{ "id":"1" , "name":"Game of Throne", "description":"book", "price":"6", "stock":"22" } ]}';
	var obj = eval ("(" + list + ")");
	
}
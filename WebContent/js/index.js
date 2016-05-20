// The root URL for the RESTful services
var rootURL = "http://localhost:8080/soa/rest/ECommerce/allproducts";
var currentProduct;

// Retrieve product list when application starts 
findAll();

// Register listeners
$(".btn btn-mini").click(function() {
	console.log("btn-mini");
	alert(1);
}
);


function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: renderTable
	});
}

function renderTable(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	
	$('#tbody_list').remove();
	$.each(list, function(index, item) {
		var tbBody = "";
		
		tbBody += "<tr><td>"+item.id+"</td>"
		+"<td>"+item.name+"</td>"
		+"<td>"+item.description+"</td>"
		+"<td>$"+item.price+"</td>"
		+"<td>"+item.stock+"</td>"
		//+"<td><button type=\"button\" class=\"btn btn-mini\" onclick=\"cart_number('number"+item.id+"','-',1))\">-</button>"
		+"<td><button type=\"button\" class=\"btn btn-mini\">-</button>"
		+"<input type=\"text\" style=\"width:5%\" id=\"number"+item.id+"\" value=\"0\" />"
		//+"<button type=\"button\" class=\"btn btn-mini\" onclick=\"cart_number('number"+item.id+"','+',1))\" >+</button></td></tr>"
		+"<button type=\"button\" class=\"btn btn-mini\">+</button></td></tr>"
		
		$('#t_list').append(tbBody);
	});
}

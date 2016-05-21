// The root URL for the RESTful services
var rootURL = "http://localhost:8080/soa/rest/ECommerce/";
var logisticURL = "http://localhost:8080/soa/rest/LogisiticService/";
var manufactureURL = "http://localhost:8080/soa/rest/Manufactures/";

// Retrieve product list when application starts 
findAll();
findOrders();

/*
*注册监听
*/

//添加订单
$(document).on("click", "#btnAddOrder", function() {
	sendOrder();
});

//查询订单详情
$(document).on("click", "#btngetOrder", function() {
	getOrderByCustomerId($('#customerId').val());
});

//查询订单物流状态
$(document).on("click", "#btnGetLogistic", function(){
	getLogisticByOrderId($('#orderId').val());
});

/*
*方法列表
*/
//获取所有产品
function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL+"allproducts",
		dataType: "json", // data type of response
		success: renderProductTable
	});
}

//生成订单
function sendOrder(){
	console.log('sendOrder');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL+"addorder", 
		dataType: "json",
		data: makeJsonOrders, 
		success: function(data, textStatus, jqXHR){
			alert('订单号：'+data.memberid);
		}
	});
}

//准备商品列表
function renderProductTable(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	
	//$('#tbody_list').remove();
	$.each(list, function(index, item) {
		var tbBody = "";
		
		tbBody += "<tr><td>"+item.id+"</td>"
		+"<td>"+item.name+"</td>"
		+"<td>"+item.description+"</td>"
		+"<td>$"+item.price+"</td>"
		+"<td>"+item.stock+"</td>"
		+"<td><button type=\"button\" class=\"btn btn-mini\" onclick=\"cart_number('number"+item.id+"','-',1);\" >-</button>"
		//+"<td><button type=\"button\" class=\"btn btn-mini\" name=\"btnMinus\">-</button>"
		+"<input type=\"text\" style=\"width:5%\" id=\"number"+item.id+"\" value=\"0\" />"
		+"<button type=\"button\" class=\"btn btn-mini\" onclick=\"cart_number('number"+item.id+"','+',1);\" >+</button></td></tr>"
		//+"<button type=\"button\" class=\"btn btn-mini\" name=\"btnAdd\">+</button></td></tr>"
		//+"<input type=\"button\" name='btnAdd' style=\"width:15px; text-align:center\" value=\"+\" /></td></tr>"
		
		$('#t_list').append(tbBody);
	});
}

//准备订单数据
function makeJsonOrders(){
	return JSON.stringify({
		"id": 1 ,
		"product_id_list": "1,2", 
		"product_num_list": "3,4",
		"total_price": "56",
		"customer_id": "1",
		"ship_address": "Beijing",
		"process": "客户已下单"
		});
}

//根据客户ID得到订单
function getOrderByCustomerId(id){
	console.log('getOrderByCustomerId：'+id);
	$.ajax({
		type: 'GET',
		url: rootURL +"orderBycustomer/"+id,
		dataType: "json",
		success: renderTableOrderById
	});
}

//准备指定用户的订单列表
function renderTableOrderById(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	
	//$('#tbody_orderById').remove();
	$.each(list, function(index, item) {
		var tbBody = "";
		
		tbBody += "<tr><td>"+item.customer_id+"</td>"
		+"<td>"+item.id+"</td>"
		+"<td>"+item.product_id_list+"</td>"
		+"<td>"+item.product_num_list+"</td>"
		+"<td>"+item.ship_address+"</td>"
		+"<td>$"+item.total_price+"</td></tr>"
		
		$('#t_orderById').append(tbBody);
	});
}

//获取全部订单
function findOrders()
{
	console.log('allOrders');
	$.ajax({
		type: 'GET',
		url: rootURL+"allorder",
		dataType: "json", // data type of response
		success: renderTableOrder
	});
}

//显示所有订单
function renderTableOrder(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	
	//$('#tbody_orderById').remove();
	$.each(list, function(index, item) {
		var tbBody = "";
		
		tbBody += "<tr><td>"+item.id+"</td>"
		+"<td>"+item.product_id_list+"</td>"
		+"<td>"+item.product_num_list+"</td>"
		+"<td><button type=\"button\" class=\"btn btn-mini btn-primary\">produce</button></td>"
		+"<td><button type=\"button\" class=\"btn btn-mini\" disabled>shipping</button></td></tr>"
		
		$('#t_orders').append(tbBody);
	});
}

//根据订单号获取物流
function getLogisticByOrderId(id){
	console.log('getLogisticByOrderId'+id);
	$.ajax({
		type: 'GET',
		url: logisticURL +id,
		dataType: "json",
		success: renderTableLogistic
	});
}

//准备物流状态表
function renderTableLogistic(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	
	//$('#tbody_orderById').remove();
	$.each(list, function(index, item) {
		var tbBody = "";
		
		tbBody += "<tr><td>"+item.id+"</td>"
		+"<td>"+item.order_id+"</td>"
		+"<td>"+item.progress+"</td></tr>"
		
		$('#t_logistic').append(tbBody);
	});
}

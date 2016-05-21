// The root URL for the RESTful services
var rootURL = "rest/ECommerce/";
var logisticURL = "rest/LogisiticService/";
var manufactureURL = "rest/Manufactures/";
var productIds = new Array();//商品ID数组
var productNumbers = new Array();//商品数量数组
var totalPrice = 0;
// Retrieve product list when application starts 
findAll();
findOrders();

/*
*注册监听
*/

//添加订单
$(document).on("click", "#btnAddOrder", function() {
	sendOrder();
	//traverseTable();
});

//查询订单详情
$(document).on("click", "#btngetOrder", function() {
	getOrderByCustomerId($('#customerId').val());
});

//查询订单物流状态
$(document).on("click", "#btnGetLogistic", function(){
	getLogisticByOrderId($('#orderId').val());
});

$(document).ready(function(){
  $('#t_orders button').each(function() {
     $(this).click(function() {     
     window.alert($(this).attr("id_")); // 这是序号

  });
});
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

//遍历表格
//1. 遍历每行，取出数量不为0的，加入二维数组，
//i = parseInt($(number).val());关键，取到input里的数量
function traverseTable()
{
	console.log("traverseTable");
	//首先清空缓存的变量
	clearVariable();
	
	var p_id;
	var p_number;
	var p_price;
	$("#t_list tr").each(function(trindex,product){
		$(product).find("td input").each(function(tdindex,number){
			p_number = $(number).val();
			if(p_number != "0")
			{
				//alert(p_number);
				p_id = $(product).children("td[id]").text();
				p_price = parseInt($(product).children("td[name]").text());
				//alert(p_price);
				//alert(p_id);
				productIds.push(p_id);
				productNumbers.push(p_number);
				//计算价格
				calcPrice(p_price,p_number);
			}
		});
	});
	//alert(productIds);
	//alert(productNumbers);
	//alert(totalPrice);
}

//清除缓存变量
function clearVariable(){
	var id_length = productIds.length;
	var number_length = productNumbers.length;
	productIds.slice(0,id_length);
	productNumbers.slice(0,number_length);
	totalPrice = 0;
	
	//alert(productIds);
	//alert(productNumbers);
	//alert(totalPrice);
}

//计算价格
function calcPrice(price, number){
	var i_price = parseInt(price);
	var i_number = parseInt(number);
	
	totalPrice += (i_price * i_number);
	//alert(i_price+": "+i_number +": "+totalPrice);
}

//生成订单
function sendOrder(){
	console.log('sendOrder');
	
	//遍历表格，取出数据
	traverseTable();

	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL+"addorder", 
		dataType: "json",
		data: makeJsonOrders(), 
		/*success: function(data, textStatus, jqXHR){
			alert('订单号：'+data.memberid);
		}*/
	});
}



//准备商品列表
function renderProductTable(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	
	//$('#tbody_list').remove();
	$.each(list, function(index, item) {
		var tbBody = "";
		
		tbBody += "<tr><td id=\""+item.id+"\">"+item.id+"</td>"
		+"<td>"+item.name+"</td>"
		+"<td>"+item.description+"</td>"
		+"<td name=\"price\">"+item.price+"</td>"
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
		"id": 1,
		"product_id_list": productIds.join(","), 
		//"product_id_list": "1,2", 
		"product_num_list": productNumbers.join(","),
		//"product_num_list": "3,4",
		"total_price": totalPrice,
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
		+"<td>$"+item.total_price+"</td>"
		+"<td>"+item.process+"</td></tr>"
		
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

//显示全部订单
function renderTableOrder(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	
	//$('#tbody_orderById').remove();
	$.each(list, function(index, item) {
		var tbBody = "";
		
		tbBody += "<tr><td id=\""+item.id+"\">"+item.id+"</td>"
		+"<td>"+item.product_id_list+"</td>"
		+"<td>"+item.product_num_list+"</td>"
		+"<td><button type=\"button\" class=\"btn btn-mini btn-primary\" onclick='produce(this)'>produce</button></td>"
		+"<td><button type=\"button\" class=\"btn btn-mini\" onclick='shipping(this)'>shipping</button></td></tr>"
		
		$('#t_orders').append(tbBody);
	});
}

function produce(obj){ 
	var td = $(obj).parent();
	var tr = $(td).parent();
	//获取ID值
	var s_order_id = $(tr).children("td[id]").text();
	var i_order_id = parseInt(s_order_id);
	alert(manufactureURL+i_order_id);
	$.ajax({
		type: 'GET',
		url: manufactureURL+i_order_id,
		dataType: "json",
		success: function(data, textStatus, jqXHR){
			alert("produce");
		}
	});
} 

function shipping(obj){
	var td = $(obj).parent();
	var tr = $(td).parent();
	//获取ID值
	var order_id = $(tr).children("td[id]").text();
	alert(logisticURL+order_id);
	$.ajax({
		type: 'GET',
		url: logisticURL+order_id,
		dataType: "json",
		success: function(data, textStatus, jqXHR){
			alert("shipping");
		}
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

// The root URL for the RESTful services
var rootURL = "http://localhost:8080/soa/rest/ECommerce/";
var logisticURL = "http://localhost:8080/soa/rest/LogisiticService/";
var manufactureURL = "http://localhost:8080/soa/rest/Manufactures/";

// Retrieve product list when application starts 
findAll();
findOrders();

/*
*ע�����
*/

//��Ӷ���
$(document).on("click", "#btnAddOrder", function() {
	sendOrder();
});

//��ѯ��������
$(document).on("click", "#btngetOrder", function() {
	getOrderByCustomerId($('#customerId').val());
});

//��ѯ��������״̬
$(document).on("click", "#btnGetLogistic", function(){
	getLogisticByOrderId($('#orderId').val());
});

/*
*�����б�
*/
//��ȡ���в�Ʒ
function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL+"allproducts",
		dataType: "json", // data type of response
		success: renderProductTable
	});
}

//���ɶ���
function sendOrder(){
	console.log('sendOrder');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL+"addorder", 
		dataType: "json",
		data: makeJsonOrders, 
		success: function(data, textStatus, jqXHR){
			alert('�����ţ�'+data.memberid);
		}
	});
}

//׼����Ʒ�б�
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

//׼����������
function makeJsonOrders(){
	return JSON.stringify({
		"id": 1 ,
		"product_id_list": "1,2", 
		"product_num_list": "3,4",
		"total_price": "56",
		"customer_id": "1",
		"ship_address": "Beijing",
		"process": "�ͻ����µ�"
		});
}

//���ݿͻ�ID�õ�����
function getOrderByCustomerId(id){
	console.log('getOrderByCustomerId��'+id);
	$.ajax({
		type: 'GET',
		url: rootURL +"orderBycustomer/"+id,
		dataType: "json",
		success: renderTableOrderById
	});
}

//׼��ָ���û��Ķ����б�
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

//��ȡȫ������
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

//��ʾ���ж���
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

//���ݶ����Ż�ȡ����
function getLogisticByOrderId(id){
	console.log('getLogisticByOrderId'+id);
	$.ajax({
		type: 'GET',
		url: logisticURL +id,
		dataType: "json",
		success: renderTableLogistic
	});
}

//׼������״̬��
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

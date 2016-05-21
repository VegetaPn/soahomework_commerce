// The root URL for the RESTful services
var rootURL = "rest/ECommerce/";
var logisticURL = "rest/LogisiticService/";
var manufactureURL = "rest/Manufactures/";
var productIds = new Array();//��ƷID����
var productNumbers = new Array();//��Ʒ��������
var totalPrice = 0;
// Retrieve product list when application starts 
findAll();
findOrders();

/*
*ע�����
*/

//��Ӷ���
$(document).on("click", "#btnAddOrder", function() {
	sendOrder();
	//traverseTable();
});

//��ѯ��������
$(document).on("click", "#btngetOrder", function() {
	getOrderByCustomerId($('#customerId').val());
});

//��ѯ��������״̬
$(document).on("click", "#btnGetLogistic", function(){
	getLogisticByOrderId($('#orderId').val());
});

$(document).ready(function(){
  $('#t_orders button').each(function() {
     $(this).click(function() {     
     window.alert($(this).attr("id_")); // �������

  });
});
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

//�������
//1. ����ÿ�У�ȡ��������Ϊ0�ģ������ά���飬
//i = parseInt($(number).val());�ؼ���ȡ��input�������
function traverseTable()
{
	console.log("traverseTable");
	//������ջ���ı���
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
				//����۸�
				calcPrice(p_price,p_number);
			}
		});
	});
	//alert(productIds);
	//alert(productNumbers);
	//alert(totalPrice);
}

//����������
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

//����۸�
function calcPrice(price, number){
	var i_price = parseInt(price);
	var i_number = parseInt(number);
	
	totalPrice += (i_price * i_number);
	//alert(i_price+": "+i_number +": "+totalPrice);
}

//���ɶ���
function sendOrder(){
	console.log('sendOrder');
	
	//�������ȡ������
	traverseTable();

	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL+"addorder", 
		dataType: "json",
		data: makeJsonOrders(), 
		/*success: function(data, textStatus, jqXHR){
			alert('�����ţ�'+data.memberid);
		}*/
	});
}



//׼����Ʒ�б�
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

//׼����������
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
		+"<td>$"+item.total_price+"</td>"
		+"<td>"+item.process+"</td></tr>"
		
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

//��ʾȫ������
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
	//��ȡIDֵ
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
	//��ȡIDֵ
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

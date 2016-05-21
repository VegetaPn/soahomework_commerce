/**
* 购物车加减按钮 
* @param txt_id 数量的ID 
* @param type 加 + 减 - 
* @param num 添加或者减少的数量 默认为1
*/
function cart_number(txt_id, type, num) 
{ 
	alert(txt_id);
	num = num || 1; 
	var txt = document.getElementById(txt_id); 
	var source_num = parseInt(txt.value); 
	if(source_num == 0 && type == '-') 
	{ 
	alert('商品数量已经为负数'); 
	return; 
	} 
	var to_num = source_num; 
	if(type == '+') 
	{ 
	to_num += num; 
	} 
	else if(type == '-') 
	{ 
	to_num -= num; 
	} 
	
	txt.value = to_num;
	
	//商品信息添加到cookie
	
	//changePrice(to_num);
}

/**
* 更改小计的价格
*/
function changePrice(num)
{
	
}
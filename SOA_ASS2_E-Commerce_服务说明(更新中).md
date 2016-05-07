# SOA ASS2 E-Commerce 服务说明  

## 列表、说明 
1. E-Commerce Service Provider: generateOrder
	1. E-Commerce Service Provider提供下单服务
	2. 由Customer调用
2. Manufactures: produceProduct
	1. Manufactures提供生产产品服务
	2. 由E-Commerce Service Provider调用
3. Logistic Provider: transportProduct
	1. Logistic Provider提供配送服务
	2. 由Manufactures调用
4. Logistic Provider: logisticStatus
	1. Logistic Provider提供物流查询服务
	2. 由Customer调用


## 详情  
1. generateOrder
	1. 需要: 
		1. Customer的id
		2. 商品id、数量的集合
		3. 收货人信息
	2. 返回:
		1. 下单结果说明
		2. 订单号码(唯一标识)
2. produceProduct
	1. 需要:
		1. 订单号码
	2. 返回:
		1. 操作结果
		2. 订单号码
3. transportProduct
	1. 需要:
		1. 订单号码
	2. 返回:
		1. 操作结果
		2. 物流号码(唯一标识)
4. logisticStatus
	1. 需要:
		1. 物流号码
	2. 返回:
		1. 物流状态
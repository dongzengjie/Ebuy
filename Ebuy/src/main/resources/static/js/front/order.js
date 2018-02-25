$(function() {
	var getOrderInfo='/Ebuy/fronted/getOrderInfo';
	
	
	getOrder();
	
	function getOrder(e){
		$.getJSON(getOrderInfo,function(data){
			
			if(data.success){
				var orderList=data.orderList;
				var user=data.user;
				var orderHTML='';
				
				
				
				
				orderList.map(function(item,index){
					orderHTML +='<table><tr><th>商品名称</th><th>商品价格</th><th>购买数量</th></tr>';
					item.orderProductlist.map(function(item,index){
						
						orderHTML +='<tr class="orderProduct">'
									 +'<td class="thumb">'
									 +'<img src="/Ebuy'+item.product.proPic+'" width="70px" height="50px"/><a href="/Ebuy/toproductview?productId='+item.product.productId+'">'+item.product.productName+'</a></td>'
									 +'	<td class="price" id="price_id_1">'
									 +'<span id="price">￥'+item.product.price+'</span> <input type="hidden" value="'+item.product.price+'" /></td>'
									 +'	<td class="number">'
									 +'<dl>'
									 +'<dt><input id="number_id_1" type="text" name="number" value="'+item.num+'" /></dt>'
									 +'</dl></td>'
									 +'</tr>';
					});
					
					orderHTML +='<tr><td class="field">订单号：</td><td><div  class="text" id="orderON">'+item.orderNo+' </div></td></tr></table>';
					
					orderHTML +='<div class="button">'
								+'<a class="deleteOrder" style="color: red; font-size: 20px;" href="#" data-id="'+item.orderId+'">删除</a>'
								+'</div>';
					orderHTML +='<div class="button"><div style="color: red; font-size: 20px;">合计：'+item.cost+'</div></div>';	
								
				});
				
				$('#allcost').html("总计："+data.cost);
				$('#order').html(orderHTML);
				$('#userName').html(user.trueName);
				$('#address').val(user.address);
			}
		});
		
		
		
		$('#order').delegate('.deleteOrder','click',function(e){
			var deleteOrder='/Ebuy/fronted/deleteOrder/'+e.currentTarget.dataset.id
			$.getJSON(deleteOrder,function(data){
				if(data.success){
					getOrder();
				}else{
					 window.location.reload();
				}
			});
		})
		
	}
	
	
	
});
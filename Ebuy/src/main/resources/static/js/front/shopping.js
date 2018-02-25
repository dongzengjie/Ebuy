$(function(){
	var getshoppingCart ='/Ebuy/fronted/getshoppingCart';
	
	var addOrderInfo ='/Ebuy/fronted/addOrderInfo';
	
	var removeurl='';
	var priceproduct=0;
		
	getShopppingCartList();
	
	function getShopppingCartList(e){
		
		$.getJSON(getshoppingCart,function(data){
			
			var shoppingHTML='';
			if(data.success){
				shoppingHTML +='<tr><th>商品名称</th><th>商品价格</th><th>购买数量</th><th>操作</th></tr>';
				
				if(data.size <=0){
					$('#submit').hide();
				}else{
					$('#submit').show();
				}
				
				
				data.shoppingCart.shoppingCartItemsList.map(function(item,index){
					
				
					
					shoppingHTML +='<tr class="removeshopping">'
								 +'<td class="thumb">'
								 +'<img src="/Ebuy'+item.product.proPic+'" width="70px" height="50px"/><a href="/Ebuy/toproductview?productId='+item.product.productId+'">'+item.product.productName+'</a></td>'
								 +'	<td class="price" id="price_id_1">'
								 +'<span id="price">￥'+item.product.price+'</span> <input type="hidden" value="'+item.product.price+'" /></td>'
								 +'	<td class="number">'
								 +'<dl>'
								 +'<dt><input id="number_id_1" type="text" name="number" value="'+item.count+'" /></dt>'
								 +'</dl></td>'
								 +'<td class="delete"><a class="remove" data-id="'+index+'"  href="#">删除</a></td>'
								 +'</tr>';
					priceproduct =item.product.price * item.count +priceproduct;
					
				});
				
				$('.buttoncalc').append('<div style="color: red; font-size: 20px;">总计：￥'+priceproduct+'元</div>');
				
				$('#shoppingCart').html(shoppingHTML);
				
			}else{
				alert(data.errorMsg);
			}
			
		});
		
	}

	
	
	$('#shoppingCart').on('click','.removeshopping .remove',function(e){
		
		var target = $(e.currentTarget);
		
			$.getJSON('/Ebuy/fronted/removeproduct/'+e.currentTarget.dataset.id, function(data){
				if(data.success){
					getShopppingCartList();
				}else{
					alert(data.errorMsg)
				}
			});
		
		
	});
	
	
	$('#submit').click(function(){
		var fromShoppingCart =true;
		var formData = new FormData();
		formData.append("fromShoppingCart",fromShoppingCart);
		$.ajax({
			url:addOrderInfo,
			type:"POST",
			data:formData,
			contentType :false,
			processData : false,
			cache : false,
			success: function(data){
				if(data.success){		
					window.location.href='/Ebuy/tofrontedorder';
				}else {
					alert(data.errorMsg);
				} 
			}
		});
		
		
	});
	
	
/*
 * $('#submit').click(function(){ var fromShoppingCart =true;
 * 
 * $.ajax({ url:addOrderInfo, type:"POST", data:fromShoppingCart, contentType :
 * 'application/text', success: function(data){ if(data.success){
 * window.location.href='/Ebuy/tofrontedorder'; }else { alert(data.errorMsg); }
 * }); });
 */
});
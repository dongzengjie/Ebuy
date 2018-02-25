$(function(){

	var productId= getQueryString('productId');
	var productinfo='/Ebuy/fronted/getproductinfo/'+productId;

	var addshopcart='/Ebuy/fronted/shoppingCart';
	var productitem='';
	var addOrderInfo ='/Ebuy/fronted/addOrderInfo';
	
	$.getJSON(productinfo,function(data){
		
		if(data.success){
			var categoryHTML='';
			var productHTML='';
			data.bigtypeList.map(function(item,index){
				categoryHTML +='<dt>'+item.bigName+'</dt>';
				
				item.smalltypelist.map(function(item,index){
					categoryHTML +='<dd><a href="/Ebuy/tofrontedproductlist?smalltypeId='+item.smalltypeId+'&pageindex=0">'+item.smallName+'</a></dd>';
				});
			});
			
			productitem =data.product;
			productHTML ='<h1>'+productitem.productName+'</h1>'
						+'<div class="infos">'
						+'<div class="thumb"><img src="/Ebuy'+productitem.proPic+'" width="300px" height="300px"/></div>'
						+'<div class="buy">'
						+'<p>商城价：<span class="price">'+productitem.price+'</span></p>'
						+'<p>库　存：'+productitem.stock+'</p>'
						+'<p>分　类：'+productitem.smalltype.smallName+'</p>'
						+'<div class="button"><input type="button" id="button" value="" /><a href="#" class="submitaddshopcart">放入购物车</a></div>'
						+'</div>'
						+'<div class="clear"></div>'
						+'</div>'
						+'<div class="introduce">'
						+'<h2><strong>商品详情</strong></h2>'
						+'<div class="text">'+productitem.description+'</div>'
						+'</div>';
			
			
			
			$('#category').html(categoryHTML);
			$('#product').html(productHTML);
		}else{
			alert(data.errorMsg);
		}
	});
	
	
	$("#product").delegate("#button","click",function(){
		var product={};
		product.productId=productitem.productId;
		product.productName=productitem.productName;
		product.proPic=productitem.proPic;
		product.price=productitem.price;
		product.stock=productitem.stock;
		product.smalltype=productitem.smalltype;
		product.description=productitem.description;
		
		var fromShoppingCart =false;
		var formData = new FormData();
		formData.append("fromShoppingCart",fromShoppingCart);
		formData.append("productStr",JSON.stringify(product));
		
		
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
	
	

	
	
	$('#product').on('click','a',function(e){
		var target = $(e.currentTarget);
		if (target.hasClass('submitaddshopcart')) {
			
			
			var product={};
			product.productId=productitem.productId;
			product.productName=productitem.productName;
			product.proPic=productitem.proPic;
			product.price=productitem.price;
			product.stock=productitem.stock;
			product.smalltype=productitem.smalltype;
			product.description=productitem.description;
			
			$.ajax({
				
				url:addshopcart,
				type : 'POST',
				data:JSON.stringify(product),
				contentType : 'application/json',
				success: function(data){
					if(data.success){
						alert("添加成功");
					}else{
						alert(data.errorMsg);
					}
				}
			});
			
		}
	});
	
	
	
});
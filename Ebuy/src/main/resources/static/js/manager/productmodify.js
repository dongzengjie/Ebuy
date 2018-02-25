$(function(){
	var productId=getQueryString("productId");
	
	var getproductinfoUrl='/Ebuy/manager/queryProductById/'+productId;
	var productmodify='/Ebuy/manager/modifyProduct'
	
	getproduct();
	
	function getproduct(e){
		$.getJSON(getproductinfoUrl,function(data){
			
			if(data.success){
				var product =data.product;
				$('#productName').val(product.productName);
				$('#description').val(product.description);
				$('#price').val(product.price);
				$('#stock').val(product.stock);
				$('#specialtime').val(product.specialPriceTime);
				$('#hottime').val(product.hotTime);
				
				var tempHTML= '';
				data.smalltypeList.map(function(item,index){
					tempHTML +='<option data-id="'+item.smalltypeId+'">'+item.smallName+'</option>'
				});
				$('#parentId').html(tempHTML);
				$("#parentId option[data-id='"+product.smalltype.smalltypeId+"']").attr('selected','selected');
				
			}else{
				alert(data.errorMsg);
			}
		});
		
	};
	
	
	
	
	
	$('#submit').click(function(){
		var product={};
		product.productId=productId;
		product.productName=$('#productName').val();
		product.description=$('#description').val();
		product.specialPriceTime=$('#specialtime').val();
		product.hotTime=$('#hottime').val();
		product.smalltype={
				smalltypeId:$('#parentId').find('option').not(function(){
					return !this.selected;
				}).data('id')
		};
		var productImg =$('#product-img')[0].files[0];
		product.price=$('#price').val();
		product.stock=$('#stock').val();
		var formData = new FormData();
		formData.append("productImg", productImg);
		formData.append('productStr', JSON.stringify(product));
		
		$.ajax({
			url:productmodify,
			type:'POST',
			data:formData,
		
			contentType : false,
			processData : false,
			cache : false,
			success: function(data){
				if(data.success){
					window.location.href='/Ebuy/toproduct?pageIndex=0';
				}else{
					alert(data.errorMsg);
				}
			}
		});
		
	});
});
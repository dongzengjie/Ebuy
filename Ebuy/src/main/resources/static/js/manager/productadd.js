$(function() {
	var getsmalltypelist='/Ebuy/manager/getCategoryInfo';
	var addproductUrl='/Ebuy/manager/addProduct'
	
	getsmalltype();
	
	function getsmalltype(e){
		$.getJSON(getsmalltypelist,function(data){
			var tempHTML='';
			if(data.success){
				data.smalltypeList.map(function(item,index){
					tempHTML +='<option data-id="'+item.smalltypeId+'">'+item.smallName+'</option>'
				});
				$('#parentId').html(tempHTML);
				
			
			}
		});
	}
	
	$('#submit').click(function(){
		var product={};
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
			url:addproductUrl,
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



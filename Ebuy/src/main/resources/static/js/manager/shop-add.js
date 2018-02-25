$(function(){
	var getbigTypeUrl="/Ebuy/manager/getbigtype";
	var addshopUrl="/Ebuy/manager/addShop"

	$.getJSON(getbigTypeUrl,function(data){
		if(data.success){
			var tempHTML="";
			data.bigtypeList.map(function(item,index){
				tempHTML +='<option data-id="'+item.bigtypeId+'">'+item.bigName+'</option>'
			});
			$('#bigtype').html(tempHTML);
				
			
		}else {
			alert(data.errorMsg);
		}
	});
	
	
	$('#submit').click(function(){
		var shop={};
		shop.shopName=$('#name').val();
		shop.bigtype={
				bigtypeId:$('#bigtype').find('option').not(function(){
					return !this.selected;
				}).data('id')
				
					
		};
		
		$.ajax({
			url:addshopUrl,
			type:'POST',
			data:JSON.stringify(shop),
			contentType : 'application/json',
			success:function(data){
				if(data.success){
					
					window.location.href='/Ebuy/tomanagerresult';
				}else {
					alert(data.errorMsg);
				}
			}
		});
	});
	
});
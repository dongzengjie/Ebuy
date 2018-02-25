$(function(){
	var addcategory= '/Ebuy/manager/addcategory';
	var getCategoryInfo = '/Ebuy/manager/getCategoryInfo';

	$.getJSON(getCategoryInfo,function(data){
		if(data.success){
			
			$('#bigtype').html(data.bigtype);
		}
	});
	
	
	$('#submit').click(function(){
		var smalltype={};
		smalltype.smallName=$('#className').val();
		$.ajax({
			url:addcategory,
			type:'POST',
			data:JSON.stringify(smalltype),
			contentType:'application/json',
			success:function(data){
				if(data.success){
					window.location.href='/Ebuy/toproductClass'
				}else {
					alert(data.errorMsg);
				}
			}
		});
	});
	
});
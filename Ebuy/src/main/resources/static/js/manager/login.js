$(function(){
	var loginUrl='/Ebuy/manager/tomanagerlogin';
	

	$('#submit').click(function(){
		var user={};
		user.username=$('#username').val();
		
		user.password=$('#password').val();
		
		var vrifyCode=$('#vrifyCode').val();
		
		var formData = new FormData();
		formData.append('userStr', JSON.stringify(user));
		formData.append('vrifyCode',vrifyCode);
		
		$.ajax({
			url:loginUrl,
			type:"POST",
			data:formData,
			contentType : false,
			processData : false,
			cache : false,
			success: function(data){
				if(data.success){
					if(data.haveshop){
						window.location.href='/Ebuy/tomanageindex';
					}else {
						window.location.href='/Ebuy/toshopadd';
					}
					
				}else {
					alert(data.errorMsg);
					$('#vrifyCodeimg').click();
				}
			}
		});
		
		
	});
	
	
		
		
	
});
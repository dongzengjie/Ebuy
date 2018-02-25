$(function(){
	var loginUrl='/Ebuy/fronted/tologin';
	

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
						window.location.href='/Ebuy/tofrontedindex';
					
				}else {
					alert(data.errorMsg);
					$('#vrifyCodeimg').click();
				}
			}
		});
		
		
	});
	
	
		
		
	
});
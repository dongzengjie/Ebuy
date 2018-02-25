$(function(){
	var registerUrl='/Ebuy/fronted/frontedregistuser';
	


	$('#submit').click(function(){
		var user={};
		user.username=$('#username').val();
		user.trueName=$('#trueName').val();
		user.email=$('#email').val();
		user.mobile=$('#mobile').val();
		user.password=$('#password').val();
		user.address=$('#address').val();
		var vrifyCode=$('#vrifyCode').val();
		
		var formData = new FormData();
		formData.append('userStr', JSON.stringify(user));
		formData.append('vrifyCode',vrifyCode);
		
		$.ajax({
			url:registerUrl,
			type:"POST",
			data:formData,
			contentType : false,
			processData : false,
			cache : false,
			success: function(data){
				if(data.success){
					window.location.href='/Ebuy/tofrontedlogin';
				}else {
					alert(data.errorMsg);
					$('#vrifyCodeimg').click();
				}
			}
		});
		
		
	});
	
	
		
		
	
});
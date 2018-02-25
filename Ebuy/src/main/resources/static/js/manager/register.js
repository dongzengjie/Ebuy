$(function(){
	var registerUrl='/Ebuy/manager/managerregistuser';
	

	$('#submit').click(function(){
		var user={};
		user.username=$('#username').val();
		user.trueName=$('#trueName').val();
		user.email=$('#email').val();
		user.mobile=$('#mobile').val();
		user.password=$('#password').val();
		
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
					window.location.href='/Ebuy/tologin';
				}else {
					alert(data.errorMsg);
					$('#vrifyCodeimg').click();
				}
			}
		});
		
		
	});
	
	
		
		
	
});
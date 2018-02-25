$(function(){
	var smalltypeId= getQueryString('smalltypeId');
	var modifycategory= '/Ebuy/manager/updateSmalltype';
	var getCategoryInfo = '/Ebuy/manager/querySmallTypeAndBigType?smalltypeId='+smalltypeId;

	$.getJSON(getCategoryInfo,function(data){
		if(data.success){
			$('#bigtype').html(data.bigtype);
			$('#className').val(data.smalltype);
		}
	});
	
	
	$('#submit').click(function(){
		var smalltype={};
		smalltype.smalltypeId=smalltypeId;
		smalltype.smallName=$('#className').val();
		$.ajax({
			url:modifycategory,
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
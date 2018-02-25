$(function(){

	var smalltypeId= getQueryString('smalltypeId');
	var pageindex=getQueryString('pageindex');
	var getproductList='/Ebuy/fronted/getproductListBySmallId/'+smalltypeId+'/'+pageindex;
	
	$.getJSON(getproductList,function(data){
		if(data.success){
			
			var categoryHTML='';
			
			var productHTML='';
			var pageHTML = '';
			if (data.count / 12 == 0) {
				data.count = 1;
			}
			for (var i = 1; i <= Math.ceil(data.count / 12); i++) {
				if (pageindex == i) {
					pageHTML += '<li class="current"><a href="/Ebuy/tofrontedproductlist?smalltypeId='+smalltypeId+'&pageindex='
							+ i + '">' + i + '</a></li>';
				} else {
					pageHTML += '<li><a href="/Ebuy/tofrontedproductlist?smalltypeId='+smalltypeId+'&pageindex='
					+ i + '">' + i + '</a></li>';
				}

			}
			
			data.productList.map(function(item,index){
				
				productHTML += '<li><dl><dt><a href="/Ebuy/toproductview?productId='
					+ item.productId
					+ '" target="_blank">'
					+ '<img src="/Ebuy'+item.proPic+'" width="70px" height="80px"/></a></dt>'
					+'<dd class="title"><a href="/Ebuy/toproductview?productId='+item.productId+'" target="_blank">'+item.description+'</a></dd>'
					+'<dd class="price">￥'+item.price+'</dd></dl></li>';
				
			});
			
			data.bigtypeList.map(function(item,index){
				categoryHTML +='<dt>'+item.bigName+'</dt>';
				
				item.smalltypelist.map(function(item,index){
					categoryHTML +='<dd><a href="/Ebuy/tofrontedproductlist?smalltypeId='+item.smalltypeId+'&pageindex=0">'+item.smallName+'</a></dd>';
				});
			});
			
			$('#category').html(categoryHTML);
			$('#productList').html(productHTML);
			$('#page1').html(pageHTML);
			$('#page2').html(pageHTML);
			
		}else{
			alert(data.errorMsg);
		}
	});
	
});
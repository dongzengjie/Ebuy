$(function() {
	var getfrontindexinfo = '/Ebuy/fronted/getFrontIndexInfo';

	$
			.getJSON(
					getfrontindexinfo,
					function(data) {
						if (data.success) {
							var specialpriceHTML = '';
							var hotpriceHTML='';
							var categoryHTML='';
								
							data.productSpecialList
									.map(function(item, index) {
										specialpriceHTML += '<li><dl><dt><a href="/Ebuy/toproductview?productId='
												+ item.productId
												+ '" target="_blank">'
												+ '<img src="/Ebuy'+item.proPic+'" width="70px" height="80px"/></a></dt>'
												+'<dd class="title"><a href="/Ebuy/toproductview?productId='+item.productId+'" target="_blank">'+item.description+'</a></dd>'
												+'<dd class="price">￥'+item.price+'</dd></dl></li>';
									});
							data.productHotList.map(function(item,index){
								hotpriceHTML += '<li><dl><dt><a href="/Ebuy/toproductview?productId='
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
							
							
							$('#hotprice').html(hotpriceHTML);
							$('#specialprice').html(specialpriceHTML);
							$('#category').html(categoryHTML);
							

						} else {
							alert(data.errorMsg);
						}
					});
});
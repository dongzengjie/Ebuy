$(function() {

	var pageIndex = getQueryString("pageIndex");
	var getproductlist = '/Ebuy/manager/queryProductList?pageIndex='
			+ pageIndex + '&pageSize=4';

	var modifyenable = '/Ebuy/manager/modifyProduct';

	getList();
	function getList(e) {
		$
				.getJSON(
						getproductlist,
						function(data) {
							if (data.success) {
								
								var tempHTML = '';
								var pageHTML = '';
								if (data.count / 4 == 0) {
									data.count = 1;
								}
								for (var i = 1; i <= Math.ceil(data.count / 4); i++) {
									if (pageIndex == i) {
										pageHTML += '<li class="current"><a href="/Ebuy/toproduct?pageIndex='
												+ i + '">' + i + '</a></li>';
									} else {
										pageHTML += '<li><a href="/Ebuy/toproduct?pageIndex='
												+ i + '">' + i + '</a></li>';
									}

								}

								tempHTML += '<tr><th>ID</th>	<th>商品名称</th><th>操作</th></tr>';
								data.productList
										.map(function(item, index) {

											var textOp = "上架";
											var contraryStatus = 0;
											if (item.enableStatus == 0) {
												var textOp = "下架";
												var contraryStatus = 1;
											} else {
												var contraryStatus = 0;
											}

											tempHTML += '<tr><td class="first w4 c">'
													+ index
													+ '</td>'
													+ '<td class="thumb">'
													+ '<img src="/Ebuy'
													+ item.proPic
													+ '"  width="70px" height="50px"/>'
													+ '<a href="/Ebuy/toproductview?productId='
													+ item.productId
													+ '" target="_blank">'
													+ item.productName
													+ '</a></td>'
													+ '<td class="w1 c"><a href="/Ebuy/toproductmodify?productId='
													+ item.productId
													+ '">修改</a>  <a href="" class="delete" data-id="'
													+ item.productId
													+ '" data-status="'
													+ contraryStatus
													+ '">'
													+ textOp + '</a></td></tr>';

										});

								$('.list').html(tempHTML);

								$('#pagecontext').html(pageHTML);

							} else {
								alert(data.errorMsg);
							}
						});
	}

	$('.list').on(
			'click',
			'a',
			function(e) {
				var target = $(e.currentTarget);
				if (target.hasClass('delete')) {
					deleteItem(e.currentTarget.dataset.id,
							e.currentTarget.dataset.status);
				}
			});

	function deleteItem(id, enableStatus) {
		var product = {};
		product.productId = id;
		product.enableStatus = enableStatus;

		$.ajax({
			url : modifyenable,
			type : 'POST',
			data : {
				productStr : JSON.stringify(product),
				
			},
			dataType : 'json',
			success : function(data) {
				if (data.success) {
				
					getList();
				} else {
					alert("操作失败"+data.errorMsg);
				}
			}

		});
	}

});

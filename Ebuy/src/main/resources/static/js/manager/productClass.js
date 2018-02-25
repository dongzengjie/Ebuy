$(function() {
	var getCategoryInfo = '/Ebuy/manager/getCategoryInfo';

	$
			.getJSON(
					getCategoryInfo,
					function(data) {
						if (data.success) {
							var tempHTML = '';
							tempHTML = '<tr><th>ID</th><th>分类名称</th><th>操作</th></tr><tr><td class="first w4 c"></td><td id="bigtype">'
									+ data.bigtype + '</td><td></td></tr>';
							data.smalltypeList
									.map(function(item, index) {
										tempHTML += '<tr>'
												+ '<td class="first w4 c">'
												+ index
												+ '</td>'
												+ '<td class="childClass">'
												+ item.smallName
												+ '</td>'
												+ '<td class="w1 c"><a href="/Ebuy/toproductClassmodify?smalltypeId='+item.smalltypeId+'" class="modify" data-id='
												+ item.smalltypeId
												+ '>修改</a><a href="" class="delete" data-id='
												+ item.smalltypeId
												+ '>   删除</a></td>'
									});
							$('#categoryList').html(tempHTML);

						} else {
							alert(data.errorMsg);
						}
					});
});
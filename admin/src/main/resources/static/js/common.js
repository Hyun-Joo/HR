function commonAjax(paramData, url, fnCallBack){
	$.ajax({
		url : url,
		data : paramData,
		type : "post", 
		dataType : "json" 
	})
	.done(function(result) {
		if(typeof fnCallBack =='function' ){
			fnCallBack(result,paramData);
		}
	})
	.fail(function(xhr, status, errorThrown) {
		alert('오류로 인해 처리되지 않았습니다.\n새로고침을 실행합니다.');
		location.reload(true);
		})
	.always(function(xhr, status) {
	});
}
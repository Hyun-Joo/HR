var isPossibleId = false;

function fnCheckId(){
	var param = {};
		param.mbAcc = $('input[name=mbAcc]').val();
	
	var actionUrl = '/member/id/check';
	
	if(isEmpty(param.mbAcc)){
		$('#idCheck').css('display','block');
		$('#idCheck').css('color','#ff6600');
		$('#idCheck').html('아이디를 입력해 주세요.');
	}else{
		commonAjax(param, actionUrl, fnIdCheckCallBack);
	}
	return isPossibleId;
}

function fnIdCheckCallBack(result){
	console.log(result);
	if(result != 0){
		$('#idCheck').css('display','block');
		$('#idCheck').css('color','#ff6600');
		$('#idCheck').html('사용할 수 없는 아이디입니다.');
	}else if(result == 0){
		$('#idCheck').css('display','block');
		$('#idCheck').css('color','#33cc33');
		$('#idCheck').html('사용 가능한 아이디입니다.');
		isPossibleId = true;
	}
}
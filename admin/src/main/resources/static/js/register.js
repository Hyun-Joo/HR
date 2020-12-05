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

function fnPwdCheck(){
	var isPassword = false;
	var $mbAcc = $('input[name=mbAcc]');
	var $mbPwd = $('input[name=mbPwd]');
	if(isEmpty($mbPwd.val())){
		$('#pwCheck').show();
		$('#pwCheck').css('color','#ff6600');
		$('#pwCheck').html('비밀번호를 입력해 주세요.');
	}else if($mbAcc.val() == $mbPwd.val()){
		$('#pwCheck').show();
		$('#pwCheck').css('color','#ff6600');
		$('#pwCheck').html('비밀번호를 입력해 주세요.');
	}else if(!/[~!@#$%^&*()_+|<>?:{}]/.test($mbPwd.val())){
		$('#pwCheck').show();
		$('#pwCheck').css('color','#ff6600');
		$('#pwCheck').html('비밀번호는 영문, 숫자, 특수문자 혼합 6~20자로 해주세요.');
	}else if($mbPwd.val().length < 6 || $mbPwd.val().length > 20){
		$('#pwCheck').show();
		$('#pwCheck').css('color','#ff6600');
		$('#pwCheck').html('비밀번호 길이가 맞지 않습니다.');
	}else{
		$('#pwCheck').show();
		$('#pwCheck').css('color','#33cc33');
		$('#pwCheck').html('사용 가능한 비밀번호입니다.');
		isPassword = true;
	}
	return isPassword;
}

$(document).on('input', function(){
	var mbNm = $('input[name=mbNm]').val();
	var mbAcc = $('input[name=mbAcc]').val();
	var mbEmail = $('input[name=mbEmail]').val();
	var mbPwd = $('input[name=mbPwd]').val();
	var mbTel = $('input[name=mbTel]').val();
	
	if(mbNm && mbAcc && mbEmail && mbPwd && mbTel){
		$('#register').attr('disabled', false);
	}else{
		$('#register').attr('disabled', true);
	}
})

function fnRegister(){
	event.preventDefault();
	
	var param = {};
		param.mbNm = $('input[name=mbNm]').val();
		param.mbAcc = $('input[name=mbAcc]').val();
		param.mbEmail = $('input[name=mbEmail]').val();
		param.mbPwd = $('input[name=mbPwd]').val();
		param.mbTel = $('input[name=mbTel]').val();
		
	if(!isPossibleId){
		alert('아이디 체크를 완료해 주세요.');
		$('input[name=mbAcc]').focus();
		return false;
	}
	if(!fnPwdCheck()){
		alert('비밀번호를 확인해 주세요.');
		$('input[name=mbPwd]').focus();
		return false;
	}
	if(param.mbTel.length < 10 || param.mbTel.length > 11){
		alert('연락처를 확인해 주세요.');
		$('input[name=mbTel]').focus();
		return false;
	}
	
	commonAjax(param, '/member/register', function(result){
		console.log(result);
		
		if(!isEmpty(result.validation)){
			alert('이미 등록된 회원입니다.');
		}else if(result.isJoinComplete){
			alert('등록이 완료되었습니다.');
			location.href = '/';
		}else{
			alert('등록에 실패하였습니다.');
			//location.reload(true);
		}
	});
}
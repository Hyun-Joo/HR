package com.hr.admin.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.admin.dao.MemberDao;
import com.hr.admin.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;

	@Override
	public Integer idCheck(String mbAcc) {
		Integer result = 0;
		try {
			result = memberDao.idCheck(mbAcc);
		} catch (Exception e) {
			log.error("아이디 유효체크 실패: {}",e.getMessage());
		}
		return result;
	}
	
	@Override
	@Transactional
	public Map<String, Object> register(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		Integer joinResult = 0;
		boolean isJoinComplete = false;
		try {
			String validation = checkValidation(param);
			if(StringUtils.isNotBlank(validation)) {
				result.put("validation", validation);
				return result;
			}
			
			param.put("mbUseYn", "Y");
			joinResult = memberDao.register(param);
			result.put("joinResult", joinResult);
			if(joinResult > 0) {
				isJoinComplete = true;
			}
			result.put("isJoinComplete", isJoinComplete);
		} catch (Exception e) {
			log.error("회원 등록 실패! => {}",e.getMessage());
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public String checkValidation(Map<String, Object> param) {
		String result = "";
		try {
			if(param != null) {
				Map<String,Object> dupMember = memberDao.getMemberInfo(param);
				if(dupMember != null) {
					result = "DUP_MB";
				}
			}
		} catch (Exception e) {
			log.error("중복가입 여부 확인 실패: {}",e.getMessage());
		}
		return result;
	}

}

package com.hr.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

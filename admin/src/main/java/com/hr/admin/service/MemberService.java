package com.hr.admin.service;

import java.util.Map;

public interface MemberService {
	
	public Integer idCheck(String mbAcc);
	
	public String checkValidation(Map<String, Object> param);

	public Map<String, Object> register(Map<String, Object> param);

}

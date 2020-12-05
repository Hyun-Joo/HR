package com.hr.admin.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberDao {
	
	 Integer idCheck(String mbAcc);
	 
	 Map<String,Object> getMemberInfo(Map<String,Object> param);

	 Integer register(Map<String, Object> param);

}

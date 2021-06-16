package com.test.dao;

import java.util.List;
import com.test.vo.userVO;

public interface userDAO {
	public List<userVO> selectuser() throws Exception; // Dao에서 Mybatis를 호출하고 VO값을 담아 서비스에 보낸다
}

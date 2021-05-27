package com.test.dao;

import java.util.List;
import com.test.vo.userVO;

public interface userDAO {
	public List<userVO> selectuser() throws Exception;
}

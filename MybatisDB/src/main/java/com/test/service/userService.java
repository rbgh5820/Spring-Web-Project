package com.test.service;

import java.util.List;
import com.test.vo.userVO;

public interface userService {
	public List<userVO> selectuser() throws Exception;
}

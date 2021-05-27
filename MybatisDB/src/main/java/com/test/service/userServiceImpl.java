package com.test.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.test.vo.userVO;

import javax.inject.Inject;
import com.test.dao.userDAO;

@Service
public class userServiceImpl implements userService {

	@Inject
	private userDAO dao;
	
	@Override
	public List<userVO> selectuser() throws Exception {
		return dao.selectuser();
	}

}

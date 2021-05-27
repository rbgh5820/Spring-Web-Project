package com.test.dao;

import java.util.List;
import com.test.vo.userVO;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class userDAOImpl implements userDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String Namespace="com.test.mybatis.sql.test";
	
	@Override
	public List<userVO> selectuser() throws Exception {
		
		return sqlSession.selectList(Namespace+".selectuser");
	}
	
}

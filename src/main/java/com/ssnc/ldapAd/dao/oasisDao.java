package com.ssnc.ldapAd.dao;

import com.ssnc.ldapAd.vo.empVo;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class oasisDao {
	protected static final String NAMESPACE = "com.ssnc.ldapAd.dao.oasisDao.";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    @Qualifier("sqlSession")
	private SqlSession sqlSession;
	
	//인사정보 insert
	public int deleteOasistemp() {
		logger.debug("deleteOasistemp DAO >> ");
		return sqlSession.delete(NAMESPACE + "deleteOasistemp");
	}

	public int insertEmpVo(empVo empvo) {
		return sqlSession.insert(NAMESPACE + "insertEmpVo", empvo);
	}

	public List<empVo> selectEmpVo() {
		return sqlSession.selectList(NAMESPACE + "selectEmpVo");
	}
	
}

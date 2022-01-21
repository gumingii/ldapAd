package com.ssnc.ldapAd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssnc.ldapAd.dao.oasisDao;
import com.ssnc.ldapAd.vo.empVo;

import java.util.List;

@Service
public class oasisServiceImpl implements oasisServiceInterface {
	
	@Autowired
	private oasisDao oasisdao;

	@Override
	public void addEmpVo(empVo empvo) {
		oasisdao.insertEmpVo(empvo);
	}

	@Override
	public List<empVo> getEmpVo() {
		List<empVo> empVoList = oasisdao.selectEmpVo();
		return null;
	}
}

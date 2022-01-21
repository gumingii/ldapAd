package com.ssnc.ldapAd.service;

import com.ssnc.ldapAd.vo.empVo;

import java.util.List;

public interface oasisServiceInterface {

    public void addEmpVo(empVo empvo);

    public List<empVo> getEmpVo();

}

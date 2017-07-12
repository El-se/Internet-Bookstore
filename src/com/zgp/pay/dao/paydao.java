package com.zgp.pay.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zgp.dao.DingdanMapper;
import com.zgp.domain.Dingdan;

@Repository
public class paydao {
	@Autowired
	private DingdanMapper mapper;

	public Dingdan selectdingdan(String oid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(oid);
	}

	public void selectbyoid(String oid) {
		// TODO Auto-generated method stub
		Dingdan dingdan = mapper.selectByPrimaryKey(oid);
		dingdan.setStatus(2);
		mapper.updateByPrimaryKey(dingdan);
	}
	
	
}

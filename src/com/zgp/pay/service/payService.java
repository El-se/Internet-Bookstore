package com.zgp.pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgp.domain.Dingdan;
import com.zgp.pay.dao.paydao;

@Service
public class payService {
	@Autowired
	private paydao paydao;

	public Dingdan selectdingdan(String oid) {
		// TODO Auto-generated method stub
		return paydao.selectdingdan(oid);
	}

	public void selectbyoid(String oid) {
		// TODO Auto-generated method stub
		paydao.selectbyoid(oid);
	}

	

	
}

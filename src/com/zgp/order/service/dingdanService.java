package com.zgp.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgp.domain.Dingdan;
import com.zgp.order.PoVo.dingdanPoVo;
import com.zgp.order.dao.dingdanDao;

@Service
public class dingdanService {
	@Autowired
	private dingdanDao dingdanDao;

	public void addDingdan(String[] ids, Dingdan dingdan) {
		// TODO Auto-generated method stub
		dingdanDao.addDingdan(ids,dingdan);
	}

	public List<dingdanPoVo> getDingdans(String uid) {
		// TODO Auto-generated method stub
		return dingdanDao.getDingdans(uid);
	}

	public dingdanPoVo getDingdan(String oid) {
		// TODO Auto-generated method stub
		return dingdanDao.getDingdan(oid);
	}

	public void updateStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		dingdanDao.updateStatus(map);
	}
}

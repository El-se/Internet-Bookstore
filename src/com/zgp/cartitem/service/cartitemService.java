package com.zgp.cartitem.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zgp.cartitem.dao.cartitemDao;
import com.zgp.cartitem.povo.cartitemPovo;
import com.zgp.dao.CartItemMapper;
import com.zgp.domain.CartItem;
import com.zgp.domain.CartItemExample;
import com.zgp.domain.User;

@Service
public class cartitemService {
	@Autowired
	private cartitemDao dao;

	public List<cartitemPovo> selectcartitemByUid(String uid) {
		// TODO Auto-generated method stub
		return dao.selectcartitemByUid(uid);
	}

	public void deletecartitemByid(String cartitemid) {
		// TODO Auto-generated method stub
		dao.deletecartitemByid(cartitemid);
	}

	public void addcartitem(CartItem cartItem, User u, String bid, Integer quantity) {
		// TODO Auto-generated method stub
		dao.addcartitem(cartItem,u,bid,quantity);
	}

	public void updatacartitemjianone(String cartitemid) {
		// TODO Auto-generated method stub
		dao.updatacartitemjianone(cartitemid);
	}

	public void updatacartitemaddone(String cartitemid) {
		// TODO Auto-generated method stub
		dao.updatacartitemaddone(cartitemid);
	}

	public void deletecartitems(String[] ids, String uid) {
		// TODO Auto-generated method stub
		dao.deletecartitems(ids,uid);
	}

	public List<cartitemPovo> jiesuan(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.jisuan(map);
	}
	
}

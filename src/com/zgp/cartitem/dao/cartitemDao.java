package com.zgp.cartitem.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.zgp.cartitem.povo.cartitemPovo;
import com.zgp.dao.CartItemMapper;
import com.zgp.domain.CartItem;
import com.zgp.domain.CartItemExample;
import com.zgp.domain.CartItemExample.Criteria;
import com.zgp.domain.User;

@Repository
public class cartitemDao {
	@Autowired
	private CartItemMapper mapper;

	public List<cartitemPovo> selectcartitemByUid(String uid) {
		// TODO Auto-generated method stub
		return mapper.selectcartitemByUid(uid);
	}

	public void deletecartitemByid(String cartitemid) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(cartitemid);
	}

	public void addcartitem(CartItem cartItem, User u, String bid, Integer quantity) {
		// TODO Auto-generated method stub
		CartItemExample example  = new CartItemExample();
		example.createCriteria().andUidEqualTo(u.getUid()).andBidEqualTo(bid);
		List<CartItem>  list=mapper.selectByExample(example);
		if(list==null || list.size()==0){
			mapper.insert(cartItem);
		}else{
			list.get(0).setQuantity(quantity+list.get(0).getQuantity());
			mapper.updateByPrimaryKey(list.get(0));	
		}
	}

	public void updatacartitemjianone(String cartitemid) {
		// TODO Auto-generated method stub
		CartItemExample example = new CartItemExample();
		example.createCriteria().andCartitemidEqualTo(cartitemid);
		List<CartItem> cartitems = mapper.selectByExample(example);
		
		Integer upQuantity = cartitems.get(0).getQuantity();
		cartitems.get(0).setQuantity(upQuantity-1);
		mapper.updateByPrimaryKey(cartitems.get(0));
	}

	public void updatacartitemaddone(String cartitemid) {
		// TODO Auto-generated method stub
		CartItemExample example = new CartItemExample();
		example.createCriteria().andCartitemidEqualTo(cartitemid);
		List<CartItem> cartitems = mapper.selectByExample(example);
		
		Integer upQuantity = cartitems.get(0).getQuantity();
		cartitems.get(0).setQuantity(upQuantity+1);
		mapper.updateByPrimaryKey(cartitems.get(0));
	}

	public void deletecartitems(String[] ids, String uid) {
		// TODO Auto-generated method stub
		/*java.util.Map<String ,  Object >   map  = new java.util.HashMap<String, Object>();
		map.put("ids", ids);
		map.put("uid", uid);
		mapper.delete2(map);*/
		CartItemExample example = new CartItemExample();
		example.createCriteria().andCartitemidIn(Arrays.asList(ids)).andUidEqualTo(uid);
		mapper.deleteByExample(example);
		System.out.println("---------------------------------------"+mapper.countByExample(example));
	}

	public List<cartitemPovo> jisuan(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.jiesuan(map);
	}
	
}

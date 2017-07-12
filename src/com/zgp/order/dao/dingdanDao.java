package com.zgp.order.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zgp.cartitem.povo.cartitemPovo;
import com.zgp.dao.CartItemMapper;
import com.zgp.dao.DingdanMapper;
import com.zgp.dao.OrderitemMapper;
import com.zgp.domain.Dingdan;
import com.zgp.domain.Orderitem;
import com.zgp.order.PoVo.dingdanPoVo;

import uuid.UUIDHelper;

@Repository
public class dingdanDao {
	@Autowired
	private DingdanMapper mapper;
	@Autowired
	private CartItemMapper cMapper;
	@Autowired
	private OrderitemMapper mapper2;
	public void addDingdan(String[] ids, Dingdan dingdan) {
		// TODO Auto-generated method stub
		mapper.insert(dingdan);
		for (String cartitemid : ids) {
			Orderitem orderitem = new Orderitem();
			cartitemPovo povo = cMapper.selectCartItemPoVoByCartitemid(cartitemid);
			cMapper.deleteByPrimaryKey(cartitemid);
			orderitem.setBid(povo.getBid());
			orderitem.setBname(povo.getBook().getBname());
			orderitem.setCurrprice(povo.getBook().getCurrprice());
			orderitem.setImageB(povo.getBook().getImageB());
			orderitem.setOid(dingdan.getOid());
			orderitem.setOrderitemid(UUIDHelper.getUUID());
			orderitem.setQuantity(povo.getQuantity());
			orderitem.setSubtotal(new BigDecimal(povo.getSubTotal()));
			mapper2.insert(orderitem);
		}
		
	}
	public List<dingdanPoVo> getDingdans(String uid) {
		// TODO Auto-generated method stub
		return mapper.selectDingdanByUid(uid);
	}
	public dingdanPoVo getDingdan(String oid) {
		// TODO Auto-generated method stub
		return mapper.selectbyoid(oid);
	}
	public void updateStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		mapper.updateStatus(map);
	}

}

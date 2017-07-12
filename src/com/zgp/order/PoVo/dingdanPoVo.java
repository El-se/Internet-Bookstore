package com.zgp.order.PoVo;

import java.util.List;

import com.zgp.domain.CartItem;
import com.zgp.domain.Dingdan;
import com.zgp.domain.Orderitem;

public class dingdanPoVo extends Dingdan {

	private List<Orderitem> orderitems;

	public dingdanPoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public dingdanPoVo(List<Orderitem> orderitems) {
		super();
		this.orderitems = orderitems;
	}

	@Override
	public String toString() {
		return "dingdanPoVo [orderitems=" + orderitems + ", toString()=" + super.toString() + "]";
	}

	public List<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
	

}

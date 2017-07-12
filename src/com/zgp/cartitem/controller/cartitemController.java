package com.zgp.cartitem.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zgp.cartitem.povo.cartitemPovo;
import com.zgp.cartitem.service.cartitemService;
import com.zgp.domain.CartItem;
import com.zgp.domain.User;

import uuid.UUIDHelper;

@Controller
public class cartitemController {
	@Autowired
	private cartitemService service;
	@RequestMapping(value="/getcartitem/{uid}")
	public String getcartitem(@PathVariable String uid,Model model){
		List<cartitemPovo> povos = service.selectcartitemByUid(uid);
		model.addAttribute("cartItems", povos);
		return "jsps/cart/list";
	}
	
	@RequestMapping(value="/delete/{cartitemid}")
	public String deleteCartItemById(@PathVariable String cartitemid,Model model,HttpSession session){
		service.deletecartitemByid(cartitemid);
		User User = (com.zgp.domain.User) session.getAttribute("user");
		String uid = User.getUid();
		return "redirect:/getcartitem/"+uid;
	}
	
	@RequestMapping(value="/addcartitem/{bid}")
	public String addcartitem(@PathVariable String bid,Integer quantity,HttpSession session,Model model){
		String  cartitemid =  UUIDHelper.getUUID();
		CartItem  cartItem  = new CartItem();
		cartItem.setCartitemid(cartitemid);
		cartItem.setBid(bid);
		cartItem.setQuantity(quantity);
		User u   =(User)session.getAttribute("user");
		cartItem.setUid(u.getUid());
		service.addcartitem(cartItem,u,bid,quantity);
		return  "redirect:/getcartitem/"+u.getUid();
	}
	
	@RequestMapping(value="/updatajian/{cartitemid}")
	public String updatajian(@PathVariable String cartitemid,HttpSession session){
		service.updatacartitemjianone(cartitemid);
		User u   =(User)session.getAttribute("user");
		return  "redirect:/getcartitem/"+u.getUid();
	}
	
	@RequestMapping(value="/updatajia/{cartitemid}")
	public String updatajia(@PathVariable String cartitemid,HttpSession session){
		service.updatacartitemaddone(cartitemid);
		User u   =(User)session.getAttribute("user");
		return  "redirect:/getcartitem/"+u.getUid();
	}
	
	@RequestMapping (value="/deletecartitems")
	public  String  deletecartitems(String[] ids,HttpSession  session,Model model){
		User  user = (User)session.getAttribute("user");
		String uid  =user.getUid();
		service.deletecartitems(ids,uid);
		return  "redirect:/getcartitem/"+uid;
	}

	@RequestMapping (value="/jiesuan/{ids}" ,method=RequestMethod.POST)
	public String jiesuan(@PathVariable  String [] ids,Model  model,HttpSession session){
		
		Map<String,Object>  map  = new HashMap<String, Object>();
		map.put("uid", ((User)session.getAttribute("user")).getUid());
		map.put("ids", Arrays.asList(ids));
		List<cartitemPovo>  povos =service.jiesuan(map);
		model.addAttribute("cartitems", povos);
		return  "jsps/cart/showitem";
		
	}
}

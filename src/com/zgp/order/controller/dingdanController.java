package com.zgp.order.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zgp.domain.Dingdan;
import com.zgp.order.PoVo.dingdanPoVo;
import com.zgp.order.service.dingdanService;

import uuid.UUIDHelper;

@Controller
public class dingdanController {
	@Autowired
	private dingdanService service;
	
	@RequestMapping(value="/makedingdan",method=RequestMethod.POST)
	public String makedingdan(String[] ids,Model model,Dingdan dingdan){
		dingdan.setOid(UUIDHelper.getUUID());
		Date date =  new Date();
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		dingdan.setOrdertime(sdf.format(date));
		dingdan.setStatus(1);
		service.addDingdan(ids, dingdan);
		model.addAttribute("dingdan", dingdan);
		return  "jsps/order/ordersucc";
	}
	
	@RequestMapping(value="/dingdanlist/{uid}",method=RequestMethod.GET)
	public String dingdanlist(@PathVariable String uid,Model model){
		List<dingdanPoVo>   dingdans =  service.getDingdans(uid);
		model.addAttribute("dingdans", dingdans);
		return  "jsps/order/list";
	}
	
	@RequestMapping(value="/getdingdan/{oid}",method=RequestMethod.GET)
	public String getdingdan(@PathVariable String oid,Model model){
		dingdanPoVo   dingdans =  service.getDingdan(oid);
		System.out.println(dingdans);
		model.addAttribute("dingdan", dingdans);
		return  "jsps/order/desc";
	}
	
	@RequestMapping(value="/confirm/{oid}",method=RequestMethod.GET)
	public String confirm(@PathVariable String oid,Model model){
		Map<String,Object>  map = new HashMap<String, Object>();
		map.put("oid", oid);
		map.put("status", 4);
		service.updateStatus(map);
		model.addAttribute("code", "success");
		model.addAttribute("msg", "订单已确认，购物愉快");
		return  "jsps/msg";
	}
	
	@RequestMapping(value="/cancel/{oid}",method=RequestMethod.GET)
	public String cancel(@PathVariable String oid,Model model){
		Map<String,Object>  map = new HashMap<String, Object>();
		map.put("oid", oid);
		map.put("status", 5);
		service.updateStatus(map);
		model.addAttribute("code", "success");
		model.addAttribute("msg", "订单已取消，购物不愉快");
		return  "jsps/msg";
	}
}

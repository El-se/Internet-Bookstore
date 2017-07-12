package com.zgp.pay.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.zgp.domain.Dingdan;
import com.zgp.order.PoVo.dingdanPoVo;
import com.zgp.pay.service.payService;

@Controller
public class paycontroller {
	@Autowired
	private payService service;
	@RequestMapping(value="/gotupaypage/{oid}")
	public String gotopaypage(@PathVariable String oid,Model model){
		Dingdan dingdan = service.selectdingdan(oid);
		model.addAttribute("paydingdan", dingdan);
		return "jsps/order/pay";
	}
	
	@RequestMapping(value="/pay/{oid}")
	public void pay(@PathVariable String oid,Model model,HttpServletResponse response) throws Exception{
		Dingdan dingdan = service.selectdingdan(oid);
		
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		/* alipayRequest.setNotifyUrl(AlipayConfig.notify_url); */
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = dingdan.getOid();
		//付款金额，必填
		String total_amount = dingdan.getTotal().toString();
		//订单名称，必填
		String subject = "购买图书";
		//商品描述，可空
		String body = "";
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		
		//输出
		response.getWriter().print(result);
	}
	
	@RequestMapping(value="/retuenurl")
	public String returnurl(Model model,HttpServletRequest request) throws Exception{
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		if(signVerified) {
			String oid = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
			service.selectbyoid(oid);
			model.addAttribute("code", "success");
			model.addAttribute("msg", "支付成功，我们将尽快发货！");
		}else {
			/*out.println("验签失败");*/
			model.addAttribute("code", "error");
			model.addAttribute("msg", "支付失败！");
		}
		return "jsps/msg";
	}
}

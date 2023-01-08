package org.fyp.zhkucst.controller;

import org.fyp.zhkucst.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@ResponseBody
	@RequestMapping(value="/initOrder")
	public String initOrder(@RequestParam("uid") String userid){
		return orderService.initOrder(userid);
	}
}

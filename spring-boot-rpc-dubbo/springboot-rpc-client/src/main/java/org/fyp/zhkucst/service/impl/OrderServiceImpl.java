package org.fyp.zhkucst.service.impl;

import java.util.List;

import org.fyp.zhkucst.service.HelloService;
import org.fyp.zhkucst.service.OrderService;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;


@Service
public class OrderServiceImpl implements OrderService{
	//@Autowired
	@Reference(timeout = 1000) /* (loadbalance = "random") */ /* (url = "127.0.0.1:20880") */
	HelloService helloService;


	@Override
	public String initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("用户id:" + userId);
		System.out.println(helloService);
		String res = helloService.sayHello(userId);
		return res;
	}
}

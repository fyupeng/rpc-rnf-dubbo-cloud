package org.fyp.zhkucst.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import org.fyp.zhkucst.service.HelloService;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: fyp
 * @Date: 2022/10/19
 * @Description: HelloWorld实现类
 * @Package: cn.fyupeng.cn.fyupeng.controller.impl
 * @Version: 1.0
 */

@Service
@Component
public class HelloServiceImpl implements HelloService {
   private AtomicInteger count = new AtomicInteger(0);
   @Override
   public String sayHello(String name) {
      try {
         long start = System.currentTimeMillis();
         System.out.println("调用次数" + count.incrementAndGet());
         //int taskTime = new Random().nextInt(50);
         Thread.sleep(50);
         long end = System.currentTimeMillis();
         System.out.println("任务时间： " + (end - start));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return "hello, my name is " + name;
   }
}

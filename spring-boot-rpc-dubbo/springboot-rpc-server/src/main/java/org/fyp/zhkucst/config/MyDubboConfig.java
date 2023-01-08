package org.fyp.zhkucst.config;

import java.util.ArrayList;

import com.alibaba.dubbo.config.*;
import org.fyp.zhkucst.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDubboConfig {

	 @Bean
	 public ApplicationConfig applicationConfig() {
		 ApplicationConfig applicationConfig = new ApplicationConfig();
		 applicationConfig.setName("bootUserServiveProvider");
		 applicationConfig.setVersion("1.0.0");
		 return applicationConfig;
	 }


	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setProtocol("zookeeper");
		registryConfig.setAddress("47.107.63.171:2181");
		return registryConfig;
	}
	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(20880);
		return protocolConfig;
	}

	@Bean
	public ServiceConfig<HelloService> ServiceConfig(HelloService helloService){
		ServiceConfig<HelloService> serviceConfig = new ServiceConfig<>();
		serviceConfig.setInterface(HelloService.class);
		serviceConfig.setRef(helloService);
		serviceConfig.setVersion("1.0.0");

		MethodConfig methodConfig = new MethodConfig();
		methodConfig.setName("sayHello");
		methodConfig.setTimeout(1000);

		ArgumentConfig argumentConfig = new ArgumentConfig();
		argumentConfig.setType("java.lang.String");

		ArrayList<ArgumentConfig> arguments =  new ArrayList<>();
		arguments.add(argumentConfig);

		methodConfig.setArguments(arguments);

		ArrayList<MethodConfig> methods = new ArrayList<>();
		methods.add(methodConfig);

		serviceConfig.setMethods(methods);

		return serviceConfig;
	}

	@Bean
	public ProviderConfig providerConfig() {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setTimeout(1000);
		return providerConfig;
	}

	@Bean
	public MonitorConfig monitorConfig() {
		MonitorConfig monitorConfig = new MonitorConfig();
		monitorConfig.setProtocol("registry");
		monitorConfig.setAddress("127.0.0.1:7070");
		return monitorConfig;
	}
}

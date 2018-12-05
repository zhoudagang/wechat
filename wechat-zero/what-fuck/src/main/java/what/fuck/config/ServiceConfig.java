package what.fuck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import what.fuck.service.impl.MessageServiceImpl;

@Configuration // 此处为配置项
public class ServiceConfig {
  
	@Bean
	public MessageServiceImpl messageServiceImpl() {
		return new MessageServiceImpl();
	}

}

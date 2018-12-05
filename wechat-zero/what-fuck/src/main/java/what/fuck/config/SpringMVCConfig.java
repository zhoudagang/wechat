package what.fuck.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import what.fuck.interceptor.AuthInterceptor;


@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {
    
    @Autowired
    private AuthInterceptor authInterceptor;
    

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       /*---------------------------------------+
        |    添加拦截器,并依次执行 
        +=======================================*/
        
        // 添加拦截过滤
   //    registry.addInterceptor(authInterceptor).addPathPatterns("/**");
        
    }

}
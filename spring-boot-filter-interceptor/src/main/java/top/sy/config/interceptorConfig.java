package top.sy.config;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.sy.interceptor.MyInterceptor;
import top.sy.interceptor.YourInterceptor;


@Configuration
@Slf4j
@AllArgsConstructor
public class interceptorConfig implements WebMvcConfigurer {
    @Resource
    private final MyInterceptor myInterceptor;
    private final YourInterceptor yourInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/test");
    }

}

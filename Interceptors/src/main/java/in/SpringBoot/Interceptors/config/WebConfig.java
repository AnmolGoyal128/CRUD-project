package in.SpringBoot.Interceptors.config;

import in.SpringBoot.Interceptors.Interceptor.AuthenticationInterceptor;
import in.SpringBoot.Interceptors.Interceptor.AuthorizationInterceptor;
import in.SpringBoot.Interceptors.Interceptor.LoggingInterceptor;
import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;

    public AuthenticationInterceptor authenticationInterceptor;

    public AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(AuthenticationInterceptor authenticationInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
    }

    public WebConfig(LoggingInterceptor loggingInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor).
                addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login",  "/api/public/**")
                        .order(1);
        registry.addInterceptor(loggingInterceptor).
                addPathPatterns("/api/**").
                order(2);
        registry.addInterceptor(authorizationInterceptor).
                excludePathPatterns("/api/public/**").
                order(3);
    }
}

// /api/student or /random ---->

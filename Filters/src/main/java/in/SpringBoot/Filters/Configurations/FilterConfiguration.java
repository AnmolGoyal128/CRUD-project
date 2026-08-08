package in.SpringBoot.Filters.Configurations;

import in.SpringBoot.Filters.Filter.dummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
@Bean
    public FilterRegistrationBean<dummyFilter> getDummyFilter(){
        FilterRegistrationBean<dummyFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(new dummyFilter());
        registrationBean.addUrlPatterns("/api/*, /admin/*");
        return registrationBean;

    }
}

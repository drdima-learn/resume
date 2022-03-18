package net.devstudy.resume.configuration;

import net.devstudy.resume.filter.ResumeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletInit extends SpringBootServletInitializer {

//    @Bean
//    public FilterRegistrationBean ErrorFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new ResumeFilter()); // adding sitemesh filter ??
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setOrder(1);
//        return filterRegistrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean siteMeshFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new CustomSiteMeshFilter()); // adding sitemesh filter ??
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setOrder(2);
//        return filterRegistrationBean;
//    }


}

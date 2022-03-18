//package net.devstudy.resume.configuration;
//
//import net.devstudy.resume.filter.ResumeFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Filter {
//    @Bean
//    public FilterRegistrationBean<ResumeFilter> loggingFilter(){
//        FilterRegistrationBean<ResumeFilter> registrationBean
//                = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new ResumeFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(2);
//
//        return registrationBean;
//    }
//}

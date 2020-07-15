package com.zut.gds.config;

import com.zut.gds.intercetper.TestIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * <p>
 *  配置bean
 * </p>
 *
 * @author huaxiaoyu
 * @since 2020-07-11
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private TestIntercepter testIntercepter;

    @Autowired
    public void setTestIntercepter(TestIntercepter testIntercepter) {
        this.testIntercepter = testIntercepter;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testIntercepter)
                .addPathPatterns("/admin/**")
                .addPathPatterns("/teacher/**")
                .addPathPatterns("/student/**")
                .addPathPatterns("/company/**");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}


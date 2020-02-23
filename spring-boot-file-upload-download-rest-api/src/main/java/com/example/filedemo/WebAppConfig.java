package com.example.filedemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

  /*  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/MyTestPage").setViewName("forward:/MyTestPage.html");
    }*/

	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	        .addResourceHandler("./*.html")
	        .addResourceLocations("/static/");
	}*/
	
	@Bean
    public ClassLoaderTemplateResolver yourTemplateResolver() {
        ClassLoaderTemplateResolver configurer = new ClassLoaderTemplateResolver();
        configurer.setPrefix("template/");
        configurer.setSuffix(".html");
        configurer.setTemplateMode(TemplateMode.HTML);
        configurer.setCharacterEncoding("UTF-8");
        configurer.setOrder(0);  // this is important. This way spring //boot will listen to both places 0 and 1
        configurer.setCacheable(false);
        configurer.setCheckExistence(true);
        return configurer;
    }
}
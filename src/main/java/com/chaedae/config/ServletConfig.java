package com.chaedae.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * <h1>Spring WebMVC Configuration</h1>
 * @author ChaeDae
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.chaedae"})
public class ServletConfig implements WebMvcConfigurer {

	/**
	 * Apache-Tiles Configuration
	 * @return tilesViewResolver
	 */
	@Bean
    public TilesViewResolver viewResolver() {
        TilesViewResolver viewResolver = new TilesViewResolver();
        viewResolver.setViewClass(TilesView.class);
        viewResolver.setOrder(1);
        
        return viewResolver;
    }
	
	/**
	 * Apache-Tiles Init
	 * @return
	 */
	@Bean
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{
                "/WEB-INF/tiles/layouts/tiles.xml"
        });
        tilesConfigurer.setCheckRefresh(true);
//        tilesConfigurer.setDefinitionsFactoryClass(TilesDefinitionsConfig.class);
//        
//        TilesDefinitionsConfig.addDefinitions();
        
        return tilesConfigurer;
	}
	
	/**
	 * ViewResolver Configuration
	 * @return viewResolver
	 */
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		
		return resolver;
	}
	
	/**
	 * MessageSource Configuration
	 * 다국어 처리
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		
		return source;
	}
	
	
}

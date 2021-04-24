package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("bridge")
@EnableWebMvc
public class SevletInitializer {

	@Bean
	public ViewResolver getView() {
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver();
		viewResolver.setPrefix("view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}

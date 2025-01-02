package io.github.andresgois.app01.config;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

//@Configuration
public class PropertiesConfig {

	//@Bean
	public PropertySourcesPlaceholderConfigurer config() {
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		config.setLocation(new FileSystemResource("C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\Spring batch\\application.properties"));
		return config;
	}
}

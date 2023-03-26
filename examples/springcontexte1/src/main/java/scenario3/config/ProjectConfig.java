package scenario3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"scenario3.services","scenario3.repositories"})
public class ProjectConfig {

}

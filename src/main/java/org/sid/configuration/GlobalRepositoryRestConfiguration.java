package org.sid.configuration;

import org.sid.entities.Etudiant;
import org.sid.entities.Formation;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class GlobalRepositoryRestConfiguration extends RepositoryRestConfigurerAdapter{

	public void configureRepositoryRestConfiguartaion(RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.setReturnBodyOnCreate(true);
		repositoryRestConfiguration.setReturnBodyOnUpdate(true);
		repositoryRestConfiguration.exposeIdsFor(Etudiant.class, Formation.class);
		repositoryRestConfiguration.getCorsRegistry()
		.addMapping("/**")
		.allowedOrigins("*")
		.allowedHeaders("*")
		.allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
		
	}

}

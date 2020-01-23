package org.sid;

import java.util.Date;

import org.sid.dao.EtudiantRepository;
import org.sid.dao.FormationRepository;
import org.sid.entities.Etudiant;
import org.sid.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MsUh2cApplication implements CommandLineRunner{

	@Autowired
	private EtudiantRepository etudR;
	@Autowired
	private FormationRepository formR;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(MsUh2cApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repositoryRestConfiguration.exposeIdsFor(Formation.class, Etudiant.class);
		repositoryRestConfiguration.getCorsRegistry()
		.addMapping("/**")
		.allowedOrigins("*")
		.allowedHeaders("*")
		.allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
		
		Formation f1 = formR.save(new Formation(null, "PHP", 30, null));
		Formation f2 = formR.save(new Formation(null, "JAVA", 30, null));
		Formation f3 = formR.save(new Formation(null, "Oracle", 30, null));
		
		etudR.save(new Etudiant(null, "Hassan", "Hassan", new Date(), f1));
		etudR.save(new Etudiant(null, "Mohamed", "Mohamed", new Date(), f2));
		etudR.save(new Etudiant(null, "Hanane", "Hanane", new Date(), f3));
		etudR.save(new Etudiant(null, "Nabila", "Nabila", new Date(), f1));
	}

}

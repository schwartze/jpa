package hibernate;

import hibernate.domain.Content;
import hibernate.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static Logger logger = LoggerFactory.getLogger( Main.class );
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "everyzone" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User user = entityManager.find( User.class, 1 );
		logger.debug( "{}", user.getUser_id() );
		logger.debug( "{}", user.getUuid() );
		logger.debug( "{}", user.getEmail() );
		logger.debug( "{}", user.getFirst_name() );
		logger.debug( "{}", user.getLast_name() );
		
		Content content = user.getContent();
		logger.debug( "{}", content.getContent_id() );
		logger.debug( "{}", content.getUser_id() );
		logger.debug( "{}", content.getDescription() );
		entityManager.close();
	}
}

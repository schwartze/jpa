package mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBMain {
	private static Logger logger = LoggerFactory.getLogger( MongoDBMain.class );
	private static String MONGODB_DB_NAME = "test";
	private static String MONGODB_DB_USER = "schwartze";
	private static char[] MONGODB_DB_PWD = "!kim9978K".toCharArray();
	public static void main( String[] args ) {
		
		try {
			MongoCredential credential = MongoCredential.createCredential( MONGODB_DB_USER, MONGODB_DB_NAME, MONGODB_DB_PWD );
			try ( MongoClient mongoClient = new MongoClient( new ServerAddress( "consequence.xyz" ), Arrays.asList( credential ) ) ) {
				MongoDatabase db = mongoClient.getDatabase( MONGODB_DB_NAME );
				MongoCollection<Document> collection = db.getCollection( "user" );
				collection.find().iterator().forEachRemaining( ( doc ) -> {
					logger.debug( "{}", doc.toJson() );
					doc.forEach( ( key, value ) -> {
						logger.debug( "{} {}", key, value );
					} );
				} );
				Map<String, Object> map = new HashMap<String, Object>();
				List<String> arr = new ArrayList<String>();
				arr.add( "program" );
				arr.add( "basketball" );
				map.put( "name", "schwartze" );
				map.put( "hobby", arr );
				
				logger.debug( "{}", new Document( map ).toJson() );
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}

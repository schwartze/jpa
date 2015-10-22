package invoke;

import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvokeMain {
	private static Logger logger = LoggerFactory.getLogger( InvokeMain.class );
	
	public static void main ( String[] args ) {
		Hello hello = (Hello) Proxy.newProxyInstance( Hello.class.getClassLoader(), new Class[] { Hello.class }, new HelloHandler( new HelloBody() ) );
		String ret = hello.say( "Schwartze" );
		logger.debug( "{}", ret );
	}
}

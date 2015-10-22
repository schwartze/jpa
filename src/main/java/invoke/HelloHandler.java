package invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloHandler implements InvocationHandler {
	private static Logger logger = LoggerFactory.getLogger( HelloHandler.class );
	
	private Hello target;
	
	public HelloHandler( Hello target ) {
		this.target = target;
	}
	
	@Override
	public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
		Object ret = method.invoke( target, args );
		logger.debug( "{}", proxy );
		logger.debug( "{}", method.getName() );
		logger.debug( "{}", args );
		logger.debug( "{}", ret );
		return ret;
	}

}

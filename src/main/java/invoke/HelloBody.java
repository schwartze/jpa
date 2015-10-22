package invoke;

public class HelloBody implements Hello {

	@Override
	public String say ( String prefix ) {
		return prefix + " Hello";
	}

}

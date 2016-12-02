/**
 * Created by HiekmaHe on 02.12.2016.
 */
public class ABrokenMethod extends AMethod
{
	public String testMethod()
	{
		throw new RuntimeException();
	}
}

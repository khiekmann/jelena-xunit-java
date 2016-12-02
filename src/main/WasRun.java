/**
 * Created by HiekmaHe on 02.12.2016.
 */
public class WasRun extends TestCase
{

	public WasRun(AMethod method)
	{
		super(method);
	}

	public int wasRun() {
		return wasRun;
	}

	public void setUp()
	{
		log("setUp ");
	}

	public void tearDown()
	{
		log("tearDown ");
	}
}
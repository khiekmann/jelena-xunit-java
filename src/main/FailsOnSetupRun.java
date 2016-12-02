/**
 * Created by HiekmaHe on 02.12.2016.
 */
public class FailsOnSetupRun extends TestCase
{
	public FailsOnSetupRun(AMethod method)
	{
		super(method);
	}

	public void setUp()
	{
		throw new RuntimeException();
	}

	public void tearDown()
	{
		log("tearDown ");
	}
}

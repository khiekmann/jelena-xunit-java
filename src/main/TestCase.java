/**
 * Created by HiekmaHe on 02.12.2016.
 */
public abstract class TestCase implements Test
{
	private final AMethod method;

	public int wasRun;
	public String log;

	public TestCase(AMethod method)
	{
		this.method = method;
		wasRun = 0;
		log = "";
	}

	public void run(TestResult result)
	{
		runAndReturnResult(result);
	}

	private TestResult runAndReturnResult(TestResult result)
	{
		try {
			result.testStarted();
			setUp();
			log(method.testMethod());
			tearDown();
		} catch (Throwable throwable) {
			result.testFailed();
		}
		return result;
	}

	public abstract void setUp();

	public void log(String message)
	{
		log += message;
	}

	public abstract void tearDown();

	public int countTestCases()
	{
		return 1;
	}
}
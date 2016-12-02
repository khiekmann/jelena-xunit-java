/**
 * Created by HiekmaHe on 02.12.2016.
 */
public class TestResult
{
	private int runCount;
	private int errorCount;

	public TestResult()
	{
		runCount = 0;
		errorCount = 0;
	}

	public void testStarted() {
		runCount++;
	}

	public String summary()
	{
		return runCount + " run, " + errorCount + " failed";
	}

	public void testFailed() {
		errorCount++;
	}
}

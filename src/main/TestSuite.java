import java.util.ArrayList;
import java.util.List;


/**
 * Created by HiekmaHe on 02.12.2016.
 */
public class TestSuite implements Test
{
	private List<TestCase> testCases;

	public TestSuite()
	{
		testCases = new ArrayList<TestCase>();
	}

	public boolean add(TestCase testCase)
	{
		return testCases.add(testCase);
	}

	public TestResult run()
	{
		return new TestResult();
	}

	public int countTestCases()
	{
		return testCases.size();
	}

	public void run(TestResult result)
	{
		for (TestCase testCase : testCases) {
			testCase.run(result);
		}
	}
}

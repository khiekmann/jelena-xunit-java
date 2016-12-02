import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


/**
 * Created by HiekmaHe on 02.12.2016.
 */
public class TDDByExampleTest
{
	private AMethod testMethod;
	private ABrokenMethod testBrokenMethod;
	private AMethod testBreakOnSetup;
	private TestResult result;

	@Before
	public void test() {
		testMethod = new ATestMethod();
		testBrokenMethod = new ABrokenMethod();
		testBreakOnSetup = new ASetupFailingMethod();
		result = new TestResult();
	}

	@Ignore("Refactoring. testMethod is now obsolete.")
	@Test
	public void testChapter18() {
		// arrange
		WasRun test = new WasRun(testMethod);
		assertEquals(0, test.wasRun());
		/* obsolete // test.testMethod();*/
		assertTrue(test.log.contains(testMethod.toString()));
	}

	@Test
	public void testChapter18_1() {
		// arrange
		WasRun test = new WasRun(testMethod);
		assertEquals(0, test.wasRun());
		test.run(new TestResult());
		assertTrue(test.log.contains("testMethod"));
	}

	@Test
	public void testRunning() {
		WasRun test = new WasRun(testMethod);
		assertEquals(0, test.wasRun());
		test.run(result);
		assertTrue(test.log.contains("testMethod"));
	}

	@Test
	public void testWasSetUp() {
		WasRun test = new WasRun(testMethod);
		test.run(result);
		assertTrue(test.log.contains("setUp"));
	}

	@Test
	public void testTemplateMethod() {
		WasRun test = new WasRun(testMethod);
		assertEquals(0, test.wasRun());
		test.run(result);
		assertTrue(test.log.startsWith("setUp testMethod"));
	}

	@Test
	public void testTemplateMethod_1() {
		WasRun test = new WasRun(testMethod);
		assertEquals(0, test.wasRun());
		test.run(result);
		assertEquals("setUp testMethod tearDown ", test.log);
	}

	@Test
	public void testResult() {
		TestCase test = new WasRun(testMethod);
		test.run(result);
		assertEquals("1 run, 0 failed", result.summary());
	}

	@Test /* obsolete(expected = Exception.class) */
	public void testFailedResult() {
		TestCase test = new WasRun(testBrokenMethod);
		test.run(result);
		assertEquals("1 run, 1 failed", result.summary());
	}

	@Test
	public void testFailedResultFormatting() {
		result.testStarted();
		result.testFailed();
		assertEquals("1 run, 1 failed", result.summary());
	}

	@Test
	public void testFailedSetup() {
		TestCase test = new FailsOnSetupRun(testBreakOnSetup);
		test.run(result);
		assertEquals("1 run, 1 failed", result.summary());
	}

	@Test
	public void testSuite(){
		TestSuite suite = new TestSuite();
		suite.add(new WasRun(testMethod));
		suite.add(new WasRun(testBrokenMethod));
		suite.run(result);
		assertEquals("2 run, 1 failed", result.summary());
	}
}
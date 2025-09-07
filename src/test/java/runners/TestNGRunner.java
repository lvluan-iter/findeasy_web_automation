package runners;

import org.testng.TestNG;

import java.util.Arrays;


public class TestNGRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        testNG.setTestSuites(Arrays.asList("src/test/resources/testng.xml"));
        testNG.setSuiteThreadPoolSize(2);
        testNG.setThreadCount(4);

        testNG.setVerbose(2);
        testNG.setPreserveOrder(true);

        testNG.run();
    }
}

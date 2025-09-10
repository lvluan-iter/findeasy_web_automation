package constants;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    //====TIMEOUTS====
    public static final int EXPLICIT_WAIT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 20;

    //====PATHS====
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String MAIN_RESOURCES_PATH = PROJECT_PATH + "src/main/resources";
    public static final String TEST_RESOURCES_PATH = PROJECT_PATH + "src/test/resources";
    public static final String CONFIG_PROPERTIES_PATH = MAIN_RESOURCES_PATH + "/config.properties";
    public static final String SMOKE_TEST_XML_PATH = TEST_RESOURCES_PATH + "/SmokeTest.xml";
    public static final String REGRESSION_TEST_XML_PATH = TEST_RESOURCES_PATH + "/RegressionTest.xml";
    public static final String REPORT_PATH = PROJECT_PATH + "/reports";

}

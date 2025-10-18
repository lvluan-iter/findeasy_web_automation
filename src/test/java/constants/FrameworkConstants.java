package constants;

public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    //====TIMEOUTS====
    public static final int EXPLICIT_WAIT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 20;
    public static final int WAIT_TIMEOUT = 10;
    public static final int HOVER_TIME = 1;

    //====PATHS====
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_PATH = PROJECT_PATH + "/src/test/resources";
    public static final String CONFIG_PROPERTIES_PATH = RESOURCES_PATH + "/config.properties";
    public static final String REPORT_PATH = PROJECT_PATH + "/reports";
    public static final String FEATURES_PATH = "src/test/resources/features";
}

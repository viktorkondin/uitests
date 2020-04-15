package common;

import com.codeborne.selenide.Configuration;
import configuration.Environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {
        logger.info("Obtaining configuration from properties");
        Environment currentEnvironment = new Environment();
        Configuration.baseUrl = currentEnvironment.getProperties().getProperty("base_url");
        Configuration.startMaximized = true;
        logger.info("Configurations are successfully obtained for " + currentEnvironment.getEnvironmentType() +
                " environment");
    }
}

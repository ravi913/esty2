import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", strict = true,tags = {},plugin = {})
public class RunCukesTest {
}




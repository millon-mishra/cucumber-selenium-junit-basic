package nl.sogeti.millon;

/**
 * Created by MILLMISH on 12-11-2017.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Demo.feature",
        format = {"pretty","html:target/Reports"}
)
public class SystemtestRunnerTest {
}

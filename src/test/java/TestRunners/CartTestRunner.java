package TestRunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features/cart.feature", // Path to your feature files
	    glue = "stepDefinitions", // Package where your step definition classes are located
	    plugin = {"pretty"} // Add more plugins if needed
	)

public class CartTestRunner {

}

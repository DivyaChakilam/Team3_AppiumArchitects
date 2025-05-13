package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestContext;

public class SearchChannelSteps {
	private TestContext testContext;

    public SearchChannelSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    @Given("User launches the emulator and SkyTube app")
    public void user_launches_the_emulator_and_sky_tube_app() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User enter a {string} to search in search field")
    public void user_enter_a_to_search_in_search_field(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees the searched channel")
    public void user_sees_the_searched_channel() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

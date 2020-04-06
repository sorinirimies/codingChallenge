package com.themovie.steps;

import com.themovie.page_object.Common_PO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.tools.TestContext;

public class Common_Steps {
    private Common_PO common_po;

    public Common_Steps(TestContext context){
        common_po = new Common_PO(context);
    }

    @Given("The application is installed and launched")
    public void theApplicationIsInstalledAndLaunched() {
        common_po.check_appIsOpen();
    }

    @When("User click on the Tv button")
    public void userClickOnTheTvButton() {
        common_po.click_button_tvshow();
    }

    @When("User click on the Star button")
    public void userClickOnTheStarButton() {
        common_po.click_button_star();
    }

    @When("User click on the Movie button")
    public void userClickOnTheMovieButton() {
        common_po.click_button_movie();
    }

    @When("User click on the Star {string}")
    public void userClickOnTheStar(String star_name) {
        common_po.click_star(star_name);
    }

    @When("User click on the Tv Show {string}")
    public void userClickOnTheTvShow(String tvShow_name) {
        common_po.click_tvshow(tvShow_name);
    }

    @When("User click on the Movie {string}")
    public void userClickOnTheMovie(String movie_name) {
        common_po.click_movie(movie_name);
    }

    @Then("User is on the Tv Shows screen")
    public void userIsOnTheTvShowsScreen() {
        common_po.check_page_tvshow();
    }

    @Then("User is on the Tv Show's details page {string}")
    public void userIsOnTheTvShowSDetailsPage(String tvShow_name) {
        common_po.check_tvshow(tvShow_name);

    }

    @Then("User is on the Star screen")
    public void userIsOnTheStarScreen() {
        common_po.check_page_star();
    }

    @Then("User is on the Star's details page {string}")
    public void userIsOnTheStarSDetailsPage(String star) {
        common_po.check_star(star);
    }

    @Then("User is on the Movie Screen")
    public void userIsOnTheMovieScreen() {
        common_po.check_page_movie();
    }

    @Then("User is on the Movie's details page {string}")
    public void userIsOnTheMovieSDetailsPage(String movie_name) {
        common_po.check_movie(movie_name);
    }

    @When("User click on the arrow back")
    public void userClickOnTheArrowBack() {
        common_po.click_button_back();
    }

    @When("User click on the back button")
    public void userClickOnTheBackButton() {
        common_po.click_toolbar_home();
    }
}

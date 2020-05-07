@AppTest

Feature: Test Application

  @TvShow
  Scenario Outline: User wants to see details about his favorite show
    Given The application is installed and launched
    When User click on the Tv button
    Then User is on the Tv Shows screen
    When User click on the Tv Show "<Tv Show>"
    Then User is on the Tv Show's details page "<Tv Show>"

    Examples:
      |Tv Show    |
      |Dragon Ball|

  @Star
  Scenario Outline: User wants to see details about his favorite star
    Given The application is installed and launched
    When User click on the Star button
    Then User is on the Star screen
    When User click on the Star "<Star>"
    Then User is on the Star's details page "<Star>"

    Examples:
      |Star     |
      |Brad Pitt|

  @Movie
  Scenario Outline: User wants to see details about his favorite movie
    Given The application is installed and launched
    When User click on the Movie "<Movie>"
    Then User is on the Movie's details page "<Movie>"

    Examples:
      |Movie    |
      |Bloodshot|

  @Full
  Scenario Outline: User explore all the application
    Given The application is installed and launched
    When User click on the Tv button
    Then User is on the Tv Shows screen
    When User click on the Tv Show "<Tv Show>"
    Then User is on the Tv Show's details page "<Tv Show>"
    When User click on the arrow back
    Then User is on the Tv Shows screen
    When User click on the Star button
    Then User is on the Star screen
    When User click on the Star "<Star>"
    Then User is on the Star's details page "<Star>"
    When User click on the back button
    Then User is on the Star screen
    When User click on the Movie button
    Then User is on the Movie Screen
    When User click on the Movie "<Movie>"
    Then User is on the Movie's details page "<Movie>"

    Examples:
      |Tv Show |Star        |Movie     |
      |Castle  |Kevin Makely|Underwater|



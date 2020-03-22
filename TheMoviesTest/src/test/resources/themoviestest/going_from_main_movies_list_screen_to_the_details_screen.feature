Feature: Going from main movies list screen to the detailed screen
  Everybody wants to go from the movie at the main list to details

  Scenario: Show details of movie cars
    Given the app is up and running
    When i click at cars movie
    Then i see the correct release date

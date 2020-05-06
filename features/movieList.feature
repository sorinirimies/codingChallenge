Feature: movies list managment

    Scenario Outline: Check movie details
        Given I am on "movies list" page
        When I go to detail page of "<title>"
        Then I see the release date "<release_date>" of "<title>"

        Examples:
            | title                      | release_date |
            | Ad Astra                   | 2019-09-17   |
            | Underwater                 | 2020-01-08   |

            #| Die Hard: With a Vengeance | 1995-05-19   |
            #| John Wick                  | 2014-10-22   |

        
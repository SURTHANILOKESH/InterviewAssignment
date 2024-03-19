@ALL @UC01
Feature: Login to Saucedemo application

  Scenario Outline: Login with valid user credentials and verify that user have logged in successfully.
    Given Navigate to saucedemo application
    Then Verify user lands on home page
    When User enter the <username> and <password>
    And Click on login button
    Then Verify user lands on the inventory page

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Login invalid user credentials and verify that user have not logged in successfully.
    Given Navigate to saucedemo application
    Then Verify user lands on home page
    When User enter the <username> and <password>
    And Click on login button
    Then Verify user does not lands on the inventory page

    Examples: 
      | username        | password     |
      | locked_out_user | secret_sauce |
      #| problem_user            | secret_sauce |
      #| performance_glitch_user | secret_sauce |
      #| error_user              | secret_sauce |
      #| visual_user             | secret_sauce |

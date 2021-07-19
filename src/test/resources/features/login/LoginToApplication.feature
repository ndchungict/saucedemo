@driver:appium @App
Feature: Login Sauce Demo Application
  As a customer
  I want to order some clothes
  So that I need to login

  @Auth01
  Scenario: Login successfully
    Given that chung is on the sauce demo application
    When he login to application with valid user
      | username      | password     |
      | standard_user | secret_sauce |
    Then On the application he should see the shopping cart
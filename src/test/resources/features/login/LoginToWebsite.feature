@Web @driver:chrome
Feature: Login Sauce Demo Website
  As a customer
  I want to order some clothes
  So that I need to login

  Background:
    Given that Chung is on the sauce demo website

  @Auth01
  Scenario: Login with standard user
    When he login with valid user
      | username      | password     |
      | standard_user | secret_sauce |
    Then he should see the shopping cart

  @Auth02
  Scenario: Login with locked out user
    Given that chung is on the sauce demo website
    When he login with valid user
      | username        | password     |
      | locked_out_user | secret_sauce |
    Then he should see the error message "Epic sadface: Sorry, this user has been locked out."

  @Auth03
  Scenario: Login with blank username
    When he login with valid user
      | username | password     |
      |          | secret_sauce |
    Then he should see the error message "Epic sadface: Username is required"

  @Auth04
  Scenario: Login with blank password
    When he login with valid user
      | username      | password |
      | standard_user |          |
    Then he should see the error message "Epic sadface: Password is required"

  @Auth05
  Scenario: Login with invalid user and password
    When he login with valid user
      | username      | password         |
      | standard_user | invalid_password |
    Then he should see the error message "Epic sadface: Username and password do not match any user in this service"

  @manual-result:passed @Auth06
  Scenario: Login with timeout

  @manual-result:failed @Auth07
  Scenario: Disconnect to server
@Login @loginfeature @all
Feature: Iogin functionality

  Background: 
    Given User opens tutorial ninja website
    When User click on MyAccount
    And click on Login link

  @TS_Login_01
  Scenario Outline: Testing the login functionality using Scenario Outline
    And User enter the emailaddress and password "<emailaddress>" and "<password>"
    And User click on login button
    Then User should navigated to account page
    When User click on MyAccount
    And User click on logout link
    Then User should logout successfully

    Examples: 
      | emailaddress    | password |
      | name1@email.com |     1234 |
      | name2@email.com |     1234 |

  @TS_Login_02
  Scenario: Testing the login functionality using Property file
    And User enters valid credentials
    Then User should navigated to account page
    When User click on MyAccount
    And User click on logout link
    Then User should logout successfully

  @TS_Login_03
  Scenario Outline: Testing the login functionality using Scenario Outline
    And User enters valid credentials using sheet "<sheetname>" <rownum>
    And User click on login button
    Then User should navigated to account page
    When User click on MyAccount
    And User click on logout link
    Then User should logout successfully

    Examples: 
      | sheetname | rownum |
      | loginData |      0 |
      | loginData |      1 |

  @TS_Login_04
  Scenario: Testing the login functionality using DataTable
    When User enters the credentails using Data table
      | name4@email.com | 1234 |
    And User click on login button
    Then User should navigated to account page
    When User click on MyAccount
    And User click on logout link
    Then User should logout successfully

Feature: Verify Wallet
  Scenario: Verify Dashboard
    Given Open Wallet application successfully
    When Input email & password
      | Fields | Value                 |
      | Email  | demouser@demouser.com |
      | Pass   | 123456                |
    And Click to login
    Then Verify The Dashboard screen display: Deposits and WithDrawals tab
    And Verify In Deposits tab display Deposit to Us Dollar with Amount =
      | Fields | Value                 |
      | Amount  | 55.00 USD            |

  Scenario: Verify Add Virtual Cards screen
    Given Open Wallet application successfully
    When Input email & password
      | Fields | Value                 |
      | Email  | demouser@demouser.com |
      | Pass   | 123456                |
    And Click to login
    And Click to icon Virtual Cards at footer menu
    And Click to Buy Card
    Then Verify The Buy a New Virtual Card display Name textbox and Fund button

  Scenario: Verify Request money screen
    Given Open Wallet application successfully
    When Input email & password
      | Fields | Value                 |
      | Email  | demouser@demouser.com |
      | Pass   | 123456                |
    And Click to login
    And Click to menu left icon
    And Click to request
    Then Verify The Request money display with Amount textbox, Email textbox, Request description and Send button

  Scenario: Verify setting screen
    Given Open Wallet application successfully
    When Input email & password
      | Fields | Value                 |
      | Email  | demouser@demouser.com |
      | Pass   | 123456                |
    And Click to login
    And Click to menu left icon
    And  Click to Setting
    And  Scroll to Change Password
    Then Verify The Change password screen display 3 textbox: Current password, New password, Repeat New Password

  Scenario: Verify error message in Add Virtual Cards screen
    Given Open Wallet application successfully
    When Input email & password
      | Fields | Value                 |
      | Email  | demouser@demouser.com |
      | Pass   | 123456                |
    And Click to login
    And Click to icon Virtual Cards at footer menu
    And Click to Buy Card
    And Input Name on Card
    And Click to the Fund button
    And Add 10 USD amount
    And Click to next icon
    Then Verify The screen display error message: No sufficient funds
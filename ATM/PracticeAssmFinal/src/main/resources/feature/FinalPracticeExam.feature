Feature: Verify eCart Application

  Scenario: Verify Home Screen
    Given Open eCart Application successfully
    Then Verify Home Screen

  Scenario: Verify Category Screen
    Given Open eCart Application successfully
    When Click to next
    And Click to next
    And Click to Get Started
    Then Verify Default Delivery Location Screen
      | Fields         | Value   |
      | List Verify    | All,370405,841301,800001,370465,370001|
    And Select Target Verify Location
      | Fields         | Value   |
      | List Verify    | All     |
    And Click to Category menu item
    Then Verify Category Screen
      | Fields          | Value   |
      | NumberOfCategory| 6   |
      | List Verify     | Coffee Product,Fast Food,Home Supplies,Beverages,Baby Need's,Vegetables|






Feature: Verify Banggood Easy Online Shopping Application

  Scenario: Verify Product Detail screen
    Given Open Banggood Easy Online Shopping Application successfully
    When Click to the Category on footer menu
    And Scroll to Home and Garden in Left menu
    And Click to Home and Garden in Left menu
    And Click to Home Decor at the right category
    And Click to Filter
    And Select COD
    And Click Done
    And Click First Product
    Then Verify Product Detail screen display Product Name
    And Verify Product Detail screen display COD icon

  Scenario: Verify Cart Screen
    Given Open Banggood Easy Online Shopping Application successfully
    When Scroll to Hot Categories
    And Click to Smartphone Category
    And Click to Target Product
      | Fields         | Value   |
      | Target Product | Ulefone Armor 26 Ultra 5G 200MP Quad Camera 64MP|
    Then Verify Product Detail screen display Product Name
    And Verify Product Detail screen display Product Price
    And Verify Product Detail screen display Buy Now Button
    And Verify Product Detail screen display Add to Cart Button
    And Scroll to Shipping
    And Click to Shipping
    And Click to SearchBox
    And Change Shipping Address
      | Fields         | Value   |
      | State change | United States|
      | Province change | Alabama|
    And Click to Continue
    And Click to Add to Cart
    And Click to Add to Cart Button
    And Click to Cart icon on Top
    Then Verify Cart Screen

  Scenario: Verify The Login screen
    Given Open Banggood Easy Online Shopping Application successfully
    When Click Account on footer menu
    And Click View All Order
    Then Verify Login screen display Email
    And Verify Login screen display Password
    And Verify Login screen display Sign-In Button


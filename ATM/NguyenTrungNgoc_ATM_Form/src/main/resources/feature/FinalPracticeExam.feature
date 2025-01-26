Feature: Verify Banggood Easy Online Shopping Application

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



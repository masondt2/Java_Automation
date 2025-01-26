Feature: Verify eCart App

  Scenario: Verify Home screen
    Given Open eCart application successfully
    Then Verify Home screen

  Scenario: Verify Category screen
    Given Open eCart application successfully
    When Click to next
    And Click to next
    And Click to Get Started
    Then Verify The Default Delivery Location screen
      | Fields    | Value                                  |
      | Locations | All,370405,841301,800001,370465,370001 |
    And Select target location
      | Fields    | Value |
      | Locations | All   |
    And Click to Category menu item
    Then Verify The Category screen
      | Fields                      | Value                                                                   |
      | Num Of Products In Category | 6                                                                       |
      | Products                    | Coffee Product,Fast Food,Home Supplies,Beverages,Baby Need's,Vegetables |

  Scenario: Verify number of product of Fresh Vegetables
    Given Open eCart application successfully
    When Click to next
    And Click to next
    And Click to Get Started
    And Select target location
      | Fields    | Value |
      | Locations | All   |
    And Scroll to Target Product
      | Fields         | Value            |
      | Target Product | Fresh Vagetables |
    Then Verify the number of Target Product in Category screen
      | Fields                   | Value            |
      | Target Product           | Fresh Vagetables |
      | Number of Target Product | 3                |
    And Click to View All of Target Product
      | Fields         | Value            |
      | Target Product | Fresh Vagetables |
    Then Verify the number of Target Product in Product screen
      | Fields                    | Value |
      | Number Of Target Products | 10    |

  Scenario: Verify Product Detail screen
    Given Open eCart application successfully
    When Click to next
    And Click to next
    And Click to Get Started
    And Select target location
      | Fields    | Value |
      | Locations | All   |
    And Scroll to Target Product
      | Fields         | Value  |
      | Target Product | Coffee |
    And Click to View All of Target Product
      | Fields         | Value  |
      | Target Product | Coffee |
    And Click to Verify Product
      | Fields              | Value                      |
      | Verify Product Name | High Octane Instant Coffee |
    Then Verify The product detail screen
      | Fields        | Value                                                                                                                           |
      | Product Name  | High Octane Instant Coffee Paste with Hazelnut and Coconut Flavors, 150G - Pack of 2 (Hazelnut and Coconut Beaten Coffee Paste) |
      | Product Price | $718.31                                                                                                                         |

  Scenario: Verify "Cart" screen
    Given Open eCart application successfully
    When Click to next
    And Click to next
    And Click to Get Started
    And Select target location
      | Fields    | Value |
      | Locations | All   |
    And Click to Category menu item
    And Click to Target Product Of Category Page
      | Fields         | Value     |
      | Target Product | Fast Food |
    And Click Add to Cart with Quantity of Verify Product
      | Fields         | Value                           |
      | Quantity       | 2                               |
      | Verify Product | Kurkure Namkeen - Masala Munch, |
    And Click to Cart icon on top screen
    And Select target location
      | Fields          | Value  |
      | Target Location | 370405 |
    Then Verify Cart screen
      | Fields              | Value                           |
      | Pin Code            | 370405                          |
      | Product Name        | Kurkure Namkeen - Masala Munch, |
      | Product Price       | $13.00                          |
      | Product Measurement | 85 kg                           |
      | Product Quantity    | 2                               |
      | Product Total Price | $26.00                          |

  Scenario: Verify Payment screen
    Given Open eCart application successfully
    When Click to next
    And Click to next
    And Click to Get Started
    And Select target location
      | Fields    | Value |
      | Locations | All   |
    And Click to Category menu item
    And Click to Target Product Of Category Page
      | Fields         | Value     |
      | Target Product | Beverages |
    And Click Add to Cart with Quantity of Verify Product
      | Fields         | Value                                   |
      | Quantity       | 2                                       |
      | Verify Product | Sunfeast Dark Fantasy Choco Fills, 600g |
    And Click to Cart icon on top screen
    And Select target location
      | Fields          | Value  |
      | Target Location | 370001 |
    And Click to CONTINUE button
    And Click to Login button of Welcome toeCart
    And Click to CONTINUE button
    And Select type of address
      | Fields         | Value   |
      | Addresses Type | Default |
    And Click to CONTINUE button
    Then Verify Payment screen
      | Fields           | Value             |
      | Shipping Details | Pin Code : 370001 |
      | Grand Total      | $414.20           |

  Scenario: Verify "Profile" screen
    Given Open eCart application successfully
    When Click to next
    And Click to next
    And Click to Get Started
    And Select target location
      | Fields    | Value |
      | Locations | All   |
    And Click to Profile on footer menu
    And Click to Welcome Guest
    Then Verify The login screen on Welcome toeCart page
    And Click to Login button of Welcome toeCart
    And Click to Profile on footer menu
    Then Verify profile screen
      | Fields             | Value                                                                                                                                                                                                     |
      | List Profile Items | Home,Cart,Notifications,Your Orders,Wallet History,Transaction History,Change Password ?,Manage Addresses,Refer & Earn,Contact Us,About Us,Rate Us,Share App,FAQ,Terms & Conditions,Privacy Policy,Logout |















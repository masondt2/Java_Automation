Feature: Verify TIKI App
  
  Scenario: Verify product name and product price of Hang Moi in Laptop – May Vi Tinh
    Given Open TIKI application successfully
    When Click to Danh Muc San Pham
    And Scroll to Laptop – May Vi Tinh at Right category
    And Click to Laptop – May Vi Tinh at Right category
    And Click to Hang moi
    And Click to the first Laptop May Vi Tinh product
    Then Verify the product name, product price of first product should be displayed

  Scenario: Verify product name and product price of thuong hieu Samsung in Dien Thoai - May Tinh Bang
    Given Open TIKI application successfully
    When Click to Danh Muc San Pham
    And Click to Điện thoại – Máy tính bảng at Right category
    And Click to the Lọc button
    And Scroll to Thương hiệu
    And Select Samsung
    And Click to Áp Dụng button
    And Click to the first Dien Thoai May Tinh Bang product
    Then Verify the product name, product price of first product should be displayed
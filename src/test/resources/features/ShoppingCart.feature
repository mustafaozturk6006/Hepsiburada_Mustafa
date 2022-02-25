@wip
Feature: Adding products to the shopping cart

    Scenario: Verify that user should be able to search and add item to the shopping cart after login
      Given the user is on the home page
      When  click -Giriş Yap- option from -Giriş Yap- dropdown
      And   enter email and click -Giriş Yap- button
      And   enter password and click -Giriş Yap- button
      And   verify that user logged in successfully
      And   enter the item "Iphone 13 128 GB" into search box and click -Ara- button
      And   click the item
      And   click -Sepete Ekle- from the first Seller
      And   click -Sepet Ekte- from -Diğer Satıcılar- Section
      Then  Verify that item added into the shopping cart successfully

    Scenario: Verify that user should be able to search and add item to the shopping cart without login
      Given the user is on the home page
      When  enter the item "samsung galaxy note 20 ultra" into search box and click -Ara- button
      And   click the item
      And   click -Sepete Ekle- from the first Seller
      And   click -Sepet Ekte- from -Diğer Satıcılar- Section
      Then  Verify that item added into the shopping cart successfully



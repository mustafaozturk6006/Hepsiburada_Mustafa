Feature: User Login

  Scenario: Verify that user login with valid credential.
    Given the user is on the home page
    When  click -Giriş Yap- option from -Giriş Yap- dropdown
    And   enter email and click -Giriş Yap- button
    And   enter password and click -Giriş Yap- button
    Then  verify that user logged in successfully

  Scenario: Verify that user cannot login with a valid username and an invalid password.
    Given the user is on the home page
    When  click -Giriş Yap- option from -Giriş Yap- dropdown
    And   enter email and click -Giriş Yap- button
    And   enter invalid password and click -Giriş Yap- button
    Then  verify that warning message displayed

  Scenario: Verify that user cannot login with a invalid username and an valid password.
    Given the user is on the home page
    When  click -Giriş Yap- option from -Giriş Yap- dropdown
    And   enter invalid email and click -Giriş Yap- button
    Then  verify that warning message displayed

  Scenario: Verify that user cannot login with a blank username
    Given the user is on the home page
    When  click -Giriş Yap- option from -Giriş Yap- dropdown
    And   leave blank username section and click -Giriş Yap- button
    Then  verify that warning message displayed

  Scenario: Verify that user cannot login with a blank username
    Given the user is on the home page
    When  click -Giriş Yap- option from -Giriş Yap- dropdown
    And   leave blank username section and click -Giriş Yap- button
    Then  verify that warning message displayed

  Scenario: Verify that ‘Enter’ key of the keyboard is working correctly on the login page.
    Given the user is on the home page
    When  click -Giriş Yap- option from -Giriş Yap- dropdown
    And   enter email and press ‘Enter’ key of the keyboard
    And   enter password and press ‘Enter’ key of the keyboard
    Then  verify that user logged in successfully

  Scenario: Verify that user is able to login with a new password only after password has been changed
    Given the user is on the home page
    When  click -Giriş Yap- option from -Giriş Yap- dropdown
    And   enter email and click -Giriş Yap- button
    And   enter password and click -Giriş Yap- button
    And   click -Kullanıcı Bilgilerim- option from -Hesabım- dropdown
    And   click -Şifre Değişikliği- Tab and enter current and new password
    And   click -Güncelle- button
    And   click initials right top on the screen and click -Çıkış Yap-
    And   click -Giriş Yap- option from -Giriş Yap- dropdown
    And   enter email and click -Giriş Yap- button
    And   enter password and click -Giriş Yap- button
    Then  verify that user logged in successfully





Feature: Authenticate - Login

  Background:
    Given Click on go to login page button

  @SmokeTest @Login
  Scenario: Verify user can login successfully
    When Input the username as "luan0907"
    And Input the password as "Luan@0907"
    And Click on login submit button
    Then Verify success toast display message like "Đăng nhập thành công!"

  @SmokeTest @Login
  Scenario: Verify admin can login successfully
    When Input the username as "luan123"
    And Input the password as "Luan@0907"
    And Click on login submit button
    Then Verify success toast display message like "Đăng nhập thành công!"
    And Verify admin icon is displayed

  @FunctionalTest @Login
  Scenario: Verify user cannot login with invalid username
    When Input the username as "invalid"
    And Input the password as "Luan@0907"
    And Click on login submit button
    Then Verify success toast display message like "Tên đăng nhập hoặc mật khẩu không đúng."

  @FunctionalTest @Login
  Scenario: Verify user cannot login with invalid password
    When Input the username as "luan123"
    And Input the password as "invalid"
    And Click on login submit button
    Then Verify success toast display message like "Tên đăng nhập hoặc mật khẩu không đúng."
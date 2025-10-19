Feature: Authenticate - Register

  Background:
    Given Click on go to login page button
    And Click on go to register page button

  @SmokeTest @Register
  Scenario: Verify user can register successfully
    When Input the register username as "luanle123"
    And Input the register password as "Luan@1234"
    And Input the rewrite password as "Luan@1234"
    And Input the email as "levanluan@gmail.com"
    And Input the fullname as "Luan"
    And Select gender as "Nam"
    And Input the birthdate as "07/10/2002"
    And Input the phone number as "0932123124"
    And Verify success toast display message like "Register successfully!"

  @FunctionalTest @Register
  Scenario: Verify user can register successfully with only required field
    When Input the register username as "luanle123"
    And Input the register password as "Luan@1234"
    And Input the rewrite password as "Luan@1234"
    And Input the email as "levanluan@gmail.com"
    And Input the fullname as "Luan"
    And Input the phone number as "0932123124"
    And Verify success toast display message like "Register successfully!"

  @FunctionalTest @Register
  Scenario: Verify user cannot register with mismatch in password and rewrite password
    When Input the register username as "luanle123"
    And Input the register password as "Luan@1234"
    And Input the rewrite password as "Luan@1235"
    And Input the email as "levanluan@gmail.com"
    And Input the fullname as "Luan"
    And Input the phone number as "0932123124"
    And Verify success toast display message like "Register successfully!"

  @FunctionalTest @Register
  Scenario: Verify user cannot register with an existing username
    When Input the register username as "luan123"
    And Input the register password as "Luan@1234"
    And Input the rewrite password as "Luan@1235"
    And Input the email as "levanluan@gmail.com"
    And Input the fullname as "Luan"
    And Input the phone number as "0932123124"
    And Verify success toast display message like "Register successfully!"

  @FunctionalTest @Register
  Scenario: Verify user cannot register with an existing email
    When Input the register username as "luanle123"
    And Input the register password as "Luan@1234"
    And Input the rewrite password as "Luan@1235"
    And Input the email as "luanle.31211027594@st.ueh.edu.vn"
    And Input the fullname as "Luan"
    And Input the phone number as "0932123124"
    And Verify success toast display message like "Register successfully!"

  @FunctionalTest @Register
  Scenario: Verify user cannot register with a password that does not meet the requirements
    When Input the register username as "luanle123"
    And Input the register password as "1234"
    And Input the rewrite password as "Luan@1235"
    And Input the email as "levanluan@gmail.com"
    And Input the fullname as "Luan"
    And Input the phone number as "0932123124"
    And Verify success toast display message like "Register successfully!"


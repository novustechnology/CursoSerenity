@Login
Feature: Login

  Scenario Outline: Uso de las variables de sesión
    Given accedo a la "<url>" de SwagLabs con usuario y password
    Examples:
      | url                        |
      | https://www.saucedemo.com/ |
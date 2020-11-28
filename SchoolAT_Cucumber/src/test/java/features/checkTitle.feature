Feature: Проверка возможностей
  Check Title
  @googleTest
  Scenario: Check Title
    Given go to website 'https://www.google.ru/'
    Then check title 'Google'
    Then stop work
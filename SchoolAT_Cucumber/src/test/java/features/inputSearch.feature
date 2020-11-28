Feature: Check search
  @googleTest
  Scenario: Input word in search field
    Given go to website 'https://www.google.ru/'
    Then search 'Гладиолус'
    Then search on page 'Шпажник — Википедия'
    Then stop work
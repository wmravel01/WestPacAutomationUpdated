Feature: Kiwisaver Projected Balance Calculations based on different Age

  Scenario: Navigate to Kiwisaver Retirement Calculator
    Given User navigates to URL
    And mousehover to Kiwisaver
    And Click on link Kiwisaver_Calculators
    And Click on link Get_here_to_get_started
    And verify title "KiwiSaver Retirement Calculator"

  Scenario: Calculate for age as 30
    Given User enter current age "30"
    And select Employment Status "Employed"
    And enter salary per year "82000"
    And select KiwiSaver member contribution 4percent
    And select PIR "17.5%"
    And select risk profile "High"
    When user click on  button Projection
    Then verify balance estimated amount at age of Sixtyfive

  # And validate information Icons displaying
  Scenario: Calculate for age as 45
    Given User enter current age "45"
    And select Employment Status "Self-employed"
    And select PIR "10.5%"
    And enter current KiwiSaver balance "100000"
    And enter voluntary contribution "90"
    And select frequency "Fortnightly"
    And select risk profile "Meduim"
    And enter saving goals requirement "290000"
    Then verify balance estimated amount at age of Sixtyfive

  Scenario: Calculate for age as 55
    Given User enter current age "55"
    And select Employment Status "Not employed"
    And select PIR "10.5%"
    And enter current KiwiSaver balance "140000"
    And enter voluntary contribution "10"
    And select frequency "Annually"
    And select risk profile "Meduim"
    And enter saving goals requirement "200000"
    Then verify balance estimated amount at age of Sixtyfive

  Scenario: Quit Browser
    Given User quit the browser

Feature: KiwiSaver_Calculator_Information_IconTest

  Scenario: Navigate to Kiwisaver Retirement Calculator
    Given User navigates to URL
    And mousehover to Kiwisaver
    And Click on link Kiwisaver_Calculators
    And Click on link Get_here_to_get_started
    And verify title "KiwiSaver Retirement Calculator"

  Scenario: Calculate for age as 25
    Given User enter current age "25"
    And select Employment Status "Employed"
    And enter salary per year "82000"
    And select KiwiSaver member contribution 4percent
    And select PIR "17.5%"
    And select risk profile "High"
    When user click on  button Projection
    Then verify balance estimated amount at age of Sixtyfive and Information Icons
    

  Scenario: Quit Browser
    Given User quit the browser

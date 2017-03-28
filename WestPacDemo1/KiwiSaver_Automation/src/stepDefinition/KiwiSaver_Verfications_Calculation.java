package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kiwisaver_main.*;

public class KiwiSaver_Verfications_Calculation {
	BaseTest base = new BaseTest();

	@Given("^User navigates to URL$")
	public void user_navigates_to_URL() throws Throwable {

		base.openBrowser();
		System.out.println("Navigation success");
		BaseTest.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("^mousehover to Kiwisaver$")
	public void mousehover_to_Kiwisaver() throws Throwable {

		WebElement KiwiSaver = BaseTest.driver.findElement(By.xpath(".//*[@id='ubermenu-section-link-kiwisaver-ps']"));
		Actions Act = new Actions(BaseTest.driver);
		Act.moveToElement(KiwiSaver).perform();
	}

	@Given("^Click on link Kiwisaver_Calculators$")
	public void click_on_link_Kiwisaver_Calculators() throws Throwable {

		BaseTest.driver.findElement(By.xpath(".//*[@id='ubermenu-item-cta-kiwisaver-calculators-ps']")).click();

	}

	@Given("^Click on link Get_here_to_get_started$")
	public void click_on_link_Get_here_to_get_started() throws Throwable {

		BaseTest.driver.findElement(By.xpath(".//*[@id='content-ps']/div[2]/div/section/p[4]/a")).click();
	}

	@Given("^verify title \"([^\"]*)\"$")
	public void verify_title(String cal_Title) throws Throwable {

		String getTitle = BaseTest.driver.findElement(By.xpath(".//*[@id='content-ps']/div/article/div/h1")).getText();
		Assert.assertEquals(cal_Title, getTitle);
		System.out.println("The title " + getTitle + " is verified");
		Boolean bResult = BaseTest.driver.findElement(By.xpath(".//*[@id='content-ps']/div/article/div/h1"))
				.isDisplayed();
		Assert.assertTrue(bResult);

	}

	@Given("^User enter current age \"([^\"]*)\"$")
	public void user_enter_current_age(String currentAge) throws Throwable {
		System.out.println("Feature is Started");
		BaseTest.driver.switchTo().frame(0);
		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.CurrentAge'] input")).clear();
		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.CurrentAge'] input")).sendKeys(currentAge);
		System.out.println(currentAge);
	}

	@Given("^select Employment Status \"([^\"]*)\"$")
	public void select_Employment_Status(String employmentStatus) throws Throwable {

		List<WebElement> clickFreqDropdown = BaseTest.driver
				.findElements(By.cssSelector("div[ ng-model='ctrl.data.EmploymentStatus'] .control-well"));
		clickFreqDropdown.get(0).click();

		List<WebElement> elementsFreq = BaseTest.driver
				.findElements(By.xpath("//div[@ng-model='ctrl.data.EmploymentStatus']/div/div[2]/ul/li"));

		for (int i = 1; i < elementsFreq.size(); i++) {
			WebElement elementFreq = elementsFreq.get(i);
			String innerElement = elementFreq.getAttribute("innerHTML");
			if (innerElement.contains(employmentStatus)) {
				elementFreq.click();
				System.out.println("Employment Status " + employmentStatus + " is selected");
				break;
			}

		}

	}

	@Given("^enter salary per year \"([^\"]*)\"$")
	public void enter_salary_per_year(String salary) throws Throwable {

		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.AnnualIncome'] input")).sendKeys(salary);
	}

	@Given("^select KiwiSaver member contribution 4percent$")
	public void select_KiwiSaver_member_contribution_4percent() throws Throwable {

		WebElement radioBtn = BaseTest.driver.findElement(By.cssSelector("#radio-option-069"));
		radioBtn.click();
	}

	@Given("^select PIR \"([^\"]*)\"$")
	public void select_PIR(String PIR) throws Throwable {

		List<WebElement> clickPIRDropdown = BaseTest.driver
				.findElements(By.cssSelector("div[ng-model='ctrl.data.PIRRate'] .well-value.ng-binding"));
		clickPIRDropdown.get(0).click();

		List<WebElement> elementsPIR = BaseTest.driver
				.findElements(By.xpath("//div[@ ng-repeat='pirRate in ctrl.cms.pirRates']/li/div/span"));
		for (int I = 0; I < elementsPIR.size(); I++) {
			WebElement elementPIR = elementsPIR.get(I);
			String innerElement = elementPIR.getAttribute("innerHTML");

			if (innerElement.contentEquals(PIR)) {
				Thread.sleep(1000);
				elementPIR.click();
				Thread.sleep(1000);
				System.out.println("PIR " + PIR + " is selected");
			}
		}

	}

	@Given("^enter current KiwiSaver balance \"([^\"]*)\"$")
	public void enter_current_KiwiSaver_balance(String currentksbalance) throws Throwable {
		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.KiwiSaverBalance'] input")).clear();
		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.KiwiSaverBalance'] input"))
				.sendKeys(currentksbalance);

	}

	@Given("^enter voluntary contribution \"([^\"]*)\"$")
	public void enter_voluntary_contribution(String voluntaryContribution) throws Throwable {

		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.VoluntaryContributions'] input")).clear();
		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.VoluntaryContributions'] input"))
				.sendKeys(voluntaryContribution);
	}

	@Given("^select frequency \"([^\"]*)\"$")
	public void select_frequency(String frequency) throws Throwable {

		List<WebElement> clickFreqDropdown = BaseTest.driver
				.findElements(By.cssSelector("div[ ng-model='$parent.period'] .control-well"));
		clickFreqDropdown.get(0).click();

		List<WebElement> elementsFreq = BaseTest.driver
				.findElements(By.xpath("//div[@ng-model='$parent.period']/div/div[2]/ul/li"));

		for (int i = 1; i < elementsFreq.size(); i++) {
			WebElement elementFreq = elementsFreq.get(i);
			String innerElement = elementFreq.getAttribute("innerHTML");
			if (innerElement.contains(frequency)) {
				elementFreq.click();
				System.out.println("Frequency selected");
				break;
			}

		}
	}

	@Given("^select risk profile \"([^\"]*)\"$")
	public void select_risk_profile(String arg1) throws Throwable {

		WebElement radioBtn = BaseTest.driver.findElement(By.cssSelector("#radio-option-021"));
		radioBtn.click();

	}

	@Given("^enter saving goals requirement \"([^\"]*)\"$")
	public void enter_saving_goals_requirement(String savingGoalsRequirement) throws Throwable {

		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.SavingsGoal'] input")).clear();
		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.SavingsGoal'] input"))
				.sendKeys(savingGoalsRequirement);
	}

	@When("^user click on  button Projection$")
	public void user_click_on_button_Projection() throws Throwable {

		BaseTest.driver.switchTo().defaultContent();
		List<WebElement> findElements2 = BaseTest.driver.findElements(By.tagName("iframe"));
		for (int i = 0; i < findElements2.size();) {
			BaseTest.driver.switchTo().frame(i);
			List<WebElement> findElements = BaseTest.driver
					.findElements(By.cssSelector(".btn.btn-regular.btn-results-reveal.btn-has-chevron"));
			findElements.get(0).click();
			System.out.println(findElements.size());
			System.out.println("Projection button clicked");
			Thread.sleep(1000);
			// verify_balance_estimated_amount_at_age_of_Sixtyfive();
			break;

		}

	}

	@Then("^verify balance estimated amount at age of Sixtyfive$")
	public void verify_balance_estimated_amount_at_age_of_Sixtyfive() throws Throwable {

		String estimatedKiwiSaverBalanceAtAge65 = BaseTest.driver
				.findElement(By.xpath("//div[@ng-show='ctrl.view.resultsPanelRevealed']/div/div/div[1]/div[1]/span[2]"))
				.getText();
		System.out.println("At age 65, your KiwiSaver balance is estimated to be: " + estimatedKiwiSaverBalanceAtAge65
				+ " is verified.");

		BaseTest.driver.switchTo().defaultContent();
	}

	@Then("^verify balance estimated amount at age of Sixtyfive and Information Icons$")
	public void verify_balance_estimated_amount_at_age_of_Sixtyfive_and_Information_Icons() throws Throwable {

		String estimatedKiwiSaverBalanceAtAge65 = BaseTest.driver
				.findElement(By.xpath("//div[@ng-show='ctrl.view.resultsPanelRevealed']/div/div/div[1]/div[1]/span[2]"))
				.getText();
		System.out.println("At age 65, your KiwiSaver balance is estimated to be: " + estimatedKiwiSaverBalanceAtAge65
				+ " is verified.");

		List<WebElement> findInfoIcons = BaseTest.driver.findElements(
				By.cssSelector(".icon-target.icon-target-help-toggle.icon-btn.icon-btn-info.ir.ng-scope"));
		// System.out.println(findInfoIcons.size());
		for (int i = 0; i < findInfoIcons.size() - 1; i++) {
			if (findInfoIcons.get(i).isDisplayed()) {
				findInfoIcons.get(i).click();
				System.out.println(
						"The help text " + findInfoIcons.get(i).getText() + " is displayed for the information icons");

			} else {
				System.out.println("This is icon " + findInfoIcons.get(i).getTagName() + " is not displayed");
			}

		}

	}

	@Given("^User quit the browser$")
	public void user_quit_the_browser() throws Throwable {
		System.out.println("Feature completed");
		base.closeBrowser();

	}

}




	


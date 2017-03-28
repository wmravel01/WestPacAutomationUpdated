package kiwisaver_test;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import kiwisaver_main.BaseTest;

public class workouts1 extends BaseTest {
	public static BaseTest base = new BaseTest();

	public static void main(String[] args) throws Throwable {

		runBaseCase();

	}

	public static void runBaseCase() throws Throwable {

		base.openBrowser();
		mousehover_to_Kiwisaver();
		click_on_link_Kiwisaver_Calculators();
		click_on_link_Kiwisaver_Calculators();
		click_on_link_Get_here_to_get_started();
		verify_title();

		BaseTest.driver.switchTo().frame(0);

		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.CurrentAge'] input")).sendKeys("30");

		List<WebElement> selectEmpStatusDd = BaseTest.driver.findElements(By.cssSelector(".control-well"));

		selectEmpStatusDd.get(1).click();
		List<WebElement> findDropDownElement = BaseTest.driver.findElements(By.cssSelector(".dropdown"));
		List<WebElement> findEmpListValue = findDropDownElement.get(0).findElements(By.tagName("li"));
		findEmpListValue.get(1).click();

		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.AnnualIncome'] input")).sendKeys("900000");
		WebElement radioBtn = BaseTest.driver.findElement(By.cssSelector("#radio-option-069"));
		radioBtn.click();

		List<WebElement> clickPIRDropdown = BaseTest.driver
				.findElements(By.cssSelector("div[ng-model='ctrl.data.PIRRate'] .well-value.ng-binding"));
		clickPIRDropdown.get(0).click();

		List<WebElement> elementsPIR = driver
				.findElements(By.xpath("//div[@ ng-repeat='pirRate in ctrl.cms.pirRates']/li/div/span"));
		for (int I = 0; I < elementsPIR.size(); I++) {
			WebElement elementPIR = elementsPIR.get(I);
			String innerElement = elementPIR.getAttribute("innerHTML");

			if (innerElement.contentEquals("10.5%")) {
				elementPIR.click();
				System.out.println("PIR selected");
			}
		}

		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.KiwiSaverBalance'] input")).sendKeys("400000");
		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.VoluntaryContributions'] input"))
				.sendKeys("100");

		List<WebElement> clickFreqDropdown = BaseTest.driver
				.findElements(By.cssSelector("div[ ng-model='$parent.period'] .control-well"));
		clickFreqDropdown.get(0).click();

		List<WebElement> elementsFreq = driver
				.findElements(By.xpath("//div[@ng-model='$parent.period']/div/div[2]/ul/li"));
		System.out.println(elementsFreq.size());
		for (int i = 1; i < elementsFreq.size(); i++) {
			WebElement elementFreq = elementsFreq.get(i);
			String innerElement = elementFreq.getAttribute("innerHTML");

			System.out.println(innerElement);
			if (innerElement.contains("Annually")) {
				elementFreq.click();
				System.out.println("Frequency selected");
				break;
			}

		}

		WebElement radioBtnRiskProfile = BaseTest.driver.findElement(By.cssSelector("#radio-option-021"));
		radioBtnRiskProfile.click();
		BaseTest.driver.findElement(By.cssSelector("div[model='ctrl.data.SavingsGoal'] input")).sendKeys("1500000");

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

			System.out.println("completed");
			// base.closeBrowser();
			break;

		}

		//BaseTest.driver.switchTo().frame(0);

		String estimatedKiwiSaverBalanceAtAge65 = BaseTest.driver
				.findElement(By.cssSelector(".result-value.result-currency.ng-binding")).getText();
		System.out.println("At age 65, your KiwiSaver balance is estimated to be: " + estimatedKiwiSaverBalanceAtAge65
				+ " is verified.");
		//BaseTest.driver.switchTo().defaultContent();

		if (BaseTest.driver.findElement(By.xpath("//div[@help-id='Results']/button/i")).isDisplayed()) {
			System.out.println("The total amount help informaiton icon is present");
			BaseTest.driver.findElement(By.xpath("//div[@help-id='Results']/button/i")).click();
			if (BaseTest.driver
					.findElement(By.cssSelector(".results-heading div[class='field-message message-info ng-binding']>p"))
					.isDisplayed()) {
				System.out.println("The help text of Total Amount is available");
			} else {
				System.out.println("The help text of Total Amount is available");
			}
		}

		else {
			System.out.println("The total amount help information icon is not present");
		}
		
		// BaseTest.driver.switchTo().defaultContent();
		List<WebElement> findInfoIcons = BaseTest.driver.findElements(
				By.cssSelector(".icon-target.icon-target-help-toggle.icon-btn.icon-btn-info.ir.ng-scope"));
		System.out.println(findInfoIcons.size());
		for (int i = 0; i < findInfoIcons.size()-1; i++) {
			if (findInfoIcons.get(i).isDisplayed()){
				findInfoIcons.get(i).click();
				System.out.println("The help text "+findInfoIcons.get(i).getTagName()+ " is displayed for the information icon");
/*				int j=i+1;
				@SuppressWarnings("unchecked")
				List<WebElement> findHelpTexts= (List<WebElement>) BaseTest.driver.findElement(
						By.cssSelector(".field-message.message-info.ng-binding"));
				if (findHelpTexts.get(i).isDisplayed())
				{
					System.out.println("The help text "+findHelpTexts.get(i).getText()+ " is displayed for the information icon");
				}
				
				if(!findHelpTexts.get(i).isDisplayed())
				{
					System.out.println("The help text is not displayed for the information icon");
				}*/
				
			}
			else
			{
				System.out.println("This is icon "+findInfoIcons.get(i).getTagName()+ " is not displayed");
			}
				
			System.out.println("Now the i count is "+i);


			

		}
		System.out.println("completed");
		// base.closeBrowser();

	}

	public static void mousehover_to_Kiwisaver() throws Throwable {

		WebElement KiwiSaver = BaseTest.driver.findElement(By.xpath(".//*[@id='ubermenu-section-link-kiwisaver-ps']"));
		Actions Act = new Actions(BaseTest.driver);
		Act.moveToElement(KiwiSaver).perform();
	}

	public static void click_on_link_Kiwisaver_Calculators() throws Throwable {

		BaseTest.driver.findElement(By.xpath(".//*[@id='ubermenu-item-cta-kiwisaver-calculators-ps']")).click();

	}

	public static void click_on_link_Get_here_to_get_started() throws Throwable {

		BaseTest.driver.findElement(By.xpath(".//*[@id='content-ps']/div[2]/div/section/p[4]/a")).click();
	}

	public static void verify_title() throws Throwable {

		String getTitle = BaseTest.driver.findElement(By.xpath(".//*[@id='content-ps']/div/article/div/h1")).getText();
		Assert.assertEquals("KiwiSaver Retirement Calculator", getTitle);
		System.out.println("The title " + getTitle + " is verified");
		Boolean bResult = BaseTest.driver.findElement(By.xpath(".//*[@id='content-ps']/div/article/div/h1"))
				.isDisplayed();
		Assert.assertTrue(bResult);
	}
	
	public static void verify_HelpIcons() throws Throwable{
		
		//.icon-target.icon-target-help-toggle.icon-btn.icon-btn-info.ir.ng-scope
	}

}

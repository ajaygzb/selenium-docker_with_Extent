package helper.methods;

import org.openqa.selenium.WebDriver;

import com.tests.BaseTest;

public class JavascriptHandlingMethods implements IBase {
	protected WebDriver driver = new BaseTest().getDriver();
	/**Method to handle alert
	 * @param decision : String : Accept or dismiss alert
	 */
	public void handleAlert(String decision)
	{
		if(decision.equals("accept"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
	}
}

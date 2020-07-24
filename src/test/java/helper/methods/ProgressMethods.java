package helper.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProgressMethods extends SelectElementByType implements IBase
{
	/** Method to wait 
	 * @param time : String : Time to wait
	 * @param method : String : wait by sleep or implicit method 
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 */
	public void wait(String time) throws NumberFormatException, InterruptedException
	{
		//sleep method takes parameter in milliseconds
		Thread.sleep(Integer.parseInt(time)*1000);
	}
	
	/**Method to Explicitly wait for element to be displayed
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
	 * @param accessName : String : Locator value
	 * @param duration : String : Time to wait for element to be displayed
	 */
	public void waitForElementToDisplay(String accessType,String accessName,String duration)
	{
		By byEle = getelementbytype(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(driver,Integer.parseInt(duration)*1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byEle));
	}
		
	/** Method to Explicitly wait for element to be enabled=click
	 * @param accessType : String : Locator type (id, name, class, xpath, css)
	 * @param accessName : String : Locator value
	 * @param duration : String : Time to wait for element to be clickable
	 */
	public void waitForElementToClick(String accessType,String accessName,String duration)
	{
		By byEle = getelementbytype(accessType, accessName);
		WebDriverWait wait = (new WebDriverWait(driver,Integer.parseInt(duration)*1000));
		wait.until(ExpectedConditions.elementToBeClickable(byEle));
	}
	
}

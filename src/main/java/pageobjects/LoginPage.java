package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibrary.ExcelUtilities;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginbutton;

	public void loginUser() throws IOException {
	    String uid=ExcelUtilities.readExcel(1, 1);
	    String pwd=ExcelUtilities.readExcel(2, 1);
		username.sendKeys(uid);
		password.sendKeys(pwd);
		loginbutton.click();
	}
}

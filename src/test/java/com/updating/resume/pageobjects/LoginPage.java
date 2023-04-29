package com.updating.resume.pageobjects;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.updating.resume.util.CommonUtil;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id = "login_Layer")
	private WebElement loginlink;
	
	@FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
	private WebElement uname;
	
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement pswd;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement submit;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void windowsHandle() {
		String parent_window = driver.getWindowHandle();

		Set<String> child_win = driver.getWindowHandles();
		ArrayList<String> arr = new ArrayList<String>(child_win);
		for (String ch : arr) {
			driver.switchTo().window(ch);
			System.out.println(driver.getTitle());
		}
	}
	
	public void clickNoukariLogin() {
		loginlink.click();
		
	}
	public void enterUserName(String username) {
		this.uname.sendKeys(username);
	}
	public void enterPassword(String password) {
		this.pswd.sendKeys(password);
		
	}
	public HomePage clickSubmitButton() {
		submit.click();
		
		return PageFactory.initElements(driver, HomePage.class);
	}

}

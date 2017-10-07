package com.gittigidiyor.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GittiGidiyorLoginPage {
	private WebDriver driver ;
	private WebDriverWait wait ;
	
	private static final String USER_NAME_ID ="L-UserNameField";
	private static final String USER_PASSWORD_ID ="L-PasswordField";
	private static final String LOGIN_BUTTON_ID ="gg-login-enter";
	
	
	public GittiGidiyorLoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver,30);
	}
	public void sendUserName(String text) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(USER_NAME_ID))));
		driver.findElement(By.id(USER_NAME_ID)).clear();
		driver.findElement(By.id(USER_NAME_ID)).sendKeys(text);
	}
	public void sendUserPassword(String text) {
		driver.findElement(By.id(USER_PASSWORD_ID)).clear();
		driver.findElement(By.id(USER_PASSWORD_ID)).sendKeys(text);
	}
	public void clickLoginButton() {
		driver.findElement(By.id(LOGIN_BUTTON_ID)).click();
	}
	
	public boolean isValidLogin() {
		String title = driver.getTitle();
		
		if (!title.equals("GittiGidiyor'a Hoşgeldiniz!")) {
			return false;
		}
		return true;
	}
}

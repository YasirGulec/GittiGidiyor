package com.gittigidiyor.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GittiGidiyorHomePage {
	private WebDriver driver ;
	private WebDriverWait wait ;
	private static final String URL = "https://www.gittigidiyor.com/";
	private static final String SINGIN_BUTTON_ID ="H-Login";
	
	
	public GittiGidiyorHomePage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(this.driver,30); 
		this.driver.get(URL);
	}
	public void clickLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(SINGIN_BUTTON_ID))));
		driver.findElement(By.id(SINGIN_BUTTON_ID)).click();
	}
	
	
	
	
}

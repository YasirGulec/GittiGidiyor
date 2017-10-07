package com.gittigidiyor.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GittiGidiyorMainPage {
	private WebDriver driver ;
	private WebDriverWait wait ;
	private static final String SEARCH_WORD_ID ="search_word";
	private static final String FIND_BUTTON_ID="header_find_button";
	private static final String PRODUCTS_XPATH="//li[@itemprop='itemListElement']//span[@itemprop='name']";
	
	public GittiGidiyorMainPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	public void sendSearcText(String text) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(SEARCH_WORD_ID))));
		driver.findElement(By.id(SEARCH_WORD_ID)).clear();
		driver.findElement(By.id(SEARCH_WORD_ID)).sendKeys(text);		
	}
	public void clickFindButton() {
		driver.findElement(By.id(FIND_BUTTON_ID)).click();
	}
	
	public boolean isValidSearch() {
		List<WebElement> webElements = driver.findElements(By.xpath(PRODUCTS_XPATH));
		for(WebElement element: webElements) {
			if (!element.getText().toUpperCase().contains("AS")) {
				return false;
			}
		}
		return true;
	}
}

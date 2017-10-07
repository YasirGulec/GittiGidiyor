package com.gittigidiyor.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.gittigidiyor.page.GittiGidiyorHomePage;
import com.gittigidiyor.page.GittiGidiyorLoginPage;
import com.gittigidiyor.page.GittiGidiyorMainPage;

public class GittiGidiyorTest {
	private static WebDriver driver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");
		driver = new ChromeDriver(o);
	}
	
	@Test
	public void searchText() {
		GittiGidiyorHomePage homePage = new GittiGidiyorHomePage(driver);
		homePage.clickLoginButton();
		
		GittiGidiyorLoginPage loginPage = new GittiGidiyorLoginPage(driver);
		loginPage.sendUserName("yasirodev");
		loginPage.sendUserPassword("123456ab");
		loginPage.clickLoginButton();
		
		Assert.assertTrue("Login Olunamadı", loginPage.isValidLogin());
		
		GittiGidiyorMainPage mainPage = new GittiGidiyorMainPage(driver);
		mainPage.sendSearcText("Asus Notebook");
		mainPage.clickFindButton();
		
		Assert.assertTrue("Arama hatalı", mainPage.isValidSearch());
	}
	
	@AfterClass
	public static void finish() {
		driver.close();
	}
}

package application.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import application.CatalogoHTTPController;

@RunWith(SpringRunner.class)
@WebMvcTest(CatalogoHTTPController.class)
public class CatalogoE2ESeleniumTest {
	private WebDriver driver;

	@Before
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void test_loadHomePage() {
		driver.get("/productos");
	}
}

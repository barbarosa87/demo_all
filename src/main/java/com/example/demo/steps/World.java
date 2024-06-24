package com.example.demo.steps;


import com.example.demo.configuration.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Component
@Getter
public class World {

	private WebDriver webDriver;

	@Autowired
	private Config config;

	public void createDriver(long timeout){

		WebDriver driver=null;
		if (config.getBrowser().equalsIgnoreCase("Firefox")){
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			if (config.isHeadless()){
				options.addArguments("--headless");
			}
			driver = WebDriverManager.firefoxdriver().capabilities(options).create();
		}else if (config.getBrowser().equalsIgnoreCase("Chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("--disable-gpu");
			if (config.isHeadless()){
				options.addArguments("--headless=new");
			}
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = WebDriverManager.chromedriver().capabilities(options).create();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		this.webDriver=driver;
	}


}

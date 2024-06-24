package com.example.demo.steps;


import com.example.demo.configuration.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Getter
public class World {

	private WebDriver webDriver;

	@Autowired
	private Config config;

	public void createDriver(long timeout){
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
		WebDriver driver=null;
		if (config.getBrowser().equalsIgnoreCase("Chromium")){
			 driver = WebDriverManager.chromiumdriver().capabilities(options).create();
		}else if (config.getBrowser().equalsIgnoreCase("Chrome")){
			driver = WebDriverManager.chromedriver().capabilities(options).create();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		this.webDriver=driver;
	}


}

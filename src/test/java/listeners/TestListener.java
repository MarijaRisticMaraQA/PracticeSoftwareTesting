package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class TestListener implements ITestListener {

	private static final Logger log = LogManager.getLogger(TestListener.class.getName());

	@Override
	public void onTestStart(ITestResult result) {

		log.info("STARTING TEST: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		log.info("TEST METHOD: " + result.getMethod().getMethodName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		log.error("TEST METHOD: " + result.getMethod().getMethodName() + " FAILED");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);
	}

//	private void takeScreenshot(WebDriver driver) {
//
//		Date date = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
//		String fileName = format.format(date);
//
//		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + fileName + ".png"));
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
}

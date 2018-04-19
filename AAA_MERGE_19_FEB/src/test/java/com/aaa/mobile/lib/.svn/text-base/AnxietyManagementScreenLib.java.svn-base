package com.aaa.mobile.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.AnxietyManagementScreenPage;
import com.aaa.mobile.page.MembershipInfoPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestContext;


import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

import java.io.File;

/**
 * Created by E002734 on 12/19/2017.
 */
public class AnxietyManagementScreenLib extends ActionEngineMobile {

	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}

	/**
	 *methodName : verifyDidYouKnow
	 *description: click  Did You Know
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void verifyDidYouKnow() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.didYouKnowLabel, "did you know text");
		getText(AnxietyManagementScreenPage.didYouKnowLabel, "did you know text");
	}

	/**
	 *methodName : estimatedTimeToArrive
	 *description: click  estimated time of arrival
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void estimatedTimeToArrive() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.promisedTimeOfArrival, "promised Time Of Arrival");
		getText(AnxietyManagementScreenPage.promisedTimeOfArrival, "promised Time Of Arrival");
	}

	/**
	 *methodName : didYouKnowUpdatesLabel
	 *description: get the text of notification
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void didYouKnowUpdatesLabel() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.didYouKnowUpdatesLabel, "did you know notifications");
		getText(AnxietyManagementScreenPage.didYouKnowUpdatesLabel, "did you know notifications");
		Thread.sleep(2000);
		getText(AnxietyManagementScreenPage.didYouKnowUpdatesLabel, "did you know notifications");
		Thread.sleep(2000);
		getText(AnxietyManagementScreenPage.didYouKnowUpdatesLabel, "did you know notifications");
	}

	/**
	 *methodName : callAAALabel
	 *description: get the text of callAAALabel
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void callAAALabel() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.callAAALabel, "call AAA label");
		getText(AnxietyManagementScreenPage.callAAALabel, "call AAA label");
	}

	/**
	 *methodName : getActiveRequestTitle
	 *description: get Active Request Title
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void getActiveRequestTitle() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.activeRequestTitle, "activeRequestTitle");
		getText(AnxietyManagementScreenPage.activeRequestTitle, "activeRequestTitle");
	}

	/**
	 *methodName : serviceSpinnerImage
	 *description: check whether service spinner image is present
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void serviceSpinnerImage() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.serviceTrackerSpinnerImage, "service tracker spinner");
		isVisibleOnly(AnxietyManagementScreenPage.serviceTrackerSpinnerImage, "service tracker spinner");
	}


	/**
	 *methodName : getActiveRequestNotification
	 *description: get the active Request Notification
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void getActiveRequestNotification() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.activeRequestNotification, "active Request Notification");
		getText(AnxietyManagementScreenPage.activeRequestNotification, "active Request Notification");
	}


	/**
	 *methodName : clickHistoryButton
	 *description: click History Button
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void clickHistoryButton() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.historyButton, "history Button");
		click(AnxietyManagementScreenPage.historyButton, "history Button");
	}

	/**
	 *methodName : clickReceivedLabel
	 *description: click Received Label
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void clickReceivedLabel() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.receivedLabel, "click received Label");
		click(AnxietyManagementScreenPage.receivedLabel, "click on received Label");
	}

	/**
	 *methodName : verifyPillBar
	 *description: verify PillBar is available
	 *param
	 * author E002734
	 * throws Throwable
	 */
	public void verifyPillBar() throws Throwable {
		waitForVisibilityOfElement(AnxietyManagementScreenPage.receivedLabel, "click received Label");
		getText(AnxietyManagementScreenPage.receivedLabel, "received Label");
		getText(AnxietyManagementScreenPage.enRouteLabel, "enRoute Label");
		getText(AnxietyManagementScreenPage.onLocationLabel, "on Location Label");
		getText(AnxietyManagementScreenPage.cancelRequestBtn, "on cancelRequest Label");
	}

	/*public void elementScreenShot(ITestContext testContext, By by, String imgName) throws IOException {

		if (testContext.getCurrentXmlTest().getParameter("platformName").equalsIgnoreCase("Android")) {
			//WebElement ele = appiumDriver.findElement(by);
			AndroidDriver AndroidDriver = (AndroidDriver) this.appiumDriver;
			WebElement ele = AndroidDriver.findElement(by);
			// Get entire page screenshot
			File screenshot = ((TakesScreenshot) AndroidDriver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = ImageIO.read(screenshot);

			// Get the location of element on the page
			org.openqa.selenium.Point point = ele.getLocation();

			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),
					eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);

			// Copy the element screenshot to disk
			File screenshotLocation = new File("ElemetScreenShots\\" + imgName);//+".png"
			FileUtils.copyFile(screenshot, screenshotLocation);
		} else if (testContext.getCurrentXmlTest().getParameter("platformName").equalsIgnoreCase("IOS")) {

			IOSDriver iosDriver = (IOSDriver) this.appiumDriver;
			LOG.info("locator value " + by);
			// Get entire page screenshot
			File screenshot = ((TakesScreenshot) iosDriver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = ImageIO.read(screenshot);

			// Get the location of element on the page
			Point point = ele.getLocatio();

			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);

			// Copy the element screenshot to disk

*//*			    File resultDir = new File("ElemetScreenShots_IOS");
				if (resultDir.exists() == false) {
					try {
						resultDir.mkdirs();
					} catch (Exception e) {
						LOG.info("Exception Encountered : " + e.getMessage());
					}
				}*//*

			File screenshotLocation = new File(imgName);//+".png"
			FileUtils.copyFile(screenshot, screenshotLocation);
		}
	}

	public String getColorCode(String Path) throws Throwable {

		File file = new File(Path);//"TestData//Savebutton.png"
		ImageInputStream is = ImageIO.createImageInputStream(file);
		waitForElementPresent(ImpactHomeScreenPage.menuImage, "Master button", 6);
		Iterator iter = ImageIO.getImageReaders(is);

		if (!iter.hasNext()) {
			LOG.info("Cannot load the specified file " + file);
			System.exit(1);
		}
		ImageReader imageReader = (ImageReader) iter.next();
		imageReader.setInput(is);

		BufferedImage image = imageReader.read(0);

		int height = image.getHeight();
		int width = image.getWidth();

		Map m = new HashMap();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int[] rgbArr = getRGBArr(rgb);
				// Filter out grays....
				if (!isGray(rgbArr)) {
					Integer counter = (Integer) m.get(rgb);
					if (counter == null)
						counter = 0;
					counter++;
					m.put(rgb, counter);
				}
			}
		}
		String colourHex = getMostCommonColour(m);
		LOG.info("hex code :" + colourHex);
		LOG.info(hex2Rgb("#23c3ef"));
		return colourHex;
	}

	public static boolean isGray(int[] rgbArr) {
		int rgDiff = rgbArr[0] - rgbArr[1];
		int rbDiff = rgbArr[0] - rgbArr[2];
		// Filter out black, white and grays...... (tolerance within 10 pixels)
		int tolerance = 10;
		if (rgDiff > tolerance || rgDiff < -tolerance)
			if (rbDiff > tolerance || rbDiff < -tolerance) {
				return false;
			}
		return true;
	}

	public static String getMostCommonColour(Map map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		Map.Entry me = (Map.Entry) list.get(list.size() - 1);
		int[] rgb = getRGBArr((Integer) me.getKey());
		return Integer.toHexString(rgb[0]) + " " + Integer.toHexString(rgb[1]) + " " + Integer.toHexString(rgb[2]);
	}

	public static int[] getRGBArr(int pixel) {
		int alpha = (pixel >> 24) & 0xff;
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
		return new int[]{red, green, blue};
	}

	public static Color hex2Rgb(String colorStr) {
		return new Color(Integer.valueOf(colorStr.substring(1, 3), 16), Integer.valueOf(colorStr.substring(3, 5), 16),
				Integer.valueOf(colorStr.substring(5, 7), 16));
	}
*/


}

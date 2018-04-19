package com.aaa.mobile.page;
import org.openqa.selenium.By;

public class ContactInformationPage {
	public static By contactInformationTitle;
	//public static By enterContactInformation;
	public static By sendRequest;
	public static By contactNumber;

	static {
			contactInformationTitle = By.id("com.aaa.android.discounts:id/ers_contact_info_title");
			//enterContactInformation = By.id("com.aaa.android.discounts:id/ers_phone_number");
			sendRequest = By.id("com.aaa.android.discounts:id/ers_btn_submit_request");
		    contactNumber=By.id("com.aaa.android.discounts:id/ers_phone_number");
	}
}

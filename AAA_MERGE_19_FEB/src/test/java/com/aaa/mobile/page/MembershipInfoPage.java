package com.aaa.mobile.page;
import org.openqa.selenium.By;

public class MembershipInfoPage {
    public static By membershipLabel;
    public static By membershipNumber;
    public static By membershipSequence;
    public static By skipButton;
	public static By continueButton;

	static {
        membershipLabel = By.xpath("//android.widget.TextView[contains(@text,'Membership')]");
        membershipNumber = By.id("com.aaa.android.discounts:id/et_membership_number_prompt");
        membershipSequence = By.id("com.aaa.android.discounts:id/sequence");
        skipButton = By.id("com.aaa.android.discounts:id/iv_skip");
		continueButton = By.id("com.aaa.android.discounts:id/b_continue");
	}
}
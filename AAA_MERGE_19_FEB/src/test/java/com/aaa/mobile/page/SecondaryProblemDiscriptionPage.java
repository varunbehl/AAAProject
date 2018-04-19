package com.aaa.mobile.page;

import org.openqa.selenium.By;

/**
 * Created by E002734 on 12/15/2017.
 */
public class SecondaryProblemDiscriptionPage {

	public static By problemDescriptionTitle;
	public static By possibleEngineProblemLabel;
	public static By vehicleAccidentLabel;
	public static By towDestinationTitle;
	public static By selectApprovedAutorepairFacilityLabel;
	public static By addNewAddressLabel;
	public static By homeLabel;
	public static By batteryTestPossibleReplacementLabel;
	public static By needJumpStartLabel;
	public static By vehicleStalledDrivingLabel;
	public static By onlyOneTireFlatLabel;
	public static By moreThanTireFlatLabel;
	public static By tireJustNeedsAirLabel;
	public static By keyLockedVehicleLabel;
	public static By keyLostorBrokenLabel;
	public static By ignitionTurningSteeringwheelLabel;
	public static By vehicleRunsGasolineLabel;
	public static By vehicleRunsDieselFuelLabel;
	public static By electricVehicleChargeLabel;
	public static By batteryProblem;

	static {
		problemDescriptionTitle = By.id("com.aaa.android.discounts:id/ers_situation_title");
		possibleEngineProblemLabel= By.xpath("//android.widget.TextView[@text='Possible engine problem']");
		vehicleAccidentLabel=By.xpath("//android.widget.TextView[contains(@text,'Vehicle was in an accident')]");
		towDestinationTitle=By.xpath("//android.widget.TextView[contains(@text,'Tow Destination')]");
		selectApprovedAutorepairFacilityLabel=By.xpath("//android.widget.TextView[contains(@text,'Select AAA Approved Auto Repair Facility')]");
		addNewAddressLabel=By.xpath("//android.widget.TextView[contains(@text,'Add New Address')]");
		homeLabel=By.xpath("//android.widget.TextView[contains(@text,'Home')]");
		batteryTestPossibleReplacementLabel=By.xpath("//android.widget.TextView[contains(@text,'Battery test and possible replacement')]");
		needJumpStartLabel=By.xpath("//android.widget.TextView[contains(@text,'Need a jump start')]");
		vehicleStalledDrivingLabel=By.xpath("//android.widget.TextView[contains(@text,'Vehicle stalled while driving')]");
		onlyOneTireFlatLabel=By.xpath("//android.widget.TextView[contains(@text,'Only one tire is flat')]");
		moreThanTireFlatLabel=By.xpath("//android.widget.TextView[contains(@text,'More than one tire is flat')]");
		tireJustNeedsAirLabel=By.xpath("//android.widget.TextView[contains(@text,'Tire just needs air')]");
		keyLockedVehicleLabel=By.xpath("//android.widget.TextView[contains(@text,'Key locked inside vehicle')]");
		keyLostorBrokenLabel=By.xpath("//android.widget.TextView[contains(@text,'Key is lost or broken')]");
		ignitionTurningSteeringwheelLabel=By.xpath("//android.widget.TextView[contains(@text,'Key won't turn in the ignition - even if I try turning the steering wheel')]");
		vehicleRunsGasolineLabel=By.xpath("//android.widget.TextView[contains(@text,'Vehicle runs on gasoline')]");
		vehicleRunsDieselFuelLabel=By.xpath("//android.widget.TextView[contains(@text,'Vehicle runs on diesel fuel')]");
		electricVehicleChargeLabel=By.xpath("//android.widget.TextView[contains(@text,'All-electric vehicle is out of charge')]");
		batteryProblem = By.xpath("//android.widget.TextView[@text='Battery']");


	}
}

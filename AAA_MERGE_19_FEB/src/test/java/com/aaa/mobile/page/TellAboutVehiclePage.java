package com.aaa.mobile.page;
import org.openqa.selenium.By;

public class TellAboutVehiclePage {
	   	public static By tellVehicleYear;
	    public static By tellVehicleMake;
	    public static By tellVehicleModel;
	    public static By tellVehicleColor;
	    public static By saveButtton;
	    public static By selectVehicleYear;
	    public static By vehicleDetailsList;
		public static By vehicleYearNumber;
		public static By vehicleMakeName;
		public static By vehicleModelName;
		public static By vehicleColor;
		public static By modifyVehicleYearNumber;
		public static By modifyVehicleMakeName;
		public static By modifyVehicleModelName;
		public static By modifyVehicleColor;
		
	static {
		    tellVehicleYear=By.xpath("//android.widget.TextView[contains(@text,'Year')]");
		    tellVehicleMake=By.xpath("//android.widget.TextView[contains(@text,'Make')]");
		    tellVehicleModel=By.xpath("//android.widget.TextView[contains(@text,'Model')]");
		    tellVehicleColor=By.xpath("//android.widget.TextView[contains(@text,'Color')]");
		    saveButtton=By.id("com.aaa.android.discounts:id/ers_save_vehicle_button");
		    selectVehicleYear=By.id("com.aaa.android.discounts:id/ers_vehicle_detail_item_root_layout");
		    vehicleDetailsList=By.id("com.aaa.android.discounts:id/ers_vehicle_details_list");
		    vehicleYearNumber = By.xpath("(//android.widget.TextView)[3]");
			vehicleMakeName = By.xpath("(//android.widget.TextView)[3]");
			vehicleModelName = By.xpath("(//android.widget.TextView)[3]");
			vehicleColor = By.xpath("(//android.widget.TextView)[3]");
		    modifyVehicleYearNumber = By.xpath("(//android.widget.TextView)[4]");
		    modifyVehicleMakeName = By.xpath("(//android.widget.TextView)[4]");
		    modifyVehicleModelName = By.xpath("(//android.widget.TextView)[4]");
		    modifyVehicleColor = By.xpath("(//android.widget.TextView)[4]");
	}
}




	




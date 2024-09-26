package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import page.Vehicle_Inward;

public class Vehicle_Inward_Test extends BaseTest {

   Vehicle_Inward vehicleInwardPage;

    @BeforeTest
    public void setUpPage() {
        vehicleInwardPage = new Vehicle_Inward(driver);
    }

    @Test(priority = 2, enabled = true)
    public void testVehicleInward() {
        vehicleInwardPage.vehicle_inward();
    }
}
